-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 04, 2021 at 04:13 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `emp`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `EmployeeID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) COLLATE latin1_bin NOT NULL,
  `Gender` enum('Male','Female','Other') COLLATE latin1_bin NOT NULL,
  `Age` int(11) NOT NULL,
  `BloodGroup` enum('A+','A-','B+','B-','O+','O-','AB+','AB-','Other','Unknown') COLLATE latin1_bin NOT NULL,
  `ContactNbr` varchar(15) COLLATE latin1_bin NOT NULL,
  `Qualification` enum('DG','TS','AQ','SA','MAt','ChefC','Chauff','AM') COLLATE latin1_bin NOT NULL,
  `DOJ` date NOT NULL,
  `Address` text COLLATE latin1_bin NOT NULL,
  `PathImg` text COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`EmployeeID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EmployeeID`, `Name`, `Gender`, `Age`, `BloodGroup`, `ContactNbr`, `Qualification`, `DOJ`, `Address`, `PathImg`) VALUES
(1, 'Mokhtari Samy', 'Male', 22, 'A+', '0665776603', 'TS', '2021-01-04', '23 rue Fernand Durbec, 95870, Bezons, France', '1p.jpg'),
(2, 'Macron Emmanuel', 'Male', 43, 'O+', '0142928100', 'DG', '2017-05-14', '55 Rue du Faubourg Saint-Honoré, 75008, Paris, France', '8p.jpg'),
(3, 'Merkel Angela', 'Female', 66, 'Unknown', '+4930182722720', 'DG', '2005-11-22', 'Willy-Brandt-Straße 1, 10557 Berlin, Allemagne', '9p.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Login` varchar(10) COLLATE latin1_bin NOT NULL,
  `Password` varchar(10) COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`ID`, `Login`, `Password`) VALUES
(1, 'admin', 'admin'),
(2, 'root', '1234');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
