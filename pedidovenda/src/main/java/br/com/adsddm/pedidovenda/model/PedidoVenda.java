package br.com.adsddm.pedidovenda.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the pedidovenda database table.
 * 
 */
@Entity
@NamedQuery(name="Pedidovenda.findAll", query="SELECT p FROM PedidoVenda p")
public class PedidoVenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pedidovenda_id")
	private Integer id;
	@OneToMany(mappedBy="pedidovenda", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ItemPedidoVenda> itempedidovendas = new ArrayList<>();
	@ManyToOne
	private Cliente cliente;

	public PedidoVenda() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ItemPedidoVenda> getItempedidovendas() {
		return this.itempedidovendas;
	}

	public void setItempedidovendas(List<ItemPedidoVenda> itempedidovendas) {
		this.itempedidovendas = itempedidovendas;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}