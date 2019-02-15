-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 15, 2019 at 01:45 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pos_biptek`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username_admin` varchar(25) NOT NULL,
  `kode_perusahaan_admin` int(11) NOT NULL,
  `password_admin` varchar(25) NOT NULL,
  `nama_lengkap_admin` varchar(50) NOT NULL,
  `no_telepon_admin` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bundle`
--

CREATE TABLE `bundle` (
  `kode_bundle` int(11) NOT NULL,
  `nama_bundle` varchar(25) NOT NULL,
  `harga_bundle` int(9) NOT NULL,
  `tanggal_mulai_berlaku_bundle` date NOT NULL,
  `tanggal_berakhir_bundle` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `list_produk_bundle`
--

CREATE TABLE `list_produk_bundle` (
  `kode_bundle_list` int(11) NOT NULL,
  `kode_produk_list_bundle` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `list_produk_restock`
--

CREATE TABLE `list_produk_restock` (
  `kode_restock_list` int(11) NOT NULL,
  `kode_produk_list_restock` varchar(13) NOT NULL,
  `jumlah_produk_restock` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `list_produk_terjual`
--

CREATE TABLE `list_produk_terjual` (
  `kode_penjualan_list` int(11) NOT NULL,
  `kode_produk_list_terjual` varchar(13) NOT NULL,
  `jumlah_produk_terjual` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `username_pegawai` varchar(25) NOT NULL,
  `kode_toko_pegawai` int(11) NOT NULL,
  `password_pegawai` varchar(25) NOT NULL,
  `jabatan_pegawai` varchar(10) NOT NULL,
  `nama_lengkap_pegawai` varchar(50) NOT NULL,
  `no_telepon_pegawai` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pemasukan`
--

