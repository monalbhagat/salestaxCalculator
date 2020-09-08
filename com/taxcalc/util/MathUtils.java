package com.taxcalc.util;

public class MathUtils {

    public static double roundOffTax(double n) {
        return Math.ceil(n * 20) / 20;
    }

    public static double roundOffAmount(double n) {
        return Math.round(n * 100.0) / 100.0;
    }
}
