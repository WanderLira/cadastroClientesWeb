package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import daos.ItemPedidoDAO;
import daos.PedidoDAO;
import entities.ItemPedido;
import entities.Pedido;

public class PedidoService extends AbstractService{
	
	
	
	public  static void inserir(Pedido pedido) {
		
		EntityManager  manager =  fac.createEntityManager();
		
		try{
			PedidoDAO pedidoDAO = new PedidoDAO(manager);
			ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO(manager);
			
			for(ItemPedido itemPedido:pedido.getItensPedido()){
				if(itemPedido.getCardapio() == null ){
					throw new Exception("Item sem cardápio");
				}
				itemPedidoDAO.inserir(itemPedido);
			}
			pedidoDAO.inserir(pedido);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	}
	
	public  static void remove(Pedido pedido) {
		
		EntityManager  manager =  fac.createEntityManager();
		
		try{
			PedidoDAO pedidoDAO = new PedidoDAO(manager);
			ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO(manager);
			
			for(ItemPedido itemPedido:pedido.getItensPedido()){
				itemPedidoDAO.remover(itemPedido);
			}
			pedidoDAO.remover(pedido);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	}

}
