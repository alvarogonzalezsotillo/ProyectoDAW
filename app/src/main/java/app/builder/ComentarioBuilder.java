package app.builder;

import app.beans.implementations.ComentarioBean;

import java.io.Serializable;

public class ComentarioBuilder implements Serializable {

    private static final long serialVersionUID = 1L;

    private String texto;
    private Long idUsuario;
    private Long idTweet;

    public ComentarioBuilder() {

        //Constructor para test
    }

    public ComentarioBuilder(String texto, Long idUsuario, Long idTweet) {
        this.texto = texto;
        this.idUsuario = idUsuario;
        this.idTweet = idTweet;
    }

    public ComentarioBean build(){

        return new ComentarioBean(texto,idUsuario,idTweet);

    }

    public ComentarioBuilder texto(String texto) {
        this.texto = texto;
        return this;
    }

    public ComentarioBuilder idUsuario(Long idUsuario){

        this.idUsuario = idUsuario;
        return this;
    }

    public ComentarioBuilder idTweet(Long idTweet){

        this.idTweet = idTweet;
        return this;
    }

}