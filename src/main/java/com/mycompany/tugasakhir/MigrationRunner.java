package com.mycompany.tugasakhir;

import com.mycompany.tugasakhir.config.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MigrationRunner {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            
            System.out.println("Memulai migrasi database...");
            
            // Print schema before
            System.out.println("\n--- SCHEMA SEBELUM MIGRASI ---");
            ResultSet rs = stmt.executeQuery("DESCRIBE transaksi_parkir");
            boolean hasIdTarif = false;
            while (rs.next()) {
                String field = rs.getString("Field");
                System.out.println(field + " - " + rs.getString("Type"));
                if (field.equalsIgnoreCase("id_tarif")) {
                    hasIdTarif = true;
                }
            }
            
            if (!hasIdTarif) {
                System.out.println("\nSUCCESS: Kolom id_tarif memang SUDAH TIDAK ADA di tabel transaksi_parkir.");
            } else {
                System.out.println("\nWARNING: Kolom id_tarif MASIH ADA. Mencoba menghapus...");
                try {
                    stmt.execute("ALTER TABLE transaksi_parkir DROP FOREIGN KEY fk_transaksi_tarif");
                    System.out.println("-> Drop FK sukses.");
                } catch (Exception e) {
                    System.out.println("-> Drop FK gagal/tidak ada: " + e.getMessage());
                }
                
                try {
                    stmt.execute("ALTER TABLE transaksi_parkir DROP COLUMN id_tarif");
                    System.out.println("-> Drop Kolom sukses.");
                } catch (Exception e) {
                    System.out.println("-> Drop Kolom gagal: " + e.getMessage());
                }
            }
            
            // Print schema after
            System.out.println("\n--- SCHEMA SETELAH MIGRASI ---");
            rs = stmt.executeQuery("DESCRIBE transaksi_parkir");
            while (rs.next()) {
                System.out.println(rs.getString("Field") + " - " + rs.getString("Type"));
            }
            
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
