DROP SCHEMA IF EXISTS `VOTE`;
CREATE SCHEMA IF NOT EXISTS `VOTE`;
USE `VOTE`;

-- ******************** Create tables ******************** 
CREATE TABLE `QUESTIONS` (
	`ID` int(10) NOT NULL auto_increment,
	`QUESTION` varchar(100) NOT NULL,
    
	 PRIMARY KEY (`ID`)
);

CREATE TABLE `VOTE_ROOM` (
	`ID` int(10) NOT NULL auto_increment,
	`NAME` varchar(100) NOT NULL,
	`IS_OPENED` BOOLEAN NOT NULL DEFAULT 0,
	`ID_QUESTION` int(10) NOT NULL,
    
	 PRIMARY KEY (`ID`),
	 FOREIGN KEY (`ID_QUESTION`) REFERENCES QUESTIONS(ID)
);

CREATE TABLE `ANSWER` (
	`ID` int(10) NOT NULL auto_increment,
	`ID_QUESTION` int(10) NOT NULL,
	`ANSWER` varchar(100) NOT NULL,
    
	 PRIMARY KEY (`ID`),
	 FOREIGN KEY (`ID_QUESTION`) REFERENCES QUESTIONS(ID)
);

CREATE TABLE `VOTE` (
	`ID` int(10) NOT NULL auto_increment,
	`ID_ROOM` int(10) NOT NULL ,
	`ID_ANSWER` int(10) NOT NULL,
    
	 PRIMARY KEY (`ID`),
	 FOREIGN KEY (`ID_ROOM`) REFERENCES VOTE_ROOM(ID),
	 FOREIGN KEY (`ID_ANSWER`) REFERENCES ANSWER(ID)
);

-- ******************** Create tables ******************** 



-- ******************** Seed test data *******************

INSERT INTO `vote`.`questions` (`QUESTION`) VALUES ('How old are you?');
INSERT INTO `vote`.`questions` (`QUESTION`) VALUES ('Are you married?');
INSERT INTO `vote`.`questions` (`QUESTION`) VALUES ('Why so serious?');

INSERT INTO `vote`.`vote_room` (`ID`, `NAME`, `IS_OPENED`, `ID_QUESTION`) VALUES ('1', 'Age vote', '1', '1');
INSERT INTO `vote`.`vote_room` (`ID`, `NAME`, `IS_OPENED`, `ID_QUESTION`) VALUES ('2', 'Marital voting', '1', '2');

INSERT INTO `vote`.`answer` (`ID`, `ID_QUESTION`, `ANSWER`) VALUES ('1', '1', '>18');
INSERT INTO `vote`.`answer` (`ID`, `ID_QUESTION`, `ANSWER`) VALUES ('2', '1', '=<18');
INSERT INTO `vote`.`answer` (`ID`, `ID_QUESTION`, `ANSWER`) VALUES ('3', '2', 'Yes');
INSERT INTO `vote`.`answer` (`ID`, `ID_QUESTION`, `ANSWER`) VALUES ('4', '2', 'No');

-- ******************** Seed test data *******************

