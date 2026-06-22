package com.mycompany.tugasakhir.dao;

import com.mycompany.tugasakhir.config.DatabaseConnection;
import com.mycompany.tugasakhir.model.TransaksiParkir;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object untuk tabel transaksi_parkir.
 */
public class TransaksiParkirDAO {

    private Connection getConnection() {
        return DatabaseConnection.getInstance().getConnection();
    }

    /**
     * Insert transaksi parkir masuk.
     */
    public boolean insert(TransaksiParkir transaksi) {
        String sql = "INSERT INTO transaksi_parkir (plat_nomor, id_kendaraan, jam_masuk, "
                   + "tarif_awal, tarif_per_jam, id_petugas_masuk, status) "
                   + "VALUES (?, ?, ?, ?, ?, ?, 'MASUK')";
        try (PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, transaksi.getPlatNomor());
            ps.setInt(2, transaksi.getIdKendaraan());
            ps.setTimestamp(3, Timestamp.valueOf(transaksi.getJamMasuk()));
            ps.setDouble(4, transaksi.getTarifAwal());
            ps.setDouble(5, transaksi.getTarifPerJam());
            if (transaksi.getIdPetugasMasuk() != null) {
                ps.setInt(6, transaksi.getIdPetugasMasuk());
            } else {
                ps.setNull(6, Types.INTEGER);
            }
            int affected = ps.executeUpdate();
            if (affected > 0) {
                ResultSet keys = ps.getGeneratedKeys();
                if (keys.next()) {
                    transaksi.setIdTransaksi(keys.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("[TransaksiParkirDAO] Insert error: " + e.getMessage());
            e.printStackTrace();
            // Store the error message for debugging
            lastError = e.getMessage();
        }
        return false;
    }

    private String lastError = null;
    public String getLastError() { return lastError; }

    /**
     * Update transaksi parkir keluar.
     */
    public boolean updateKeluar(TransaksiParkir transaksi) {
        String sql = "UPDATE transaksi_parkir SET jam_keluar=?, durasi_jam=?, total_biaya=?, "
                   + "id_petugas_keluar=?, status='KELUAR' WHERE id_transaksi=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setTimestamp(1, Timestamp.valueOf(transaksi.getJamKeluar()));
            ps.setInt(2, transaksi.getDurasiJam());
            ps.setDouble(3, transaksi.getTotalBiaya());
            if (transaksi.getIdPetugasKeluar() != null) {
                ps.setInt(4, transaksi.getIdPetugasKeluar());
            } else {
                ps.setNull(4, Types.INTEGER);
            }
            ps.setInt(5, transaksi.getIdTransaksi());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("[TransaksiParkirDAO] UpdateKeluar error: " + e.getMessage());
        }
        return false;
    }

    /**
     * Hapus transaksi.
     */
    public boolean delete(int idTransaksi) {
        String sql = "DELETE FROM transaksi_parkir WHERE id_transaksi=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idTransaksi);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("[TransaksiParkirDAO] Delete error: " + e.getMessage());
        }
        return false;
    }

