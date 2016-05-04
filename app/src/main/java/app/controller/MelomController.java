package app.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.primefaces.model.UploadedFile;

import app.beans.implementations.MelomBean;
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
	private transient UploadedFile imagenAlbum,cancion;
	private Long idUsuario=1L;
	
	@ManagedProperty(value="#{MelomDao}")
	private MelomDAO melomDao;

	//MelomController's methods
	public void insert(){
		if(comentario.equals("")||comentario==null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", 
					"Comprueba si has insertado un comentario antes de subir tu melom."));	
		}
		else{
			/*melomBuilder=new MelomBuilder(titulo,album,tipoMusica,comentario,cancion,imagenAlbum,idUsuario);
			MelomBean mb=melomBuilder.build();*/
			MelomBean mb=melomBuilder
					.titulo(titulo)
					.album(album)
					.tipoMusica(tipoMusica)
					.comentarioMusico(comentario)
					.cancion(cancion)
					.imagenAlbum(imagenAlbum)
					.idUsuario(idUsuario).build();
			initSessionForDao();
			initTransactionForDao();
			melomDao.insert(mb);
			commitAndCloseSession();
		}
	}//insertMelom

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
