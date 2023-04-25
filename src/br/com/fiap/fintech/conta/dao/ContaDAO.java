package br.com.fiap.fintech.conta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.fiap.fintech.conta.Conta;
import br.com.fiap.fintech.core.ConnectorManager;

public class ContaDAO {

	private final String ID_COLLUMN = "ID_CONTA";
	private final String NUMERO_COLLUMN = "NM_CONTA";
	private final String ACTIVE_COLLUMN = "ACTIVE";
	private final String SALDO_COLLUMN = "SALDO";
	private final String CLIENT_ID_COLLUMN = "T_SOF_CLIENTE_ID_CLIENTE";

	private Connection conexao;

	public void cadastrar(Conta cc) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectorManager.getInstance().getConnection();
			String sql = "INSERT INTO T_SOF_CONTA (ID_CONTA,NM_CONTA,ACTIVE,SALDO,T_SOF_CLIENTE_ID_CLIENTE) VALUES (?,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cc.getId().toString());
			stmt.setString(2, cc.getNumero());
			stmt.setBoolean(3, cc.isActive());
			stmt.setDouble(4, cc.getSaldo());
			stmt.setString(5, cc.clienteId.toString());
			
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

	public List<Conta> listar() throws Exception {

		List<Conta> lista = new ArrayList<Conta>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectorManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_SOF_CONTA");
			rs = stmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString(this.ID_COLLUMN);
				String numero = rs.getString(this.NUMERO_COLLUMN);
				boolean active = rs.getBoolean(this.ACTIVE_COLLUMN);
				double saldo = rs.getDouble(this.SALDO_COLLUMN);
				String clienteId = rs.getString(this.CLIENT_ID_COLLUMN);
				
				try {
					Conta Conta = new Conta(UUID.fromString(id), UUID.fromString(clienteId), numero, saldo, active);
					lista.add(Conta);
				} catch (Exception e) {
					e.printStackTrace();
				}
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

	public void atualizar(Conta cc) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectorManager.getInstance().getConnection();
			String sql = "UPDATE T_SOF_CONTA SET NM_CONTA='?', ACTIVE=?, SALDO=? WHERE ID_CONTA='?'";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cc.getNumero());
			stmt.setBoolean(2, cc.isActive());
			stmt.setDouble(3, cc.getSaldo());
			stmt.setString(4, cc.getId().toString());

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
			String sql = "DELETE FROM T_SOF_CONTA WHERE ID_CONTA = ?";
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

	public Conta buscarPorId(String codigoBusca) {
		Conta Conta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectorManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_SOF_CONTA WHERE ID_CONTA = ?");
			stmt.setString(1, codigoBusca);
			rs = stmt.executeQuery();

			if (rs.next()) {
				String id = rs.getString(this.ID_COLLUMN);
				String numero = rs.getString(this.NUMERO_COLLUMN);
				boolean active = rs.getBoolean(this.ACTIVE_COLLUMN);
				double saldo = rs.getDouble(this.SALDO_COLLUMN);
				String clienteId = rs.getString(this.CLIENT_ID_COLLUMN);
				
				try {
					Conta = new Conta(UUID.fromString(id), UUID.fromString(clienteId), numero, saldo, active);
				} catch (Exception e) {
					e.printStackTrace();
				}
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
		return Conta;
	}
}
