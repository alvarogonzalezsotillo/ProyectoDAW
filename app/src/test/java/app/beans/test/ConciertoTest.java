package app.beans.test;

import app.beans.implementations.ConciertoBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConciertoTest {

    Long idTest = 1L;
    Long idUsuarioTest = 1L;
    String paisTest = "paisTest";
    String ciudadTest = "ciudadTest";
    String lugarTest = "lugarTest";

    ConciertoBean sut;

    @Before
    public void setUp() throws Exception {

        try {

            sut = new ConciertoBean(paisTest,ciudadTest,lugarTest,idUsuarioTest);
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

        String paisActual = sut.getPais();
        assertEquals(paisTest,paisActual);

        String ciudadActual = sut.getCiudad();
        assertEquals(ciudadTest,ciudadActual);

        String lugarActual = sut.getLugar();
        assertEquals(lugarTest,lugarActual);

        Long idUsuarioActual = sut.getIdUsuario();
        assertEquals(idUsuarioTest,idUsuarioActual);

    }

    @Test
    public void shouldSetTheNewAttributesWhenCallingSetters(){

        Long nuevoId = 2L;
        sut.setId(nuevoId);
        assertEquals(nuevoId,sut.getId());

        String nuevoPais = "nuevoPais";
        sut.setPais(nuevoPais);
        assertEquals(nuevoPais,sut.getPais());

        String nuevaCiudad = "nuevaCiudad";
        sut.setCiudad(nuevaCiudad);
        assertEquals(nuevaCiudad,sut.getCiudad());

        String nuevoLugar = "nuevoLugar";
        sut.setLugar(nuevoLugar);
        assertEquals(nuevoLugar,sut.getLugar());

        Long nuevoIdUsuario = 2L;
        sut.setIdUsuario(nuevoIdUsuario);
        assertEquals(nuevoIdUsuario,sut.getIdUsuario());

    }
}
