import os

view_dir = r"c:\Users\DELL\OneDrive\Documents\NetBeansProjects\tugasakhir\src\main\java\com\mycompany\tugasakhir\view"

# 1. XML Form Shared Template
def get_outer_form_xml(title, content_xml):
    return f"""<?xml version="1.0" encoding="UTF-8" ?>
<Form version="1.3" maxVersion="1.9" type="org.netbeans.modules.form.forminfo.JFrameFormInfo">
  <Properties>
    <Property name="defaultCloseOperation" type="int" value="3"/>
    <Property name="title" type="java.lang.String" value="{title}"/>
    <Property name="minimumSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
      <Dimension value="[1150, 700]"/>
    </Property>
  </Properties>
  <SyntheticProperties>
    <SyntheticProperty name="formSizePolicy" type="int" value="1"/>
    <SyntheticProperty name="generateCenter" type="boolean" value="true"/>
  </SyntheticProperties>
  <Layout class="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout"/>
  <SubComponents>
    <Container class="javax.swing.JPanel" name="headerPanel">
      <Properties>
        <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
          <Color blue="60" green="34" red="0f" type="rgb"/>
        </Property>
        <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
          <Dimension value="[0, 55]"/>
        </Property>
      </Properties>
      <Constraints>
        <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
          <BorderConstraints direction="North"/>
        </Constraint>
      </Constraints>
      <Layout class="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout"/>
      <SubComponents>
        <Component class="javax.swing.JLabel" name="lblHeaderTitle">
          <Properties>
            <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
              <Font name="Segoe UI" size="20" style="1"/>
            </Property>
            <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
              <Color blue="ff" green="ff" red="ff" type="rgb"/>
            </Property>
            <Property name="text" type="java.lang.String" value="Sistem Parkir Modern"/>
            <Property name="border" type="javax.swing.border.Border" editor="org.netbeans.modules.form.editors2.BorderEditor">
              <Border info="org.netbeans.modules.form.compat2.border.EmptyBorderInfo">
                <EmptyBorder bottom="0" left="20" right="0" top="0"/>
              </Border>
            </Property>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
              <BorderConstraints direction="West"/>
            </Constraint>
          </Constraints>
        </Component>
        <Container class="javax.swing.JPanel" name="headerRightPanel">
          <Properties>
            <Property name="opaque" type="boolean" value="false"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
              <BorderConstraints direction="East"/>
            </Constraint>
          </Constraints>
          <Layout class="org.netbeans.modules.form.compat2.layouts.DesignFlowLayout">
            <Property name="alignment" type="int" value="2"/>
            <Property name="horizontalGap" type="int" value="20"/>
            <Property name="verticalGap" type="int" value="15"/>
          </Layout>
          <SubComponents>
            <Component class="javax.swing.JLabel" name="lblUser">
              <Properties>
                <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                  <Font name="Segoe UI" size="13" style="0"/>
                </Property>
                <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                  <Color blue="c8" green="c8" red="c8" type="rgb"/>
                </Property>
                <Property name="text" type="java.lang.String" value="User (Role)"/>
              </Properties>
            </Component>
            <Component class="javax.swing.JLabel" name="lblClock">
              <Properties>
                <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                  <Font name="Segoe UI" size="13" style="0"/>
                </Property>
                <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                  <Color blue="c8" green="c8" red="c8" type="rgb"/>
                </Property>
                <Property name="text" type="java.lang.String" value="Clock"/>
              </Properties>
            </Component>
          </SubComponents>
        </Container>
      </SubComponents>
    </Container>
    <Container class="javax.swing.JPanel" name="sidebarPanel">
      <Properties>
        <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
          <Color blue="2e" green="1a" red="1a" type="rgb"/>
        </Property>
        <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
          <Dimension value="[240, 0]"/>
        </Property>
      </Properties>
      <Constraints>
        <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
          <BorderConstraints direction="West"/>
        </Constraint>
      </Constraints>
      <Layout class="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout"/>
      <SubComponents>
        <Component class="javax.swing.JLabel" name="lblAppTitle">
          <Properties>
            <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
              <Font name="Segoe UI" size="22" style="1"/>
            </Property>
            <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
              <Color blue="ff" green="ff" red="ff" type="rgb"/>
            </Property>
            <Property name="horizontalAlignment" type="int" value="0"/>
            <Property name="text" type="java.lang.String" value=" PARKIRKU"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="0" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="15" insetsLeft="15" insetsBottom="15" insetsRight="15" anchor="10" weightX="1.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JSeparator" name="jSeparator1">
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="1" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JButton" name="btnDashboard">
          <Properties>
            <Property name="text" type="java.lang.String" value="Dashboard"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="2" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JButton" name="btnMasuk">
          <Properties>
            <Property name="text" type="java.lang.String" value="Parkir Masuk"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="3" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JButton" name="btnKeluar">
          <Properties>
            <Property name="text" type="java.lang.String" value="Parkir Keluar"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="4" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JButton" name="btnKendaraan">
          <Properties>
            <Property name="text" type="java.lang.String" value="Kelola Kendaraan"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="5" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JButton" name="btnTarif">
          <Properties>
            <Property name="text" type="java.lang.String" value="Kelola Tarif"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="6" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JButton" name="btnPetugas">
          <Properties>
            <Property name="text" type="java.lang.String" value="Kelola Petugas"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="7" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JButton" name="btnUser">
          <Properties>
            <Property name="text" type="java.lang.String" value="Kelola User"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="8" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JButton" name="btnLaporan">
          <Properties>
            <Property name="text" type="java.lang.String" value="Laporan"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="9" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.Box$Filler" name="boxSpacer">
          <Properties>
            <Property name="maximumSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
              <Dimension value="[32767, 32767]"/>
            </Property>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="10" gridWidth="1" gridHeight="1" fill="3" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="0" insetsBottom="0" insetsRight="0" anchor="10" weightX="0.0" weightY="1.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JButton" name="btnLogout">
          <Properties>
            <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
              <Color blue="60" green="45" red="e9" type="rgb"/>
            </Property>
            <Property name="text" type="java.lang.String" value="Keluar (Logout)"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="11" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="10" insetsLeft="0" insetsBottom="20" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
      </SubComponents>
    </Container>
    <Container class="javax.swing.JPanel" name="contentArea">
      <Properties>
        <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
          <Color blue="f5" green="f2" red="f0" type="rgb"/>
        </Property>
        <Property name="border" type="javax.swing.border.Border" editor="org.netbeans.modules.form.editors2.BorderEditor">
          <Border info="org.netbeans.modules.form.compat2.border.EmptyBorderInfo">
            <EmptyBorder bottom="20" left="20" right="20" top="20"/>
          </Border>
        </Property>
      </Properties>
      <Constraints>
        <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
          <BorderConstraints direction="Center"/>
        </Constraint>
      </Constraints>
      <Layout class="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout"/>
      <SubComponents>
        {content_xml}
      </SubComponents>
    </Container>
  </SubComponents>
</Form>
"""

# 2. Java JFrame Shared Template
def get_outer_java_code(classname, package_imports, properties_and_listeners, active_nav, body_logic=""):
    return f"""package com.mycompany.tugasakhir.view;

import com.mycompany.tugasakhir.util.SessionManager;
import com.mycompany.tugasakhir.util.VectorIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
{package_imports}

/**
 * JFrame Form untuk {classname}.
 */
public class {classname} extends javax.swing.JFrame {{

    private final Map<String, JButton> navButtons = new HashMap<>();
    private JMenuItem menuLogout;
    private JMenu menuMasterData;
    private JMenu menuLaporan;
    {properties_and_listeners}

    public {classname}() {{
        initComponents();
        setupAccessControl();
        initNavButtonStyles();
        setActiveNavVisual("{active_nav}");
        buildMenuBar();
        customInit();
        
        setMinimumSize(new Dimension(1150, 700));
        setSize(1200, 750);
        setLocationRelativeTo(null);
    }}

    private void customInit() {{
        {body_logic}
    }}

    private void initNavButtonStyles() {{
        JButton[] buttons = {{btnDashboard, btnMasuk, btnKeluar, btnKendaraan, btnTarif, btnPetugas, btnUser, btnLaporan, btnLogout}};
        Color defaultBg = new Color(26, 26, 46);
        Color defaultFg = new Color(200, 200, 200);
        
        for (JButton btn : buttons) {{
            btn.setBackground(defaultBg);
            btn.setForeground(defaultFg);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);
            btn.setContentAreaFilled(true);
            btn.setOpaque(true);
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }}
        
        btnLogout.setBackground(new Color(233, 69, 96));
        btnLogout.setForeground(Color.WHITE);
    }}

    private void setActiveNavVisual(String activeCard) {{
        Color defaultBg = new Color(26, 26, 46);
        Color defaultFg = new Color(200, 200, 200);
        Color activeBg = new Color(15, 52, 96);
        Color activeFg = Color.WHITE;
        
        JButton[] buttons = {{btnDashboard, btnMasuk, btnKeluar, btnKendaraan, btnTarif, btnPetugas, btnUser, btnLaporan}};
        String[] cards = {{"DASHBOARD", "MASUK", "KELUAR", "KENDARAAN", "TARIF", "PETUGAS", "USER", "LAPORAN"}};
        
        for (int i = 0; i < buttons.length; i++) {{
            if (cards[i].equals(activeCard)) {{
                buttons[i].setBackground(activeBg);
                buttons[i].setForeground(activeFg);
                buttons[i].setIcon(new VectorIcon(VectorIcon.Type.valueOf(cards[i]), 18, activeFg));
            }} else {{
                buttons[i].setBackground(defaultBg);
                buttons[i].setForeground(defaultFg);
                buttons[i].setIcon(new VectorIcon(VectorIcon.Type.valueOf(cards[i]), 18, defaultFg));
            }}
        }}
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
    }}

    private void buildMenuBar() {{
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
    }}

    private void setupAccessControl() {{
        String role = SessionManager.getCurrentRole();
        if ("OPERATOR".equalsIgnoreCase(role)) {{
            btnKendaraan.setVisible(false);
            btnTarif.setVisible(false);
            btnPetugas.setVisible(false);
            btnUser.setVisible(false);
            btnLaporan.setVisible(false);
            menuMasterData.setVisible(false);
            menuLaporan.setVisible(false);
        }}
        headerPanel.setBackground(new Color(15, 52, 96));
        lblUser.setText(SessionManager.getCurrentUsername() + " (" + role + ")");
        Timer clockTimer = new Timer(1000, e -> {{
            java.time.LocalDateTime now = java.time.LocalDateTime.now();
            lblClock.setText(now.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        }});
        clockTimer.start();
    }}

    public void showCard(String cardName) {{
        ViewRouter.showView(cardName, this);
    }}
"""

def generate_standard_java_init(classname, title, content_area_init=""):
    return f"""
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
        setTitle("{title}");
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

        {content_area_init}
        
        getContentPane().add(contentArea, java.awt.BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
"""

