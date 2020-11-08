/**
 *  Projeto de LPOO
 * 
 *   Dupla:
 *    Alexandre Candido Souza
 *    Felipe Vasconcelos
 */

package br.com.poli.connect4;

import br.com.poli.exceptions.FullColumnException;
import br.com.poli.utils.Vector2Int;

public class Tabuleiro {
  private int[][] matrizTabuleiro = new int[6][7]; // peças no tabuleiro
  private final Vector2Int ultimaPosicaoJogada = new Vector2Int(-1, -1);
  // (-1,-1) = posição inválida que vai ser substituida em jogadas válidas

  @Override
  public String toString() {
    var tBuilder = new StringBuilder();

    // StringBuilder em vez de concatenação direta por ser mais performático dentro
    // do loop.

    tBuilder.append(" (0) (1) (2) (3) (4) (5) (6) \n");// casas possiveis
    tBuilder.append("|---.---.---.---.---.---.---|\n");// linhas de separação

    for (int i = 0; i < 6; i++) {
      tBuilder.append("|"); // Inicio do espaço

      for (int j = 0; j < 7; j++) {
        var valorLinha = matrizTabuleiro[i][j] == 0 ? " " : Integer.toString(matrizTabuleiro[i][j], 10);

        if (ultimaPosicaoJogada.compare(j, i)) // Caso a posição seja igual à ultima posição jogada
          valorLinha = "\u001B[35m" + valorLinha + "\u001B[0m";
        // Pinta o carácter no console com {cor roxa} + {valorLinha} + {corBranca}.

        tBuilder.append(" " + valorLinha + " |");
      }

      tBuilder.append("\n|---.---.---.---.---.---.---|\n");// linhas de separação

    }

    // transforma todo o conjunto na string final.
    return tBuilder.toString();
  }

  /**
   * Retorna o valor da matriz em dada posição (x,y) Onde:
   * 
   * @param x Posição Horizontal (Coluna).
   * @param y Posição Vertical (Linha).
   * @return Inteiro com o valor presente no tabuleiro, retona -1 caso a posição
   *         seja inválida.
   */
  public int getPosition(int x, int y) {
    return getPosition(x, y, false);
  }

  /**
   * Retorna o valor da matriz em dada posição (x,y) Onde:
   * 
   * @param x         Posição Horizontal (Coluna).
   * @param y         Posição Vertical (Linha).
   * @param exception Flag que define se deve jogar uma exceção em caso de posição
   *                  errada caso falso retornará -1 em posições inválidas.
   * @return Inteiro com o valor presente no tabuleiro.
   */
  public int getPosition(int x, int y, boolean exception) {
    try {
      return this.matrizTabuleiro[y][x];
    } catch (Exception e) {
      if (exception)
        throw e;

      return -1;
    }
  }

  /**
   * @return Inteiro com a quantidade de colunas do tabuleiro.
   */
  public int getLengthX() {
    return this.matrizTabuleiro[0].length;
  }

  /**
   * @return Inteiro com a quantidade de linhas do tabuleiro.
   */
  public int getLengthY() {
    return this.matrizTabuleiro.length;
  }

  /**
   * Checa se existe algum valor vázio (0) na mátriz do tabuleiro
   * 
   * @return True caso o tabuleiro não possua nenhuma casa vaga (0)
   */
  public boolean isCheio() {
    for (int i = 0; i < matrizTabuleiro.length; i++) {
      for (int j = 0; j < matrizTabuleiro[0].length; j++) {
        if (matrizTabuleiro[i][j] == 0)
          return false;
      }
    }
    return true;
  }

  /**
   * Preenche a matriz do tabuleiro com uma nova jogada
   * 
   * @param position Posição Horizontal(x) da coluna que vai ser preenchida.
   * @param jogador  Identificador de quem fez a jogada.
   * @return Inteiro com a posição Vertical(Y) onde foi marcado.
   * @throws FullColumnException      caso a coluna especificada pelo parametro
   *                                  position já esteja cheia.
   * @throws IllegalArgumentException caso a coluna especificada pelo parametro
   *                                  position seja menor que 0 ou maior que o
   *                                  valor máximo.
   */
  public int fazerJogada(int position, int jogador) throws FullColumnException {
    if (position >= matrizTabuleiro[0].length) {
      throw new IllegalArgumentException(String.format(
          "[Posição Inválida] Posição deve ser maior ou igual à %i e menor que %i.", 0, matrizTabuleiro.length));
    }

    for (int i = (matrizTabuleiro.length - 1); i >= 0; i--) {
      int linhaAtual = matrizTabuleiro[i][position];

      // caso tenha achado alguma campo preenchido, se colocar na posição anterior
      if (linhaAtual == 0) {
        matrizTabuleiro[i][position] = jogador;

        ultimaPosicaoJogada.x = position;
        ultimaPosicaoJogada.y = i;
        return i;
      }
    }

    ultimaPosicaoJogada.y = -1;
    throw new FullColumnException("[Posição Inválida] A coluna já está preenchida.");
  }

}
