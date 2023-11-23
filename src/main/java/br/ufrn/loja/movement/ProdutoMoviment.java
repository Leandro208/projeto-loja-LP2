package br.ufrn.loja.movement;


import br.ufrn.loja.dao.ProdutoDao;
import br.ufrn.loja.model.Produto;

public class ProdutoMoviment extends AbstractMoviment<Produto> {

	public ProdutoMoviment() {
		
	}
	public ProdutoMoviment(Produto produto) {
		objeto = produto;
		dao = new ProdutoDao();
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
	@Override
	protected boolean validar() {
		if(objeto.getNome() == null || objeto.getNome().isEmpty()) {
			System.out.println("\nVocê não digitou o nome do produto\n");
			return false;
		}
		return true;
	}
	
	
	
}
