import os

view_dir = r"c:\Users\DELL\OneDrive\Documents\NetBeansProjects\tugasakhir\src\main\java\com\mycompany\tugasakhir\view"

# 1. XML Form Shared Template
def get_outer_form_xml(title, content_xml, imports_xml=""):
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
        // Custom styling/logic hook
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

# Let's define specific content areas.
# 3. NewLoginView
login_form = """<?xml version="1.0" encoding="UTF-8" ?>
<Form version="1.3" maxVersion="1.9" type="org.netbeans.modules.form.forminfo.JFrameFormInfo">
  <Properties>
    <Property name="defaultCloseOperation" type="int" value="3"/>
    <Property name="title" type="java.lang.String" value="Sistem Parkir Desktop - Login"/>
    <Property name="resizable" type="boolean" value="false"/>
  </Properties>
  <SyntheticProperties>
    <SyntheticProperty name="formSizePolicy" type="int" value="1"/>
    <SyntheticProperty name="generateCenter" type="boolean" value="true"/>
  </SyntheticProperties>
  <Layout class="org.netbeans.modules.form.compat2.layouts.DesignGridLayout">
    <Property name="columns" type="int" value="2"/>
    <Property name="rows" type="int" value="1"/>
  </Layout>
  <SubComponents>
    <Container class="javax.swing.JPanel" name="leftPanel">
      <Properties>
        <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
          <Color blue="2e" green="1a" red="1a" type="rgb"/>
        </Property>
      </Properties>
      <Layout class="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout"/>
      <SubComponents>
        <Component class="javax.swing.JLabel" name="lblLogo">
          <Properties>
            <Property name="horizontalAlignment" type="int" value="0"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="0" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="10" insetsLeft="20" insetsBottom="10" insetsRight="20" anchor="10" weightX="0.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JLabel" name="lblTitle">
          <Properties>
            <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
              <Font name="Segoe UI" size="28" style="1"/>
            </Property>
            <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
              <Color blue="ff" green="ff" red="ff" type="rgb"/>
            </Property>
            <Property name="horizontalAlignment" type="int" value="0"/>
            <Property name="text" type="java.lang.String" value="PARKIR SYSTEM"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="1" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="10" insetsLeft="20" insetsBottom="10" insetsRight="20" anchor="10" weightX="0.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JLabel" name="lblSub">
          <Properties>
            <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
              <Color blue="e3" green="e6" red="df" type="rgb"/>
            </Property>
            <Property name="horizontalAlignment" type="int" value="0"/>
            <Property name="text" type="java.lang.String" value="Aplikasi Manajemen Parkir Modern &amp; Profesional"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="2" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="10" insetsLeft="20" insetsBottom="10" insetsRight="20" anchor="10" weightX="0.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JLabel" name="lblFooter">
          <Properties>
            <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
              <Font name="Segoe UI" size="10" style="2"/>
            </Property>
            <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
              <Color blue="c3" green="be" red="b2" type="rgb"/>
            </Property>
            <Property name="horizontalAlignment" type="int" value="0"/>
            <Property name="text" type="java.lang.String" value="Tugas Akhir Mahasiswa v1.0"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="3" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="50" insetsLeft="20" insetsBottom="10" insetsRight="20" anchor="10" weightX="0.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
      </SubComponents>
    </Container>
    <Container class="javax.swing.JPanel" name="rightPanel">
      <Properties>
        <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
          <Color blue="ff" green="ff" red="ff" type="rgb"/>
        </Property>
      </Properties>
      <Layout class="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout"/>
      <SubComponents>
        <Component class="javax.swing.JLabel" name="lblWelcome">
          <Properties>
            <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
              <Font name="Segoe UI" size="26" style="1"/>
            </Property>
            <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
              <Color blue="36" green="34" red="2d" type="rgb"/>
            </Property>
            <Property name="text" type="java.lang.String" value="Selamat Datang"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="0" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="5" insetsLeft="40" insetsBottom="5" insetsRight="40" anchor="10" weightX="1.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JLabel" name="lblSubWelcome">
          <Properties>
            <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
              <Font name="Segoe UI" size="13" style="0"/>
            </Property>
            <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
              <Color blue="73" green="6e" red="63" type="rgb"/>
            </Property>
            <Property name="text" type="java.lang.String" value="Silakan masuk menggunakan akun Anda"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="1" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="40" insetsBottom="20" insetsRight="40" anchor="10" weightX="1.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JLabel" name="lblUser">
          <Properties>
            <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
              <Font name="Segoe UI" size="12" style="1"/>
            </Property>
            <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
              <Color blue="73" green="6e" red="63" type="rgb"/>
            </Property>
            <Property name="text" type="java.lang.String" value="Username"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="2" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="10" insetsLeft="40" insetsBottom="5" insetsRight="40" anchor="10" weightX="1.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JTextField" name="txtUsername">
          <Properties>
            <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
              <Dimension value="[280, 40]"/>
            </Property>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="3" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="40" insetsBottom="10" insetsRight="40" anchor="10" weightX="1.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JLabel" name="lblPass">
          <Properties>
            <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
              <Font name="Segoe UI" size="12" style="1"/>
            </Property>
            <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
              <Color blue="73" green="6e" red="63" type="rgb"/>
            </Property>
            <Property name="text" type="java.lang.String" value="Password"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="4" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="10" insetsLeft="40" insetsBottom="5" insetsRight="40" anchor="10" weightX="1.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JPasswordField" name="txtPassword">
          <Properties>
            <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
              <Dimension value="[280, 40]"/>
            </Property>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="5" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="40" insetsBottom="15" insetsRight="40" anchor="10" weightX="1.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JLabel" name="lblError">
          <Properties>
            <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
              <Color blue="31" green="30" red="d6" type="rgb"/>
            </Property>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="6" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="0" insetsLeft="40" insetsBottom="10" insetsRight="40" anchor="10" weightX="1.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
        <Component class="javax.swing.JButton" name="btnLogin">
          <Properties>
            <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
              <Font name="Segoe UI" size="14" style="1"/>
            </Property>
            <Property name="text" type="java.lang.String" value="MASUK"/>
            <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
              <Dimension value="[280, 45]"/>
            </Property>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout" value="org.netbeans.modules.form.compat2.layouts.DesignGridBagLayout$GridBagConstraintsDescription">
              <GridBagConstraints gridX="0" gridY="7" gridWidth="1" gridHeight="1" fill="2" ipadX="0" ipadY="0" insetsTop="10" insetsLeft="40" insetsBottom="10" insetsRight="40" anchor="10" weightX="1.0" weightY="0.0"/>
            </Constraint>
          </Constraints>
        </Component>
      </SubComponents>
    </Container>
  </SubComponents>
</Form>
"""

