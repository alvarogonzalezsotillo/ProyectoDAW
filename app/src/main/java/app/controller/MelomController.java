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
import app.model.MelomDAO;
import app.utils.UtilSessionHibernate;

@ManagedBean (name="melomController")
@ViewScoped
public class MelomController implements Serializable {
	private static final long serialVersionUID = 1L;

	private MelomBuilder melomB;
	private String titulo,album,tipoMusica,comentario;
	private transient UploadedFile imagenAlbum,cancion;
	private Long idUsuario=1L;
	
	@ManagedProperty(value="#{MelomDAO}")
	private MelomDAO melomD;

	//MelomController's methods
	public void insert(){
		if(comentario==""){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", 
					"Comprueba si has insertado un comentario antes de subir tu melom."));	
		}
		else{
			//melomB=new MelomBuilder(titulo,album,tipoMusica,comentario,cancion,imagenAlbum,idUsuario);
			//MelomBean mb=melomB.build();
			MelomBean mb=melomB
					.titulo(titulo)
					.album(album)
					.tipoMusica(tipoMusica)
					.comentarioMusico(comentario)
					.cancion(cancion)
					.imagenAlbum(imagenAlbum)
					.idUsuario(idUsuario).build();
			initSessionForDAO();
			initTransactionForDAO();
			melomD.insert(mb);
			commitAndCloseSession();
		}
	}//insertMelom

	private void initSessionForDAO(){
		Session session=UtilSessionHibernate.initSession();
		melomD.setSession(session);
	}//initSessionForDAO
	
	private void commitAndCloseSession(){
		 Session session = melomD.getSession();
	     UtilSessionHibernate.commitAndCloseSession(session);
	}//commitAndCloseSession
	
	private void closeSession(){
		Session session = melomD.getSession();
        UtilSessionHibernate.closeSession(session);
	}//closeSession
	
	private void initTransactionForDAO(){
	     Session session = melomD.getSession();
	     UtilSessionHibernate.initTransaction(session);
	}//initTransactionForDAO
	
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

	public MelomBuilder getMelomB() {
		return melomB;
	}

	public void setMelomB(MelomBuilder melomB) {
		this.melomB = melomB;
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

	public MelomDAO getMelomD() {
		return melomD;
	}

	public void setMelomD(MelomDAO melomD) {
		this.melomD = melomD;
	}
}//class
