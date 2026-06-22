package com.mycompany.tugasakhir.view;

import com.mycompany.tugasakhir.controller.*;
import com.mycompany.tugasakhir.service.AuthService;
import com.mycompany.tugasakhir.util.SessionManager;
import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Dimension;

/**
 * Router untuk mengelola transisi navigasi antar JPanel secara mulus dan konsisten.
 */
public class ViewRouter {
    private static NewDashboardView dashboardView;
    private static NewTransaksiMasukView transaksiMasukView;
    private static NewTransaksiKeluarView transaksiKeluarView;
    private static NewKendaraanView kendaraanView;
    private static NewPetugasView petugasView;
    private static NewUserView userView;
    private static NewLaporanView laporanView;

    private static JFrame mainFrame;
    private static JPanel cardsPanel;
    private static CardLayout cardLayout;
    
    private static NewDashboardController dashboardController;

    public static void initializeAllViews() {
        dashboardView = new NewDashboardView();
        transaksiMasukView = new NewTransaksiMasukView();
        transaksiKeluarView = new NewTransaksiKeluarView();
        kendaraanView = new NewKendaraanView();
        petugasView = new NewPetugasView();
        userView = new NewUserView();
        laporanView = new NewLaporanView();

        // Inisialisasi controller versi baru langsung ke JFrame view
        dashboardController = new NewDashboardController(dashboardView);
        new NewTransaksiController(transaksiMasukView, transaksiKeluarView);
        new KendaraanController(kendaraanView);
        new PetugasController(petugasView);
        new UserController(userView);
        new LaporanController(laporanView);
        
        mainFrame = new JFrame("Aplikasi Tugas Akhir");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardLayout = new CardLayout();
        cardsPanel = new JPanel(cardLayout);
        mainFrame.setContentPane(cardsPanel);
        
        cardsPanel.add(dashboardView.getContentPane(), "DASHBOARD");
        cardsPanel.add(transaksiMasukView.getContentPane(), "MASUK");
        cardsPanel.add(transaksiKeluarView.getContentPane(), "KELUAR");
        cardsPanel.add(kendaraanView.getContentPane(), "KENDARAAN");
        cardsPanel.add(petugasView.getContentPane(), "PETUGAS");
        cardsPanel.add(userView.getContentPane(), "USER");
        cardsPanel.add(laporanView.getContentPane(), "LAPORAN");
        
        mainFrame.setMinimumSize(new Dimension(1150, 700));
        mainFrame.setSize(1200, 750);
        mainFrame.setLocationRelativeTo(null);
    }

    public static void showView(String viewName, JFrame activeFrame) {
        JFrame targetFrame = null;
        switch (viewName) {
            case "DASHBOARD" -> targetFrame = dashboardView;
            case "MASUK" -> targetFrame = transaksiMasukView;
            case "KELUAR" -> targetFrame = transaksiKeluarView;
            case "KENDARAAN" -> targetFrame = kendaraanView;
            case "PETUGAS" -> targetFrame = petugasView;
            case "USER" -> targetFrame = userView;
            case "LAPORAN" -> targetFrame = laporanView;
        }

        if (targetFrame != null) {
            mainFrame.setJMenuBar(targetFrame.getJMenuBar());
            String title = targetFrame.getTitle();
            mainFrame.setTitle(title != null && !title.isEmpty() ? title : "Aplikasi Tugas Akhir");
            
            cardLayout.show(cardsPanel, viewName);
            
            if ("DASHBOARD".equals(viewName) && dashboardController != null) {
                dashboardController.refreshData();
            }
            
            if (activeFrame != null && activeFrame != mainFrame && activeFrame.isVisible()) {
                mainFrame.setExtendedState(activeFrame.getExtendedState());
                mainFrame.setLocation(activeFrame.getLocation());
                mainFrame.setSize(activeFrame.getSize());
                activeFrame.setVisible(false);
                activeFrame.dispose();
            }
            
            if (!mainFrame.isVisible()) {
                mainFrame.setVisible(true);
            }
            
            mainFrame.revalidate();
            mainFrame.repaint();
        }
    }

    public static JFrame getCurrentFrame() {
        return mainFrame;
    }

    public static void setCurrentFrame(JFrame frame) {
        // Obsolete dengan arsitektur single-frame
    }

    public static void logout(JFrame activeFrame) {
        int confirm = JOptionPane.showConfirmDialog(
                mainFrame,
                "Apakah Anda yakin ingin logout?",
                "Konfirmasi Logout",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (confirm == JOptionPane.YES_OPTION) {
            if (mainFrame != null) {
                mainFrame.dispose();
            }
            disposeAll();
            SessionManager.logout();
            
            NewLoginView loginView = new NewLoginView();
            new NewLoginController(loginView, new AuthService());
            loginView.setVisible(true);
        }
    }

    public static void disposeAll() {
        if (dashboardView != null) { dashboardView.dispose(); dashboardView = null; }
        if (transaksiMasukView != null) { transaksiMasukView.dispose(); transaksiMasukView = null; }
        if (transaksiKeluarView != null) { transaksiKeluarView.dispose(); transaksiKeluarView = null; }
        if (kendaraanView != null) { kendaraanView.dispose(); kendaraanView = null; }
        if (petugasView != null) { petugasView.dispose(); petugasView = null; }
        if (userView != null) { userView.dispose(); userView = null; }
        if (laporanView != null) { laporanView.dispose(); laporanView = null; }
        if (mainFrame != null) { mainFrame.dispose(); mainFrame = null; }
    }

    public static NewDashboardView getDashboardView() { return dashboardView; }
    public static NewTransaksiMasukView getTransaksiMasukView() { return transaksiMasukView; }
    public static NewTransaksiKeluarView getTransaksiKeluarView() { return transaksiKeluarView; }
    public static NewKendaraanView getKendaraanView() { return kendaraanView; }
    public static NewPetugasView getPetugasView() { return petugasView; }
    public static NewUserView getUserView() { return userView; }
    public static NewLaporanView getLaporanView() { return laporanView; }
}
