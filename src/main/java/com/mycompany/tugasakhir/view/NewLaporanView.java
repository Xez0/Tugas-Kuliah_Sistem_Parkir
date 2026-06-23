package com.mycompany.tugasakhir.view;

import com.mycompany.tugasakhir.util.SessionManager;
import com.mycompany.tugasakhir.util.VectorIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;


/**
 * JFrame Form untuk NewLaporanView.
 */
public class NewLaporanView extends javax.swing.JFrame {

    private final Map<String, JButton> navButtons = new HashMap<>();
    private JMenuItem menuLogout;
    private JMenu menuMasterData;
    private JMenu menuLaporan;
    
    private DefaultTableModel tableModel;



    // Delegation methods
    public void resetFilters() {
        java.util.Date today = new java.util.Date();
        dateStart.setDate(today);
        dateEnd.setDate(today);
        txtSearchPlat.setText("");
        lblTotalTransactions.setText("0");
        lblTotalRevenue.setText("Rp 0");
    }

    public java.util.Date getStartDate() { return dateStart.getDate(); }
    public java.util.Date getEndDate() { return dateEnd.getDate(); }
    public String getSearchPlat() { return txtSearchPlat.getText().trim().toUpperCase(); }
    public JTable getTable() { return tblLaporan; }

    public void addFilterListener(ActionListener l) {
        btnFilter.addActionListener(l);
        txtSearchPlat.addActionListener(l);
    }
    public void addResetListener(ActionListener l) { btnReset.addActionListener(l); }
    public void addPrintListener(ActionListener l) { btnPrint.addActionListener(l); }

    public void populateTable(java.util.List<com.mycompany.tugasakhir.model.TransaksiParkir> list) {
        com.mycompany.tugasakhir.util.TableUtil.clearTable(tableModel);
        int totalTrans = 0;
        double totalRev = 0;

        for (com.mycompany.tugasakhir.model.TransaksiParkir t : list) {
            String formatMasuk = com.mycompany.tugasakhir.util.DateTimeUtil.formatDisplay(t.getJamMasuk());
            String formatKeluar = com.mycompany.tugasakhir.util.DateTimeUtil.formatDisplay(t.getJamKeluar());
            String durasiStr = t.getStatus().equals("KELUAR") ? t.getDurasiJam() + " Jam" : "-";
            
            double biayaValue = 0.0;
            if (t.getStatus().equals("KELUAR")) {
                biayaValue = t.getTotalBiaya();
            } else {
                // Hitung biaya berjalan untuk kendaraan yang masih parkir
                int runningDurasi = com.mycompany.tugasakhir.util.DateTimeUtil.hitungDurasiJam(t.getJamMasuk(), com.mycompany.tugasakhir.util.DateTimeUtil.now());
                if (runningDurasi == 0) runningDurasi = 1; // Minimal 1 jam
                biayaValue = t.getTarifAwal() + (Math.max(0, runningDurasi - 1) * t.getTarifPerJam());
            }
            String biayaStr = com.mycompany.tugasakhir.util.CurrencyUtil.formatRupiah(biayaValue);
            
            tableModel.addRow(new Object[]{
                    t.getIdTransaksi(),
                    t.getPlatNomor(),
                    t.getJenisKendaraan(),
                    formatMasuk,
                    formatKeluar,
                    durasiStr,
                    biayaStr,
                    t.getNamaPetugasMasuk() != null ? t.getNamaPetugasMasuk() : "-",
                    t.getNamaPetugasKeluar() != null ? t.getNamaPetugasKeluar() : "-"
            });

            totalTrans++;
            totalRev += biayaValue;
        }

        lblTotalTransactions.setText(String.valueOf(totalTrans));
        lblTotalRevenue.setText(com.mycompany.tugasakhir.util.CurrencyUtil.formatRupiah(totalRev));
    }


    public NewLaporanView() {
        initComponents();
        setupAccessControl();
        initNavButtonStyles();
        setActiveNavVisual("LAPORAN");
        buildMenuBar();
        customInit();
        
        setMinimumSize(new Dimension(1150, 700));
        setSize(1200, 750);
        setLocationRelativeTo(null);
    }

    private void customInit() {
        
        tableModel = (DefaultTableModel) tblLaporan.getModel();
        com.mycompany.tugasakhir.util.TableUtil.styleTable(tblLaporan);
        
        // Alignments
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblLaporan.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblLaporan.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblLaporan.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblLaporan.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tblLaporan.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tblLaporan.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        tblLaporan.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);

