package com.mycompany.tugasakhir.dao;

import com.mycompany.tugasakhir.config.DatabaseConnection;
import com.mycompany.tugasakhir.model.Kendaraan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object untuk tabel kendaraan.
 */
public class KendaraanDAO {

    private Connection getConnection() {
        return DatabaseConnection.getInstance().getConnection();
    }

    public boolean insert(Kendaraan kendaraan) {
        String sql = "INSERT INTO kendaraan (jenis_kendaraan, tarif_awal, tarif_per_jam, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, kendaraan.getJenisKendaraan());
            ps.setDouble(2, kendaraan.getTarifAwal());
            ps.setDouble(3, kendaraan.getTarifPerJam());
            ps.setString(4, kendaraan.getStatus());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("[KendaraanDAO] Insert error: " + e.getMessage());
            return false;
        }
    }

    public boolean update(Kendaraan kendaraan) {
        String sql = "UPDATE kendaraan SET jenis_kendaraan=?, tarif_awal=?, tarif_per_jam=?, status=? WHERE id_kendaraan=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, kendaraan.getJenisKendaraan());
            ps.setDouble(2, kendaraan.getTarifAwal());
            ps.setDouble(3, kendaraan.getTarifPerJam());
            ps.setString(4, kendaraan.getStatus());
            ps.setInt(5, kendaraan.getIdKendaraan());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("[KendaraanDAO] Update error: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idKendaraan) {
        String sql = "DELETE FROM kendaraan WHERE id_kendaraan=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idKendaraan);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("[KendaraanDAO] Delete error: " + e.getMessage());
            return false;
        }
    }

    public Kendaraan findById(int idKendaraan) {
        String sql = "SELECT * FROM kendaraan WHERE id_kendaraan=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idKendaraan);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSet(rs);
            }
        } catch (SQLException e) {
            System.err.println("[KendaraanDAO] FindById error: " + e.getMessage());
        }
        return null;
    }

    public List<Kendaraan> findAll() {
        List<Kendaraan> list = new ArrayList<>();
        String sql = "SELECT * FROM kendaraan ORDER BY id_kendaraan ASC";
        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("[KendaraanDAO] FindAll error: " + e.getMessage());
        }
        return list;
    }

    public List<Kendaraan> findAllActive() {
        List<Kendaraan> list = new ArrayList<>();
        String sql = "SELECT * FROM kendaraan WHERE status='AKTIF' ORDER BY jenis_kendaraan ASC";
        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("[KendaraanDAO] FindAllActive error: " + e.getMessage());
        }
        return list;
    }

    public List<Kendaraan> search(String keyword) {
        List<Kendaraan> list = new ArrayList<>();
        String sql = "SELECT * FROM kendaraan WHERE jenis_kendaraan LIKE ? ORDER BY id_kendaraan ASC";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("[KendaraanDAO] Search error: " + e.getMessage());
        }
        return list;
    }

    public boolean isJenisExists(String jenis, int excludeId) {
        String sql = "SELECT COUNT(*) FROM kendaraan WHERE jenis_kendaraan=? AND id_kendaraan!=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, jenis);
            ps.setInt(2, excludeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("[KendaraanDAO] isJenisExists error: " + e.getMessage());
        }
        return false;
    }

    private Kendaraan mapResultSet(ResultSet rs) throws SQLException {
        Kendaraan k = new Kendaraan();
        k.setIdKendaraan(rs.getInt("id_kendaraan"));
        k.setJenisKendaraan(rs.getString("jenis_kendaraan"));
        k.setTarifAwal(rs.getDouble("tarif_awal"));
        k.setTarifPerJam(rs.getDouble("tarif_per_jam"));
        k.setStatus(rs.getString("status"));
        return k;
    }
}
