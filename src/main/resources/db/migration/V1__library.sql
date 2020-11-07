-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 20, 2020 at 01:31 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.3.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `book_id` bigint(20) NOT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `isbn` bigint(20) NOT NULL,
  `series_name` varchar(255) DEFAULT NULL,
  `publisher_id` bigint(20) DEFAULT NULL,
  `writer_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`book_id`, `book_name`, `description`, `isbn`, `series_name`, `publisher_id`, `writer_id`) VALUES
(1, 'Introduction to Java', 'Description about the Book', 1234567890, 'Programming language', 1, 1),
(2, 'Introduction to C', 'Descrption', 1234567890, 'Programming language', 3, 2),
(3, 'Introduction to C++', 'dsadsa', 3213212, 'Academic', 2, 3),
(4, 'Introduction to PHP', 'Kerem', 1234567890, 'Programming language', 5, 4),
(5, 'Introduction to Python', 'Hello', 1234567890, 'Science-fiction', 4, 5),
(6, 'Head First Java', 'description', 1234567890, 'Book', 8, 6),
(7, 'EJB', 'asd', 1234567890, 'Java', 9, 7),
(8, 'Kali', 'Test', 1234567890, 'Linux', 7, 8),
(9, 'Ubuntu', 'dsa', 1234567890, 'Linux', 6, 9),
(10, 'Introduction to Linux', 'asd', 1234567890, 'Academic', 12, 10),
(11, 'Introduction to Assembly', 'asdasd', 1234567890, 'Academic', 10, 11),
(12, 'Introduction to C++', 'dsad', 1234567890, 'Academic', 11, 6);

-- --------------------------------------------------------

--
-- Table structure for table `publisher`
--

CREATE TABLE `publisher` (
  `publisher_id` bigint(20) NOT NULL,
  `publisher_description` varchar(255) DEFAULT NULL,
  `publisher_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `publisher`
--

INSERT INTO `publisher` (`publisher_id`, `publisher_description`, `publisher_name`) VALUES
(1, 'About the publisher', 'PEGASUS'),
(2, 'Description', 'Sony'),
(3, 'Description', 'Konami'),
(4, 'descriptiondescription', 'ASUS'),
(5, 'descriptiondescription', 'Ozgur Software'),
(6, 'description description', 'Intel'),
(7, 'description', 'Microsoft'),
(8, 'description', 'Linux'),
(9, 'description', 'Mac OS X'),
(10, 'description description', 'Samsung'),
(11, 'description description', 'Huawei'),
(12, 'test21', 'test2');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_name`, `user_password`, `user_role`) VALUES
(1, 'depocu', '$2a$10$Wbw0GVGSsSBRjhz9tPe/qOnSLPHkGzHc8SyRnjjYcj.QtGRCG3PcG', 'DEPOCU'),
(2, 'user', '$2a$10$e83FC2X653lXIX/zq2dEcuC1FZikSKzgMGBjfC5KAdiFJixLzaMLa', 'USER'),
(3, 'admin', '$2a$10$vuxmK8yL2.en7cY2vontwOLhUUf7pdXIarde2AqU1UCeCe3J3eLcy', 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `writer`
--

CREATE TABLE `writer` (
  `writer_id` bigint(20) NOT NULL,
  `writer_description` varchar(255) DEFAULT NULL,
  `writer_name` varchar(255) DEFAULT NULL,
  `writer_surname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `writer`
--

INSERT INTO `writer` (`writer_id`, `writer_description`, `writer_name`, `writer_surname`) VALUES
(1, 'Description', 'Kerem', 'Sarmis'),
(2, 'Description', 'Can', 'Kagan'),
(3, 'description', 'Oguz', 'Kagan'),
(4, 'description', 'Kultigin', 'Kagan'),
(5, 'description', 'Baybars', 'Aslan'),
(6, 'description ', 'Sultan', 'Alparslan'),
(7, 'description', 'Ahmet', 'Kerem'),
(8, 'description', 'Biz', 'Siz'),
(9, 'description', 'İlber', 'Ortaylı'),
(10, 'description', 'Kerem', 'Kağan'),
(11, 'description', 'Barış', 'Özcan');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`book_id`),
  ADD KEY `FKgtvt7p649s4x80y6f4842pnfq` (`publisher_id`),
  ADD KEY `FK5ow0lwxq781l5uin7pj2yjop3` (`writer_id`);

--
-- Indexes for table `publisher`
--
ALTER TABLE `publisher`
  ADD PRIMARY KEY (`publisher_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `writer`
--
ALTER TABLE `writer`
  ADD PRIMARY KEY (`writer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `book_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `publisher`
--
ALTER TABLE `publisher`
  MODIFY `publisher_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `writer`
--
ALTER TABLE `writer`
  MODIFY `writer_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FK5ow0lwxq781l5uin7pj2yjop3` FOREIGN KEY (`writer_id`) REFERENCES `writer` (`writer_id`),
  ADD CONSTRAINT `FKgtvt7p649s4x80y6f4842pnfq` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`publisher_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
