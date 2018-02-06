-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 26, 2017 at 08:57 PM
-- Server version: 10.1.24-MariaDB
-- PHP Version: 7.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javaproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctorinfo`
--

CREATE TABLE `doctorinfo` (
  `serial` int(8) NOT NULL,
  `name` varchar(100) NOT NULL,
  `Id` varchar(767) NOT NULL,
  `password` varchar(100) NOT NULL,
  `areaOfExp` varchar(50) NOT NULL,
  `picture` varchar(767) DEFAULT NULL,
  `details` text,
  `uid` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctorinfo`
--

INSERT INTO `doctorinfo` (`serial`, `name`, `Id`, `password`, `areaOfExp`, `picture`, `details`, `uid`) VALUES
(21, 'Dr. Hashem', 'id1', '1', 'Anesthe', NULL, 'erfger', 74),
(22, 'Dr. Belal', 'id3', '1', 'Heart', '0', 'sdf', 22),
(24, 'id4', '', '', 'vvv', 'E:\\java\\Finalproject\\imran.jpg', '', 22),
(25, 'id5', 'id5', 'id5', 'id5', 'C:UsersSSRDesktopp1.PNG', 'id5', 22),
(32, 'Dr. XYZ', 'id66', '1', 'Chold Specialist', 'imran.JPG', 'MBBS', 2),
(33, 'Dr. XYZ', 'id77', '1', 'Child Specialist', 'imran.JPG', 'MBBS', 2);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `serial` int(8) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `id` varchar(767) NOT NULL,
  `password` varchar(100) NOT NULL,
  `AreaOfExp` varchar(500) DEFAULT NULL,
  `picture` varchar(500) DEFAULT NULL,
  `uid` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`serial`, `name`, `sex`, `email`, `id`, `password`, `AreaOfExp`, `picture`, `uid`) VALUES
(37, 'Mozammal Hosen', 'Male', 'dsf@s.com', '0-944665-58', '1', NULL, NULL, 3),
(38, 'Sk. Samiur Rahman', 'Male', 'sksami4456@gmail.com', 'admin', 'admin', NULL, NULL, 0),
(41, 'ee', 'Female', 'ee', 'ee', 'ee', NULL, NULL, 3),
(42, 'ee', 'Female', 'ee', 'eee', 'eee', NULL, NULL, 3),
(43, 'Dr. Belal', NULL, NULL, 'id3', '1', 'Heart', 'C:UsersSSRDesktopokc.PNG', 2),
(45, 'id5', NULL, NULL, 'id5', 'id5', 'id5', 'C:UsersSSRDesktopp1.PNG', 2),
(48, 'Abdur Rahman', 'Female', 'sada@jiosad.com', '4-1683248-11', '1', NULL, NULL, 3),
(50, 'Dr. XYZ', NULL, NULL, 'id66', '1', 'Chold Specialist', '', 2),
(51, 'Dr. XYZ', NULL, NULL, 'id77', '1', 'Child Specialist', 'imran.JPG', 2),
(52, 'SSR2', 'Male', 'null', '5-9203334-20', '1', NULL, NULL, 3),
(53, 'Mrs. X', 'Female', 'dsf@dsf.com', '6-2126257-0', '1', NULL, 'images.jpg', 3),
(54, '', 'Male', '', '', '', NULL, 'null', 3);

-- --------------------------------------------------------

--
-- Table structure for table `patientdetails`
--

CREATE TABLE `patientdetails` (
  `serial` int(8) NOT NULL,
  `Id` varchar(767) NOT NULL,
  `name` varchar(50) NOT NULL,
  `age` int(8) NOT NULL,
  `sex` varchar(50) NOT NULL,
  `details` text NOT NULL,
  `docType` varchar(200) NOT NULL,
  `uid` varchar(200) NOT NULL,
  `picture` varchar(767) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patientdetails`
--

INSERT INTO `patientdetails` (`serial`, `Id`, `name`, `age`, `sex`, `details`, `docType`, `uid`, `picture`) VALUES
(12, '0-944665-58', 'Mozammal Hosen', 24, 'Male', 'Pete betha', 'Anesthesiologist', '0-944665-58', NULL),
(14, 'eee', 'ee', 14, 'Female', 'rfrre', 'Anesthesiologist 1', 'eee', NULL),
(15, '5-9203334-20', 'SSR2', 27, 'Male', 'Golay betha', 'Child Specialist', '5-9203334-20', NULL),
(19, '6-2126257-0', 'Mrs. X', 24, 'Female', 'iohl', 'Child Specialist', '6-2126257-0', 'images.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `prescription`
--

CREATE TABLE `prescription` (
  `serial` int(8) NOT NULL,
  `pres` text NOT NULL,
  `Pid` varchar(767) NOT NULL,
  `Pname` varchar(100) NOT NULL,
  `Did` varchar(767) NOT NULL,
  `Dname` varchar(100) NOT NULL,
  `picture` varchar(767) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prescription`
--

INSERT INTO `prescription` (`serial`, `pres`, `Pid`, `Pname`, `Did`, `Dname`, `picture`) VALUES
(12, 'ghh', '6-2126257-0', 'Mrs. X', 'id77', 'Dr. XYZ', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctorinfo`
--
ALTER TABLE `doctorinfo`
  ADD PRIMARY KEY (`serial`),
  ADD UNIQUE KEY `Id` (`Id`),
  ADD UNIQUE KEY `areaOfExp` (`areaOfExp`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`serial`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `patientdetails`
--
ALTER TABLE `patientdetails`
  ADD PRIMARY KEY (`serial`),
  ADD UNIQUE KEY `Id` (`Id`);

--
-- Indexes for table `prescription`
--
ALTER TABLE `prescription`
  ADD PRIMARY KEY (`serial`),
  ADD UNIQUE KEY `Pid` (`Pid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctorinfo`
--
ALTER TABLE `doctorinfo`
  MODIFY `serial` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `serial` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;
--
-- AUTO_INCREMENT for table `patientdetails`
--
ALTER TABLE `patientdetails`
  MODIFY `serial` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `prescription`
--
ALTER TABLE `prescription`
  MODIFY `serial` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