login_java = """package com.mycompany.tugasakhir.view;

import com.mycompany.tugasakhir.util.VectorIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NewLoginView extends javax.swing.JFrame {

    public NewLoginView() {
        initComponents();
        lblLogo.setIcon(new VectorIcon(VectorIcon.Type.KENDARAAN, 80, Color.WHITE));
        
        // Gradient styling left panel
        leftPanel = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(26, 26, 46), 
                        getWidth(), getHeight(), new Color(15, 52, 96)
                );
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.setColor(new Color(233, 69, 96, 40));
                g2.fillOval(-50, -50, 200, 200);
                g2.fillOval(getWidth() - 100, getHeight() - 100, 150, 150);
                g2.dispose();
            }
        };
        
        // Style masuk button
        btnLogin.setBackground(new Color(233, 69, 96));
        btnLogin.setForeground(Color.WHITE);
        
        setSize(800, 500);
        setLocationRelativeTo(null);
    }

    public String getUsername() { return txtUsername.getText().trim(); }
    public String getPassword() { return new String(txtPassword.getPassword()); }

    public void addLoginListener(ActionListener l) {
        btnLogin.addActionListener(l);
        txtUsername.addActionListener(l);
        txtPassword.addActionListener(l);
    }

    public void showErrorMessage(String msg) { lblError.setText(msg); }
    public void clearFields() {
        txtUsername.setText("");
        txtPassword.setText("");
        lblError.setText("");
        txtUsername.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        leftPanel = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblSub = new javax.swing.JLabel();
        lblFooter = new javax.swing.JLabel();
        rightPanel = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        lblSubWelcome = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPass = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblError = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Parkir Desktop - Login");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        leftPanel.setBackground(new java.awt.Color(26, 26, 46));
        leftPanel.setLayout(new java.awt.GridBagLayout());

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        leftPanel.add(lblLogo, gridBagConstraints);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("PARKIR SYSTEM");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        leftPanel.add(lblTitle, gridBagConstraints);

        lblSub.setForeground(new java.awt.Color(223, 230, 227));
        lblSub.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSub.setText("Aplikasi Manajemen Parkir Modern & Profesional");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        leftPanel.add(lblSub, gridBagConstraints);

        lblFooter.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        lblFooter.setForeground(new java.awt.Color(178, 190, 195));
        lblFooter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFooter.setText("Tugas Akhir Mahasiswa v1.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(50, 20, 10, 20);
        leftPanel.add(lblFooter, gridBagConstraints);

        getContentPane().add(leftPanel);

        rightPanel.setBackground(new java.awt.Color(255, 255, 255));
        rightPanel.setLayout(new java.awt.GridBagLayout());

        lblWelcome.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(45, 52, 54));
        lblWelcome.setText("Selamat Datang");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 40, 5, 40);
        rightPanel.add(lblWelcome, gridBagConstraints);

        lblSubWelcome.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubWelcome.setForeground(new java.awt.Color(99, 110, 115));
        lblSubWelcome.setText("Silakan masuk menggunakan akun Anda");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 20, 40);
        rightPanel.add(lblSubWelcome, gridBagConstraints);

        lblUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUser.setForeground(new java.awt.Color(99, 110, 115));
        lblUser.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 5, 40);
        rightPanel.add(lblUser, gridBagConstraints);

        txtUsername.setPreferredSize(new java.awt.Dimension(280, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 10, 40);
        rightPanel.add(txtUsername, gridBagConstraints);

        lblPass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPass.setForeground(new java.awt.Color(99, 110, 115));
        lblPass.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 5, 40);
        rightPanel.add(lblPass, gridBagConstraints);

        txtPassword.setPreferredSize(new java.awt.Dimension(280, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 15, 40);
        rightPanel.add(txtPassword, gridBagConstraints);

        lblError.setForeground(new java.awt.Color(214, 48, 49));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 10, 40);
        rightPanel.add(lblError, gridBagConstraints);

        btnLogin.setText("MASUK");
        btnLogin.setPreferredSize(new java.awt.Dimension(280, 45));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 10, 40);
        rightPanel.add(btnLogin, gridBagConstraints);

        getContentPane().add(rightPanel);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblFooter;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblSub;
    private javax.swing.JLabel lblSubWelcome;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
}
"""

