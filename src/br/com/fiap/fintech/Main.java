package br.com.fiap.fintech;

import java.util.Date;

import br.com.fiap.fintech.cliente.ClienteFisico;
import br.com.fiap.fintech.cliente.Endereco;
import br.com.fiap.fintech.conta.Conta;

public class Main {

	public static void main(String[] args) throws Exception {
		Endereco enderecoCliente1 = new Endereco("06444000", "Barueri", "São Paulo", "Jardim Paulista", "XPTO", 62, "Super Mercado Verde", "Ap 67");
		
		ClienteFisico cliente1 = new ClienteFisico("Vitor", "teste@gmail.com", "123456", new Date(), "11940037479", enderecoCliente1, "23937917870");

		
		Conta conta1 = new Conta(cliente1, "89455", 0.0);
		System.out.println("Antiga senha;  " + cliente1.getPassword());
		cliente1.alterarSenha("654321");
		System.out.println("Nova senha:  " + cliente1.getPassword());
		
		System.out.println("Validar cliente:  " + cliente1.validarCliente("teste@gmail.com", "654321"));
		
		conta1.depositar(500);
		System.out.println("Novo Saldo:  " + conta1.consultarSaldo());
		
	}

}
