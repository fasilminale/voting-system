-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 10, 2019 at 08:19 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `voting`
--

-- --------------------------------------------------------

--
-- Table structure for table `Competitors`
--

CREATE TABLE `Competitors` (
  `competitor_id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `age` int(3) NOT NULL,
  `job` text NOT NULL,
  `detail` text NOT NULL,
  `count` int(11) NOT NULL,
  `election_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Competitors`
--

INSERT INTO `Competitors` (`competitor_id`, `name`, `age`, `job`, `detail`, `count`, `election_id`) VALUES
(1, 'Efrem Seyume', 0, 'writer', 'he has writen 20 books since 1990', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Elections`
--

CREATE TABLE `Elections` (
  `election_id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `type` varchar(100) NOT NULL,
  `detail` varchar(200) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `result` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Elections`
--

INSERT INTO `Elections` (`election_id`, `name`, `type`, `detail`, `status`, `result`) VALUES
(1, 'Book Awards', 'Entertement', 'good book of 2018', 1, ''),
(2, 'music2', 'ent', 'top music of 2019', 1, ''),
(3, 'test name', 'test type', 'test detail', 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE `Users` (
  `user_id` int(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `age` int(3) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`user_id`, `email`, `age`, `username`, `password`) VALUES
(1, 'fasiladam1290@gmail.com', 22, 'fasilminale', '123456'),
(2, 'lemma@gmail.com', 21, 'lemma', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `Votes`
--

CREATE TABLE `Votes` (
  `vote_id` int(11) NOT NULL,
  `election_id` int(11) NOT NULL,
  `competitor_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Votes`
--

INSERT INTO `Votes` (`vote_id`, `election_id`, `competitor_id`, `user_id`) VALUES
(1, 1, 1, 1),
(2, 1, 1, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Competitors`
--
ALTER TABLE `Competitors`
  ADD PRIMARY KEY (`competitor_id`),
  ADD KEY `election_id` (`election_id`);

--
-- Indexes for table `Elections`
--
ALTER TABLE `Elections`
  ADD PRIMARY KEY (`election_id`);

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username_2` (`username`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `Votes`
--
ALTER TABLE `Votes`
  ADD PRIMARY KEY (`vote_id`),
  ADD KEY `election_id` (`election_id`),
  ADD KEY `competitor_id` (`competitor_id`),
  ADD KEY `user_id` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Competitors`
--
ALTER TABLE `Competitors`
  MODIFY `competitor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `Elections`
--
ALTER TABLE `Elections`
  MODIFY `election_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `Users`
--
ALTER TABLE `Users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `Votes`
--
ALTER TABLE `Votes`
  MODIFY `vote_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Competitors`
--
ALTER TABLE `Competitors`
  ADD CONSTRAINT `competitors_ibfk_1` FOREIGN KEY (`election_id`) REFERENCES `Elections` (`election_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Votes`
--
ALTER TABLE `Votes`
  ADD CONSTRAINT `votes_ibfk_1` FOREIGN KEY (`election_id`) REFERENCES `Elections` (`election_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `votes_ibfk_2` FOREIGN KEY (`competitor_id`) REFERENCES `Competitors` (`competitor_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `votes_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `Users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
