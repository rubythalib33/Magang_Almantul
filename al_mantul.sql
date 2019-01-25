-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 25, 2019 at 09:05 AM
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
-- Database: `al_mantul`
--

-- --------------------------------------------------------

--
-- Table structure for table `bundle`
--

CREATE TABLE `bundle` (
  `kode_bundle` int(11) NOT NULL,
  `harga_bundle` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `list_produk_bundle`
--

CREATE TABLE `list_produk_bundle` (
  `kode_bundle_list` int(11) NOT NULL,
  `kode_produk_list_bundle` varchar(13) NOT NULL,
  `jumlah_produk_bundle` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `list_produk_restock`
--

CREATE TABLE `list_produk_restock` (
  `kode_restock_list` int(11) NOT NULL,
  `kode_produk_list_restock` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `list_produk_terjual`
--

CREATE TABLE `list_produk_terjual` (
  `kode_penjualan_list` int(13) NOT NULL,
  `kode_produk_list_terjual` varchar(13) NOT NULL,
  `jumlah_produk_keluar` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pemasukan`
--

CREATE TABLE `pemasukan` (
  `kode_data_pemasukan` int(11) NOT NULL,
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
  `kode_pengeluaran` varchar(5) NOT NULL,
  `tanggal_pengeluaran` date NOT NULL,
  `jumlah_pengeluaran` int(9) NOT NULL
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
  `gambar_produk` varchar(50) NOT NULL,
  `stok_produk` int(3) NOT NULL,
  `stok_kritis_produk` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `restock`
--

CREATE TABLE `restock` (
  `kode_restock` int(13) NOT NULL,
  `kode_supplier_restock` int(11) NOT NULL,
  `tanggal_transaksi_restock` date NOT NULL,
  `tanggal_jatuh_tempo` date NOT NULL,
  `bukti_transaksi_restock` varchar(50) NOT NULL
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
-- Table structure for table `transaksi_penjualan`
--

CREATE TABLE `transaksi_penjualan` (
  `kode_penjualan` int(13) NOT NULL,
  `kode_user_penjualan` varchar(25) NOT NULL,
  `nama_customer` varchar(25) NOT NULL,
  `tanggal_transaksi_penjualan` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `jabatan` varchar(10) NOT NULL,
  `nama_lengkap` varchar(50) NOT NULL,
  `no_telepon` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

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
  ADD KEY `kode_produk_list` (`kode_produk_list_restock`);

--
-- Indexes for table `list_produk_terjual`
--
ALTER TABLE `list_produk_terjual`
  ADD KEY `kode_penjualan_list` (`kode_penjualan_list`),
  ADD KEY `kode_produk_list` (`kode_produk_list_terjual`);

--
-- Indexes for table `pemasukan`
--
ALTER TABLE `pemasukan`
  ADD PRIMARY KEY (`kode_data_pemasukan`);

--
-- Indexes for table `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD PRIMARY KEY (`kode_data_pengeluaran`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`kode_produk`);

--
-- Indexes for table `restock`
--
ALTER TABLE `restock`
  ADD PRIMARY KEY (`kode_restock`),
  ADD KEY `kode_supplier_restock` (`kode_supplier_restock`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`kode_supplier`);

--
-- Indexes for table `transaksi_penjualan`
--
ALTER TABLE `transaksi_penjualan`
  ADD PRIMARY KEY (`kode_penjualan`),
  ADD KEY `kode_user_penjualan` (`kode_user_penjualan`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

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
-- AUTO_INCREMENT for table `restock`
--
ALTER TABLE `restock`
  MODIFY `kode_restock` int(13) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `kode_supplier` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `transaksi_penjualan`
--
ALTER TABLE `transaksi_penjualan`
  MODIFY `kode_penjualan` int(13) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `list_produk_bundle`
--
ALTER TABLE `list_produk_bundle`
  ADD CONSTRAINT `fk_kode_bundle` FOREIGN KEY (`kode_bundle_list`) REFERENCES `bundle` (`kode_bundle`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_kode_produk_list3` FOREIGN KEY (`kode_produk_list_bundle`) REFERENCES `produk` (`kode_produk`) ON UPDATE CASCADE;

--
-- Constraints for table `list_produk_restock`
--
ALTER TABLE `list_produk_restock`
  ADD CONSTRAINT `fk_kode_produk_list2` FOREIGN KEY (`kode_produk_list_restock`) REFERENCES `produk` (`kode_produk`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_kode_restock_list` FOREIGN KEY (`kode_restock_list`) REFERENCES `restock` (`kode_restock`) ON UPDATE CASCADE;

--
-- Constraints for table `list_produk_terjual`
--
ALTER TABLE `list_produk_terjual`
  ADD CONSTRAINT `fk_kode_penjualan_list` FOREIGN KEY (`kode_penjualan_list`) REFERENCES `transaksi_penjualan` (`kode_penjualan`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_kode_produk_list` FOREIGN KEY (`kode_produk_list_terjual`) REFERENCES `produk` (`kode_produk`) ON UPDATE CASCADE;

--
-- Constraints for table `restock`
--
ALTER TABLE `restock`
  ADD CONSTRAINT `fk_kode_supplier_restock` FOREIGN KEY (`kode_supplier_restock`) REFERENCES `supplier` (`kode_supplier`) ON UPDATE CASCADE;

--
-- Constraints for table `transaksi_penjualan`
--
ALTER TABLE `transaksi_penjualan`
  ADD CONSTRAINT `fk_transaksi_kode_user` FOREIGN KEY (`kode_user_penjualan`) REFERENCES `user` (`username`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
