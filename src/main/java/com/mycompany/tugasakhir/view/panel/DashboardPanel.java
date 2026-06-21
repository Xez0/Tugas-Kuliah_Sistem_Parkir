package com.mycompany.tugasakhir.view.panel;

import com.mycompany.tugasakhir.model.TransaksiParkir;
import com.mycompany.tugasakhir.util.CurrencyUtil;
import com.mycompany.tugasakhir.util.TableUtil;
import com.mycompany.tugasakhir.view.component.StatsCard;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Panel Dashboard utama.
 * Menampilkan kartu statistik ringkas dan tabel transaksi terbaru.
 */
public class DashboardPanel extends JPanel {

    private StatsCard cardActive;
    private StatsCard cardTodayTrans;
    private StatsCard cardTodayRev;
    private StatsCard cardPetugas;

    private JTable tblRecent;
    private DefaultTableModel tableModel;

    public DashboardPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(20, 20));
        setBackground(new Color(240, 242, 245)); // #f0f2f5
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ==========================================
        // TOP PANEL: Header Selamat Datang
        // ==========================================
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setOpaque(false);
        
        JLabel lblWelcome = new JLabel("Statistik Parkir Hari Ini");
        lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblWelcome.setForeground(new Color(26, 26, 46));
        headerPanel.add(lblWelcome);
        
        add(headerPanel, BorderLayout.NORTH);

        // ==========================================
        // CENTER PANEL: Kartu Statistik & Tabel
        // ==========================================
        JPanel centerPanel = new JPanel(new BorderLayout(20, 20));
        centerPanel.setOpaque(false);

        // Grid Kartu Statistik
        JPanel cardGrid = new JPanel(new GridLayout(1, 4, 15, 15));
        cardGrid.setOpaque(false);

        cardActive = new StatsCard(
                "Kendaraan Parkir", "0", com.mycompany.tugasakhir.util.VectorIcon.Type.KENDARAAN, 
                new Color(15, 52, 96), new Color(26, 26, 46)
        );
        cardTodayTrans = new StatsCard(
                "Transaksi Hari Ini", "0", com.mycompany.tugasakhir.util.VectorIcon.Type.LAPORAN, 
                new Color(233, 69, 96), new Color(180, 40, 70)
        );
        cardTodayRev = new StatsCard(
                "Pendapatan Hari Ini", "Rp 0", com.mycompany.tugasakhir.util.VectorIcon.Type.TARIF, 
                new Color(0, 184, 148), new Color(0, 150, 120)
        );
        cardPetugas = new StatsCard(
                "Total Petugas", "0", com.mycompany.tugasakhir.util.VectorIcon.Type.PETUGAS, 
                new Color(253, 203, 110), new Color(230, 160, 50)
        );

        cardGrid.add(cardActive);
        cardGrid.add(cardTodayTrans);
        cardGrid.add(cardTodayRev);
        cardGrid.add(cardPetugas);

        centerPanel.add(cardGrid, BorderLayout.NORTH);

        // Panel Tabel Transaksi Terbaru
        JPanel tablePanel = new JPanel(new BorderLayout(10, 10));
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        JLabel lblTableTitle = new JLabel("Transaksi Parkir Terkini");
        lblTableTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTableTitle.setForeground(new Color(26, 26, 46));
        tablePanel.add(lblTableTitle, BorderLayout.NORTH);

        String[] columns = {"ID", "Plat Nomor", "Jenis Kendaraan", "Jam Masuk", "Jam Keluar", "Total Biaya", "Status"};
        tableModel = TableUtil.createReadOnlyModel(columns);
        tblRecent = new JTable(tableModel);
        TableUtil.styleTable(tblRecent);

        // Center alignment for some columns
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblRecent.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblRecent.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblRecent.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblRecent.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tblRecent.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);

        // Right alignment for revenue
        javax.swing.table.DefaultTableCellRenderer rightRenderer = new javax.swing.table.DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tblRecent.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

        tablePanel.add(TableUtil.wrapInScrollPane(tblRecent), BorderLayout.CENTER);
        centerPanel.add(tablePanel, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);
    }

    public void updateStats(int activeVehicles, int todayTransactions, double todayRevenue, int totalPetugas) {
        cardActive.setValue(String.valueOf(activeVehicles));
        cardTodayTrans.setValue(String.valueOf(todayTransactions));
        cardTodayRev.setValue(CurrencyUtil.formatRupiah(todayRevenue));
        cardPetugas.setValue(String.valueOf(totalPetugas));
    }

    public void populateRecentTable(List<TransaksiParkir> list) {
        TableUtil.clearTable(tableModel);
        for (TransaksiParkir t : list) {
            String formatMasuk = t.getJamMasuk() != null ? t.getJamMasuk().toString() : "-";
            String formatKeluar = t.getJamKeluar() != null ? t.getJamKeluar().toString() : "-";
            String biaya = t.getStatus().equals("KELUAR") ? CurrencyUtil.formatRupiah(t.getTotalBiaya()) : "-";
            
            tableModel.addRow(new Object[]{
                    t.getIdTransaksi(),
                    t.getPlatNomor(),
                    t.getJenisKendaraan(),
                    formatMasuk,
                    formatKeluar,
                    biaya,
                    t.getStatus().toString()
            });
        }
    }
}
