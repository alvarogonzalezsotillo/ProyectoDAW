package app.beans.implementations;

import app.beans.interfaces.Comentario;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BETAcomentarios")//NO OLVIDAR CAMBIAR CUANDO TERMINEMOS LA TABLA DE COMENTARIOS!!!!!!!!!!!!!!!!!!!
public class ComentarioBean implements Comentario, Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    private Long id;

    @Column(name = "texto")
    private String texto;

    @Column(name = "idUsuario")
    private Long idUsuario;
    @Column(name = "idTweet")
    private Long idTweet;

    public ComentarioBean() {
        //Constructor por defecto
    }

    public ComentarioBean(String texto, Long idUsuario, Long idTweet) {
        this.texto = texto;
        this.idUsuario = idUsuario;
        this.idTweet = idTweet;
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

    public Long getIdTweet() {
        return idTweet;
    }

    public void setIdTweet(Long idTweet) {
        this.idTweet = idTweet;
    }
}
