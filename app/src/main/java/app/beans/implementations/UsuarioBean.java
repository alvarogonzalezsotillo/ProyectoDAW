package app.beans.implementations;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import app.beans.interfaces.Usuario;
import app.utils.Util;

@Entity
@Table(name = "usuarios")
public class UsuarioBean implements Usuario, Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    private Long id;

    @Column(name = "nombreDeUsuario")
    private String nombreDeUsuario;
    @Column(name = "apellidoDeUsuario")
    private String apellidoDeUsuario;
    @Column(name = "nickDeUsuario")
    private String nickDeUsuario;
    @Column(name = "passwordDeUsuario")
    private String passwordDeUsuario;

    @Column(name = "imagenDeUsuario", columnDefinition = "LONGBLOB")
    private byte[] imagenDeUsuario;

    @Column(name = "correoDeUsuario")
    private String correoDeUsuario;
    @Column(name = "webDeUsuario")
    private String webDeUsuario;

    @Column(name = "grupoDeUsuario")
    private String grupoDeUsuario;
    @Column(name = "tipoMusicaDeUsuario")
    private String tipoMusicaDeUsuario;
    
    public UsuarioBean(){
        //Constructor por defecto
    }
    
    public UsuarioBean(String nombreDeUsuario, String apellidoDeUsuario, String nickDeUsuario, String correoDeUsuario, String tipoMusicaDeUsuario, String grupoDeUsuario, String webDeUsuario, String passwordDeUsuario, byte[] imagenDeUsuario) {

        this.nombreDeUsuario = nombreDeUsuario;
        this.apellidoDeUsuario = apellidoDeUsuario;
        this.nickDeUsuario = nickDeUsuario;
        this.correoDeUsuario = correoDeUsuario;
        this.tipoMusicaDeUsuario = tipoMusicaDeUsuario;
        this.grupoDeUsuario = grupoDeUsuario;
        this.webDeUsuario = webDeUsuario;
        String saltPassword = Util.getSalt();
        this.passwordDeUsuario = Util.hashPasswordSHA(passwordDeUsuario+saltPassword);
        this.imagenDeUsuario = imagenDeUsuario ;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getApellidoDeUsuario() {
        return apellidoDeUsuario;
    }

    public void setApellidoDeUsuario(String apellidoDeUsuario) {
        this.apellidoDeUsuario = apellidoDeUsuario;
    }

    public String getNickDeUsuario() {
        return nickDeUsuario;
    }

    public void setNickDeUsuario(String nickDeUsuario) {
        this.nickDeUsuario = nickDeUsuario;
    }

    public String getCorreoDeUsuario() {
        return correoDeUsuario;
    }

    public void setCorreoDeUsuario(String correoDeUsuario) {
        this.correoDeUsuario = correoDeUsuario;
    }

    public String getGrupoDeUsuario() {
        return grupoDeUsuario;
    }

    public void setGrupoDeUsuario(String grupoDeUsuario) {
        this.grupoDeUsuario = grupoDeUsuario;
    }

    public String getTipoMusicaDeUsuario() {
        return tipoMusicaDeUsuario;
    }

    public void setTipoMusicaDeUsuario(String tipoMusicaDeUsuario) {
        this.tipoMusicaDeUsuario = tipoMusicaDeUsuario;
    }

    public String getWebDeUsuario() {
        return webDeUsuario;
    }

    public void setWebDeUsuario(String webUsuario) {
        this.webDeUsuario = webUsuario;
    }

    public void setPasswordDeUsuario(String passwordDeUsuario) {
        String salt = Util.getSalt();
        this.passwordDeUsuario = Util.hashPasswordSHA(passwordDeUsuario + salt);
    }

    public String getPasswordDeUsuario() {
        return passwordDeUsuario;
    }

    public byte[] getImagenDeUsuario() {
        return imagenDeUsuario;
    }

    public void setImagenDeUsuario(byte[] imagenDeUsuario) {
        this.imagenDeUsuario = imagenDeUsuario;
    }
}
