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
import java.io.*;
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
    private String rutaImagenAlbum = null;


    public void insertMelom() throws IOException {

        this.rutaImagenAlbum = upload(imagenAlbum);
        this.rutaCancion = upload(cancion);

        MelomBean melom = createMelomBean();
        initSessionForDao();
        initTransactionForDao();
        melomDao.insert(melom);
        commitAndCloseSession();

//TODO        String route = "/views/timeline/timeline.xhtml";
        String route = "/index.xhtml";

        UtilViews.redirect(route);
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
        List<MelomBean> listaMeloms = melomDao.getAll();
        commitAndCloseSession();

    }

    public void getMelomById(Long id){

        initSessionForDao();
        initTransactionForDao();
        MelomBean melomReturned = melomDao.getById(id);
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
                            .rutaCancion(rutaCancion)
                            .rutaImagenAlbum(rutaImagenAlbum)
                            .autor(autor)
                            .build();
    }

    public String upload(UploadedFile uploadedFile) throws IOException {

        String randomNameFile = UtilFiles.getRandomName();

        String typeFile = UtilFiles.getTypeFile(uploadedFile);

        String newName = randomNameFile + typeFile;

        byte[] contents = uploadedFile.getContents();

        InputStream dataFile = uploadedFile.getInputstream();

        File file = new File(UtilFiles.getPath(), newName);

        return saveFile(file, dataFile, contents);

    }

    public String saveFile(File file, InputStream dataFile, byte[] contents) throws IOException {

        OutputStream streamOut = new FileOutputStream(file);

        int read = 0;
        byte[] bytes = new byte[contents.length];
        while ((read = dataFile.read(bytes)) != -1) {
            streamOut.write(bytes, 0, read);
        }
        streamOut.flush();

        return UtilFiles.getFileRoute(file);
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
