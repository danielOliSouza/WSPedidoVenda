package br.com.adsddm.pedidovenda.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.adsddm.pedidovenda.model.Cliente;
import br.com.adsddm.pedidovenda.model.ItemPedidoVenda;
import br.com.adsddm.pedidovenda.model.PedidoVenda;
import br.com.adsddm.pedidovenda.model.Produto;
import br.com.adsddm.pedidovenda.model.ProdutoAdapter;
import br.com.adsddm.pedidovenda.repository.Clientes;
import br.com.adsddm.pedidovenda.repository.PedidoVendas;
import br.com.adsddm.pedidovenda.repository.Produtos;
import br.com.adsddm.pedidovenda.util.Transactional;

public class PedidoVendaServices {
	private PedidoVendas pedidoVendas;
	private Clientes clientes;
	private Produtos produtos;
	private ObjectMapper mapper;
	
	public PedidoVendaServices() {
		pedidoVendas = new PedidoVendas();
		clientes = new Clientes();
		mapper = new ObjectMapper();
		produtos = new Produtos();
	}
	//Format JSON json="{\"pedidovenda\": {\"idcliente\":1,\"items\":[{\"idproduto\": 1, \"qtd\":01},{\"idproduto\": 2, \"qtd\":01}]}}";
	
	public void salvar(String json) {
		PedidoVenda pedidoVenda = new PedidoVenda();
		
		
		try {
			JSONObject root = new JSONObject(json);
			int idCliente =root.getJSONObject("pedidovenda").getInt("idcliente");
			JSONArray jItems = root.getJSONObject("pedidovenda").getJSONArray("items");
			
			pedidoVenda.setCliente(clientes.findCliente(idCliente));
			for(int i=0; i < jItems.length(); i++ ){
				ItemPedidoVenda item = new ItemPedidoVenda();
				item.setQtd(jItems.getJSONObject(i).getInt("qtd"));
				item.setProduto(produtos.findProduto(jItems.getJSONObject(i).getInt("idproduto")));
				item.setPedidovenda(pedidoVenda);
				pedidoVenda.getItempedidovendas().add(item);
			}
			
			pedidoVendas.guardar(pedidoVenda);
		} catch (Exception e) {
			System.out.println(e.getMessage() + " - " + json);
		}
		
		
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
