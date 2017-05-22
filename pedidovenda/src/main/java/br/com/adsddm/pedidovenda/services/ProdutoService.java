package br.com.adsddm.pedidovenda.services;

import com.google.gson.Gson;

import br.com.adsddm.pedidovenda.repository.Produtos;
import br.com.adsddm.pedidovenda.util.Transactional;

public class ProdutoService {
	private Produtos produtos;
	public ProdutoService() {
		produtos = new Produtos();
	}
	@Transactional
	public String todosProdutosJSON(){
		return new Gson().toJson(produtos.todosProdutos());
	}
}
