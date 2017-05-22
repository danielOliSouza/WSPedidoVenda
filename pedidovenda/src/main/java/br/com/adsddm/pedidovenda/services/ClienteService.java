package br.com.adsddm.pedidovenda.services;

import com.google.gson.Gson;

import br.com.adsddm.pedidovenda.repository.Clientes;
import br.com.adsddm.pedidovenda.util.Transactional;

public class ClienteService {
	private Clientes clientes;
	public ClienteService() {
		clientes = new Clientes();
	}
	@Transactional
	public String todosProdutosJSON() {
		return new Gson().toJson(clientes.todosClientes());
	}
	
}
