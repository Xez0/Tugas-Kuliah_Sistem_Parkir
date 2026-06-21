package com.mycompany.tugasakhir.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Utility class untuk format mata uang Rupiah.
 */
public class CurrencyUtil {

    private static final DecimalFormat RUPIAH_FORMAT;

    static {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("id", "ID"));
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        RUPIAH_FORMAT = new DecimalFormat("Rp #,##0", symbols);
    }

    /**
     * Format angka ke format Rupiah.
     * Contoh: 15000.0 → "Rp 15.000"
     */
    public static String formatRupiah(double amount) {
        return RUPIAH_FORMAT.format(amount);
    }

    /**
     * Format angka ke format Rupiah tanpa prefix "Rp".
     * Contoh: 15000.0 → "15.000"
     */
    public static String formatNumber(double amount) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("id", "ID"));
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("#,##0", symbols);
        return df.format(amount);
    }

    /**
     * Parse string angka dari format Rupiah.
     */
    public static double parseRupiah(String rupiahStr) {
        if (rupiahStr == null || rupiahStr.trim().isEmpty()) return 0;
        String cleaned = rupiahStr.replaceAll("[^\\d,.]", "");
        cleaned = cleaned.replace(".", "").replace(",", ".");
        try {
            return Double.parseDouble(cleaned);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
