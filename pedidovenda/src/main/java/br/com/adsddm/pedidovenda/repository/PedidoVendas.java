package br.com.adsddm.pedidovenda.repository;

import javax.persistence.EntityManager;

import br.com.adsddm.pedidovenda.model.PedidoVenda;
import br.com.adsddm.pedidovenda.util.EntityManagerProducer;

public class PedidoVendas {
	private EntityManager manager = EntityManagerProducer.createEntityManager();

	public void guardar(PedidoVenda pedidoVenda) {
		manager.persist(pedidoVenda);
	}

	public PedidoVenda find(int i) {
		return manager.find(PedidoVenda.class, 1);
	}
	
}
