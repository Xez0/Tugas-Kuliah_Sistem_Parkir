package com.mycompany.tugasakhir.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utility class untuk hashing password menggunakan SHA-256.
 */
public class HashUtil {

    /**
     * Hash string menggunakan SHA-256.
     * @param input string yang akan di-hash
     * @return hex string hasil hash
     */
    public static String sha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }

    /**
     * Verifikasi password terhadap hash.
     */
    public static boolean verify(String plaintext, String hash) {
        return sha256(plaintext).equals(hash);
    }
}
