@echo off
title MySQL Server - Sistem Parkir
echo ==========================================================
echo           MENYALAKAN DATABASE MYSQL LOKAL
echo ==========================================================
echo Database: parkir_db (Port: 3306)
echo Data Folder: %~dp0mysql_data
echo.
echo Menjalankan database server...
echo (Jangan tutup jendela ini selama aplikasi sedang digunakan)
echo ==========================================================
echo.
"C:\Program Files\MySQL\MySQL Server 8.4\bin\mysqld.exe" --datadir="%~dp0mysql_data" --console
pause
