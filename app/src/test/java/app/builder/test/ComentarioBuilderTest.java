package app.builder.test;

import app.beans.ComentarioBean;
import app.builder.ComentarioBuilder;

import static org.junit.Assert.*;

import org.junit.*;

public class ComentarioBuilderTest {

    ComentarioBuilder sut;
    ComentarioBuilder returned;

    private String textoTest = "textoTest";
    private Long idUsuarioTest = 1L;
    private Long idMelomTest = 1L;

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

        ComentarioBuilder comentarioBuilder = new ComentarioBuilder(textoTest,idUsuarioTest,idMelomTest);

        assertNotNull(comentarioBuilder);

    }

    @Test
    public void shouldSetAllAttributesReturnComentarioBuilderOnEachOneAndBuildNewComentario(){

        returned = sut.idMelom(idMelomTest);
        assertSame(returned,sut);

        returned = sut.idUsuario(idUsuarioTest);
        assertSame(returned,sut);

        returned = sut.texto(textoTest);
        assertSame(returned,sut);

        comentario = sut.build();

        assertEquals(textoTest,comentario.getTexto());
        assertEquals(idUsuarioTest,comentario.getIdUsuario());
        assertEquals(idMelomTest,comentario.getIdMelom());

    }

}
