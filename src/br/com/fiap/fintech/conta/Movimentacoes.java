package br.com.fiap.fintech.conta;
import java.util.UUID;
import java.util.Date;

public class Movimentacoes {
	private UUID id = UUID.randomUUID();
	private String tipo;
	private String descricao;
	private Date dtVigencia;
	private double vlMovimentacao;
	private UUID contaId;
	private UUID categoriaId;
	
	public Movimentacoes(String tipo, String descricao, Date dtVigencia, double vlMovimentacao, UUID conta, UUID categoria) {
		this.tipo = tipo;
		this.descricao = descricao;
		this.dtVigencia = dtVigencia;
		this.vlMovimentacao = vlMovimentacao;
		this.contaId = conta;
		this.categoriaId = categoria;
		
	}
	
	
	public Movimentacoes(UUID id, String tipo, String descricao, Date dtVigencia, double vlMovimentacao, UUID conta, UUID categoria) {
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
		this.dtVigencia = dtVigencia;
		this.vlMovimentacao = vlMovimentacao;
		this.contaId = conta;
		this.categoriaId = categoria;
		
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDtVigencia() {
		return dtVigencia;
	}

	public void setDtVigencia(Date dtVigencia) {
		this.dtVigencia = dtVigencia;
	}

	public double getVlMovimentacao() {
		return vlMovimentacao;
	}

	public void setVlMovimentacao(double vlMovimentacao) {
		this.vlMovimentacao = vlMovimentacao;
	}

	public UUID getContaId() {
		return contaId;
	}

	public void setContaId(UUID contaId) {
		this.contaId = contaId;
	}

	public UUID getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(UUID categoriaId) {
		this.categoriaId = categoriaId;
	}

	
	public Movimentacoes update(String tipo, String descricao, Date dtVigencia, double vlMovimentacao) {
		this.tipo = tipo; 
		this.descricao = descricao;
		this.dtVigencia = dtVigencia;
		this.vlMovimentacao = vlMovimentacao;
		return this;	
	}
	
}
