package app.beans;

import app.beans.interfaces.Bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "followers")
public class FollowerBean implements Serializable, Bean {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "idUsuario")
    private Long idUsuario;

    @Column(name = "idFollower")
    private Long idFollower;

    public FollowerBean(Long idUsuario, Long idFollower) {
        this.idUsuario = idUsuario;
        this.idFollower = idFollower;
    }

    public FollowerBean() {
        //Constructor por defecto
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuarioToFollow) {
        this.idUsuario = idUsuarioToFollow;
    }

    public Long getIdFollower() {
        return idFollower;
    }

    public void setIdFollower(Long idFollower) {
        this.idFollower = idFollower;
    }

    public Long getId(){

        return null;
    }
    public void setId(Long id){

        //Do nothing

    }
}
