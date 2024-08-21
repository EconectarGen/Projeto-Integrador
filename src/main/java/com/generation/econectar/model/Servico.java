package com.generation.econectar.model;



import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "tb_servico")
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nomeServico;
	
	
	private String descricao;
	
	private double valor;
	
	
	private String sobreMim;
	
	private String status;
	
	@ManyToOne
	@JsonIgnore
	private Usuario vendedor;
	
	@ManyToOne
    @JsonIgnore
	private Usuario comprador;
	
	@ManyToOne
	
	private Categoria categoria;
	

	


	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	public Usuario getComprador() {
		return comprador;
	}

	public void setComprador(Usuario comprador) {
		this.comprador = comprador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getSobreMim() {
		return sobreMim;
	}

	public void setSobreMim(String sobreMim) {
		this.sobreMim = sobreMim;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
