package app.model.interfaces;

import org.hibernate.Session;

public interface SessionFactory {

     Session getSession();

     void setSession(Session session);

}
