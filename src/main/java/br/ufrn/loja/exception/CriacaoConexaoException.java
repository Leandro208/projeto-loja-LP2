package br.ufrn.loja.exception;

@SuppressWarnings("serial")
public class CriacaoConexaoException extends RuntimeException {

    public CriacaoConexaoException(String mensagem) {
        super(mensagem);
    }

    public CriacaoConexaoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}