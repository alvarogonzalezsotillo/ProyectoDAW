package app.controller;

import app.beans.MelomBean;
import app.builder.MelomBuilder;
import app.controller.interfaces.Controller;
import app.model.MelomDAO;
import app.utils.UtilFiles;
import app.utils.UtilSessionHibernate;
import app.utils.UtilUserSession;
import app.utils.UtilViews;
import org.hibernate.Session;
import org.primefaces.model.UploadedFile;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "melomController")
@ViewScoped
public class MelomController implements Serializable, Controller {

    private static final long serialVersionUID = 1L;

    private MelomBuilder melomBuilder;

    @ManagedProperty(value = "#{melomDao}")
    private MelomDAO melomDao;

    private String titulo;
    private String album;
    private String tipoMusica;
    private String comentario;
    private transient UploadedFile imagenAlbum;
    private transient UploadedFile cancion;
    private Long idUsuario = UtilUserSession.getUserId();
    private String autor = UtilUserSession.getUserName();
    private String rutaCancion = null;
    private String rutaImagenAlbum = UtilFiles.getDefaultAlbumRoute();


    public void insertMelom() throws IOException {
        java.util.logging.Logger.getLogger(getClass().getName()).log( java.util.logging.Level.SEVERE, "insertando Melom" );
        if (checkImageIsNull()) {

            this.rutaImagenAlbum = UtilFiles.upload(imagenAlbum);
        }

        this.rutaCancion = UtilFiles.upload(cancion);
        java.util.logging.Logger.getLogger(getClass().getName()).log( java.util.logging.Level.SEVERE, "Fichero subido:" + this.rutaCancion );
        
        MelomBean melom = createMelomBean();
        initSessionForDao();
        initTransactionForDao();
        melomDao.insert(melom);
        commitAndCloseSession();
        java.util.logging.Logger.getLogger(getClass().getName()).log( java.util.logging.Level.SEVERE, "Melom insertado:" + melom );

        refreshPage();
    }

    public void deleteMelom(Long id) {

        initSessionForDao();
        initTransactionForDao();
        melomDao.deleteById(id);
        commitAndCloseSession();
        refreshPage();
    }

    private boolean checkImageIsNull() {

        String fileName = imagenAlbum.getFileName();

        return !(fileName.equals(""));
    }


    private void refreshPage() {
        //TODO        String route = "/views/timeline/timeline.xhtml";
        String route = "/index.xhtml";

        UtilViews.redirect(route);
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

    private MelomBean createMelomBean() {
        melomBuilder = new MelomBuilder(titulo, idUsuario);
        return melomBuilder.album(album)
                .tipoMusica(tipoMusica)
                .comentarioMusico(comentario)
                .rutaCancion(rutaCancion)
                .rutaImagenAlbum(rutaImagenAlbum)
                .autor(autor)
                .build();
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRutaCancion() {
        return rutaCancion;
    }

    public void setRutaCancion(String rutaCancion) {
        this.rutaCancion = rutaCancion;
    }

    public String getRutaImagenAlbum() {
        return rutaImagenAlbum;
    }

    public void setRutaImagenAlbum(String rutaImagenAlbum) {
        this.rutaImagenAlbum = rutaImagenAlbum;
    }
}
