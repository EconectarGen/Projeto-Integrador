package com.generation.econectar.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Size(min = 1, max = 255, message = "O nome da categoria deve conter no mínimo 1 e no máximo 255 caracteres")
	private String nomeCategoria;
	
	
	@Size(min = 1, max = 1000, message = "A descrição deve conter no mínimo 1 e no máximo 1000 caracteres")
	private String descricao;
	
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("categoria")
	private Set<Servico> servico;

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public Set<Servico> getServiço() {
		return servico;
	}

	public void setServiço(Set<Servico> servico) {
		this.servico = servico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
