package app.controller;

import app.beans.UsuarioBean;
import app.controller.interfaces.Controller;
import app.model.UsuarioDAO;
import app.utils.UtilFiles;
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

    private Long idAjeno;

    private String nombreAjeno;
    private String apellidoAjeno;
    private String nickAjeno;
    private String correoAjeno;
    private String grupoAjeno;
    private String webAjeno;
    private String tipoMusicaAjeno;
    private String imagenAjeno;

    private List<String> listaNicks;

    private boolean isFollowed;

    public void init() {

        initSessionForDao();
        UsuarioBean usuarioActual = usuarioDao.getById(UtilUserSession.getUserId());
        this.listaNicks = usuarioDao.getAllNicks();
        closeSession();

        this.idPersonal = usuarioActual.getId();

        this.nombrePersonal = usuarioActual.getNombreDeUsuario();
        this.apellidoPersonal = usuarioActual.getApellidoDeUsuario();
        this.nickPersonal = usuarioActual.getNickDeUsuario();
        this.correoPersonal = usuarioActual.getCorreoDeUsuario();
        this.grupoPersonal = usuarioActual.getGrupoDeUsuario();
        this.webPersonal = usuarioActual.getWebDeUsuario();
        this.tipoMusicaPersonal = usuarioActual.getTipoMusicaDeUsuario();
        this.imagenPersonal = UtilFiles.transformFileToBase64(usuarioActual.getImagenDeUsuario());

    }

    public void verPerfil(String nickAjeno) {

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
        this.imagenAjeno = UtilFiles.transformFileToBase64(usuarioActual.getImagenDeUsuario());
        userIsFollowed();

        String route = "/views/perfil/usuario.xhtml";
        UtilViews.redirect(route);

    }

    private void userIsFollowed() {

        if (this.idAjeno == UtilUserSession.getUserId()) {

            this.isFollowed = true;

        }

        else {
            initSessionForDao();
            List<Long> listaUsuariosSeguidos = usuarioDao.getFollowedUsers(UtilUserSession.getUserId());
            closeSession();
            this.isFollowed = listaUsuariosSeguidos.contains(idAjeno);
        }
    }

    public void seguir() {

        initSessionForDao();
        initTransactionForDao();
        usuarioDao.seguirNuevoUsuario(this.idAjeno, UtilUserSession.getUserId());
        commitAndCloseSession();

    }

    public void dejarSeguir() {

        initSessionForDao();
        initTransactionForDao();
        usuarioDao.dejarSeguirUsuario(this.idAjeno, UtilUserSession.getUserId());
        commitAndCloseSession();

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

    public List<String> getListaNicks() {
        return listaNicks;
    }

    public void setListaNicks(List<String> listaNicks) {
        this.listaNicks = listaNicks;
    }

    public boolean getIsFollowed() {
        return isFollowed;
    }

    public void setFollowed(boolean followed) {
        isFollowed = followed;
    }
}
