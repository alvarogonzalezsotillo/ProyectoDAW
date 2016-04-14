package app.beans.imp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import app.beans.Usuario;
import app.controller.Util;

@Entity
@Table(name = "usuarios")
public class UsuarioImp implements Usuario, Serializable {

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

    @Column(name = "imagenDeUsuario")
    @Lob
    private byte[] imagenDeUsuario;

    @Column(name = "correoDeUsuario")
    private String correoDeUsuario;
    @Column(name = "webDeUsuario")
    private String webDeUsuario;

    @Column(name = "esUsuarioMusico")
    private boolean esUsuarioMusico;
    @Column(name = "grupoDeUsuario")
    private String grupoDeUsuario;
    @Column(name = "tipoMusicaDeUsuario")
    private String tipoMusicaDeUsuario;
    
    public UsuarioImp(){
        //Constructor por defecto
    }
    
    public UsuarioImp(String nombreDeUsuario, String apellidoDeUsuario, String nickDeUsuario, String correoDeUsuario,
            boolean esUsuarioMusico, String tipoMusicaDeUsuario, String grupoDeUsuario, String webDeUsuario, String passwordDeUsuario) {

        this.nombreDeUsuario = nombreDeUsuario;
        this.apellidoDeUsuario = apellidoDeUsuario;
        this.nickDeUsuario = nickDeUsuario;
        this.correoDeUsuario = correoDeUsuario;
        this.esUsuarioMusico = esUsuarioMusico;
        this.tipoMusicaDeUsuario = tipoMusicaDeUsuario;
        this.grupoDeUsuario = grupoDeUsuario;
        this.webDeUsuario = webDeUsuario;
        String saltPassword = Util.getSalt();
        this.passwordDeUsuario = Util.hashPasswordSHA(passwordDeUsuario+saltPassword);
        
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

    public boolean getEsUsuarioMusico() {
        return esUsuarioMusico;
    }

    public void setEsUsuarioMusico(boolean esUsuarioMusico) {
        this.esUsuarioMusico = esUsuarioMusico;
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

    public byte[] getImagenDeUsuario() {
        return imagenDeUsuario;
    }

    public void setImagenDeUsuario(byte[] imagenDeUsuario) {
        this.imagenDeUsuario = imagenDeUsuario;
    }

    public void setPasswordDeUsuario(String passwordDeUsuario) {
        String salt = Util.getSalt();
        this.passwordDeUsuario = Util.hashPasswordSHA(passwordDeUsuario + salt);
    }

    public String getPasswordDeUsuario() {
        return passwordDeUsuario;
    }

}
