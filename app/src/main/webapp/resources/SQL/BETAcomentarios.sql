CREATE TABLE `iesrey`.`BETAcomentarios` (
  `id` BIGINT(11) NOT NULL,
  `texto` VARCHAR(45) NOT NULL,
  `idUsuario` BIGINT(11) NOT NULL,
  `idTweet` BIGINT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idTweet_idx` (`idTweet` ASC),
  CONSTRAINT `idTweet`
    FOREIGN KEY (`idTweet`)
    REFERENCES `iesrey`.`BETAtweets` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);