# Proyecto
Repositorio para Proyecto de DAW realizado por Sara, Jorge y Guillermo

#IMPORTANTÍSIMO
**A la hora de subir los ficheros al repositorio hay que evitar subir ficheros ocultos(precedidos de un punto) en los commits, a continuación dejo una imagen con algunos de ellos. Solo subir los ficheros fuentes y de configuración del propio proyecto, en general, ficheros que hemos realizado nosotros mismos y no los autogenerados por Eclipse**

![Ejemplo de ficheros ignorados](http://s8.postimg.org/jugakenud/84dbe3bf_6b57_41e3_bdef_c5c81ddc9ce9.jpg)

#¿Cómo funcionar con git y no morir en el intento?

Cada uno trabaja con su propia rama haciendo sus commits y push. Cuando se hayan terminado los cambios y todo funcione tendremos que cambiar a la rama **master** y hacer el **merge** con nuestra rama.

Una vez hecho el merge, se realiza un autocommit, por que solo solo haremos **push** de master para subir los cambios

Una vez subidos, avisamos al resto de que se han hecho cambios en master, y el resto tiene que hacer lo siguiente:

En la rama master hacemos un **pull** de los cambios, cambiamos a nuestra rama y hacemos un **merge** con la rama master y seguimos haciendo nuestro commits y push de nuestra rama.

# Requisitos necesarios
Eclipse versión JEE Mars 2:
http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/mars2

JBoss tools versión 4.3.0 disponible a través del *Eclipse Marketplace*

Tomcat 8 a descargar de aquí:
https://tomcat.apache.org/download-80.cgi

Añadir nuevo servidor a Eclipse con *Botón derecho -> New -> Server -> Apache -> Tomcat 8*
Seleccionas las ruta donde esté instalado Tomcat y finalizar

Una base de datos MySQL versión 5.7 a descargar https://dev.mysql.com/downloads/mysql/

Gestor de Base de datos MYSQL Workbench a descargar https://dev.mysql.com/downloads/workbench/

**Cuidado y no descargar la versión test**

Aplicación de Git para Windows/MAC/Linux a descargar de aquí: https://git-scm.com/downloads

#¿Cómo iniciar el proyecto?
Nos vamos a la carpeta donde tengamos el **workspace** y creamos otra carpeta llamada git(por ejemplo, si tenemos el workspace en *C:/workspace*, la carpeta creada será *C:/git*). Vamos a esta nueva carpeta, creamos una nueva carpeta dentro que se va a llamar proyecto y mediante la línea de comandos de git(*git-bash ubicado en la ruta de instalación de Git*) clonamos con *git clone* el repositorio de la siguiente forma.

```shell
cd /git/proyecto (ruta elegida antes)
git clone https://github.com/Gmuela/ProyectoDAW.git
```

En el caso de querer bajar solo las ramas de master y la rama personal, realizaríamos lo siguiente.

```
cd /git/proyecto (ruta elegida antes)
git clone -b master https://github.com/Gmuela/ProyectoDAW.git
git checkout nombreRamaPersonal
```
Donde nombreRamaPersonal en nuestro caso sería sara,jordc o Guillermo. Cuidado con poner el nombre de la rama igual, mayúsculas y minúsculas incluidas.

Una vez hecho lo anterior ya tendremos el projecto con todos los fuentes en la carpeta *C:/git/proyecto*

Ahora en Eclipse hacemos un proyecto desde *Import -> Maven -> Existing Maven Project* y seleccionamos la carpeta **app** dentro de proyecto, es decir, los fuentes que hemos clonado del repositorio.

Una vez hecho, nos creará el proyecto.

#¿Cómo probar de momento la inserción de comentarios?
Ya que aún no disponemos de una lógica completa, hay que hacer algún apaño para probar ciertas cosas. Entendamos un poco la lógica: Necesitamos un usuario que haya hecho un tweet para poder comentarlo. Es decir, debe existir un Usuario con un id(por ejemplo 1), para que pueda haber un tweet(cuyo id sea por ejemplo 2 y su idUsuario sea 1, es ecir, el usuario existente) para que alguien pueda comentar(el id comentario será 3, su idTweet será 2 y su idusuario será 1). Por lo tanto, esta jerarquía debe seguirse al pie de la letra o nos dará problemas a la hora de insertar.

Para ello he creado unos SQL que nos permita probar de momento la inserción del comentario. una vez tengamos la base de datos limpia, con todas las tablas vacías, ejecutamos el SQL llamado **insertFirstValueHibernateSequence** que nos permitirá crear un usuario nuevo, mediante el formulario de registro que ya funciona, con el *id = 1*.

Una vez hecho esto, creamos el usuario y a continuación ejecutamos el SQL **inserTweet**, que nos servirá de simulación como si el usuario(id=1) hubiera hecho un tweet.

Por lo tanto, solo queda probar el formulario de creación de comentario, asegurándose de que los valores idUsuario e idTweet en el ComentarioController son iguales a *1L*

#Funcionalidades externas al proyecto para usar
##Obligatorias: 
**Taiga** para hacer uso de una metodología ágil (SCRUM)

##Opcionales: 
**Trello** para registrar ideas que surjan para próximos Sprints

**Whatsapp Web** para poder enviar capturas de pantalla a través de un chat

**Skype** , **TS** o **Discord** para mantener contacto y resolver dudas en grupo

***

#Para Guillermo

Esto no hace falta que lo miréis, son algunas cosas que voy a usar que ya os explicaré cuando lo haya aprendido, aunque os dejo links por si queréis informaros.

##SonarQube 
Evaluaciones del código

http://www.sonarqube.org/

https://es.wikipedia.org/wiki/SonarQube

##JUnit
Test unitarios y de integración

https://es.wikipedia.org/wiki/JUnit

##Mockito
Los objetos Mock permiten de una forma sencilla testear clases como Servlets o EJBs para simular su entorno. El cometido de un objeto Mock es servir de ayuda a los test

http://mockito.org/

https://en.wikipedia.org/wiki/Mockito

