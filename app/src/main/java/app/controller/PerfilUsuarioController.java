package app.controller;

import app.beans.MelomBean;
import app.beans.UsuarioBean;
import app.controller.interfaces.Controller;
import app.model.UsuarioDAO;
import app.utils.UtilPasswords;
import app.utils.UtilSessionHibernate;
import app.utils.UtilUserSession;
import app.utils.UtilViews;
import org.hibernate.Session;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "perfilUsuarioController")
@ApplicationScoped
public class PerfilUsuarioController implements Controller, Serializable {

    @ManagedProperty(value = "#{usuarioDao}")
    private UsuarioDAO usuarioDao;

    private Long idPersonal;

    private String nombrePersonal;
    private String apellidoPersonal;
    private String nickPersonal;
    private String correoPersonal;
    private String grupoPersonal;
    private String webPersonal;
    private String tipoMusicaPersonal;
    private String imagenPersonal;

    private String oldPass;
    private String newPass;
    private String newPassOk;

    private Long idAjeno;

    private String nombreAjeno;
    private String apellidoAjeno;
    private String nickAjeno;
    private String correoAjeno;
    private String grupoAjeno;
    private String webAjeno;
    private String tipoMusicaAjeno;
    private String imagenAjeno;

    private List<MelomBean> listaMelomsAjenos;

    private List<String> listNicks;

    private boolean isFollowed;
    private boolean ItsaMeMario;

    private boolean isAnonymous;

    public PerfilUsuarioController(){
        java.util.logging.Logger.getLogger(getClass().getName()).log( java.util.logging.Level.INFO, "*********************" );
    }
    
    public void init() {
        java.util.logging.Logger.getLogger(getClass().getName()).log( java.util.logging.Level.INFO, "init" );
        checkUserIsAnonymous();

        if (!isAnonymous) {
            initSessionForDao();
            UsuarioBean usuarioActual = usuarioDao.getById(UtilUserSession.getUserId());
            this.listNicks = usuarioDao.getAllNicks();
            closeSession();

            this.idPersonal = usuarioActual.getId();

            this.nombrePersonal = usuarioActual.getNombreDeUsuario();
            this.apellidoPersonal = usuarioActual.getApellidoDeUsuario();
            this.nickPersonal = usuarioActual.getNickDeUsuario();
            this.correoPersonal = usuarioActual.getCorreoDeUsuario();
            this.grupoPersonal = usuarioActual.getGrupoDeUsuario();
            this.webPersonal = usuarioActual.getWebDeUsuario();
            this.tipoMusicaPersonal = usuarioActual.getTipoMusicaDeUsuario();
            this.imagenPersonal = usuarioActual.getRutaImagenDeUsuario();
        } else {

            initSessionForDao();
            this.listNicks = usuarioDao.getAllNicks();
            closeSession();

        }
    }

    public void viewProfile(String nickAjeno) {

        initSessionForDao();
        UsuarioBean usuarioActual = usuarioDao.getByNick(nickAjeno);
        closeSession();


        this.idAjeno = usuarioActual.getId();

        this.nombreAjeno = usuarioActual.getNombreDeUsuario();
        this.apellidoAjeno = usuarioActual.getApellidoDeUsuario();
        this.nickAjeno = usuarioActual.getNickDeUsuario();
        this.correoAjeno = usuarioActual.getCorreoDeUsuario();
        this.grupoAjeno = usuarioActual.getGrupoDeUsuario();
        this.webAjeno = usuarioActual.getWebDeUsuario();
        this.tipoMusicaAjeno = usuarioActual.getTipoMusicaDeUsuario();
        this.imagenAjeno = usuarioActual.getRutaImagenDeUsuario();

        initSessionForDao();
        this.listaMelomsAjenos = usuarioDao.getListMelomsByUser(idAjeno);
        closeSession();

        userIsFollowed();

        String route = "/views/usuario/perfil.xhtml";
        UtilViews.redirect(route);

    }

    public void viewAllProfiles() {

        String route = "/views/usuario/listaUsuarios.xhtml";
        UtilViews.redirect(route);

    }

