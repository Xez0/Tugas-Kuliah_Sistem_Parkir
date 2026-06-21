package com.mycompany.tugasakhir.view.panel;

import com.mycompany.tugasakhir.model.TransaksiParkir;
import com.mycompany.tugasakhir.util.CurrencyUtil;
import com.mycompany.tugasakhir.util.TableUtil;
import com.mycompany.tugasakhir.view.component.RoundedButton;
import com.mycompany.tugasakhir.view.component.RoundedTextField;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.List;

/**
 * Panel Laporan Transaksi Parkir.
 * Memiliki filter tanggal, filter plat nomor, cetak laporan, dan ringkasan pendapatan.
 */
public class LaporanPanel extends JPanel {

    private JDateChooser dateStart;
    private JDateChooser dateEnd;
    private RoundedTextField txtSearchPlat;
    private RoundedButton btnFilter;
    private RoundedButton btnPrint;
    private RoundedButton btnReset;

    private JTable tblLaporan;
    private DefaultTableModel tableModel;

    private JLabel lblTotalTransactions;
    private JLabel lblTotalRevenue;

    public LaporanPanel() {
        initComponents();
        resetFilters();
    }

    private void initComponents() {
        setLayout(new BorderLayout(15, 15));
        setBackground(new Color(240, 242, 245));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setOpaque(false);
        JLabel lblTitle = new JLabel("Laporan Transaksi Parkir");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitle.setForeground(new Color(26, 26, 46));
        titlePanel.add(lblTitle);
        add(titlePanel, BorderLayout.NORTH);

        // ==========================================
        // TOP PANEL: Filter Controls
        // ==========================================
        JPanel filterCard = new JPanel(new GridBagLayout());
        filterCard.setBackground(Color.WHITE);
        filterCard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Start Date
        filterCard.add(new JLabel("Mulai Tanggal:"), gbc);
        gbc.gridx++;
        dateStart = new JDateChooser();
        dateStart.setDateFormatString("yyyy-MM-dd");
        dateStart.setPreferredSize(new Dimension(130, 32));
        filterCard.add(dateStart, gbc);

        // End Date
        gbc.gridx++;
        filterCard.add(new JLabel("Sampai Tanggal:"), gbc);
        gbc.gridx++;
        dateEnd = new JDateChooser();
        dateEnd.setDateFormatString("yyyy-MM-dd");
        dateEnd.setPreferredSize(new Dimension(130, 32));
        filterCard.add(dateEnd, gbc);

        // Search Plat
        gbc.gridx++;
        filterCard.add(new JLabel("Cari Plat:"), gbc);
        gbc.gridx++;
        txtSearchPlat = new RoundedTextField(10);
        txtSearchPlat.setPreferredSize(new Dimension(110, 32));
        filterCard.add(txtSearchPlat, gbc);

        // Buttons
        gbc.gridx++;
        btnFilter = new RoundedButton("FILTER", new Color(15, 52, 96), 8);
        btnFilter.setIcon(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.SEARCH, 13, Color.WHITE));
        btnFilter.setIconTextGap(5);
        btnFilter.setPreferredSize(new Dimension(95, 32));
        filterCard.add(btnFilter, gbc);

