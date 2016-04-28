CREATE TABLE `iesrey`.`BETAcomentarios` (
  `id` BIGINT(11) NOT NULL,
  `texto` VARCHAR(200) NOT NULL,
  `idUsuario` BIGINT(11) NOT NULL,
  `idTweet` BIGINT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idTweet_idx` (`idTweet` ASC),
  CONSTRAINT `idTweet`
    FOREIGN KEY (`idTweet`)
    REFERENCES `iesrey`.BETAmeloms (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);