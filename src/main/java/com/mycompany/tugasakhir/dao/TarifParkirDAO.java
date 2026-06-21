package com.mycompany.tugasakhir.dao;

import com.mycompany.tugasakhir.config.DatabaseConnection;
import com.mycompany.tugasakhir.model.TarifParkir;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object untuk tabel tarif_parkir.
 */
public class TarifParkirDAO {

    private Connection getConnection() {
        return DatabaseConnection.getInstance().getConnection();
    }

    public boolean insert(TarifParkir tarif) {
        String sql = "INSERT INTO tarif_parkir (jenis, tarif, progresif, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, tarif.getJenis());
            ps.setDouble(2, tarif.getTarif());
            ps.setDouble(3, tarif.getProgresif());
            ps.setString(4, tarif.getStatus());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("[TarifParkirDAO] Insert error: " + e.getMessage());
            return false;
        }
    }

    public boolean update(TarifParkir tarif) {
        String sql = "UPDATE tarif_parkir SET jenis=?, tarif=?, progresif=?, status=? WHERE id_tarif=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, tarif.getJenis());
            ps.setDouble(2, tarif.getTarif());
            ps.setDouble(3, tarif.getProgresif());
            ps.setString(4, tarif.getStatus());
            ps.setInt(5, tarif.getIdTarif());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("[TarifParkirDAO] Update error: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idTarif) {
        String sql = "DELETE FROM tarif_parkir WHERE id_tarif=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idTarif);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("[TarifParkirDAO] Delete error: " + e.getMessage());
            return false;
        }
    }

    public TarifParkir findById(int idTarif) {
        String sql = "SELECT * FROM tarif_parkir WHERE id_tarif=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idTarif);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSet(rs);
            }
        } catch (SQLException e) {
            System.err.println("[TarifParkirDAO] FindById error: " + e.getMessage());
        }
        return null;
    }

    public TarifParkir findByJenis(String jenis) {
        String sql = "SELECT * FROM tarif_parkir WHERE jenis=? AND status='AKTIF'";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, jenis);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSet(rs);
            }
        } catch (SQLException e) {
            System.err.println("[TarifParkirDAO] FindByJenis error: " + e.getMessage());
        }
        return null;
    }

    public List<TarifParkir> findAll() {
        List<TarifParkir> list = new ArrayList<>();
        String sql = "SELECT * FROM tarif_parkir ORDER BY id_tarif ASC";
        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("[TarifParkirDAO] FindAll error: " + e.getMessage());
        }
        return list;
    }

    public List<TarifParkir> findAllActive() {
        List<TarifParkir> list = new ArrayList<>();
        String sql = "SELECT * FROM tarif_parkir WHERE status='AKTIF' ORDER BY jenis ASC";
        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("[TarifParkirDAO] FindAllActive error: " + e.getMessage());
        }
        return list;
    }

    public List<TarifParkir> search(String keyword) {
        List<TarifParkir> list = new ArrayList<>();
        String sql = "SELECT * FROM tarif_parkir WHERE jenis LIKE ? ORDER BY id_tarif ASC";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("[TarifParkirDAO] Search error: " + e.getMessage());
        }
        return list;
    }

    public boolean isJenisExists(String jenis, int excludeId) {
        String sql = "SELECT COUNT(*) FROM tarif_parkir WHERE jenis=? AND id_tarif!=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, jenis);
            ps.setInt(2, excludeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("[TarifParkirDAO] isJenisExists error: " + e.getMessage());
        }
        return false;
    }

    private TarifParkir mapResultSet(ResultSet rs) throws SQLException {
        TarifParkir t = new TarifParkir();
        t.setIdTarif(rs.getInt("id_tarif"));
        t.setJenis(rs.getString("jenis"));
        t.setTarif(rs.getDouble("tarif"));
        t.setProgresif(rs.getDouble("progresif"));
        t.setStatus(rs.getString("status"));
        return t;
    }
}
