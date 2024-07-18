/*Giải thích một số điểm quan trọng:

Chúng ta sử dụng @Transactional cho các phương thức thay đổi dữ liệu để đảm bảo tính nhất quán của dữ liệu.
Trong createBooking và updateBooking, chúng ta kiểm tra xem có đủ ghế trống không trước khi tạo hoặc cập nhật đặt chỗ.
Phương thức isSeatsAvailable kiểm tra số ghế còn trống. Chúng ta cần thêm một phương thức tùy chỉnh countBookedSeatsByShowtime trong BookingRepository.
        Trong updateBooking, chúng ta tính toán sự chênh lệch số ghế để kiểm tra xem có đủ ghế trống không.
Phương thức convertToDTO chuyển đổi từ Entity sang DTO. Chúng ta giả định rằng số lượng vé được tính bằng cách chia tổng số tiền cho giá mỗi vé.
        Trong cancelBooking, bạn có thể muốn thêm một số logic kinh doanh, ví dụ như kiểm tra xem đặt chỗ có đủ điều kiện để hủy hay không dựa trên thời gian chiếu.*/

package com.example.gen_code_ai.service;

import com.example.gen_code_ai.dto.BookingRequest;
import com.example.gen_code_ai.dto.BookingResponse;
import com.example.gen_code_ai.entity.BookingEntity;
import com.example.gen_code_ai.entity.CustomerEntity;
import com.example.gen_code_ai.entity.ShowtimeEntity;
import com.example.gen_code_ai.exception.*;
import com.example.gen_code_ai.repository.BookingRepository;
import com.example.gen_code_ai.repository.CustomerRepository;
import com.example.gen_code_ai.repository.MovieRepository;
import com.example.gen_code_ai.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MovieRepository movieRepository;

    public List<BookingResponse> getAllBookings() {
        List<BookingEntity> bookings = bookingRepository.findAll();
        return bookings.stream().map(this::convertToBookingResponse).collect(Collectors.toList());
    }

    @Transactional
    public BookingResponse createBooking(BookingRequest bookingRequest) {
        ShowtimeEntity existingShowtime = showtimeRepository.findById(bookingRequest.getShowtimeId()).orElseThrow(() -> new ShowtimeNotFoundException("Showtime not found"));
        CustomerEntity existingCustomer = customerRepository.findById(bookingRequest.getCustomerId()).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        int requestedSeats = getNumberOfTicketsFromBookingRequest(bookingRequest);

        // Check if there are available seats
        if (!isSeatsAvailable(existingShowtime, requestedSeats)) {
            throw new InsufficientTicketsAvailableException("Not enough seats available");
        }

        BookingEntity booking = new BookingEntity();
        booking.setShowtime(existingShowtime);
        booking.setBookingDate(OffsetDateTime.now());
        booking.setTotalAmount(bookingRequest.getTotalAmount());
        booking.setCustomer(existingCustomer);

        BookingEntity savedBooking = bookingRepository.save(booking);
        return convertToBookingResponse(savedBooking);
    }

    public BookingResponse getBookingById(Integer id) throws BookingNotFoundException {
        BookingEntity booking = bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException("Booking not found with id: " + id));
        return convertToBookingResponse(booking);
    }

    @Transactional
    public BookingResponse updateBooking(BookingRequest bookingRequest) throws BookingNotFoundException, BookingAlreadyExistsException, InsufficientTicketsAvailableException {
        BookingEntity existingBooking = bookingRepository.findById(bookingRequest.getBookingId()).orElseThrow(() -> new BookingNotFoundException("Booking not found with id: " + bookingRequest.getBookingId()));

        ShowtimeEntity showtime = showtimeRepository.findById(bookingRequest.getShowtimeId()).orElseThrow(() -> new ShowtimeNotFoundException("Showtime not found"));

        int requestedSeats = getNumberOfTicketsFromBookingRequest(bookingRequest);
        int existingAvailableSeats = getNumberOfTicketsExisting(existingBooking.getBookingId());

        // Check if there are available seats for the new number of tickets
        int seatDifference = requestedSeats - existingAvailableSeats;
        if (seatDifference > 0 && !isSeatsAvailable(showtime, seatDifference)) {
            throw new InsufficientTicketsAvailableException("Not enough seats available");
        }

        existingBooking.setShowtime(showtime);
        existingBooking.setBookingDate(OffsetDateTime.now());
        //todo:Need to update correct booking totalAmount
        existingBooking.setTotalAmount(0);

        BookingEntity updatedBooking = bookingRepository.save(existingBooking);
        return convertToBookingResponse(updatedBooking);
    }

    @Transactional
    public void cancelBooking(Integer id) {
        BookingEntity booking = bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException("Booking not found with id: " + id));

        // You might want to add some business logic here,
        // e.g., check if the booking is eligible for cancellation based on the showtime

        bookingRepository.delete(booking);
    }

    private boolean isSeatsAvailable(ShowtimeEntity showtime, int requestedSeats) {
        int bookedSeats = bookingRepository.countBookedSeatsByShowtime(showtime);
        return (showtime.getTheater().getCapacity() - bookedSeats) >= requestedSeats;
    }

    // convert booking entity to booking response
    private BookingResponse convertToBookingResponse(BookingEntity booking) {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(booking.getBookingId());
        bookingResponse.setCustomerId(booking.getCustomer().getCustomerId());
        bookingResponse.setShowtimeId(booking.getShowtime().getShowtimeId());
        bookingResponse.setBookingDate(booking.getBookingDate());
        bookingResponse.setTotalAmount(booking.getTotalAmount());
        // bookingResponse.setNumberOfTickets(calculateNumberOfTickets(booking));
        return bookingResponse;
    }

    // convert booking request to booking entity
