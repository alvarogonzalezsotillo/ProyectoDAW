package app.beans.imp;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import app.beans.Usuario;

@ManagedBean(name = "usuario")
@SessionScoped
@SuppressWarnings("unused")
@Entity
@Table(name="usuarios")
public class UsuarioImp implements Usuario, Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="idUsuario")
	private Long id;
	@Column(name="nombre")
	private String nombreDeUsuario;
	@Column(name="apellido")
	private String apellidoDeUsuario;
	@Column(name="nick")
	private String nickDeUsuario;
	@Column(name="correo")
	private String correoDeUsuario;
	@Column(name="esMusico")
	private boolean esUsuarioMusico;
	@Column(name="web")
	private String webDeUsuario;
	@Column(name="grupo")
	private String grupoDeUsuario;

	// Password -> Hash | Salt -> Cadena aleatoria
	private String passwordDeUsuario;
	private String saltPassword;
	
	
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

	
	public String getWebDeUsuario() {
		return webDeUsuario;
	}

	public void setWebDeUsuario(String webUsuario) {
		this.webDeUsuario = webUsuario;
	}

	public String getGrupoDeUsuario() {
		return grupoDeUsuario;
	}

	public void setGrupoDeUsuario(String grupoDeUsuario) {
		this.grupoDeUsuario = grupoDeUsuario;
	}

	//TODO Hash de la contraseña
	public void setPasswordDeUsuario(String passwordDeUsuario) {
		this.passwordDeUsuario = passwordDeUsuario;
	}

	//TODO Generador aleatorio de una cadena
	public void setSaltPassword(String saltPassword) {
		this.saltPassword = saltPassword;
	}

}
