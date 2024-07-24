package com.example.gen_code_ai.repository;

import com.example.gen_code_ai.entity.Movie;
import com.example.gen_code_ai.entity.MoviePricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT mp FROM MoviePricing mp " +
            "WHERE mp.movie = :movie " +
            "AND :date BETWEEN mp.startDate AND mp.endDate " +
            "ORDER BY mp.startDate DESC " +
            "LIMIT 1")
    Optional<MoviePricing> findByMovieAndDate(@Param("movie") Movie movie, @Param("date") LocalDate date);
}
