CREATE TABLE `Events` {
  `eventDate` VARCHAR(45) NULL,
  `location` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `eventName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`eventName`));
}
