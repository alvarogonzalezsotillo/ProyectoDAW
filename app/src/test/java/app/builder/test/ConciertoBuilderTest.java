package app.builder.test;

import app.beans.ConciertoBean;
import app.builder.ConciertoBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConciertoBuilderTest {

    ConciertoBuilder sut;
    ConciertoBuilder returned;

    private String paisTest = "paisTest";
    private String ciudadTest = "ciudadTest";
    private String lugarTest = "lugarTest";
    private Long idUsuarioTest = 1L;

    ConciertoBean concierto;

    @Before
    public void setUp() throws Exception {

        try {

            sut = new ConciertoBuilder();


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

        ConciertoBuilder conciertoBuilder = new ConciertoBuilder(idUsuarioTest,lugarTest,ciudadTest,paisTest);

        assertNotNull(conciertoBuilder);

    }

    @Test
    public void shouldSetAllAttributesReturnComentarioBuilderOnEachOneAndBuildNewComentario(){

        returned = sut.idUsuario(idUsuarioTest);
        assertSame(returned,sut);

        returned = sut.pais(paisTest);
        assertSame(returned,sut);

        returned = sut.ciudad(ciudadTest);
        assertSame(returned,sut);

        returned = sut.lugar(lugarTest);
        assertSame(returned,sut);

        concierto = sut.build();

        assertEquals(paisTest, concierto.getPais());
        assertEquals(ciudadTest, concierto.getCiudad());
        assertEquals(lugarTest, concierto.getLugar());
        assertEquals(idUsuarioTest, concierto.getIdUsuario());

    }
}
