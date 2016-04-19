package app.controller;

import app.model.UsuarioDAO;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean(name = "loginController")
@ViewScoped
public class LoginController implements Serializable {

    private String nick;
    private String password;

    @ManagedProperty(value = "#{usuarioDao}")
    UsuarioDAO usuarioDao;

    public void login() {

        String salt = Util.getSalt();

        String passwordHashed = Util.hashPasswordSHA(password + salt);

        boolean checkLogin = usuarioDao.loginUsuario(nick, passwordHashed);

        if (checkLogin) {

            try {

                FacesContext.getCurrentInstance().getExternalContext().redirect("/views/index/bienvenida.xhtml");
            }

            catch (IOException e) {

                e.printStackTrace();
            }

        } else {

            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Oops!", "El nick o password introducidos no coinciden,¿ya te registraste?");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);

        }


    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsuarioDAO getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDAO usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
}
