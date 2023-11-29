package br.ufrn.loja.view;

import java.util.Scanner;


import br.ufrn.loja.model.Produto;
import br.ufrn.loja.services.AbstractService;
import br.ufrn.loja.services.ProdutoService;
import br.ufrn.loja.utils.CorUtils;

public class TelaBusca {

	private Scanner in;
	private int opcao;
	private AbstractService<Produto> produtoService = new ProdutoService();
	public static final int REMOVER = 4;
	public static final int ALTERAR = 5;

	public TelaBusca(Scanner in) {
		this.in = in;
		produtoService.setObjeto(new Produto());
	}

	/**
	 * @brief Método que inicia a execução da TelaBusca.
	 */
	public void run(int opcao) {
		this.opcao = opcao;
		switch (this.opcao) {
			case Menu.VER_TODOS:
				produtoService.processar(opcao);
				break;
			case Menu.BUSCAR:
				buscar();
				break;
			default:
				System.out.println("Erro");
			}
	}

	private void buscar() {
		System.out.println("Digite o ID para a busca");
		produtoService.getObjeto().setId(in.nextInt());
		if (produtoService.buscar()) {
			System.out.println("[0] Voltar   [4]Remover    [5]Alterar");
			opcao = in.nextInt();

			if (opcao != Menu.SAIR) {
				if (opcao == REMOVER ) {
					produtoService.processar(opcao);
				} else if (opcao == ALTERAR) {
					alterar();
				} else {
					System.out.println(CorUtils.vermelho("Valor Invelido!"));
				}
			}
		}

	}
	
	private void alterar() {
		in.nextLine();

		System.out.print("Digite o nome do produto: ");
		produtoService.getObjeto().setNome(in.nextLine());

		System.out.print("Digite o preço de custo do produto: ");
		produtoService.getObjeto().setPreco_custo(in.nextDouble());

		System.out.print("Digite o preço de venda do produto: ");
		produtoService.getObjeto().setPreco_venda(in.nextDouble());
		in.nextLine();

		System.out.print("Digite o estoque do produto: ");
		produtoService.getObjeto().setEstoque(in.nextInt());
		in.nextLine();

		System.out.print("Digite o fabricante do produto: ");
		produtoService.getObjeto().setFabricante(in.nextLine());

		produtoService.processar(ALTERAR);
	}

}
