/**
 *  Primeira Parte do Projeto de LPOO
 * 
 *   Dupla:
 *    Alexandre Candido Souza
 *    Felipe Vasconcelos
 */

package src.com.lpoo;

public class Main {

  public static void main(String[] args) {
    Partida partida = new Partida("Alex", "Felipe");

    partida.FazerJogada(0);
    partida.FazerJogada(1);
    partida.FazerJogada(2);
    partida.FazerJogada(3);
  }
}
