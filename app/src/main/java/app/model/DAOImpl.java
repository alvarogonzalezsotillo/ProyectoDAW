package app.model;

import org.hibernate.Session;

public class DAOImpl extends BaseDaoHibernate implements DAO {

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