# Let's write code for a CRUD View Creator
def generate_crud_view(classname, active_nav, fields_xml, fields_java_vars, fields_java_init, fields_java_methods, title, table_columns, form_pref_width=320):
    content_xml = f"""<Container class="javax.swing.JPanel" name="titlePanel">
          <Properties>
            <Property name="opaque" type="boolean" value="false"/>
            <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
              <Dimension value="[0, 40]"/>
            </Property>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
              <BorderConstraints direction="North"/>
            </Constraint>
          </Constraints>
          <Layout class="org.netbeans.modules.form.compat2.layouts.DesignFlowLayout">
            <Property name="alignment" type="int" value="0"/>
            <Property name="horizontalGap" type="int" value="0"/>
            <Property name="verticalGap" type="int" value="0"/>
          </Layout>
          <SubComponents>
            <Component class="javax.swing.JLabel" name="lblContentTitle">
              <Properties>
                <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                  <Font name="Segoe UI" size="22" style="1"/>
                </Property>
                <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                  <Color blue="2e" green="1a" red="1a" type="rgb"/>
                </Property>
                <Property name="text" type="java.lang.String" value="{title}"/>
              </Properties>
            </Component>
          </SubComponents>
        </Container>
        <Container class="javax.swing.JPanel" name="mainSplitPanel">
          <Properties>
            <Property name="opaque" type="boolean" value="false"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
              <BorderConstraints direction="Center"/>
            </Constraint>
          </Constraints>
          <Layout class="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout">
            <Property name="horizontalGap" type="int" value="15"/>
            <Property name="verticalGap" type="int" value="15"/>
          </Layout>
          <SubComponents>
            <Container class="javax.swing.JPanel" name="formCard">
              <Properties>
                <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                  <Color blue="ff" green="ff" red="ff" type="rgb"/>
                </Property>
                <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
                  <Dimension value="[{form_pref_width}, 0]"/>
                </Property>
                <Property name="border" type="javax.swing.border.Border" editor="org.netbeans.modules.form.editors2.BorderEditor">
                  <Border info="org.netbeans.modules.form.compat2.border.CompoundBorderInfo">
                    <CompoundBorder>
                      <BorderInfo info="org.netbeans.modules.form.compat2.border.LineBorderInfo">
                        <LineBorder>
                          <Color blue="dc" green="dc" red="dc" type="rgb"/>
                        </LineBorder>
                      </BorderInfo>
                      <BorderInfo info="org.netbeans.modules.form.compat2.border.EmptyBorderInfo">
                        <EmptyBorder bottom="20" left="20" right="20" top="20"/>
                      </BorderInfo>
                    </CompoundBorder>
                  </Border>
                </Property>
              </Properties>
              <Constraints>
                <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
                  <BorderConstraints direction="West"/>
                </Constraint>
              </Constraints>
              <Layout class="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout"/>
              <SubComponents>
                {fields_xml}
                <Component class="javax.swing.Box$Filler" name="formSpacer">
                  <Properties>
                    <Property name="maximumSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
                      <Dimension value="[32767, 32767]"/>
                    </Property>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="10" gridWidth="1" gridHeight="1" fill="3" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="0" insetsBottom="0" insetsRight="0" anchor="10" weightX="1.0" weightY="1.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Container class="javax.swing.JPanel" name="buttonPanel">
                  <Properties>
                    <Property name="opaque" type="boolean" value="false"/>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="11" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="15" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                  <Layout class="org.netbeans.modules.form.compat2.layouts.DesignGridLayout">
                    <Property name="columns" type="int" value="3"/>
                    <Property name="horizontalGap" type="int" value="5"/>
                    <Property name="rows" type="int" value="1"/>
                    <Property name="verticalGap" type="int" value="5"/>
                  </Layout>
                  <SubComponents>
                    <Component class="javax.swing.JButton" name="btnSave">
                      <Properties>
                        <Property name="text" type="java.lang.String" value="SIMPAN"/>
                      </Properties>
                    </Component>
                    <Component class="javax.swing.JButton" name="btnDelete">
                      <Properties>
                        <Property name="text" type="java.lang.String" value="HAPUS"/>
                      </Properties>
                    </Component>
                    <Component class="javax.swing.JButton" name="btnReset">
                      <Properties>
                        <Property name="text" type="java.lang.String" value="BATAL"/>
                      </Properties>
                    </Component>
                  </SubComponents>
                </Container>
              </SubComponents>
            </Container>
            <Container class="javax.swing.JPanel" name="tableCard">
              <Properties>
                <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                  <Color blue="ff" green="ff" red="ff" type="rgb"/>
                </Property>
                <Property name="border" type="javax.swing.border.Border" editor="org.netbeans.modules.form.editors2.BorderEditor">
                  <Border info="org.netbeans.modules.form.compat2.border.CompoundBorderInfo">
                    <CompoundBorder>
                      <BorderInfo info="org.netbeans.modules.form.compat2.border.DesignBorderBorderInfo">
                        <BorderInfo rgb="220,220,220" thickness="1" type="LineBorder"/>
                      </BorderInfo>
                      <BorderInfo info="org.netbeans.modules.form.compat2.border.EmptyBorderInfo">
                        <EmptyBorder bottom="15" left="15" right="15" top="15"/>
                      </BorderInfo>
                    </CompoundBorder>
                  </Border>
                </Property>
              </Properties>
              <Constraints>
                <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
                  <BorderConstraints direction="Center"/>
                </Constraint>
              </Constraints>
              <Layout class="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout">
                <Property name="horizontalGap" type="int" value="10"/>
                <Property name="verticalGap" type="int" value="10"/>
              </Layout>
              <SubComponents>
                <Container class="javax.swing.JPanel" name="searchPanel">
                  <Properties>
                    <Property name="opaque" type="boolean" value="false"/>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
                      <BorderConstraints direction="North"/>
                    </Constraint>
                  </Constraints>
                  <Layout class="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout">
                    <Property name="horizontalGap" type="int" value="5"/>
                    <Property name="verticalGap" type="int" value="5"/>
                  </Layout>
                  <SubComponents>
                    <Component class="javax.swing.JTextField" name="txtSearch">
                      <Properties>
                        <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
                          <Dimension value="[200, 36]"/>
                        </Property>
                      </Properties>
                    </Component>
                    <Component class="javax.swing.JButton" name="btnSearch">
                      <Properties>
                        <Property name="text" type="java.lang.String" value="CARI"/>
                        <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
                          <Dimension value="[95, 36]"/>
                        </Property>
                      </Properties>
                      <Constraints>
                        <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
                          <BorderConstraints direction="East"/>
                        </Constraint>
                      </Constraints>
                    </Component>
                  </SubComponents>
                </Container>
                <Container class="javax.swing.JScrollPane" name="jScrollPane1">
                  <AuxValues>
                    <AuxValue name="autoScrollPane" type="java.lang.Boolean" value="true"/>
                  </AuxValues>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
                      <BorderConstraints direction="Center"/>
                    </Constraint>
                  </Constraints>
                  <Layout class="org.netbeans.modules.form.compat2.layouts.DesignJScrollPaneLayout"/>
                  <SubComponents>
                    <Component class="javax.swing.JTable" name="tblData">
                      <Properties>
                        <Property name="model" type="javax.swing.table.TableModel" editor="org.netbeans.modules.form.editors2.TableModelEditor">
                          <Table columnCount="{len(table_columns)}" rowCount="0">
                            {"".join([f'<Column editable="false" title="{col}" type="java.lang.Object"/>' for col in table_columns])}
                          </Table>
                        </Property>
                      </Properties>
                    </Component>
                  </SubComponents>
                </Container>
              </SubComponents>
            </Container>
          </SubComponents>
        </Container>"""

    # Java Code Body logic
    java_body_logic = f"""
        tableModel = (DefaultTableModel) tblData.getModel();
        com.mycompany.tugasakhir.util.TableUtil.styleTable(tblData);
        
        // Color setup
        btnSave.setBackground(new Color(0, 184, 148));
        btnSave.setForeground(Color.WHITE);
        btnSave.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnSave.setIcon(new VectorIcon(VectorIcon.Type.SAVE, 14, Color.WHITE));
        
        btnDelete.setBackground(new Color(214, 48, 49));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnDelete.setIcon(new VectorIcon(VectorIcon.Type.DELETE, 14, Color.WHITE));
        
        btnReset.setBackground(new Color(99, 110, 115));
        btnReset.setForeground(Color.WHITE);
        btnReset.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnReset.setIcon(new VectorIcon(VectorIcon.Type.RESET, 14, Color.WHITE));
        
        btnSearch.setBackground(new Color(15, 52, 96));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnSearch.setIcon(new VectorIcon(VectorIcon.Type.SEARCH, 14, Color.WHITE));

        // Click selection and styling details
        {fields_java_init}
    """

    imports = "import javax.swing.table.DefaultTableModel;\nimport java.awt.event.MouseAdapter;\nimport java.awt.event.MouseEvent;\n"
    
    java_props = f"""
    private DefaultTableModel tableModel;
    {fields_java_vars}
    
    // Delegation methods for CRUD views
    public void addSaveListener(ActionListener l) {{ btnSave.addActionListener(l); }}
    public void addDeleteListener(ActionListener l) {{ btnDelete.addActionListener(l); }}
    public void addResetListener(ActionListener l) {{ btnReset.addActionListener(l); }}
    public void addSearchListener(ActionListener l) {{
        btnSearch.addActionListener(l);
        txtSearch.addActionListener(l);
    }}
    {fields_java_methods}
    """

    content_area_init_xml = f"""
        titlePanel = new javax.swing.JPanel();
        lblContentTitle = new javax.swing.JLabel();
        mainSplitPanel = new javax.swing.JPanel();
        formCard = new javax.swing.JPanel();
        formSpacer = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        buttonPanel = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        tableCard = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        titlePanel.setOpaque(false);
        titlePanel.setPreferredSize(new java.awt.Dimension(0, 40));
        titlePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        lblContentTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblContentTitle.setForeground(new java.awt.Color(26, 26, 46));
        lblContentTitle.setText("{title}");
        titlePanel.add(lblContentTitle);

        contentArea.add(titlePanel, java.awt.BorderLayout.NORTH);

        mainSplitPanel.setOpaque(false);
        mainSplitPanel.setLayout(new java.awt.BorderLayout(15, 15));

        formCard.setBackground(new java.awt.Color(255, 255, 255));
        formCard.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)), javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20)));
        formCard.setPreferredSize(new java.awt.Dimension({form_pref_width}, 0));
        formCard.setLayout(new java.awt.GridBagLayout());

        // Field specific initializations will run programmatically
        initCustomFields();

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        formCard.add(formSpacer, gridBagConstraints);

        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new java.awt.GridLayout(1, 3, 5, 5));

        btnSave.setText("SIMPAN");
        buttonPanel.add(btnSave);

        btnDelete.setText("HAPUS");
        buttonPanel.add(btnDelete);

        btnReset.setText("BATAL");
        buttonPanel.add(btnReset);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 5, 0);
        formCard.add(buttonPanel, gridBagConstraints);

        mainSplitPanel.add(formCard, java.awt.BorderLayout.WEST);

        tableCard.setBackground(new java.awt.Color(255, 255, 255));
        tableCard.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)), javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        tableCard.setLayout(new java.awt.BorderLayout(10, 10));

        searchPanel.setOpaque(false);
        searchPanel.setLayout(new java.awt.BorderLayout(5, 5));
        searchPanel.add(txtSearch, java.awt.BorderLayout.CENTER);

        btnSearch.setText("CARI");
        btnSearch.setPreferredSize(new java.awt.Dimension(95, 36));
        searchPanel.add(btnSearch, java.awt.BorderLayout.EAST);

        tableCard.add(searchPanel, java.awt.BorderLayout.NORTH);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {{}},
            new String [] {{
                {", ".join([f'"{c}"' for c in table_columns])}
            }}
        ) {{
            boolean[] canEdit = new boolean [] {{
                {", ".join(["false"] * len(table_columns))}
            }};
            public boolean isCellEditable(int rowIndex, int columnIndex) {{
                return canEdit [columnIndex];
            }}
        }});
        jScrollPane1.setViewportView(tblData);

        tableCard.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        mainSplitPanel.add(tableCard, java.awt.BorderLayout.CENTER);

        contentArea.add(mainSplitPanel, java.awt.BorderLayout.CENTER);
    """

    java_components_init = generate_standard_java_init(classname, title, content_area_init_xml)

    # XML output
    form_content = get_outer_form_xml(title, content_xml)

    # Java output
    java_code = get_outer_java_code(classname, imports, java_props, active_nav, java_body_logic)
    java_code += "\n    // <editor-fold defaultstate=\"collapsed\" desc=\"Generated Code\">//GEN-BEGIN:initComponents\n    private void initComponents() {"
    java_code += java_components_init
    java_code += "\n    }// </editor-fold>//GEN-END:initComponents\n"
    
    # Custom fields initialization
    java_code += f"\n    private void initCustomFields() {{\n        java.awt.GridBagConstraints gridBagConstraints;\n        // Dynamic initialization of inputs to hook Swing builder\n        {fields_java_init}\n    }}\n"
    
    # Declarations
    java_code += """
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
    private javax.swing.JPanel formCard;
    private javax.swing.Box.Filler formSpacer;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel headerRightPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAppTitle;
    private javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblContentTitle;
    private javax.swing.JLabel lblHeaderTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel mainSplitPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JPanel tableCard;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables
    """
    java_code += "\n}\n"

    with open(os.path.join(view_dir, f"{classname}.form"), "w", encoding="utf-8") as f:
        f.write(form_content)
    with open(os.path.join(view_dir, f"{classname}.java"), "w", encoding="utf-8") as f:
        f.write(java_code)

