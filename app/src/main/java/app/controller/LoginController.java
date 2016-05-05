package app.controller;

import app.controller.interfaces.Controller;
import app.utils.Util;
import app.model.UsuarioDAO;
import app.utils.UtilSessionHibernate;
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

        String salt = Util.getSalt();

        String passwordHashed = Util.hashPasswordSHA(password + salt);

        initSessionForDao();
        boolean checkLogin = usuarioDao.loginUsuario(nick, passwordHashed);
        closeSession();

        if (checkLogin) {

            try {

                FacesContext.getCurrentInstance().getExternalContext().redirect("/views/timeline/timeline.xhtml");
            }

            catch (IOException e) {

                throw new RuntimeException("Fallo en LoginController: no se pudo redirigir" + e);
            }

        }

        else {

            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Oops!", "El nick o password introducidos no coinciden,¿ya te registraste?");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);

        }


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
