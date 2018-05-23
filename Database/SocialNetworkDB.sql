-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 23, 2018 at 05:51 PM
-- Server version: 5.7.21-0ubuntu0.16.04.1
-- PHP Version: 7.0.28-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `SocialNetworkDB`
--

-- --------------------------------------------------------

--
-- Table structure for table `commentsTB`
--

CREATE TABLE `commentsTB` (
  `id` int(11) NOT NULL,
  `postId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `parentCommentId` int(11) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `countryTB`
--

CREATE TABLE `countryTB` (
  `id` int(11) NOT NULL,
  `countryName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `countryTB`
--

INSERT INTO `countryTB` (`id`, `countryName`) VALUES
(1, 'Andorra'),
(2, 'United Arab Emirates'),
(3, 'Afghanistan'),
(4, 'Antigua and Barbuda'),
(5, 'Anguilla'),
(6, 'Albania'),
(7, 'Armenia'),
(8, 'Angola'),
(9, 'Antarctica'),
(10, 'Argentina'),
(11, 'American Samoa'),
(12, 'Austria'),
(13, 'Australia'),
(14, 'Aruba'),
(15, 'Åland'),
(16, 'Azerbaijan'),
(17, 'Bosnia and Herzegovina'),
(18, 'Barbados'),
(19, 'Bangladesh'),
(20, 'Belgium'),
(21, 'Burkina Faso'),
(22, 'Bulgaria'),
(23, 'Bahrain'),
(24, 'Burundi'),
(25, 'Benin'),
(26, 'Saint Barthélemy'),
(27, 'Bermuda'),
(28, 'Brunei'),
(29, 'Bolivia'),
(30, 'Bonaire'),
(31, 'Brazil'),
(32, 'Bahamas'),
(33, 'Bhutan'),
(34, 'Bouvet Island'),
(35, 'Botswana'),
(36, 'Belarus'),
(37, 'Belize'),
(38, 'Canada'),
(39, 'Cocos [Keeling] Islands'),
(40, 'Democratic Republic of the Congo'),
(41, 'Central African Republic'),
(42, 'Republic of the Congo'),
(43, 'Switzerland'),
(44, 'Ivory Coast'),
(45, 'Cook Islands'),
(46, 'Chile'),
(47, 'Cameroon'),
(48, 'China'),
(49, 'Colombia'),
(50, 'Costa Rica'),
(51, 'Cuba'),
(52, 'Cape Verde'),
(53, 'Curacao'),
(54, 'Christmas Island'),
(55, 'Cyprus'),
(56, 'Czechia'),
(57, 'Germany'),
(58, 'Djibouti'),
(59, 'Denmark'),
(60, 'Dominica'),
(61, 'Dominican Republic'),
(62, 'Algeria'),
(63, 'Ecuador'),
(64, 'Estonia'),
(65, 'Egypt'),
(66, 'Western Sahara'),
(67, 'Eritrea'),
(68, 'Spain'),
(69, 'Ethiopia'),
(70, 'Finland'),
(71, 'Fiji'),
(72, 'Falkland Islands'),
(73, 'Micronesia'),
(74, 'Faroe Islands'),
(75, 'France'),
(76, 'Gabon'),
(77, 'United Kingdom'),
(78, 'Grenada'),
(79, 'Georgia'),
(80, 'French Guiana'),
(81, 'Guernsey'),
(82, 'Ghana'),
(83, 'Gibraltar'),
(84, 'Greenland'),
(85, 'Gambia'),
(86, 'Guinea'),
(87, 'Guadeloupe'),
(88, 'Equatorial Guinea'),
(89, 'Greece'),
(90, 'South Georgia and the South Sandwich Islands'),
(91, 'Guatemala'),
(92, 'Guam'),
(93, 'Guinea-Bissau'),
(94, 'Guyana'),
(95, 'Hong Kong'),
(96, 'Heard Island and McDonald Islands'),
(97, 'Honduras'),
(98, 'Croatia'),
(99, 'Haiti'),
(100, 'Hungary'),
(101, 'Indonesia'),
(102, 'Ireland'),
(103, 'Israel'),
(104, 'Isle of Man'),
(105, 'India'),
(106, 'British Indian Ocean Territory'),
(107, 'Iraq'),
(108, 'Iran'),
(109, 'Iceland'),
(110, 'Italy'),
(111, 'Jersey'),
(112, 'Jamaica'),
(113, 'Jordan'),
(114, 'Japan'),
(115, 'Kenya'),
(116, 'Kyrgyzstan'),
(117, 'Cambodia'),
(118, 'Kiribati'),
(119, 'Comoros'),
(120, 'Saint Kitts and Nevis'),
(121, 'North Korea'),
(122, 'South Korea'),
(123, 'Kuwait'),
(124, 'Cayman Islands'),
(125, 'Kazakhstan'),
(126, 'Laos'),
(127, 'Lebanon'),
(128, 'Saint Lucia'),
(129, 'Liechtenstein'),
(130, 'Sri Lanka'),
(131, 'Liberia'),
(132, 'Lesotho'),
(133, 'Lithuania'),
(134, 'Luxembourg'),
(135, 'Latvia'),
(136, 'Libya'),
(137, 'Morocco'),
(138, 'Monaco'),
(139, 'Moldova'),
(140, 'Montenegro'),
(141, 'Saint Martin'),
(142, 'Madagascar'),
(143, 'Marshall Islands'),
(144, 'Macedonia'),
(145, 'Mali'),
(146, 'Myanmar [Burma]'),
(147, 'Mongolia'),
(148, 'Macao'),
(149, 'Northern Mariana Islands'),
(150, 'Martinique'),
(151, 'Mauritania'),
(152, 'Montserrat'),
(153, 'Malta'),
(154, 'Mauritius'),
(155, 'Maldives'),
(156, 'Malawi'),
(157, 'Mexico'),
(158, 'Malaysia'),
(159, 'Mozambique'),
(160, 'Namibia'),
(161, 'New Caledonia'),
(162, 'Niger'),
(163, 'Norfolk Island'),
(164, 'Nigeria'),
(165, 'Nicaragua'),
(166, 'Netherlands'),
(167, 'Norway'),
(168, 'Nepal'),
(169, 'Nauru'),
(170, 'Niue'),
(171, 'New Zealand'),
(172, 'Oman'),
(173, 'Panama'),
(174, 'Peru'),
(175, 'French Polynesia'),
(176, 'Papua New Guinea'),
(177, 'Philippines'),
(178, 'Pakistan'),
(179, 'Poland'),
(180, 'Saint Pierre and Miquelon'),
(181, 'Pitcairn Islands'),
(182, 'Puerto Rico'),
(183, 'Palestine'),
(184, 'Portugal'),
(185, 'Palau'),
(186, 'Paraguay'),
(187, 'Qatar'),
(188, 'Réunion'),
(189, 'Romania'),
(190, 'Serbia'),
(191, 'Russia'),
(192, 'Rwanda'),
(193, 'Saudi Arabia'),
(194, 'Solomon Islands'),
(195, 'Seychelles'),
(196, 'Sudan'),
(197, 'Sweden'),
(198, 'Singapore'),
(199, 'Saint Helena'),
(200, 'Slovenia'),
(201, 'Svalbard and Jan Mayen'),
(202, 'Slovakia'),
(203, 'Sierra Leone'),
(204, 'San Marino'),
(205, 'Senegal'),
(206, 'Somalia'),
(207, 'Suriname'),
(208, 'South Sudan'),
(209, 'São Tomé and Príncipe'),
(210, 'El Salvador'),
(211, 'Sint Maarten'),
(212, 'Syria'),
(213, 'Swaziland'),
(214, 'Turks and Caicos Islands'),
(215, 'Chad'),
(216, 'French Southern Territories'),
(217, 'Togo'),
(218, 'Thailand'),
(219, 'Tajikistan'),
(220, 'Tokelau'),
(221, 'East Timor'),
(222, 'Turkmenistan'),
(223, 'Tunisia'),
(224, 'Tonga'),
(225, 'Turkey'),
(226, 'Trinidad and Tobago'),
(227, 'Tuvalu'),
(228, 'Taiwan'),
(229, 'Tanzania'),
(230, 'Ukraine'),
(231, 'Uganda'),
(232, 'U.S. Minor Outlying Islands'),
(233, 'United States'),
(234, 'Uruguay'),
(235, 'Uzbekistan'),
(236, 'Vatican City'),
(237, 'Saint Vincent and the Grenadines'),
(238, 'Venezuela'),
(239, 'British Virgin Islands'),
(240, 'U.S. Virgin Islands'),
(241, 'Vietnam'),
(242, 'Vanuatu'),
(243, 'Wallis and Futuna'),
(244, 'Samoa'),
(245, 'Kosovo'),
(246, 'Yemen'),
(247, 'Mayotte'),
(248, 'South Africa'),
(249, 'Zambia'),
(250, 'Zimbabwe');

-- --------------------------------------------------------

--
-- Table structure for table `friendRequestTB`
--

CREATE TABLE `friendRequestTB` (
  `id` int(11) NOT NULL,
  `fromUserId` int(11) NOT NULL,
  `toUserId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `friendTB`
--

CREATE TABLE `friendTB` (
  `userId1` int(11) NOT NULL,
  `userId2` int(11) NOT NULL,
  `priorityOrder` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `friendTB`
--

INSERT INTO `friendTB` (`userId1`, `userId2`, `priorityOrder`) VALUES
(21, 28, 0),
(28, 21, 0),
(28, 35, 0),
(35, 28, 0);

-- --------------------------------------------------------

--
-- Table structure for table `groupChatTB`
--

CREATE TABLE `groupChatTB` (
  `id` int(11) NOT NULL,
  `createdUserId` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `createdDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `groupChatXuserTB`
--

CREATE TABLE `groupChatXuserTB` (
  `groupChatId` int(11) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `groupTB`
--

CREATE TABLE `groupTB` (
  `emailId` varchar(255) NOT NULL,
  `groupName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groupTB`
--

INSERT INTO `groupTB` (`emailId`, `groupName`) VALUES
('akku3369@gmail.com', 'UserGroup'),
('ayushi@gmail.com', 'UserGroup'),
('heta@gmail.com', 'UserGroup'),
('hjariwala130896@gmail.com', 'AdminGroup'),
('hjariwala1414@gmail.com', 'UserGroup'),
('mansinmodi@gmail.com', 'UserGroup'),
('moheetjari@gmail.com', 'UserGroup'),
('viralidabhi22@gmail.com', 'UserGroup'),
('yashpatel@gmail.com', 'UserGroup');

-- --------------------------------------------------------

--
-- Table structure for table `likeTB`
--

CREATE TABLE `likeTB` (
  `id` int(11) NOT NULL,
  `postId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `createdDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `messageTB`
--

CREATE TABLE `messageTB` (
  `id` int(11) NOT NULL,
  `fromUserId` int(11) DEFAULT NULL,
  `toUserId` int(11) DEFAULT NULL,
  `groupId` int(11) DEFAULT NULL,
  `time` time DEFAULT NULL,
  `messageText` varchar(255) DEFAULT NULL,
  `isFile` tinyint(1) DEFAULT NULL,
  `fileUrl` varchar(255) DEFAULT NULL,
  `createdDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `postTB`
--

CREATE TABLE `postTB` (
  `id` int(11) NOT NULL,
  `heading` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `isImage` tinyint(1) DEFAULT NULL,
  `isVideo` tinyint(1) DEFAULT NULL,
  `videoUrl` varchar(255) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `postXimageTB`
--

CREATE TABLE `postXimageTB` (
  `id` int(11) NOT NULL,
  `postId` int(11) DEFAULT NULL,
  `imageUrl` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `userTB`
--

CREATE TABLE `userTB` (
  `id` int(11) NOT NULL,
  `fName` varchar(255) DEFAULT NULL,
  `lName` varchar(255) DEFAULT NULL,
  `mobileNo` bigint(10) DEFAULT NULL,
  `emailId` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `profilePicture` varchar(255) DEFAULT NULL,
  `countryId` int(11) DEFAULT NULL,
  `isVerified` int(11) NOT NULL DEFAULT '0',
  `verificationCode` varchar(255) DEFAULT NULL,
  `createdDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userTB`
--

INSERT INTO `userTB` (`id`, `fName`, `lName`, `mobileNo`, `emailId`, `password`, `dob`, `gender`, `profilePicture`, `countryId`, `isVerified`, `verificationCode`, `createdDate`) VALUES
(1, 'Harsh', 'Jariwala', 8141484832, 'hjariwala130896@gmail.com', '60fe74406e7f353ed979f350f2fbb6a2e8690a5fa7d1b0c32983d1d8b3f95f67', '1996-08-13', 'Male', NULL, 105, 1, NULL, '2018-04-17'),
(3, 'Aakansha', 'Patel', 9904103571, 'akku3369@gmail.com', '3e16ecfa88c44efef1d838d87fa094e84e31f679927968d24eb75ad3387dfee4', '1997-02-13', 'Female', '18052018051639986.jpg', 105, 1, NULL, '2018-04-17'),
(8, 'Ayushi', 'Vankawala', 9874563210, 'ayushi@gmail.com', '22f9f70548f30c6cdd3a8eb8664a6c43cd10404a767162822f483aa4f6cee4a4', '1997-08-27', 'Female', NULL, 105, 0, NULL, '2018-04-18'),
(9, 'Mansi', 'Modi', 9632587410, 'mansinmodi@gmail.com', '70c5f99bf46c467e5cfc362900a0138caae4709a4ae765d33b0430faf1859e70', '1997-02-22', 'Female', NULL, 105, 0, NULL, '2018-04-18'),
(10, 'Heta', 'Sheth', 1234567890, 'heta@gmail.com', '23f5eea7e0011dc26470d141ab0014325027fcacc75250dba26030f53e7f765a', '1996-10-07', 'Female', NULL, 105, 0, NULL, '2018-04-18'),
(11, 'Yash', 'Patel', 1234569870, 'yashpatel@gmail.com', '0b4aa33184c17d937b0b2fbbf2bf2c2b459092d76fbbf32c14d2d16c3b593c94', '2018-04-19', 'Male', NULL, 105, 0, NULL, '2018-04-20'),
(21, 'Virali', 'Dabhi', 9924324178, 'viralidabhi22@gmail.com', '64b41ab6c82ec29f3d0ced26c54ceaebcb166c6ae4adb50e26b995c7324fe16a', '1996-10-30', 'Female', '20052018020251157.jpg', 105, 1, NULL, '2018-05-19'),
(28, 'H', 'Jariwala', 8141484832, 'hjariwala1414@gmail.com', 'daef57dd7c523f76ef0522a0f5430c17fcd6a574487c320269abbd821d92fa01', '1996-08-13', 'Male', '23052018124213310.jpg', 105, 1, NULL, '2018-05-20'),
(35, 'mohit', 'Jariwala', 8866022012, 'moheetjari@gmail.com', 'da54773a7a5a99781e6db854eb3f10257e7d61dc7280dc36a2e43389aaa542f0', '1998-07-25', 'Male', '23052018011455505.jpg', 105, 1, NULL, '2018-05-22');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `commentsTB`
--
ALTER TABLE `commentsTB`
  ADD PRIMARY KEY (`id`),
  ADD KEY `postId` (`postId`),
  ADD KEY `userId` (`userId`),
  ADD KEY `parentCommentId` (`parentCommentId`);

--
-- Indexes for table `countryTB`
--
ALTER TABLE `countryTB`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `friendRequestTB`
--
ALTER TABLE `friendRequestTB`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fromUserId` (`fromUserId`,`toUserId`),
  ADD KEY `toUserId` (`toUserId`);

--
-- Indexes for table `friendTB`
--
ALTER TABLE `friendTB`
  ADD PRIMARY KEY (`userId1`,`userId2`),
  ADD KEY `userId2` (`userId2`),
  ADD KEY `userId1` (`userId1`);

--
-- Indexes for table `groupChatTB`
--
ALTER TABLE `groupChatTB`
  ADD PRIMARY KEY (`id`),
  ADD KEY `createdUserId` (`createdUserId`);

--
-- Indexes for table `groupChatXuserTB`
--
ALTER TABLE `groupChatXuserTB`
  ADD PRIMARY KEY (`groupChatId`,`userId`),
  ADD KEY `userId` (`userId`),
  ADD KEY `groupChatId` (`groupChatId`);

--
-- Indexes for table `groupTB`
--
ALTER TABLE `groupTB`
  ADD PRIMARY KEY (`emailId`,`groupName`),
  ADD KEY `emailId` (`emailId`);

--
-- Indexes for table `likeTB`
--
ALTER TABLE `likeTB`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userId` (`userId`),
  ADD KEY `postId` (`postId`);

--
-- Indexes for table `messageTB`
--
ALTER TABLE `messageTB`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fromUserId` (`fromUserId`),
  ADD KEY `toUserId` (`toUserId`),
  ADD KEY `groupId` (`groupId`);

--
-- Indexes for table `postTB`
--
ALTER TABLE `postTB`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userId` (`userId`);

--
-- Indexes for table `postXimageTB`
--
ALTER TABLE `postXimageTB`
  ADD PRIMARY KEY (`id`),
  ADD KEY `postId` (`postId`);

--
-- Indexes for table `userTB`
--
ALTER TABLE `userTB`
  ADD PRIMARY KEY (`id`),
  ADD KEY `countryId` (`countryId`),
  ADD KEY `emailId` (`emailId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `commentsTB`
--
ALTER TABLE `commentsTB`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `countryTB`
--
ALTER TABLE `countryTB`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=251;
--
-- AUTO_INCREMENT for table `friendRequestTB`
--
ALTER TABLE `friendRequestTB`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `groupChatTB`
--
ALTER TABLE `groupChatTB`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `likeTB`
--
ALTER TABLE `likeTB`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `messageTB`
--
ALTER TABLE `messageTB`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `postTB`
--
ALTER TABLE `postTB`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `postXimageTB`
--
ALTER TABLE `postXimageTB`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `userTB`
--
ALTER TABLE `userTB`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `commentsTB`
--
ALTER TABLE `commentsTB`
  ADD CONSTRAINT `commentsTB_ibfk_1` FOREIGN KEY (`postId`) REFERENCES `postTB` (`id`),
  ADD CONSTRAINT `commentsTB_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `userTB` (`id`),
  ADD CONSTRAINT `commentsTB_ibfk_3` FOREIGN KEY (`parentCommentId`) REFERENCES `commentsTB` (`id`);

--
-- Constraints for table `friendRequestTB`
--
ALTER TABLE `friendRequestTB`
  ADD CONSTRAINT `friendRequestTB_ibfk_1` FOREIGN KEY (`fromUserId`) REFERENCES `userTB` (`id`),
  ADD CONSTRAINT `friendRequestTB_ibfk_2` FOREIGN KEY (`toUserId`) REFERENCES `userTB` (`id`);

--
-- Constraints for table `friendTB`
--
ALTER TABLE `friendTB`
  ADD CONSTRAINT `friendTB_ibfk_1` FOREIGN KEY (`userId1`) REFERENCES `userTB` (`id`),
  ADD CONSTRAINT `friendTB_ibfk_2` FOREIGN KEY (`userId2`) REFERENCES `userTB` (`id`);

--
-- Constraints for table `groupChatTB`
--
ALTER TABLE `groupChatTB`
  ADD CONSTRAINT `groupChatTB_ibfk_1` FOREIGN KEY (`createdUserId`) REFERENCES `userTB` (`id`);

--
-- Constraints for table `groupChatXuserTB`
--
ALTER TABLE `groupChatXuserTB`
  ADD CONSTRAINT `groupChatXuserTB_ibfk_1` FOREIGN KEY (`groupChatId`) REFERENCES `groupChatTB` (`id`),
  ADD CONSTRAINT `groupChatXuserTB_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `userTB` (`id`);

--
-- Constraints for table `groupTB`
--
ALTER TABLE `groupTB`
  ADD CONSTRAINT `groupTB_ibfk_1` FOREIGN KEY (`emailId`) REFERENCES `userTB` (`emailId`) ON DELETE CASCADE;

--
-- Constraints for table `likeTB`
--
ALTER TABLE `likeTB`
  ADD CONSTRAINT `likeTB_ibfk_1` FOREIGN KEY (`postId`) REFERENCES `postTB` (`id`),
  ADD CONSTRAINT `likeTB_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `userTB` (`id`);

--
-- Constraints for table `messageTB`
--
ALTER TABLE `messageTB`
  ADD CONSTRAINT `messageTB_ibfk_1` FOREIGN KEY (`fromUserId`) REFERENCES `userTB` (`id`),
  ADD CONSTRAINT `messageTB_ibfk_2` FOREIGN KEY (`toUserId`) REFERENCES `userTB` (`id`),
  ADD CONSTRAINT `messageTB_ibfk_3` FOREIGN KEY (`groupId`) REFERENCES `groupChatTB` (`id`);

--
-- Constraints for table `postTB`
--
ALTER TABLE `postTB`
  ADD CONSTRAINT `postTB_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `userTB` (`id`);

--
-- Constraints for table `postXimageTB`
--
ALTER TABLE `postXimageTB`
  ADD CONSTRAINT `postXimageTB_ibfk_1` FOREIGN KEY (`postId`) REFERENCES `postTB` (`id`);

--
-- Constraints for table `userTB`
--
ALTER TABLE `userTB`
  ADD CONSTRAINT `userTB_ibfk_1` FOREIGN KEY (`countryId`) REFERENCES `countryTB` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