        // Set column widths so dates aren't truncated
        tblLaporan.getColumnModel().getColumn(3).setPreferredWidth(140);
        tblLaporan.getColumnModel().getColumn(4).setPreferredWidth(140);
        tblLaporan.getColumnModel().getColumn(5).setPreferredWidth(70);
        tblLaporan.getColumnModel().getColumn(6).setPreferredWidth(120);

        javax.swing.table.DefaultTableCellRenderer rightRenderer = new javax.swing.table.DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tblLaporan.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);

        // Styling elements
        btnFilter.setBackground(new Color(15, 52, 96));
        btnFilter.setForeground(Color.WHITE);
        btnFilter.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnFilter.setIcon(new VectorIcon(VectorIcon.Type.SEARCH, 13, Color.WHITE));
        
        btnReset.setBackground(new Color(99, 110, 115));
        btnReset.setForeground(Color.WHITE);
        btnReset.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnReset.setIcon(new VectorIcon(VectorIcon.Type.RESET, 13, Color.WHITE));

        btnPrint.setBackground(new Color(0, 184, 148));
        btnPrint.setForeground(Color.WHITE);
        btnPrint.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnPrint.setIcon(new VectorIcon(VectorIcon.Type.PRINT, 13, Color.WHITE));

        resetFilters();

    }

    private void initNavButtonStyles() {
        JButton[] buttons = {btnDashboard, btnMasuk, btnKeluar, btnKendaraan, btnPetugas, btnUser, btnLaporan, btnLogout};
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
        
        JButton[] buttons = {btnDashboard, btnMasuk, btnKeluar, btnKendaraan, btnPetugas, btnUser, btnLaporan};
        String[] cards = {"DASHBOARD", "MASUK", "KELUAR", "KENDARAAN", "PETUGAS", "USER", "LAPORAN"};
        
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
        btnPetugas.addActionListener(e -> showCard("PETUGAS"));
        btnUser.addActionListener(e -> showCard("USER"));
        btnLaporan.addActionListener(e -> showCard("LAPORAN"));
        btnLogout.addActionListener(e -> ViewRouter.logout(this));
    }

    private void buildMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuMasterData = new JMenu("Master Data");
        JMenuItem itemKendaraan = new JMenuItem("Kendaraan");
        itemKendaraan.addActionListener(e -> showCard("KENDARAAN"));JMenuItem itemPetugas = new JMenuItem("Petugas");
        itemPetugas.addActionListener(e -> showCard("PETUGAS"));
        JMenuItem itemUser = new JMenuItem("User");
        itemUser.addActionListener(e -> showCard("USER"));
        menuMasterData.add(itemKendaraan);menuMasterData.add(itemPetugas);
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
        btnPetugas = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnLaporan = new javax.swing.JButton();
        boxSpacer = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        btnLogout = new javax.swing.JButton();
        contentArea = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        lblContentTitle = new javax.swing.JLabel();
        mainSplitPanel = new javax.swing.JPanel();
        filterCard = new javax.swing.JPanel();
        lblStart = new javax.swing.JLabel();
        dateStart = new com.toedter.calendar.JDateChooser();
        lblEnd = new javax.swing.JLabel();
        dateEnd = new com.toedter.calendar.JDateChooser();
        lblSearchPlat = new javax.swing.JLabel();
        txtSearchPlat = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        tableCard = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLaporan = new javax.swing.JTable();
        summaryPanel = new javax.swing.JPanel();
        infoGrid = new javax.swing.JPanel();
        transCard = new javax.swing.JPanel();
        lblTransTitle = new javax.swing.JLabel();
        lblTotalTransactions = new javax.swing.JLabel();
        revCard = new javax.swing.JPanel();
        lblRevTitle = new javax.swing.JLabel();
        lblTotalRevenue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Parkir Desktop - Laporan");
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
        btnKeluar.addActionListener(this::btnKeluarActionPerformed);
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
        btnLaporan.addActionListener(this::btnLaporanActionPerformed);
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
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
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
        lblContentTitle.setText("Laporan Transaksi Parkir");
        titlePanel.add(lblContentTitle);

        contentArea.add(titlePanel, java.awt.BorderLayout.NORTH);

        mainSplitPanel.setOpaque(false);
        mainSplitPanel.setLayout(new java.awt.BorderLayout(15, 15));

        filterCard.setBackground(new java.awt.Color(255, 255, 255));
        filterCard.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        filterCard.setLayout(new java.awt.GridBagLayout());

        lblStart.setText("Mulai Tanggal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        filterCard.add(lblStart, gridBagConstraints);

        dateStart.setDateFormatString("yyyy-MM-dd");
        dateStart.setPreferredSize(new java.awt.Dimension(130, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        filterCard.add(dateStart, gridBagConstraints);

        lblEnd.setText("Sampai Tanggal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        filterCard.add(lblEnd, gridBagConstraints);

        dateEnd.setDateFormatString("yyyy-MM-dd");
        dateEnd.setPreferredSize(new java.awt.Dimension(130, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        filterCard.add(dateEnd, gridBagConstraints);

        lblSearchPlat.setText("Cari Plat:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        filterCard.add(lblSearchPlat, gridBagConstraints);

        txtSearchPlat.setPreferredSize(new java.awt.Dimension(110, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        filterCard.add(txtSearchPlat, gridBagConstraints);

        btnFilter.setText("FILTER");
        btnFilter.setPreferredSize(new java.awt.Dimension(95, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        filterCard.add(btnFilter, gridBagConstraints);

        btnReset.setText("RESET");
        btnReset.setPreferredSize(new java.awt.Dimension(95, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        filterCard.add(btnReset, gridBagConstraints);

        btnPrint.setText("PRINT");
        btnPrint.setPreferredSize(new java.awt.Dimension(95, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        filterCard.add(btnPrint, gridBagConstraints);

        mainSplitPanel.add(filterCard, java.awt.BorderLayout.NORTH);

        tableCard.setBackground(new java.awt.Color(255, 255, 255));
        tableCard.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tableCard.setLayout(new java.awt.BorderLayout());

        tblLaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Transaksi", "Plat Nomor", "Jenis", "Jam Masuk", "Jam Keluar", "Durasi", "Biaya", "Petugas Masuk", "Petugas Keluar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLaporan);

        tableCard.add(jScrollPane1);

        mainSplitPanel.add(tableCard, java.awt.BorderLayout.CENTER);

        summaryPanel.setLayout(new java.awt.BorderLayout());

        infoGrid.setOpaque(false);
        infoGrid.setLayout(new java.awt.GridLayout(1, 2, 20, 20));

        transCard.setBackground(new java.awt.Color(255, 255, 255));
        transCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        transCard.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 15));

        lblTransTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTransTitle.setText("Total Transaksi Selesai:");
        transCard.add(lblTransTitle);

        lblTotalTransactions.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblTotalTransactions.setForeground(new java.awt.Color(15, 52, 96));
        lblTotalTransactions.setText("0");
        transCard.add(lblTotalTransactions);

        infoGrid.add(transCard);

        revCard.setBackground(new java.awt.Color(255, 255, 255));
        revCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        revCard.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 15));

        lblRevTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRevTitle.setText("Total Pendapatan Parkir:");
        revCard.add(lblRevTitle);

        lblTotalRevenue.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblTotalRevenue.setForeground(new java.awt.Color(0, 184, 148));
        lblTotalRevenue.setText("Rp 0");
        revCard.add(lblTotalRevenue);

        infoGrid.add(revCard);

        summaryPanel.add(infoGrid, java.awt.BorderLayout.CENTER);

        mainSplitPanel.add(summaryPanel, java.awt.BorderLayout.SOUTH);

        contentArea.add(mainSplitPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(contentArea, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaporanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLaporanActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKeluarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler boxSpacer;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnKendaraan;
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMasuk;
    private javax.swing.JButton btnPetugas;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUser;
    private javax.swing.JPanel contentArea;
    private com.toedter.calendar.JDateChooser dateEnd;
    private com.toedter.calendar.JDateChooser dateStart;
    private javax.swing.JPanel filterCard;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel headerRightPanel;
    private javax.swing.JPanel infoGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAppTitle;
    private javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblContentTitle;
    private javax.swing.JLabel lblEnd;
    private javax.swing.JLabel lblHeaderTitle;
    private javax.swing.JLabel lblRevTitle;
    private javax.swing.JLabel lblSearchPlat;
    private javax.swing.JLabel lblStart;
    private javax.swing.JLabel lblTotalRevenue;
    private javax.swing.JLabel lblTotalTransactions;
    private javax.swing.JLabel lblTransTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel mainSplitPanel;
    private javax.swing.JPanel revCard;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JPanel summaryPanel;
    private javax.swing.JPanel tableCard;
    private javax.swing.JTable tblLaporan;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel transCard;
    private javax.swing.JTextField txtSearchPlat;
    // End of variables declaration//GEN-END:variables
    
}