    public void follow() {

        initSessionForDao();
        initTransactionForDao();
        usuarioDao.followNewUser(this.idAjeno, UtilUserSession.getUserId());
        commitAndCloseSession();
        refreshProfile();

    }

    public void unfollow() {

        initSessionForDao();
        initTransactionForDao();
        usuarioDao.unfollowUser(this.idAjeno, UtilUserSession.getUserId());
        commitAndCloseSession();
        refreshProfile();
    }

    public void modifyProfile(Long id) {

        initSessionForDao();
        initTransactionForDao();
        usuarioDao.update(idPersonal, nombrePersonal, apellidoPersonal, correoPersonal, grupoPersonal, webPersonal, tipoMusicaPersonal);
        commitAndCloseSession();

        String summary = "¡Ahora sí que rockeas!";
        String detail = "La información de tu perfil fue actualizada";
//TODO        String route = "/views/timeline/timeline.xhtml";
        String route = "/index.xhtml";

        UtilViews.redirectWithInfoMessage(route,summary,detail);
    }

    public void modifyPassword() {

        initSessionForDao();
        UsuarioBean usuario = usuarioDao.getById(idPersonal);
        closeSession();

        if (oldPasswordIsOk(usuario) && newPassIsOk()) {

            String newPassHashed = hashNewPassword();

            initSessionForDao();
            initTransactionForDao();
            usuarioDao.updatePassword(usuario.getId(), newPassHashed);
            commitAndCloseSession();

            String summary = "¡Buena afinación!";
            String detail = "La password fue cambiada satisfactoriamente";
            String route = "/views/formulario/modificacionUsuario.xhtml";

            UtilViews.redirectWithInfoMessage(route,summary,detail);

        } else {

            String summary = "¡Eso ha desafinado!";
            String detail = "Verifica las passwords, alguna de ellas no fue bien introducida";

            UtilViews.sendErrorMessage(summary, detail);
        }

    }

    private String hashNewPassword() {
        String salt = UtilPasswords.getSalt();
        return UtilPasswords.hashPasswordSHA(newPass + salt);
    }

    private boolean newPassIsOk() {
        return newPass.equals(newPassOk);
    }

    private boolean oldPasswordIsOk(UsuarioBean usuario) {

        String salt = UtilPasswords.getSalt();
        String hashOldPassword = UtilPasswords.hashPasswordSHA(oldPass + salt);
        String oldPassword = usuario.getPasswordDeUsuario();

        return hashOldPassword.equals(oldPassword);
    }

    public void redirectToFormPassword() {

        UtilViews.redirect("/views/formulario/modificarPassword.xhtml");

    }

    private void checkUserIsAnonymous() {

        if (UtilUserSession.getUserId() == null) {

            isAnonymous = true;
        } else {

            isAnonymous = false;
        }

    }

    public void refreshProfile() {

        userIsFollowed();
        String route = "/views/usuario/perfil.xhtml";
        UtilViews.redirect(route);


    }

    private void userIsFollowed() {

        if (this.idAjeno == UtilUserSession.getUserId()) {

            this.isFollowed = false;
            this.ItsaMeMario = true;

        } else {
            initSessionForDao();
            List<Long> listaUsuariosSeguidos = usuarioDao.getFollowedUsers(UtilUserSession.getUserId());
            closeSession();
            this.isFollowed = listaUsuariosSeguidos.contains(idAjeno);
            this.ItsaMeMario = false;
        }
    }

    public void initSessionForDao() {
        Session session = UtilSessionHibernate.initSession();
        usuarioDao.setSession(session);
    }

    public void commitAndCloseSession() {
        Session session = usuarioDao.getSession();
        UtilSessionHibernate.commitAndCloseSession(session);

    }


    public void initTransactionForDao() {
        Session session = usuarioDao.getSession();
        UtilSessionHibernate.initTransaction(session);

    }


    public void closeSession() {
        Session session = usuarioDao.getSession();
        UtilSessionHibernate.closeSession(session);
    }

    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNombrePersonal() {
        return nombrePersonal;
    }

