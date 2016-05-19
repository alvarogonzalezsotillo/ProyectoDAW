package app.model;

import app.beans.FollowerBean;
import app.model.interfaces.DAO;

import java.util.List;

public class FollowerDAO extends SessionFactoryImpl implements DAO<FollowerBean> {

    public void insert(FollowerBean follower) {
        session.save(follower);
    }

    public void deleteById(Long id) {
        FollowerBean followerToDelete = session.load(FollowerBean.class, id);
        session.delete(followerToDelete);
    }

    public void update(FollowerBean follower) {
        //Do nothing
    }

    public FollowerBean getById(Long id) {
        return null;
    }

    public List<FollowerBean> getAll() {
        return null;
    }
}
