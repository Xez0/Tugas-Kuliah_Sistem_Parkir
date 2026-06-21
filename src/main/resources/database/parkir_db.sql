-- ============================================================
-- SISTEM PARKIR DESKTOP - Database Script
-- Database: parkir_db
-- Engine: MySQL 8.x
-- Author: Tugas Akhir
-- ============================================================

-- Buat database
CREATE DATABASE IF NOT EXISTS parkir_db
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_general_ci;

USE parkir_db;

-- ============================================================
-- TABEL 1: users (Akun login sistem)
-- ============================================================
DROP TABLE IF EXISTS transaksi_parkir;
DROP TABLE IF EXISTS tarif_parkir;
DROP TABLE IF EXISTS kendaraan;
DROP TABLE IF EXISTS petugas;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id_user       INT AUTO_INCREMENT PRIMARY KEY,
    nama          VARCHAR(100) NOT NULL,
    username      VARCHAR(50)  NOT NULL UNIQUE,
    password_hash VARCHAR(64)  NOT NULL,
    role          ENUM('ADMIN','OPERATOR') NOT NULL DEFAULT 'OPERATOR',
    status        ENUM('AKTIF','NONAKTIF') NOT NULL DEFAULT 'AKTIF',
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- ============================================================
-- TABEL 2: petugas (Data petugas parkir)
-- ============================================================
CREATE TABLE petugas (
    id_petugas    INT AUTO_INCREMENT PRIMARY KEY,
    nama          VARCHAR(100) NOT NULL,
    username      VARCHAR(50)  NOT NULL UNIQUE,
    password_hash VARCHAR(64)  NOT NULL,
    role          ENUM('ADMIN','OPERATOR') NOT NULL DEFAULT 'OPERATOR',
    no_telp       VARCHAR(20),
    status        ENUM('AKTIF','NONAKTIF') NOT NULL DEFAULT 'AKTIF',
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- ============================================================
-- TABEL 3: kendaraan (Jenis kendaraan + tarif dasar)
-- ============================================================
CREATE TABLE kendaraan (
    id_kendaraan    INT AUTO_INCREMENT PRIMARY KEY,
    jenis_kendaraan VARCHAR(50)    NOT NULL UNIQUE,
    tarif_awal      DECIMAL(12,2)  NOT NULL DEFAULT 0,
    tarif_per_jam   DECIMAL(12,2)  NOT NULL DEFAULT 0,
    status          ENUM('AKTIF','NONAKTIF') NOT NULL DEFAULT 'AKTIF'
) ENGINE=InnoDB;

-- ============================================================
-- TABEL 4: tarif_parkir (Tarif detail + progresif)
-- ============================================================
CREATE TABLE tarif_parkir (
    id_tarif   INT AUTO_INCREMENT PRIMARY KEY,
    jenis      VARCHAR(50)    NOT NULL UNIQUE,
    tarif      DECIMAL(12,2)  NOT NULL DEFAULT 0,
    progresif  DECIMAL(12,2)  NOT NULL DEFAULT 0,
    status     ENUM('AKTIF','NONAKTIF') NOT NULL DEFAULT 'AKTIF'
) ENGINE=InnoDB;

-- ============================================================
-- TABEL 5: transaksi_parkir (Transaksi parkir)
-- ============================================================
CREATE TABLE transaksi_parkir (
    id_transaksi       INT AUTO_INCREMENT PRIMARY KEY,
    plat_nomor         VARCHAR(20)    NOT NULL,
    id_kendaraan       INT            NOT NULL,
    id_tarif           INT            NOT NULL,
    jam_masuk          DATETIME       NOT NULL,
    jam_keluar         DATETIME       NULL,
    durasi_jam         INT            DEFAULT 0,
    tarif_awal         DECIMAL(12,2)  DEFAULT 0,
    tarif_per_jam      DECIMAL(12,2)  DEFAULT 0,
    total_biaya        DECIMAL(12,2)  DEFAULT 0,
    id_petugas_masuk   INT            NULL,
    id_petugas_keluar  INT            NULL,
    status             ENUM('MASUK','KELUAR') NOT NULL DEFAULT 'MASUK',
    created_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    -- Foreign Keys
    CONSTRAINT fk_transaksi_kendaraan
        FOREIGN KEY (id_kendaraan) REFERENCES kendaraan(id_kendaraan)
        ON UPDATE CASCADE ON DELETE RESTRICT,

    CONSTRAINT fk_transaksi_tarif
        FOREIGN KEY (id_tarif) REFERENCES tarif_parkir(id_tarif)
        ON UPDATE CASCADE ON DELETE RESTRICT,

    CONSTRAINT fk_transaksi_petugas_masuk
        FOREIGN KEY (id_petugas_masuk) REFERENCES petugas(id_petugas)
        ON UPDATE CASCADE ON DELETE SET NULL,

    CONSTRAINT fk_transaksi_petugas_keluar
        FOREIGN KEY (id_petugas_keluar) REFERENCES petugas(id_petugas)
        ON UPDATE CASCADE ON DELETE SET NULL,

    -- Index
    INDEX idx_plat_nomor (plat_nomor),
    INDEX idx_jam_masuk (jam_masuk),
    INDEX idx_status (status)
) ENGINE=InnoDB;

-- ============================================================
-- INSERT DATA DUMMY
-- ============================================================

-- Password: admin123 -> SHA-256
-- Password: operator123 -> SHA-256
-- admin123   = 240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9
-- operator123= 5ccd1bf31e36bf9b1ad0dede78691c232b2ce74fd2ac41eee71bbbd8d2904cba

-- Users
INSERT INTO users (nama, username, password_hash, role, status) VALUES
('Administrator', 'admin', '240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9', 'ADMIN', 'AKTIF'),
('Operator 1', 'operator', '5ccd1bf31e36bf9b1ad0dede78691c232b2ce74fd2ac41eee71bbbd8d2904cba', 'OPERATOR', 'AKTIF');

-- Petugas
INSERT INTO petugas (nama, username, password_hash, role, no_telp, status) VALUES
('Budi Santoso', 'budi', '240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9', 'ADMIN', '081234567890', 'AKTIF'),
('Siti Rahayu', 'siti', '5ccd1bf31e36bf9b1ad0dede78691c232b2ce74fd2ac41eee71bbbd8d2904cba', 'OPERATOR', '081234567891', 'AKTIF'),
('Ahmad Wijaya', 'ahmad', '5ccd1bf31e36bf9b1ad0dede78691c232b2ce74fd2ac41eee71bbbd8d2904cba', 'OPERATOR', '081234567892', 'AKTIF');

-- Kendaraan
INSERT INTO kendaraan (jenis_kendaraan, tarif_awal, tarif_per_jam, status) VALUES
('Motor', 3000.00, 2000.00, 'AKTIF'),
('Mobil', 5000.00, 3000.00, 'AKTIF'),
('Truk', 10000.00, 5000.00, 'AKTIF');

-- Tarif Parkir
INSERT INTO tarif_parkir (jenis, tarif, progresif, status) VALUES
('Motor', 3000.00, 2000.00, 'AKTIF'),
('Mobil', 5000.00, 3000.00, 'AKTIF'),
('Truk', 10000.00, 5000.00, 'AKTIF');

-- Transaksi Parkir (contoh data)
INSERT INTO transaksi_parkir (plat_nomor, id_kendaraan, id_tarif, jam_masuk, jam_keluar, durasi_jam, tarif_awal, tarif_per_jam, total_biaya, id_petugas_masuk, id_petugas_keluar, status) VALUES
('B 1234 ABC', 1, 1, '2026-06-12 08:00:00', '2026-06-12 10:00:00', 2, 3000, 2000, 5000, 1, 2, 'KELUAR'),
('B 5678 DEF', 2, 2, '2026-06-12 09:00:00', '2026-06-12 12:00:00', 3, 5000, 3000, 11000, 1, 2, 'KELUAR'),
('D 9012 GHI', 1, 1, '2026-06-12 10:00:00', '2026-06-12 11:00:00', 1, 3000, 2000, 3000, 2, 1, 'KELUAR'),
('F 3456 JKL', 3, 3, '2026-06-12 07:00:00', '2026-06-12 12:00:00', 5, 10000, 5000, 30000, 1, 2, 'KELUAR'),
('B 7890 MNO', 2, 2, '2026-06-12 14:00:00', NULL, 0, 5000, 3000, 0, 2, NULL, 'MASUK');