# -------------------------------------------------------------
# Generate NewKendaraanView
# -------------------------------------------------------------
kendaraan_fields_xml = """<Component class="javax.swing.JLabel" name="lblId">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="ID Kendaraan (Otomatis)"/>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="0" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JTextField" name="txtId">
                  <Properties>
                    <Property name="enabled" type="boolean" value="false"/>
                    <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
                      <Dimension value="[0, 35]"/>
                    </Property>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="1" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="0" insetsBottom="10" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JLabel" name="lblJenis">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Jenis Kendaraan"/>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="2" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JTextField" name="txtJenis">
                  <Properties>
                    <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
                      <Dimension value="[0, 35]"/>
                    </Property>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="3" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="0" insetsBottom="10" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JLabel" name="lblTarifAwal">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Tarif Awal (Rp)"/>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="4" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JTextField" name="txtTarifAwal">
                  <Properties>
                    <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
                      <Dimension value="[0, 35]"/>
                    </Property>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="5" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="0" insetsBottom="10" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JLabel" name="lblTarifPerJam">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Tarif Per Jam (Rp)"/>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="6" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JTextField" name="txtTarifPerJam">
                  <Properties>
                    <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
                      <Dimension value="[0, 35]"/>
                    </Property>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="7" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="0" insetsBottom="10" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JLabel" name="lblStatus">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Status"/>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="8" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JComboBox" name="cbStatus">
                  <Properties>
                    <Property name="model" type="javax.swing.ComboBoxModel" editor="org.netbeans.modules.form.editors2.ComboBoxModelEditor">
                      <StringArray count="2">
                        <String value="AKTIF"/>
                        <String value="NONAKTIF"/>
                      </StringArray>
                    </Property>
                    <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
                      <Dimension value="[0, 35]"/>
                    </Property>
                  </Properties>
                  <AuxValues>
                    <AuxValue name="JavaCodeGenerator_TypeParameters" type="java.lang.String" value="&lt;String&gt;"/>
                  </AuxValues>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="9" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="0" insetsBottom="10" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>"""

kendaraan_java_vars = """
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JTextField txtTarifAwal;
    private javax.swing.JTextField txtTarifPerJam;
    private javax.swing.JComboBox<String> cbStatus;
"""

kendaraan_java_init = """
        // Column alignment
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblData.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblData.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        javax.swing.table.DefaultTableCellRenderer rightRenderer = new javax.swing.table.DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tblData.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        tblData.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);

        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblData.getSelectedRow();
                if (selectedRow != -1) {
                    fillFormFromSelectedRow(selectedRow);
                }
            }
        });
        
        // Add components to form card
        txtId = new javax.swing.JTextField();
        txtId.setEnabled(false);
        txtId.setPreferredSize(new Dimension(0, 35));
        
        txtJenis = new javax.swing.JTextField();
        txtJenis.setPreferredSize(new Dimension(0, 35));
        
        txtTarifAwal = new javax.swing.JTextField();
        txtTarifAwal.setPreferredSize(new Dimension(0, 35));
        
        txtTarifPerJam = new javax.swing.JTextField();
        txtTarifPerJam.setPreferredSize(new Dimension(0, 35));
        
        cbStatus = new javax.swing.JComboBox<>(new String[]{"AKTIF", "NONAKTIF"});
        cbStatus.setPreferredSize(new Dimension(0, 35));

        // Layout setup
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5,0,5,0);
        formCard.add(new javax.swing.JLabel("ID Kendaraan (Otomatis)"), gridBagConstraints);

        gridBagConstraints.gridy = 1;
        formCard.add(txtId, gridBagConstraints);

        gridBagConstraints.gridy = 2;
        formCard.add(new javax.swing.JLabel("Jenis Kendaraan"), gridBagConstraints);

        gridBagConstraints.gridy = 3;
        formCard.add(txtJenis, gridBagConstraints);

        gridBagConstraints.gridy = 4;
        formCard.add(new javax.swing.JLabel("Tarif Awal (Rp)"), gridBagConstraints);

        gridBagConstraints.gridy = 5;
        formCard.add(txtTarifAwal, gridBagConstraints);

        gridBagConstraints.gridy = 6;
        formCard.add(new javax.swing.JLabel("Tarif Per Jam (Rp)"), gridBagConstraints);

        gridBagConstraints.gridy = 7;
        formCard.add(txtTarifPerJam, gridBagConstraints);

        gridBagConstraints.gridy = 8;
        formCard.add(new javax.swing.JLabel("Status"), gridBagConstraints);

        gridBagConstraints.gridy = 9;
        formCard.add(cbStatus, gridBagConstraints);
"""

kendaraan_java_methods = """
    public String getIdInput() { return txtId.getText(); }
    public String getJenisInput() { return txtJenis.getText().trim(); }
    public String getTarifAwalInput() { return txtTarifAwal.getText().trim(); }
    public String getTarifPerJamInput() { return txtTarifPerJam.getText().trim(); }
    public String getStatusInput() { return cbStatus.getSelectedItem().toString(); }
    public String getSearchInput() { return txtSearch.getText().trim(); }

    public JTextField getTxtJenis() { return txtJenis; }
    public JTextField getTxtTarifAwal() { return txtTarifAwal; }
    public JTextField getTxtTarifPerJam() { return txtTarifPerJam; }

    public void resetForm() {
        txtId.setText("");
        txtJenis.setText("");
        txtTarifAwal.setText("");
        txtTarifPerJam.setText("");
        cbStatus.setSelectedIndex(0);
        btnDelete.setEnabled(false);
        tblData.clearSelection();
    }

    private void fillFormFromSelectedRow(int row) {
        txtId.setText(tableModel.getValueAt(row, 0).toString());
        txtJenis.setText(tableModel.getValueAt(row, 1).toString());
        String cleanTarifAwal = tableModel.getValueAt(row, 2).toString()
                .replace("Rp ", "").replace(".", "").replace(",00", "").replace(",-", "").trim();
        String cleanTarifPerJam = tableModel.getValueAt(row, 3).toString()
                .replace("Rp ", "").replace(".", "").replace(",00", "").replace(",-", "").trim();
        txtTarifAwal.setText(cleanTarifAwal);
        txtTarifPerJam.setText(cleanTarifPerJam);
        cbStatus.setSelectedItem(tableModel.getValueAt(row, 4).toString());
        btnDelete.setEnabled(true);
    }

    public void populateTable(java.util.List<com.mycompany.tugasakhir.model.Kendaraan> list) {
        com.mycompany.tugasakhir.util.TableUtil.clearTable(tableModel);
        for (com.mycompany.tugasakhir.model.Kendaraan k : list) {
            tableModel.addRow(new Object[]{
                    k.getIdKendaraan(),
                    k.getJenisKendaraan(),
                    com.mycompany.tugasakhir.util.CurrencyUtil.formatRupiah(k.getTarifAwal()),
                    com.mycompany.tugasakhir.util.CurrencyUtil.formatRupiah(k.getTarifPerJam()),
                    k.getStatus().toString()
            });
        }
    }
"""

def make_kendaraan():
    generate_crud_view("NewKendaraanView", "KENDARAAN", kendaraan_fields_xml, kendaraan_java_vars, kendaraan_java_init, kendaraan_java_methods, "Kelola Jenis Kendaraan & Tarif Awal", ["ID", "Jenis Kendaraan", "Tarif Awal", "Tarif Per Jam", "Status"])

# -------------------------------------------------------------
# Generate NewTarifParkirView
# -------------------------------------------------------------
tarif_fields_xml = """<Component class="javax.swing.JLabel" name="lblId">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="ID Tarif (Otomatis)"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JTextField" name="txtId">
                  <Properties>
                    <Property name="enabled" type="boolean" value="false"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JLabel" name="lblJenis">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Jenis Kendaraan"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JTextField" name="txtJenis">
                </Component>
                <Component class="javax.swing.JLabel" name="lblTarif">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Tarif Awal (Rp)"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JTextField" name="txtTarif">
                </Component>
                <Component class="javax.swing.JLabel" name="lblProgresif">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Tarif Progresif Per Jam (Rp)"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JTextField" name="txtProgresif">
                </Component>
                <Component class="javax.swing.JLabel" name="lblStatus">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Status"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JComboBox" name="cbStatus">
                  <Properties>
                    <Property name="model" type="javax.swing.ComboBoxModel" editor="org.netbeans.modules.form.editors2.ComboBoxModelEditor">
                      <StringArray count="2">
                        <String value="AKTIF"/>
                        <String value="NONAKTIF"/>
                      </StringArray>
                    </Property>
                  </Properties>
                </Component>"""

tarif_java_vars = """
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JTextField txtTarif;
    private javax.swing.JTextField txtProgresif;
    private javax.swing.JComboBox<String> cbStatus;
"""

tarif_java_init = """
        // Column alignment
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblData.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblData.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        javax.swing.table.DefaultTableCellRenderer rightRenderer = new javax.swing.table.DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tblData.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        tblData.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);

        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblData.getSelectedRow();
                if (selectedRow != -1) {
                    fillFormFromSelectedRow(selectedRow);
                }
            }
        });

        txtId = new javax.swing.JTextField();
        txtId.setEnabled(false);
        txtId.setPreferredSize(new Dimension(0, 35));
        
        txtJenis = new javax.swing.JTextField();
        txtJenis.setPreferredSize(new Dimension(0, 35));
        
        txtTarif = new javax.swing.JTextField();
        txtTarif.setPreferredSize(new Dimension(0, 35));
        
        txtProgresif = new javax.swing.JTextField();
        txtProgresif.setPreferredSize(new Dimension(0, 35));
        
        cbStatus = new javax.swing.JComboBox<>(new String[]{"AKTIF", "NONAKTIF"});
        cbStatus.setPreferredSize(new Dimension(0, 35));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5,0,5,0);
        formCard.add(new javax.swing.JLabel("ID Tarif (Otomatis)"), gridBagConstraints);

        gridBagConstraints.gridy = 1;
        formCard.add(txtId, gridBagConstraints);

        gridBagConstraints.gridy = 2;
        formCard.add(new javax.swing.JLabel("Jenis Kendaraan"), gridBagConstraints);

        gridBagConstraints.gridy = 3;
        formCard.add(txtJenis, gridBagConstraints);

        gridBagConstraints.gridy = 4;
        formCard.add(new javax.swing.JLabel("Tarif Awal (Rp)"), gridBagConstraints);

        gridBagConstraints.gridy = 5;
        formCard.add(txtTarif, gridBagConstraints);

        gridBagConstraints.gridy = 6;
        formCard.add(new javax.swing.JLabel("Tarif Progresif Per Jam (Rp)"), gridBagConstraints);

        gridBagConstraints.gridy = 7;
        formCard.add(txtProgresif, gridBagConstraints);

        gridBagConstraints.gridy = 8;
        formCard.add(new javax.swing.JLabel("Status"), gridBagConstraints);

        gridBagConstraints.gridy = 9;
        formCard.add(cbStatus, gridBagConstraints);
"""

