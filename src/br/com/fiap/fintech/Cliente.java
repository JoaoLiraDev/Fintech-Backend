package br.com.fiap.fintech;
import java.util.Date;
import java.util.UUID;

public class Cliente {
	public UUID id = UUID.randomUUID();
	public String name;
	public String email;
	private String password;
	public Date dtNascimento;
	public String nrTelefone;
	public Date dtCriacao = new Date();
	public Date dtAtualizacao = new Date();
	
	
	public Cliente(String name, String email, String password, Date dtNascimento, String nrTelefone) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.dtNascimento = dtNascimento;
		this.nrTelefone = nrTelefone;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void alterarSenha(String password) {
		this.password = password;
	}
	
	public Cliente atualizar(String name, String email, Date dtNascimento, String nrTelefone) {
		this.name = name; 
		this.email = email;
		this.dtNascimento = dtNascimento;
		this.nrTelefone = nrTelefone;
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
