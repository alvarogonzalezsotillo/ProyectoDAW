package app.model;

import app.model.interfaces.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionFactoryImpl implements SessionFactory {

    protected Session session;

    @Override
    public Session getSession() {
        return session;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

}