tarif_java_methods = """
    public String getIdInput() { return txtId.getText(); }
    public String getJenisInput() { return txtJenis.getText().trim(); }
    public String getTarifInput() { return txtTarif.getText().trim(); }
    public String getProgresifInput() { return txtProgresif.getText().trim(); }
    public String getStatusInput() { return cbStatus.getSelectedItem().toString(); }
    public String getSearchInput() { return txtSearch.getText().trim(); }

    public void resetForm() {
        txtId.setText("");
        txtJenis.setText("");
        txtTarif.setText("");
        txtProgresif.setText("");
        cbStatus.setSelectedIndex(0);
        btnDelete.setEnabled(false);
        tblData.clearSelection();
    }

    private void fillFormFromSelectedRow(int row) {
        txtId.setText(tableModel.getValueAt(row, 0).toString());
        txtJenis.setText(tableModel.getValueAt(row, 1).toString());
        String cleanTarif = tableModel.getValueAt(row, 2).toString()
                .replace("Rp ", "").replace(".", "").replace(",00", "").trim();
        String cleanProgresif = tableModel.getValueAt(row, 3).toString()
                .replace("Rp ", "").replace(".", "").replace(",00", "").trim();
        txtTarif.setText(cleanTarif);
        txtProgresif.setText(cleanProgresif);
        cbStatus.setSelectedItem(tableModel.getValueAt(row, 4).toString());
        btnDelete.setEnabled(true);
    }

    public void populateTable(java.util.List<com.mycompany.tugasakhir.model.TarifParkir> list) {
        com.mycompany.tugasakhir.util.TableUtil.clearTable(tableModel);
        for (com.mycompany.tugasakhir.model.TarifParkir t : list) {
            tableModel.addRow(new Object[]{
                    t.getIdTarif(),
                    t.getJenis(),
                    com.mycompany.tugasakhir.util.CurrencyUtil.formatRupiah(t.getTarif()),
                    com.mycompany.tugasakhir.util.CurrencyUtil.formatRupiah(t.getProgresif()),
                    t.getStatus().toString()
            });
        }
    }
"""

def make_tarif():
    generate_crud_view("NewTarifParkirView", "TARIF", tarif_fields_xml, tarif_java_vars, tarif_java_init, tarif_java_methods, "Kelola Tarif Progresif Parkir", ["ID", "Jenis Kendaraan", "Tarif Awal", "Tarif Progresif", "Status"])

# -------------------------------------------------------------
# Generate NewPetugasView
# -------------------------------------------------------------
petugas_fields_xml = """<Component class="javax.swing.JLabel" name="lblId">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="ID Petugas (Otomatis)"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JTextField" name="txtId">
                  <Properties>
                    <Property name="enabled" type="boolean" value="false"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JLabel" name="lblNama">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Nama Lengkap"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JTextField" name="txtNama">
                </Component>
                <Component class="javax.swing.JLabel" name="lblUsername">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Username"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JTextField" name="txtUsername">
                </Component>
                <Component class="javax.swing.JLabel" name="lblPassword">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Password"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JPasswordField" name="txtPassword">
                </Component>
                <Component class="javax.swing.JLabel" name="lblRole">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Role"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JComboBox" name="cbRole">
                  <Properties>
                    <Property name="model" type="javax.swing.ComboBoxModel" editor="org.netbeans.modules.form.editors2.ComboBoxModelEditor">
                      <StringArray count="2">
                        <String value="OPERATOR"/>
                        <String value="ADMIN"/>
                      </StringArray>
                    </Property>
                  </Properties>
                </Component>
                <Component class="javax.swing.JLabel" name="lblNoTelp">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="No. Telepon"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JTextField" name="txtNoTelp">
                </Component>
                <Component class="javax.swing.JLabel" name="lblStatus">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Status"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JComboBox" name="cbStatus">
                  <Properties>
                    <Property name="model" type="javax.swing.ComboBoxModel" editor="org.netbeans.modules.form.editors2.ComboBoxModelEditor">
                      <StringArray count="2">
                        <String value="AKTIF"/>
                        <String value="NONAKTIF"/>
                      </StringArray>
                    </Property>
                  </Properties>
                </Component>"""

petugas_java_vars = """
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JComboBox<String> cbRole;
    private javax.swing.JTextField txtNoTelp;
    private javax.swing.JComboBox<String> cbStatus;
"""

petugas_java_init = """
        // Column alignment
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblData.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblData.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblData.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tblData.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblData.getSelectedRow();
                if (selectedRow != -1) {
                    fillFormFromSelectedRow(selectedRow);
                }
            }
        });

        txtId = new javax.swing.JTextField();
        txtId.setEnabled(false);
        txtId.setPreferredSize(new Dimension(0, 32));
        
        txtNama = new javax.swing.JTextField();
        txtNama.setPreferredSize(new Dimension(0, 32));
        
        txtUsername = new javax.swing.JTextField();
        txtUsername.setPreferredSize(new Dimension(0, 32));
        
        txtPassword = new javax.swing.JPasswordField();
        txtPassword.setPreferredSize(new Dimension(0, 32));
        
        cbRole = new javax.swing.JComboBox<>(new String[]{"OPERATOR", "ADMIN"});
        cbRole.setPreferredSize(new Dimension(0, 32));
        
        txtNoTelp = new javax.swing.JTextField();
        txtNoTelp.setPreferredSize(new Dimension(0, 32));
        
        cbStatus = new javax.swing.JComboBox<>(new String[]{"AKTIF", "NONAKTIF"});
        cbStatus.setPreferredSize(new Dimension(0, 32));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4,0,4,0);
        formCard.add(new javax.swing.JLabel("ID Petugas (Otomatis)"), gridBagConstraints);

        gridBagConstraints.gridy = 1;
        formCard.add(txtId, gridBagConstraints);

        gridBagConstraints.gridy = 2;
        formCard.add(new javax.swing.JLabel("Nama Lengkap"), gridBagConstraints);

        gridBagConstraints.gridy = 3;
        formCard.add(txtNama, gridBagConstraints);

        gridBagConstraints.gridy = 4;
        formCard.add(new javax.swing.JLabel("Username"), gridBagConstraints);

        gridBagConstraints.gridy = 5;
        formCard.add(txtUsername, gridBagConstraints);

        gridBagConstraints.gridy = 6;
        formCard.add(new javax.swing.JLabel("Password (Kosongkan jika tidak diubah)"), gridBagConstraints);

        gridBagConstraints.gridy = 7;
        formCard.add(txtPassword, gridBagConstraints);

        gridBagConstraints.gridy = 8;
        formCard.add(new javax.swing.JLabel("Role"), gridBagConstraints);

        gridBagConstraints.gridy = 9;
        formCard.add(cbRole, gridBagConstraints);

        gridBagConstraints.gridy = 10;
        formCard.add(new javax.swing.JLabel("No. Telepon"), gridBagConstraints);

        gridBagConstraints.gridy = 11;
        formCard.add(txtNoTelp, gridBagConstraints);

        gridBagConstraints.gridy = 12;
        formCard.add(new javax.swing.JLabel("Status"), gridBagConstraints);

        gridBagConstraints.gridy = 13;
        formCard.add(cbStatus, gridBagConstraints);
"""

petugas_java_methods = """
    public String getIdInput() { return txtId.getText(); }
    public String getNamaInput() { return txtNama.getText().trim(); }
    public String getUsernameInput() { return txtUsername.getText().trim(); }
    public String getPasswordInput() { return new String(txtPassword.getPassword()); }
    public String getRoleInput() { return cbRole.getSelectedItem().toString(); }
    public String getNoTelpInput() { return txtNoTelp.getText().trim(); }
    public String getStatusInput() { return cbStatus.getSelectedItem().toString(); }
    public String getSearchInput() { return txtSearch.getText().trim(); }

    public void resetForm() {
        txtId.setText("");
        txtNama.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        cbRole.setSelectedIndex(0);
        txtNoTelp.setText("");
        cbStatus.setSelectedIndex(0);
        btnDelete.setEnabled(false);
        tblData.clearSelection();
    }

    private void fillFormFromSelectedRow(int row) {
        txtId.setText(tableModel.getValueAt(row, 0).toString());
        txtNama.setText(tableModel.getValueAt(row, 1).toString());
        txtUsername.setText(tableModel.getValueAt(row, 2).toString());
        txtPassword.setText("");
        cbRole.setSelectedItem(tableModel.getValueAt(row, 3).toString());
        txtNoTelp.setText(tableModel.getValueAt(row, 4) != null ? tableModel.getValueAt(row, 4).toString() : "");
        cbStatus.setSelectedItem(tableModel.getValueAt(row, 5).toString());
        btnDelete.setEnabled(true);
    }

    public void populateTable(java.util.List<com.mycompany.tugasakhir.model.Petugas> list) {
        com.mycompany.tugasakhir.util.TableUtil.clearTable(tableModel);
        for (com.mycompany.tugasakhir.model.Petugas p : list) {
            tableModel.addRow(new Object[]{
                    p.getIdPetugas(),
                    p.getNama(),
                    p.getUsername(),
                    p.getRole().toString(),
                    p.getNoTelp(),
                    p.getStatus().toString()
            });
        }
    }
"""

def make_petugas():
    generate_crud_view("NewPetugasView", "PETUGAS", petugas_fields_xml, petugas_java_vars, petugas_java_init, petugas_java_methods, "Kelola Data Petugas Parkir", ["ID", "Nama Lengkap", "Username", "Role", "No. Telp", "Status"], form_pref_width=340)

# -------------------------------------------------------------
# Generate NewUserView
# -------------------------------------------------------------
user_fields_xml = """<Component class="javax.swing.JLabel" name="lblId">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="ID User (Otomatis)"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JTextField" name="txtId">
                  <Properties>
                    <Property name="enabled" type="boolean" value="false"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JLabel" name="lblNama">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Nama Lengkap"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JTextField" name="txtNama">
                </Component>
                <Component class="javax.swing.JLabel" name="lblUsername">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Username"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JTextField" name="txtUsername">
                </Component>
                <Component class="javax.swing.JLabel" name="lblPassword">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Password"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JPasswordField" name="txtPassword">
                </Component>
                <Component class="javax.swing.JLabel" name="lblRole">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Role"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JComboBox" name="cbRole">
                  <Properties>
                    <Property name="model" type="javax.swing.ComboBoxModel" editor="org.netbeans.modules.form.editors2.ComboBoxModelEditor">
                      <StringArray count="2">
                        <String value="OPERATOR"/>
                        <String value="ADMIN"/>
                      </StringArray>
                    </Property>
                  </Properties>
                </Component>
                <Component class="javax.swing.JLabel" name="lblStatus">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Status"/>
                  </Properties>
                </Component>
                <Component class="javax.swing.JComboBox" name="cbStatus">
                  <Properties>
                    <Property name="model" type="javax.swing.ComboBoxModel" editor="org.netbeans.modules.form.editors2.ComboBoxModelEditor">
                      <StringArray count="2">
                        <String value="AKTIF"/>
                        <String value="NONAKTIF"/>
                      </StringArray>
                    </Property>
                  </Properties>
                </Component>"""

user_java_vars = """
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JComboBox<String> cbRole;
    private javax.swing.JComboBox<String> cbStatus;
"""

