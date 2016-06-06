package app.beans;

import app.beans.interfaces.Bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comentarios")
public class ComentarioBean implements Serializable, Bean {

    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    private Long id;

    @Column(name = "texto")
    private String texto;

    @Column(name = "idUsuario")
    private Long idUsuario;

    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @Column(name = "idMelom")
    private Long idMelom;

    public ComentarioBean() {
        //Constructor por defecto
    }

    public ComentarioBean(String texto, Long idUsuario, String nombreUsuario, Long idMelom) {
        this.texto = texto;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.idMelom = idMelom;
    }


    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdMelom() {
        return idMelom;
    }

    public void setIdMelom(Long idMelom) {
        this.idMelom = idMelom;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