        gbc.gridx++;
        btnReset = new RoundedButton("RESET", new Color(99, 110, 115), 8);
        btnReset.setIcon(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.RESET, 13, Color.WHITE));
        btnReset.setIconTextGap(5);
        btnReset.setPreferredSize(new Dimension(95, 32));
        filterCard.add(btnReset, gbc);

        gbc.gridx++;
        btnPrint = new RoundedButton("PRINT", new Color(0, 184, 148), 8);
        btnPrint.setIcon(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.PRINT, 13, Color.WHITE));
        btnPrint.setIconTextGap(5);
        btnPrint.setPreferredSize(new Dimension(95, 32));
        filterCard.add(btnPrint, gbc);

        add(filterCard, BorderLayout.NORTH);

        // ==========================================
        // CENTER PANEL: Table
        // ==========================================
        JPanel tableCard = new JPanel(new BorderLayout());
        tableCard.setBackground(Color.WHITE);
        tableCard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        String[] columns = {"ID Transaksi", "Plat Nomor", "Jenis", "Jam Masuk", "Jam Keluar", "Durasi", "Biaya", "Petugas Keluar"};
        tableModel = TableUtil.createReadOnlyModel(columns);
        tblLaporan = new JTable(tableModel);
        TableUtil.styleTable(tblLaporan);

        // Center alignment for some columns
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblLaporan.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblLaporan.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblLaporan.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblLaporan.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tblLaporan.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tblLaporan.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);

        // Right alignment for cost
        javax.swing.table.DefaultTableCellRenderer rightRenderer = new javax.swing.table.DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tblLaporan.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);

        tableCard.add(TableUtil.wrapInScrollPane(tblLaporan), BorderLayout.CENTER);
        add(tableCard, BorderLayout.CENTER);

        // ==========================================
        // BOTTOM PANEL: Summary
        // ==========================================
        JPanel summaryPanel = new JPanel(new BorderLayout());
        summaryPanel.setOpaque(false);

        JPanel infoGrid = new JPanel(new GridLayout(1, 2, 20, 20));
        infoGrid.setOpaque(false);

        // Card 1: Total Transaksi
        JPanel transCard = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 15));
        transCard.setBackground(Color.WHITE);
        transCard.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        JLabel lblTransTitle = new JLabel("Total Transaksi Selesai:");
        lblTransTitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTotalTransactions = new JLabel("0");
        lblTotalTransactions.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTotalTransactions.setForeground(new Color(15, 52, 96));
        transCard.add(lblTransTitle);
        transCard.add(lblTotalTransactions);

        // Card 2: Total Pendapatan
        JPanel revCard = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 15));
        revCard.setBackground(Color.WHITE);
        revCard.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        JLabel lblRevTitle = new JLabel("Total Pendapatan Parkir:");
        lblRevTitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTotalRevenue = new JLabel("Rp 0");
        lblTotalRevenue.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTotalRevenue.setForeground(new Color(0, 184, 148));
        revCard.add(lblRevTitle);
        revCard.add(lblTotalRevenue);

        infoGrid.add(transCard);
        infoGrid.add(revCard);

        summaryPanel.add(infoGrid, BorderLayout.CENTER);
        add(summaryPanel, BorderLayout.SOUTH);
    }

    public void resetFilters() {
        // Default to showing today's reports
        Date today = new Date();
        dateStart.setDate(today);
        dateEnd.setDate(today);
        txtSearchPlat.setText("");
        lblTotalTransactions.setText("0");
        lblTotalRevenue.setText("Rp 0");
    }

    // Getters
    public Date getStartDate() {
        return dateStart.getDate();
    }

    public Date getEndDate() {
        return dateEnd.getDate();
    }

    public String getSearchPlat() {
        return txtSearchPlat.getText().trim().toUpperCase();
    }

    public JTable getTable() {
        return tblLaporan;
    }

    // Listeners
    public void addFilterListener(ActionListener l) {
        btnFilter.addActionListener(l);
        txtSearchPlat.addActionListener(l);
    }

    public void addResetListener(ActionListener l) {
        btnReset.addActionListener(l);
    }

    public void addPrintListener(ActionListener l) {
        btnPrint.addActionListener(l);
    }

    // Populate Table & update summary
    public void populateTable(List<TransaksiParkir> list) {
        TableUtil.clearTable(tableModel);
        int totalTrans = 0;
        double totalRev = 0;

        for (TransaksiParkir t : list) {
            String formatMasuk = t.getJamMasuk() != null ? t.getJamMasuk().toString() : "-";
            String formatKeluar = t.getJamKeluar() != null ? t.getJamKeluar().toString() : "-";
            String durasiStr = t.getStatus().equals("KELUAR") ? t.getDurasiJam() + " Jam" : "-";
            
            double biayaValue = t.getStatus().equals("KELUAR") ? t.getTotalBiaya() : 0.0;
            String biayaStr = CurrencyUtil.formatRupiah(biayaValue);
            
            tableModel.addRow(new Object[]{
                    t.getIdTransaksi(),
                    t.getPlatNomor(),
                    t.getJenisKendaraan(),
                    formatMasuk,
                    formatKeluar,
                    durasiStr,
                    biayaStr,
                    t.getNamaPetugasKeluar()
            });

            totalTrans++;
            totalRev += biayaValue;
        }

        lblTotalTransactions.setText(String.valueOf(totalTrans));
        lblTotalRevenue.setText(CurrencyUtil.formatRupiah(totalRev));
    }
}
