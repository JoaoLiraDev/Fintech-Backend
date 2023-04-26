package br.com.fiap.fintech;

import java.util.List;
import java.util.UUID;

import br.com.fiap.fintech.conta.Categoria;
import br.com.fiap.fintech.conta.Conta;
import br.com.fiap.fintech.conta.dao.CategoriaDAO;
import br.com.fiap.fintech.conta.dao.ContaDAO;

public class Main {

	public static void main(String[] args) throws Exception {
		// ID do usuário criado no banco via script: fd188ea8-ebba-4932-9cc7-8fca717e1abf
		
		UUID id = UUID.fromString("fd188ea8-ebba-4932-9cc7-8fca717e1abf");
		Conta contaTeste = new Conta(id,  "67561", 0);
		
		ContaDAO contaDao = new ContaDAO();
		
//		contaDao.cadastrar(contaTeste);
		
		List<Conta> contaResult = contaDao.listar();
		
		for (Conta item : contaResult) {
			System.out.println("Conta" + item.getId() + " " + item.getNumero() + " " + item.getSaldo());
		}
//		Categoria categoriaTeste = new Categoria("Viagens");

		CategoriaDAO dao = new CategoriaDAO();

//		dao.cadastrar(categoriaTeste);

		List<Categoria> categoriaResult = dao.listar();

		for (Categoria item : categoriaResult) {
			System.out.println(item.getId() + " " + item.getNmCategoria());
		}

	}

}
