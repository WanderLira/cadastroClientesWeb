package daos;

import javax.persistence.EntityManager;

import entities.Cliente;

public class ClienteDAO extends AbstractDAO<Cliente> {

	public ClienteDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Cliente> entityClass() {
		return Cliente.class;
	}

}
