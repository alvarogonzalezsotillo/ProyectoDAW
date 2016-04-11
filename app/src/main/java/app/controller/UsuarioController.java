package app.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import app.beans.imp.UsuarioImp;
import app.model.UsuarioDAO;

@ManagedBean(name="usuarioController")
@ViewScoped
public class UsuarioController {

	private UsuarioImp usuario;
	
	private UsuarioDAO dao;
	
}
