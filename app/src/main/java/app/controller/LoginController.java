package app.controller;

import app.controller.interfaces.Controller;
import app.model.UsuarioDAO;
import app.utils.UtilPasswords;
import app.utils.UtilSessionHibernate;
import app.utils.UtilViews;
import org.hibernate.Session;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean(name = "loginController")
@ViewScoped
public class LoginController implements Serializable, Controller {

    private String nick;
    private String password;

    @ManagedProperty(value = "#{usuarioDao}")
    UsuarioDAO usuarioDao;

    public void login() {

        if (userIsRegistered()) {

            String route = "/views/timeline/timeline.xhtml";
            UtilViews.redirect(route);
        }

        else {
            String summary = "Oops!";
            String detail = "El nick o password introducidos no coinciden, ¿ya te registraste?";

            UtilViews.sendErrorMessage(summary,detail);
        }
    }

    private boolean userIsRegistered() {

        String salt = UtilPasswords.getSalt();
        String passwordHashed = UtilPasswords.hashPasswordSHA(password + salt);

        initSessionForDao();
        boolean isRegistered = usuarioDao.loginUsuario(nick, passwordHashed);
        closeSession();
        return isRegistered;
    }


    public void initSessionForDao(){
        Session session = UtilSessionHibernate.initSession();
        usuarioDao.setSession(session);
    }


    public void commitAndCloseSession(){
        Session session = usuarioDao.getSession();
        UtilSessionHibernate.commitAndCloseSession(session);

    }

    public void closeSession(){
        Session session = usuarioDao.getSession();
        UtilSessionHibernate.closeSession(session);
    }


    public void initTransactionForDao(){
        Session session = usuarioDao.getSession();
        UtilSessionHibernate.initTransaction(session);

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
