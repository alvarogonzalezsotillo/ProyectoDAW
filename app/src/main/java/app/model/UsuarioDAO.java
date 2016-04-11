package app.model;

import app.beans.imp.UsuarioImp;

public class UsuarioDAO extends BaseDaoHibernate {

	public UsuarioDAO() {
		super();
	}
	
	public void insertUsuario(UsuarioImp usuario){
		
		session.save(usuario);
		transaction.commit();
		
	}

}
