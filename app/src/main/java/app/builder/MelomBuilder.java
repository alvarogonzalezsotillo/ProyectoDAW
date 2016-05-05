package app.builder;

import java.io.Serializable;

import app.builder.interfaces.Builder;
import org.primefaces.model.UploadedFile;

import app.beans.MelomBean;
import app.utils.Util;

public class MelomBuilder implements Serializable, Builder<MelomBean> {

    private static final long serialVersionUID = 1L;

    private String titulo;
    private String album;
    private String tipoMusica;
    private String comentarioMusico;
    private byte[] cancion;
    private byte[] imagenAlbum;
    private Long idUsuario;

    public MelomBuilder(){
        
        //Constructor por defecto para los test
        
    }

    public MelomBuilder(String titulo, String album, String tipoMusica, String comentarioMusico, byte[] cancion, byte[] imagenAlbum, Long idUsuario){
        this.titulo = titulo;
        this.album = album;
        this.tipoMusica = tipoMusica;
        this.comentarioMusico = comentarioMusico;
        this.cancion = cancion;
        this.imagenAlbum = imagenAlbum;
        this.idUsuario = idUsuario;
    }

    @Override
    public MelomBean build() {

        return new MelomBean(titulo, album, tipoMusica, comentarioMusico, cancion, imagenAlbum, idUsuario);

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

        this.cancion = Util.transformFile(cancion);

        return this;

    }
    
    public MelomBuilder imagenAlbum(UploadedFile imagenAlbum) {

        this.imagenAlbum = Util.transformFile(imagenAlbum);

        return this;

    }
    
    public MelomBuilder idUsuario(Long idUsuario) {

        this.idUsuario = idUsuario;

        return this;

    }
    
}
