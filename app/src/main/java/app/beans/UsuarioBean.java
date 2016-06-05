package app.beans;

import app.beans.interfaces.Bean;
import app.utils.UtilPasswords;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
public class UsuarioBean implements Serializable, Bean {

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

    @Column(name = "rutaImagenDeUsuario")
    private String rutaImagenDeUsuario;

    @Column(name = "correoDeUsuario")
    private String correoDeUsuario;
    @Column(name = "webDeUsuario")
    private String webDeUsuario;

    @Column(name = "grupoDeUsuario")
    private String grupoDeUsuario;
    @Column(name = "tipoMusicaDeUsuario")
    private String tipoMusicaDeUsuario;

    public UsuarioBean() {
        //Constructor por defecto
    }

    public UsuarioBean(String nombreDeUsuario, String apellidoDeUsuario, String nickDeUsuario, String correoDeUsuario, String tipoMusicaDeUsuario, String grupoDeUsuario, String webDeUsuario, String passwordDeUsuario, String rutaImagenDeUsuario) {

        this.nombreDeUsuario = nombreDeUsuario;
        this.apellidoDeUsuario = apellidoDeUsuario;
        this.nickDeUsuario = nickDeUsuario;
        this.correoDeUsuario = correoDeUsuario;
        this.tipoMusicaDeUsuario = tipoMusicaDeUsuario;
        this.grupoDeUsuario = grupoDeUsuario;
        this.webDeUsuario = webDeUsuario;
        String saltPassword = UtilPasswords.getSalt();
        this.passwordDeUsuario = UtilPasswords.hashPasswordSHA(passwordDeUsuario + saltPassword);
        this.rutaImagenDeUsuario = rutaImagenDeUsuario;
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
        String salt = UtilPasswords.getSalt();
        this.passwordDeUsuario = UtilPasswords.hashPasswordSHA(passwordDeUsuario + salt);
    }

    public String getPasswordDeUsuario() {
        return passwordDeUsuario;
    }

    public String getRutaImagenDeUsuario() {
        return rutaImagenDeUsuario;
    }

    public void setRutaImagenDeUsuario(String rutaImagenDeUsuario) {
        this.rutaImagenDeUsuario = rutaImagenDeUsuario;
    }
}
