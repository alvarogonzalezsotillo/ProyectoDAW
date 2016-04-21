CREATE TABLE `iesrey`.`BETAconciertos` (
  `id` BIGINT(11) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `pais` VARCHAR(50) NOT NULL,
  `ciudad` VARCHAR(60) NOT NULL,
  `lugar` VARCHAR(80) NOT NULL,
  `idUsuario` BIGINT(11) NOT NULL,
  PRIMARY KEY (`id`));