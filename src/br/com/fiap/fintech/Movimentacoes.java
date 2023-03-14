package br.com.fiap.fintech;
import java.util.UUID;
import java.util.Date;

public class Movimentacoes {
	public UUID id = UUID.randomUUID();
	public String tipo;
	public String descricao;
	public Date dtVigencia;
	public double vlMovimentacao;
	public Date dtCriacao = new Date();
	public Date dtAtualizacao = new Date();
	
	public Movimentacoes(String tipo, String descricao, Date dtVigencia, double vlMovimentacao) {
		this.tipo = tipo; 
		this.descricao = descricao;
		this.dtVigencia = dtVigencia;
		this.vlMovimentacao = vlMovimentacao;
	}
	
	public Movimentacoes update(String tipo, String descricao, Date dtVigencia, double vlMovimentacao) {
		this.tipo = tipo; 
		this.descricao = descricao;
		this.dtVigencia = dtVigencia;
		this.vlMovimentacao = vlMovimentacao;
		this.dtAtualizacao = new Date();
		return this;
	}
	
}
