package com.mycompany.tugasakhir.view;

import com.mycompany.tugasakhir.util.SessionManager;
import com.mycompany.tugasakhir.util.VectorIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.DefaultTableModel;
import com.mycompany.tugasakhir.util.VectorIcon;


/**
 * JFrame Form untuk NewDashboardView.
 */
public class NewDashboardView extends javax.swing.JFrame {

    private final Map<String, JButton> navButtons = new HashMap<>();
    private JMenuItem menuLogout;
    private JMenu menuMasterData;
    private JMenu menuLaporan;
    
    private DefaultTableModel tableModel;
    private JButton btnDemo;
    
    // UI components declared in form
    private javax.swing.JPanel cardGrid;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel lblActiveTitle;
    private javax.swing.JLabel lblActiveVal;
    private javax.swing.JLabel lblPetugasTitle;
    private javax.swing.JLabel lblPetugasVal;
    private javax.swing.JLabel lblRevTitle;
    private javax.swing.JLabel lblRevVal;
    private javax.swing.JLabel lblTableTitle;
    private javax.swing.JLabel lblTransTitle;
    private javax.swing.JLabel lblTransVal;
    private javax.swing.JTable tblRecent;
    private javax.swing.JPanel tablePanel;
    
    // Delegation methods
    public JButton getBtnDemo() { return btnDemo; }
    public void addLogoutListener(ActionListener l) {
        if (menuLogout != null) menuLogout.addActionListener(l);
    }

    public void updateStats(int activeVehicles, int todayTransactions, double todayRevenue, int totalPetugas) {
        lblActiveVal.setText("  " + activeVehicles);
        lblTransVal.setText("  " + todayTransactions);
        lblRevVal.setText("  " + com.mycompany.tugasakhir.util.CurrencyUtil.formatRupiah(todayRevenue));
        lblPetugasVal.setText("  " + totalPetugas);
    }

