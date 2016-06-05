package app.beans.test;

import app.beans.MelomBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MelomTest {

    Long idTest = 1L;
    Long idUsuarioTest = 1L;
    String tituloTest = "tituloTest";
    String albumTest = "albumTest";
    String tipoMusicaTest = "tipoMusicaTest";
    String comentarioTest = "comentarioTest";
    String autorTest = "autorTest";

    MelomBean sut;

    @Before
    public void setUp() throws Exception {

        try {

            sut = new MelomBean(tituloTest, albumTest, tipoMusicaTest, comentarioTest, null, null, idUsuarioTest, autorTest);
            sut.setId(idTest);

        } catch (ExceptionInInitializerError e) {

            throw new ExceptionInInitializerError("No se ha podido inicializar el SUT" + e);

        }
    }

    @After
    public void tearDown() throws Exception {

        try {

            sut = null;
        } catch (Exception e) {

            throw new ExceptionInInitializerError("No se ha podido destruir el SUT" + e);

        }
    }

    @Test
    public void shouldReturnTheAttributedWhenCallingGetters() {

        Long idActual = sut.getId();
        assertEquals(idTest, idActual);

        String tituloActual = sut.getTitulo();
        assertEquals(tituloTest, tituloActual);

        String albumActual = sut.getAlbum();
        assertEquals(albumTest, albumActual);

        String tipoMusicaActual = sut.getTipoMusica();
        assertEquals(tipoMusicaTest, tipoMusicaActual);

        String comentarioActual = sut.getComentarioMusico();
        assertEquals(comentarioTest, comentarioActual);

        String autorActual = sut.getAutor();
        assertEquals(autorTest, autorActual);

        Long idUsuarioActual = sut.getIdUsuario();
        assertEquals(idUsuarioTest, idUsuarioActual);

    }

    @Test
    public void shouldSetTheNewAttributesWhenCallingSetters() {

        Long nuevoId = 2L;
        sut.setId(nuevoId);
        assertEquals(nuevoId, sut.getId());

        String nuevoTitulo = "nuevoTitulo";
        sut.setTitulo(nuevoTitulo);
        assertEquals(nuevoTitulo, sut.getTitulo());

        String nuevoAlbum = "nuevoAlbum";
        sut.setAlbum(nuevoAlbum);
        assertEquals(nuevoAlbum, sut.getAlbum());

        String nuevoTipoMusica = "nuevoTipoMusica";
        sut.setTipoMusica(nuevoTipoMusica);
        assertEquals(nuevoTipoMusica, sut.getTipoMusica());

        String nuevoComentario = "nuevoComentario";
        sut.setComentarioMusico(nuevoComentario);
        assertEquals(nuevoComentario, sut.getComentarioMusico());

        Long nuevoIdUsuario = 2L;
        sut.setIdUsuario(nuevoIdUsuario);
        assertEquals(nuevoIdUsuario, sut.getIdUsuario());

    }

}
