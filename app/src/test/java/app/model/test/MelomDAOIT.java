package app.model.test;

import app.beans.implementations.MelomBean;
import app.model.MelomDAO;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MelomDAOIT extends BaseIT<MelomDAO>{

    @Before
    public void setUp(){
        sut = new MelomDAO();
        open();
    }

    @Test
    public void shouldReturnAllMelomsInsertedWhenCallingGetAll() {

        assertEquals(2, sut.getAll().size());

    }

    @Test
    public void shouldReturnTheMelomIdentifiedByIdWhenCallingGetById() {

        MelomBean melomReturned = sut.getById(1L);
        assertEquals("tituloTest", melomReturned.getTitulo());

    }

    @Test
    public void shouldUpdateTheMelomWhenCallingUpdate() {

        MelomBean melomReturned = sut.getById(1L);
        melomReturned.setTitulo("tituloTestNuevo");
        assertNotNull(melomReturned.getTitulo());
        sut.update(melomReturned);
        assertEquals("tituloTestNuevo", sut.getById(1L).getTitulo());

    }

    @Test
    public void shoulReturnAllMelomsFilterByIdUsuarioWhenCallingGetAllByIdUsuario(){

        assertEquals(2,sut.getAllByIdUsuario(1L).size());

    }

    @Test
    public void shouldDeleteTheMelomIdentifiedByIdWhenCallingDeleteById(){

        sut.deleteById(2L);
        assertEquals(1, sut.getAll().size());

    }

}
