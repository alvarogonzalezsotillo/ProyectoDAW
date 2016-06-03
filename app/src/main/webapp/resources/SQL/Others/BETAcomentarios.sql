CREATE TABLE `iesrey`.`BETAcomentarios` (
  `id` BIGINT(11) NOT NULL,
  `texto` VARCHAR(200) NOT NULL,
  `idUsuario` BIGINT(11) NOT NULL,
  `idMelom` BIGINT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idMelom_idx` (`idMelom` ASC),
  CONSTRAINT `idMelom`
    FOREIGN KEY (`idMelom`)
    REFERENCES `iesrey`.meloms (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);