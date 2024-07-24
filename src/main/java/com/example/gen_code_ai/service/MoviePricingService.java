package com.example.gen_code_ai.service;

import com.example.gen_code_ai.entity.Movie;
import com.example.gen_code_ai.entity.MoviePricing;
import com.example.gen_code_ai.repository.MoviePricingRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoviePricingService {
  @Autowired private MoviePricingRepository moviePricingRepository;

  public BigDecimal getStandardPrice(Movie movie, LocalDate date) {
    return moviePricingRepository
        .findByMovieAndDate(movie, date)
        .map(MoviePricing::getPrice)
        .orElse(movie.getDefaultStandardPrice());
  }

  //    public BigDecimal getStandardPrice2(Movie movie, Theater theater, LocalDate date) {
  //        BigDecimal basePrice = movie.getStandardPrice();
  //
  //        // Điều chỉnh theo rạp
  //        basePrice = basePrice.multiply(theater.getPriceMultiplier());
  //
  //        // Điều chỉnh theo thời gian công chiếu
  //        long daysSinceRelease = ChronoUnit.DAYS.between(movie.getReleaseDate(), date);
  //        if (daysSinceRelease < 7) {
  //            basePrice = basePrice.multiply(new BigDecimal("1.2")); // Tăng 20% trong tuần đầu
  // công chiếu
  //        }
  //
  //        // Có thể thêm các điều chỉnh khác...
  //
  //        return basePrice;
  //    }
}
