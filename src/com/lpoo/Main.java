/**
 *  Projeto de LPOO
 * 
 *   Dupla:
 *    Alexandre Candido Souza
 *    Felipe Vasconcelos
 */

package src.com.lpoo;

public class Main {

  public static void main(String[] args) {
    Partida partida = new Partida("Alex", "Felipe");
    // Tabuleiro tabuleiro = new Tabuleiro();

    partida.fazerJogada(0);
    partida.fazerJogada(1);
    partida.fazerJogada(2);
    partida.fazerJogada(2);
    partida.fazerJogada(3);
  }
}
