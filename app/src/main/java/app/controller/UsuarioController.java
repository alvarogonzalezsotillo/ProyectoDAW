package app.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import app.beans.imp.UsuarioImp;
import app.builder.UsuarioBuilder;
import app.model.UsuarioDAO;

@ManagedBean(name = "usuarioController")
@ViewScoped
public class UsuarioController implements Serializable {

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

    @ManagedProperty(value = "#{UsuarioDao}")
    private UsuarioDAO usuarioDao;

    public void insert() {

        usuarioBuilder = new UsuarioBuilder(nombre,apellido,nick,password);

        UsuarioImp usuario = usuarioBuilder.correo(correo)
                                           .web(web)
                                           .grupo(grupo)
                                           .tipoMusica(tipoMusica)
                                           .build();

        usuarioDao.insertUsuario(usuario);

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

}
