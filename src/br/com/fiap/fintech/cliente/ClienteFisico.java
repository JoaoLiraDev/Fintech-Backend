package br.com.fiap.fintech.cliente;

import java.util.Date;

import br.com.fiap.fintech.Endereco;

public class ClienteFisico extends Cliente {
	private String cpf;
	
	public ClienteFisico(String name, String email, String password, Date dtNascimento, String nrTelefone, Endereco endereco, String cpf) {
		super(name, email, password, dtNascimento, nrTelefone, endereco);
		this.setCpf(cpf);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
