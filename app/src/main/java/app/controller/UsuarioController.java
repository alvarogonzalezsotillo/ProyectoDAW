package app.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import app.beans.imp.UsuarioImp;
import app.model.UsuarioDAO;

@ManagedBean(name = "usuarioController")
@ViewScoped
public class UsuarioController implements Serializable{

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value="#{usuario}")
    private UsuarioImp usuario;

    private UsuarioDAO dao = new UsuarioDAO();

    public void insert() {

        dao.insertUsuario(usuario);

    }

    public UsuarioImp getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioImp usuario) {
        this.usuario = usuario;
    }

    public UsuarioDAO getDao() {
        return dao;
    }

    public void setDao(UsuarioDAO dao) {
        this.dao = dao;
    }

}
