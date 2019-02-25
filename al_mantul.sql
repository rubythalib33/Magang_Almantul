-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Waktu pembuatan: 25 Feb 2019 pada 07.17
-- Versi server: 10.1.34-MariaDB
-- Versi PHP: 7.2.7

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
-- Struktur dari tabel `admin`
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
-- Struktur dari tabel `bundle`
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
-- Struktur dari tabel `list_produk_bundle`
--

CREATE TABLE `list_produk_bundle` (
  `id_list_produk_bundle` int(11) NOT NULL,
  `kode_bundle_list` int(11) NOT NULL,
  `kode_produk_list_bundle` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `list_produk_restock`
--

CREATE TABLE `list_produk_restock` (
  `id_list_produk_restock` int(11) NOT NULL,
  `kode_restock_list` int(11) NOT NULL,
  `kode_produk_list_restock` varchar(13) NOT NULL,
  `jumlah_produk_restock` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `list_produk_terjual`
--

CREATE TABLE `list_produk_terjual` (
  `id_list_produk_terjual` int(11) NOT NULL,
  `kode_penjualan_list` int(11) NOT NULL,
  `kode_produk_list_terjual` varchar(13) NOT NULL,
  `jumlah_produk_terjual` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `migration`
--

CREATE TABLE `migration` (
  `version` varchar(180) NOT NULL,
  `apply_time` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `migration`
--

INSERT INTO `migration` (`version`, `apply_time`) VALUES
('m000000_000000_base', 1550907669),
('m130524_201442_init', 1550907673);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pegawai`
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
-- Struktur dari tabel `pemasukan`
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
-- Struktur dari tabel `pengeluaran`
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
-- Struktur dari tabel `perusahaan`
--

CREATE TABLE `perusahaan` (
  `kode_perusahaan` int(11) NOT NULL,
  `nama_pemilik_perusahaan` varchar(50) NOT NULL,
  `alamat_perusahaan` text NOT NULL,
  `tanggal_berdiri_perusahaan` date NOT NULL,
  `email_perusahaan` varchar(50) NOT NULL,
  `no_telepon_perusahaan` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `produk`
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
  `stok_kritis_produk` int(3) NOT NULL,
  `status_produk` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `produk_diskon`
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
-- Struktur dari tabel `restock`
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
-- Struktur dari tabel `supplier`
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
-- Struktur dari tabel `toko`
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
-- Struktur dari tabel `transaksi_penjualan`
--

CREATE TABLE `transaksi_penjualan` (
  `kode_penjualan` int(11) NOT NULL,
  `username_pegawai_penjualan` varchar(25) NOT NULL,
  `tanggal_transaksi_penjualan` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `auth_key` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `password_hash` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password_reset_token` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT '10',
  `created_at` int(11) NOT NULL,
  `updated_at` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `username`, `auth_key`, `password_hash`, `password_reset_token`, `email`, `status`, `created_at`, `updated_at`) VALUES
(1, 'superadmin', '3lMgOjTXfkE9gCt6owk6zDoNbKPn5bpe', '$2y$13$kGO7RNYq4NemnpR7BX21keub7XDXTdT.VJQEkwY2ORWPIMRTM1QlW', NULL, 'rubyabdullah14@gmail.com', 10, 1550910794, 1550910794);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username_admin`),
  ADD KEY `kode_perusahaan_admin` (`kode_perusahaan_admin`);

--
-- Indeks untuk tabel `bundle`
--
ALTER TABLE `bundle`
  ADD PRIMARY KEY (`kode_bundle`);

--
-- Indeks untuk tabel `list_produk_bundle`
--
ALTER TABLE `list_produk_bundle`
  ADD PRIMARY KEY (`id_list_produk_bundle`),
  ADD KEY `kode_bundle_list` (`kode_bundle_list`),
  ADD KEY `kode_produk_list_bundle` (`kode_produk_list_bundle`);

--
-- Indeks untuk tabel `list_produk_restock`
--
ALTER TABLE `list_produk_restock`
  ADD PRIMARY KEY (`id_list_produk_restock`),
  ADD KEY `kode_restock_list` (`kode_restock_list`),
  ADD KEY `kode_produk_list_restock` (`kode_produk_list_restock`);

--
-- Indeks untuk tabel `list_produk_terjual`
--
ALTER TABLE `list_produk_terjual`
  ADD PRIMARY KEY (`id_list_produk_terjual`),
  ADD KEY `kode_penjualan_list` (`kode_penjualan_list`),
  ADD KEY `kode_produk_list_terjual` (`kode_produk_list_terjual`);

--
-- Indeks untuk tabel `migration`
--
ALTER TABLE `migration`
  ADD PRIMARY KEY (`version`);

--
-- Indeks untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`username_pegawai`),
  ADD KEY `kode_toko_pegawai` (`kode_toko_pegawai`);

--
-- Indeks untuk tabel `pemasukan`
--
ALTER TABLE `pemasukan`
  ADD PRIMARY KEY (`kode_data_pemasukan`),
  ADD KEY `kode_toko_pemasukan` (`kode_toko_pemasukan`);

--
-- Indeks untuk tabel `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD PRIMARY KEY (`kode_data_pengeluaran`),
  ADD KEY `kode_toko_pengeluaran` (`kode_toko_pengeluaran`);

--
-- Indeks untuk tabel `perusahaan`
--
ALTER TABLE `perusahaan`
  ADD PRIMARY KEY (`kode_perusahaan`);

--
-- Indeks untuk tabel `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`kode_produk`);

--
-- Indeks untuk tabel `produk_diskon`
--
ALTER TABLE `produk_diskon`
  ADD PRIMARY KEY (`kode_diskon`),
  ADD KEY `kode_produk_diskon` (`kode_produk_diskon`);

--
-- Indeks untuk tabel `restock`
--
ALTER TABLE `restock`
  ADD PRIMARY KEY (`kode_restock`),
  ADD KEY `kode_supplier_restock` (`kode_supplier_restock`),
  ADD KEY `username_restock` (`username_pegawai_restock`);

--
-- Indeks untuk tabel `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`kode_supplier`);

--
-- Indeks untuk tabel `toko`
--
ALTER TABLE `toko`
  ADD PRIMARY KEY (`kode_toko`),
  ADD KEY `kode_perusahaan_toko` (`kode_perusahaan_toko`);

--
-- Indeks untuk tabel `transaksi_penjualan`
--
ALTER TABLE `transaksi_penjualan`
  ADD PRIMARY KEY (`kode_penjualan`),
  ADD KEY `kode_pegawai_penjualan` (`username_pegawai_penjualan`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `password_reset_token` (`password_reset_token`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `bundle`
--
ALTER TABLE `bundle`
  MODIFY `kode_bundle` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `list_produk_bundle`
--
ALTER TABLE `list_produk_bundle`
  MODIFY `id_list_produk_bundle` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `list_produk_restock`
--
ALTER TABLE `list_produk_restock`
  MODIFY `id_list_produk_restock` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `list_produk_terjual`
--
ALTER TABLE `list_produk_terjual`
  MODIFY `id_list_produk_terjual` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `pemasukan`
--
ALTER TABLE `pemasukan`
  MODIFY `kode_data_pemasukan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `pengeluaran`
--
ALTER TABLE `pengeluaran`
  MODIFY `kode_data_pengeluaran` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `perusahaan`
--
ALTER TABLE `perusahaan`
  MODIFY `kode_perusahaan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `produk_diskon`
--
ALTER TABLE `produk_diskon`
  MODIFY `kode_diskon` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `restock`
--
ALTER TABLE `restock`
  MODIFY `kode_restock` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `supplier`
--
ALTER TABLE `supplier`
  MODIFY `kode_supplier` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `toko`
--
ALTER TABLE `toko`
  MODIFY `kode_toko` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `transaksi_penjualan`
--
ALTER TABLE `transaksi_penjualan`
  MODIFY `kode_penjualan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`kode_perusahaan_admin`) REFERENCES `perusahaan` (`kode_perusahaan`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `list_produk_bundle`
--
ALTER TABLE `list_produk_bundle`
  ADD CONSTRAINT `list_produk_bundle_ibfk_1` FOREIGN KEY (`kode_bundle_list`) REFERENCES `bundle` (`kode_bundle`) ON UPDATE CASCADE,
  ADD CONSTRAINT `list_produk_bundle_ibfk_2` FOREIGN KEY (`kode_produk_list_bundle`) REFERENCES `produk` (`kode_produk`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `list_produk_restock`
--
ALTER TABLE `list_produk_restock`
  ADD CONSTRAINT `list_produk_restock_ibfk_1` FOREIGN KEY (`kode_restock_list`) REFERENCES `restock` (`kode_restock`) ON UPDATE CASCADE,
  ADD CONSTRAINT `list_produk_restock_ibfk_2` FOREIGN KEY (`kode_produk_list_restock`) REFERENCES `produk` (`kode_produk`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `list_produk_terjual`
--
ALTER TABLE `list_produk_terjual`
  ADD CONSTRAINT `list_produk_terjual_ibfk_1` FOREIGN KEY (`kode_penjualan_list`) REFERENCES `transaksi_penjualan` (`kode_penjualan`) ON UPDATE CASCADE,
  ADD CONSTRAINT `list_produk_terjual_ibfk_2` FOREIGN KEY (`kode_produk_list_terjual`) REFERENCES `produk` (`kode_produk`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  ADD CONSTRAINT `pegawai_ibfk_1` FOREIGN KEY (`kode_toko_pegawai`) REFERENCES `toko` (`kode_toko`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pemasukan`
--
ALTER TABLE `pemasukan`
  ADD CONSTRAINT `pemasukan_ibfk_1` FOREIGN KEY (`kode_toko_pemasukan`) REFERENCES `toko` (`kode_toko`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD CONSTRAINT `pengeluaran_ibfk_1` FOREIGN KEY (`kode_toko_pengeluaran`) REFERENCES `toko` (`kode_toko`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `produk_diskon`
--
ALTER TABLE `produk_diskon`
  ADD CONSTRAINT `produk_diskon_ibfk_1` FOREIGN KEY (`kode_produk_diskon`) REFERENCES `produk` (`kode_produk`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `restock`
--
ALTER TABLE `restock`
  ADD CONSTRAINT `restock_ibfk_1` FOREIGN KEY (`kode_supplier_restock`) REFERENCES `supplier` (`kode_supplier`) ON UPDATE CASCADE,
  ADD CONSTRAINT `restock_ibfk_2` FOREIGN KEY (`username_pegawai_restock`) REFERENCES `pegawai` (`username_pegawai`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `toko`
--
ALTER TABLE `toko`
  ADD CONSTRAINT `toko_ibfk_1` FOREIGN KEY (`kode_perusahaan_toko`) REFERENCES `perusahaan` (`kode_perusahaan`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `transaksi_penjualan`
--
ALTER TABLE `transaksi_penjualan`
  ADD CONSTRAINT `transaksi_penjualan_ibfk_1` FOREIGN KEY (`username_pegawai_penjualan`) REFERENCES `pegawai` (`username_pegawai`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
