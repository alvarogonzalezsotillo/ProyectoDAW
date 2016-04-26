package app.model;

import org.hibernate.Session;

public interface DAO {

     Session getSession();

     void setSession(Session session);

}
