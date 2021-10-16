-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 16, 2021 at 07:52 AM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestion_stock`
--

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `id_client` int(255) NOT NULL AUTO_INCREMENT,
  `nom_client` varchar(255) DEFAULT NULL,
  `prenom_client` varchar(255) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_client`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`id_client`, `nom_client`, `prenom_client`, `adresse`) VALUES
(1, 'client1', 'clientprenom', 'adresse'),
(2, 'Test', 'Hugues', 'Nalakely'),
(3, 'gdgsgs', NULL, NULL),
(4, 'gogo', NULL, NULL),
(5, '', NULL, NULL),
(6, 'ddsfssfsf', NULL, NULL),
(7, '', NULL, NULL),
(8, 'fsfsftsgtsgsgsgs', NULL, NULL),
(9, '', NULL, NULL),
(10, '', NULL, NULL),
(11, '', NULL, NULL),
(12, 'vaovava', NULL, NULL),
(13, 'dgdrgdgdgd', NULL, NULL),
(14, 'fsfsfsfsfsfsfsfsfss', NULL, NULL),
(15, 'fsggkhskgbsgbsgbsbgbgsg', NULL, NULL),
(16, 'pierere', NULL, NULL),
(17, 'Bob', NULL, NULL),
(18, 'BOBO', NULL, NULL),
(19, 'ffffffffff', NULL, NULL),
(20, 'ffsfsf', NULL, NULL),
(21, 'lol', NULL, NULL),
(22, 'hoho', NULL, NULL),
(23, 'fofo', NULL, NULL),
(24, 'NONO', NULL, NULL),
(25, 'gogo', NULL, NULL),
(26, 'gogo', NULL, NULL),
(27, 'Vomert', NULL, NULL),
(28, 'Aziz', NULL, NULL),
(29, 'Aziz', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `commandes`
--

DROP TABLE IF EXISTS `commandes`;
CREATE TABLE IF NOT EXISTS `commandes` (
  `id_commande` int(11) NOT NULL AUTO_INCREMENT,
  `quantite` int(255) NOT NULL,
  `id_article` int(255) NOT NULL,
  `id_client` int(255) NOT NULL,
  `date_commande` timestamp NOT NULL,
  PRIMARY KEY (`id_commande`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `commandes`
--

INSERT INTO `commandes` (`id_commande`, `quantite`, `id_article`, `id_client`, `date_commande`) VALUES
(1, 8, 5, 23, '2021-07-05 14:18:52'),
(2, 5, 7, 24, '2021-07-05 14:30:17'),
(3, 5, 7, 25, '2021-07-05 14:32:20'),
(4, 5, 7, 26, '2021-07-05 14:32:21'),
(5, 9000, 8, 27, '2021-07-06 07:57:16'),
(6, 3, 8, 28, '2021-09-09 04:46:42'),
(7, 3, 8, 29, '2021-09-09 04:46:42');

-- --------------------------------------------------------

--
-- Table structure for table `fournisseurs`
--

DROP TABLE IF EXISTS `fournisseurs`;
CREATE TABLE IF NOT EXISTS `fournisseurs` (
  `id_fournisseur` int(255) NOT NULL AUTO_INCREMENT,
  `nom_fournisseur` varchar(255) NOT NULL,
  PRIMARY KEY (`id_fournisseur`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `fournisseurs`
--

INSERT INTO `fournisseurs` (`id_fournisseur`, `nom_fournisseur`) VALUES
(1, 'JB'),
(2, 'Savonerie Tropicale'),
(3, 'Star'),
(4, 'Mpamboly'),
(5, 'Mpiompy'),
(6, 'Vitafoam'),
(7, 'Tiko'),
(8, 'Topolos');

-- --------------------------------------------------------

--
-- Table structure for table `stock_articles`
--

DROP TABLE IF EXISTS `stock_articles`;
CREATE TABLE IF NOT EXISTS `stock_articles` (
  `id_article` int(255) NOT NULL AUTO_INCREMENT,
  `nom_article` varchar(255) NOT NULL,
  `quantite` int(255) NOT NULL,
  `id_fournisseur` int(255) NOT NULL,
  PRIMARY KEY (`id_article`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stock_articles`
--

INSERT INTO `stock_articles` (`id_article`, `nom_article`, `quantite`, `id_fournisseur`) VALUES
(1, 'Savony', 1, 1),
(2, 'Labozia', 100, 1),
(3, 'Kamikaz', 44, 3),
(4, 'Kidoro', 40, 6),
(5, 'Test', 44, 5),
(6, 'Gana', 45, 5),
(7, 'Yaourt', 25, 7),
(8, 'Driver', 20088, 8);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
