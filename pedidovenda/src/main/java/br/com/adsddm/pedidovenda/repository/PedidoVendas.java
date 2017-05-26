package br.com.adsddm.pedidovenda.repository;

import javax.persistence.EntityManager;

import br.com.adsddm.pedidovenda.model.PedidoVenda;
import br.com.adsddm.pedidovenda.util.EntityManagerProducer;
import br.com.adsddm.pedidovenda.util.Transactional;

public class PedidoVendas {
	private EntityManager manager = EntityManagerProducer.createEntityManager();
	
	@Transactional
	public void guardar(PedidoVenda pedidoVenda) {
		manager.getTransaction().begin();
		manager.persist(pedidoVenda);
		manager.getTransaction().commit();
	}

	public PedidoVenda find(int i) {
		return manager.find(PedidoVenda.class, 1);
	}
	
}
