package com.mycompany.tugasakhir.view;

import com.mycompany.tugasakhir.util.SessionManager;
import com.mycompany.tugasakhir.util.VectorIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;


/**
 * JFrame Form untuk NewTransaksiKeluarView.
 */
public class NewTransaksiKeluarView extends javax.swing.JFrame {

    private final Map<String, JButton> navButtons = new HashMap<>();
    private JMenuItem menuLogout;
    private JMenu menuMasterData;
    private JMenu menuLaporan;
    
    private com.mycompany.tugasakhir.model.TransaksiParkir activeTransaksi;

    // UI elements declared in form
    private javax.swing.JLabel lblSearchTitle;
    private javax.swing.JPanel searchBarPanel;
    private javax.swing.JTextField txtCariPlat;
    private javax.swing.JButton btnCari;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblPlat;
    private javax.swing.JTextField txtPlatNomor;
    private javax.swing.JLabel lblJenis;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JLabel lblJamMasuk;
    private javax.swing.JTextField txtJamMasuk;
    private javax.swing.JLabel lblJamKeluar;
    private javax.swing.JTextField txtJamKeluar;
    private javax.swing.JLabel lblDurasi;
    private javax.swing.JTextField txtDurasi;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTextField txtTotalBiaya;
    private javax.swing.Box.Filler formSpacer;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton btnProsesKeluar;
    private javax.swing.JButton btnCetakStruk;
    private javax.swing.JButton btnReset;
    private javax.swing.JPanel formCard;
    private javax.swing.JPanel receiptCard;
    private javax.swing.JLabel lblReceiptHeader;
    private javax.swing.JScrollPane receiptScroll;
    private javax.swing.JTextArea txtStrukArea;
    private javax.swing.JPanel mainSplitPanel;
    private javax.swing.JPanel titlePanel;

