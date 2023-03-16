package br.com.fiap.fintech.conta;

import java.util.Date;
import java.util.UUID;

public class Categoria {
	public UUID id = UUID.randomUUID();
	public String nmCategoria;
	public Date dtCriacao = new Date();
	public Date dtAtualizacao = new Date();
	
	public Categoria(String nmCategoria) {
		this.nmCategoria = nmCategoria;
	}
	
	public Categoria atualizar(String nmCategoria) {
		this.nmCategoria = nmCategoria;
		this.dtAtualizacao = new Date();
		return this;
	}
}
