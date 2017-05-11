DROP SCHEMA IF EXISTS `VOTE`;
CREATE SCHEMA IF NOT EXISTS `VOTE`;
USE `VOTE`;

-- ******************** Create tables ******************** 

CREATE TABLE `VOTE_ROOM` (
	`ID` int(10) NOT NULL auto_increment,
	`NAME` varchar(100) NOT NULL,
	`IS_OPENED` varchar
	 PRIMARY KEY (`ID`)
);

-- ******************** Create tables ******************** 

