-- ============================================================
-- MIGRATION SCRIPT: Hapus kolom id_tarif dari transaksi_parkir
-- Jalankan script ini di database parkir_db yang sudah ada
-- untuk menyesuaikan skema dengan versi kode terbaru.
-- ============================================================

USE parkir_db;

-- 1. Hapus foreign key constraint id_tarif (jika ada)
SET @fk_exists = (SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS 
    WHERE CONSTRAINT_NAME = 'fk_transaksi_tarif' 
    AND TABLE_NAME = 'transaksi_parkir'
    AND TABLE_SCHEMA = 'parkir_db');

SET @sql = IF(@fk_exists > 0, 
    'ALTER TABLE transaksi_parkir DROP FOREIGN KEY fk_transaksi_tarif', 
    'SELECT 1');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- 2. Hapus kolom id_tarif (jika ada)
SET @col_exists = (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS 
    WHERE TABLE_NAME = 'transaksi_parkir' 
    AND COLUMN_NAME = 'id_tarif'
    AND TABLE_SCHEMA = 'parkir_db');

SET @sql2 = IF(@col_exists > 0, 
    'ALTER TABLE transaksi_parkir DROP COLUMN id_tarif', 
    'SELECT 1');
PREPARE stmt2 FROM @sql2;
EXECUTE stmt2;
DEALLOCATE PREPARE stmt2;

-- 3. Hapus tabel tarif_parkir (jika ada)
DROP TABLE IF EXISTS tarif_parkir;

-- Selesai!
SELECT 'Migration selesai! Kolom id_tarif dan tabel tarif_parkir telah dihapus.' AS status;
