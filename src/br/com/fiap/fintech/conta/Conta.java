package br.com.fiap.fintech.conta;
import java.util.Date;
import java.util.UUID;

import br.com.fiap.fintech.cliente.Cliente;
import br.com.fiap.fintech.cliente.ClienteFisico;

public class Conta {
	public UUID id = UUID.randomUUID();
	public Cliente titular;
	public String numero;
	private double saldo;
	private boolean active;
	public Date dtCriacao = new Date();
	public Date dtAtualizacao = new Date();
	
	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public Conta(ClienteFisico titular, String numero, double saldo) throws Exception {
		if (numero.length() == 5 && saldo >= 0) {
			this.titular = titular;
			this.numero = numero;
			this.saldo = saldo;
			this.active = true;
		} else {
			throw new Exception("Numero ou saldo informados sao invalidos!\nnumero apenas cinco digitos e saldo tem que ser maior ou igual a zero.");
		}
	}
	
	
	public double consultarSaldo() {
		return this.saldo;
	}
	
	public void depositar(double valor) throws Exception {
		if (this.active) {
			if(valor > 0) {
				this.saldo += valor;
			}else {
				throw new Exception("Valor de deposito invalido!");
			}
		} else {
			throw new Exception("A conta esta inativa!");
		}
	}
	
	
	public void desativar() throws Exception {
		if (this.isActive()) {
			this.active = false;
		} else {
			throw new Exception("A conta ja esta desativada!");
		}
	}
	
	public void ativar() throws Exception {
		if (!this.isActive()) {
			this.active = true;
		} else {
			throw new Exception("A conta ja esta ativada!");
		}
	}
	
	
}
