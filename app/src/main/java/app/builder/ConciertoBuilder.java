package app.builder;

import app.beans.ConciertoBean;
import app.builder.interfaces.Builder;

import java.io.Serializable;

public class ConciertoBuilder implements Serializable, Builder<ConciertoBean> {

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

    public ConciertoBuilder pais(String pais) {
        this.pais = pais;
        return this;
    }

    public ConciertoBuilder ciudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public ConciertoBuilder lugar(String lugar) {
        this.lugar = lugar;
        return this;
    }

    public ConciertoBuilder idUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }
}
