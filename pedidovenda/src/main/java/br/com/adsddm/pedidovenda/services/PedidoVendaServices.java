package br.com.adsddm.pedidovenda.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import br.com.adsddm.pedidovenda.model.ItemPedidoVenda;
import br.com.adsddm.pedidovenda.model.PedidoVenda;
import br.com.adsddm.pedidovenda.model.Produto;
import br.com.adsddm.pedidovenda.model.ProdutoAdapter;
import br.com.adsddm.pedidovenda.repository.Clientes;
import br.com.adsddm.pedidovenda.repository.PedidoVendas;

public class PedidoVendaServices {
	private PedidoVendas pedidoVendas;
	private Clientes clientes;
	private Gson gson;
	private ObjectMapper mapper;
	public PedidoVendaServices() {
		pedidoVendas = new PedidoVendas();
		mapper = new ObjectMapper();
	}
	
	public void salvar(String json) {
		PedidoVenda pedidoVenda = null;
		try {
			pedidoVenda = mapper.readValue(json, PedidoVenda.class);
		} catch (Exception e){
			e.printStackTrace();
		}
		pedidoVendas.guardar(pedidoVenda);
	}
	
	
	public String exemploJson(){
		String jsonResult = "{}";
		try {
			jsonResult = mapper.writeValueAsString((pedidoVendas.find(01)));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonResult;
	}
}
