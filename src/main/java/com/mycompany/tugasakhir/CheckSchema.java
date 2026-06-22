package com.mycompany.tugasakhir;

import com.mycompany.tugasakhir.config.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CheckSchema {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("DESCRIBE transaksi_parkir");
            System.out.println("\n=== SCHEMA transaksi_parkir ===");
            while (rs.next()) {
                System.out.println(rs.getString("Field") + " - " + rs.getString("Type") + " - Default: " + rs.getString("Default"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
