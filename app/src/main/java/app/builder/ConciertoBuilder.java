package app.builder;

import app.beans.implementations.ConciertoBean;

import java.io.Serializable;

public class ConciertoBuilder implements Serializable{

    private static final long serialVersionUID = 1L;

    private String pais;
    private String ciudad;
    private String lugar;
    private Long idUsuario;

    public ConciertoBuilder() {
        //Constructor para test
    }

    public ConciertoBuilder(Long idUsuario, String lugar, String ciudad, String pais) {
        this.idUsuario = idUsuario;
        this.lugar = lugar;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public ConciertoBean build(){

        return new ConciertoBean(pais,ciudad,lugar,idUsuario);

    }
}