    // delegation methods
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
        txtStrukArea.setText("\n\n       BELUM ADA DATA TRANSAKSI.\n  Silakan cari plat nomor di sebelah kiri.");
        txtCariPlat.requestFocus();
    }

    public void setTransaksiData(com.mycompany.tugasakhir.model.TransaksiParkir t) {
        this.activeTransaksi = t;
        txtPlatNomor.setText(t.getPlatNomor());
        txtJenis.setText(t.getJenisKendaraan());
        txtJamMasuk.setText(t.getJamMasuk().toString());
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        txtJamKeluar.setText(com.mycompany.tugasakhir.util.DateTimeUtil.formatDisplay(now));
        int durasi = com.mycompany.tugasakhir.util.DateTimeUtil.hitungDurasiJam(t.getJamMasuk(), now);
        txtDurasi.setText(durasi + " Jam");
        btnProsesKeluar.setEnabled(true);
        btnCetakStruk.setEnabled(false);
    }

    public void setTotalBiaya(double biaya) {
        txtTotalBiaya.setText(com.mycompany.tugasakhir.util.CurrencyUtil.formatRupiah(biaya));
    }

    public void showStruk(String strukText) {
        txtStrukArea.setText(strukText);
        btnCetakStruk.setEnabled(true);
        btnProsesKeluar.setEnabled(false);
        txtCariPlat.setEnabled(false);
        btnCari.setEnabled(false);
    }

    public String getCariPlatInput() { return txtCariPlat.getText().trim().toUpperCase(); }
    public com.mycompany.tugasakhir.model.TransaksiParkir getActiveTransaksi() { return activeTransaksi; }
    public JTextArea getStrukArea() { return txtStrukArea; }
    public JTextField getTxtCariPlat() { return txtCariPlat; }
    public JButton getBtnCari() { return btnCari; }
    public JButton getBtnProsesKeluar() { return btnProsesKeluar; }
    public JButton getBtnCetakStruk() { return btnCetakStruk; }

    public void addCariListener(ActionListener l) {
        btnCari.addActionListener(l);
        txtCariPlat.addActionListener(l);
    }
    public void addProsesKeluarListener(ActionListener l) { btnProsesKeluar.addActionListener(l); }
    public void addCetakStrukListener(ActionListener l) { btnCetakStruk.addActionListener(l); }
    public void addResetListener(ActionListener l) { btnReset.addActionListener(l); }


    public NewTransaksiKeluarView() {
        initComponents();
        setupAccessControl();
        initNavButtonStyles();
        setActiveNavVisual("KELUAR");
        buildMenuBar();
        customInit();
        
        setMinimumSize(new Dimension(1150, 700));
        setSize(1200, 750);
        setLocationRelativeTo(null);
    }

    private void customInit() {
        
        // Set colors and design
        btnCari.setBackground(new Color(15, 52, 96));
        btnCari.setForeground(Color.WHITE);
        btnCari.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnCari.setIcon(new VectorIcon(VectorIcon.Type.SEARCH, 14, Color.WHITE));
        
        btnProsesKeluar.setBackground(new Color(0, 184, 148));
        btnProsesKeluar.setForeground(Color.WHITE);
        btnProsesKeluar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnProsesKeluar.setIcon(new VectorIcon(VectorIcon.Type.SAVE, 15, Color.WHITE));

        btnCetakStruk.setBackground(new Color(253, 203, 110));
        btnCetakStruk.setForeground(new Color(45, 52, 54));
        btnCetakStruk.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnCetakStruk.setIcon(new VectorIcon(VectorIcon.Type.PRINT, 15, new Color(45, 52, 54)));

        btnReset.setBackground(new Color(99, 110, 115));
        btnReset.setForeground(Color.WHITE);
        btnReset.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnReset.setIcon(new VectorIcon(VectorIcon.Type.RESET, 15, Color.WHITE));

        txtTotalBiaya.setForeground(new Color(233, 69, 96));
        txtStrukArea.setBackground(new Color(255, 255, 240));
        txtStrukArea.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        receiptScroll.setBorder(null);

    }

    private void initNavButtonStyles() {
        JButton[] buttons = {btnDashboard, btnMasuk, btnKeluar, btnKendaraan, btnTarif, btnPetugas, btnUser, btnLaporan, btnLogout};
        Color defaultBg = new Color(26, 26, 46);
        Color defaultFg = new Color(200, 200, 200);
        
        for (JButton btn : buttons) {
            btn.setBackground(defaultBg);
            btn.setForeground(defaultFg);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);
            btn.setContentAreaFilled(true);
            btn.setOpaque(true);
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        
        btnLogout.setBackground(new Color(233, 69, 96));
        btnLogout.setForeground(Color.WHITE);
    }

    private void setActiveNavVisual(String activeCard) {
        Color defaultBg = new Color(26, 26, 46);
        Color defaultFg = new Color(200, 200, 200);
        Color activeBg = new Color(15, 52, 96);
        Color activeFg = Color.WHITE;
        
        JButton[] buttons = {btnDashboard, btnMasuk, btnKeluar, btnKendaraan, btnTarif, btnPetugas, btnUser, btnLaporan};
        String[] cards = {"DASHBOARD", "MASUK", "KELUAR", "KENDARAAN", "TARIF", "PETUGAS", "USER", "LAPORAN"};
        
        for (int i = 0; i < buttons.length; i++) {
            if (cards[i].equals(activeCard)) {
                buttons[i].setBackground(activeBg);
                buttons[i].setForeground(activeFg);
                buttons[i].setIcon(new VectorIcon(VectorIcon.Type.valueOf(cards[i]), 18, activeFg));
            } else {
                buttons[i].setBackground(defaultBg);
                buttons[i].setForeground(defaultFg);
                buttons[i].setIcon(new VectorIcon(VectorIcon.Type.valueOf(cards[i]), 18, defaultFg));
            }
        }
        btnLogout.setIcon(new VectorIcon(VectorIcon.Type.LOGOUT, 18, Color.WHITE));
        
        btnDashboard.addActionListener(e -> showCard("DASHBOARD"));
        btnMasuk.addActionListener(e -> showCard("MASUK"));
        btnKeluar.addActionListener(e -> showCard("KELUAR"));
        btnKendaraan.addActionListener(e -> showCard("KENDARAAN"));
        btnTarif.addActionListener(e -> showCard("TARIF"));
        btnPetugas.addActionListener(e -> showCard("PETUGAS"));
        btnUser.addActionListener(e -> showCard("USER"));
        btnLaporan.addActionListener(e -> showCard("LAPORAN"));
        btnLogout.addActionListener(e -> ViewRouter.logout(this));
    }

    private void buildMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuMasterData = new JMenu("Master Data");
        JMenuItem itemKendaraan = new JMenuItem("Kendaraan");
        itemKendaraan.addActionListener(e -> showCard("KENDARAAN"));
        JMenuItem itemTarif = new JMenuItem("Tarif Parkir");
        itemTarif.addActionListener(e -> showCard("TARIF"));
        JMenuItem itemPetugas = new JMenuItem("Petugas");
        itemPetugas.addActionListener(e -> showCard("PETUGAS"));
        JMenuItem itemUser = new JMenuItem("User");
        itemUser.addActionListener(e -> showCard("USER"));
        menuMasterData.add(itemKendaraan);
        menuMasterData.add(itemTarif);
        menuMasterData.add(itemPetugas);
        menuMasterData.add(itemUser);

        JMenu menuTransaksi = new JMenu("Transaksi");
        JMenuItem itemMasuk = new JMenuItem("Parkir Masuk");
        itemMasuk.addActionListener(e -> showCard("MASUK"));
        JMenuItem itemKeluar = new JMenuItem("Parkir Keluar");
        itemKeluar.addActionListener(e -> showCard("KELUAR"));
        menuTransaksi.add(itemMasuk);
        menuTransaksi.add(itemKeluar);

        menuLaporan = new JMenu("Laporan");
        JMenuItem itemLap = new JMenuItem("Laporan Transaksi");
        itemLap.addActionListener(e -> showCard("LAPORAN"));
        menuLaporan.add(itemLap);

        JMenu menuSistem = new JMenu("Sistem");
        menuLogout = new JMenuItem("Logout");
        menuLogout.addActionListener(e -> ViewRouter.logout(this));
        JMenuItem itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(e -> System.exit(0));
        menuSistem.add(menuLogout);
        menuSistem.addSeparator();
        menuSistem.add(itemExit);

        menuBar.add(menuMasterData);
        menuBar.add(menuTransaksi);
        menuBar.add(menuLaporan);
        menuBar.add(menuSistem);
        setJMenuBar(menuBar);
    }

    private void setupAccessControl() {
        String role = SessionManager.getCurrentRole();
        if ("OPERATOR".equalsIgnoreCase(role)) {
            btnKendaraan.setVisible(false);
            btnTarif.setVisible(false);
            btnPetugas.setVisible(false);
            btnUser.setVisible(false);
            btnLaporan.setVisible(false);
            menuMasterData.setVisible(false);
            menuLaporan.setVisible(false);
        }
        headerPanel.setBackground(new Color(15, 52, 96));
        lblUser.setText(SessionManager.getCurrentUsername() + " (" + role + ")");
        Timer clockTimer = new Timer(1000, e -> {
            java.time.LocalDateTime now = java.time.LocalDateTime.now();
            lblClock.setText(now.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        });
        clockTimer.start();
    }

    public void showCard(String cardName) {
        ViewRouter.showView(cardName, this);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        headerPanel = new javax.swing.JPanel();
        lblHeaderTitle = new javax.swing.JLabel();
        headerRightPanel = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblClock = new javax.swing.JLabel();
        sidebarPanel = new javax.swing.JPanel();
        lblAppTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnDashboard = new javax.swing.JButton();
        btnMasuk = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnKendaraan = new javax.swing.JButton();
        btnTarif = new javax.swing.JButton();
        btnPetugas = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnLaporan = new javax.swing.JButton();
        boxSpacer = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        btnLogout = new javax.swing.JButton();
        contentArea = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Parkir Desktop - Parkir Keluar");
        setMinimumSize(new java.awt.Dimension(1150, 700));

        headerPanel.setBackground(new java.awt.Color(15, 52, 96));
        headerPanel.setPreferredSize(new java.awt.Dimension(0, 55));
        headerPanel.setLayout(new java.awt.BorderLayout());

        lblHeaderTitle.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblHeaderTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblHeaderTitle.setText("Sistem Parkir Modern");
        lblHeaderTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0));
        headerPanel.add(lblHeaderTitle, java.awt.BorderLayout.WEST);

        headerRightPanel.setOpaque(false);
        headerRightPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 20, 15));

        lblUser.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblUser.setForeground(new java.awt.Color(200, 200, 200));
        lblUser.setText("User (Role)");
        headerRightPanel.add(lblUser);

        lblClock.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblClock.setForeground(new java.awt.Color(200, 200, 200));
        lblClock.setText("Clock");
        headerRightPanel.add(lblClock);

        headerPanel.add(headerRightPanel, java.awt.BorderLayout.EAST);

        getContentPane().add(headerPanel, java.awt.BorderLayout.NORTH);

        sidebarPanel.setBackground(new java.awt.Color(26, 26, 46));
        sidebarPanel.setPreferredSize(new java.awt.Dimension(240, 0));
        sidebarPanel.setLayout(new java.awt.GridBagLayout());

        lblAppTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblAppTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblAppTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAppTitle.setText(" PARKIRKU");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        sidebarPanel.add(lblAppTitle, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(jSeparator1, gridBagConstraints);

        btnDashboard.setText("Dashboard");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(btnDashboard, gridBagConstraints);

        btnMasuk.setText("Parkir Masuk");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(btnMasuk, gridBagConstraints);

        btnKeluar.setText("Parkir Keluar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(btnKeluar, gridBagConstraints);

        btnKendaraan.setText("Kelola Kendaraan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(btnKendaraan, gridBagConstraints);

        btnTarif.setText("Kelola Tarif");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(btnTarif, gridBagConstraints);

        btnPetugas.setText("Kelola Petugas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(btnPetugas, gridBagConstraints);

        btnUser.setText("Kelola User");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(btnUser, gridBagConstraints);

        btnLaporan.setText("Laporan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(btnLaporan, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        sidebarPanel.add(boxSpacer, gridBagConstraints);

        btnLogout.setBackground(new java.awt.Color(233, 69, 96));
        btnLogout.setText("Keluar (Logout)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 20, 0);
        sidebarPanel.add(btnLogout, gridBagConstraints);

        getContentPane().add(sidebarPanel, java.awt.BorderLayout.WEST);

        contentArea.setBackground(new java.awt.Color(240, 242, 245));
        contentArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentArea.setLayout(new java.awt.BorderLayout());

        
        titlePanel = new javax.swing.JPanel();
        lblContentTitle = new javax.swing.JLabel();
        mainSplitPanel = new javax.swing.JPanel();
        formCard = new javax.swing.JPanel();
        lblSearchTitle = new javax.swing.JLabel();
        searchBarPanel = new javax.swing.JPanel();
        txtCariPlat = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        lblPlat = new javax.swing.JLabel();
        txtPlatNomor = new javax.swing.JTextField();
        lblJenis = new javax.swing.JLabel();
        txtJenis = new javax.swing.JTextField();
        lblJamMasuk = new javax.swing.JLabel();
        txtJamMasuk = new javax.swing.JTextField();
        lblJamKeluar = new javax.swing.JLabel();
        txtJamKeluar = new javax.swing.JTextField();
        lblDurasi = new javax.swing.JLabel();
        txtDurasi = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        txtTotalBiaya = new javax.swing.JTextField();
        formSpacer = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        buttonPanel = new javax.swing.JPanel();
        btnProsesKeluar = new javax.swing.JButton();
        btnCetakStruk = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        receiptCard = new javax.swing.JPanel();
        lblReceiptHeader = new javax.swing.JLabel();
        receiptScroll = new javax.swing.JScrollPane();
        txtStrukArea = new javax.swing.JTextArea();

        titlePanel.setOpaque(false);
        titlePanel.setPreferredSize(new java.awt.Dimension(0, 40));
        titlePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        lblContentTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblContentTitle.setForeground(new java.awt.Color(26, 26, 46));
        lblContentTitle.setText("Transaksi Parkir Keluar & Pembayaran");
        titlePanel.add(lblContentTitle);

        contentArea.add(titlePanel, java.awt.BorderLayout.NORTH);

        mainSplitPanel.setOpaque(false);
        mainSplitPanel.setLayout(new java.awt.GridLayout(1, 2, 20, 20));

        formCard.setBackground(new java.awt.Color(255, 255, 255));
        formCard.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)), javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        formCard.setLayout(new java.awt.GridBagLayout());

        lblSearchTitle.setText("Cari Plat Nomor Aktif");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        formCard.add(lblSearchTitle, gridBagConstraints);

        searchBarPanel.setOpaque(false);
        searchBarPanel.setLayout(new java.awt.BorderLayout(5, 5));

        txtCariPlat.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtCariPlat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCariPlat.setPreferredSize(new java.awt.Dimension(0, 38));
        searchBarPanel.add(txtCariPlat, java.awt.BorderLayout.CENTER);

        btnCari.setText("CARI");
        btnCari.setPreferredSize(new java.awt.Dimension(95, 38));
        searchBarPanel.add(btnCari, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        formCard.add(searchBarPanel, gridBagConstraints);
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        formCard.add(jSeparator2, gridBagConstraints);

        lblPlat.setText("Plat Nomor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        formCard.add(lblPlat, gridBagConstraints);

        txtPlatNomor.setEnabled(false);
        txtPlatNomor.setPreferredSize(new java.awt.Dimension(0, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        formCard.add(txtPlatNomor, gridBagConstraints);

        lblJenis.setText("Jenis Kendaraan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        formCard.add(lblJenis, gridBagConstraints);

        txtJenis.setEnabled(false);
        txtJenis.setPreferredSize(new java.awt.Dimension(0, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        formCard.add(txtJenis, gridBagConstraints);

        lblJamMasuk.setText("Jam Masuk");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        formCard.add(lblJamMasuk, gridBagConstraints);

        txtJamMasuk.setEnabled(false);
        txtJamMasuk.setPreferredSize(new java.awt.Dimension(0, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        formCard.add(txtJamMasuk, gridBagConstraints);

        lblJamKeluar.setText("Jam Keluar (Sekarang)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        formCard.add(lblJamKeluar, gridBagConstraints);

        txtJamKeluar.setEnabled(false);
        txtJamKeluar.setPreferredSize(new java.awt.Dimension(0, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        formCard.add(txtJamKeluar, gridBagConstraints);

        lblDurasi.setText("Durasi Parkir (Ceiling Jam)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        formCard.add(lblDurasi, gridBagConstraints);

        txtDurasi.setEnabled(false);
        txtDurasi.setPreferredSize(new java.awt.Dimension(0, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        formCard.add(txtDurasi, gridBagConstraints);

        lblTotal.setText("Total Biaya Parkir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        formCard.add(lblTotal, gridBagConstraints);

        txtTotalBiaya.setEnabled(false);
        txtTotalBiaya.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTotalBiaya.setPreferredSize(new java.awt.Dimension(0, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        formCard.add(txtTotalBiaya, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        formCard.add(formSpacer, gridBagConstraints);

        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new java.awt.GridLayout(1, 3, 5, 5));

        btnProsesKeluar.setText("PROSES");
        buttonPanel.add(btnProsesKeluar);

        btnCetakStruk.setText("STRUK");
        buttonPanel.add(btnCetakStruk);

        btnReset.setText("BATAL");
        buttonPanel.add(btnReset);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 5, 0);
        formCard.add(buttonPanel, gridBagConstraints);

        mainSplitPanel.add(formCard);

        receiptCard.setBackground(new java.awt.Color(45, 52, 54));
        receiptCard.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)), javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        receiptCard.setLayout(new java.awt.BorderLayout(10, 10));

        lblReceiptHeader.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblReceiptHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblReceiptHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReceiptHeader.setText("Preview Struk Pembayaran");
        receiptCard.add(lblReceiptHeader, java.awt.BorderLayout.NORTH);

        txtStrukArea.setEditable(false);
        txtStrukArea.setBackground(new java.awt.Color(255, 255, 240));
        txtStrukArea.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        receiptScroll.setViewportView(txtStrukArea);

        receiptCard.add(receiptScroll, java.awt.BorderLayout.CENTER);

        mainSplitPanel.add(receiptCard);

        contentArea.add(mainSplitPanel, java.awt.BorderLayout.CENTER);
    
        
        getContentPane().add(contentArea, java.awt.BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);

    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler boxSpacer;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnKendaraan;
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMasuk;
    private javax.swing.JButton btnPetugas;
    private javax.swing.JButton btnTarif;
    private javax.swing.JButton btnUser;
    private javax.swing.JPanel contentArea;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAppTitle;
    private javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblHeaderTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel headerRightPanel;
    // End of variables declaration//GEN-END:variables
    
}
