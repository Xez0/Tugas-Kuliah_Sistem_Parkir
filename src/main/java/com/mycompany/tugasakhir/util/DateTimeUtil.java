package com.mycompany.tugasakhir.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class untuk operasi tanggal dan waktu.
 */
public class DateTimeUtil {

    public static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final DateTimeFormatter DISPLAY_DATETIME = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    public static final DateTimeFormatter DISPLAY_DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter DISPLAY_TIME = DateTimeFormatter.ofPattern("HH:mm");

    /**
     * Hitung durasi dalam jam (dibulatkan ke atas).
     * Contoh: 1 jam 30 menit = 2 jam
     */
    public static int hitungDurasiJam(LocalDateTime masuk, LocalDateTime keluar) {
        if (masuk == null || keluar == null || keluar.isBefore(masuk)) {
            return 0;
        }
        long minutes = Duration.between(masuk, keluar).toMinutes();
        if (minutes <= 0) return 0;
        // Pembulatan ke atas: 1-60 menit = 1 jam, 61-120 = 2 jam, dll
        return (int) Math.ceil(minutes / 60.0);
    }

    /**
     * Format LocalDateTime ke string display.
     */
    public static String formatDisplay(LocalDateTime dateTime) {
        if (dateTime == null) return "-";
        return dateTime.format(DISPLAY_DATETIME);
    }

    /**
     * Format LocalDateTime ke string database.
     */
    public static String formatForDb(LocalDateTime dateTime) {
        if (dateTime == null) return null;
        return dateTime.format(DATETIME_FORMAT);
    }

    /**
     * Parse string datetime dari database.
     */
    public static LocalDateTime parseFromDb(String dateTimeStr) {
        if (dateTimeStr == null || dateTimeStr.isEmpty()) return null;
        return LocalDateTime.parse(dateTimeStr, DATETIME_FORMAT);
    }

    /**
     * Dapatkan waktu sekarang.
     */
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    /**
     * Format durasi jam ke string readable.
     */
    public static String formatDurasi(int jam) {
        if (jam <= 0) return "0 jam";
        return jam + " jam";
    }
}
