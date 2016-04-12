package app.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BaseDaoHibernate {
	
	public static final SessionFactory factory = new Configuration().configure().buildSessionFactory();
	public static final Session session = factory.openSession();
	public static final Transaction transaction  = session.beginTransaction();
	
}