def generate_login():
    with open(os.path.join(view_dir, "NewLoginView.form"), "w", encoding="utf-8") as f:
        f.write(login_form)
    with open(os.path.join(view_dir, "NewLoginView.java"), "w", encoding="utf-8") as f:
        f.write(login_java)

# 4. NewDashboardView
dashboard_xml = """<Container class="javax.swing.JPanel" name="titlePanel">
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
                <Property name="text" type="java.lang.String" value="Statistik Parkir Hari Ini"/>
              </Properties>
            </Component>
          </SubComponents>
        </Container>
        <Container class="javax.swing.JPanel" name="centerPanel">
          <Properties>
            <Property name="opaque" type="boolean" value="false"/>
          </Properties>
          <Constraints>
            <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
              <BorderConstraints direction="Center"/>
            </Constraint>
          </Constraints>
          <Layout class="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout">
            <Property name="horizontalGap" type="int" value="20"/>
            <Property name="verticalGap" type="int" value="20"/>
          </Layout>
          <SubComponents>
            <Container class="javax.swing.JPanel" name="cardGrid">
              <Properties>
                <Property name="opaque" type="boolean" value="false"/>
              </Properties>
              <Constraints>
                <Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout" value="org.netbeans.modules.form.compat2.layouts.DesignBorderLayout$BorderConstraintsDescription">
                  <BorderConstraints direction="North"/>
                </Constraint>
              </Constraints>
              <Layout class="org.netbeans.modules.form.compat2.layouts.DesignGridLayout">
                <Property name="columns" type="int" value="4"/>
                <Property name="horizontalGap" type="int" value="15"/>
                <Property name="rows" type="int" value="1"/>
                <Property name="verticalGap" type="int" value="15"/>
              </Layout>
              <SubComponents>
                <Container class="javax.swing.JPanel" name="pnlCardActive">
                  <Properties>
                    <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                      <Color blue="60" green="34" red="0f" type="rgb"/>
                    </Property>
                    <Property name="preferredSize" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor">
                      <Dimension value="[240, 110]"/>
                    </Property>
                  </Properties>
                  <Layout class="org.netbeans.modules.form.compat2.layouts.DesignGridLayout">
                    <Property name="columns" type="int" value="1"/>
                    <Property name="rows" type="int" value="2"/>
                  </Layout>
                  <SubComponents>
                    <Component class="javax.swing.JLabel" name="lblActiveTitle">
                      <Properties>
                        <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                          <Font name="Segoe UI" size="12" style="1"/>
                        </Property>
                        <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                          <Color blue="ff" green="ff" red="ff" type="rgb"/>
                        </Property>
                        <Property name="text" type="java.lang.String" value="  KENDARAAN PARKIR"/>
                      </Properties>
                    </Component>
                    <Component class="javax.swing.JLabel" name="lblActiveVal">
                      <Properties>
                        <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                          <Font name="Segoe UI" size="26" style="1"/>
                        </Property>
                        <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                          <Color blue="ff" green="ff" red="ff" type="rgb"/>
                        </Property>
                        <Property name="text" type="java.lang.String" value="  0"/>
                      </Properties>
                    </Component>
                  </SubComponents>
                </Container>
                <Container class="javax.swing.JPanel" name="pnlCardTrans">
                  <Properties>
                    <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                      <Color blue="60" green="45" red="e9" type="rgb"/>
                    </Property>
                  </Properties>
                  <Layout class="org.netbeans.modules.form.compat2.layouts.DesignGridLayout">
                    <Property name="columns" type="int" value="1"/>
                    <Property name="rows" type="int" value="2"/>
                  </Layout>
                  <SubComponents>
                    <Component class="javax.swing.JLabel" name="lblTransTitle">
                      <Properties>
                        <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                          <Font name="Segoe UI" size="12" style="1"/>
                        </Property>
                        <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                          <Color blue="ff" green="ff" red="ff" type="rgb"/>
                        </Property>
                        <Property name="text" type="java.lang.String" value="  TRANSAKSI HARI INI"/>
                      </Properties>
                    </Component>
                    <Component class="javax.swing.JLabel" name="lblTransVal">
                      <Properties>
                        <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                          <Font name="Segoe UI" size="26" style="1"/>
                        </Property>
                        <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                          <Color blue="ff" green="ff" red="ff" type="rgb"/>
                        </Property>
                        <Property name="text" type="java.lang.String" value="  0"/>
                      </Properties>
                    </Component>
                  </SubComponents>
                </Container>
                <Container class="javax.swing.JPanel" name="pnlCardRev">
                  <Properties>
                    <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                      <Color blue="94" green="b8" red="0" type="rgb"/>
                    </Property>
                  </Properties>
                  <Layout class="org.netbeans.modules.form.compat2.layouts.DesignGridLayout">
                    <Property name="columns" type="int" value="1"/>
                    <Property name="rows" type="int" value="2"/>
                  </Layout>
                  <SubComponents>
                    <Component class="javax.swing.JLabel" name="lblRevTitle">
                      <Properties>
                        <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                          <Font name="Segoe UI" size="12" style="1"/>
                        </Property>
                        <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                          <Color blue="ff" green="ff" red="ff" type="rgb"/>
                        </Property>
                        <Property name="text" type="java.lang.String" value="  PENDAPATAN HARI INI"/>
                      </Properties>
                    </Component>
                    <Component class="javax.swing.JLabel" name="lblRevVal">
                      <Properties>
                        <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                          <Font name="Segoe UI" size="26" style="1"/>
                        </Property>
                        <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                          <Color blue="ff" green="ff" red="ff" type="rgb"/>
                        </Property>
                        <Property name="text" type="java.lang.String" value="  Rp 0"/>
                      </Properties>
                    </Component>
                  </SubComponents>
                </Container>
                <Container class="javax.swing.JPanel" name="pnlCardPetugas">
                  <Properties>
                    <Property name="background" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                      <Color blue="6e" green="cb" red="fd" type="rgb"/>
                    </Property>
                  </Properties>
                  <Layout class="org.netbeans.modules.form.compat2.layouts.DesignGridLayout">
                    <Property name="columns" type="int" value="1"/>
                    <Property name="rows" type="int" value="2"/>
                  </Layout>
                  <SubComponents>
                    <Component class="javax.swing.JLabel" name="lblPetugasTitle">
                      <Properties>
                        <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                          <Font name="Segoe UI" size="12" style="1"/>
                        </Property>
                        <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                          <Color blue="36" green="34" red="2d" type="rgb"/>
                        </Property>
                        <Property name="text" type="java.lang.String" value="  TOTAL PETUGAS"/>
                      </Properties>
                    </Component>
                    <Component class="javax.swing.JLabel" name="lblPetugasVal">
                      <Properties>
                        <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
                          <Font name="Segoe UI" size="26" style="1"/>
                        </Property>
                        <Property name="foreground" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
                          <Color blue="36" green="34" red="2d" type="rgb"/>
                        </Property>
                        <Property name="text" type="java.lang.String" value="  0"/>
                      </Properties>
                    </Component>
                  </SubComponents>
                </Container>
              </SubComponents>
            </Container>
            <Container class="javax.swing.JPanel" name="tablePanel">
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
                    <Property name="text" type="java.lang.String" value="Transaksi Parkir Terkini"/>
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
                    <Component class="javax.swing.JTable" name="tblRecent">
                      <Properties>
                        <Property name="model" type="javax.swing.table.TableModel" editor="org.netbeans.modules.form.editors2.TableModelEditor">
                          <Table columnCount="7" rowCount="0">
                            <Column editable="false" title="ID" type="java.lang.Object"/>
                            <Column editable="false" title="Plat Nomor" type="java.lang.Object"/>
                            <Column editable="false" title="Jenis Kendaraan" type="java.lang.Object"/>
                            <Column editable="false" title="Jam Masuk" type="java.lang.Object"/>
                            <Column editable="false" title="Jam Keluar" type="java.lang.Object"/>
                            <Column editable="false" title="Total Biaya" type="java.lang.Object"/>
                            <Column editable="false" title="Status" type="java.lang.Object"/>
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

dashboard_java_body = """
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
"""

dashboard_java_props = """
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
"""

def generate_dashboard():
    form_content = get_outer_form_xml("Sistem Parkir Desktop - Dashboard", dashboard_xml)
    
    # We must insert the components into standard guarded declarations
    java_header_imports = """
