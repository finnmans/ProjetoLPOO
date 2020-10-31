/**
 *  Projeto de LPOO
 * 
 *   Dupla:
 *    Alexandre Candido Souza
 *    Felipe Vasconcelos
 */

package br.com.poli.connect4;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    String jog1;
    String jog2;
    Scanner scanner = new Scanner(System.in);
    Jogador vencedor = null;
    boolean empate = false;
    // String msgBaseJogada = "%-20s: jogou na coluna: %x %n";

    System.out.println("Jogador 1:");
    jog1 = scanner.next();

    System.out.println("Jogador 2:");
    jog2 = scanner.next();

    Partida partida = new Partida(jog1, jog2);

    System.out.printf("%n%-20s: começará jogando!%n", partida.getJogadorAtual());
    System.out.println(String.format("%-40s%n", " ").replace(" ", "-")); // Printar a linha no tamanho certo
    System.out.println(partida.getTabuleiroString());

    while (!empate && vencedor == null) {
      System.out.printf("%s | Digite a posição (0-6): ", partida.getJogadorAtual());
      int x = scanner.nextInt();
      System.out.println(partida.fazerJogada(x));

      vencedor = partida.getVencedor();
      empate = partida.isEmpate();
    }

    if (vencedor != null) {
      System.out.printf("%n %s VENCEU!!%n", vencedor);
    }

    if (empate) {
      System.out.println("ITS A TIE!");
    }

    System.out.println("\nJogo acabou"); // ta aq so pra saber se tem erro em algum lugar
    scanner.close();
  }
}
