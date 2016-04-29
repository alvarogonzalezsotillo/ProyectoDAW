package app.beans.implementations;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import app.beans.interfaces.Melom;

@Entity
@Table(name = "BETAmeloms")//NO OLVIDAR CAMBIAR CUANDO TERMINEMOS LA TABLA DE MELOMS!!!!!!!!!!!!!!!!!!!
public class MelomBean implements Melom, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
    private Long id;
	
	@Column(name = "titulo")
    private String titulo;
	
	@Column(name = "album")
    private String album;
	
	@Column(name = "tipoMusica")
    private String tipoMusica;
	
	@Column(name ="comentarioMusico")
    private String comentarioMusico;
	
	@Column(name = "cancion", columnDefinition = "LONGBLOB")
    private byte[] cancion;
	
	@Column(name = "imagenAlbum", columnDefinition = "LONGBLOB")
    private byte[] imagenAlbum;
	
	@Column(name ="idUsuario")
	private Long idUsuario;
	
	@Column(name = "fechaPublicacion")
	private Date fechaPublicacion;
	
	public MelomBean() {
        //Constructor por defecto
    }
	
	public MelomBean(String titulo, String album, String tipoMusica, String comentarioMusico, byte[] cancion, byte[] imagenAlbum, Long idUsuario, Date fechaPublicacion) {
		this.titulo = titulo;
		this.album = album;
		this.tipoMusica = tipoMusica;
		this.comentarioMusico = comentarioMusico;
		this.cancion = cancion;
		this.imagenAlbum = imagenAlbum;
		this.idUsuario = idUsuario;
		this.fechaPublicacion = fechaPublicacion;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAlbum() {
		return album;
	}

	public String getTipoMusica() {
		return tipoMusica;
	}

	public String getComentarioMusico() {
		return comentarioMusico;
	}

	public byte[] getCancion() {
		return cancion;
	}

	public byte[] getImagenAlbum() {
		return imagenAlbum;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public void setTipoMusica(String tipoMusica) {
		this.tipoMusica = tipoMusica;
	}

	public void setComentarioMusico(String comentarioMusico) {
		this.comentarioMusico = comentarioMusico;
	}

	public void setCancion(byte[] cancion) {
		this.cancion = cancion;
	}

	public void setImagenAlbum(byte[] imagenAlbum) {
		this.imagenAlbum = imagenAlbum;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	
	
}
