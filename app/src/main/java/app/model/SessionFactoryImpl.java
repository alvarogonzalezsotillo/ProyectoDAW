package app.model;

import app.model.interfaces.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionFactoryImpl implements SessionFactory {

    protected org.hibernate.SessionFactory factory = new Configuration().configure().buildSessionFactory();
    protected Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

}
