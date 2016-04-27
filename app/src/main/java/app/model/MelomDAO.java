package app.model;

import app.beans.implementations.MelomBean;

import java.io.Serializable;
import java.util.List;

public class MelomDAO extends SessionFactoryImpl implements Serializable, DAO<MelomBean> {

    private static final long serialVersionUID = 1L;

    public MelomDAO() {

        super();
    }

    public void insert(MelomBean melomBean) {
        //TODO
    }

    public void update(MelomBean melomBean) {
        //TODO
    }

    public void deleteById(Long id) {
        //TODO
    }

    public MelomBean getById(Long id) {
        //TODO
        return null;
    }

    public List<MelomBean> getAll() {
        //TODO
        return null;
    }
}
