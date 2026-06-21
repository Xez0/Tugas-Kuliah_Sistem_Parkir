package com.mycompany.tugasakhir.view;

import com.mycompany.tugasakhir.controller.*;
import com.mycompany.tugasakhir.service.AuthService;
import com.mycompany.tugasakhir.util.SessionManager;
import javax.swing.*;

/**
 * Router untuk mengelola transisi navigasi antar JFrame menu secara mulus dan konsisten.
 */
public class ViewRouter {
    private static NewDashboardView dashboardView;
    private static NewTransaksiMasukView transaksiMasukView;
    private static NewTransaksiKeluarView transaksiKeluarView;
    private static NewKendaraanView kendaraanView;
    private static NewTarifParkirView tarifParkirView;
    private static NewPetugasView petugasView;
    private static NewUserView userView;
    private static NewLaporanView laporanView;

    private static JFrame currentFrame;

    public static void initializeAllViews() {
        dashboardView = new NewDashboardView();
        transaksiMasukView = new NewTransaksiMasukView();
        transaksiKeluarView = new NewTransaksiKeluarView();
        kendaraanView = new NewKendaraanView();
        tarifParkirView = new NewTarifParkirView();
        petugasView = new NewPetugasView();
        userView = new NewUserView();
        laporanView = new NewLaporanView();

        // Register panels ke dashboardView contentArea (CardLayout)
        dashboardView.registerPanel("MASUK", transaksiMasukView.getTransaksiMasukPanel());
        dashboardView.registerPanel("KELUAR", transaksiKeluarView.getTransaksiKeluarPanel());
        dashboardView.registerPanel("KENDARAAN", kendaraanView.getKendaraanPanel());
        dashboardView.registerPanel("TARIF", tarifParkirView.getTarifParkirPanel());
        dashboardView.registerPanel("PETUGAS", petugasView.getPetugasPanel());
        dashboardView.registerPanel("USER", userView.getUserPanel());
        dashboardView.registerPanel("LAPORAN", laporanView.getLaporanPanel());

        // Inisialisasi controller versi baru
        new NewDashboardController(dashboardView.getDashboardPanel(), dashboardView);
        new NewTransaksiController(transaksiMasukView.getTransaksiMasukPanel(), transaksiKeluarView.getTransaksiKeluarPanel(), dashboardView);
        new KendaraanController(kendaraanView.getKendaraanPanel());
        new TarifParkirController(tarifParkirView.getTarifParkirPanel());
        new PetugasController(petugasView.getPetugasPanel());
        new UserController(userView.getUserPanel());
        new LaporanController(laporanView.getLaporanPanel());

        currentFrame = dashboardView;
    }

    public static void showView(String viewName, JFrame activeFrame) {
        if (dashboardView != null) {
            dashboardView.showCardOnDashboard(viewName);
            if (!dashboardView.isVisible()) {
                dashboardView.setVisible(true);
            }
            currentFrame = dashboardView;
        }
    }

    public static JFrame getCurrentFrame() {
        return currentFrame;
    }

    public static void setCurrentFrame(JFrame frame) {
        currentFrame = frame;
    }

    public static void logout(JFrame activeFrame) {
        int confirm = JOptionPane.showConfirmDialog(
                activeFrame,
                "Apakah Anda yakin ingin logout?",
                "Konfirmasi Logout",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (confirm == JOptionPane.YES_OPTION) {
            if (activeFrame != null) {
                activeFrame.dispose();
            }
            disposeAll();
            SessionManager.logout();
            
            // Buka kembali NewLoginView
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
        if (tarifParkirView != null) { tarifParkirView.dispose(); tarifParkirView = null; }
        if (petugasView != null) { petugasView.dispose(); petugasView = null; }
        if (userView != null) { userView.dispose(); userView = null; }
        if (laporanView != null) { laporanView.dispose(); laporanView = null; }
        currentFrame = null;
    }

    public static NewDashboardView getDashboardView() { return dashboardView; }
    public static NewTransaksiMasukView getTransaksiMasukView() { return transaksiMasukView; }
    public static NewTransaksiKeluarView getTransaksiKeluarView() { return transaksiKeluarView; }
    public static NewKendaraanView getKendaraanView() { return kendaraanView; }
    public static NewTarifParkirView getTarifParkirView() { return tarifParkirView; }
    public static NewPetugasView getPetugasView() { return petugasView; }
    public static NewUserView getUserView() { return userView; }
    public static NewLaporanView getLaporanView() { return laporanView; }
}
