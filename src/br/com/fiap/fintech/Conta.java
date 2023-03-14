package br.com.fiap.fintech;
import java.util.Date;
import java.util.UUID;

public class Conta {
	public UUID id = UUID.randomUUID();
	public String nmConta;
	private double saldo;
	public Date dtCriacao = new Date();
	public Date dtAtualizacao = new Date();
	
	public Conta(String nmConta) {
		this.nmConta = nmConta;
		this.saldo = 0.0;
	}
	
	public Conta(String nmConta, double saldo) {
		this.nmConta = nmConta;
		this.saldo = saldo;
	}
	
	public double consultarSaldo() {
		return this.saldo;
	}
	
	public double depositar(double value) {
		this.saldo += value;
		return this.saldo;
	}
}
