package app.model;

import java.io.Serializable;

import app.beans.imp.UsuarioImp;

public class UsuarioDAO extends BaseDaoHibernate implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public UsuarioDAO() {
        super();
    }

    public void insertUsuario(UsuarioImp usuario) {

        transaction = session.beginTransaction();
        session.save(usuario);
        transaction.commit();

    }

}
