# Proyecto
Repositorio para Proyecto de DAW realizado por Sara, Jorge y Guillermo

#IMPORTANTÍSIMO
**A la hora de subir los ficheros al repositorio hay que evitar subir ficheros ocultos(precedidos de un punto) en los commits, a continuación dejo una imagen con algunos de ellos. Solo subir los ficheros fuentes y de configuración del propio proyecto, en general, ficheros que hemos realizado nosotros mismos y no los autogenerados por Eclipse**

![Ejemplo de ficheros ignorados](http://s8.postimg.org/jugakenud/84dbe3bf_6b57_41e3_bdef_c5c81ddc9ce9.jpg)


# Requisitos necesarios
Eclipse versión JEE Mars 2:
http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/mars2

JBoss tools versión 4.3.0 disponible a través del *Eclipse Marketplace*

Tomcat 8 a descargar de aquí:
https://tomcat.apache.org/download-80.cgi

Añadir nuevo servidor a Eclipse con *Botón derecho -> New -> Server -> Apache -> Tomcat 8*
Seleccionas las ruta donde esté instalado Tomcat y finalizar

Una base de datos MySQL versión 5.7 a descargar https://dev.mysql.com/downloads/mysql/

**Cuidado y no descargar la versión test**

Aplicación de Git para Windows/MAC/Linux a descargar de aquí: https://git-scm.com/downloads

#¿Cómo iniciar el proyecto?
Nos vamos a la carpeta donde tengamos el **workspace** y creamos otra carpeta llamada git(por ejemplo, si tenemos el workspace en *C:/workspace*, la carpeta creada será *C:/git*). Vamos a esta nueva carpeta, creamos una nueva carpeta dentro que se va a llamar proyecto y mediante la línea de comandos de git(*git-bash ubicado en la ruta de instalación de Git*) clonamos con *git clone* el repositorio de la siguiente forma.

```shell
cd /git/proyecto (ruta elegida antes)
git clone https://github.com/Gmuela/ProyectoDAW.git
```
Una vez hecho lo anterior ya tendremos el projecto con todos los fuentes en la carpeta *C:/git/proyecto*

Ahora en Eclipse hacemos un proyecto desde *Import -> Maven -> Existing Maven Project* y seleccionamos la carpeta **app** dentro de proyecto, es decir, los fuentes que hemos clonado del repositorio.

Una vez hecho, nos creará el proyecto.

#Funcionalidades externas al proyecto para usar
##Obligatorias: 
**Taiga** para hacer uso de una metodología ágil (SCRUM)

##Opcionales: 
**Trello** para registrar ideas que surjan para próximos Sprints

**Whatsapp Web** para poder enviar capturas de pantalla a través de un chat

**Skype** o **TS** para mantener contacto y resolver dudas en grupo