    /**
     * Cari transaksi berdasarkan ID.
     */
    public TransaksiParkir findById(int idTransaksi) {
        String sql = getSelectWithJoin() + " WHERE t.id_transaksi=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idTransaksi);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSet(rs);
            }
        } catch (SQLException e) {
            System.err.println("[TransaksiParkirDAO] FindById error: " + e.getMessage());
        }
        return null;
    }

    /**
     * Cari transaksi aktif (MASUK) berdasarkan plat nomor.
     */
    public TransaksiParkir findActiveByPlatNomor(String platNomor) {
        String sql = getSelectWithJoin() + " WHERE t.plat_nomor=? AND t.status='MASUK'";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, platNomor.toUpperCase().trim());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSet(rs);
            }
        } catch (SQLException e) {
            System.err.println("[TransaksiParkirDAO] FindActiveByPlatNomor error: " + e.getMessage());
        }
        return null;
    }

    /**
     * Ambil semua transaksi.
     */
    public List<TransaksiParkir> findAll() {
        List<TransaksiParkir> list = new ArrayList<>();
        String sql = getSelectWithJoin() + " ORDER BY t.id_transaksi DESC";
        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("[TransaksiParkirDAO] FindAll error: " + e.getMessage());
        }
        return list;
    }

    /**
     * Ambil semua transaksi yang masih MASUK (kendaraan parkir).
     */
    public List<TransaksiParkir> findAllActive() {
        List<TransaksiParkir> list = new ArrayList<>();
        String sql = getSelectWithJoin() + " WHERE t.status='MASUK' ORDER BY t.jam_masuk DESC";
        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("[TransaksiParkirDAO] FindAllActive error: " + e.getMessage());
        }
        return list;
    }

    /**
     * Cari transaksi berdasarkan range tanggal.
     */
    public List<TransaksiParkir> findByDateRange(LocalDate startDate, LocalDate endDate) {
        List<TransaksiParkir> list = new ArrayList<>();
        String sql = getSelectWithJoin()
                   + " WHERE DATE(t.jam_masuk) >= ? AND DATE(t.jam_masuk) <= ? ORDER BY t.jam_masuk DESC";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(startDate));
            ps.setDate(2, Date.valueOf(endDate));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("[TransaksiParkirDAO] FindByDateRange error: " + e.getMessage());
        }
        return list;
    }

    /**
     * Cari transaksi berdasarkan plat nomor.
     */
    public List<TransaksiParkir> searchByPlatNomor(String platNomor) {
        List<TransaksiParkir> list = new ArrayList<>();
        String sql = getSelectWithJoin() + " WHERE t.plat_nomor LIKE ? ORDER BY t.jam_masuk DESC";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, "%" + platNomor + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("[TransaksiParkirDAO] SearchByPlatNomor error: " + e.getMessage());
        }
        return list;
    }

    /**
     * Cek apakah plat nomor sedang aktif parkir.
     */
    public boolean isPlatNomorAktif(String platNomor) {
        String sql = "SELECT COUNT(*) FROM transaksi_parkir WHERE plat_nomor=? AND status='MASUK'";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, platNomor.toUpperCase().trim());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("[TransaksiParkirDAO] isPlatNomorAktif error: " + e.getMessage());
        }
        return false;
    }

    /**
     * Hitung jumlah kendaraan yang sedang parkir.
     */
    public int countActiveParking() {
        String sql = "SELECT COUNT(*) FROM transaksi_parkir WHERE status='MASUK'";
        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("[TransaksiParkirDAO] countActiveParking error: " + e.getMessage());
        }
        return 0;
    }

    /**
     * Hitung jumlah transaksi hari ini.
     */
    public int countTodayTransactions() {
        String sql = "SELECT COUNT(*) FROM transaksi_parkir WHERE DATE(jam_masuk) = CURDATE()";
        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("[TransaksiParkirDAO] countTodayTransactions error: " + e.getMessage());
        }
        return 0;
    }

    /**
     * Hitung pendapatan hari ini.
     */
    public double getTodayRevenue() {
        String sql = "SELECT COALESCE(SUM(total_biaya), 0) FROM transaksi_parkir "
                   + "WHERE DATE(jam_masuk) = CURDATE() AND status='KELUAR'";
        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.err.println("[TransaksiParkirDAO] getTodayRevenue error: " + e.getMessage());
        }
        return 0;
    }

    /**
     * Hitung total pendapatan berdasarkan range tanggal.
     */
    public double getRevenueByDateRange(LocalDate startDate, LocalDate endDate) {
        String sql = "SELECT COALESCE(SUM(total_biaya), 0) FROM transaksi_parkir "
                   + "WHERE DATE(jam_masuk) >= ? AND DATE(jam_masuk) <= ? AND status='KELUAR'";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(startDate));
            ps.setDate(2, Date.valueOf(endDate));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.err.println("[TransaksiParkirDAO] getRevenueByDateRange error: " + e.getMessage());
        }
        return 0;
    }

    /**
     * SELECT query dengan JOIN ke tabel kendaraan, tarif, dan petugas.
     */
    private String getSelectWithJoin() {
        return "SELECT t.*, k.jenis_kendaraan, "
             + "pm.nama AS nama_petugas_masuk, pk.nama AS nama_petugas_keluar "
             + "FROM transaksi_parkir t "
             + "LEFT JOIN kendaraan k ON t.id_kendaraan = k.id_kendaraan "
             + "LEFT JOIN petugas pm ON t.id_petugas_masuk = pm.id_petugas "
             + "LEFT JOIN petugas pk ON t.id_petugas_keluar = pk.id_petugas";
    }

    /**
     * Map ResultSet ke objek TransaksiParkir.
     */
    private TransaksiParkir mapResultSet(ResultSet rs) throws SQLException {
        TransaksiParkir t = new TransaksiParkir();
        t.setIdTransaksi(rs.getInt("id_transaksi"));
        t.setPlatNomor(rs.getString("plat_nomor"));
        t.setIdKendaraan(rs.getInt("id_kendaraan"));

        Timestamp jamMasuk = rs.getTimestamp("jam_masuk");
        if (jamMasuk != null) t.setJamMasuk(jamMasuk.toLocalDateTime());

        Timestamp jamKeluar = rs.getTimestamp("jam_keluar");
        if (jamKeluar != null) t.setJamKeluar(jamKeluar.toLocalDateTime());

        t.setDurasiJam(rs.getInt("durasi_jam"));
        t.setTarifAwal(rs.getDouble("tarif_awal"));
        t.setTarifPerJam(rs.getDouble("tarif_per_jam"));
        t.setTotalBiaya(rs.getDouble("total_biaya"));

        int petugasMasukId = rs.getInt("id_petugas_masuk");
        t.setIdPetugasMasuk(rs.wasNull() ? null : petugasMasukId);

        int petugasKeluarId = rs.getInt("id_petugas_keluar");
        t.setIdPetugasKeluar(rs.wasNull() ? null : petugasKeluarId);

        t.setStatus(rs.getString("status"));
        t.setCreatedAt(rs.getTimestamp("created_at"));

        // Transient fields dari JOIN
        try {
            t.setJenisKendaraan(rs.getString("jenis_kendaraan"));
            t.setNamaPetugasMasuk(rs.getString("nama_petugas_masuk"));
            t.setNamaPetugasKeluar(rs.getString("nama_petugas_keluar"));
        } catch (SQLException ignored) {
            // Kolom JOIN mungkin tidak ada jika query tanpa JOIN
        }

        return t;
    }
}
