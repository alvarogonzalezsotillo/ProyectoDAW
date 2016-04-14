package app.beans.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.beans.imp.UsuarioImp;
import app.builder.UsuarioBuilder;
import app.controller.Util;

public class UsuarioBuilderTest {
    
    UsuarioBuilder sut;
    UsuarioBuilder returned;
    UsuarioImp usuarioTest;
    
    String nombreTest = "nombreTest";
    String apellidoTest = "apellidoTest";
    String nickTest = "nickTest";
    String correoTest;
    String tipoMusicaTest;
    String grupoTest;
    String webTest;
    String passwordTest = "passwordTest";
    String salt = Util.getSalt();


    @Before
    public void setUp() throws Exception {
        
        try {

            sut = new UsuarioBuilder();
            
            
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
    public void testUsuarioBuilder(){
        
        UsuarioBuilder uBTest = new UsuarioBuilder(nombreTest,apellidoTest,nickTest,passwordTest);
        
        assertNotNull(uBTest);
        
    }

    @Test
    public void shouldSetAllUsuarioAttributesReturnTheUsuarioBuilderOnEachOneAndBuildNewUsusario() {
        
        returned = sut.nombre(nombreTest);
        assertSame(sut, returned);
        
        returned = sut.apellido(apellidoTest);
        assertSame(sut, returned);
        
        returned = sut.nick(nickTest);
        assertSame(sut, returned);
        
        returned = sut.password(passwordTest);
        assertSame(sut, returned);
        
        returned = sut.correo(correoTest);
        assertSame(sut, returned);
        
        returned = sut.grupo(grupoTest);
        assertSame(sut, returned);
        
        returned = sut.tipoMusica(tipoMusicaTest);
        assertSame(sut, returned);
        
        returned = sut.web(webTest);
        assertSame(sut, returned);
        
        usuarioTest = sut.build();
        assertNotNull(usuarioTest);
        
        assertEquals(nombreTest,usuarioTest.getNombreDeUsuario());
        assertEquals(apellidoTest,usuarioTest.getApellidoDeUsuario());
        assertEquals(nickTest,usuarioTest.getNickDeUsuario());
        assertEquals(correoTest,usuarioTest.getCorreoDeUsuario());
        assertEquals(grupoTest,usuarioTest.getGrupoDeUsuario());
        assertEquals(tipoMusicaTest,usuarioTest.getTipoMusicaDeUsuario());
        assertEquals(webTest,usuarioTest.getWebDeUsuario());
        
        String salt = Util.getSalt();
        
        assertEquals(Util.hashPasswordSHA(passwordTest + salt),usuarioTest.getPasswordDeUsuario());
        
    }
}
