package app.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BaseDaoHibernate {

    public SessionFactory factory = new Configuration().configure().buildSessionFactory();
    public Session session = factory.openSession();
    public Transaction transaction = null;

}
