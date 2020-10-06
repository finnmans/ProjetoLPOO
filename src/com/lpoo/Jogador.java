/**
 *  Primeira Parte do Projeto de LPOO
 * 
 *   Dupla:
 *    Alexandre Candido Souza
 *    Felipe Vasconcelos
 */

package src.com.lpoo;

public class Jogador {
  private final Integer numero;
  private final String nome;

  public Jogador(int numero, String nome) {
    this.numero = numero;
    this.nome = nome;
  }

  public Integer getNumero() {
    return numero;
  }

  public String getNome() {
    return nome;
  }

}