//    private BookingEntity convertToBookingEntity(BookingRequest bookingRequest) {
//        BookingEntity booking = new BookingEntity();
//        booking.setCustomer(bookingRequest.getCustomerId());
//        booking.setShowtime(bookingRequest.getShowtimeId());
//        booking.setBookingDate(bookingRequest.getBookingDate());
//        booking.setTotalAmount(bookingRequest.getTotalAmount());
//        return booking;
//    }

    // update booking entity
//    private void updateBookingEntity(BookingEntity booking, BookingRequest bookingRequest) {
//        booking.setCustomer(bookingRequest.getCustomerId());
//        booking.setShowtime(bookingRequest.getShowtimeId());
//        booking.setBookingDate(bookingRequest.getBookingDate());
//        booking.setTotalAmount(bookingRequest.getTotalAmount());
//    }


    // showtime.getAvailableTickets
    private int getAvailableTickets(ShowtimeEntity showtime) {
        return showtime.getTheater().getCapacity() - bookingRepository.countBookedSeatsByShowtime(showtime);
    }


    ////////////////////////////

    /*Giải thích:

    Phương thức getNumberOfTickets nhận vào một bookingId.
    Nó tìm kiếm booking tương ứng trong cơ sở dữ liệu. Nếu không tìm thấy, nó sẽ ném ra một BookingNotFoundException.
    Sau khi tìm thấy booking, nó gọi phương thức private calculateNumberOfTickets để tính toán số lượng vé.
    Phương thức calculateNumberOfTickets tính toán số lượng vé bằng cách chia tổng số tiền cho giá mỗi vé. Chúng ta sử dụng divideToIntegralValue để đảm bảo kết quả là một số nguyên.

    Lưu ý rằng cách tính này giả định rằng tổng số tiền luôn là bội số chính xác của giá mỗi vé. Trong thực tế, bạn có thể cần xử lý các trường hợp đặc biệt hoặc làm tròn số.*/

    public int getNumberOfTicketsExisting(Integer bookingId) throws BookingNotFoundException {
        BookingEntity booking = bookingRepository.findById(bookingId).orElseThrow(() -> new BookingNotFoundException("Booking not found with id: " + bookingId));

        return calculateNumberOfTickets(booking);
    }


    //todo:Need update real logic
    private int calculateNumberOfTickets(BookingEntity booking) {
        // Giả sử số lượng vé được tính bằng cách chia tổng số tiền cho giá mỗi vé
        // BigDecimal pricePerTicket = booking.getShowtimeId().getPrice();
        //return booking.getTotalAmount().divideToIntegralValue(pricePerTicket).intValue();
        return 0;
    }

    ////////////////////////////


    // getNumberOfTickets from booking request
    public Integer getNumberOfTicketsFromBookingRequest(BookingRequest bookingRequest) {
        double totalAmount = bookingRequest.getTotalAmount();
        double ticketPrice = bookingRequest.getTicketPrice();
        return (int) (totalAmount / ticketPrice);
    }
}
