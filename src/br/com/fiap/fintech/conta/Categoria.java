package br.com.fiap.fintech.conta;

import java.util.UUID;

public class Categoria {
	private UUID id = UUID.randomUUID();
	private String nmCategoria;
	
	public Categoria(String nmCategoria) {
		this.nmCategoria = nmCategoria;
	}
	
	public Categoria(UUID id, String nmCategoria) {
		this.nmCategoria = nmCategoria;
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNmCategoria() {
		return nmCategoria;
	}

	public void setNmCategoria(String nmCategoria) {
		this.nmCategoria = nmCategoria;
	}
	
}
