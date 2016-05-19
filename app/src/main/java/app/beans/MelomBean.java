package app.beans;

import app.beans.interfaces.Bean;
import app.utils.UtilFiles;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BETAmeloms")//TODO NO OLVIDAR CAMBIAR CUANDO TERMINEMOS LA TABLA DE MELOMS!!!!!!!!!!!!!!!!!!!
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

    @Column(name = "cancion", columnDefinition = "LONGBLOB")
    private byte[] cancion;

    @Column(name = "imagenAlbum", columnDefinition = "LONGBLOB")
    private byte[] imagenAlbum;

    @Column(name ="idUsuario")
    private Long idUsuario;

    public MelomBean() {
        //Constructor por defecto
    }

    public MelomBean(String titulo, String album, String tipoMusica, String comentarioMusico, byte[] cancion, byte[] imagenAlbum, Long idUsuario) {
        this.titulo = titulo;
        this.album = album;
        this.tipoMusica = tipoMusica;
        this.comentarioMusico = comentarioMusico;
        this.cancion = cancion;
        this.imagenAlbum = imagenAlbum;
        this.idUsuario = idUsuario;
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

    public String getCancion() {
        return UtilFiles.transformFileToBase64(cancion);
    }

    public String getImagenAlbum() {
        return UtilFiles.transformFileToBase64(imagenAlbum);
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

    public void setCancion(byte[] cancion) {
        this.cancion = cancion;
    }

    public void setImagenAlbum(byte[] imagenAlbum) {
        this.imagenAlbum = imagenAlbum;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

}
