DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS PUBLIC_USERS;


CREATE TABLE `USER` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(45) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  `ROLE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `MEIT` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  
