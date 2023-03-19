package br.com.fiap.fintech.cliente;
import java.util.Date;
import java.util.UUID;

public abstract class Cliente {
	public UUID id = UUID.randomUUID();
	public String name;
	public String email;
	private String password;
	public Date dtNascimento;
	public String nrTelefone;
	public Endereco endereco;
	public Date dtCriacao = new Date();
	public Date dtAtualizacao = new Date();
	
	
	public Cliente(String name, String email, String password, Date dtNascimento, String nrTelefone, Endereco endereco) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.dtNascimento = dtNascimento;
		this.nrTelefone = nrTelefone;
		this.endereco = endereco;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void alterarSenha(String password) {
		this.password = password;
		this.dtAtualizacao = new Date();
	}
	
	public Cliente atualizar(String name, String email, Date dtNascimento, String nrTelefone, Endereco endereco) {
		this.name = name; 
		this.email = email;
		this.dtNascimento = dtNascimento;
		this.nrTelefone = nrTelefone;
		this.endereco = endereco;
		this.dtAtualizacao = new Date();
		return this;
	}
	
	public boolean validarCliente(String email, String password) {
		if (this.email == email && this.password == password) {
			return true;
		}
		else {
			return false;
		}
	}
}
