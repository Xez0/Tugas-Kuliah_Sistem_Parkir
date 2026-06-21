package com.mycompany.tugasakhir.controller;

import com.mycompany.tugasakhir.model.TransaksiParkir;
import com.mycompany.tugasakhir.service.PetugasService;
import com.mycompany.tugasakhir.service.TransaksiParkirService;
import com.mycompany.tugasakhir.view.NewDashboardView;

import javax.swing.*;
import java.util.List;

/**
 * Controller untuk Dashboard Panel pada NewDashboardView.
 */
public class NewDashboardController {

    private final NewDashboardView view;
    private final TransaksiParkirService transaksiService;
    private final PetugasService petugasService;
    private Timer refreshTimer;

    public NewDashboardController(NewDashboardView view) {
        this.view = view;
        this.transaksiService = new TransaksiParkirService();
        this.petugasService = new PetugasService();

        // Initial load
        refreshData();

        // Setup auto refresh timer tiap 5 detik
        refreshTimer = new Timer(5000, e -> {
            if (view.isShowing()) {
                refreshData();
            }
        });
        refreshTimer.start();
    }

    public void refreshData() {
        int activeVehicles = transaksiService.countActiveParking();
        int todayTransactions = transaksiService.countTodayTransactions();
        double todayRevenue = transaksiService.getTodayRevenue();
        int totalPetugas = petugasService.countAll();

        view.updateStats(activeVehicles, todayTransactions, todayRevenue, totalPetugas);

        List<TransaksiParkir> allTransactions = transaksiService.getAll();
        int limit = Math.min(allTransactions.size(), 10);
        List<TransaksiParkir> recentTransactions = allTransactions.subList(0, limit);
        
        view.populateRecentTable(recentTransactions);
    }
}
