package app.model;

import app.model.interfaces.SessionFactory;
import org.hibernate.Session;

public class SessionFactoryImpl implements SessionFactory {

    protected Session session;


    public Session getSession() {
        return session;
    }


    public void setSession(Session session) {
        this.session = session;
    }

}
