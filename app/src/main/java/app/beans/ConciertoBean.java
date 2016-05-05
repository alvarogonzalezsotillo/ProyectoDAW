package app.beans;

import app.beans.interfaces.Bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BETAconciertos")//NO OLVIDAR CAMBIAR CUANDO TERMINEMOS LA TABLA DE COMENTARIOS!!!!!!!!!!!!!!!!!!!
public class ConciertoBean implements Serializable, Bean {

    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    private Long id;

    @Column(name = "pais")
    private String pais;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "lugar")
    private String lugar;

    @Column(name = "idUsuario")
    private Long idUsuario;

    public ConciertoBean(String pais, String ciudad, String lugar, Long idUsuario) {
        this.pais = pais;
        this.ciudad = ciudad;
        this.lugar = lugar;
        this.idUsuario = idUsuario;
    }

    public ConciertoBean() {
        //Constructor por defecto
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