CREATE TABLE `pemasukan` (
  `kode_data_pemasukan` int(11) NOT NULL,
  `kode_toko_pemasukan` int(11) NOT NULL,
  `kode_pemasukan` varchar(5) NOT NULL,
  `tanggal_pemasukan` date NOT NULL,
  `jumlah_pemasukan` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pengeluaran`
--

CREATE TABLE `pengeluaran` (
  `kode_data_pengeluaran` int(11) NOT NULL,
  `kode_toko_pengeluaran` int(11) NOT NULL,
  `kode_pengeluaran` varchar(5) NOT NULL,
  `tanggal_pengeluaran` date NOT NULL,
  `jumlah_pengeluaran` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `perusahaan`
--

CREATE TABLE `perusahaan` (
  `kode_perusahaan` int(11) NOT NULL,
  `nama_pemilik_perusahaan` varchar(50) NOT NULL,
  `alamat_perusahaan` text NOT NULL,
  `email_perusahaan` varchar(50) NOT NULL,
  `no_telepon_perusahaan` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `kode_produk` varchar(13) NOT NULL,
  `jenis_produk` varchar(6) NOT NULL,
  `kategori_produk` varchar(25) NOT NULL,
  `nama_produk` varchar(25) NOT NULL,
  `deskripsi_produk` text NOT NULL,
  `harga_jual_produk` int(9) NOT NULL,
  `harga_beli_produk` int(9) NOT NULL,
  `satuan_produk` varchar(25) NOT NULL,
  `stok_produk` int(3) NOT NULL,
  `stok_kritis_produk` int(3) NOT NULL,
  `status_produk` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `produk_diskon`
--

CREATE TABLE `produk_diskon` (
  `kode_diskon` int(11) NOT NULL,
  `kode_produk_diskon` varchar(13) NOT NULL,
  `besar_diskon(%)` int(3) NOT NULL,
  `tanggal_mulai_berlaku_diskon` date NOT NULL,
  `tanggal_berakhir_diskon` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `restock`
--

CREATE TABLE `restock` (
  `kode_restock` int(11) NOT NULL,
  `kode_supplier_restock` int(11) NOT NULL,
  `username_pegawai_restock` varchar(25) NOT NULL,
  `tanggal_transaksi_restock` date NOT NULL,
  `tanggal_jatuh_tempo` date NOT NULL,
  `bukti_transaksi_restock` varchar(50) NOT NULL DEFAULT '-'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `kode_supplier` int(11) NOT NULL,
  `nama_supplier` varchar(25) NOT NULL,
  `email_supplier` varchar(25) NOT NULL,
  `no_telepon_supplier` varchar(13) NOT NULL,
  `alamat_supplier` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `toko`
--

CREATE TABLE `toko` (
  `kode_toko` int(11) NOT NULL,
  `kode_perusahaan_toko` int(11) NOT NULL,
  `manager_toko` varchar(50) NOT NULL,
  `alamat_toko` text NOT NULL,
  `no_telepon_toko` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_penjualan`
--

CREATE TABLE `transaksi_penjualan` (
  `kode_penjualan` int(11) NOT NULL,
  `username_pegawai_penjualan` varchar(25) NOT NULL,
  `tanggal_transaksi_penjualan` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username_admin`),
  ADD KEY `kode_perusahaan_admin` (`kode_perusahaan_admin`);

--
-- Indexes for table `bundle`
--
ALTER TABLE `bundle`
  ADD PRIMARY KEY (`kode_bundle`);

--
-- Indexes for table `list_produk_bundle`
--
ALTER TABLE `list_produk_bundle`
  ADD KEY `kode_bundle_list` (`kode_bundle_list`),
  ADD KEY `kode_produk_list_bundle` (`kode_produk_list_bundle`);

--
-- Indexes for table `list_produk_restock`
--
ALTER TABLE `list_produk_restock`
  ADD KEY `kode_restock_list` (`kode_restock_list`),
  ADD KEY `kode_produk_list_restock` (`kode_produk_list_restock`);

--
-- Indexes for table `list_produk_terjual`
--
ALTER TABLE `list_produk_terjual`
  ADD KEY `kode_penjualan_list` (`kode_penjualan_list`),
  ADD KEY `kode_produk_list_terjual` (`kode_produk_list_terjual`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`username_pegawai`),
  ADD KEY `kode_toko_pegawai` (`kode_toko_pegawai`);

--
-- Indexes for table `pemasukan`
--
ALTER TABLE `pemasukan`
  ADD PRIMARY KEY (`kode_data_pemasukan`),
  ADD KEY `kode_toko_pemasukan` (`kode_toko_pemasukan`);

--
-- Indexes for table `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD PRIMARY KEY (`kode_data_pengeluaran`),
  ADD KEY `kode_toko_pengeluaran` (`kode_toko_pengeluaran`);

--
-- Indexes for table `perusahaan`
--
ALTER TABLE `perusahaan`
  ADD PRIMARY KEY (`kode_perusahaan`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`kode_produk`);

--
-- Indexes for table `produk_diskon`
--
ALTER TABLE `produk_diskon`
  ADD PRIMARY KEY (`kode_diskon`),
  ADD KEY `kode_produk_diskon` (`kode_produk_diskon`);

--
-- Indexes for table `restock`
--
ALTER TABLE `restock`
  ADD PRIMARY KEY (`kode_restock`),
  ADD KEY `kode_supplier_restock` (`kode_supplier_restock`),
  ADD KEY `username_restock` (`username_pegawai_restock`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`kode_supplier`);

--
-- Indexes for table `toko`
--
ALTER TABLE `toko`
  ADD PRIMARY KEY (`kode_toko`),
  ADD KEY `kode_perusahaan_toko` (`kode_perusahaan_toko`);

--
-- Indexes for table `transaksi_penjualan`
--
ALTER TABLE `transaksi_penjualan`
  ADD PRIMARY KEY (`kode_penjualan`),
  ADD KEY `kode_pegawai_penjualan` (`username_pegawai_penjualan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bundle`
--
ALTER TABLE `bundle`
  MODIFY `kode_bundle` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pemasukan`
--
ALTER TABLE `pemasukan`
  MODIFY `kode_data_pemasukan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pengeluaran`
--
ALTER TABLE `pengeluaran`
  MODIFY `kode_data_pengeluaran` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `perusahaan`
--
ALTER TABLE `perusahaan`
  MODIFY `kode_perusahaan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `produk_diskon`
--
ALTER TABLE `produk_diskon`
  MODIFY `kode_diskon` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `restock`
--
ALTER TABLE `restock`
  MODIFY `kode_restock` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `kode_supplier` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `toko`
--
ALTER TABLE `toko`
  MODIFY `kode_toko` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `transaksi_penjualan`
--
ALTER TABLE `transaksi_penjualan`
  MODIFY `kode_penjualan` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`kode_perusahaan_admin`) REFERENCES `perusahaan` (`kode_perusahaan`) ON UPDATE CASCADE;

--
-- Constraints for table `list_produk_bundle`
--
ALTER TABLE `list_produk_bundle`
  ADD CONSTRAINT `list_produk_bundle_ibfk_1` FOREIGN KEY (`kode_bundle_list`) REFERENCES `bundle` (`kode_bundle`) ON UPDATE CASCADE,
  ADD CONSTRAINT `list_produk_bundle_ibfk_2` FOREIGN KEY (`kode_produk_list_bundle`) REFERENCES `produk` (`kode_produk`) ON UPDATE CASCADE;

--
-- Constraints for table `list_produk_restock`
--
ALTER TABLE `list_produk_restock`
  ADD CONSTRAINT `list_produk_restock_ibfk_1` FOREIGN KEY (`kode_restock_list`) REFERENCES `restock` (`kode_restock`) ON UPDATE CASCADE,
  ADD CONSTRAINT `list_produk_restock_ibfk_2` FOREIGN KEY (`kode_produk_list_restock`) REFERENCES `produk` (`kode_produk`) ON UPDATE CASCADE;

--
-- Constraints for table `list_produk_terjual`
--
ALTER TABLE `list_produk_terjual`
  ADD CONSTRAINT `list_produk_terjual_ibfk_1` FOREIGN KEY (`kode_penjualan_list`) REFERENCES `transaksi_penjualan` (`kode_penjualan`) ON UPDATE CASCADE,
  ADD CONSTRAINT `list_produk_terjual_ibfk_2` FOREIGN KEY (`kode_produk_list_terjual`) REFERENCES `produk` (`kode_produk`) ON UPDATE CASCADE;

--
-- Constraints for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD CONSTRAINT `pegawai_ibfk_1` FOREIGN KEY (`kode_toko_pegawai`) REFERENCES `toko` (`kode_toko`) ON UPDATE CASCADE;

--
-- Constraints for table `pemasukan`
--
ALTER TABLE `pemasukan`
  ADD CONSTRAINT `pemasukan_ibfk_1` FOREIGN KEY (`kode_toko_pemasukan`) REFERENCES `toko` (`kode_toko`) ON UPDATE CASCADE;

--
-- Constraints for table `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD CONSTRAINT `pengeluaran_ibfk_1` FOREIGN KEY (`kode_toko_pengeluaran`) REFERENCES `toko` (`kode_toko`) ON UPDATE CASCADE;

--
-- Constraints for table `produk_diskon`
--
ALTER TABLE `produk_diskon`
  ADD CONSTRAINT `produk_diskon_ibfk_1` FOREIGN KEY (`kode_produk_diskon`) REFERENCES `produk` (`kode_produk`) ON UPDATE CASCADE;

--
-- Constraints for table `restock`
--
ALTER TABLE `restock`
  ADD CONSTRAINT `restock_ibfk_1` FOREIGN KEY (`kode_supplier_restock`) REFERENCES `supplier` (`kode_supplier`) ON UPDATE CASCADE,
  ADD CONSTRAINT `restock_ibfk_2` FOREIGN KEY (`username_pegawai_restock`) REFERENCES `pegawai` (`username_pegawai`) ON UPDATE CASCADE;

--
-- Constraints for table `toko`
--
ALTER TABLE `toko`
  ADD CONSTRAINT `toko_ibfk_1` FOREIGN KEY (`kode_perusahaan_toko`) REFERENCES `perusahaan` (`kode_perusahaan`) ON UPDATE CASCADE;

--
-- Constraints for table `transaksi_penjualan`
--
ALTER TABLE `transaksi_penjualan`
  ADD CONSTRAINT `transaksi_penjualan_ibfk_1` FOREIGN KEY (`username_pegawai_penjualan`) REFERENCES `pegawai` (`username_pegawai`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
