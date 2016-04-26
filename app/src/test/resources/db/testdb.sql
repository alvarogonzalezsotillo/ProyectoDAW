DROP TABLE usuarios IF EXISTS;

CREATE TABLE usuarios (
id BIGINT(11) NOT NULL,
nombreDeUsuario VARCHAR(45) NOT NULL,
apellidoDeUsuario VARCHAR(45) NOT NULL,
nickDeUsuario VARCHAR(65) NOT NULL,
passwordDeUsuario VARCHAR(254) NOT NULL,
correoDeUsuario VARCHAR(85) NULL,
imagenDeUsuario LONGBLOB NULL,
esUsuarioMusico TINYINT(1) NOT NULL DEFAULT 1,
grupoDeUsuario VARCHAR(35) NULL,
webDeUsuario VARCHAR(100) NULL,
tipoMusicaDeUsuario VARCHAR(20) NULL,
esAdmin TINYINT(1) NOT NULL DEFAULT 0,
fechaRegistro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (id));

INSERT INTO usuarios(id,nombreDeUsuario,apellidoDeUsuario,nickDeUsuario,passwordDeUsuario) VALUES (1,'nombreTest','apellidoTest','nickTest','passwordTest');

INSERT INTO usuarios(id,nombreDeUsuario,apellidoDeUsuario,nickDeUsuario,passwordDeUsuario) VALUES (2,'nombreTest2','apellidoTest2','nickTest2','passwordTest2');