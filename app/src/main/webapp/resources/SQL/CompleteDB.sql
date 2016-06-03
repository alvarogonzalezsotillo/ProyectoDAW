CREATE SCHEMA IF NOT EXISTS `iesrey`;

CREATE TABLE `iesrey`.`usuarios` (
  `id` BIGINT(11) NOT NULL,
  `nombreDeUsuario` VARCHAR(45) NOT NULL,
  `apellidoDeUsuario` VARCHAR(45) NOT NULL,
  `nickDeUsuario` VARCHAR(65) NOT NULL,
  `passwordDeUsuario` VARCHAR(254) NOT NULL,
  `correoDeUsuario` VARCHAR(85) NULL,
  `imagenDeUsuario` LONGBLOB NULL,
  `grupoDeUsuario` VARCHAR(35) NULL,
  `webDeUsuario` VARCHAR(100) NULL,
  `tipoMusicaDeUsuario` VARCHAR(20) NULL,
  `esAdmin` TINYINT(1) NOT NULL DEFAULT 0,
  `fechaRegistro` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));

CREATE TABLE `iesrey`.`BETAmeloms` (
  `id` BIGINT(11) NOT NULL,
  `autor` VARCHAR(60) NOT NULL,
  `titulo` VARCHAR(150) NOT NULL,
  `album` VARCHAR(20) NULL,
  `tipoMusica` VARCHAR(45) NULL,
  `comentarioMusico` VARCHAR(100) NULL,
  `rutaCancion` VARCHAR(240) NULL DEFAULT NULL,
  `rutaImagenAlbum` VARCHAR(240) NULL DEFAULT NULL,
  `idUsuario` BIGINT(11) NOT NULL,
  `fechaPublicacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `idUsuario_idx` (`idUsuario` ASC),
  CONSTRAINT `idUsuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `iesrey`.`usuarios` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);

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

CREATE TABLE `iesrey`.`BETAconciertos` (
  `id` BIGINT(11) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `pais` VARCHAR(50) NOT NULL,
  `ciudad` VARCHAR(60) NOT NULL,
  `lugar` VARCHAR(80) NOT NULL,
  `idUsuario` BIGINT(11) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `iesrey`.`BETAfollowers` (
  `idUsuario`  BIGINT (11) NOT NULL,
  `idFollower` BIGINT (11) NOT NULL,
  PRIMARY KEY (`idUsuario`, `idFollower`)
);

CREATE TABLE `iesrey`.`hibernate_sequence` (`next_val` bigint);

INSERT INTO `iesrey`.`hibernate_sequence`(`next_val`)
VALUE (0);