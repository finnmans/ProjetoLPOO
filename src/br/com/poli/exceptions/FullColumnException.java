package br.com.poli.exceptions;

/**
 * FullColumnException
 * 
 * Exceção caso a coluna do tabuleiro já esteja completamente preenchida
 */
public class FullColumnException extends Exception {

  private static final long serialVersionUID = 1L;

  public FullColumnException(String message, Throwable cause) {
    super(message, cause);
  }

  public FullColumnException(String message) {
    super(message);
  }

}