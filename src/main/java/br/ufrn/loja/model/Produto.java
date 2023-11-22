package br.ufrn.loja.model;

/**
 * 
 * Classe responsavel pela entidade produto
 *
 */
public class Produto {
	
	private int id;
	private String nome;
	private double preco;
	private int estoque;
	private String fabricante;

	
	public Produto() {
	}

	public Produto(String nome, double preco, int estoque, String fabricante) {
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
		this.fabricante = fabricante;
	}

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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
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
	
	

}
