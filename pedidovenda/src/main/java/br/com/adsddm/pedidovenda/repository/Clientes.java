package br.com.adsddm.pedidovenda.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.google.gson.Gson;

import br.com.adsddm.pedidovenda.model.Cliente;
import br.com.adsddm.pedidovenda.model.ItemPedidoVenda;
import br.com.adsddm.pedidovenda.model.PedidoVenda;
import br.com.adsddm.pedidovenda.util.EntityManagerProducer;

public class Clientes {
	EntityManager manager;
	
	public Clientes(){
		manager = EntityManagerProducer.createEntityManager();
	}
	public List<Cliente> todosClientes() {
		return manager.createQuery("FROM Cliente", Cliente.class).getResultList();
	}
	public Cliente findCliente(int id){
		return (Cliente) manager.find(Cliente.class, id);
	}
}
