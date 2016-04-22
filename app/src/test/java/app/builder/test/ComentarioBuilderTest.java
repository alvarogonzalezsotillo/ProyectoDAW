package app.builder.test;

import app.beans.implementations.ComentarioBean;
import app.builder.ComentarioBuilder;
import app.builder.UsuarioBuilder;

import static org.junit.Assert.*;

import org.junit.*;

public class ComentarioBuilderTest {

    ComentarioBuilder sut;
    ComentarioBuilder returned;

    private String textoTest = "textoTest";
    private Long idUsuarioTest = 1L;
    private Long idTweetTest = 1L;

    ComentarioBean comentario;

    @Before
    public void setUp() throws Exception {

        try {

            sut = new ComentarioBuilder();


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

        ComentarioBuilder comentarioBuilder = new ComentarioBuilder(textoTest,idUsuarioTest,idTweetTest);

        assertNotNull(comentarioBuilder);

    }

    @Test
    public void shouldSetAllAttributesReturnComentarioBuilderOnEachOneAndBuildNewComentario(){

        returned = sut.idTweet(idTweetTest);
        assertSame(returned,sut);

        returned = sut.idUsuario(idUsuarioTest);
        assertSame(returned,sut);

        returned = sut.texto(textoTest);
        assertSame(returned,sut);

        comentario = sut.build();

        assertEquals(textoTest,comentario.getTexto());
        assertEquals(idUsuarioTest,comentario.getIdUsuario());
        assertEquals(idTweetTest,comentario.getIdTweet());

    }



}