user_java_init = """
        // Column alignment
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblData.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblData.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblData.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblData.getSelectedRow();
                if (selectedRow != -1) {
                    fillFormFromSelectedRow(selectedRow);
                }
            }
        });

        txtId = new javax.swing.JTextField();
        txtId.setEnabled(false);
        txtId.setPreferredSize(new Dimension(0, 35));
        
        txtNama = new javax.swing.JTextField();
        txtNama.setPreferredSize(new Dimension(0, 35));
        
        txtUsername = new javax.swing.JTextField();
        txtUsername.setPreferredSize(new Dimension(0, 35));
        
        txtPassword = new javax.swing.JPasswordField();
        txtPassword.setPreferredSize(new Dimension(0, 35));
        
        cbRole = new javax.swing.JComboBox<>(new String[]{"OPERATOR", "ADMIN"});
        cbRole.setPreferredSize(new Dimension(0, 35));
        
        cbStatus = new javax.swing.JComboBox<>(new String[]{"AKTIF", "NONAKTIF"});
        cbStatus.setPreferredSize(new Dimension(0, 35));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5,0,5,0);
        formCard.add(new javax.swing.JLabel("ID User (Otomatis)"), gridBagConstraints);

        gridBagConstraints.gridy = 1;
        formCard.add(txtId, gridBagConstraints);

        gridBagConstraints.gridy = 2;
        formCard.add(new javax.swing.JLabel("Nama Lengkap"), gridBagConstraints);

        gridBagConstraints.gridy = 3;
        formCard.add(txtNama, gridBagConstraints);

        gridBagConstraints.gridy = 4;
        formCard.add(new javax.swing.JLabel("Username"), gridBagConstraints);

        gridBagConstraints.gridy = 5;
        formCard.add(txtUsername, gridBagConstraints);

        gridBagConstraints.gridy = 6;
        formCard.add(new javax.swing.JLabel("Password (Kosongkan jika tidak diubah)"), gridBagConstraints);

        gridBagConstraints.gridy = 7;
        formCard.add(txtPassword, gridBagConstraints);

        gridBagConstraints.gridy = 8;
        formCard.add(new javax.swing.JLabel("Role"), gridBagConstraints);

        gridBagConstraints.gridy = 9;
        formCard.add(cbRole, gridBagConstraints);

        gridBagConstraints.gridy = 10;
        formCard.add(new javax.swing.JLabel("Status"), gridBagConstraints);

        gridBagConstraints.gridy = 11;
        formCard.add(cbStatus, gridBagConstraints);
"""

user_java_methods = """
    public String getIdInput() { return txtId.getText(); }
    public String getNamaInput() { return txtNama.getText().trim(); }
    public String getUsernameInput() { return txtUsername.getText().trim(); }
    public String getPasswordInput() { return new String(txtPassword.getPassword()); }
    public String getRoleInput() { return cbRole.getSelectedItem().toString(); }
    public String getStatusInput() { return cbStatus.getSelectedItem().toString(); }
    public String getSearchInput() { return txtSearch.getText().trim(); }

    public void resetForm() {
        txtId.setText("");
        txtNama.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        cbRole.setSelectedIndex(0);
        cbStatus.setSelectedIndex(0);
        btnDelete.setEnabled(false);
        tblData.clearSelection();
    }

    private void fillFormFromSelectedRow(int row) {
        txtId.setText(tableModel.getValueAt(row, 0).toString());
        txtNama.setText(tableModel.getValueAt(row, 1).toString());
        txtUsername.setText(tableModel.getValueAt(row, 2).toString());
        txtPassword.setText("");
        cbRole.setSelectedItem(tableModel.getValueAt(row, 3).toString());
        cbStatus.setSelectedItem(tableModel.getValueAt(row, 4).toString());
        btnDelete.setEnabled(true);
    }

    public void populateTable(java.util.List<com.mycompany.tugasakhir.model.User> list) {
        com.mycompany.tugasakhir.util.TableUtil.clearTable(tableModel);
        for (com.mycompany.tugasakhir.model.User u : list) {
            tableModel.addRow(new Object[]{
                    u.getIdUser(),
                    u.getNama(),
                    u.getUsername(),
                    u.getRole().toString(),
                    u.getStatus().toString()
            });
        }
    }
"""

def make_user():
    generate_crud_view("NewUserView", "USER", user_fields_xml, user_java_vars, user_java_init, user_java_methods, "Kelola Akun User Sistem", ["ID", "Nama Lengkap", "Username", "Role", "Status"], form_pref_width=340)


# -------------------------------------------------------------
# Generate NewTransaksiMasukView
# -------------------------------------------------------------
masuk_xml = """<Container class="javax.swing.JPanel" name="titlePanel">
          <Properties>
            <Property name="opaque" type="boolean" value="false"/>
            <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
              <Dimension value="[0, 40]"/>
            </Property>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
              <BorderConstraints direction="North"/>
            </Constraint>
          </Constraints>
          <Layout class="org.netbeans.modules.form.compat2.layouts.DesignFlowLayout">
            <Property name="alignment" type="int" value="0"/>
            <Property name="horizontalGap" type="int" value="0"/>
            <Property name="verticalGap" type="int" value="0"/>
          </Layout>
          <SubComponents>
            <Component class="javax.swing.JLabel" name="lblContentTitle">
              <Properties>
                <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                  <Font name="Segoe UI" size="22" style="1"/>
                </Property>
                <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                  <Color blue="2e" green="1a" red="1a" type="rgb"/>
                </Property>
                <Property name="text" type="java.lang.String" value="Transaksi Parkir Masuk"/>
              </Properties>
            </Component>
          </SubComponents>
        </Container>
        <Container class="javax.swing.JPanel" name="mainSplitPanel">
          <Properties>
            <Property name="opaque" type="boolean" value="false"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
              <BorderConstraints direction="Center"/>
            </Constraint>
          </Constraints>
          <Layout class="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout">
            <Property name="horizontalGap" type="int" value="15"/>
            <Property name="verticalGap" type="int" value="15"/>
          </Layout>
          <SubComponents>
            <Container class="javax.swing.JPanel" name="formCard">
              <Properties>
                <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                  <Color blue="ff" green="ff" red="ff" type="rgb"/>
                </Property>
                <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
                  <Dimension value="[320, 0]"/>
                </Property>
                <Property name="border" type="javax.swing.border.Border" editor="org.netbeans.modules.form.editors2.BorderEditor">
                  <Border info="org.netbeans.modules.form.compat2.border.CompoundBorderInfo">
                    <CompoundBorder>
                      <BorderInfo info="org.netbeans.modules.form.compat2.border.LineBorderInfo">
                        <LineBorder>
                          <Color blue="dc" green="dc" red="dc" type="rgb"/>
                        </LineBorder>
                      </BorderInfo>
                      <BorderInfo info="org.netbeans.modules.form.compat2.border.EmptyBorderInfo">
                        <EmptyBorder bottom="20" left="20" right="20" top="20"/>
                      </BorderInfo>
                    </CompoundBorder>
                  </Border>
                </Property>
              </Properties>
              <Constraints>
                <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
                  <BorderConstraints direction="West"/>
                </Constraint>
              </Constraints>
              <Layout class="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout"/>
              <SubComponents>
                <Component class="javax.swing.JLabel" name="lblBanner">
                  <Properties>
                    <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                      <Font name="Segoe UI" size="16" style="1"/>
                    </Property>
                    <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                      <Color blue="60" green="34" red="0f" type="rgb"/>
                    </Property>
                    <Property name="horizontalAlignment" type="int" value="0"/>
                    <Property name="text" type="java.lang.String" value="Entry Parkir Baru"/>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="0" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="8" insetsLeft="0" insetsBottom="8" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JLabel" name="lblPlatLabel">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Plat Nomor Kendaraan"/>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="1" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="15" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JTextField" name="txtPlatNomor">
                  <Properties>
                    <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                      <Font name="Segoe UI" size="18" style="1"/>
                    </Property>
                    <Property name="horizontalAlignment" type="int" value="0"/>
                    <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
                      <Dimension value="[0, 42]"/>
                    </Property>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="2" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="0" insetsBottom="10" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JLabel" name="lblJenisLabel">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Jenis Kendaraan"/>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="3" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="10" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JComboBox" name="cbJenisKendaraan">
                  <Properties>
                    <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                      <Font name="Segoe UI" size="14" style="0"/>
                    </Property>
                    <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
                      <Dimension value="[0, 38]"/>
                    </Property>
                  </Properties>
                  <AuxValues>
                    <AuxValue name="JavaCodeGenerator_TypeParameters" type="java.lang.String" value="&lt;com.mycompany.tugasakhir.model.Kendaraan&gt;"/>
                  </AuxValues>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="4" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="0" insetsBottom="10" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.Box$Filler" name="formSpacer">
                  <Properties>
                    <Property name="maximumSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
                      <Dimension value="[32767, 32767]"/>
                    </Property>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="5" gridWidth="1" gridHeight="1" fill="3" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="0" insetsBottom="0" insetsRight="0" anchor="10" weightX="1.0" weightY="1.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Container class="javax.swing.JPanel" name="buttonPanel">
                  <Properties>
                    <Property name="opaque" type="boolean" value="false"/>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="6" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="20" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                  <Layout class="org.netbeans.modules.form.compat2.layouts.DesignGridLayout">
                    <Property name="columns" type="int" value="2"/>
                    <Property name="horizontalGap" type="int" value="8"/>
                    <Property name="rows" type="int" value="1"/>
                    <Property name="verticalGap" type="int" value="8"/>
                  </Layout>
                  <SubComponents>
                    <Component class="javax.swing.JButton" name="btnProses">
                      <Properties>
                        <Property name="text" type="java.lang.String" value="MASUK"/>
                      </Properties>
                    </Component>
                    <Component class="javax.swing.JButton" name="btnReset">
                      <Properties>
                        <Property name="text" type="java.lang.String" value="RESET"/>
                      </Properties>
                    </Component>
                  </SubComponents>
                </Container>
              </SubComponents>
            </Container>
            <Container class="javax.swing.JPanel" name="tableCard">
              <Properties>
                <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                  <Color blue="ff" green="ff" red="ff" type="rgb"/>
                </Property>
                <Property name="border" type="javax.swing.border.Border" editor="org.netbeans.modules.form.editors2.BorderEditor">
                  <Border info="org.netbeans.modules.form.compat2.border.CompoundBorderInfo">
                    <CompoundBorder>
                      <BorderInfo info="org.netbeans.modules.form.compat2.border.DesignBorderBorderInfo">
                        <BorderInfo rgb="220,220,220" thickness="1" type="LineBorder"/>
                      </BorderInfo>
                      <BorderInfo info="org.netbeans.modules.form.compat2.border.EmptyBorderInfo">
                        <EmptyBorder bottom="15" left="15" right="15" top="15"/>
                      </BorderInfo>
                    </CompoundBorder>
                  </Border>
                </Property>
              </Properties>
              <Constraints>
                <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
                  <BorderConstraints direction="Center"/>
                </Constraint>
              </Constraints>
              <Layout class="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout">
                <Property name="horizontalGap" type="int" value="10"/>
                <Property name="verticalGap" type="int" value="10"/>
              </Layout>
              <SubComponents>
                <Component class="javax.swing.JLabel" name="lblTableTitle">
                  <Properties>
                    <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                      <Font name="Segoe UI" size="16" style="1"/>
                    </Property>
                    <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                      <Color blue="2e" green="1a" red="1a" type="rgb"/>
                    </Property>
                    <Property name="text" type="java.lang.String" value="Kendaraan yang Sedang Parkir"/>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
                      <BorderConstraints direction="North"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Container class="javax.swing.JScrollPane" name="jScrollPane1">
                  <AuxValues>
                    <AuxValue name="autoScrollPane" type="java.lang.Boolean" value="true"/>
                  </AuxValues>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
                      <BorderConstraints direction="Center"/>
                    </Constraint>
                  </Constraints>
                  <Layout class="org.netbeans.modules.form.compat2.layouts.DesignJScrollPaneLayout"/>
                  <SubComponents>
                    <Component class="javax.swing.JTable" name="tblActiveParking">
                      <Properties>
                        <Property name="model" type="javax.swing.table.TableModel" editor="org.netbeans.modules.form.editors2.TableModelEditor">
                          <Table columnCount="5" rowCount="0">
                            <Column editable="false" title="ID Transaksi" type="java.lang.Object"/>
                            <Column editable="false" title="Plat Nomor" type="java.lang.Object"/>
                            <Column editable="false" title="Jenis" type="java.lang.Object"/>
                            <Column editable="false" title="Jam Masuk" type="java.lang.Object"/>
                            <Column editable="false" title="Petugas Masuk" type="java.lang.Object"/>
                          </Table>
                        </Property>
                      </Properties>
                    </Component>
                  </SubComponents>
                </Container>
              </SubComponents>
            </Container>
          </SubComponents>
        </Container>"""

