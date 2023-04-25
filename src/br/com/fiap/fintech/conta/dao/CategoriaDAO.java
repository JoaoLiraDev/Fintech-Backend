package br.com.fiap.fintech.conta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.fiap.fintech.conta.Categoria;
import br.com.fiap.fintech.core.ConnectorManager;

public class CategoriaDAO {

	private final String ID_COLLUMN = "ID_CATEGORIA";
	private final String NOME_COLLUMN = "NM_CATEGORIA";

	private Connection conexao;

	public void cadastrar(Categoria categoria) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectorManager.getInstance().getConnection();
			String sql = "INSERT INTO T_SOF_CATEGORIA (ID_CATEGORIA, NM_CATEGORIA) VALUES ( ?, ? )";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, categoria.getId().toString());
			stmt.setString(2, categoria.getNmCategoria());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Categoria> listar() {

		List<Categoria> lista = new ArrayList<Categoria>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectorManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_SOF_CATEGORIA");
			rs = stmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString(this.ID_COLLUMN);
				String nome = rs.getString(this.NOME_COLLUMN);

				Categoria Categoria = new Categoria(UUID.fromString(id), nome);
				lista.add(Categoria);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	public void atualizar(Categoria categoria) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectorManager.getInstance().getConnection();
			String sql = "UPDATE T_SOF_CATEGORIA SET NM_CATEGORIA = ?  WHERE ID_CATEGORIA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, categoria.getNmCategoria());
			stmt.setString(2, categoria.getId().toString());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void remover(String id) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectorManager.getInstance().getConnection();
			String sql = "DELETE FROM T_SOF_CATEGORIA WHERE ID_CATEGORIA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Categoria buscarPorId(String codigoBusca) {
		Categoria Categoria = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectorManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_SOF_CATEGORIA WHERE ID_CATEGORIA = ?");
			stmt.setString(1, codigoBusca);
			rs = stmt.executeQuery();

			if (rs.next()) {
				String id = rs.getString(this.ID_COLLUMN);
				String nome = rs.getString(this.NOME_COLLUMN);
				Categoria = new Categoria(UUID.fromString(id), nome);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Categoria;
	}
}