    public void setNombrePersonal(String nombrePersonal) {
        this.nombrePersonal = nombrePersonal;
    }

    public UsuarioDAO getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDAO usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public String getApellidoPersonal() {
        return apellidoPersonal;
    }

    public void setApellidoPersonal(String apellidoPersonal) {
        this.apellidoPersonal = apellidoPersonal;
    }

    public String getNickPersonal() {
        return nickPersonal;
    }

    public void setNickPersonal(String nickPersonal) {
        this.nickPersonal = nickPersonal;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public String getGrupoPersonal() {
        return grupoPersonal;
    }

    public void setGrupoPersonal(String grupoPersonal) {
        this.grupoPersonal = grupoPersonal;
    }

    public String getWebPersonal() {
        return webPersonal;
    }

    public void setWebPersonal(String webPersonal) {
        this.webPersonal = webPersonal;
    }

    public String getTipoMusicaPersonal() {
        return tipoMusicaPersonal;
    }

    public void setTipoMusicaPersonal(String tipoMusicaPersonal) {
        this.tipoMusicaPersonal = tipoMusicaPersonal;
    }

    public String getImagenPersonal() {

        return imagenPersonal;

    }

    public Long getIdAjeno() {
        return idAjeno;
    }

    public void setIdAjeno(Long idAjeno) {
        this.idAjeno = idAjeno;
    }

    public String getNombreAjeno() {
        return nombreAjeno;
    }

    public void setNombreAjeno(String nombreAjeno) {
        this.nombreAjeno = nombreAjeno;
    }

    public String getApellidoAjeno() {
        return apellidoAjeno;
    }

    public void setApellidoAjeno(String apellidoAjeno) {
        this.apellidoAjeno = apellidoAjeno;
    }

    public String getNickAjeno() {
        return nickAjeno;
    }

    public void setNickAjeno(String nickAjeno) {
        this.nickAjeno = nickAjeno;
    }

    public String getCorreoAjeno() {
        return correoAjeno;
    }

    public void setCorreoAjeno(String correoAjeno) {
        this.correoAjeno = correoAjeno;
    }

    public String getGrupoAjeno() {
        return grupoAjeno;
    }

    public void setGrupoAjeno(String grupoAjeno) {
        this.grupoAjeno = grupoAjeno;
    }

    public String getWebAjeno() {
        return webAjeno;
    }

    public void setWebAjeno(String webAjeno) {
        this.webAjeno = webAjeno;
    }

    public String getTipoMusicaAjeno() {
        return tipoMusicaAjeno;
    }

    public void setTipoMusicaAjeno(String tipoMusicaAjeno) {
        this.tipoMusicaAjeno = tipoMusicaAjeno;
    }

    public String getImagenAjeno() {
        return imagenAjeno;
    }

    public void setImagenAjeno(String imagenAjeno) {
        this.imagenAjeno = imagenAjeno;
    }

    public List<String> getListNicks() {
        return listNicks;
    }

    public void setListNicks(List<String> listNicks) {
        this.listNicks = listNicks;
    }

    public boolean getIsFollowed() {
        return isFollowed;
    }

    public void setFollowed(boolean followed) {
        isFollowed = followed;
    }

    public boolean getItsaMeMario() {
        return ItsaMeMario;
    }

    public void setItsaMeMario(boolean itsaMeMario) {
        this.ItsaMeMario = itsaMeMario;
    }

    public boolean getIsAnonymous() {
        System.out.println( "isAnonymous:" + isAnonymous );
        java.util.logging.Logger.getLogger(getClass().getName()).log( java.util.logging.Level.INFO, "*********************isAnonymous:" + isAnonymous );
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    public List<MelomBean> getListaMelomsAjenos() {
        return listaMelomsAjenos;
    }

    public void setListaMelomsAjenos(List<MelomBean> listaMelomsAjenos) {
        this.listaMelomsAjenos = listaMelomsAjenos;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getNewPassOk() {
        return newPassOk;
    }

    public void setNewPassOk(String newPassOk) {
        this.newPassOk = newPassOk;
    }
}
