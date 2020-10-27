/**
 *  Projeto de LPOO
 * 
 *   Dupla:
 *    Alexandre Candido Souza
 *    Felipe Vasconcelos
 */

package src.com.lpoo;

public class Tabuleiro {
  private int[][] matrizTabuleiro = new int[6][7]; // peças no tabuleiro

  public void desenharTabuleiro() { // desenhar o tabuleiro

    System.out.println(" (0) (1) (2) (3) (4) (5) (6)");// casas possiveis
    System.out.println("|---.---.---.---.---.---.---|");// linhas de separação

    for (int i = 0; i < 6; i++) {
      System.out.print("|");
      for (int j = 0; j < 7; j++) {
        String valorLinha = matrizTabuleiro[i][j] == 0 ? " " : Integer.toString(matrizTabuleiro[i][j], 10);
        System.out.print(" " + valorLinha + " |");
      }
      System.out.println("\n|---.---.---.---.---.---.---|");// linhas de separação

    }

    System.out.println();

  }

  public int fazerJogada(int position, int jogador) {

    if (position >= matrizTabuleiro.length) {
      return -1;
    }

    for (int i = 0; i < matrizTabuleiro.length; i++) {
      int linhaAtual = matrizTabuleiro[i][position];

      // caso tenha achado alguma campo preenchido, se colocar na posição anterior
      if (linhaAtual != 0) {
        matrizTabuleiro[i - 1][position] = jogador;
        return i;
      }
    }

    // caso n tenha achado nada, se coloca no final da coluna
    matrizTabuleiro[matrizTabuleiro.length - 1][position] = jogador;
    return matrizTabuleiro.length - 1;
  }

}
