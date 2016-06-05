package app.model.test;

import app.model.SessionFactoryImpl;
import app.utils.UtilSessionHibernate;
import org.hibernate.Session;
import org.junit.After;

public class BaseIT<C extends SessionFactoryImpl> {

    protected C sut;
    private Session session;

    public void open() {

        session = UtilSessionHibernate.initSession();
        sut.setSession(session);
        UtilSessionHibernate.initTransaction(session);

    }

    @After
    public void close() {

        UtilSessionHibernate.commitAndCloseSession(session);

    }

}
