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

    private UsuarioImp usuario;

    @ManagedProperty(value="#{UsuarioDao}")
    private UsuarioDAO usuarioDao;

    public void insert() {

        usuarioDao.insertUsuario(usuario);
        
        usuarioDao.session.close();

    }

    public UsuarioImp getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioImp usuario) {
        this.usuario = usuario;
    }

    public UsuarioDAO getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDAO usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

}
