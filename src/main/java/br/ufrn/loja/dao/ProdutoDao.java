package br.ufrn.loja.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.loja.infra.ConnectionFactory;
import br.ufrn.loja.model.Produto;

/**
 * @brief Implementação do DAO para a entidade Produto.
 *
 *        Esta classe é responsável por interagir com o banco de dados para
 *        realizar operações relacionadas a produtos.
 */
public class ProdutoDao implements GenericDao<Produto> {

	private static final String INSERT = "INSERT INTO produto(nome, preco_custo, preco_venda, estoque, fabricante) VALUES (%)";
	private static final String SELECT_ALL = "SELECT * FROM produto";
	private static final String DELETE = "DELETE FROM produto WHERE id = ";
	private static final String EXISTE = "SELECT COUNT(*) FROM produto WHERE id = ";
	private static final String SELECT = "SELECT * FROM produto WHERE id = ";
	private Connection con;
	private Statement statement;

	public ProdutoDao() {
		con = ConnectionFactory.getInstance().getConnection();
	}

	
	@Override
	public void salvar(Produto obj) {
		try {
			statement = con.createStatement();
			statement.executeUpdate(INSERT.replace("%", "'" + obj.getNome() + "', " + obj.getPreco_custo() + ", "
					+ obj.getPreco_venda() + ", " + obj.getEstoque() + ", '" + obj.getFabricante() + "'"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharRecursos();
		}
	}

	@Override
	public List<Produto> buscarTodos() {
		List<Produto> resultado = new ArrayList<>();
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(SELECT_ALL);
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco_custo(rs.getDouble("preco_custo"));
				produto.setPreco_venda(rs.getDouble("preco_venda"));
				produto.setEstoque(rs.getInt("estoque"));
				produto.setFabricante(rs.getString("fabricante"));
				resultado.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharRecursos();
		}
		return resultado;
	}

	@Override
	public Produto buscarPorId(int id) {
		Produto produto = new Produto();
		try {
			statement = con.createStatement();
			ResultSet result = statement.executeQuery(SELECT + id);
			if (result.next()) {
				produto.setId(result.getInt("id"));
				produto.setNome(result.getString("nome"));
				produto.setPreco_custo(result.getDouble("preco_custo"));
				produto.setPreco_venda(result.getDouble("preco_venda"));
				produto.setEstoque(result.getInt("estoque"));
				produto.setFabricante(result.getString("fabricante"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharRecursos();
		}
		return produto;
	}

	@Override
	public void delete(int id) {
		try {
			statement = con.createStatement();
			statement.executeUpdate(DELETE + id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharRecursos();
		}

	}

	@Override
	public boolean existePorId(int id) {
		try {
			statement = con.createStatement();
			ResultSet result = statement.executeQuery(EXISTE + id);
			return result.next() && result.getInt(1) > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharRecursos();
		}
		return false;
	}

	@Override
	public void alterar(Produto obj) {
		try {
			statement = con.createStatement();
			String sql = "UPDATE produto SET nome = '" + obj.getNome() + "', preco_custo = " + obj.getPreco_custo()
					+ ", preco_venda = " + obj.getPreco_venda() + ", estoque = " + obj.getEstoque() + ", fabricante = '"
					+ obj.getFabricante() + "' WHERE id = " + obj.getId();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharRecursos();
		}
	}
	
	/**
	 * @brief Fecha os recursos (Statement) utilizados para interagir com o banco de
	 *        dados.
	 */
	private void fecharRecursos() {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
