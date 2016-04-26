package app.model.test;

import app.helpers.HibernateHelper;
import app.model.DAOImpl;
import org.hibernate.Session;
import org.junit.After;

public class BaseIT<C extends DAOImpl> {

    protected C sut;
    private Session session;

//    @BeforeClass
//    public static void tearUp(){
//
//        try {
//
//            sut.setSession(HibernateHelper.initSession());
//            HibernateHelper.initTransaction();
//
////          usuarioTest.setNombreDeUsuario("NombreTest");
////          usuarioTest.setPasswordDeUsuario("pass");
////          sut.insertUsuario(usuarioTest);
////
////            usuarioParaLog.setNickDeUsuario("nickTest");
////            usuarioParaLog.setPasswordDeUsuario("passTest");
////            sut.insertUsuario(usuarioParaLog);
//
//            HibernateHelper.commit();
//
//
//        }
//
//        catch (ExceptionInInitializerError e) {
//
//            throw new ExceptionInInitializerError("No se ha podido inicializar el SUT" + e);
//
//        }
//
//    }
//
//    @AfterClass
//    public static void tearDown() throws Exception {
//
//        sut = null;
//
//
//    }

    public void open() {

        session = HibernateHelper.initSession();
        sut.setSession(session);
        HibernateHelper.initTransaction(session);

    }

    @After
    public void close() {

        HibernateHelper.commitAndCloseSession(session);

    }

}