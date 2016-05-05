package app.model;

import app.beans.ConciertoBean;
import app.model.interfaces.DAO;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

public class ConciertoDAO extends SessionFactoryImpl implements Serializable, DAO<ConciertoBean> {

    @Override
    public void insert(ConciertoBean conciertoBean) {

        session.save(conciertoBean);
    }

    @Override
    public void update(ConciertoBean conciertoBean) {

        session.update(conciertoBean);
    }

    @Override
    public void deleteById(Long id) {
        ConciertoBean conciertoToDelete = session.load(ConciertoBean.class, id);
        session.delete(conciertoToDelete);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ConciertoBean getById(Long id) {

        List<ConciertoBean> listaConciertos;
        Query query = session.createQuery("from ConciertoBean concierto where concierto.id = :id");
        query.setParameter("id",id);
        listaConciertos = query.list();
        return listaConciertos.get(0);
    }

    @Override
    public List<ConciertoBean> getAll() {

        List<ConciertoBean> listaConciertos;
        Query query = session.createQuery("from ConciertoBean concierto");
        listaConciertos = query.list();
        return listaConciertos;
    }
}
