package app.builder;

import java.io.Serializable;

import app.builder.interfaces.Builder;
import app.utils.UtilFiles;
import org.primefaces.model.UploadedFile;

import app.beans.MelomBean;

public class MelomBuilder implements Serializable, Builder<MelomBean> {

    private static final long serialVersionUID = 1L;

    private String titulo;
    private String album;
    private String tipoMusica;
    private String comentarioMusico;
    private String rutaCancion;
    private byte[] imagenAlbum;
    private Long idUsuario;
    private String autor;

    public MelomBuilder(){
        
        //Constructor por defecto para los test
        
    }

    public MelomBuilder(String titulo, Long idUsuario){
        this.titulo = titulo;
        this.idUsuario = idUsuario;
    }


    public MelomBean build() {

        return new MelomBean(titulo, album, tipoMusica, comentarioMusico, rutaCancion, imagenAlbum, idUsuario, autor);

    }
    
    public MelomBuilder titulo(String titulo) {

        this.titulo = titulo;

        return this;

    }
    
    public MelomBuilder album(String album) {

        this.album = album;

        return this;

    }
    
    public MelomBuilder tipoMusica(String tipoMusica) {

        this.tipoMusica = tipoMusica;

        return this;

    }
    
    public MelomBuilder comentarioMusico(String comentarioMusico) {

        this.comentarioMusico = comentarioMusico;

        return this;

    }
    
    public MelomBuilder cancion(UploadedFile cancion) {

        this.rutaCancion = cancion.getFileName();

        return this;

    }
    
    public MelomBuilder imagenAlbum(UploadedFile imagenAlbum) {

        this.imagenAlbum = UtilFiles.transformFile(imagenAlbum);

        return this;

    }
    
    public MelomBuilder idUsuario(Long idUsuario) {

        this.idUsuario = idUsuario;

        return this;

    }

    public MelomBuilder autor(String autor){

        this.autor = autor;

        return this;

    }
    
}
