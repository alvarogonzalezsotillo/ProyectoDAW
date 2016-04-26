package app.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UtilSessionHibernate {

    private final static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public static Session initSession() {

        return factory.openSession();

    }

    public static Transaction initTransaction(Session session) {

        return session.beginTransaction();

    }

    public static void commit(Transaction transaction) {

        transaction.commit();

    }

    public static void rollback(Transaction transaction) {

        transaction.rollback();

    }

    public static void closeSession(Session session) {

        session.close();

    }

    public static void commitAndCloseSession(Session session){
        session.getTransaction().commit();
        session.close();
    }

}
