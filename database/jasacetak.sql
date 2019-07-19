-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 14, 2019 at 03:27 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jasacetak`
--

-- --------------------------------------------------------

--
-- Table structure for table `tabel_ketegori`
--

CREATE TABLE `tabel_ketegori` (
  `kode_kategori` char(10) NOT NULL,
  `nm_produk` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_ketegori`
--

INSERT INTO `tabel_ketegori` (`kode_kategori`, `nm_produk`) VALUES
('K001', 'Print Kertas '),
('K002', 'Kertas Berwarna');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_pegawai`
--

CREATE TABLE `tabel_pegawai` (
  `kode_pegawai` char(10) NOT NULL,
  `nama_pegawai` varchar(20) NOT NULL,
  `alamat` varchar(25) NOT NULL,
  `nip` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_pegawai`
--

INSERT INTO `tabel_pegawai` (`kode_pegawai`, `nama_pegawai`, `alamat`, `nip`) VALUES
('P001', 'Risma Diana', 'Boyolali', 2376546),
('P002', 'Tegar ', 'Gemolong', 2376547);

-- --------------------------------------------------------

--
-- Table structure for table `tabel_pelanggan`
--

CREATE TABLE `tabel_pelanggan` (
  `kode_pelanggan` char(10) NOT NULL,
  `nama_pelanggan` varchar(20) NOT NULL,
  `alamat` varchar(25) NOT NULL,
  `telp` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_pelanggan`
--

INSERT INTO `tabel_pelanggan` (`kode_pelanggan`, `nama_pelanggan`, `alamat`, `telp`) VALUES
('KL001', 'Fatma Sy', 'Bintan', 98987656),
('KL002', 'Ayuk A', 'Surakarta', 97654326);

-- --------------------------------------------------------

--
-- Table structure for table `tabel_pemesanan`
--

CREATE TABLE `tabel_pemesanan` (
  `kode_pemesanan` char(10) NOT NULL,
  `kode_pegawai` char(10) NOT NULL,
  `kode_pelanggan` char(10) NOT NULL,
  `kode_produk` char(10) NOT NULL,
  `produk` varchar(20) NOT NULL,
  `harga` int(20) NOT NULL,
  `jumlah` int(20) NOT NULL,
  `total` int(15) NOT NULL,
  `dp` int(25) NOT NULL,
  `sisa` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_pemesanan`
--

INSERT INTO `tabel_pemesanan` (`kode_pemesanan`, `kode_pegawai`, `kode_pelanggan`, `kode_produk`, `produk`, `harga`, `jumlah`, `total`, `dp`, `sisa`) VALUES
('LK001', 'P001', 'KL001', 'L001', 'Print Kertas ', 500, 54, 27000, 150000, -123000),
('PL001', 'P001', 'KL001', 'L001', 'Print Kertas ', 500, 56, 28000, 10000, 18000);

-- --------------------------------------------------------

--
-- Table structure for table `tabel_produk`
--

CREATE TABLE `tabel_produk` (
  `kode_produk` char(10) NOT NULL,
  `kode_kategori` char(10) NOT NULL,
  `produk` varchar(20) NOT NULL,
  `harga` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_produk`
--

INSERT INTO `tabel_produk` (`kode_produk`, `kode_kategori`, `produk`, `harga`) VALUES
('L001', 'K001', 'Print Kertas ', 500),
('L002', 'K002', 'Kertas Berwarna', 9000);

-- --------------------------------------------------------

--
-- Table structure for table `tabel_transaksi`
--

CREATE TABLE `tabel_transaksi` (
  `kode_pembayaran` char(10) NOT NULL,
  `kode_pemesanan` char(10) NOT NULL,
  `produk` varchar(20) NOT NULL,
  `Dp` int(25) NOT NULL,
  `total` int(15) NOT NULL,
  `sisa` double NOT NULL,
  `bayar` int(11) NOT NULL,
  `kembali` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_transaksi`
--

INSERT INTO `tabel_transaksi` (`kode_pembayaran`, `kode_pemesanan`, `produk`, `Dp`, `total`, `sisa`, `bayar`, `kembali`) VALUES
('KB001', 'LK001', 'Print Kertas ', 500, 27000, 30000, -26500, 3500),
('KP001', 'LK001', 'Print Kertas ', 500, 27000, 30000, 26500, 83000),
('PM001', 'LK001', 'Print Kertas ', 500, 27000, 30000, -26500, 3500);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tabel_ketegori`
--
ALTER TABLE `tabel_ketegori`
  ADD PRIMARY KEY (`kode_kategori`);

--
-- Indexes for table `tabel_pegawai`
--
ALTER TABLE `tabel_pegawai`
  ADD PRIMARY KEY (`kode_pegawai`);

--
-- Indexes for table `tabel_pelanggan`
--
ALTER TABLE `tabel_pelanggan`
  ADD PRIMARY KEY (`kode_pelanggan`);

--
-- Indexes for table `tabel_pemesanan`
--
ALTER TABLE `tabel_pemesanan`
  ADD PRIMARY KEY (`kode_pemesanan`),
  ADD KEY `kode_pegawai` (`kode_pegawai`),
  ADD KEY `kode_pelanggan` (`kode_pelanggan`),
  ADD KEY `kode_produk` (`kode_produk`);

--
-- Indexes for table `tabel_produk`
--
ALTER TABLE `tabel_produk`
  ADD PRIMARY KEY (`kode_produk`),
  ADD KEY `kode_kategori` (`kode_kategori`);

--
-- Indexes for table `tabel_transaksi`
--
ALTER TABLE `tabel_transaksi`
  ADD PRIMARY KEY (`kode_pembayaran`),
  ADD KEY `kode_pemesanan` (`kode_pemesanan`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tabel_pemesanan`
--
ALTER TABLE `tabel_pemesanan`
  ADD CONSTRAINT `tabel_pemesanan_ibfk_1` FOREIGN KEY (`kode_pelanggan`) REFERENCES `tabel_pelanggan` (`kode_pelanggan`),
  ADD CONSTRAINT `tabel_pemesanan_ibfk_2` FOREIGN KEY (`kode_pegawai`) REFERENCES `tabel_pegawai` (`kode_pegawai`),
  ADD CONSTRAINT `tabel_pemesanan_ibfk_3` FOREIGN KEY (`kode_produk`) REFERENCES `tabel_produk` (`kode_produk`);

--
-- Constraints for table `tabel_produk`
--
ALTER TABLE `tabel_produk`
  ADD CONSTRAINT `tabel_produk_ibfk_1` FOREIGN KEY (`kode_kategori`) REFERENCES `tabel_ketegori` (`kode_kategori`);

--
-- Constraints for table `tabel_transaksi`
--
ALTER TABLE `tabel_transaksi`
  ADD CONSTRAINT `tabel_transaksi_ibfk_1` FOREIGN KEY (`kode_pemesanan`) REFERENCES `tabel_pemesanan` (`kode_pemesanan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