import javax.swing.table.DefaultTableModel;
import com.mycompany.tugasakhir.util.VectorIcon;
"""
    
    # Generate standard guarded variables declaration
    java_vars_decl = """
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
"""

    java_components_init = """
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
"""

    java_code = get_outer_java_code("NewDashboardView", java_header_imports, dashboard_java_props, "DASHBOARD", dashboard_java_body)
    java_code += "\n    // <editor-fold defaultstate=\"collapsed\" desc=\"Generated Code\">//GEN-BEGIN:initComponents\n    private void initComponents() {"
    java_code += java_components_init
    java_code += "\n    }// </editor-fold>//GEN-END:initComponents\n"
    java_code += "\n    private javax.swing.JPanel pnlCardActive;\n    private javax.swing.JPanel pnlCardPetugas;\n    private javax.swing.JPanel pnlCardRev;\n    private javax.swing.JPanel pnlCardTrans;\n"
    java_code += java_vars_decl
    java_code += "\n}\n"

    with open(os.path.join(view_dir, "NewDashboardView.form"), "w", encoding="utf-8") as f:
        f.write(form_content)
    with open(os.path.join(view_dir, "NewDashboardView.java"), "w", encoding="utf-8") as f:
        f.write(java_code)

# Let's run generating login & dashboard to verify
generate_login()
generate_dashboard()
print("Generated login & dashboard.")
