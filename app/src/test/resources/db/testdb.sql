DROP TABLE usuarios
IF EXISTS;
DROP TABLE BETAcomentarios
IF EXISTS;
DROP TABLE meloms
IF EXISTS;
DROP TABLE BETAconciertos
IF EXISTS;

CREATE TABLE usuarios (
  id                  BIGINT (11) NOT NULL,
  nombreDeUsuario     VARCHAR(45)  NOT NULL,
  apellidoDeUsuario   VARCHAR(45)  NOT NULL,
  nickDeUsuario       VARCHAR(65)  NOT NULL,
  passwordDeUsuario   VARCHAR(254) NOT NULL,
  correoDeUsuario     VARCHAR(85)  NULL,
  imagenDeUsuario LONGBLOB NULL,
  grupoDeUsuario      VARCHAR(35)  NULL,
  webDeUsuario        VARCHAR(100) NULL,
  tipoMusicaDeUsuario VARCHAR(20)  NULL,
  esAdmin             TINYINT (1) NOT NULL DEFAULT 0,
  fechaRegistro       DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

CREATE TABLE meloms (
  id               BIGINT (11) NOT NULL,
  autor            VARCHAR(60)  NOT NULL,
  titulo           VARCHAR(150) NOT NULL,
  album            VARCHAR(20)  NULL,
  tipoMusica       VARCHAR(45)  NULL,
  comentarioMusico VARCHAR(100) NULL,
  rutaCancion      VARCHAR(200) NULL     DEFAULT NULL,
  rutaImagenAlbum  VARCHAR(200) NULL     DEFAULT NULL,
  idUsuario        BIGINT (11) NOT NULL,
  fechaPublicacion DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  CONSTRAINT idUsuario
  FOREIGN KEY (idUsuario)
  REFERENCES usuarios (id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
);

CREATE TABLE BETAcomentarios (
  id            BIGINT (11) NOT NULL,
  texto         VARCHAR(45) NOT NULL,
  nombreUsuario VARCHAR(45) NOT NULL,
  idUsuario     BIGINT (11) NOT NULL,
  idMelom       BIGINT (11) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT idMelom
  FOREIGN KEY (idMelom)
  REFERENCES meloms (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE BETAconciertos (
  id        BIGINT (11) NOT NULL,
  fecha     DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  pais      VARCHAR(50) NOT NULL,
  ciudad    VARCHAR(60) NOT NULL,
  lugar     VARCHAR(80) NOT NULL,
  idUsuario BIGINT (11) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE followers (
  idUsuario  BIGINT (11) NOT NULL,
  idFollower BIGINT (11) NOT NULL,
  PRIMARY KEY (idUsuario, idFollower)
);

INSERT
INTO usuarios (id, nombreDeUsuario, apellidoDeUsuario, nickDeUsuario, passwordDeUsuario)
VALUES (1, 'nombreTest', 'apellidoTest', 'nickTest', 'passwordTest');

INSERT
INTO usuarios (id, nombreDeUsuario, apellidoDeUsuario, nickDeUsuario, passwordDeUsuario)
VALUES (2, 'nombreTest2', 'apellidoTest2', 'nickTest2', 'passwordTest2');

INSERT
INTO meloms (id, autor, titulo, album, tipoMusica, comentarioMusico, rutaCancion, rutaImagenAlbum, idUsuario)
VALUES (1, 'autorTest', 'tituloTest', NULL, NULL, NULL, NULL, NULL, 1);

INSERT
INTO meloms (id, autor, titulo, album, tipoMusica, comentarioMusico, rutaCancion, rutaImagenAlbum, idUsuario)
VALUES (2, 'autorTest', 'tituloTest2', NULL, NULL, NULL, NULL, NULL, 1);

INSERT
INTO BETAcomentarios (id, texto, idUsuario, nombreUsuario, idMelom)
VALUES (1, 'textoTest', 1, 'usuarioTest', 1);

INSERT
INTO BETAcomentarios (id, texto, idUsuario, nombreUsuario, idMelom)
VALUES (2, 'textoTest2', 1, 'usuarioTest', 1);

INSERT
INTO BETAconciertos (id, pais, ciudad, lugar, idUsuario)
VALUES (1, 'paisTest', 'ciudadTest', 'lugarTest', 1);

INSERT
INTO BETAconciertos (id, pais, ciudad, lugar, idUsuario)
VALUES (2, 'paisTest2', 'ciudadTest2', 'lugarTest2', 2);

INSERT
INTO followers (idUsuario, idFollower)
VALUES (1, 2);