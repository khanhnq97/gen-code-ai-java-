package com.example.gen_code_ai.utils;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class DateTimeUtil {
    // create a new date time object
    public static OffsetDateTime getDateTime() {
        return OffsetDateTime.now();
    }

    // convert OffsetDateTime to LocalDateTime
    public static LocalDateTime convertToLocalDateTime(OffsetDateTime dateTime) {
        return dateTime.toLocalDateTime();
    }

    // convert LocalDateTime to OffsetDateTime
    public static OffsetDateTime convertToOffsetDateTime(LocalDateTime dateTime) {
        return dateTime.atOffset(ZoneOffset.UTC);
    }
}
