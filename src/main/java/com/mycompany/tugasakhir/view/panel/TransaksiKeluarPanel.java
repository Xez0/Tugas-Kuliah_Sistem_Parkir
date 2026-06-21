package com.mycompany.tugasakhir.view.panel;

import com.mycompany.tugasakhir.model.TransaksiParkir;
import com.mycompany.tugasakhir.util.CurrencyUtil;
import com.mycompany.tugasakhir.util.DateTimeUtil;
import com.mycompany.tugasakhir.view.component.RoundedButton;
import com.mycompany.tugasakhir.view.component.RoundedTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

/**
 * Panel Transaksi Keluar (Parkir Keluar).
 * Input plat nomor & pencarian di kiri, visual receipt / struk di kanan.
 */
public class TransaksiKeluarPanel extends JPanel {

    private RoundedTextField txtCariPlat;
    private RoundedButton btnCari;

    private RoundedTextField txtPlatNomor;
    private RoundedTextField txtJenis;
    private RoundedTextField txtJamMasuk;
    private RoundedTextField txtJamKeluar;
    private RoundedTextField txtDurasi;
    private RoundedTextField txtTotalBiaya;

    private RoundedButton btnProsesKeluar;
    private RoundedButton btnCetakStruk;
    private RoundedButton btnReset;

    private JTextArea txtStrukArea;

    private TransaksiParkir activeTransaksi;

    public TransaksiKeluarPanel() {
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
        JLabel lblTitle = new JLabel("Transaksi Parkir Keluar & Pembayaran");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitle.setForeground(new Color(26, 26, 46));
        titlePanel.add(lblTitle);
        add(titlePanel, BorderLayout.NORTH);

        // Content (Split Left & Right)
        JPanel contentPanel = new JPanel(new GridLayout(1, 2, 20, 20));
        contentPanel.setOpaque(false);

        // ==========================================
        // LEFT PANEL: Form Pencarian & Detail
        // ==========================================
        JPanel formCard = new JPanel(new GridBagLayout());
        formCard.setBackground(Color.WHITE);
        formCard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(4, 0, 4, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        // Search Section
        formCard.add(new JLabel("Cari Plat Nomor Aktif"), gbc);
        gbc.gridy++;
        JPanel searchBarPanel = new JPanel(new BorderLayout(5, 5));
        searchBarPanel.setOpaque(false);
        txtCariPlat = new RoundedTextField(15);
        txtCariPlat.setFont(new Font("Segoe UI", Font.BOLD, 16));
        txtCariPlat.setHorizontalAlignment(JTextField.CENTER);
        txtCariPlat.setPreferredSize(new Dimension(0, 38));
        btnCari = new RoundedButton("CARI", new Color(15, 52, 96), 8);
        btnCari.setIcon(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.SEARCH, 14, Color.WHITE));
        btnCari.setIconTextGap(6);
        btnCari.setPreferredSize(new Dimension(95, 38));
        searchBarPanel.add(txtCariPlat, BorderLayout.CENTER);
        searchBarPanel.add(btnCari, BorderLayout.EAST);
        formCard.add(searchBarPanel, gbc);

        // Separator
        gbc.gridy++;
        gbc.insets = new Insets(10, 0, 10, 0);
        formCard.add(new JSeparator(JSeparator.HORIZONTAL), gbc);

        // Detail Fields (Read-Only)
        gbc.insets = new Insets(3, 0, 3, 0);
        gbc.gridy++;
        formCard.add(new JLabel("Plat Nomor"), gbc);
        gbc.gridy++;
        txtPlatNomor = new RoundedTextField(20);
        txtPlatNomor.setEnabled(false);
        txtPlatNomor.setPreferredSize(new Dimension(0, 32));
        formCard.add(txtPlatNomor, gbc);

        gbc.gridy++;
        formCard.add(new JLabel("Jenis Kendaraan"), gbc);
        gbc.gridy++;
        txtJenis = new RoundedTextField(20);
        txtJenis.setEnabled(false);
        txtJenis.setPreferredSize(new Dimension(0, 32));
        formCard.add(txtJenis, gbc);

        gbc.gridy++;
        formCard.add(new JLabel("Jam Masuk"), gbc);
        gbc.gridy++;
        txtJamMasuk = new RoundedTextField(20);
        txtJamMasuk.setEnabled(false);
        txtJamMasuk.setPreferredSize(new Dimension(0, 32));
        formCard.add(txtJamMasuk, gbc);

        gbc.gridy++;
        formCard.add(new JLabel("Jam Keluar (Sekarang)"), gbc);
        gbc.gridy++;
        txtJamKeluar = new RoundedTextField(20);
        txtJamKeluar.setEnabled(false);
        txtJamKeluar.setPreferredSize(new Dimension(0, 32));
        formCard.add(txtJamKeluar, gbc);

        gbc.gridy++;
        formCard.add(new JLabel("Durasi Parkir (Ceiling Jam)"), gbc);
        gbc.gridy++;
        txtDurasi = new RoundedTextField(20);
        txtDurasi.setEnabled(false);
        txtDurasi.setPreferredSize(new Dimension(0, 32));
        formCard.add(txtDurasi, gbc);

        gbc.gridy++;
        formCard.add(new JLabel("Total Biaya Parkir"), gbc);
        gbc.gridy++;
        txtTotalBiaya = new RoundedTextField(20);
        txtTotalBiaya.setEnabled(false);
        txtTotalBiaya.setFont(new Font("Segoe UI", Font.BOLD, 16));
        txtTotalBiaya.setForeground(new Color(233, 69, 96));
        txtTotalBiaya.setPreferredSize(new Dimension(0, 35));
        formCard.add(txtTotalBiaya, gbc);

        // Spacer
        gbc.gridy++;
        gbc.weighty = 1.0;
        formCard.add(Box.createVerticalGlue(), gbc);

        // Buttons
        gbc.gridy++;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(15, 0, 5, 0);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        buttonPanel.setOpaque(false);

        btnProsesKeluar = new RoundedButton("PROSES", new Color(0, 184, 148), 8);
        btnProsesKeluar.setIcon(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.SAVE, 15, Color.WHITE));
        btnProsesKeluar.setIconTextGap(6);

