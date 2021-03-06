package app.builder;

import app.beans.UsuarioBean;
import app.builder.interfaces.Builder;

import java.io.Serializable;

public class UsuarioBuilder implements Serializable, Builder<UsuarioBean> {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private String apellido;
    private String nick;
    private String password;
    private String correo;
    private String web;
    private String grupo;
    private String tipoMusica;
    private String rutaImagen;

    public UsuarioBuilder() {

        //Constructor por defecto para los test

    }

    public UsuarioBuilder(String nombre, String apellido, String nick, String password) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.nick = nick;
        this.password = password;

    }


    public UsuarioBean build() {

        return new UsuarioBean(nombre, apellido, nick, correo, tipoMusica, grupo, web, password, rutaImagen);

    }


    public UsuarioBuilder nombre(String nombre) {

        this.nombre = nombre;

        return this;

    }

    public UsuarioBuilder apellido(String apellido) {

        this.apellido = apellido;

        return this;
    }

    public UsuarioBuilder nick(String nick) {

        this.nick = nick;

        return this;

    }

    public UsuarioBuilder correo(String correo) {

        this.correo = correo;

        return this;

    }

    public UsuarioBuilder tipoMusica(String tipoMusica) {

        this.tipoMusica = tipoMusica;

        return this;
    }

    public UsuarioBuilder grupo(String grupo) {

        this.grupo = grupo;

        return this;

    }

    public UsuarioBuilder web(String web) {

        this.web = web;

        return this;

    }

    public UsuarioBuilder password(String password) {

        this.password = password;

        return this;

    }

    public UsuarioBuilder rutaImagen(String rutaImagen) {

        this.rutaImagen = rutaImagen;

        return this;

    }

}
