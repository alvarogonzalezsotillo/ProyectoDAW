package app.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BaseDaoHibernate {
	
	Session session;
	Transaction transaction;
	SessionFactory factory;
	
	public BaseDaoHibernate() {
		
		this.factory = new Configuration().configure().buildSessionFactory();
		this.session = factory.openSession();
		this.transaction = session.beginTransaction();
	}
	
	
	
}
