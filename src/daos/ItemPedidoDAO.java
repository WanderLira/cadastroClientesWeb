package daos;

import javax.persistence.EntityManager;

import entities.ItemPedido;

public class ItemPedidoDAO extends AbstractDAO<ItemPedido>{

	public ItemPedidoDAO(EntityManager manager) {
		super(manager);
	}
	
	@Override
	public Class<ItemPedido> entityClass() {
		return ItemPedido.class;
	}

}
