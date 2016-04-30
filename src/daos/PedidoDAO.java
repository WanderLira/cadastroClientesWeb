package daos;

import javax.persistence.EntityManager;

import entities.Pedido;

public class PedidoDAO extends AbstractDAO<Pedido>{

	public PedidoDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Pedido> entityClass() {
		return Pedido.class;
	}

}
