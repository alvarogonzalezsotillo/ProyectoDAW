package app.builder;

import app.beans.ComentarioBean;
import app.builder.interfaces.Builder;

import java.io.Serializable;

public class ComentarioBuilder implements Serializable, Builder<ComentarioBean> {

    private static final long serialVersionUID = 1L;

    private String texto;
    private Long idUsuario;
    private String nombreUsuario;
    private Long idMelom;

    public ComentarioBuilder() {

        //Constructor para test
    }

    public ComentarioBuilder(String texto, Long idUsuario, String nombreUsuario, Long idMelom) {
        this.texto = texto;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.idMelom = idMelom;
    }


    public ComentarioBean build() {

        return new ComentarioBean(texto, idUsuario, nombreUsuario, idMelom);

    }

    public ComentarioBuilder texto(String texto) {
        this.texto = texto;
        return this;
    }

    public ComentarioBuilder idUsuario(Long idUsuario) {

        this.idUsuario = idUsuario;
        return this;
    }

    public ComentarioBuilder nombreUsuario(String nombreUsuario) {

        this.nombreUsuario = nombreUsuario;
        return this;
    }

    public ComentarioBuilder idMelom(Long idMelom) {

        this.idMelom = idMelom;
        return this;
    }

}