package com.mycompany.tugasakhir.view.panel;

import com.mycompany.tugasakhir.model.Kendaraan;
import com.mycompany.tugasakhir.model.TransaksiParkir;
import com.mycompany.tugasakhir.util.TableUtil;
import com.mycompany.tugasakhir.view.component.RoundedButton;
import com.mycompany.tugasakhir.view.component.RoundedTextField;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Panel Transaksi Masuk (Parkir Masuk).
 * Form input plat nomor & jenis kendaraan di kiri, tabel kendaraan aktif parkir di kanan.
 */
public class TransaksiMasukPanel extends JPanel {

    private RoundedTextField txtPlatNomor;
    private JComboBox<Kendaraan> cbJenisKendaraan;
    private RoundedButton btnProses;
    private RoundedButton btnReset;

    private JTable tblActiveParking;
    private DefaultTableModel tableModel;

    public TransaksiMasukPanel() {
        initComponents();
        resetForm();
    }

    private void initComponents() {
        setLayout(new BorderLayout(15, 15));
        setBackground(new Color(240, 242, 245));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setOpaque(false);
        JLabel lblTitle = new JLabel("Transaksi Parkir Masuk");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitle.setForeground(new Color(26, 26, 46));
        titlePanel.add(lblTitle);
        add(titlePanel, BorderLayout.NORTH);

        // Side-by-side Layout
        JPanel contentPanel = new JPanel(new BorderLayout(15, 15));
        contentPanel.setOpaque(false);

        // ==========================================
        // FORM PANEL (LEFT)
        // ==========================================
        JPanel formCard = new JPanel(new GridBagLayout());
        formCard.setBackground(Color.WHITE);
        formCard.setPreferredSize(new Dimension(320, getPreferredSize().height));
        formCard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(8, 0, 8, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        // Info Banner
        JLabel lblBanner = new JLabel("Entry Parkir Baru", SwingConstants.CENTER);
        lblBanner.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblBanner.setForeground(new Color(15, 52, 96));
        formCard.add(lblBanner, gbc);

        // Plat Nomor
        gbc.gridy++;
        gbc.insets = new Insets(15, 0, 5, 0);
        formCard.add(new JLabel("Plat Nomor Kendaraan"), gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 10, 0);
        txtPlatNomor = new RoundedTextField(20);
        txtPlatNomor.setFont(new Font("Segoe UI", Font.BOLD, 18));
        txtPlatNomor.setHorizontalAlignment(JTextField.CENTER);
        txtPlatNomor.setPreferredSize(new Dimension(0, 42));
        formCard.add(txtPlatNomor, gbc);

        // Jenis Kendaraan
        gbc.gridy++;
        gbc.insets = new Insets(10, 0, 5, 0);
        formCard.add(new JLabel("Jenis Kendaraan"), gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 10, 0);
        cbJenisKendaraan = new JComboBox<>();
        cbJenisKendaraan.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cbJenisKendaraan.setPreferredSize(new Dimension(0, 38));
        formCard.add(cbJenisKendaraan, gbc);

        // Spacer
        gbc.gridy++;
        gbc.weighty = 1.0;
        formCard.add(Box.createVerticalGlue(), gbc);

        // Control Buttons
        gbc.gridy++;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(20, 0, 5, 0);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 8, 8));
        buttonPanel.setOpaque(false);

        btnProses = new RoundedButton("MASUK", new Color(0, 184, 148), 8);
        btnProses.setIcon(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.SAVE, 16, Color.WHITE));
        btnProses.setIconTextGap(8);
        btnProses.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnProses.setPreferredSize(new Dimension(0, 42));

        btnReset = new RoundedButton("RESET", new Color(99, 110, 115), 8);
        btnReset.setIcon(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.RESET, 16, Color.WHITE));
        btnReset.setIconTextGap(8);
        btnReset.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnReset.setPreferredSize(new Dimension(0, 42));

        buttonPanel.add(btnProses);
        buttonPanel.add(btnReset);
        formCard.add(buttonPanel, gbc);

        contentPanel.add(formCard, BorderLayout.WEST);

        // ==========================================
        // TABLE PANEL (RIGHT)
        // ==========================================
        JPanel tableCard = new JPanel(new BorderLayout(10, 10));
        tableCard.setBackground(Color.WHITE);
        tableCard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        JLabel lblTableTitle = new JLabel("Kendaraan yang Sedang Parkir");
        lblTableTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTableTitle.setForeground(new Color(26, 26, 46));
        tableCard.add(lblTableTitle, BorderLayout.NORTH);

        String[] columns = {"ID Transaksi", "Plat Nomor", "Jenis", "Jam Masuk", "Petugas Masuk"};
        tableModel = TableUtil.createReadOnlyModel(columns);
        tblActiveParking = new JTable(tableModel);
        TableUtil.styleTable(tblActiveParking);

        // Center alignment for some columns
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblActiveParking.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblActiveParking.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblActiveParking.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblActiveParking.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        tableCard.add(TableUtil.wrapInScrollPane(tblActiveParking), BorderLayout.CENTER);
        contentPanel.add(tableCard, BorderLayout.CENTER);

        add(contentPanel, BorderLayout.CENTER);
    }

    public void setJenisKendaraanList(List<Kendaraan> list) {
        cbJenisKendaraan.removeAllItems();
        for (Kendaraan k : list) {
            cbJenisKendaraan.addItem(k);
        }
    }

    public void resetForm() {
        txtPlatNomor.setText("");
        if (cbJenisKendaraan.getItemCount() > 0) {
            cbJenisKendaraan.setSelectedIndex(0);
        }
        txtPlatNomor.requestFocus();
    }

    // Getters
    public String getPlatNomorInput() {
        return txtPlatNomor.getText().trim().toUpperCase();
    }

    public Kendaraan getSelectedKendaraan() {
        return (Kendaraan) cbJenisKendaraan.getSelectedItem();
    }

    // Demo Expose
    public JTextField getTxtPlatNomor() { return txtPlatNomor; }
    public JComboBox<Kendaraan> getCbJenisKendaraan() { return cbJenisKendaraan; }
    public JButton getBtnProses() { return btnProses; }

    // Listeners
    public void addProsesListener(ActionListener l) {
        btnProses.addActionListener(l);
        txtPlatNomor.addActionListener(l); // Trigger on enter key
    }

    public void addResetListener(ActionListener l) {
        btnReset.addActionListener(l);
    }

    // Populate active transactions
    public void populateActiveParkingTable(List<TransaksiParkir> list) {
        TableUtil.clearTable(tableModel);
        for (TransaksiParkir t : list) {
            String formatMasuk = t.getJamMasuk() != null ? t.getJamMasuk().toString() : "-";
            tableModel.addRow(new Object[]{
                    t.getIdTransaksi(),
                    t.getPlatNomor(),
                    t.getJenisKendaraan(),
                    formatMasuk,
                    t.getNamaPetugasMasuk()
            });
        }
    }
}
