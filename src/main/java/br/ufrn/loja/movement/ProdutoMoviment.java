package br.ufrn.loja.movement;

import java.util.Scanner;

import br.ufrn.loja.dao.ProdutoDao;
import br.ufrn.loja.model.Produto;

public class ProdutoMoviment extends AbstractMoviment<Produto, ProdutoDao> {

	public ProdutoMoviment() {
		dao = new ProdutoDao();
	}
	@Override
	protected void cadastrar(Scanner in) {
		lerDados(in);	
		dao.salvar(objeto);
	}

	@Override
	protected void lerDados(Scanner in) {
		in.nextLine();
		
		System.out.print("Digite o nome do produto: ");
        String nome = in.nextLine();

        System.out.print("Digite o preço do produto: ");
        double preco = in.nextDouble();
        in.nextLine();

        System.out.print("Digite o estoque do produto: ");
        int estoque = in.nextInt();
        in.nextLine();

        System.out.print("Digite o fabricante do produto: ");
        String fabricante = in.nextLine();

        objeto = new Produto(nome, preco, estoque, fabricante);
	}

	@Override
	protected void consultar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void alterar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void remover() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
