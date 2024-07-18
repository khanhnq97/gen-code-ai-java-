package com.example.gen_code_ai.repository;

import com.example.gen_code_ai.entity.BookingEntity;
import com.example.gen_code_ai.entity.ShowtimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {
    int countBookedSeatsByShowtime(ShowtimeEntity showtime);
}
