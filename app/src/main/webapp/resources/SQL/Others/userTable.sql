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