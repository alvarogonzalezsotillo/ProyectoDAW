package app.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import app.beans.imp.UsuarioImp;
import app.model.UsuarioDAO;

@ManagedBean(name="usuarioController")
@ViewScoped
public class UsuarioController {

	@ManagedProperty(value="usuario")
	private UsuarioImp usuario;
	
	private UsuarioDAO dao = new UsuarioDAO();
	
	public void insert(){
		
		dao.insertUsuario(usuario);
		
	}

	public UsuarioImp getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioImp usuario) {
		this.usuario = usuario;
	}
	
	
	
}
