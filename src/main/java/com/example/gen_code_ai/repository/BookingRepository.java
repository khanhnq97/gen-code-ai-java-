package com.example.gen_code_ai.repository;

import com.example.gen_code_ai.entity.Booking;
import com.example.gen_code_ai.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    int countBookedSeatsByShowtime(Showtime showtime);
}
