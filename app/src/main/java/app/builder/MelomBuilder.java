package app.builder;

import app.beans.MelomBean;
import app.builder.interfaces.Builder;

import java.io.Serializable;

public class MelomBuilder implements Serializable, Builder<MelomBean> {

    private static final long serialVersionUID = 1L;

    private String titulo;
    private String album;
    private String tipoMusica;
    private String comentarioMusico;
    private String rutaCancion;
    private String rutaImagenAlbum;
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

        return new MelomBean(titulo, album, tipoMusica, comentarioMusico, rutaCancion, rutaImagenAlbum, idUsuario, autor);

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
    
    public MelomBuilder rutaCancion(String rutaCancion) {

        this.rutaCancion = rutaCancion;

        return this;

    }
    
    public MelomBuilder rutaImagenAlbum(String rutaImagenAlbum) {

        this.rutaImagenAlbum = rutaImagenAlbum;

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
