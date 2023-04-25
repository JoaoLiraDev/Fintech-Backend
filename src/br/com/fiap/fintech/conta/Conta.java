package br.com.fiap.fintech.conta;
import java.util.Date;
import java.util.UUID;

import br.com.fiap.fintech.cliente.Cliente;
import br.com.fiap.fintech.cliente.ClienteFisico;

public class Conta {
	private UUID id = UUID.randomUUID();
	public UUID clienteId;
	private String numero;
	private double saldo;
	private boolean active;
	
	public Conta(UUID clienteId, String numero, double saldo) throws Exception {
		if (numero.length() == 5 && saldo >= 0) {
			this.clienteId = clienteId;
			this.numero = numero;
			this.saldo = saldo;
			this.active = true;
		} else {
			throw new Exception("Numero ou saldo informados sao invalidos!\nnumero apenas cinco digitos e saldo tem que ser maior ou igual a zero.");
		}
	}
	
	public Conta(UUID id, UUID clienteId, String numero, double saldo, boolean active) throws Exception {
		if (numero.length() == 5 && saldo >= 0) {
			this.id = id;
			this.clienteId = clienteId;
			this.numero = numero;
			this.saldo = saldo;
			this.active = active;
		} else {
			throw new Exception("Numero ou saldo informados sao invalidos!\nnumero apenas cinco digitos e saldo tem que ser maior ou igual a zero.");
		}
	}
	
	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


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
