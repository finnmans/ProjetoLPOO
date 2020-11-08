package br.com.poli.exceptions;

/**
 * FullColumnException
 */
public class FullColumnException extends Exception {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public FullColumnException(String message, Throwable cause) {
    super(message, cause);
  }

  public FullColumnException(String message) {
    super(message);
  }

}