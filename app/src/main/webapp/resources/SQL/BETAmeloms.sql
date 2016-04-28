CREATE TABLE `iesrey`.`BETAmeloms` (
  `id` BIGINT(11) NOT NULL,
  `titulo` VARCHAR(150) NOT NULL,
  `album` VARCHAR(20) NULL,
  `tipoMusica` VARCHAR(45) NULL,
  `comentarioMusico` VARCHAR(100) NULL,
  `cancion` LONGBLOB NULL DEFAULT NULL,
  `imagenAlbum` LONGBLOB NULL DEFAULT NULL,
  `idUsuario` BIGINT(11) NOT NULL,
  `fechaPublicación` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `idUsuario_idx` (`idUsuario` ASC),
  CONSTRAINT `idUsuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `iesrey`.`usuarios` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);