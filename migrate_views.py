import os

view_dir = r"c:\Users\DELL\OneDrive\Documents\NetBeansProjects\tugasakhir\src\main\java\com\mycompany\tugasakhir\view"

# Generate NewKendaraanView.form and NewKendaraanView.java
def generate_kendaraan():
    form_content = """<?xml version="1.0" encoding="UTF-8" ?>
<Form version="1.3" maxVersion="1.9" type="org.netbeans.modules.form.forminfo.JFrameFormInfo">
  <Properties>
    <Property name="defaultCloseOperation" type="int" value="3"/>
    <Property name="title" type="java.lang.String" value="Sistem Parkir Desktop - Kelola Kendaraan"/>
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
            <Property name="text" type="java.lang.String" value="Kelola Kendaraan"/>
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
        <Container class="javax.swing.JPanel" name="titlePanel">
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
                <Property name="text" type="java.lang.String" value="Kelola Jenis Kendaraan &amp; Tarif Awal"/>
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
                
                <Component class="javax.swing.JLabel" name="lblIdLabel">
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
                
                <Component class="javax.swing.JLabel" name="lblJenisLabel">
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
                
                <Component class="javax.swing.JLabel" name="lblTarifAwalLabel">
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

                <Component class="javax.swing.JLabel" name="lblTarifPerJamLabel">
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

                <Component class="javax.swing.JLabel" name="lblStatusLabel">
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
                </Component>

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
                    <Component class="javax.swing.JTable" name="tblKendaraan">
                      <Properties>
                        <Property name="model" type="javax.swing.table.TableModel" editor="org.netbeans.modules.form.editors2.TableModelEditor">
                          <Table columnCount="5" rowCount="0">
                            <Column editable="false" title="ID" type="java.lang.Object"/>
                            <Column editable="false" title="Jenis Kendaraan" type="java.lang.Object"/>
                            <Column editable="false" title="Tarif Awal" type="java.lang.Object"/>
                            <Column editable="false" title="Tarif Per Jam" type="java.lang.Object"/>
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
        </Container>
        
      </SubComponents>
    </Container>
  </SubComponents>
</Form>
"""
    
    java_content = """package com.mycompany.tugasakhir.view;

import com.mycompany.tugasakhir.model.Kendaraan;
import com.mycompany.tugasakhir.util.CurrencyUtil;
import com.mycompany.tugasakhir.util.SessionManager;
import com.mycompany.tugasakhir.util.TableUtil;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JFrame Form untuk menu Kelola Kendaraan.
 */
public class NewKendaraanView extends javax.swing.JFrame {

    private final Map<String, JButton> navButtons = new HashMap<>();
    private String currentCardName = "KENDARAAN";
    private DefaultTableModel tableModel;

    private JMenuItem menuLogout;
    private JMenu menuMasterData;
    private JMenu menuLaporan;

    public NewKendaraanView() {
        initComponents();
        tableModel = (DefaultTableModel) tblKendaraan.getModel();
        TableUtil.styleTable(tblKendaraan);
        
        // Alignments
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblKendaraan.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblKendaraan.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        javax.swing.table.DefaultTableCellRenderer rightRenderer = new javax.swing.table.DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tblKendaraan.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        tblKendaraan.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);

        // Click handler
        tblKendaraan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblKendaraan.getSelectedRow();
                if (selectedRow != -1) {
                    fillFormFromSelectedRow(selectedRow);
                }
            }
        });

        // Styling buttons and panels
        btnSave.setBackground(new Color(0, 184, 148));
        btnSave.setForeground(Color.WHITE);
        btnSave.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnSave.setIcon(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.SAVE, 14, Color.WHITE));
        btnSave.setIconTextGap(5);

        btnDelete.setBackground(new Color(214, 48, 49));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnDelete.setIcon(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.DELETE, 14, Color.WHITE));
        btnDelete.setIconTextGap(5);

        btnReset.setBackground(new Color(99, 110, 115));
        btnReset.setForeground(Color.WHITE);
        btnReset.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnReset.setIcon(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.RESET, 14, Color.WHITE));
        btnReset.setIconTextGap(5);

        btnSearch.setBackground(new Color(15, 52, 96));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnSearch.setIcon(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.SEARCH, 14, Color.WHITE));
        btnSearch.setIconTextGap(5);

        // Sidebar
        initNavButtonStates();
        buildMenuBar();
        setupAccessControl();
        
        setMinimumSize(new Dimension(1150, 700));
        setSize(1200, 750);
        setLocationRelativeTo(null);
        resetForm();
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

    public void resetForm() {
        txtId.setText("");
        txtJenis.setText("");
        txtTarifAwal.setText("");
        txtTarifPerJam.setText("");
        cbStatus.setSelectedIndex(0);
        btnDelete.setEnabled(false);
        tblKendaraan.clearSelection();
    }

    // Expose getters/setters for controller
    public String getIdInput() { return txtId.getText(); }
    public String getJenisInput() { return txtJenis.getText().trim(); }
    public String getTarifAwalInput() { return txtTarifAwal.getText().trim(); }
    public String getTarifPerJamInput() { return txtTarifPerJam.getText().trim(); }
    public String getStatusInput() { return cbStatus.getSelectedItem().toString(); }
    public String getSearchInput() { return txtSearch.getText().trim(); }
    
    public JTextField getTxtJenis() { return txtJenis; }
    public JTextField getTxtTarifAwal() { return txtTarifAwal; }
    public JTextField getTxtTarifPerJam() { return txtTarifPerJam; }

    public void addSaveListener(ActionListener l) { btnSave.addActionListener(l); }
    public void addDeleteListener(ActionListener l) { btnDelete.addActionListener(l); }
    public void addResetListener(ActionListener l) { btnReset.addActionListener(l); }
    public void addSearchListener(ActionListener l) {
        btnSearch.addActionListener(l);
        txtSearch.addActionListener(l);
    }

    public void populateTable(List<Kendaraan> list) {
        TableUtil.clearTable(tableModel);
        for (Kendaraan k : list) {
            tableModel.addRow(new Object[]{
                    k.getIdKendaraan(),
                    k.getJenisKendaraan(),
                    CurrencyUtil.formatRupiah(k.getTarifAwal()),
                    CurrencyUtil.formatRupiah(k.getTarifPerJam()),
                    k.getStatus().toString()
            });
        }
    }

    private void initNavButtonStates() {
        lblAppTitle.setIcon(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.KENDARAAN, 24, Color.WHITE));
        
        btnDashboard.addActionListener(e -> showCard("DASHBOARD"));
        navButtons.put("DASHBOARD", btnDashboard);
        
        btnMasuk.addActionListener(e -> showCard("MASUK"));
        navButtons.put("MASUK", btnMasuk);
        
        btnKeluar.addActionListener(e -> showCard("KELUAR"));
        navButtons.put("KELUAR", btnKeluar);
        
        btnKendaraan.addActionListener(e -> showCard("KENDARAAN"));
        navButtons.put("KENDARAAN", btnKendaraan);
        
        btnTarif.addActionListener(e -> showCard("TARIF"));
        navButtons.put("TARIF", btnTarif);
        
        btnPetugas.addActionListener(e -> showCard("PETUGAS"));
        navButtons.put("PETUGAS", btnPetugas);
        
        btnUser.addActionListener(e -> showCard("USER"));
        navButtons.put("USER", btnUser);
        
        btnLaporan.addActionListener(e -> showCard("LAPORAN"));
        navButtons.put("LAPORAN", btnLaporan);
        
        btnLogout.addActionListener(e -> ViewRouter.logout(this));
        
        initNavButtonStyles();
        setActiveNavVisual("KENDARAAN");
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
                buttons[i].setIcon(new com.mycompany.tugasakhir.util.VectorIcon(
                    com.mycompany.tugasakhir.util.VectorIcon.Type.valueOf(cards[i]), 18, activeFg));
            } else {
                buttons[i].setBackground(defaultBg);
                buttons[i].setForeground(defaultFg);
                buttons[i].setIcon(new com.mycompany.tugasakhir.util.VectorIcon(
                    com.mycompany.tugasakhir.util.VectorIcon.Type.valueOf(cards[i]), 18, defaultFg));
            }
        }
        btnLogout.setIcon(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.LOGOUT, 18, Color.WHITE));
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

    @SuppressWarnings("unchecked")
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
        mainSplitPanel = new javax.swing.JPanel();
        formCard = new javax.swing.JPanel();
        lblIdLabel = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblJenisLabel = new javax.swing.JLabel();
        txtJenis = new javax.swing.JTextField();
        lblTarifAwalLabel = new javax.swing.JLabel();
        txtTarifAwal = new javax.swing.JTextField();
        lblTarifPerJamLabel = new javax.swing.JLabel();
        txtTarifPerJam = new javax.swing.JTextField();
        lblStatusLabel = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
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
        tblKendaraan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Parkir Desktop - Kelola Kendaraan");
        setMinimumSize(new java.awt.Dimension(1150, 700));

        headerPanel.setBackground(new java.awt.Color(15, 52, 96));
        headerPanel.setPreferredSize(new java.awt.Dimension(0, 55));
        headerPanel.setLayout(new java.awt.BorderLayout());

        lblHeaderTitle.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblHeaderTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblHeaderTitle.setText("Kelola Kendaraan");
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
        lblContentTitle.setText("Kelola Jenis Kendaraan & Tarif Awal");
        titlePanel.add(lblContentTitle);

        contentArea.add(titlePanel, java.awt.BorderLayout.NORTH);

        mainSplitPanel.setOpaque(false);
        mainSplitPanel.setLayout(new java.awt.BorderLayout(15, 15));

        formCard.setBackground(new java.awt.Color(255, 255, 255));
        formCard.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)), javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20)));
        formCard.setPreferredSize(new java.awt.Dimension(320, 0));
        formCard.setLayout(new java.awt.GridBagLayout());

        lblIdLabel.setText("ID Kendaraan (Otomatis)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        formCard.add(lblIdLabel, gridBagConstraints);

        txtId.setEnabled(false);
        txtId.setPreferredSize(new java.awt.Dimension(0, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        formCard.add(txtId, gridBagConstraints);

        lblJenisLabel.setText("Jenis Kendaraan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        formCard.add(lblJenisLabel, gridBagConstraints);

        txtJenis.setPreferredSize(new java.awt.Dimension(0, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        formCard.add(txtJenis, gridBagConstraints);

        lblTarifAwalLabel.setText("Tarif Awal (Rp)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        formCard.add(lblTarifAwalLabel, gridBagConstraints);

        txtTarifAwal.setPreferredSize(new java.awt.Dimension(0, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        formCard.add(txtTarifAwal, gridBagConstraints);

        lblTarifPerJamLabel.setText("Tarif Per Jam (Rp)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        formCard.add(lblTarifPerJamLabel, gridBagConstraints);

        txtTarifPerJam.setPreferredSize(new java.awt.Dimension(0, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        formCard.add(txtTarifPerJam, gridBagConstraints);

        lblStatusLabel.setText("Status");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        formCard.add(lblStatusLabel, gridBagConstraints);

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AKTIF", "NONAKTIF" }));
        cbStatus.setPreferredSize(new java.awt.Dimension(0, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        formCard.add(cbStatus, gridBagConstraints);
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

        tblKendaraan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Jenis Kendaraan", "Tarif Awal", "Tarif Per Jam", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblKendaraan);

        tableCard.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        mainSplitPanel.add(tableCard, java.awt.BorderLayout.CENTER);

        contentArea.add(mainSplitPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(contentArea, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler boxSpacer;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnKendaraan;
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMasuk;
    private javax.swing.JButton btnPetugas;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTarif;
    private javax.swing.JButton btnUser;
    private javax.swing.JComboBox<String> cbStatus;
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
    private javax.swing.JLabel lblIdLabel;
    private javax.swing.JLabel lblJenisLabel;
    private javax.swing.JLabel lblStatusLabel;
    private javax.swing.JLabel lblTarifAwalLabel;
    private javax.swing.JLabel lblTarifPerJamLabel;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel mainSplitPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JTable tblKendaraan;
    private javax.swing.JPanel tableCard;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblSubWelcome;
    private javax.swing.JLabel lblUserLabel;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTarifAwal;
    private javax.swing.JTextField txtTarifPerJam;
    // End of variables declaration//GEN-END:variables
}
"""
    
    with open(os.path.join(view_dir, "NewKendaraanView.form"), "w", encoding="utf-8") as f:
        f.write(form_content)
    with open(os.path.join(view_dir, "NewKendaraanView.java"), "w", encoding="utf-8") as f:
        f.write(java_content)
