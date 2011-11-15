package br.com.otavio.easybroker.bo;

import br.com.otavio.easybroker.dao.UsuarioDAO;
import br.com.otavio.easybroker.to.UsuarioTO;

public class LoginBO {
	
	public UsuarioTO login(String email, String senha){
		UsuarioDAO dao = new UsuarioDAO();
		
		try {
			UsuarioTO usuarioTO = dao.logar(email, senha);
			return usuarioTO;
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
}