masuk_java_props = """
    private DefaultTableModel tableModel;

    // Form elements declared visually in form
    private javax.swing.JLabel lblBanner;
    private javax.swing.JLabel lblPlatLabel;
    private javax.swing.JTextField txtPlatNomor;
    private javax.swing.JLabel lblJenisLabel;
    private javax.swing.JComboBox<com.mycompany.tugasakhir.model.Kendaraan> cbJenisKendaraan;
    private javax.swing.Box.Filler formSpacer;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton btnProses;
    private javax.swing.JButton btnReset;
    private javax.swing.JPanel formCard;
    private javax.swing.JPanel tableCard;
    private javax.swing.JLabel lblTableTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblActiveParking;
    private javax.swing.JPanel mainSplitPanel;
    private javax.swing.JPanel titlePanel;

    // Public Controller delegation methods
    public void setJenisKendaraanList(java.util.List<com.mycompany.tugasakhir.model.Kendaraan> list) {
        cbJenisKendaraan.removeAllItems();
        for (com.mycompany.tugasakhir.model.Kendaraan k : list) {
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

    public String getPlatNomorInput() {
        return txtPlatNomor.getText().trim().toUpperCase();
    }

    public com.mycompany.tugasakhir.model.Kendaraan getSelectedKendaraan() {
        return (com.mycompany.tugasakhir.model.Kendaraan) cbJenisKendaraan.getSelectedItem();
    }

    public JTextField getTxtPlatNomor() { return txtPlatNomor; }
    public JComboBox<com.mycompany.tugasakhir.model.Kendaraan> getCbJenisKendaraan() { return cbJenisKendaraan; }
    public JButton getBtnProses() { return btnProses; }

    public void addProsesListener(ActionListener l) {
        btnProses.addActionListener(l);
        txtPlatNomor.addActionListener(l); // Trigger on enter key
    }

    public void addResetListener(ActionListener l) {
        btnReset.addActionListener(l);
    }

    public void populateActiveParkingTable(java.util.List<com.mycompany.tugasakhir.model.TransaksiParkir> list) {
        com.mycompany.tugasakhir.util.TableUtil.clearTable(tableModel);
        for (com.mycompany.tugasakhir.model.TransaksiParkir t : list) {
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
"""

masuk_java_body = """
        tableModel = (DefaultTableModel) tblActiveParking.getModel();
        com.mycompany.tugasakhir.util.TableUtil.styleTable(tblActiveParking);
        
        // Alignments
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblActiveParking.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblActiveParking.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblActiveParking.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblActiveParking.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        // Styling elements
        btnProses.setBackground(new Color(0, 184, 148));
        btnProses.setForeground(Color.WHITE);
        btnProses.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnProses.setIcon(new VectorIcon(VectorIcon.Type.SAVE, 16, Color.WHITE));
        
        btnReset.setBackground(new Color(99, 110, 115));
        btnReset.setForeground(Color.WHITE);
        btnReset.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnReset.setIcon(new VectorIcon(VectorIcon.Type.RESET, 16, Color.WHITE));
"""

def make_transaksi_masuk():
    form_xml = get_outer_form_xml("Sistem Parkir Desktop - Parkir Masuk", masuk_xml)
    
    java_components_init = generate_standard_java_init("NewTransaksiMasukView", "Sistem Parkir Desktop - Parkir Masuk", """
        titlePanel = new javax.swing.JPanel();
        lblContentTitle = new javax.swing.JLabel();
        mainSplitPanel = new javax.swing.JPanel();
        formCard = new javax.swing.JPanel();
        lblBanner = new javax.swing.JLabel();
        lblPlatLabel = new javax.swing.JLabel();
        txtPlatNomor = new javax.swing.JTextField();
        lblJenisLabel = new javax.swing.JLabel();
        cbJenisKendaraan = new javax.swing.JComboBox<>();
        formSpacer = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        buttonPanel = new javax.swing.JPanel();
        btnProses = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        tableCard = new javax.swing.JPanel();
        lblTableTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblActiveParking = new javax.swing.JTable();

        titlePanel.setOpaque(false);
        titlePanel.setPreferredSize(new java.awt.Dimension(0, 40));
        titlePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        lblContentTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblContentTitle.setForeground(new java.awt.Color(26, 26, 46));
        lblContentTitle.setText("Transaksi Parkir Masuk");
        titlePanel.add(lblContentTitle);

        contentArea.add(titlePanel, java.awt.BorderLayout.NORTH);

        mainSplitPanel.setOpaque(false);
        mainSplitPanel.setLayout(new java.awt.BorderLayout(15, 15));

        formCard.setBackground(new java.awt.Color(255, 255, 255));
        formCard.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)), javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20)));
        formCard.setPreferredSize(new java.awt.Dimension(320, 0));
        formCard.setLayout(new java.awt.GridBagLayout());

        lblBanner.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblBanner.setForeground(new java.awt.Color(15, 52, 96));
        lblBanner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBanner.setText("Entry Parkir Baru");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 0);
        formCard.add(lblBanner, gridBagConstraints);

        lblPlatLabel.setText("Plat Nomor Kendaraan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 5, 0);
        formCard.add(lblPlatLabel, gridBagConstraints);

        txtPlatNomor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtPlatNomor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPlatNomor.setPreferredSize(new java.awt.Dimension(0, 42));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        formCard.add(txtPlatNomor, gridBagConstraints);

        lblJenisLabel.setText("Jenis Kendaraan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        formCard.add(lblJenisLabel, gridBagConstraints);

        cbJenisKendaraan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbJenisKendaraan.setPreferredSize(new java.awt.Dimension(0, 38));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        formCard.add(cbJenisKendaraan, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        formCard.add(formSpacer, gridBagConstraints);

        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new java.awt.GridLayout(1, 2, 8, 8));

        btnProses.setText("MASUK");
        buttonPanel.add(btnProses);

        btnReset.setText("RESET");
        buttonPanel.add(btnReset);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 5, 0);
        formCard.add(buttonPanel, gridBagConstraints);

        mainSplitPanel.add(formCard, java.awt.BorderLayout.WEST);

        tableCard.setBackground(new java.awt.Color(255, 255, 255));
        tableCard.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)), javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        tableCard.setLayout(new java.awt.BorderLayout(10, 10));

        lblTableTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTableTitle.setForeground(new java.awt.Color(26, 26, 46));
        lblTableTitle.setText("Kendaraan yang Sedang Parkir");
        tableCard.add(lblTableTitle, java.awt.BorderLayout.NORTH);

        tblActiveParking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID Transaksi", "Plat Nomor", "Jenis", "Jam Masuk", "Petugas Masuk"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblActiveParking);

        tableCard.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        mainSplitPanel.add(tableCard, java.awt.BorderLayout.CENTER);

        contentArea.add(mainSplitPanel, java.awt.BorderLayout.CENTER);
    """)

    imports = "import javax.swing.table.DefaultTableModel;\n"
    java_code = get_outer_java_code("NewTransaksiMasukView", imports, masuk_java_props, "MASUK", masuk_java_body)
    java_code += "\n    // <editor-fold defaultstate=\"collapsed\" desc=\"Generated Code\">//GEN-BEGIN:initComponents\n    private void initComponents() {"
    java_code += java_components_init
    java_code += "\n    }// </editor-fold>//GEN-END:initComponents\n"
    
    # Declarations
    java_code += """
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
    """
    java_code += "\n}\n"

    with open(os.path.join(view_dir, "NewTransaksiMasukView.form"), "w", encoding="utf-8") as f:
        f.write(form_xml)
    with open(os.path.join(view_dir, "NewTransaksiMasukView.java"), "w", encoding="utf-8") as f:
        f.write(java_code)