        btnCetakStruk = new RoundedButton("STRUK", new Color(253, 203, 110), 8);
        btnCetakStruk.setIcon(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.PRINT, 15, new Color(45, 52, 54)));
        btnCetakStruk.setIconTextGap(6);
        btnCetakStruk.setForeground(new Color(45, 52, 54));

        btnReset = new RoundedButton("BATAL", new Color(99, 110, 115), 8);
        btnReset.setIcon(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.RESET, 15, Color.WHITE));
        btnReset.setIconTextGap(6);

        buttonPanel.add(btnProsesKeluar);
        buttonPanel.add(btnCetakStruk);
        buttonPanel.add(btnReset);
        formCard.add(buttonPanel, gbc);

        contentPanel.add(formCard);

        // ==========================================
        // RIGHT PANEL: Receipt Mockup (Struk Area)
        // ==========================================
        JPanel receiptCard = new JPanel(new BorderLayout(10, 10));
        receiptCard.setBackground(new Color(45, 52, 54)); // dark background for terminal/receipt feel
        receiptCard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        JLabel lblReceiptHeader = new JLabel("Preview Struk Pembayaran", SwingConstants.CENTER);
        lblReceiptHeader.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblReceiptHeader.setForeground(Color.WHITE);
        receiptCard.add(lblReceiptHeader, BorderLayout.NORTH);

        txtStrukArea = new JTextArea();
        txtStrukArea.setEditable(false);
        txtStrukArea.setBackground(new Color(255, 255, 240)); // light warm yellow receipt color
        txtStrukArea.setFont(new Font("Courier New", Font.PLAIN, 13));
        txtStrukArea.setForeground(Color.BLACK);
        txtStrukArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 150), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        JScrollPane receiptScroll = new JScrollPane(txtStrukArea);
        receiptScroll.setBorder(null);
        receiptCard.add(receiptScroll, BorderLayout.CENTER);

        contentPanel.add(receiptCard);

        add(contentPanel, BorderLayout.CENTER);
    }

    public void resetForm() {
        txtCariPlat.setText("");
        txtCariPlat.setEnabled(true);
        btnCari.setEnabled(true);

        txtPlatNomor.setText("");
        txtJenis.setText("");
        txtJamMasuk.setText("");
        txtJamKeluar.setText("");
        txtDurasi.setText("");
        txtTotalBiaya.setText("");

        btnProsesKeluar.setEnabled(false);
        btnCetakStruk.setEnabled(false);
        activeTransaksi = null;

        txtStrukArea.setText("\n\n       BELUM ADA DATA TRANSAKSI.\n"
                + "  Silakan cari plat nomor di sebelah kiri.");
        txtCariPlat.requestFocus();
    }

    public void setTransaksiData(TransaksiParkir t) {
        this.activeTransaksi = t;
        txtPlatNomor.setText(t.getPlatNomor());
        txtJenis.setText(t.getJenisKendaraan());
        txtJamMasuk.setText(t.getJamMasuk().toString());
        
        // Use DateTimeUtil format helper
        LocalDateTime now = LocalDateTime.now();
        txtJamKeluar.setText(DateTimeUtil.formatDisplay(now));
        
        // Calculate duration and price details
        int durasi = DateTimeUtil.hitungDurasiJam(t.getJamMasuk(), now);
        txtDurasi.setText(durasi + " Jam");

        btnProsesKeluar.setEnabled(true);
        btnCetakStruk.setEnabled(false); // Enable after successful check-out save
    }

    public void setTotalBiaya(double biaya) {
        txtTotalBiaya.setText(CurrencyUtil.formatRupiah(biaya));
    }

    public void showStruk(String strukText) {
        txtStrukArea.setText(strukText);
        btnCetakStruk.setEnabled(true); // Struk is ready to print
        btnProsesKeluar.setEnabled(false); // Already processed
        txtCariPlat.setEnabled(false);
        btnCari.setEnabled(false);
    }

    // Input getters
    public String getCariPlatInput() {
        return txtCariPlat.getText().trim().toUpperCase();
    }

    public TransaksiParkir getActiveTransaksi() {
        return activeTransaksi;
    }

    public JTextArea getStrukArea() {
        return txtStrukArea;
    }

    // Demo Expose
    public RoundedTextField getTxtCariPlat() { return txtCariPlat; }
    public RoundedButton getBtnCari() { return btnCari; }
    public RoundedButton getBtnProsesKeluar() { return btnProsesKeluar; }
    public RoundedButton getBtnCetakStruk() { return btnCetakStruk; }

    // Actions
    public void addCariListener(ActionListener l) {
        btnCari.addActionListener(l);
        txtCariPlat.addActionListener(l);
    }

    public void addProsesKeluarListener(ActionListener l) {
        btnProsesKeluar.addActionListener(l);
    }

    public void addCetakStrukListener(ActionListener l) {
        btnCetakStruk.addActionListener(l);
    }

    public void addResetListener(ActionListener l) {
        btnReset.addActionListener(l);
    }
}
