/**
 *  Projeto de LPOO
 * 
 *   Dupla:
 *    Alexandre Candido Souza
 *    Felipe Vasconcelos
 */

package br.com.poli.connect4;

public class Main {

  public static void main(String[] args) {
    Partida partida = new Partida("Alex", "Felipe");

    System.out.printf("%n%-20s: começará jogando!%n", partida.getJoadorAtual());
    System.out.println(String.format("%-40s%n", " ").replace(" ", "-")); // Printar a linha no tamanho certo

    String msgBase = "%-20s: jogou na coluna: %x %n";

    System.out.printf(msgBase, partida.getJoadorAtual(), 0);
    System.out.println(partida.fazerJogada(0));

    System.out.printf(msgBase, partida.getJoadorAtual(), 1);
    System.out.println(partida.fazerJogada(0));

    System.out.printf(msgBase, partida.getJoadorAtual(), 2);
    System.out.println(partida.fazerJogada(0));

    System.out.printf(msgBase, partida.getJoadorAtual(), 2);
    System.out.println(partida.fazerJogada(0));

    System.out.printf(msgBase, partida.getJoadorAtual(), 3);
    System.out.println(partida.fazerJogada(0));
    System.out.println(partida.fazerJogada(0));
    System.out.println(partida.fazerJogada(0));
    System.out.println(partida.fazerJogada(0));
    System.out.println(partida.fazerJogada(0));
  }
}
