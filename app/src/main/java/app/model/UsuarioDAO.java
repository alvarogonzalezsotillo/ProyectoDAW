package app.model;

import app.beans.UsuarioBean;
import app.model.interfaces.DAO;
import org.hibernate.Query;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "usuarioDao")
@ApplicationScoped
public class UsuarioDAO extends SessionFactoryImpl implements Serializable,DAO<UsuarioBean> {

    private static final long serialVersionUID = 1L;

    public UsuarioDAO() {
        super();
    }


    public void insert(UsuarioBean usuario) {

        session.save(usuario);

    }


    public void update(UsuarioBean usuarioToUpdate) {

        session.update(usuarioToUpdate);

    }


    public void deleteById(Long id) {

        UsuarioBean usuarioToDelete = session.load(UsuarioBean.class, id);
        session.delete(usuarioToDelete);

    }


    @SuppressWarnings("unchecked")
    public UsuarioBean getById(Long id) {

        List<UsuarioBean> listUsuarios;

        Query query = session.createQuery("from UsuarioBean usuario where usuario.id = :id");
        query.setParameter("id", id);
        listUsuarios = query.list();
        return listUsuarios.get(0);
    }


    @SuppressWarnings("unchecked")
    public List<UsuarioBean> getAll() {

        List<UsuarioBean> listUsuarios;

        Query query = session.createQuery("from UsuarioBean");
        listUsuarios = query.list();
        return listUsuarios;
    }

    @SuppressWarnings("unchecked")
    public List<String> getAllNicks() {

        List<String> listNicks;

        Query query = session.createQuery("select nickDeUsuario from UsuarioBean");
        listNicks = query.list();
        return listNicks;
    }

    public boolean loginUsuario(String nick, String passwordHashed) {

        boolean checked = false;

        List<UsuarioBean> listUsuarios;

        Query query = session.createQuery("from UsuarioBean usuario where usuario.nickDeUsuario = :nick and usuario.passwordDeUsuario = :passwordHashed");
        query.setParameter("nick", nick);
        query.setParameter("passwordHashed", passwordHashed);

        listUsuarios = query.list();

        if (listUsuarios.size() == 1) {

            checked = true;

        }

        return checked;

    }

    public Long getUserId(String nick){

        Query query = session.createQuery("from UsuarioBean usuario where usuario.nickDeUsuario = :nick");
        query.setParameter("nick", nick);

        List<UsuarioBean> list = query.list();

        return list.get(0).getId();

    }

    public UsuarioBean getByNick(String nick) {

        Query query = session.createQuery("from UsuarioBean usuario where usuario.nickDeUsuario = :nick");
        query.setParameter("nick", nick);

        List<UsuarioBean> list = query.list();

        return list.get(0);

    }

    public void seguirNuevoUsuario(Long idToFollow, Long idFollower){

        Query query = session.createSQLQuery("insert into BETAfollowers (idUsuario,idFollower) values (:idToFollow, :idFollower)");
        query.setParameter("idToFollow", idToFollow);
        query.setParameter("idFollower", idFollower);
        query.executeUpdate();
    }

    public List<Long> getFollowedUsers(Long idFollower) {

        Query query = session.createQuery("select followers.idUsuario from FollowerBean followers where followers.idFollower = :idFollower");
        query.setParameter("idFollower", idFollower);

        List<Long> list = query.list();

        return list;

    }
}
