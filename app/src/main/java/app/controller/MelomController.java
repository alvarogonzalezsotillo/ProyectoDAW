package app.controller;

import app.beans.MelomBean;
import app.builder.MelomBuilder;
import app.controller.interfaces.Controller;
import app.model.MelomDAO;
import app.utils.UtilSessionHibernate;
import org.hibernate.Session;
import org.primefaces.model.UploadedFile;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "melomController")
@ViewScoped
public class MelomController implements Serializable, Controller {

    private static final long serialVersionUID = 1L;

    private MelomBuilder melomBuilder;

    private String titulo;
    private String album;
    private String tipoMusica;
    private String comentario;
    private transient UploadedFile imagenAlbum;
    private transient UploadedFile cancion;
    private Long idUsuario = 1L;

    @ManagedProperty(value = "#{melomDao}")
    private MelomDAO melomDao;

    public void insert() {
        melomBuilder = new MelomBuilder(titulo, idUsuario);
        MelomBean melom = melomBuilder.album(album)
                                      .tipoMusica(tipoMusica)
                                      .comentarioMusico(comentario)
                                      .cancion(cancion)
                                      .imagenAlbum(imagenAlbum)
                                      .build();
        System.out.println(imagenAlbum);
        System.out.println(cancion);
        initSessionForDao();
        initTransactionForDao();
        melomDao.insert(melom);
        commitAndCloseSession();
    }

    public void initSessionForDao() {
        Session session = UtilSessionHibernate.initSession();
        melomDao.setSession(session);
    }

    public void initTransactionForDao() {
        Session session = melomDao.getSession();
        UtilSessionHibernate.initTransaction(session);
    }

    public void commitAndCloseSession() {
        Session session = melomDao.getSession();
        UtilSessionHibernate.commitAndCloseSession(session);
    }

    public void closeSession() {
        Session session = melomDao.getSession();
        UtilSessionHibernate.closeSession(session);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTipoMusica() {
        return tipoMusica;
    }

    public void setTipoMusica(String tipoMusica) {
        this.tipoMusica = tipoMusica;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public MelomBuilder getMelomBuilder() {
        return melomBuilder;
    }

    public void setMelomBuilder(MelomBuilder melomBuilder) {
        this.melomBuilder = melomBuilder;
    }

    public UploadedFile getImagenAlbum() {
        return imagenAlbum;
    }

    public void setImagenAlbum(UploadedFile imagenAlbum) {
        this.imagenAlbum = imagenAlbum;
    }

    public UploadedFile getCancion() {
        return cancion;
    }

    public void setCancion(UploadedFile cancion) {
        this.cancion = cancion;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public MelomDAO getMelomDao() {
        return melomDao;
    }

    public void setMelomDao(MelomDAO melomDao) {
        this.melomDao = melomDao;
    }
}
