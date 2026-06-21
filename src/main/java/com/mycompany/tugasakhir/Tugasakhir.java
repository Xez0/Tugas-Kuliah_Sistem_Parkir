/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tugasakhir;

/**
 *
 * @author DELL
 */
import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.tugasakhir.controller.NewLoginController;
import com.mycompany.tugasakhir.service.AuthService;
import com.mycompany.tugasakhir.view.NewLoginView;

import javax.swing.*;

public class Tugasakhir {

    private static void startDatabaseAuto() {
        try {
            String projectPath = System.getProperty("user.dir");
            String batPath = projectPath + "\\start_database.bat";
            Runtime.getRuntime().exec("cmd /c start /min \"\" \"" + batPath + "\"");
            System.out.println("[System] Database local server berhasil dinyalakan di background.");
        } catch (Exception e) {
            System.err.println("[Error] Gagal menyalakan database otomatis: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Jalankan database otomatis
        startDatabaseAuto();

        // Setup Look and Feel FlatLaf Light
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            
            // Custom defaults for beautiful elements
            UIManager.put("Button.arc", 8);
            UIManager.put("Component.arc", 8);
            UIManager.put("TextComponent.arc", 8);
        } catch (Exception ex) {
            System.err.println("Gagal menginisialisasi FlatLaf: " + ex.getMessage());
        }

        // Launch Login View
        SwingUtilities.invokeLater(() -> {
            NewLoginView loginView = new NewLoginView();
            AuthService authService = new AuthService();
            new NewLoginController(loginView, authService);
            loginView.setVisible(true);
        });
    }
}
