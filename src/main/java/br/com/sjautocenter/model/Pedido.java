package br.com.sjautocenter.model;

import java.sql.Date;

public class Pedido {
	// Long -> 2
	// long -> 2
	// double -> 2.0
	// int -> 4M
	private Long id;
	private String nome;
	private String modelo;
	private String placa;
	private String descricao;
	private Date data;
	private String status; // 0 -> Aberto, 1 -> em andamento, 2 -> Concluido

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
