/**
 *  Projeto de LPOO
 * 
 *   Dupla:
 *    Alexandre Candido Souza
 *    Felipe Vasconcelos
 */

package src.br.com.poli.connect4;

import src.br.com.poli.utils.Vector2Int;

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

  public int getPosition(int x, int y) {
    return this.matrizTabuleiro[y][x];
  }
  public int getPositionX(int x){
     return this.matrizTabuleiro[matrizTabuleiro.length][x];
  }

  public int getPositionY(int y){
    return this.matrizTabuleiro[y][matrizTabuleiro[0].length];
  }

  public boolean isCheio() {
    for (int i = 0; i < matrizTabuleiro.length; i++) {
      for (int j = 0; j < matrizTabuleiro[0].length; j++) {
        if (matrizTabuleiro[i][j] == 0)
          return false;
      }
    }
    return true;
  }

  public int fazerJogada(int position, int jogador) {
    if (position > matrizTabuleiro.length) {
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
    if (isCheio())
      return 0;
    ultimoVetor.y = -1;
    return -1;
  }

  public boolean checkWinVertical(int x,int y){
    int player = matrizTabuleiro[y][x];
    int Max = matrizTabuleiro.length;
   
    if(Max > 4) Max = 4;

    for(int j = y; j < Max; j++){

    if(matrizTabuleiro[j][x] != player) return false;
}
return true;
}
public boolean checkWinHorizon(int x,int y){
  int player = matrizTabuleiro[y][x];
  int Max = matrizTabuleiro[0].length;
 
  if(Max > 4) Max = 4;

  for(int i = x; i < Max; i++){

  if(matrizTabuleiro[y][i] != player) return false;
}
return true;
}



  
}
