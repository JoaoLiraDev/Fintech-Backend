package br.com.fiap.fintech.conta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.fiap.fintech.conta.Movimentacoes;
import br.com.fiap.fintech.core.ConnectorManager;

public class MovimentacoesDAO {

	private final String ID_COLLUMN = "ID_MOV";
	private final String TIPO_COLLUMN = "IN_TIPO";
	private final String DESCRICAO_COLLUMN = "DS_DESCRICAO";
	private final String VIGENCIA_COLLUMN = "DT_VIGENCIA";
	private final String VL_MOVIMENTACAO_COLLUMN = "VL_MOVIMENTACAO";
	private final String ID_CONTA_COLLUMN = "T_SOF_CONTA_ID_CONTA";
	private final String ID_CATEG_COLLUMN = "T_SOF_CATEGORIA_ID_CATEG";

	private Connection conexao;

	public void cadastrar(Movimentacoes mov) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectorManager.getInstance().getConnection();
			String sql = "INSERT INTO T_SOF_MOVIMENTACOES (ID_MOV, IN_TIPO, DS_DESCRICAO, DT_VIGENCIA, VL_MOVIMENTACAO, T_SOF_CATEGORIA_ID_CATEG, T_SOF_CONTA_ID_CONTA) VALUES (?, ?, ?, TO_DATE('?', 'DD/MM/YYYY'), ?, ?, ?)";
			
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, mov.getId().toString());
			stmt.setString(2, mov.getTipo());
			stmt.setString(3, mov.getDescricao());
			java.sql.Date data = new java.sql.Date(mov.getDtVigencia().getTime());
			stmt.setDate(4, data);
			stmt.setDouble(5, mov.getVlMovimentacao());
			stmt.setString(6, mov.getCategoriaId().toString());
			stmt.setString(7, mov.getContaId().toString());
			
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

	public List<Movimentacoes> listar() throws Exception {

		List<Movimentacoes> lista = new ArrayList<Movimentacoes>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectorManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_SOF_MOVIMENTACOES");
			rs = stmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString(this.ID_COLLUMN);
				String tipo = rs.getString(this.TIPO_COLLUMN);
				String descricao = rs.getString(this.DESCRICAO_COLLUMN);
				java.sql.Date vigencia = rs.getDate(this.VIGENCIA_COLLUMN);
				double vlMovimentacao = rs.getDouble(this.VL_MOVIMENTACAO_COLLUMN);
				String contaId = rs.getString(this.ID_CONTA_COLLUMN);
				String categoriaId = rs.getString(this.ID_CATEG_COLLUMN);
				
				
				try {
					Movimentacoes Movimentacoes = new Movimentacoes(UUID.fromString(id), tipo, descricao, vigencia, vlMovimentacao, UUID.fromString(contaId), UUID.fromString(categoriaId));
					lista.add(Movimentacoes);
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

	public void atualizar(Movimentacoes mov) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectorManager.getInstance().getConnection();
			String sql = "UPDATE T_SOF_MOVIMENTACOES SET DT_VIGENCIA = TO_DATE('?', 'DD/MM/YYYY'), VL_MOVIMENTACAO = ?, DS_DESCRICAO = '?', IN_TIPO = '?', T_SOF_CATEGORIA_ID_CATEG = '?' WHERE ID_MOV = '?'; ";
			stmt = conexao.prepareStatement(sql);
			java.sql.Date data = new java.sql.Date(mov.getDtVigencia().getTime());
			stmt.setDate(1, data);
			stmt.setDouble(2, mov.getVlMovimentacao());
			stmt.setString(3, mov.getDescricao());
			stmt.setString(4, mov.getTipo());
			stmt.setString(5, mov.getCategoriaId().toString());
			stmt.setString(6, mov.getId().toString());
			
			
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
			String sql = "DELETE FROM T_SOF_MOVIMENTACOES WHERE ID_MOV = ?";
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

	public Movimentacoes buscarPorId(String codigoBusca) {
		Movimentacoes Movimentacoes = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectorManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_SOF_MOVIMENTACOES WHERE ID_MOV = ?");
			stmt.setString(1, codigoBusca);
			rs = stmt.executeQuery();

			if (rs.next()) {
				String id = rs.getString(this.ID_COLLUMN);
				String tipo = rs.getString(this.TIPO_COLLUMN);
				String descricao = rs.getString(this.DESCRICAO_COLLUMN);
				java.sql.Date vigencia = rs.getDate(this.VIGENCIA_COLLUMN);
				double vlMovimentacao = rs.getDouble(this.VL_MOVIMENTACAO_COLLUMN);
				String contaId = rs.getString(this.ID_CONTA_COLLUMN);
				String categoriaId = rs.getString(this.ID_CATEG_COLLUMN);
				
				try {
					Movimentacoes = new Movimentacoes(UUID.fromString(id), tipo, descricao, vigencia, vlMovimentacao, UUID.fromString(contaId), UUID.fromString(categoriaId));
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
		return Movimentacoes;
	}
}
