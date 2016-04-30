package services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import daos.CardapioDAO;
import entities.Cardapio;

public class CardapioService extends AbstractService {

	public static void inserir(Cardapio cardapio) {

		EntityManager manager = fac.createEntityManager();

		try {
			CardapioDAO cardapioDAO = new CardapioDAO(manager);
			manager.getTransaction().begin();
			cardapioDAO.inserir(cardapio);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public static void atualizar(Cardapio cardapio) {

		EntityManager manager = fac.createEntityManager();

		try {
			CardapioDAO cardapioDAO = new CardapioDAO(manager);
			manager.getTransaction().begin();
			cardapioDAO.atualizar(cardapio);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public static List<Cardapio> listar() {
		EntityManager manager = fac.createEntityManager();
		List<Cardapio> cardapios = new ArrayList<Cardapio>();
		try {
			CardapioDAO cardapioDAO = new CardapioDAO(manager);
			cardapios = cardapioDAO.listar();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return cardapios;
	}

	public static void remover(Cardapio cardapio) {
		EntityManager manager = fac.createEntityManager();

		try {
			CardapioDAO cardapioDAO = new CardapioDAO(manager);
			manager.getTransaction().begin();
			cardapioDAO.remover(cardapio);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

	}

	public static Cardapio buscarPorId(Long id) {
		EntityManager manager = fac.createEntityManager();
		Cardapio cardapio = new Cardapio();
		try {
			CardapioDAO cardapioDAO = new CardapioDAO(manager);
			cardapio = cardapioDAO.buscarPorId(id);
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return cardapio;
	}

}
