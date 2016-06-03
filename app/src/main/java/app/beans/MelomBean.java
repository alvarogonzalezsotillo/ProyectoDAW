package app.beans;

import app.beans.interfaces.Bean;
import app.utils.UtilFiles;
import org.primefaces.model.UploadedFile;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "meloms")
public class MelomBean implements Serializable, Bean {

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

    @Column(name = "rutaCancion", columnDefinition = "LONGBLOB")
    private String rutaCancion;

    private transient UploadedFile cancion;

    @Column(name = "rutaImagenAlbum", columnDefinition = "LONGBLOB")
    private String rutaImagenAlbum;

    private transient UploadedFile imagenAlbum;

    @Column(name ="idUsuario")
    private Long idUsuario;

    @Column(name = "autor")
    private String autor;

    public MelomBean() {
        //Constructor por defecto
    }

    public MelomBean(String titulo, String album, String tipoMusica, String comentarioMusico, String rutaCancion, String rutaImagenAlbum, Long idUsuario, String autor) {
        this.titulo = titulo;
        this.album = album;
        this.tipoMusica = tipoMusica;
        this.comentarioMusico = comentarioMusico;
        this.rutaCancion = rutaCancion;
        this.rutaImagenAlbum = rutaImagenAlbum;
        this.idUsuario = idUsuario;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRutaCancion(){

        return this.rutaCancion;

    }

    public String getRutaImagenAlbum() {

        return rutaImagenAlbum;
    }


    public Long getIdUsuario() {
        return idUsuario;
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

    public void setRutaCancion(String rutaCancion) {
        this.rutaCancion = rutaCancion;
    }

    public void setRutaImagenAlbum(String rutaImagenAlbum) {
        this.rutaImagenAlbum = rutaImagenAlbum;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public UploadedFile getCancion() {
        return cancion;
    }

    public void setCancion(UploadedFile cancion) {
        this.cancion = cancion;
    }

    public UploadedFile getImagenAlbum() {
        return imagenAlbum;
    }

    public void setImagenAlbum(UploadedFile imagenAlbum) {
        this.imagenAlbum = imagenAlbum;
    }
}
