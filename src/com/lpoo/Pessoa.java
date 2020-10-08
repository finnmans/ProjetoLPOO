/**
 *  Projeto de LPOO
 * 
 *   Dupla:
 *    Alexandre Candido Souza
 *    Felipe Vasconcelos
 */

package src.com.lpoo;

public class Pessoa {
  private final String nome;

  public Pessoa(String nome) {
    this.nome = nome;
  }

  @Override
  public String toString() {
    return " Jogador: " + this.getNome();
  }

  public String getNome() {
    return nome;
  }
}
