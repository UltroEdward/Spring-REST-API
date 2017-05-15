DROP SCHEMA IF EXISTS `VOTE`;
CREATE SCHEMA IF NOT EXISTS `VOTE`;
USE `VOTE`;

-- ******************** Create tables ******************** 

CREATE TABLE `VOTE_ROOM` (
	`ID` int(10) NOT NULL auto_increment,
	`NAME` varchar(100) NOT NULL,
	`IS_OPENED` varchar,
	 PRIMARY KEY (`ID`)
);

CREATE TABLE `QUESTIONS` (
	`ID` int(10) NOT NULL auto_increment,,
	`QUESTION` varchar(100) NOT NULL
	 PRIMARY KEY (`ID`)
);

CREATE TABLE `ANSWER` (
	`ID` int(10) NOT NULL auto_increment,
	`ID_QUESTION` int(10) NOT NULL auto_increment,
	`ANSWER` varchar(100) NOT NULL,
	 PRIMARY KEY (`ID`),
	 FOREIGN KEY (`ID_QUESTION`) REFERENCES QUESTIONS(ID)
);

CREATE TABLE `VOTE` (
	`ID` int(10) NOT NULL auto_increment,
	`ID_ROOM` int(10) NOT NULL auto_increment,
	`ID_ANSWER` int(10)) NOT NULL,
	 PRIMARY KEY (`ID`),
	 FOREIGN KEY (`ID_ROOM`) REFERENCES VOTE_ROOM(ID),
	 FOREIGN KEY (`ID_ANSWER`) REFERENCES ANSWER(ID)
);

-- ******************** Create tables ******************** 