# -------------------------------------------------------------
# Generate NewTransaksiKeluarView
# -------------------------------------------------------------
keluar_xml = """<Container class="javax.swing.JPanel" name="titlePanel">
          <Properties>
            <Property name="opaque" type="boolean" value="false"/>
            <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
              <Dimension value="[0, 40]"/>
            </Property>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
              <BorderConstraints direction="North"/>
            </Constraint>
          </Constraints>
          <Layout class="org.netbeans.modules.form.compat2.layouts.DesignFlowLayout">
            <Property name="alignment" type="int" value="0"/>
            <Property name="horizontalGap" type="int" value="0"/>
            <Property name="verticalGap" type="int" value="0"/>
          </Layout>
          <SubComponents>
            <Component class="javax.swing.JLabel" name="lblContentTitle">
              <Properties>
                <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                  <Font name="Segoe UI" size="22" style="1"/>
                </Property>
                <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                  <Color blue="2e" green="1a" red="1a" type="rgb"/>
                </Property>
                <Property name="text" type="java.lang.String" value="Transaksi Parkir Keluar &amp; Pembayaran"/>
              </Properties>
            </Component>
          </SubComponents>
        </Container>
        <Container class="javax.swing.JPanel" name="mainSplitPanel">
          <Properties>
            <Property name="opaque" type="boolean" value="false"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
              <BorderConstraints direction="Center"/>
            </Constraint>
          </Constraints>
          <Layout class="org.netbeans.modules.form.compat2.layouts.DesignGridLayout">
            <Property name="columns" type="int" value="2"/>
            <Property name="horizontalGap" type="int" value="20"/>
            <Property name="rows" type="int" value="1"/>
            <Property name="verticalGap" type="int" value="20"/>
          </Layout>
          <SubComponents>
            <Container class="javax.swing.JPanel" name="formCard">
              <Properties>
                <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                  <Color blue="ff" green="ff" red="ff" type="rgb"/>
                </Property>
                <Property name="border" type="javax.swing.border.Border" editor="org.netbeans.modules.form.editors2.BorderEditor">
                  <Border info="org.netbeans.modules.form.compat2.border.CompoundBorderInfo">
                    <CompoundBorder>
                      <BorderInfo info="org.netbeans.modules.form.compat2.border.LineBorderInfo">
                        <LineBorder>
                          <Color blue="dc" green="dc" red="dc" type="rgb"/>
                        </LineBorder>
                      </BorderInfo>
                      <BorderInfo info="org.netbeans.modules.form.compat2.border.EmptyBorderInfo">
                        <EmptyBorder bottom="15" left="15" right="15" top="15"/>
                      </BorderInfo>
                    </CompoundBorder>
                  </Border>
                </Property>
              </Properties>
              <Layout class="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout"/>
              <SubComponents>
                <Component class="javax.swing.JLabel" name="lblSearchTitle">
                  <Properties>
                    <Property name="text" type="java.lang.String" value="Cari Plat Nomor Aktif"/>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="0" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="4" insetsLeft="0" insetsBottom="4" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Container class="javax.swing.JPanel" name="searchBarPanel">
                  <Properties>
                    <Property name="opaque" type="boolean" value="false"/>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="1" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                  <Layout class="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout">
                    <Property name="horizontalGap" type="int" value="5"/>
                    <Property name="verticalGap" type="int" value="5"/>
                  </Layout>
                  <SubComponents>
                    <Component class="javax.swing.JTextField" name="txtCariPlat">
                      <Properties>
                        <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                          <Font name="Segoe UI" size="16" style="1"/>
                        </Property>
                        <Property name="horizontalAlignment" type="int" value="0"/>
                        <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
                          <Dimension value="[0, 38]"/>
                        </Property>
                      </Properties>
                      <Constraints>
                        <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
                          <BorderConstraints direction="Center"/>
                        </Constraint>
                      </Constraints>
                    </Component>
                    <Component class="javax.swing.JButton" name="btnCari">
                      <Properties>
                        <Property name="text" type="java.lang.String" value="CARI"/>
                        <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
                          <Dimension value="[95, 38]"/>
                        </Property>
                      </Properties>
                      <Constraints>
                        <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
                          <BorderConstraints direction="East"/>
                        </Constraint>
                      </Constraints>
                    </Component>
                  </SubComponents>
                </Container>
                <Component class="javax.swing.JSeparator" name="jSeparator2">
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="2" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="10" insetsLeft="0" insetsBottom="10" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                
                <Component class="javax.swing.JLabel" name="lblPlat">
                  <Properties><Property name="text" type="java.lang.String" value="Plat Nomor"/></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="3" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="3" insetsLeft="0" insetsBottom="3" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JTextField" name="txtPlatNomor">
                  <Properties><Property name="enabled" type="boolean" value="false"/><Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor"><Dimension value="[0, 32]"/></Property></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="4" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="0" insetsBottom="8" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                
                <Component class="javax.swing.JLabel" name="lblJenis">
                  <Properties><Property name="text" type="java.lang.String" value="Jenis Kendaraan"/></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="5" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="3" insetsLeft="0" insetsBottom="3" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JTextField" name="txtJenis">
                  <Properties><Property name="enabled" type="boolean" value="false"/><Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor"><Dimension value="[0, 32]"/></Property></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="6" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="0" insetsBottom="8" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>

                <Component class="javax.swing.JLabel" name="lblJamMasuk">
                  <Properties><Property name="text" type="java.lang.String" value="Jam Masuk"/></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="7" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="3" insetsLeft="0" insetsBottom="3" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JTextField" name="txtJamMasuk">
                  <Properties><Property name="enabled" type="boolean" value="false"/><Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor"><Dimension value="[0, 32]"/></Property></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="8" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="0" insetsBottom="8" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>

                <Component class="javax.swing.JLabel" name="lblJamKeluar">
                  <Properties><Property name="text" type="java.lang.String" value="Jam Keluar (Sekarang)"/></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="9" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="3" insetsLeft="0" insetsBottom="3" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JTextField" name="txtJamKeluar">
                  <Properties><Property name="enabled" type="boolean" value="false"/><Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor"><Dimension value="[0, 32]"/></Property></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="10" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="0" insetsBottom="8" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>

                <Component class="javax.swing.JLabel" name="lblDurasi">
                  <Properties><Property name="text" type="java.lang.String" value="Durasi Parkir (Ceiling Jam)"/></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="11" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="3" insetsLeft="0" insetsBottom="3" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JTextField" name="txtDurasi">
                  <Properties><Property name="enabled" type="boolean" value="false"/><Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor"><Dimension value="[0, 32]"/></Property></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="12" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="0" insetsBottom="8" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>

                <Component class="javax.swing.JLabel" name="lblTotal">
                  <Properties><Property name="text" type="java.lang.String" value="Total Biaya Parkir"/></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="13" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="3" insetsLeft="0" insetsBottom="3" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JTextField" name="txtTotalBiaya">
                  <Properties><Property name="enabled" type="boolean" value="false"/><Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor"><Font name="Segoe UI" size="16" style="1"/></Property><Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor"><Dimension value="[0, 35]"/></Property></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="14" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="0" insetsBottom="10" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>

                <Component class="javax.swing.Box$Filler" name="formSpacer">
                  <Properties><Property name="maximumSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor"><Dimension value="[32767, 32767]"/></Property></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="15" gridWidth="1" gridHeight="1" fill="3" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="0" insetsBottom="0" insetsRight="0" anchor="10" weightX="1.0" weightY="1.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                
                <Container class="javax.swing.JPanel" name="buttonPanel">
                  <Properties><Property name="opaque" type="boolean" value="false"/></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="16" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="15" insetsLeft="0" insetsBottom="5" insetsRight="0" anchor="10" weightX="1.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                  <Layout class="org.netbeans.modules.form.compat2.layouts.DesignGridLayout"><Property name="columns" type="int" value="3"/><Property name="horizontalGap" type="int" value="5"/><Property name="rows" type="int" value="1"/><Property name="verticalGap" type="int" value="5"/></Layout>
                  <SubComponents>
                    <Component class="javax.swing.JButton" name="btnProsesKeluar"><Properties><Property name="text" type="java.lang.String" value="PROSES"/></Properties></Component>
                    <Component class="javax.swing.JButton" name="btnCetakStruk"><Properties><Property name="text" type="java.lang.String" value="STRUK"/></Properties></Component>
                    <Component class="javax.swing.JButton" name="btnReset"><Properties><Property name="text" type="java.lang.String" value="BATAL"/></Properties></Component>
                  </SubComponents>
                </Container>
              </SubComponents>
            </Container>
            <Container class="javax.swing.JPanel" name="receiptCard">
              <Properties>
                <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                  <Color blue="36" green="34" red="2d" type="rgb"/>
                </Property>
                <Property name="border" type="javax.swing.border.Border" editor="org.netbeans.modules.form.editors2.BorderEditor">
                  <Border info="org.netbeans.modules.form.compat2.border.CompoundBorderInfo">
                    <CompoundBorder>
                      <BorderInfo info="org.netbeans.modules.form.compat2.border.LineBorderInfo">
                        <LineBorder><Color blue="dc" green="dc" red="dc" type="rgb"/></LineBorder>
                      </BorderInfo>
                      <BorderInfo info="org.netbeans.modules.form.compat2.border.EmptyBorderInfo">
                        <EmptyBorder bottom="15" left="15" right="15" top="15"/>
                      </BorderInfo>
                    </CompoundBorder>
                  </Border>
                </Property>
              </Properties>
              <Layout class="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout"/>
              <SubComponents>
                <Component class="javax.swing.JLabel" name="lblReceiptHeader">
                  <Properties>
                    <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                      <Font name="Segoe UI" size="15" style="1"/>
                    </Property>
                    <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                      <Color blue="ff" green="ff" red="ff" type="rgb"/>
                    </Property>
                    <Property name="horizontalAlignment" type="int" value="0"/>
                    <Property name="text" type="java.lang.String" value="Preview Struk Pembayaran"/>
                  </Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
                      <BorderConstraints direction="North"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Container class="javax.swing.JScrollPane" name="receiptScroll">
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
                      <BorderConstraints direction="Center"/>
                    </Constraint>
                  </Constraints>
                  <Layout class="org.netbeans.modules.form.compat2.layouts.DesignJScrollPaneLayout"/>
                  <SubComponents>
                    <Component class="javax.swing.JTextArea" name="txtStrukArea">
                      <Properties>
                        <Property name="editable" type="boolean" value="false"/>
                        <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                          <Color blue="f0" green="ff" red="ff" type="rgb"/>
                        </Property>
                        <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                          <Font name="Courier New" size="13" style="0"/>
                        </Property>
                      </Properties>
                    </Component>
                  </SubComponents>
                </Container>
              </SubComponents>
            </Container>
          </SubComponents>
        </Container>"""

keluar_java_props = """
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
        txtStrukArea.setText("\\n\\n       BELUM ADA DATA TRANSAKSI.\\n  Silakan cari plat nomor di sebelah kiri.");
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
"""

keluar_java_body = """
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
"""

def make_transaksi_keluar():
    form_xml = get_outer_form_xml("Sistem Parkir Desktop - Parkir Keluar", keluar_xml)
    
    java_components_init = generate_standard_java_init("NewTransaksiKeluarView", "Sistem Parkir Desktop - Parkir Keluar", """
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
    """)

    imports = ""
    java_code = get_outer_java_code("NewTransaksiKeluarView", imports, keluar_java_props, "KELUAR", keluar_java_body)
    java_code += "\n    // <editor-fold defaultstate=\"collapsed\" desc=\"Generated Code\">//GEN-BEGIN:initComponents\n    private void initComponents() {"
    java_code += java_components_init
    java_code += "\n    }// </editor-fold>//GEN-END:initComponents\n"
    
    # Declarations
    java_code += """
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
    """
    java_code += "\n}\n"

    with open(os.path.join(view_dir, "NewTransaksiKeluarView.form"), "w", encoding="utf-8") as f:
        f.write(form_xml)
    with open(os.path.join(view_dir, "NewTransaksiKeluarView.java"), "w", encoding="utf-8") as f:
        f.write(java_code)

