/*
   Projeto de LPOO
  
    Dupla:
     Alexandre Candido Souza
     Felipe Vasconcelos
 */

package br.com.poli;

import br.com.poli.connect4.*;
import br.com.poli.connect4.gui.TelaCadastro;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    
    var telCadastro = new TelaCadastro();
    telCadastro.init(new String[]{});
    //    run();
  }
  
  public static void run(){
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

      try {
        partida.fazerJogada(x);
      } catch (Exception e) {
        System.out.println("\n\u001B[31mposição inválida, tente novamente! \u001B[0m\n");
        continue;
      }

      System.out.println(partida.getTabuleiroString());
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
