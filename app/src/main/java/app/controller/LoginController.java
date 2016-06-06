package app.controller;

import app.controller.interfaces.Controller;
import app.model.UsuarioDAO;
import app.utils.UtilPasswords;
import app.utils.UtilSessionHibernate;
import app.utils.UtilUserSession;
import app.utils.UtilViews;
import org.hibernate.Session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable, Controller {

    private String nick;
    private String password;

    private Long userId;


    @ManagedProperty(value = "#{usuarioDao}")
    UsuarioDAO usuarioDao;

    public void login() {

        if (userIsRegistered()) {
            HttpSession userSession = UtilUserSession.getSession();
            recoverUserId(nick);
            userSession.setAttribute("userId", userId);
            userSession.setAttribute("userName", nick);
            String route = "/views/timeline/timeline.xhtml";
            UtilViews.redirect(route);
        }

        else {
            String summary = "Oops!";
            String detail = "El nick o password introducidos no coinciden, ¿ya te registraste?";

            UtilViews.sendErrorMessage(summary,detail);
        }
    }

    private void recoverUserId(String userNick) {
        initSessionForDao();
        this.userId = usuarioDao.getUserId(userNick);
        closeSession();
    }

    public void logout(){

        UtilUserSession.getSession().invalidate();
        String route = "/views/index/bienvenida.xhtml";
        UtilViews.redirect(route);

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UsuarioDAO getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDAO usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
}
