package app.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;
import org.primefaces.model.UploadedFile;

import app.beans.MelomBean;
import app.builder.MelomBuilder;
import app.controller.interfaces.Controller;
import app.model.MelomDAO;
import app.utils.UtilSessionHibernate;

@ManagedBean (name="melomController")
@ViewScoped
public class MelomController implements Serializable,Controller {
	private static final long serialVersionUID = 1L;

	private MelomBuilder melomBuilder;
	private String titulo,album,tipoMusica,comentario;
	private UploadedFile imagenAlbum,cancion;
	private Long idUsuario=1L;
	
	@ManagedProperty(value="#{MelomDao}")
	private MelomDAO melomDao;

	//MelomController's methods
	public void insert(){
			melomBuilder=new MelomBuilder(titulo,idUsuario);
			MelomBean mb= melomBuilder
					.album(album)
					.tipoMusica(tipoMusica)
					.comentarioMusico(comentario)
					.cancion(cancion)
					.imagenAlbum(imagenAlbum).build();
			initSessionForDao();
			initTransactionForDao();
			melomDao.insert(mb);
			commitAndCloseSession();
	}//insert

	public void initSessionForDao() {
		Session session=UtilSessionHibernate.initSession();
		melomDao.setSession(session);
	}//initSessionForDAO
	public void initTransactionForDao() {
		 Session session = melomDao.getSession();
	     UtilSessionHibernate.initTransaction(session);
	}//initTransactionForDAO
	
	public void commitAndCloseSession(){
		 Session session = melomDao.getSession();
	     UtilSessionHibernate.commitAndCloseSession(session);
	}//commitAndCloseSession
	
	public void closeSession(){
		Session session = melomDao.getSession();
        UtilSessionHibernate.closeSession(session);
	}//closeSession
	
	//Getters & Setters
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
}//class
