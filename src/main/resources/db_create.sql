DROP SCHEMA IF EXISTS `VOTE`;
CREATE SCHEMA IF NOT EXISTS `VOTE`;
USE `VOTE`;

-- ******************** Create tables ******************** 
CREATE TABLE `QUESTIONS` (
	`ID` int(10) NOT NULL auto_increment,
	`QUESTION` varchar(100) NOT NULL,
    
	 PRIMARY KEY (`ID`)
);

CREATE TABLE `VOTE_ROOMS` (
	`ID` int(10) NOT NULL auto_increment,
	`NAME` varchar(100) NOT NULL,
	`IS_OPENED` BOOLEAN NOT NULL DEFAULT 0,
	`ID_QUESTION` int(10) NOT NULL,
    
	 PRIMARY KEY (`ID`),
	 FOREIGN KEY (`ID_QUESTION`) REFERENCES QUESTIONS(ID)
);

CREATE TABLE `ANSWERS` (
	`ID` int(10) NOT NULL auto_increment,
	`ID_QUESTION` int(10) NOT NULL,
	`ANSWER` varchar(100) NOT NULL,
	`USER` varchar(100),
    
	 PRIMARY KEY (`ID`),
	 FOREIGN KEY (`ID_QUESTION`) REFERENCES QUESTIONS(ID)
);

CREATE TABLE `VOTES` (
	`ID` int(10) NOT NULL auto_increment,
	`ID_ROOM` int(10) NOT NULL ,
	`ID_ANSWER` int(10) NOT NULL,
    
	 PRIMARY KEY (`ID`),
	 FOREIGN KEY (`ID_ROOM`) REFERENCES VOTE_ROOMS(ID),
	 FOREIGN KEY (`ID_ANSWER`) REFERENCES ANSWERS(ID)
);

-- ******************** Create tables ******************** 



-- ******************** Seed test data *******************

INSERT INTO `vote`.`questions` (`QUESTION`) VALUES ('How old are you?');
INSERT INTO `vote`.`questions` (`QUESTION`) VALUES ('Are you married?');
INSERT INTO `vote`.`questions` (`QUESTION`) VALUES ('Why so serious?');

INSERT INTO `vote`.`vote_rooms` (`ID`, `NAME`, `IS_OPENED`, `ID_QUESTION`) VALUES ('1', 'Age vote_1', '0', '1');
INSERT INTO `vote`.`vote_rooms` (`ID`, `NAME`, `IS_OPENED`, `ID_QUESTION`) VALUES ('2', 'Age vote_2', '0', '1');
INSERT INTO `vote`.`vote_rooms` (`ID`, `NAME`, `IS_OPENED`, `ID_QUESTION`) VALUES ('3', 'Marital voting', '0', '2');

INSERT INTO `vote`.`answers` (`ID`, `ID_QUESTION`, `ANSWER`) VALUES ('1', '1', '>18');
INSERT INTO `vote`.`answers` (`ID`, `ID_QUESTION`, `ANSWER`) VALUES ('2', '1', '=<18');
INSERT INTO `vote`.`answers` (`ID`, `ID_QUESTION`, `ANSWER`) VALUES ('3', '2', 'Yes');
INSERT INTO `vote`.`answers` (`ID`, `ID_QUESTION`, `ANSWER`) VALUES ('4', '2', 'No');

INSERT INTO `vote`.`votes` (`ID`, `ID_ROOM`, `ID_ANSWER`) VALUES ('1', '1', '1');
INSERT INTO `vote`.`votes` (`ID`, `ID_ROOM`, `ID_ANSWER`) VALUES ('2', '1', '1');
INSERT INTO `vote`.`votes` (`ID`, `ID_ROOM`, `ID_ANSWER`) VALUES ('3', '1', '1');
INSERT INTO `vote`.`votes` (`ID`, `ID_ROOM`, `ID_ANSWER`) VALUES ('4', '1', '2');
INSERT INTO `vote`.`votes` (`ID`, `ID_ROOM`, `ID_ANSWER`) VALUES ('5', '2', '2');
INSERT INTO `vote`.`votes` (`ID`, `ID_ROOM`, `ID_ANSWER`) VALUES ('6', '2', '2');


-- ******************** Seed test data *******************

