package app.beans.imp;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import app.beans.Usuario;

@ManagedBean(name = "usuario")
@SessionScoped
@SuppressWarnings("unused")
public class UsuarioImp implements Usuario, Serializable {

	private static final long serialVersionUID = 1L;

	private String nombreDeUsuario;
	private String apellidoDeUsuario;
	private String nickDeUsuario;
	private String correoDeUsuario;
	private boolean esUsuarioMusico;

	// Estos dos atributos nunca deben llevar get
	private String passwordDeUsuario;
	private String saltPassword;

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

	public void setPasswordDeUsuario(String passwordDeUsuario) {
		this.passwordDeUsuario = passwordDeUsuario;
	}

	public void setSaltPassword(String saltPassword) {
		this.saltPassword = saltPassword;
	}

	public boolean getEsUsuarioMusico() {
		return esUsuarioMusico;
	}

	public void setEsUsuarioMusico(boolean esUsuarioMusico) {
		this.esUsuarioMusico = esUsuarioMusico;
	}

}
