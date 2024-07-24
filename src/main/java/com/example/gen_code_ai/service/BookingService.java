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
import com.example.gen_code_ai.entity.Booking;
import com.example.gen_code_ai.entity.Customer;
import com.example.gen_code_ai.entity.Showtime;
import com.example.gen_code_ai.entity.Theater;
import com.example.gen_code_ai.exception.BookingNotFoundException;
import com.example.gen_code_ai.exception.CustomerNotFoundException;
import com.example.gen_code_ai.exception.InsufficientTicketsAvailableException;
import com.example.gen_code_ai.exception.MovieNotFoundException;
import com.example.gen_code_ai.exception.ResourceNotFoundException;
import com.example.gen_code_ai.exception.ShowtimeNotFoundException;
import com.example.gen_code_ai.exception.TheaterNotFoundException;
import com.example.gen_code_ai.repository.BookingRepository;
import com.example.gen_code_ai.repository.CustomerRepository;
import com.example.gen_code_ai.repository.MovieRepository;
import com.example.gen_code_ai.repository.SeatRepository;
import com.example.gen_code_ai.repository.ShowtimeRepository;
import com.example.gen_code_ai.repository.TheaterRepository;
import com.example.gen_code_ai.utils.BookingUtil;
import com.example.gen_code_ai.utils.DateTimeUtil;
import com.example.gen_code_ai.utils.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.gen_code_ai.utils.ConvertDataUtil.convertToCustomerResponse;
import static com.example.gen_code_ai.utils.ConvertDataUtil.convertToMovieResponse;
import static com.example.gen_code_ai.utils.ConvertDataUtil.convertToShowtimeResponse;
import static com.example.gen_code_ai.utils.ConvertDataUtil.convertToTheaterResponse;

@Service
public class BookingService {

  @Autowired private BookingRepository bookingRepository;

  @Autowired private ShowtimeRepository showtimeRepository;

  @Autowired private CustomerRepository customerRepository;

  @Autowired private MovieRepository movieRepository;

  @Autowired private TheaterRepository theatersRepository;

  @Autowired private SeatRepository seatRepository;

  public List<BookingResponse> getAllBookings() {
    List<Booking> bookings = bookingRepository.findAll();
    return bookings.stream().map(this::convertToBookingResponse).collect(Collectors.toList());
  }

  @Transactional
  public BookingResponse createBooking(BookingRequest request)
      throws CustomerNotFoundException,
          ShowtimeNotFoundException,
          InsufficientTicketsAvailableException {
    // Retrieve existing entities based on the request
    var customerId = request.getCustomerId();
    Customer customer =
        customerRepository
            .findById(customerId)
            .orElseThrow(
                () -> new CustomerNotFoundException("Customer not found with id: " + customerId));

    var showtimeId = request.getShowtimeId();
    Showtime showtime =
        showtimeRepository
            .findById(showtimeId)
            .orElseThrow(
                () -> new ShowtimeNotFoundException("Showtime not found with id: " + showtimeId));

    var theaterId = showtime.getTheater().getId();
    Theater theater =
        theatersRepository
            .findById(theaterId)
            .orElseThrow(
                () -> new TheaterNotFoundException("Theater not found with id: " + theaterId));

    var movieId = showtime.getMovie().getId();
    var movie =
        movieRepository
            .findById(movieId)
            .orElseThrow(() -> new MovieNotFoundException("Movie not found with id: " + movieId));

    var seats = seatRepository.findAllById(request.getSeatIds());
    if (seats.size() != request.getSeatIds().size()) {
      throw new ResourceNotFoundException("One or more seats not found");
    }

    // check if seats are available
    //        if (!isSeatsAvailable(showtime, seats)) {
    //            throw new InsufficientTicketsAvailableException("Not enough seats available");
    //        }

    // Calculate the number of requested seats
    // int requestedSeats = calculateRequestedSeats(request);

    // Check seat availability
    //        if (!isSeatsAvailable(showtime, requestedSeats)) {
    //            throw new InsufficientTicketsAvailableException("Not enough seats available");
    //        }

    // Check if seats are available
    // Calculate total amount
    BigDecimal totalAmount = BookingUtil.calculateTotalAmount(seats, showtime);
    if (totalAmount.compareTo(BigDecimal.ZERO) <= 0) {
      throw new InsufficientTicketsAvailableException("Not enough tickets available");
    }

    // Create and save booking entity
    Booking booking = createNewBooking(request, customer, showtime, totalAmount);
    Booking savedBooking = bookingRepository.save(booking);

    return convertToBookingResponse(savedBooking);
  }

  public BookingResponse getBookingById(Long id) throws BookingNotFoundException {
    Booking booking =
        bookingRepository
            .findById(id)
            .orElseThrow(() -> new BookingNotFoundException("Booking not found with id: " + id));
    return convertToBookingResponse(booking);
  }

