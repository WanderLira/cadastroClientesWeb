package services;

import javax.persistence.EntityManager;

import daos.UsuarioDAO;
import entities.Usuario;

public class UsuarioService extends AbstractService {

	public static Usuario efetuarLogin(String login, String senha){
		EntityManager manager = fac.createEntityManager();
		UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
		return usuarioDAO.efetuarLogin(login, senha);
	}
}
