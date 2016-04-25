package app.helpers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {

    private final static SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private static Session session;
    private static Transaction transaction;

    public static Session getSession() {

        session = factory.openSession();

        return session;
    }

    public static void beginTransaction() {

        transaction = session.beginTransaction();
    }

    public static void commit() {

        transaction.commit();

    }

    public static void rollback() {

        transaction.rollback();

    }

    public static void closeSession() {

        session.close();

    }


}
