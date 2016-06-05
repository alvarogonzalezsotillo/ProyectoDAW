package app.controller;

import app.beans.UsuarioBean;
import app.builder.UsuarioBuilder;
import app.controller.interfaces.Controller;
import app.model.UsuarioDAO;
import app.utils.UtilFiles;
import app.utils.UtilSessionHibernate;
import app.utils.UtilViews;
import org.hibernate.Session;
import org.primefaces.model.UploadedFile;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "usuarioController")
@ViewScoped
public class UsuarioController implements Serializable, Controller {

    private static final long serialVersionUID = 1L;

    private UsuarioBuilder usuarioBuilder;

    private String nombre;
    private String apellido;
    private String nick;
    private String password;
    private String correo;
    private String web;
    private String grupo;
    private String tipoMusica;

    private String rutaImagen = UtilFiles.getDefaultUserRoute();

    private transient UploadedFile imagen;

    @ManagedProperty(value = "#{usuarioDao}")
    private UsuarioDAO usuarioDao;

    public void insertUsuario() throws IOException {

        if (nickAlreadyExists()) {

            String summary = "Has sido más lento";
            String detail = "Otro usuario ha registrado el nick " + nick + ", elige otro.";

            UtilViews.sendErrorMessage(summary, detail);

        } else {

            if (checkImagenIsNull()) {

                this.rutaImagen = UtilFiles.upload(imagen);
            }

            UsuarioBean usuario = createUsuarioBean();
            initSessionForDao();
            initTransactionForDao();
            usuarioDao.insert(usuario);
            commitAndCloseSession();

            String route = "/views/index/bienvenida.xhtml";
            String summary = "¡Bienvenid@ " + nombre + "!";
            String detail = "Tu usuario " + nick + " ha sido registrado, ¡ahora a Rockear!";

            UtilViews.redirectWithInfoMessage(route, summary, detail);

        }
    }

    private boolean checkImagenIsNull() {

        String fileName = imagen.getFileName();

        boolean isNull = !(fileName.equals(""));

        return isNull;
    }

    public void updateUsuario() {

        UsuarioBean usuario = createUsuarioBean();

        initSessionForDao();
        initTransactionForDao();
        usuarioDao.update(usuario);
        commitAndCloseSession();

    }

    public void initSessionForDao() {
        Session session = UtilSessionHibernate.initSession();
        usuarioDao.setSession(session);
    }


    public void commitAndCloseSession() {
        Session session = usuarioDao.getSession();
        UtilSessionHibernate.commitAndCloseSession(session);

    }


    public void initTransactionForDao() {
        Session session = usuarioDao.getSession();
        UtilSessionHibernate.initTransaction(session);

    }


    public void closeSession() {
        Session session = usuarioDao.getSession();
        UtilSessionHibernate.closeSession(session);
    }

    private UsuarioBean createUsuarioBean() {
        usuarioBuilder = new UsuarioBuilder(nombre, apellido, nick, password);
        return usuarioBuilder.correo(correo)
                .web(web)
                .grupo(grupo)
                .tipoMusica(tipoMusica)
                .rutaImagen(rutaImagen)
                .build();
    }

    private boolean nickAlreadyExists() {
        initSessionForDao();
        List<String> listNicks = usuarioDao.getAllNicks();
        closeSession();
        return listNicks.contains(nick);
    }

    public UsuarioBuilder getUsuarioBuilder() {

        return usuarioBuilder;
    }

    public void setUsuarioBuilder(UsuarioBuilder usuarioBuilder) {

        this.usuarioBuilder = usuarioBuilder;
    }

    public UsuarioDAO getUsuarioDao() {

        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDAO usuarioDao) {

        this.usuarioDao = usuarioDao;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getApellido() {

        return apellido;
    }

    public void setApellido(String apellido) {

        this.apellido = apellido;
    }

    public String getNick() {

        return nick;
    }

    public void setNick(String nick) {

        this.nick = nick;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getCorreo() {

        return correo;
    }

    public void setCorreo(String correo) {

        this.correo = correo;
    }

    public String getWeb() {

        return web;
    }

    public void setWeb(String web) {

        this.web = web;
    }

    public String getGrupo() {

        return grupo;
    }

    public void setGrupo(String grupo) {

        this.grupo = grupo;
    }

    public String getTipoMusica() {

        return tipoMusica;
    }

    public void setTipoMusica(String tipoMusica) {

        this.tipoMusica = tipoMusica;
    }

    public UploadedFile getImagen() {
        return imagen;
    }

    public void setImagen(UploadedFile imagen) {
        this.imagen = imagen;
    }
}
