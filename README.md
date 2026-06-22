# 🚗 Parkirku - Sistem Parkir Desktop

**Parkirku** adalah aplikasi manajemen sistem parkir berbasis desktop modern yang dirancang untuk mempermudah pengelolaan data parkir masuk, parkir keluar, tarif progresif, data master kendaraan, petugas, serta laporan pendapatan secara *real-time*.

Aplikasi ini menggunakan framework **Java Swing** dengan antarmuka modern berbasis **FlatLaf Look and Feel** serta arsitektur **Single Frame (CardLayout)** untuk memberikan pengalaman pengguna yang mulus tanpa kedipan jendela (*popup flashing*).

---

## ✨ Fitur Utama

- **Otomatisasi Database**: Database MySQL lokal akan otomatis dinyalakan di background saat aplikasi pertama kali dijalankan dari NetBeans.
- **Single Window Navigation**: Perpindahan antarmenu (Dashboard, Transaksi, Master Data, Laporan) berjalan secara instan dan mulus dalam satu frame utama.
- **Manajemen Master Data (CRUD)**:
  - 🚗 Kelola Jenis Kendaraan & Tarif (Motor, Mobil, Truk dengan tarif dasar & progresif)
  - 👥 Kelola Data Petugas Parkir & Akun User Sistem
- **Sistem Transaksi Parkir**:
  - ➕ **Parkir Masuk**: Pencatatan plat nomor, jenis kendaraan, dan waktu masuk otomatis.
  - ➖ **Parkir Keluar**: Pencarian transaksi aktif berdasarkan plat nomor, perhitungan durasi parkir otomatis, penghitungan total biaya berdasarkan tarif progresif, dan cetak struk pembayaran.
- **Laporan Pendapatan**: Visualisasi ringkasan statistik harian serta tabel riwayat transaksi lengkap untuk monitoring pendapatan harian.
- **Demo Mode (Flying Demo)**: Fitur simulasi otomatis yang memperagakan seluruh alur aplikasi secara otomatis (mulai dari input master data, simulasi parkir masuk, manipulasi durasi waktu, parkir keluar, hingga laporan) untuk keperluan demo aplikasi secara praktis.

---

## 🛠️ Teknologi & Libs yang Digunakan

- **Language**: Java 25 (mendukung Java modern)
- **UI Framework**: Java Swing (NetBeans GUI Builder JFrame Form)
- **Look and Feel**: [FlatLaf Light 3.4.1](https://github.com/JFormDesigner/FlatLaf) (Tampilan modern minimalis)
- **Database**: MySQL 8.x
- **Koneksi Database**: JDBC MySQL Connector/J 8.4.0
- **DatePicker**: JCalendar 1.4

---

## 🚀 Cara Menjalankan Aplikasi

### 1. Prasyarat (Prerequisites)
Pastikan komputer Anda sudah terinstal:
- **Java Development Kit (JDK)** versi 17 atau yang lebih baru (disarankan JDK 25).
- **NetBeans IDE** (versi 17 ke atas).
- **MySQL Server** (jika ingin menggunakan server MySQL mandiri). Namun, aplikasi ini sudah menyediakan folder data local MySQL (`mysql_data`) yang siap dijalankan melalui batch file.

### 2. Konfigurasi Database
1. Jalankan file `start_database.bat` di root folder proyek untuk mengaktifkan database lokal MySQL.
2. Impor file database [parkir_db.sql](src/main/resources/database/parkir_db.sql) ke dalam server database MySQL Anda menggunakan menu **Services** di NetBeans atau client SQL favorit Anda (HeidiSQL/Navicat/phpMyAdmin).

### 3. Jalankan Aplikasi dari NetBeans
1. Buka proyek **tugasakhir** di NetBeans.
2. Klik kanan pada proyek -> pilih **Run**.
3. Aplikasi akan menyala dan otomatis menjalankan database server di background.
4. **Login Default**:
   - **Admin**: Username `admin` | Password `admin123`
   - **Operator**: Username `operator` | Password `operator123`

---

## 📂 Struktur Proyek

```text
tugasakhir/
├── src/main/java/com/mycompany/tugasakhir/
│   ├── config/          # Pengaturan JDBC Connection
│   ├── controller/      # Controller MVC menghubungkan View dengan DAO
│   ├── dao/             # Data Access Object (Query Database)
│   ├── model/           # Entitas Data (POJO)
│   ├── service/         # Logika Bisnis & Simulasi Demo
│   ├── util/            # Helper utilitas (Format Rupiah, Hash SHA-256)
│   └── view/            # Tampilan JFrame Form (.java & .form)
│       ├── component/   # Komponen UI custom (Button, StatsCard)
│       └── panel/       # Panel konten utama menu (DashboardPanel, dll.)
├── src/main/resources/
│   ├── database/        # Skrip database SQL (parkir_db.sql)
│   └── icons/           # Ikon SVG FlatLaf
├── start_database.bat   # Skrip penyala database MySQL lokal otomatis
└── pom.xml              # Maven dependencies configuration
```
