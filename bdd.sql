CREATE TABLE IF NOT EXISTS `Users` (
`Id_User` int(5) NOT NULL,
  `Pseudo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Mail` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Nom` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Prenom` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Password` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

ALTER TABLE `Users`
 ADD PRIMARY KEY (`Id_User`), ADD UNIQUE KEY `Mail` (`Mail`), ADD UNIQUE KEY `Pseudo` (`Pseudo`);

ALTER TABLE `Users`
MODIFY `Id_User` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;


CREATE TABLE IF NOT EXISTS `Status` (
`Id_Status` int(6) NOT NULL,
  `Title` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Text` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `File` blob,
  `Date` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Id_User` int(5) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

ALTER TABLE `Status`
 ADD PRIMARY KEY (`Id_Status`), ADD KEY `Id_User` (`Id_User`);

ALTER TABLE `Status`
MODIFY `Id_Status` int(6) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;

ALTER TABLE `Status`
ADD CONSTRAINT `Status_ibfk_1` FOREIGN KEY (`Id_User`) REFERENCES `Users` (`Id_User`);

CREATE TABLE IF NOT EXISTS `Friends` (
  `Id_User` int(5) NOT NULL,
  `Id_Friend` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

ALTER TABLE `Friends`
 ADD PRIMARY KEY (`Id_User`,`Id_Friend`), ADD KEY `Id_Friend` (`Id_Friend`);

ALTER TABLE `Friends`
ADD CONSTRAINT `Friends_ibfk_1` FOREIGN KEY (`Id_User`) REFERENCES `Users` (`Id_User`),
ADD CONSTRAINT `Friends_ibfk_2` FOREIGN KEY (`Id_Friend`) REFERENCES `Users` (`Id_User`);

CREATE TABLE IF NOT EXISTS `Comments` (
`Id_Comment` int(5) NOT NULL,
  `Id_Status` int(5) NOT NULL,
  `Id_User` int(5) NOT NULL,
  `Date` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Text` varchar(300) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

ALTER TABLE `Comments`
 ADD PRIMARY KEY (`Id_Comment`,`Id_Status`,`Id_User`), ADD KEY `Id_User` (`Id_User`), ADD KEY `Id_Status` (`Id_Status`);

ALTER TABLE `Comments`
MODIFY `Id_Comment` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;

ALTER TABLE `Comments`
ADD CONSTRAINT `Comments_ibfk_1` FOREIGN KEY (`Id_User`) REFERENCES `Users` (`Id_User`),
ADD CONSTRAINT `Comments_ibfk_2` FOREIGN KEY (`Id_Status`) REFERENCES `Status` (`Id_Status`);
