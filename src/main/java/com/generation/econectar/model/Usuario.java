package com.generation.econectar.model;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Schema(example = "email@email.com.br")
	@NotBlank(message = "O nome do usuário é obrigatório!")
	@Email(message = "O atributo email é obrigatório")
	@Size(min = 1, max = 255, message = "O nome do usuário deve conter no mínimo 1 e no máximo 255 caracteres")
	private String usuario;
	
	@NotNull(message = "O nome é obrigatório!")
	private String nome;
	
	@NotBlank(message = "A senha é obrigatória!")
	@Size(min = 7, max = 64, message = "A senha deve conter no mínimo 7 e no máximo 64 caracteres")
	private String senha;
	
	@NotBlank(message = "O endereço é obrigatório!")
	@Size(min = 1, max = 255, message = "O endereço deve conter no mínimo 1 e no máximo 255 caracteres")
	private String endereco;
	
	@NotBlank(message = "O CPF é obrigatório!")
	@Size(min = 11, max = 11, message = "O CPF deve conter 11 caracteres")
	private String cpf;
	
	@NotNull(message = "a data de nascimento é obrigatório!")
	private LocalDate dataNascimento;
	
	@NotBlank(message = "a Foto é obrigatório!")
	@Size(min = 1, max = 255, message = "A foto deve conter no mínimo 1 e no máximo 255 caracteres")
	private String foto;
	
	@OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"vendedor"})
	private Set<Servico> ServicosVendidos;
	
	@OneToMany(mappedBy = "comprador", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"comprador"})
	private Set<Servico> ServicosComprados;

	public Usuario(Long id, String usuario, String nome, String senha, String endereco, String cpf, LocalDate dataNascimento, String foto, Set<Servico> servicosVendidos, Set<Servico> servicosComprados) {
		this.id = id;
		this.usuario = usuario;
		this.nome = nome;
		this.senha = senha;
		this.endereco = endereco;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.foto = foto;
		ServicosVendidos = servicosVendidos;
		ServicosComprados = servicosComprados;
	}

	public Usuario() { }

	public Set<Servico> getServicosVendidos() {
		return ServicosVendidos;
	}

	public void setServicosVendidos(Set<Servico> servicosVendidos) {
		ServicosVendidos = servicosVendidos;
	}

	public Set<Servico> getServicosComprados() {
		return ServicosComprados;
	}

	public void setServicosComprados(Set<Servico> servicosComprados) {
		ServicosComprados = servicosComprados;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	
	
}