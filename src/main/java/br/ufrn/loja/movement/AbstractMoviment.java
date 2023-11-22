package br.ufrn.loja.movement;

import java.util.Scanner;

/**
 * @brief Classe abstrata que define operações básicas de movimentação (CRUD).
 *
 * @tparam E Tipo de objeto manipulado pela classe.
 * @tparam T Tipo de DAO  associado à classe.
 */
public abstract class AbstractMoviment<E, T> {
	public static final int CRIAR = 1;
	public static final int ALTERAR = 2;
	public static final int REMOVER = 3;
	public static final int CONSULTAR = 4;

	protected E objeto;
	protected T dao;

	 /**
     * @brief Processa a operação solicitada.
     *
     * @param opcao A operação a ser realizada.
     * @param in Scanner para entrada de dados.
     */
	public void processar(int opcao, Scanner in) {
		switch (opcao) {
		case CRIAR: 
			cadastrar(in);
			break;
		case CONSULTAR:
			System.out.println("Consultando");
			break;
		case ALTERAR:
			System.out.println("Alterando");
			break;
		case REMOVER:
			System.out.println("Removendo");
			break;
		default:
			System.out.println("Nenhuma opcao");
		}

	}
	
	/**
     * @brief Método abstrato para realizar o cadastro de um objeto.
     *
     * @param in Scanner para entrada de dados.
     */
	protected abstract void cadastrar(Scanner in);
	
	/**
     * @brief Método abstrato para ler os dados do objeto.
     *
     * @param in Scanner para entrada de dados.
     */
	protected abstract void lerDados(Scanner in);
	
	 /**
     * @brief Método abstrato para consultar o objeto.
     */
	protected abstract void consultar();
	
	/**
     * @brief Método abstrato para alterar o objeto.
     */
	protected abstract void alterar();
	
	/**
     * @brief Método abstrato para remover o objeto.
     */
	protected abstract void remover();
}
