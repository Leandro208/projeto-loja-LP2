package br.ufrn.loja.view;

import java.util.Scanner;

import br.ufrn.loja.utils.CorUtils;

public class Menu {

	private static final int SAIR = 0;
	private static final int CADASTRAR = 1;
	private static final int BUSCAR = 2;
	private static final int VER_TODOS = 3;
	private static final int FATURAMENTO = 4;

	private int opcao;
	private boolean saiu;
	private Scanner in;

	public Menu() {
		this.saiu = false;
		this.in = new Scanner(System.in);
	}

	/**
	 * Metodo responsavel por chamar o menu inicial
	 */
	public static void run() {
		System.out.println(CorUtils.verde("Iniciando Sistema..."));
		new Menu().exibir();
	}

	/**
	 * Faz a chamada do menu inicial, e mantem em um laço ate o usuario decidir
	 * encerrar.
	 */
	public void exibir() {
		while (!saiu) {
			telaInicial();
			realizarAcao();
		}

		System.out.println(CorUtils.verde("Programa Encerrado!"));
	}

	/**
	 * Imprime no console o menu inicial e ler a opção escolhida
	 */
	private void telaInicial() {

		System.out.println("\nDigite a opção: ");
		System.out.println("1 - Cadastrar Produto");
		System.out.println("2 - Buscar Produto");
		System.out.println("3 - Ver todos os produtos");
		System.out.println("4 - Ver faturamento");
		System.out.println("0 - sair");

		this.opcao = in.nextInt();

	}

	/**
	 * Verifica qual opção o usuario escolheu e redireciona para a execucao da acao
	 * desejada
	 */
	private void realizarAcao() {
		switch (opcao) {
		case CADASTRAR:
			System.out.println("cadastrar");
			break;

		case BUSCAR:
			System.out.println("Busacando");
			break;

		case VER_TODOS:
			System.out.println("Vendo todos");
			break;

		case FATURAMENTO:
			System.out.println("Exibindo faturamento");
			break;

		case SAIR:
			saiu = true;
			break;

		default:
			System.out.println("Valor Invalido!");// criar uma exceção
		}
	}

}
