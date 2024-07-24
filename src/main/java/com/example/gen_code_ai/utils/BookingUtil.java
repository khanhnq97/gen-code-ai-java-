package com.example.gen_code_ai.utils;

import com.example.gen_code_ai.entity.Movie;
import com.example.gen_code_ai.entity.PricingConfig;
import com.example.gen_code_ai.entity.Seat;
import com.example.gen_code_ai.entity.Showtime;
import com.example.gen_code_ai.entity.Theater;
import com.example.gen_code_ai.model.PricingType;
import com.example.gen_code_ai.repository.MovieRepository;
import com.example.gen_code_ai.repository.PricingConfigRepository;
import com.example.gen_code_ai.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

public class BookingUtil {

    private BookingUtil() {
    }

    @Autowired
    public static PricingConfigRepository pricingConfigRepository;

    @Autowired
    public static TheaterRepository theaterRepository;

    @Autowired
    public static MovieRepository movieRepository;

    public static BigDecimal calculateTicketPrice(Showtime showtime) {
        return getBasePrice(showtime);
    }


    public static BigDecimal calculateTotalAmount(List<Seat> seats, Showtime showtime) {
        BigDecimal totalAmount = BigDecimal.ZERO;

        for (Seat seat : seats) {
            BigDecimal seatPrice = getSeatPrice(seat, showtime);
            totalAmount = totalAmount.add(seatPrice);
        }

        // Áp dụng các khuyến mãi hoặc phụ phí (nếu có)
        totalAmount = applyPromotionsAndFees(totalAmount, showtime);

        return totalAmount;
    }

    public static BigDecimal getSeatPrice(Seat seat, Showtime showtime) {
        BigDecimal basePrice = calculateTicketPrice(showtime);

        // Áp dụng giá theo loại ghế
        return switch (seat.getSeatType()) {
            case VIP -> basePrice.multiply(new BigDecimal("1.5")); // VIP ghế có giá cao hơn 50%
            case COUPLE -> basePrice.multiply(new BigDecimal("2.2")); // Ghế đôi có giá cao hơn 120%
            default -> basePrice;
        };
    }

    public static BigDecimal applyPromotionsAndFees(BigDecimal amount, Showtime showtime) {
        // Áp dụng giảm giá cho suất chiếu sớm
        if (isEarlyShow(showtime)) {
            amount = amount.multiply(new BigDecimal("0.9")); // Giảm 10%
        }

        // Áp dụng phụ phí cho suất chiếu cuối tuần
        if (isWeekendShow(showtime)) {
            amount = amount.multiply(new BigDecimal("1.1")); // Tăng 10%
        }

        // Có thể thêm logic để áp dụng các khuyến mãi khác ở đây

        return amount;
    }

    public static boolean isEarlyShow(Showtime showtime) {
        // Logic để xác định suất chiếu sớm
        // Ví dụ: suất chiếu trước 12:00 trưa
        return showtime.getStartTime().getHour() < 12;
    }

    public static boolean isWeekendShow(Showtime showtime) {
        // Logic để xác định suất chiếu cuối tuần
        DayOfWeek day = showtime.getStartTime().getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }

    public static BigDecimal getBasePrice(Showtime showtime) {
        Movie movie = movieRepository.findById(showtime.getMovie().getId()).orElse(null);
        if (movie == null) {
            throw new IllegalArgumentException("Movie not found");
        }
        BigDecimal basePrice = showtime.getMovie().getDefaultStandardPrice();

        LocalDateTime startTime = showtime.getStartTime();

        // Áp dụng điều chỉnh giá theo rạp

        Theater theater = theaterRepository.findById(showtime.getTheater().getId()).orElse(null);
        if (theater != null) {
            basePrice = applyTheaterPricing(basePrice, theater);
        }

        // Áp dụng điều chỉnh giá theo ngày trong tuần
        basePrice = applyDayOfWeekPricing(basePrice, startTime);

        // Áp dụng điều chỉnh giá theo thời gian trong ngày
        basePrice = applyTimeOfDayPricing(basePrice, startTime);

        // Áp dụng điều chỉnh giá theo mùa hoặc sự kiện đặc biệt
        basePrice = applySeasonalPricing(basePrice, startTime);

        return basePrice;
    }

    public static BigDecimal applyTheaterPricing(BigDecimal price, Theater theater) {
        PricingConfig theaterPricing = pricingConfigRepository.findByTheaterAndType(theater, PricingType.THEATER);
        return price.multiply(theaterPricing.getAdjustmentFactor());
    }

    public static BigDecimal applyDayOfWeekPricing(BigDecimal price, LocalDateTime datetime) {
        DayOfWeek dayOfWeek = datetime.getDayOfWeek();
        PricingConfig dayPricing = pricingConfigRepository.findByDayOfWeekAndType(dayOfWeek, PricingType.DAY_OF_WEEK);
        return price.multiply(dayPricing.getAdjustmentFactor());
    }

    public static BigDecimal applyTimeOfDayPricing(BigDecimal price, LocalDateTime datetime) {
        int hour = datetime.getHour();
        PricingConfig timePricing = pricingConfigRepository.findByHourRangeAndType(hour, PricingType.TIME_OF_DAY);
        return price.multiply(timePricing.getAdjustmentFactor());
    }

    public static BigDecimal applySeasonalPricing(BigDecimal price, LocalDateTime datetime) {
        PricingConfig seasonalPricing = pricingConfigRepository.findByDateRangeAndType(datetime.toLocalDate(), PricingType.SEASONAL);
        return price.multiply(seasonalPricing.getAdjustmentFactor());
    }
}