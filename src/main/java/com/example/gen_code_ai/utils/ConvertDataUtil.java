package com.example.gen_code_ai.utils;

import com.example.gen_code_ai.dto.BookingResponse;
import com.example.gen_code_ai.dto.CustomerResponse;
import com.example.gen_code_ai.dto.MovieResponse;
import com.example.gen_code_ai.dto.SeatResponse;
import com.example.gen_code_ai.dto.ShowtimeResponse;
import com.example.gen_code_ai.dto.TheaterResponse;
import com.example.gen_code_ai.entity.Booking;
import com.example.gen_code_ai.entity.Customer;
import com.example.gen_code_ai.entity.Movie;
import com.example.gen_code_ai.entity.Seat;
import com.example.gen_code_ai.entity.Showtime;
import com.example.gen_code_ai.entity.Theater;

public class ConvertDataUtil {

    // convert customer entity to customer response
    public static CustomerResponse convertToCustomerResponse(Customer customer) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomerId(customer.getCustomerId());
        customerResponse.setName(customer.getName());
        customerResponse.setEmail(customer.getEmail());
        return customerResponse;
    }

    // convert showtime entity to showtime response
    public static ShowtimeResponse convertToShowtimeResponse(Showtime showtime) {
        ShowtimeResponse showtimeResponse = new ShowtimeResponse();
        showtimeResponse.setShowtimeId(showtime.getShowtimeId());
        showtimeResponse.setStartTime(DateTimeUtil.convertToOffsetDateTime(showtime.getStartTime()));
        showtimeResponse.setEndTime(DateTimeUtil.convertToOffsetDateTime(showtime.getEndTime()));
        return showtimeResponse;
    }

    // convert theater entity to theater response
    public static TheaterResponse convertToTheaterResponse(Theater theater) {
        TheaterResponse theaterResponse = new TheaterResponse();
        theaterResponse.setTheaterId(theater.getId());
        theaterResponse.setName(theater.getName());
        return theaterResponse;
    }

    // convert movie entity to movie response
    public static MovieResponse convertToMovieResponse(Movie movie) {
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setMovieId(movie.getId());
        movieResponse.setTitle(movie.getTitle());
        movieResponse.setDuration(movie.getDuration());
        movieResponse.setReleaseDate(DateTimeUtil.convertToOffsetDateTime(movie.getReleaseDate()));
        movieResponse.setGenre(movie.getGenre());
        movieResponse.setDirector(movie.getDirector());
        movieResponse.setCast(movie.getCast());
        return movieResponse;
    }

    // convert seat entity to seat response
    public static SeatResponse convertToSeatResponse(Seat seat) {
        SeatResponse seatResponse = new SeatResponse();
        seatResponse.setSeatId(seat.getSeatId());
        //seatResponse.setRowNum(seat.getRowNumber());
        seatResponse.setSeatNumber(seat.getSeatNumber());
        //todo: add theater_id
        return seatResponse;
    }

    public static BookingResponse convertToBookingResponse(Booking booking) {
        BookingResponse bookingResponse = new BookingResponse();

//        bookingResponse.setBookingId(booking.getId());
//        bookingResponse.setCustomer(convertToCustomerResponse(booking.getCustomer()));
//        bookingResponse.setShowtime(convertToShowtimeResponse(booking.getShowtime()));
//        bookingResponse.setTheater(convertToTheaterResponse(booking.getShowtime().getTheater()));
//        bookingResponse.setMovie(convertToMovieResponse(booking.getShowtime().getMovie()));
//        bookingResponse.setBookingDate(booking.getBookingDate());
//        bookingResponse.setTotalAmount(booking.getTotalAmount());
        return bookingResponse;
    }
}
