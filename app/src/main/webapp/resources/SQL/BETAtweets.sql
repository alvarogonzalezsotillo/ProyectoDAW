CREATE TABLE `iesrey`.`BETAtweets` (
  `id` BIGINT(11) NOT NULL,
  `titulo` VARCHAR(150) NOT NULL,
  `album` VARCHAR(20) NULL,
  `tipoMusica` VARCHAR(45) NULL,
  `comentarioMusico` VARCHAR(60) NULL,
  `cancion` BLOB NULL DEFAULT NULL,
  `imagenAlbum` BLOB NULL DEFAULT NULL,
  `idUsuario` BIGINT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idUsuario_idx` (`idUsuario` ASC),
  CONSTRAINT `idUsuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `iesrey`.`usuarios` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);