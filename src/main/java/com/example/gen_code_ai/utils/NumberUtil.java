package com.example.gen_code_ai.utils;

import java.math.BigDecimal;

public class NumberUtil {
    // convert decimal to double
    public static double convertToDouble(BigDecimal bigDecimal) {
        return bigDecimal.doubleValue();
    }

    // convert double to decimal
    public static BigDecimal convertToBigDecimal(double number) {
        return BigDecimal.valueOf(number);
    }
}
