package app.model.test;

import app.beans.implementations.ConciertoBean;
import app.model.ConciertoDAO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConciertoDAOIT extends BaseIT<ConciertoDAO>{

    @Before
    public void setUp(){
        sut = new ConciertoDAO();
        open();
    }

    @Test
    public void shouldReturnAllMelomsInsertedWhenCallingGetAll() {

        assertEquals(2, sut.getAll().size());

    }

    @Test
    public void shouldReturnTheMelomIdentifiedByIdWhenCallingGetById() {

        ConciertoBean conciertoReturned = sut.getById(1L);
        assertEquals("lugarTest", conciertoReturned.getLugar());

    }

    @Test
    public void shouldUpdateTheMelomWhenCallingUpdate() {

        ConciertoBean conciertoReturned = sut.getById(1L);
        conciertoReturned.setCiudad("ciudadTestNueva");
        assertNotNull(conciertoReturned.getCiudad());
        sut.update(conciertoReturned);
        assertEquals("ciudadTestNueva", sut.getById(1L).getCiudad());

    }

    @Test
    public void shouldDeleteTheMelomIdentifiedByIdWhenCallingDeleteById(){

        sut.deleteById(2L);
        assertEquals(1, sut.getAll().size());

    }
}
