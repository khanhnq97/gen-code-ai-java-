package com.example.gen_code_ai.controller;


import com.example.gen_code_ai.dto.BookingRequest;
import com.example.gen_code_ai.dto.BookingResponse;
import com.example.gen_code_ai.exception.BookingAlreadyExistsException;
import com.example.gen_code_ai.exception.BookingNotFoundException;
import com.example.gen_code_ai.exception.InsufficientTicketsAvailableException;
import com.example.gen_code_ai.service.BookingService;
import com.example.gen_code_ai.web.BookingsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController implements BookingsApi {

    @Autowired
    private BookingService bookingService;

    @Override
    public ResponseEntity<List<BookingResponse>> getBookings() {
        List<BookingResponse> bookings = bookingService.getAllBookings();
        System.out.println(bookings);
        return ResponseEntity.ok(bookings);
    }

    @Override
    public ResponseEntity<BookingResponse> createBooking(BookingRequest bookingRequest) {
        BookingResponse createdBooking = bookingService.createBooking(bookingRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }

    @Override
    public ResponseEntity<BookingResponse> getBookingById(Integer id) {
        try {
            BookingResponse booking = bookingService.getBookingById(id);
            return ResponseEntity.ok(booking);
        } catch (BookingNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<BookingResponse> updateBooking(BookingRequest bookingRequest) {
        try {
            BookingResponse updatedBooking = bookingService.updateBooking(bookingRequest);
            return ResponseEntity.ok(updatedBooking);
        } catch (BookingNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (BookingAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (InsufficientTicketsAvailableException e) {
            return ResponseEntity.unprocessableEntity().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Void> cancelBooking(Integer id) {
        try {
            bookingService.cancelBooking(id);
            return ResponseEntity.noContent().build();
        } catch (BookingNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}