  //
  //    @Transactional
  //    public BookingResponse updateBooking(BookingRequest bookingRequest) throws
  // BookingNotFoundException, BookingAlreadyExistsException, InsufficientTicketsAvailableException
  // {
  //        Booking existingBooking =
  // bookingRepository.findById(bookingRequest.getBookingId()).orElseThrow(() -> new
  // BookingNotFoundException("Booking not found with id: " + bookingRequest.getBookingId()));
  //
  //        ShowtimeEntity showtime =
  // showtimeRepository.findById(bookingRequest.getShowtimeId()).orElseThrow(() -> new
  // ShowtimeNotFoundException("Showtime not found with id: " + bookingRequest.getShowtimeId()));
  //
  //        int requestedSeats = calculateRequestedSeats(bookingRequest);
  //        int existingAvailableSeats = getNumberOfTicketsExisting(existingBooking.getId());
  //
  //        // Check if there are available seats for the new number of tickets
  //        int seatDifference = requestedSeats - existingAvailableSeats;
  //        if (seatDifference > 0 && !isSeatsAvailable(showtime, seatDifference)) {
  //            throw new InsufficientTicketsAvailableException("Not enough seats available");
  //        }
  //
  //        existingBooking.setShowtime(showtime);
  //        existingBooking.setBookingDate(OffsetDateTime.now());
  //        //todo:Need to update correct booking totalAmount
  //        existingBooking.setTotalAmount(0);
  //
  //        Booking updatedBooking = bookingRepository.save(existingBooking);
  //        return convertToBookingResponse(updatedBooking);
  //    }

  //    @Transactional
  //    public void cancelBooking(Integer id) {
  //        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new
  // BookingNotFoundException("Booking not found with id: " + id));
  //
  //        // You might want to add some business logic here,
  //        // e.g., check if the booking is eligible for cancellation based on the showtime
  //
  //        bookingRepository.delete(booking);
  //    }

  private boolean isSeatsAvailable(Showtime showtime, int requestedSeats) {
    int bookedSeats = bookingRepository.countBookedSeatsByShowtime(showtime);
    return (showtime.getTheater().getCapacity() - bookedSeats) >= requestedSeats;
  }

  // convert booking entity to booking response

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
  private int getAvailableTickets(Showtime showtime) {
    return showtime.getTheater().getCapacity()
        - bookingRepository.countBookedSeatsByShowtime(showtime);
  }

  ////////////////////////////

  /*Giải thích:

  Phương thức getNumberOfTickets nhận vào một bookingId.
  Nó tìm kiếm booking tương ứng trong cơ sở dữ liệu. Nếu không tìm thấy, nó sẽ ném ra một BookingNotFoundException.
  Sau khi tìm thấy booking, nó gọi phương thức private calculateNumberOfTickets để tính toán số lượng vé.
  Phương thức calculateNumberOfTickets tính toán số lượng vé bằng cách chia tổng số tiền cho giá mỗi vé. Chúng ta sử dụng divideToIntegralValue để đảm bảo kết quả là một số nguyên.

  Lưu ý rằng cách tính này giả định rằng tổng số tiền luôn là bội số chính xác của giá mỗi vé. Trong thực tế, bạn có thể cần xử lý các trường hợp đặc biệt hoặc làm tròn số.*/

  public int getNumberOfTicketsExisting(Long bookingId) throws BookingNotFoundException {
    Booking booking =
        bookingRepository
            .findById(bookingId)
            .orElseThrow(
                () -> new BookingNotFoundException("Booking not found with id: " + bookingId));

    return calculateNumberOfTickets(booking);
  }

  // todo:Need update real logic
  private int calculateNumberOfTickets(Booking booking) {
    // Giả sử số lượng vé được tính bằng cách chia tổng số tiền cho giá mỗi vé
    // BigDecimal pricePerTicket = booking.getShowtimeId().getPrice();
    // return booking.getTotalAmount().divideToIntegralValue(pricePerTicket).intValue();
    return 0;
  }

  ////////////////////////////

  //
  //    // getNumberOfTickets from booking request
  //    public Integer calculateRequestedSeats(BookingRequest request) {
  //        double totalAmount = request.getTotalAmount();
  //        double ticketPrice = request.getTicketPrice();
  //        return (int) (totalAmount / ticketPrice);
  //    }

  // createNewBooking
  public Booking createNewBooking(BookingRequest request, Customer customer, Showtime showtime,BigDecimal totalAmount) {
    Booking booking = new Booking();
    booking.setCustomer(customer);
    booking.setShowtime(showtime);
    booking.setTotalAmount(totalAmount);
    booking.setBookingDate(LocalDateTime.now());
    bookingRepository.save(booking);
    return booking;
  }

  public BookingResponse convertToBookingResponse(Booking booking) {
    BookingResponse bookingResponse = new BookingResponse();
    bookingResponse.setBookingId(booking.getId());
    bookingResponse.setCustomer(convertToCustomerResponse(booking.getCustomer()));
    bookingResponse.setShowtime(convertToShowtimeResponse(booking.getShowtime()));
    bookingResponse.setTheater(convertToTheaterResponse(booking.getShowtime().getTheater()));
    bookingResponse.setMovie(convertToMovieResponse(booking.getShowtime().getMovie()));
    bookingResponse.setBookingDate(DateTimeUtil.convertToOffsetDateTime(booking.getBookingDate()));
    bookingResponse.setTotalAmount(NumberUtil.convertToDouble(booking.getTotalAmount()));
    return bookingResponse;
  }
}
