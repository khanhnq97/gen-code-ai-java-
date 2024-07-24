package com.example.gen_code_ai.repository;

import com.example.gen_code_ai.entity.PricingConfig;
import com.example.gen_code_ai.entity.Theater;
import com.example.gen_code_ai.model.PricingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Repository
public interface PricingConfigRepository extends JpaRepository<PricingConfig, Long> {
    PricingConfig findByTheaterAndType(Theater theater, PricingType type);

    PricingConfig findByDayOfWeekAndType(DayOfWeek dayOfWeek, PricingType type);

    @Query("SELECT pc FROM PricingConfig pc WHERE pc.type = :type " + "AND :hour BETWEEN pc.startHour AND pc.endHour")
    PricingConfig findByHourRangeAndType(@Param("hour") int hour, @Param("type") PricingType type);

    @Query("SELECT pc FROM PricingConfig pc WHERE pc.type = :type " + "AND :date BETWEEN pc.startDate AND pc.endDate")
    PricingConfig findByDateRangeAndType(@Param("date") LocalDate date, @Param("type") PricingType type);
}
