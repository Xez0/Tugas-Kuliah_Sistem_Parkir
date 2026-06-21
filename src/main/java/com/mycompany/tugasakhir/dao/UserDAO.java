package com.mycompany.tugasakhir.dao;

import com.mycompany.tugasakhir.config.DatabaseConnection;
import com.mycompany.tugasakhir.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object untuk tabel users.
 * Menyediakan operasi CRUD + search.
 */
public class UserDAO {

    private Connection getConnection() {
        return DatabaseConnection.getInstance().getConnection();
    }

    /**
     * Insert user baru.
     */
    public boolean insert(User user) {
        String sql = "INSERT INTO users (nama, username, password_hash, role, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, user.getNama());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPasswordHash());
            ps.setString(4, user.getRole());
            ps.setString(5, user.getStatus());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("[UserDAO] Insert error: " + e.getMessage());
            return false;
        }
    }

    /**
     * Update user.
     */
    public boolean update(User user) {
        String sql = "UPDATE users SET nama=?, username=?, password_hash=?, role=?, status=? WHERE id_user=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, user.getNama());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPasswordHash());
            ps.setString(4, user.getRole());
            ps.setString(5, user.getStatus());
            ps.setInt(6, user.getIdUser());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("[UserDAO] Update error: " + e.getMessage());
            return false;
        }
    }

    /**
     * Hapus user berdasarkan ID.
     */
    public boolean delete(int idUser) {
        String sql = "DELETE FROM users WHERE id_user=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idUser);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("[UserDAO] Delete error: " + e.getMessage());
            return false;
        }
    }

    /**
     * Cari user berdasarkan ID.
     */
    public User findById(int idUser) {
        String sql = "SELECT * FROM users WHERE id_user=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSet(rs);
            }
        } catch (SQLException e) {
            System.err.println("[UserDAO] FindById error: " + e.getMessage());
        }
        return null;
    }

    /**
     * Cari user berdasarkan username.
     */
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSet(rs);
            }
        } catch (SQLException e) {
            System.err.println("[UserDAO] FindByUsername error: " + e.getMessage());
        }
        return null;
    }

    /**
     * Ambil semua user.
     */
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM users ORDER BY id_user ASC";
        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("[UserDAO] FindAll error: " + e.getMessage());
        }
        return list;
    }

    /**
     * Cari user berdasarkan keyword (nama/username).
     */
    public List<User> search(String keyword) {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE nama LIKE ? OR username LIKE ? ORDER BY id_user ASC";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            String likeKeyword = "%" + keyword + "%";
            ps.setString(1, likeKeyword);
            ps.setString(2, likeKeyword);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("[UserDAO] Search error: " + e.getMessage());
        }
        return list;
    }

    /**
     * Cek apakah username sudah dipakai oleh user lain.
     */
    public boolean isUsernameExists(String username, int excludeId) {
        String sql = "SELECT COUNT(*) FROM users WHERE username=? AND id_user!=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setInt(2, excludeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("[UserDAO] isUsernameExists error: " + e.getMessage());
        }
        return false;
    }

    /**
     * Map ResultSet ke objek User.
     */
    private User mapResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setIdUser(rs.getInt("id_user"));
        user.setNama(rs.getString("nama"));
        user.setUsername(rs.getString("username"));
        user.setPasswordHash(rs.getString("password_hash"));
        user.setRole(rs.getString("role"));
        user.setStatus(rs.getString("status"));
        user.setCreatedAt(rs.getTimestamp("created_at"));
        return user;
    }
}
