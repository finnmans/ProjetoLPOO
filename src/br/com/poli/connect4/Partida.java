/**
 *  Projeto de LPOO
 * 
 *   Dupla:
 *    Alexandre Candido Souza
 *    Felipe Vasconcelos
 */

package br.com.poli.connect4;

import java.util.Random;

import br.com.poli.exceptions.FullColumnException;

public class Partida {
  private Jogador[] jogadores;
  private Jogador jogadorAtual;
  private Jogador vencedor;
  private int jogadorAtualIndex;
  Tabuleiro tabuleiro = new Tabuleiro();

  // #region Getters e Setters

  protected void setJogadorAtual(Jogador jogador) {
    this.jogadorAtual = jogador;
  }

  protected void setJogadorAtualByIndex(int arrayIndex) {
    setJogadorAtual(GetJogadorByIndex(arrayIndex));
    this.jogadorAtualIndex = arrayIndex;
  }

  public final Jogador GetJogadorByIndex(int arrayIndex) {
    if (arrayIndex < 0 || arrayIndex >= this.jogadores.length)
      throw new ArrayIndexOutOfBoundsException("Índice Invalido");

    return this.jogadores[arrayIndex];
  }

  public final Jogador getJogadorAtual() {
    return this.jogadorAtual;
  }

  public final Jogador getVencedor() {
    return this.vencedor;
  }

  // #endregion

  // #region Construtores
  public Partida(String nomeJogador1, String nomeJogador2) {
    this(new Jogador(1, nomeJogador1), new Jogador(2, nomeJogador2));
  }

  public Partida(Jogador jogador1, Jogador jogador2) {
    Random random = new Random();
    this.jogadores = new Jogador[] { jogador1, jogador2 };
    setJogadorAtualByIndex(random.nextInt() % 2 == 0 ? 0 : 1);
  }
  // #endregion

  public void trocarJogadores() {
    if (jogadorAtualIndex == 0)
      setJogadorAtualByIndex(1);
    else
      setJogadorAtualByIndex(0);
  }

  public String getTabuleiroString() {
    return tabuleiro.toString();
  }

  public void fazerJogada(int x) throws FullColumnException {
    int playerNum = jogadorAtual.getNumero();

    int y = tabuleiro.fazerJogada(x, playerNum);

    if (checkWin(x, y)) {
      vencedor = jogadorAtual;
    } else {
      trocarJogadores();
    }
  }

  public boolean isEmpate() {
    return (tabuleiro.isCheio() && vencedor == null);
  }

  public boolean checkWin(int x, int y) {
    return checkWinVertical(x, y) || checkWinHorizontal(x, y) || checkWinDiagonais(x, y);
  }

  // #region CheckWin
  protected boolean checkWinVertical(int x, int y) {
    // Caso não tenha 4 casas abaixo dele já retorna falso ai
    if (tabuleiro.getLengthY() - y < 4)
      return false;

    int player = tabuleiro.getPosition(x, y);

    // Checa as próximas 3 casas abaixo
    for (int i = 1; i < 4; i++) {
      // se em alguma delas tiver alguma diferença
      if (tabuleiro.getPosition(x, y + i) != player)
        return false; // jogador não ganhou
    }

    return true; // jogador ganhou
  }

  protected boolean checkWinHorizontal(int x, int y) {
    int player = tabuleiro.getPosition(x, y);
    int max = tabuleiro.getLengthX();
    int counter = 0;

    for (int j = 0; j < max; j++) {
      // caso haja algum diferente na sequência
      if (tabuleiro.getPosition(j, y) != player) {
        counter = 0; // reseta a contagem
        continue;
      }

      counter++;

      if (counter >= 4) // se ele conseguir contar 4 em sequência
        return true; // vitória
    }

    return false; // derrota
  }

  protected boolean checkWinDiagonais(int x, int y) {
    int player = tabuleiro.getPosition(x, y); // valor pra comparar
    int max = tabuleiro.getLengthY();

    // X das diagonais quando Y = 0;
    // Ex: se a pessoa joga em (3,2) o ponto superior esquerdo da diagonal vai ser
    // (1,0) e o direito vai ser (5,0)
    int d1x = x - y;
    int d2x = x + y;

    int d1counter = 0;
    int d2counter = 0;

    for (int i = 0; i < max; i++) {

      // Diagonal 1 (direita)
      if (tabuleiro.getPosition(d1x + i, i) != player) {
        d1counter = 0; // reseta a contagem
      } else {
        d1counter++;
      }
      // Diagonal 2 (esquerda)
      if (tabuleiro.getPosition(d2x - i, i) != player) {
        d2counter = 0; // reseta a contagem
      } else {
        d2counter++;
      }

      // se ele conseguir contar 4 em sequência em qualquer diagonal
      if (d1counter >= 4 || d2counter >= 4)
        return true; // vitória
    }

    return false; // derrota
  }
  // #endregion checkWin
}
