package app.model.test;

import app.beans.MelomBean;
import app.model.MelomDAO;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    public void shoulReturnAllMelomsFilterByListIdUsuarioWhenCallingGetAllByIdUsuario(){

        Collection<Long> listaId = new ArrayList<Long>();
        listaId.add(1L);
        assertEquals(2,sut.getAllByIdUsuario(listaId).size());

    }

    /*@Test
    public void shouldReturnAllMelomsFilterByIdUsuarioWhenCallingGetAllMelomsByIdFollower(){

        Collection<MelomBean> listMelomFilterByIdFollower;
        listMelomFilterByIdFollower = sut.getAllMelomsByIdFollower(2L);
        MelomBean melomReturned = sut.getById(1L);
        MelomBean melomReturned2 = sut.getById(2L);
        assertNotNull(listMelomFilterByIdFollower);
    }*/

    @Test
    public void shouldZDeleteTheMelomIdentifiedByIdWhenCallingDeleteById(){

        sut.deleteById(2L);
        assertEquals(1, sut.getAll().size());

    }

}
