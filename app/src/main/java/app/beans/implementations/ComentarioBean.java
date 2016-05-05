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
    @Column(name = "idMelom")
    private Long idMelom;

    public ComentarioBean() {
        //Constructor por defecto
    }

    public ComentarioBean(String texto, Long idUsuario, Long idMelom) {
        this.texto = texto;
        this.idUsuario = idUsuario;
        this.idMelom = idMelom;
    }

    @Id
    @SequenceGenerator(name="com_seq", sequenceName="comentario_sequence")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="com_seq")
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
}
