DROP TABLE usuarios
IF EXISTS;
DROP TABLE BETAcomentarios
IF EXISTS;
DROP TABLE BETAtweets
IF EXISTS;

CREATE TABLE usuarios (
  id                  BIGINT (11) NOT NULL,
  nombreDeUsuario     VARCHAR(45)  NOT NULL,
  apellidoDeUsuario   VARCHAR(45)  NOT NULL,
  nickDeUsuario       VARCHAR(65)  NOT NULL,
  passwordDeUsuario   VARCHAR(254) NOT NULL,
  correoDeUsuario     VARCHAR(85)  NULL,
  imagenDeUsuario LONGBLOB NULL,
  esUsuarioMusico     TINYINT (1) NOT NULL DEFAULT 1,
  grupoDeUsuario      VARCHAR(35)  NULL,
  webDeUsuario        VARCHAR(100) NULL,
  tipoMusicaDeUsuario VARCHAR(20)  NULL,
  esAdmin             TINYINT (1) NOT NULL DEFAULT 0,
  fechaRegistro       DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

CREATE TABLE BETAtweets (
  id               BIGINT (11) NOT NULL,
  titulo           VARCHAR(150) NOT NULL,
  album            VARCHAR(20)  NULL,
  tipoMusica       VARCHAR(45)  NULL,
  comentarioMusico VARCHAR(60)  NULL,
  cancion          BLOB         NULL DEFAULT NULL,
  imagenAlbum      BLOB         NULL DEFAULT NULL,
  idUsuario        BIGINT (11) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT idUsuario
  FOREIGN KEY (idUsuario)
  REFERENCES usuarios (id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
);

CREATE TABLE BETAcomentarios (
  id        BIGINT (11) NOT NULL,
  texto     VARCHAR(45) NOT NULL,
  idUsuario BIGINT (11) NOT NULL,
  idTweet   BIGINT (11) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT idTweet
  FOREIGN KEY (idTweet)
  REFERENCES BETAtweets (id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
);

INSERT
INTO usuarios (id, nombreDeUsuario, apellidoDeUsuario, nickDeUsuario, passwordDeUsuario)
VALUES (1, 'nombreTest', 'apellidoTest', 'nickTest', 'passwordTest');

INSERT
INTO usuarios (id, nombreDeUsuario, apellidoDeUsuario, nickDeUsuario, passwordDeUsuario)
VALUES (2, 'nombreTest2', 'apellidoTest2', 'nickTest2', 'passwordTest2');

INSERT
INTO BETAtweets (id, titulo, album, tipoMusica, comentarioMusico, cancion, imagenAlbum, idUsuario)
VALUES (1, 'tituloTest', NULL, NULL, NULL, NULL, NULL, 1);

INSERT
INTO BETAtweets (id, titulo, album, tipoMusica, comentarioMusico, cancion, imagenAlbum, idUsuario)
VALUES (2, 'tituloTest2', NULL, NULL, NULL, NULL, NULL, 2);


INSERT
INTO BETAcomentarios (id, texto, idUsuario, idTweet)
VALUES (1, 'textoTest', 1, 1);

INSERT
INTO BETAcomentarios (id, texto, idUsuario, idTweet)
VALUES (2, 'textoTest', 1, 1);