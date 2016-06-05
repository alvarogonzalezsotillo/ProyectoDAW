package app.controller;

import app.beans.ComentarioBean;
import app.beans.MelomBean;
import app.builder.ComentarioBuilder;
import app.controller.interfaces.Controller;
import app.model.ComentarioDAO;
import app.utils.UtilComments;
import app.utils.UtilSessionHibernate;
import app.utils.UtilUserSession;
import app.utils.UtilViews;
import org.hibernate.Session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "comentarioController")
@ViewScoped
public class ComentarioController implements Serializable, Controller {

    private static final long serialVersionUID = 1L;

    private ComentarioBuilder comentarioBuilder;

    private String texto;
    private Long idUsuario = UtilUserSession.getUserId();
    private String nombreUsuario = UtilUserSession.getUserName();
    private Long idMelom = UtilComments.getIdMelom();
    private MelomBean melom = UtilComments.getMelom();

    @ManagedProperty(value = "#{comentarioDao}")
    private ComentarioDAO comentarioDao;

    private List<ComentarioBean> listaComentarios;

    private boolean isAnonymous;

    public void init() {

        checkUserIsAnonymous();

        if (!isAnonymous) {

            initSessionForDao();
            this.listaComentarios = comentarioDao.getAllByIdMelom(idMelom);
            closeSession();

            this.melom = UtilComments.getMelom();
            System.out.print("");

        }
    }

    private void checkUserIsAnonymous() {

        if (UtilUserSession.getUserId() == null) {

            isAnonymous = true;
        } else {

            isAnonymous = false;
        }

    }

    public void comentar(MelomBean melom) {

        UtilComments.setMelom(melom);
        UtilComments.setIdMelom(melom.getId());

        String route = "/views/formulario/comentario.xhtml";

        UtilViews.redirect(route);

    }

    public void verComentarios(MelomBean melom) {

        UtilComments.setMelom(melom);
        UtilComments.setIdMelom(melom.getId());

        String route = "/views/melom/comentarios.xhtml";

        UtilViews.redirect(route);

    }

    public void insertComentario() {

        ComentarioBean comentario = createComentarioBean();

        initSessionForDao();
        initTransactionForDao();
        comentarioDao.insert(comentario);
        commitAndCloseSession();

        String route = "/views/melom/comentarios.xhtml";

        UtilViews.redirect(route);

    }

    public void updateComentario() {
        ComentarioBean comentario = createComentarioBean();

        initSessionForDao();
        initTransactionForDao();
        comentarioDao.update(comentario);
        commitAndCloseSession();

    }

    public void deleteComentario(Long id) {

        initSessionForDao();
        initTransactionForDao();
        comentarioDao.deleteById(id);
        commitAndCloseSession();

        String route = "/views/melom/comentarios.xhtml";

        UtilViews.redirect(route);

    }

    public void listComentario() {

        initSessionForDao();
        List<ComentarioBean> listaComentarios = comentarioDao.getAll();
        closeSession();

    }

    public void getComentario(Long id) {

        initSessionForDao();
        ComentarioBean comentarioReturned = comentarioDao.getById(id);
        closeSession();

    }

    public void listComentarioByIdUsuario(Long idusuario) {

        initSessionForDao();
        List<ComentarioBean> listaComentariosFilterByIdUsuario = comentarioDao.getAllByIdUsuario(idusuario);
        closeSession();

    }

    public void listComentarioByIdMelom(Long idMelom) {

        initSessionForDao();
        List<ComentarioBean> listaComentariosFilterByIdMelom = comentarioDao.getAllByIdMelom(idMelom);
        closeSession();

    }


    public void initSessionForDao() {
        Session session = UtilSessionHibernate.initSession();
        comentarioDao.setSession(session);
    }


    public void commitAndCloseSession() {
        Session session = comentarioDao.getSession();
        UtilSessionHibernate.commitAndCloseSession(session);

    }


    public void closeSession() {
        Session session = comentarioDao.getSession();
        UtilSessionHibernate.closeSession(session);
    }


    public void initTransactionForDao() {
        Session session = comentarioDao.getSession();
        UtilSessionHibernate.initTransaction(session);

    }

    private ComentarioBean createComentarioBean() {
        comentarioBuilder = new ComentarioBuilder(texto, idUsuario, nombreUsuario, idMelom);

        return comentarioBuilder.build();
    }

    public ComentarioBuilder getComentarioBuilder() {
        return comentarioBuilder;
    }

    public void setComentarioBuilder(ComentarioBuilder comentarioBuilder) {
        this.comentarioBuilder = comentarioBuilder;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdMelom() {
        return idMelom;
    }

    public void setIdMelom(Long idMelom) {
        this.idMelom = idMelom;
    }

    public ComentarioDAO getComentarioDao() {
        return comentarioDao;
    }

    public void setComentarioDao(ComentarioDAO comentarioDao) {
        this.comentarioDao = comentarioDao;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public List<ComentarioBean> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<ComentarioBean> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public boolean getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    public MelomBean getMelom() {
        return melom;
    }

    public void setMelom(MelomBean melom) {
        this.melom = melom;
    }

    public String getMelomAutor() {

        return melom.getAutor();

    }

    public String getMelomTitulo() {

        return melom.getTitulo();

    }

    public String getMelomAlbum() {

        return melom.getAlbum();

    }

    public String getMelomTipoMusica() {

        return melom.getTipoMusica();

    }

    public String getMelomComentario() {

        return melom.getComentarioMusico();

    }

    public String getMelomCancion() {

        return melom.getRutaCancion();

    }

    public String getMelomImagenAlbum() {

        return melom.getRutaImagenAlbum();

    }
}
