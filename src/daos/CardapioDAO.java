package daos;

import javax.persistence.EntityManager;

import entities.Cardapio;

public class CardapioDAO extends AbstractDAO<Cardapio> {

	public CardapioDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Cardapio> entityClass() {
		return Cardapio.class;
	}

}
