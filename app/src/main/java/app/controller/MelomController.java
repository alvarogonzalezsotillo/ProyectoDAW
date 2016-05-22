package app.controller;

import app.beans.MelomBean;
import app.builder.MelomBuilder;
import app.controller.interfaces.Controller;
import app.model.MelomDAO;
import app.utils.UtilSessionHibernate;
import app.utils.UtilUserSession;
import org.hibernate.Session;
import org.primefaces.model.UploadedFile;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
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


    public void insertMelom() {

        MelomBean melom = createMelomBean();
        initSessionForDao();
        initTransactionForDao();
        melomDao.insert(melom);
        commitAndCloseSession();
    }

    public void deleteMelom(Long id){

        initSessionForDao();
        initTransactionForDao();
        melomDao.deleteById(id);
        commitAndCloseSession();

    }

    public void updateMelom(){

        MelomBean melom = createMelomBean();
        initSessionForDao();
        initTransactionForDao();
        melomDao.update(melom);
        commitAndCloseSession();

    }

    public void listMelom(){

        initSessionForDao();
        initTransactionForDao();
        List<MelomBean> listaMeloms = melomDao.getAll();//Falta saber como enviarlo a la vista
        commitAndCloseSession();

    }

    public void getMelomById(Long id){

        initSessionForDao();
        initTransactionForDao();
        MelomBean melomReturned = melomDao.getById(id);//Falta saber como enviarlo a la vista
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

    private MelomBean createMelomBean() {
        melomBuilder = new MelomBuilder(titulo, idUsuario);
        return melomBuilder.album(album)
                            .tipoMusica(tipoMusica)
                            .comentarioMusico(comentario)
                            .cancion(cancion)
                            .imagenAlbum(imagenAlbum)
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
}
