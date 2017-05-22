package br.com.adsddm.pedidovenda.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.adsddm.pedidovenda.model.Produto;
import br.com.adsddm.pedidovenda.util.EntityManagerProducer;

public class Produtos {
	EntityManager manager;
	
	public Produtos() {
		manager = EntityManagerProducer.createEntityManager();
	}
	
	public List<Produto> todosProdutos(){
		return manager.createQuery("FROM Produto", Produto.class).getResultList();
	}

	public Produto findProduto(long id) {
		return manager.find(Produto.class, id);
	}
}
