package com.mycompany.tugasakhir.util;

/**
 * Utility class untuk validasi input.
 */
public class ValidationUtil {

    /**
     * Cek apakah string kosong atau null.
     */
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Cek apakah string adalah angka valid.
     */
    public static boolean isNumeric(String value) {
        if (isEmpty(value)) return false;
        try {
            Double.parseDouble(value.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Cek apakah string adalah integer valid.
     */
    public static boolean isInteger(String value) {
        if (isEmpty(value)) return false;
        try {
            Integer.parseInt(value.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validasi format plat nomor (contoh: B 1234 ABC).
     * Format: 1-2 huruf, spasi, 1-4 angka, spasi, 1-3 huruf
     */
    public static boolean isValidPlatNomor(String plat) {
        if (isEmpty(plat)) return false;
        String pattern = "^[A-Z]{1,2}\\s?\\d{1,4}\\s?[A-Z]{1,3}$";
        return plat.trim().toUpperCase().matches(pattern);
    }

    /**
     * Cek apakah angka positif.
     */
    public static boolean isPositiveNumber(String value) {
        if (!isNumeric(value)) return false;
        return Double.parseDouble(value.trim()) > 0;
    }

    /**
     * Validasi panjang minimum string.
     */
    public static boolean hasMinLength(String value, int minLength) {
        return !isEmpty(value) && value.trim().length() >= minLength;
    }
}
