package app.builder.test;

import app.beans.implementations.MelomBean;
import app.builder.MelomBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class MelomBuilderTest {

    MelomBuilder sut;
    MelomBuilder returned;

    Long idUsuarioTest = 1L;
    String tituloTest = "tituloTest";
    String albumTest = "albumTest";
    String tipoMusicaTest = "tipoMusicaTest";
    String comentarioTest= "comentarioTest";

    MelomBean melom;

    @Before
    public void setUp() throws Exception {

        try {

            sut = new MelomBuilder();


        }

        catch (ExceptionInInitializerError e) {

            throw new ExceptionInInitializerError("No se ha podido inicializar el SUT" + e);

        }

    }

    @After
    public void tearDown() throws Exception {

        sut = null;

    }

    @Test
    public void shouldConstructANewComentarioBuilder(){

        MelomBuilder melomBuilder = new MelomBuilder();

        assertNotNull(melomBuilder);

    }

    @Test
    public void shouldSetAllAttributesReturnComentarioBuilderOnEachOneAndBuildNewComentario(){


        returned = sut.titulo(tituloTest);
        assertSame(returned,sut);

        returned = sut.album(albumTest);
        assertSame(returned,sut);

        returned = sut.tipoMusica(tipoMusicaTest);
        assertSame(returned,sut);

        returned = sut.comentarioMusico(comentarioTest);
        assertSame(returned,sut);

        returned = sut.idUsuario(idUsuarioTest);
        assertSame(returned,sut);

        melom = sut.build();

        assertEquals(tituloTest, melom.getTitulo());
        assertEquals(albumTest, melom.getAlbum());
        assertEquals(tipoMusicaTest, melom.getTipoMusica());
        assertEquals(comentarioTest, melom.getComentarioMusico());
        assertEquals(idUsuarioTest, melom.getIdUsuario());

    }
}
