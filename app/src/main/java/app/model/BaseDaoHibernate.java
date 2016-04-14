package app.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BaseDaoHibernate {

    protected SessionFactory factory = new Configuration().configure().buildSessionFactory();
    protected Session session = null;
    protected Transaction transaction = null;

}
