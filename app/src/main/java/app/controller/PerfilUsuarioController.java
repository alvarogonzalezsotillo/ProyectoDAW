package app.controller;

import app.beans.UsuarioBean;
import app.controller.interfaces.Controller;
import app.model.UsuarioDAO;
import app.utils.UtilFiles;
import app.utils.UtilSessionHibernate;
import app.utils.UtilUserSession;
import org.hibernate.Session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "perfilUsuarioController")
@ViewScoped
public class PerfilUsuarioController implements Controller, Serializable {

    @ManagedProperty(value = "#{usuarioDao}")
    private UsuarioDAO usuarioDao;

    private String nombre;
    private String apellido;
    private String nick;
    private String correo;
    private String grupo;
    private String web;
    private String tipoMusica;
    private String fechaRegistro;
    private String imagen;

    public void init() {

        initSessionForDao();
        UsuarioBean usuarioActual = usuarioDao.getById(UtilUserSession.getUserId());
        closeSession();

        this.nombre = usuarioActual.getNombreDeUsuario();
        this.apellido = usuarioActual.getApellidoDeUsuario();
        this.nick = usuarioActual.getNickDeUsuario();
        this.correo = usuarioActual.getCorreoDeUsuario();
        this.grupo = usuarioActual.getGrupoDeUsuario();
        this.web = usuarioActual.getWebDeUsuario();
        this.tipoMusica = usuarioActual.getTipoMusicaDeUsuario();
        this.imagen = UtilFiles.transformFileToBase64(usuarioActual.getImagenDeUsuario());

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UsuarioDAO getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDAO usuarioDao) {
        this.usuarioDao = usuarioDao;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTipoMusica() {
        return tipoMusica;
    }

    public void setTipoMusica(String tipoMusica) {
        this.tipoMusica = tipoMusica;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getImagen() {

        return imagen;

    }
}
