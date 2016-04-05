# Proyecto
Repositorio para Proyecto de DAW realizado por Sara, Jorge y Guillermo

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

#¿Cómo iniciar el proyecto?
*Click derecho -> Import -> Git -> Projects from git -> Clone URI*

Copiamos y pegamos la dirección de este repositorio: https://github.com/Gmuela/Proyecto.git 

Seguimos los siguientes pasos indicando donde queremos clonar el repositorio

Una vez hecho, nos pedirá que hagamos un projecto de Eclipse, seleccionas *Import using the New Project Wizard* y lo creamos como un projecto de maven y asegurarse de que checkeamos la opción de **Create a simple project**

En la parte de **ARTIFACT**

En *Group id* ponemos iesrey.daw

En *Artifact id* ponemos app

En *Version* 0.1

En *Packaging* WAR

Parent project lo dejamos vacío y finalizamos. Debería funcionar, repito, **debería**

#¿Cómo iniciar el proyecto si falla lo anterior?

Nos vamos a la carpeta donde tengamos el **workspace** y creamos otra carpeta llamada git(por ejemplo, si tenemos el workspace en *C:/workspace*, la carpeta creada será *C:/git*). Vamos a esta nueva carpeta, creamos una nueva carpeta dentro que se va a llamar proyecto y mediante la línea de comandos de git(*git-bash*) clonamos con *git clone* el repositorio.

Una vez hecho lo anterior ya tendremos el projecto con todos los fuentes en la carpeta *C:/git/proyecto*

Ahora en Eclipse hacemos un proyecto desde *Import -> Maven -> Existing Maven Project* y seleccionamos la carpeta **app** dentro de proyecto, es decir, los fuentes que hemos clonado del repositorio.

Los siguientes pasos son iguales que en el anterior punto.

#Funcionalidades externas al proyecto para usar
##Obligatorias: 
**Taiga** para hacer uso de una metodología ágil (SCRUM)

##Opcionales: 
**Trello** para registrar ideas que surjan para próximos Sprints

**Whatsapp Web** para poder enviar capturas de pantalla a través de un chat

**Skype** o **TS** para mantener contacto y resolver dudas en grupo
