package app.beans.test;


import app.beans.ComentarioBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComentarioTest {

    private Long idTest = 1l;
    private String textoTest = "textoTest";
    private Long idUsuarioTest = 1L;
    private Long idMelomTest = 1L;

    ComentarioBean sut;

    @Before
    public void setUp() throws Exception {

        try {

            sut = new ComentarioBean(textoTest, idUsuarioTest, idMelomTest);
            sut.setId(idTest);

        }

        catch (ExceptionInInitializerError e) {

            throw new ExceptionInInitializerError("No se ha podido inicializar el SUT" + e);

        }
    }

    @After
    public void tearDown() throws Exception {

        try {

            sut = null;
        }

        catch (Exception e) {

            throw new ExceptionInInitializerError("No se ha podido destruir el SUT" + e);

        }
    }

    @Test
    public void shouldReturnTheAttributedWhenCallingGetters(){

        Long idActual = sut.getId();
        assertEquals(idTest,idActual);

        String textoActual = sut.getTexto();
        assertEquals(textoTest,textoActual);

        Long idUsuarioActual = sut.getIdUsuario();
        assertEquals(idUsuarioTest,idUsuarioActual);

        Long idMelomTest = sut.getIdMelom();
        assertEquals(idMelomTest,idMelomTest);
    }

    @Test
    public void shouldSetTheNewAttributesWhenCallingSetters(){

        Long nuevoId = 2L;
        sut.setId(nuevoId);
        assertEquals(nuevoId,sut.getId());

        String nuevoTexto = "nuevoTexto";
        sut.setTexto(nuevoTexto);
        assertEquals(nuevoTexto,sut.getTexto());

        Long nuevoIdUsuario = 2L;
        sut.setIdUsuario(nuevoIdUsuario);
        assertEquals(nuevoIdUsuario,sut.getIdUsuario());

        Long nuevoIdMelom = 2L;
        sut.setIdMelom(nuevoIdMelom);
        assertEquals(nuevoIdMelom,sut.getIdMelom());
    }

}