# -------------------------------------------------------------
# Generate NewLaporanView
# -------------------------------------------------------------
laporan_xml = """<Container class="javax.swing.JPanel" name="titlePanel">
          <Properties>
            <Property name="opaque" type="boolean" value="false"/>
            <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
              <Dimension value="[0, 40]"/>
            </Property>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
              <BorderConstraints direction="North"/>
            </Constraint>
          </Constraints>
          <Layout class="org.netbeans.modules.form.compat2.layouts.DesignFlowLayout">
            <Property name="alignment" type="int" value="0"/>
            <Property name="horizontalGap" type="int" value="0"/>
            <Property name="verticalGap" type="int" value="0"/>
          </Layout>
          <SubComponents>
            <Component class="javax.swing.JLabel" name="lblContentTitle">
              <Properties>
                <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                  <Font name="Segoe UI" size="22" style="1"/>
                </Property>
                <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                  <Color blue="2e" green="1a" red="1a" type="rgb"/>
                </Property>
                <Property name="text" type="java.lang.String" value="Laporan Transaksi Parkir"/>
              </Properties>
            </Component>
          </SubComponents>
        </Container>
        <Container class="javax.swing.JPanel" name="mainSplitPanel">
          <Properties>
            <Property name="opaque" type="boolean" value="false"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
              <BorderConstraints direction="Center"/>
            </Constraint>
          </Constraints>
          <Layout class="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout">
            <Property name="horizontalGap" type="int" value="15"/>
            <Property name="verticalGap" type="int" value="15"/>
          </Layout>
          <SubComponents>
            <Container class="javax.swing.JPanel" name="filterCard">
              <Properties>
                <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                  <Color blue="ff" green="ff" red="ff" type="rgb"/>
                </Property>
                <Property name="border" type="javax.swing.border.Border" editor="org.netbeans.modules.form.editors2.BorderEditor">
                  <Border info="org.netbeans.modules.form.compat2.border.CompoundBorderInfo">
                    <CompoundBorder>
                      <BorderInfo info="org.netbeans.modules.form.compat2.border.LineBorderInfo">
                        <LineBorder><Color blue="dc" green="dc" red="dc" type="rgb"/></LineBorder>
                      </BorderInfo>
                      <BorderInfo info="org.netbeans.modules.form.compat2.border.EmptyBorderInfo">
                        <EmptyBorder bottom="15" left="15" right="15" top="15"/>
                      </BorderInfo>
                    </CompoundBorder>
                  </Border>
                </Property>
              </Properties>
              <Constraints>
                <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
                  <BorderConstraints direction="North"/>
                </Constraint>
              </Constraints>
              <Layout class="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout"/>
              <SubComponents>
                <Component class="javax.swing.JLabel" name="lblStart">
                  <Properties><Property name="text" type="java.lang.String" value="Mulai Tanggal:"/></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="0" gridY="0" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="5" insetsBottom="5" insetsRight="5" anchor="10" weightX="0.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="com.toedter.calendar.JDateChooser" name="dateStart">
                  <Properties><Property name="dateFormatString" type="java.lang.String" value="yyyy-MM-dd"/><Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor"><Dimension value="[130, 32]"/></Property></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="1" gridY="0" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="5" insetsBottom="5" insetsRight="5" anchor="10" weightX="0.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JLabel" name="lblEnd">
                  <Properties><Property name="text" type="java.lang.String" value="Sampai Tanggal:"/></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="2" gridY="0" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="5" insetsBottom="5" insetsRight="5" anchor="10" weightX="0.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="com.toedter.calendar.JDateChooser" name="dateEnd">
                  <Properties><Property name="dateFormatString" type="java.lang.String" value="yyyy-MM-dd"/><Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor"><Dimension value="[130, 32]"/></Property></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="3" gridY="0" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="5" insetsBottom="5" insetsRight="5" anchor="10" weightX="0.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JLabel" name="lblSearchPlat">
                  <Properties><Property name="text" type="java.lang.String" value="Cari Plat:"/></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="4" gridY="0" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="5" insetsBottom="5" insetsRight="5" anchor="10" weightX="0.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JTextField" name="txtSearchPlat">
                  <Properties><Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor"><Dimension value="[110, 32]"/></Property></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="5" gridY="0" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="5" insetsBottom="5" insetsRight="5" anchor="10" weightX="0.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JButton" name="btnFilter">
                  <Properties><Property name="text" type="java.lang.String" value="FILTER"/><Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor"><Dimension value="[95, 32]"/></Property></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="6" gridY="0" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="5" insetsBottom="5" insetsRight="5" anchor="10" weightX="0.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JButton" name="btnReset">
                  <Properties><Property name="text" type="java.lang.String" value="RESET"/><Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor"><Dimension value="[95, 32]"/></Property></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="7" gridY="0" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="5" insetsBottom="5" insetsRight="5" anchor="10" weightX="0.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
                <Component class="javax.swing.JButton" name="btnPrint">
                  <Properties><Property name="text" type="java.lang.String" value="PRINT"/><Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor"><Dimension value="[95, 32]"/></Property></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
                      <GridBagConstraints gridX="8" gridY="0" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="5" insetsBottom="5" insetsRight="5" anchor="10" weightX="0.0" weightY="0.0"/>
                    </Constraint>
                  </Constraints>
                </Component>
              </SubComponents>
            </Container>
            <Container class="javax.swing.JPanel" name="tableCard">
              <Properties>
                <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                  <Color blue="ff" green="ff" red="ff" type="rgb"/>
                </Property>
                <Property name="border" type="javax.swing.border.Border" editor="org.netbeans.modules.form.editors2.BorderEditor">
                  <Border info="org.netbeans.modules.form.compat2.border.CompoundBorderInfo">
                    <CompoundBorder>
                      <BorderInfo info="org.netbeans.modules.form.compat2.border.LineBorderInfo">
                        <LineBorder><Color blue="dc" green="dc" red="dc" type="rgb"/></LineBorder>
                      </BorderInfo>
                      <BorderInfo info="org.netbeans.modules.form.compat2.border.EmptyBorderInfo">
                        <EmptyBorder bottom="15" left="15" right="15" top="15"/>
                      </BorderInfo>
                    </CompoundBorder>
                  </Border>
                </Property>
              </Properties>
              <Constraints>
                <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
                  <BorderConstraints direction="Center"/>
                </Constraint>
              </Constraints>
              <Layout class="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout"/>
              <SubComponents>
                <Container class="javax.swing.JScrollPane" name="jScrollPane1">
                  <Layout class="org.netbeans.modules.form.compat2.layouts.DesignJScrollPaneLayout"/>
                  <SubComponents>
                    <Component class="javax.swing.JTable" name="tblLaporan">
                      <Properties>
                        <Property name="model" type="javax.swing.table.TableModel" editor="org.netbeans.modules.form.editors2.TableModelEditor">
                          <Table columnCount="8" rowCount="0">
                            <Column editable="false" title="ID Transaksi" type="java.lang.Object"/>
                            <Column editable="false" title="Plat Nomor" type="java.lang.Object"/>
                            <Column editable="false" title="Jenis" type="java.lang.Object"/>
                            <Column editable="false" title="Jam Masuk" type="java.lang.Object"/>
                            <Column editable="false" title="Jam Keluar" type="java.lang.Object"/>
                            <Column editable="false" title="Durasi" type="java.lang.Object"/>
                            <Column editable="false" title="Biaya" type="java.lang.Object"/>
                            <Column editable="false" title="Petugas Keluar" type="java.lang.Object"/>
                          </Table>
                        </Property>
                      </Properties>
                    </Component>
                  </SubComponents>
                </Container>
              </SubComponents>
            </Container>
            <Container class="javax.swing.JPanel" name="summaryPanel">
              <Constraints>
                <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
                  <BorderConstraints direction="South"/>
                </Constraint>
              </Constraints>
              <Layout class="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout"/>
              <SubComponents>
                <Container class="javax.swing.JPanel" name="infoGrid">
                  <Properties><Property name="opaque" type="boolean" value="false"/></Properties>
                  <Constraints>
                    <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
                      <BorderConstraints direction="Center"/>
                    </Constraint>
                  </Constraints>
                  <Layout class="org.netbeans.modules.form.compat2.layouts.DesignGridLayout"><Property name="columns" type="int" value="2"/><Property name="horizontalGap" type="int" value="20"/><Property name="rows" type="int" value="1"/><Property name="verticalGap" type="int" value="20"/></Layout>
                  <SubComponents>
                    <Container class="javax.swing.JPanel" name="transCard">
                      <Properties>
                        <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor"><Color blue="ff" green="ff" red="ff" type="rgb"/></Property>
                        <Property name="border" type="javax.swing.border.Border" editor="org.netbeans.modules.form.editors2.BorderEditor"><Border info="org.netbeans.modules.form.compat2.border.LineBorderInfo"><LineBorder><Color blue="dc" green="dc" red="dc" type="rgb"/></LineBorder></Border></Property>
                      </Properties>
                      <Layout class="org.netbeans.modules.form.compat2.layouts.DesignFlowLayout"><Property name="alignment" type="int" value="0"/><Property name="horizontalGap" type="int" value="20"/><Property name="verticalGap" type="int" value="15"/></Layout>
                      <SubComponents>
                        <Component class="javax.swing.JLabel" name="lblTransTitle"><Properties><Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor"><Font name="Segoe UI" size="14" style="0"/></Property><Property name="text" type="java.lang.String" value="Total Transaksi Selesai:"/></Properties></Component>
                        <Component class="javax.swing.JLabel" name="lblTotalTransactions"><Properties><Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor"><Font name="Segoe UI" size="22" style="1"/></Property><Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor"><Color blue="60" green="34" red="0f" type="rgb"/></Property><Property name="text" type="java.lang.String" value="0"/></Properties></Component>
                      </SubComponents>
                    </Container>
                    <Container class="javax.swing.JPanel" name="revCard">
                      <Properties>
                        <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor"><Color blue="ff" green="ff" red="ff" type="rgb"/></Property>
                        <Property name="border" type="javax.swing.border.Border" editor="org.netbeans.modules.form.editors2.BorderEditor"><Border info="org.netbeans.modules.form.compat2.border.LineBorderInfo"><LineBorder><Color blue="dc" green="dc" red="dc" type="rgb"/></LineBorder></Border></Property>
                      </Properties>
                      <Layout class="org.netbeans.modules.form.compat2.layouts.DesignFlowLayout"><Property name="alignment" type="int" value="0"/><Property name="horizontalGap" type="int" value="20"/><Property name="verticalGap" type="int" value="15"/></Layout>
                      <SubComponents>
                        <Component class="javax.swing.JLabel" name="lblRevTitle"><Properties><Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor"><Font name="Segoe UI" size="14" style="0"/></Property><Property name="text" type="java.lang.String" value="Total Pendapatan Parkir:"/></Properties></Component>
                        <Component class="javax.swing.JLabel" name="lblTotalRevenue"><Properties><Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor"><Font name="Segoe UI" size="22" style="1"/></Property><Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor"><Color blue="94" green="b8" red="0" type="rgb"/></Property><Property name="text" type="java.lang.String" value="Rp 0"/></Properties></Component>
                      </SubComponents>
                    </Container>
                  </SubComponents>
                </Container>
              </SubComponents>
            </Container>
          </SubComponents>
        </Container>"""

laporan_java_props = """
    private DefaultTableModel tableModel;

    // UI elements declared in form
    private com.toedter.calendar.JDateChooser dateStart;
    private com.toedter.calendar.JDateChooser dateEnd;
    private javax.swing.JTextField txtSearchPlat;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnPrint;
    private javax.swing.JTable tblLaporan;
    private javax.swing.JLabel lblTotalTransactions;
    private javax.swing.JLabel lblTotalRevenue;

    private javax.swing.JLabel lblStart;
    private javax.swing.JLabel lblEnd;
    private javax.swing.JLabel lblSearchPlat;
    private javax.swing.JPanel filterCard;
    private javax.swing.JPanel tableCard;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel summaryPanel;
    private javax.swing.JPanel infoGrid;
    private javax.swing.JPanel transCard;
    private javax.swing.JLabel lblTransTitle;
    private javax.swing.JPanel revCard;
    private javax.swing.JLabel lblRevTitle;
    private javax.swing.JPanel mainSplitPanel;
    private javax.swing.JPanel titlePanel;

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
            String formatMasuk = t.getJamMasuk() != null ? t.getJamMasuk().toString() : "-";
            String formatKeluar = t.getJamKeluar() != null ? t.getJamKeluar().toString() : "-";
            String durasiStr = t.getStatus().equals("KELUAR") ? t.getDurasiJam() + " Jam" : "-";
            
            double biayaValue = t.getStatus().equals("KELUAR") ? t.getTotalBiaya() : 0.0;
            String biayaStr = com.mycompany.tugasakhir.util.CurrencyUtil.formatRupiah(biayaValue);
            
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
        lblTotalRevenue.setText(com.mycompany.tugasakhir.util.CurrencyUtil.formatRupiah(totalRev));
    }
"""

laporan_java_body = """
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
"""

def make_laporan():
    form_xml = get_outer_form_xml("Sistem Parkir Desktop - Laporan", laporan_xml)
    
    java_components_init = generate_standard_java_init("NewLaporanView", "Sistem Parkir Desktop - Laporan", """
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
        filterCard.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)), javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        filterCard.setLayout(new java.awt.GridBagLayout());

        lblStart.setText("Mulai Tanggal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        filterCard.add(lblStart, gridBagConstraints);

        dateStart.setDateFormatString("yyyy-MM-dd");
        dateStart.setPreferredSize(new java.awt.Dimension(130, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        filterCard.add(dateStart, gridBagConstraints);

        lblEnd.setText("Sampai Tanggal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        filterCard.add(lblEnd, gridBagConstraints);

        dateEnd.setDateFormatString("yyyy-MM-dd");
        dateEnd.setPreferredSize(new java.awt.Dimension(130, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        filterCard.add(dateEnd, gridBagConstraints);

        lblSearchPlat.setText("Cari Plat:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        filterCard.add(lblSearchPlat, gridBagConstraints);

        txtSearchPlat.setPreferredSize(new java.awt.Dimension(110, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        filterCard.add(txtSearchPlat, gridBagConstraints);

        btnFilter.setText("FILTER");
        btnFilter.setPreferredSize(new java.awt.Dimension(95, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        filterCard.add(btnFilter, gridBagConstraints);

        btnReset.setText("RESET");
        btnReset.setPreferredSize(new java.awt.Dimension(95, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        filterCard.add(btnReset, gridBagConstraints);

        btnPrint.setText("PRINT");
        btnPrint.setPreferredSize(new java.awt.Dimension(95, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        filterCard.add(btnPrint, gridBagConstraints);

        mainSplitPanel.add(filterCard, java.awt.BorderLayout.NORTH);

        tableCard.setBackground(new java.awt.Color(255, 255, 255));
        tableCard.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)), javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        tableCard.setLayout(new java.awt.BorderLayout());

        tblLaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID Transaksi", "Plat Nomor", "Jenis", "Jam Masuk", "Jam Keluar", "Durasi", "Biaya", "Petugas Keluar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLaporan);

        tableCard.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        mainSplitPanel.add(tableCard, java.awt.BorderLayout.CENTER);

        summaryPanel.setOpaque(false);
        summaryPanel.setLayout(new java.awt.BorderLayout());

        infoGrid.setOpaque(false);
        infoGrid.setLayout(new java.awt.GridLayout(1, 2, 20, 20));

        transCard.setBackground(new java.awt.Color(255, 255, 255));
        transCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
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
        revCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
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
    """)

    imports = "import javax.swing.table.DefaultTableModel;\n"
    java_code = get_outer_java_code("NewLaporanView", imports, laporan_java_props, "LAPORAN", laporan_java_body)
    java_code += "\n    // <editor-fold defaultstate=\"collapsed\" desc=\"Generated Code\">//GEN-BEGIN:initComponents\n    private void initComponents() {"
    java_code += java_components_init
    java_code += "\n    }// </editor-fold>//GEN-END:initComponents\n"
    
    # Declarations
    java_code += """
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
    """
    java_code += "\n}\n"

    with open(os.path.join(view_dir, "NewLaporanView.form"), "w", encoding="utf-8") as f:
        f.write(form_xml)
    with open(os.path.join(view_dir, "NewLaporanView.java"), "w", encoding="utf-8") as f:
        f.write(java_code)

# Execute generators
make_kendaraan()
make_tarif()
make_petugas()
make_user()
make_transaksi_masuk()
make_transaksi_keluar()
make_laporan()
print("Generated remaining 7 views.")
