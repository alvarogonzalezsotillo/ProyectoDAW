package app.model.test;


import app.beans.ComentarioBean;
import app.model.ComentarioDAO;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComentarioDAOIT extends BaseIT<ComentarioDAO>{

    @Before
    public void setUp(){
        sut = new ComentarioDAO();
        open();
    }

    @Test
    public void testShouldReturnAllComentariosInsertedWhenCallingGetAll() {

        assertEquals(2, sut.getAll().size());

    }


    @Test
    public void testShouldReturnTheComentarioIdentifiedByIdWhenCallingGetById() {

        ComentarioBean comentarioReturned = sut.getById(1L);
        assertEquals("textoTest", comentarioReturned.getTexto());

    }



    @Test
    public void testShouldUpdateTheUsuarioWhenCallingUpdateUsuario() {

        ComentarioBean comentarioReturned = sut.getById(1L);
        comentarioReturned.setTexto("nuevoTexto");
        assertNotNull(comentarioReturned.getTexto());
        sut.update(comentarioReturned);
        assertEquals("nuevoTexto", sut.getById(1L).getTexto());

    }

    @Test
    public void testShouldReturnAllComentariosFilterByIdUsuarioWhenCallingGetAllByIdUsuario(){

        assertEquals(2,sut.getAllByIdUsuario(1L).size());

    }

    @Test
    public void testShouldReturnAllComentariosFilterByIdMelomWhenCallingGetAllByIdMelom(){


        assertEquals(2,sut.getAllByIdMelom(1L).size());

    }

    @Test
    public void testZShouldDeleteTheComentarioIdentifiedByIdWhenCallingDeleteById(){

        sut.deleteById(2L);
        assertEquals(1, sut.getAll().size());

    }

}
