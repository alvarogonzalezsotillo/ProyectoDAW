package app.builder;

import app.beans.imp.UsuarioImp;

import java.io.Serializable;

public class UsuarioBuilder implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private String apellido;
    private String nick;
    private String password;
    private String correo;
    private String web;
    private String grupo;
    private String tipoMusica;

    public UsuarioBuilder(){
        
        //Constructor por defecto para los test
        
    }
    
    public UsuarioBuilder(String nombre, String apellido, String nick, String password){
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.nick = nick;
        this. password = password;
        
    }

    public UsuarioImp build() {

        return new UsuarioImp(nombre,apellido,nick,correo,true,tipoMusica,grupo,web,password);

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

        this.password= password;

        return this;

    }

}
