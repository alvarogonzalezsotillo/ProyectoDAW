package app.model;

import org.hibernate.Session;

public interface SessionFactory {

     Session getSession();

     void setSession(Session session);

}
