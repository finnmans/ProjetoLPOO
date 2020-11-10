/*
   Projeto de LPOO
  
    Dupla:
     Alexandre Candido Souza
     Felipe Vasconcelos
 */

package br.com.poli;

import br.com.poli.connect4.*;
import br.com.poli.connect4.gui.JanelaPrincipal;
import java.util.Scanner;
import br.com.poli.connect4.gui.telas.TelaCadastroController;
import br.com.poli.connect4.singletons.PartidaBuilder;

public class Main {

  
  public static void main(String[] args) {
    
    var janelaGui = new JanelaPrincipal();
    janelaGui.setUp();
  }
  
  public static Partida makePartida(String jog1, String jog2){
    return new Partida(jog1,jog2);
  }
  
  
  public static void run(){
    String jog1;
    String jog2;
    Scanner scanner = new Scanner(System.in);
    var users = new PartidaBuilder();
    Jogador vencedor = null;
    boolean empate = false;
    // String msgBaseJogada = "%-20s: jogou na coluna: %x %n";

    System.out.println("Jogador 1:");
    jog1 = scanner.next();//users.getUserName(0);

    System.out.println("Jogador 2:");
    jog2 = scanner.next();//users.getUserName(1);
    
    System.out.println(jog1);
    System.out.println(jog2);
    
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