    public void populateRecentTable(java.util.List<com.mycompany.tugasakhir.model.TransaksiParkir> list) {
        com.mycompany.tugasakhir.util.TableUtil.clearTable(tableModel);
        for (com.mycompany.tugasakhir.model.TransaksiParkir t : list) {
            String formatMasuk = t.getJamMasuk() != null ? t.getJamMasuk().toString() : "-";
            String formatKeluar = t.getJamKeluar() != null ? t.getJamKeluar().toString() : "-";
            String biaya = t.getStatus().equals("KELUAR") ? com.mycompany.tugasakhir.util.CurrencyUtil.formatRupiah(t.getTotalBiaya()) : "-";
            
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


    public NewDashboardView() {
        initComponents();
        setupAccessControl();
        initNavButtonStyles();
        setActiveNavVisual("DASHBOARD");
        buildMenuBar();
        customInit();
        
        setMinimumSize(new Dimension(1150, 700));
        setSize(1200, 750);
        setLocationRelativeTo(null);
    }

    private void customInit() {
        // Custom styling/logic hook
        
        tableModel = (DefaultTableModel) tblRecent.getModel();
        com.mycompany.tugasakhir.util.TableUtil.styleTable(tblRecent);
        
        // Alignments
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblRecent.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblRecent.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblRecent.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblRecent.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tblRecent.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);

        javax.swing.table.DefaultTableCellRenderer rightRenderer = new javax.swing.table.DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tblRecent.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

        // Vector Icons for cards
        lblActiveTitle.setIcon(new VectorIcon(VectorIcon.Type.KENDARAAN, 20, new Color(255, 255, 255, 180)));
        lblTransTitle.setIcon(new VectorIcon(VectorIcon.Type.LAPORAN, 20, new Color(255, 255, 255, 180)));
        lblRevTitle.setIcon(new VectorIcon(VectorIcon.Type.TARIF, 20, new Color(255, 255, 255, 180)));
        lblPetugasTitle.setIcon(new VectorIcon(VectorIcon.Type.PETUGAS, 20, new Color(45, 52, 54, 180)));
        
        // Flying Demo Button
        btnDemo = new JButton("DEMO");
        btnDemo.setBackground(new Color(255, 193, 7));
        btnDemo.setForeground(Color.BLACK);
        btnDemo.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnDemo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDemo.setIcon(new VectorIcon(VectorIcon.Type.DASHBOARD, 16, Color.BLACK));
        btnDemo.setBounds(getWidth() - 140, getHeight() - 100, 110, 45); 
        getLayeredPane().add(btnDemo, JLayeredPane.MODAL_LAYER);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                btnDemo.setBounds(getWidth() - 140, getHeight() - 100, 110, 45);
            }
        });

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
        
        // Wire listeners programmatically to prevent UI thread locks
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
        titlePanel = new javax.swing.JPanel();
        lblContentTitle = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        cardGrid = new javax.swing.JPanel();
        pnlCardActive = new javax.swing.JPanel();
        lblActiveTitle = new javax.swing.JLabel();
        lblActiveVal = new javax.swing.JLabel();
        pnlCardTrans = new javax.swing.JPanel();
        lblTransTitle = new javax.swing.JLabel();
        lblTransVal = new javax.swing.JLabel();
        pnlCardRev = new javax.swing.JPanel();
        lblRevTitle = new javax.swing.JLabel();
        lblRevVal = new javax.swing.JLabel();
        pnlCardPetugas = new javax.swing.JPanel();
        lblPetugasTitle = new javax.swing.JLabel();
        lblPetugasVal = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        lblTableTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecent = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Parkir Desktop - Dashboard");
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

        titlePanel.setOpaque(false);
        titlePanel.setPreferredSize(new java.awt.Dimension(0, 40));
        titlePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        lblContentTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblContentTitle.setForeground(new java.awt.Color(26, 26, 46));
        lblContentTitle.setText("Statistik Parkir Hari Ini");
        titlePanel.add(lblContentTitle);

        contentArea.add(titlePanel, java.awt.BorderLayout.NORTH);

        centerPanel.setOpaque(false);
        centerPanel.setLayout(new java.awt.BorderLayout(20, 20));

        cardGrid.setOpaque(false);
        cardGrid.setLayout(new java.awt.GridLayout(1, 4, 15, 15));

        pnlCardActive.setBackground(new java.awt.Color(15, 52, 96));
        pnlCardActive.setPreferredSize(new java.awt.Dimension(240, 110));
        pnlCardActive.setLayout(new java.awt.GridLayout(2, 1));

        lblActiveTitle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblActiveTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblActiveTitle.setText("  KENDARAAN PARKIR");
        pnlCardActive.add(lblActiveTitle);

        lblActiveVal.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lblActiveVal.setForeground(new java.awt.Color(255, 255, 255));
        lblActiveVal.setText("  0");
        pnlCardActive.add(lblActiveVal);

        cardGrid.add(pnlCardActive);

        pnlCardTrans.setBackground(new java.awt.Color(233, 69, 96));
        pnlCardTrans.setLayout(new java.awt.GridLayout(2, 1));

        lblTransTitle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTransTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTransTitle.setText("  TRANSAKSI HARI INI");
        pnlCardTrans.add(lblTransTitle);

        lblTransVal.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lblTransVal.setForeground(new java.awt.Color(255, 255, 255));
        lblTransVal.setText("  0");
        pnlCardTrans.add(lblTransVal);

        cardGrid.add(pnlCardTrans);

        pnlCardRev.setBackground(new java.awt.Color(0, 184, 148));
        pnlCardRev.setLayout(new java.awt.GridLayout(2, 1));

        lblRevTitle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRevTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblRevTitle.setText("  PENDAPATAN HARI INI");
        pnlCardRev.add(lblRevTitle);

        lblRevVal.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lblRevVal.setForeground(new java.awt.Color(255, 255, 255));
        lblRevVal.setText("  Rp 0");
        pnlCardRev.add(lblRevVal);

        cardGrid.add(pnlCardRev);

        pnlCardPetugas.setBackground(new java.awt.Color(253, 203, 110));
        pnlCardPetugas.setLayout(new java.awt.GridLayout(2, 1));

        lblPetugasTitle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPetugasTitle.setForeground(new java.awt.Color(45, 52, 54));
        lblPetugasTitle.setText("  TOTAL PETUGAS");
        pnlCardPetugas.add(lblPetugasTitle);

        lblPetugasVal.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lblPetugasVal.setForeground(new java.awt.Color(45, 52, 54));
        lblPetugasVal.setText("  0");
        pnlCardPetugas.add(lblPetugasVal);

        cardGrid.add(pnlCardPetugas);

        centerPanel.add(cardGrid, java.awt.BorderLayout.NORTH);

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)), javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        tablePanel.setLayout(new java.awt.BorderLayout(10, 10));

        lblTableTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTableTitle.setForeground(new java.awt.Color(26, 26, 46));
        lblTableTitle.setText("Transaksi Parkir Terkini");
        tablePanel.add(lblTableTitle, java.awt.BorderLayout.NORTH);

        tblRecent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Plat Nomor", "Jenis Kendaraan", "Jam Masuk", "Jam Keluar", "Total Biaya", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRecent);

        tablePanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        centerPanel.add(tablePanel, java.awt.BorderLayout.CENTER);

        contentArea.add(centerPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(contentArea, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private javax.swing.JPanel pnlCardActive;
    private javax.swing.JPanel pnlCardPetugas;
    private javax.swing.JPanel pnlCardRev;
    private javax.swing.JPanel pnlCardTrans;

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
    private javax.swing.JPanel cardGrid;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel contentArea;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel headerRightPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblActiveTitle;
    private javax.swing.JLabel lblActiveVal;
    private javax.swing.JLabel lblAppTitle;
    private javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblContentTitle;
    private javax.swing.JLabel lblHeaderTitle;
    private javax.swing.JLabel lblPetugasTitle;
    private javax.swing.JLabel lblPetugasVal;
    private javax.swing.JLabel lblRevTitle;
    private javax.swing.JLabel lblRevVal;
    private javax.swing.JLabel lblTableTitle;
    private javax.swing.JLabel lblTransTitle;
    private javax.swing.JLabel lblTransVal;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTable tblRecent;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables

}
