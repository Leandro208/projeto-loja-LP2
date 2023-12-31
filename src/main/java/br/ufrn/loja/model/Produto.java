package br.ufrn.loja.model;

/**
 *
 * Classe responsavel pela entidade produto
 *
 */
public class Produto {

	private int id;
	private String nome;
	private double preco_custo;
	private double preco_venda;
	private int estoque;
	private String fabricante;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco_custo() {
		return preco_custo;
	}

	public void setPreco_custo(double preco_custo) {
		this.preco_custo = preco_custo;
	}

	public double getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(double preco_venda) {
		this.preco_venda = preco_venda;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return String.format("%-5d%-28s%-15.2f%-15.2f%-10d%s%n", id, nome, preco_custo, preco_venda, estoque, fabricante);
	}
}
