package app.model;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.hibernate.Query;

import app.beans.implementations.UsuarioBean;

@ManagedBean(name = "usuarioDao")
@ApplicationScoped
public class UsuarioDAO extends BaseDaoHibernate implements Serializable {

    private static final long serialVersionUID = 1L;

    public UsuarioDAO() {
        super();
    }

    public void insertUsuario(UsuarioBean usuario) {

        session = factory.openSession();
        transaction = session.beginTransaction();
        session.save(usuario);
        transaction.commit();

    }

    @SuppressWarnings("unchecked")
    public List<UsuarioBean> getAllUsuarios() {

        List<UsuarioBean> listUsuarios;

        session = factory.openSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("from UsuarioBean");
        listUsuarios = query.list();
        transaction.commit();
        return listUsuarios;
    }

    @SuppressWarnings("unchecked")
    public List<String> getAllNicks() {

        List<String> listNicks;

        session = factory.openSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("select nickDeUsuario from UsuarioBean");
        listNicks = query.list();
        transaction.commit();
        return listNicks;
    }

    @SuppressWarnings("unchecked")
    public UsuarioBean getUsuarioById(Long id) {

        List<UsuarioBean> listUsuarios;

        session = factory.openSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("from UsuarioBean usuario where usuario.id = :id");
        query.setParameter("id", id);
        listUsuarios = query.list();
        transaction.commit();
        return listUsuarios.get(0);
    }

    public void deleteUsuarioById(Long id) {

        session = factory.openSession();
        transaction = session.beginTransaction();
        UsuarioBean usuarioToDelete = session.load(UsuarioBean.class, id);
        session.delete(usuarioToDelete);
        transaction.commit();

    }

    public void updateUsuario(UsuarioBean usuarioToUpdate) {

        session = factory.openSession();
        transaction = session.beginTransaction();
        session.update(usuarioToUpdate);
        transaction.commit();

    }

    public boolean loginUsuario(String nick,String passwordHashed){

        boolean checked=false;

        List<UsuarioBean> listUsuarios;

        session = factory.openSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("from UsuarioBean usuario where usuario.nickDeUsuario = :nick and usuario.passwordDeUsuario = :passwordHashed");
        query.setParameter("nick", nick);
        query.setParameter("passwordHashed", passwordHashed);

        listUsuarios = query.list();

        if(listUsuarios.size() == 1){

            checked = true;

        }

        return checked;

    }

    public void closeSession(){

        this.session.close();

    }

}
