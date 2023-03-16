package br.com.fiap.fintech.conta;
import java.util.UUID;
import java.util.Date;

public class Movimentacoes {
	public UUID id = UUID.randomUUID();
	public String tipo;
	public String descricao;
	public Date dtVigencia;
	public double vlMovimentacao;
	private Conta conta;
	private Categoria categoria;
	public Date dtCriacao = new Date();
	public Date dtAtualizacao = new Date();
	
	public Movimentacoes(String tipo, String descricao, Date dtVigencia, double vlMovimentacao, Conta conta, Categoria categoria) throws Exception{
		if (conta.isActive()) {
			this.tipo = tipo; 
			this.descricao = descricao;
			this.dtVigencia = dtVigencia;
			this.vlMovimentacao = vlMovimentacao;
			this.conta = conta;
			this.categoria = categoria;
		} else {
			throw new Exception("Criacao invalida, verifique o status da conta");
		}
		
	}
	
	public Movimentacoes update(String tipo, String descricao, Date dtVigencia, double vlMovimentacao) throws Exception{
		if (this.conta.isActive()) {
			this.tipo = tipo; 
			this.descricao = descricao;
			this.dtVigencia = dtVigencia;
			this.vlMovimentacao = vlMovimentacao;
			this.dtAtualizacao = new Date();
			return this;
		} else {
			throw new Exception("Atualizacao invalida, conta nao esta ativa");
		}
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Conta getConta() {
		return conta;
	}
	
}
