package daos;

import javax.persistence.EntityManager;

import entities.PessoaJuridica;

public class PessoaJuridicaDAO extends AbstractDAO<PessoaJuridica>{

	public PessoaJuridicaDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<PessoaJuridica> entityClass() {
		return PessoaJuridica.class;
	}

}
