package com.mycompany.tugasakhir.dao;

import com.mycompany.tugasakhir.config.DatabaseConnection;
import com.mycompany.tugasakhir.model.Petugas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object untuk tabel petugas.
 */
public class PetugasDAO {

    private Connection getConnection() {
        return DatabaseConnection.getInstance().getConnection();
    }

    public boolean insert(Petugas petugas) {
        String sql = "INSERT INTO petugas (nama, username, password_hash, role, no_telp, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, petugas.getNama());
            ps.setString(2, petugas.getUsername());
            ps.setString(3, petugas.getPasswordHash());
            ps.setString(4, petugas.getRole());
            ps.setString(5, petugas.getNoTelp());
            ps.setString(6, petugas.getStatus());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("[PetugasDAO] Insert error: " + e.getMessage());
            return false;
        }
    }

    public boolean update(Petugas petugas) {
        String sql = "UPDATE petugas SET nama=?, username=?, password_hash=?, role=?, no_telp=?, status=? WHERE id_petugas=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, petugas.getNama());
            ps.setString(2, petugas.getUsername());
            ps.setString(3, petugas.getPasswordHash());
            ps.setString(4, petugas.getRole());
            ps.setString(5, petugas.getNoTelp());
            ps.setString(6, petugas.getStatus());
            ps.setInt(7, petugas.getIdPetugas());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("[PetugasDAO] Update error: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idPetugas) {
        String sql = "DELETE FROM petugas WHERE id_petugas=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idPetugas);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("[PetugasDAO] Delete error: " + e.getMessage());
            return false;
        }
    }

    public Petugas findById(int idPetugas) {
        String sql = "SELECT * FROM petugas WHERE id_petugas=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idPetugas);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSet(rs);
            }
        } catch (SQLException e) {
            System.err.println("[PetugasDAO] FindById error: " + e.getMessage());
        }
        return null;
    }

    public List<Petugas> findAll() {
        List<Petugas> list = new ArrayList<>();
        String sql = "SELECT * FROM petugas ORDER BY id_petugas ASC";
        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("[PetugasDAO] FindAll error: " + e.getMessage());
        }
        return list;
    }

    public List<Petugas> findAllActive() {
        List<Petugas> list = new ArrayList<>();
        String sql = "SELECT * FROM petugas WHERE status='AKTIF' ORDER BY nama ASC";
        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("[PetugasDAO] FindAllActive error: " + e.getMessage());
        }
        return list;
    }

    public List<Petugas> search(String keyword) {
        List<Petugas> list = new ArrayList<>();
        String sql = "SELECT * FROM petugas WHERE nama LIKE ? OR username LIKE ? ORDER BY id_petugas ASC";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            String likeKeyword = "%" + keyword + "%";
            ps.setString(1, likeKeyword);
            ps.setString(2, likeKeyword);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("[PetugasDAO] Search error: " + e.getMessage());
        }
        return list;
    }

    public boolean isUsernameExists(String username, int excludeId) {
        String sql = "SELECT COUNT(*) FROM petugas WHERE username=? AND id_petugas!=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setInt(2, excludeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("[PetugasDAO] isUsernameExists error: " + e.getMessage());
        }
        return false;
    }

    public int countAll() {
        String sql = "SELECT COUNT(*) FROM petugas WHERE status='AKTIF'";
        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("[PetugasDAO] CountAll error: " + e.getMessage());
        }
        return 0;
    }

    private Petugas mapResultSet(ResultSet rs) throws SQLException {
        Petugas p = new Petugas();
        p.setIdPetugas(rs.getInt("id_petugas"));
        p.setNama(rs.getString("nama"));
        p.setUsername(rs.getString("username"));
        p.setPasswordHash(rs.getString("password_hash"));
        p.setRole(rs.getString("role"));
        p.setNoTelp(rs.getString("no_telp"));
        p.setStatus(rs.getString("status"));
        p.setCreatedAt(rs.getTimestamp("created_at"));
        return p;
    }
}
