package app.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DAOImpl implements DAO {

    protected SessionFactory factory = new Configuration().configure().buildSessionFactory();
    protected Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
