package br.com.adsddm.pedidovenda.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.gson.annotations.Expose;

@Entity
public class ItemPedidoVenda implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JsonBackReference
	private PedidoVenda pedidovenda;
	@ManyToOne
	private Produto produto;
	private int qtd;
	
	public ItemPedidoVenda() {
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public PedidoVenda getPedidovenda() {
		return this.pedidovenda;
	}

	public void setPedidovenda(PedidoVenda pedidovenda) {
		this.pedidovenda = pedidovenda;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}