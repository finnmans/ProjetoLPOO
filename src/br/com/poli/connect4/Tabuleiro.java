/**
 *  Projeto de LPOO
 * 
 *   Dupla:
 *    Alexandre Candido Souza
 *    Felipe Vasconcelos
 */

package br.com.poli.connect4;

import br.com.poli.utils.Vector2Int;

public class Tabuleiro {
  private int[][] matrizTabuleiro = new int[6][7]; // peças no tabuleiro
  private final Vector2Int ultimoVetor = new Vector2Int(-1, -1);

  @Override
  public String toString() {
    var tBuilder = new StringBuilder();
    tBuilder.append(" (0) (1) (2) (3) (4) (5) (6) \n");// casas possiveis
    tBuilder.append("|---.---.---.---.---.---.---|\n");// linhas de separação

    for (int i = 0; i < 6; i++) {
      tBuilder.append("|");

      for (int j = 0; j < 7; j++) {
        var valorLinha = matrizTabuleiro[i][j] == 0 ? " " : Integer.toString(matrizTabuleiro[i][j], 10);
        if (ultimoVetor.compare(j, i))
          valorLinha = "\u001B[35m" + valorLinha + "\u001B[0m";

        tBuilder.append(" " + valorLinha + " |");
      }

      tBuilder.append("\n|---.---.---.---.---.---.---|\n");// linhas de separação

    }
    return tBuilder.toString();
  }

  public int GetPosition(int x, int y) {
    return this.matrizTabuleiro[y][x];
  }

  public boolean isCheio() {
    return br.com.poli.utils.Arrays.contemElemento(matrizTabuleiro, 0);
  }

  public int fazerJogada(int position, int jogador) {
    if (position >= matrizTabuleiro.length) {
      return -1;
    }

    for (int i = (matrizTabuleiro.length - 1); i >= 0; i--) {
      int linhaAtual = matrizTabuleiro[i][position];

      // caso tenha achado alguma campo preenchido, se colocar na posição anterior
      if (linhaAtual == 0) {
        matrizTabuleiro[i][position] = jogador;

        ultimoVetor.x = position;
        ultimoVetor.y = i;
        return i;
      }
    }

    // caso n tenha achado nada, retorna -1 (Coluna Preenchida)
    ultimoVetor.y = -1;
    return -1;
  }

}
