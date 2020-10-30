/**
 *  Projeto de LPOO
 * 
 *   Dupla:
 *    Alexandre Candido Souza
 *    Felipe Vasconcelos
 */

package br.com.poli.connect4;

import java.util.Random;

public class Partida {
  private Jogador[] jogadores;
  private Jogador jogadorAtual;
  private Jogador vencedor;
  private int jogadorAtualIndex;
  Tabuleiro tabuleiro = new Tabuleiro();

  // private Jogador vencedor;
  boolean isFinalizado;

  // #region Getters e Setters

  public Jogador GetJogadorByIndex(int arrayIndex) {
    if (arrayIndex < 0 || arrayIndex >= this.jogadores.length)
      throw new ArrayIndexOutOfBoundsException("Índice Invalido");

    return this.jogadores[arrayIndex];
  }

  public void setJogadorAtual(Jogador jogador) {
    this.jogadorAtual = jogador;
  }

  public final Jogador getJoadorAtual() {
    return this.jogadorAtual;
  }

  public void setJogadorAtualByIndex(int arrayIndex) {
    setJogadorAtual(GetJogadorByIndex(arrayIndex));
    this.jogadorAtualIndex = arrayIndex;
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

  public boolean isEmpate() {
    return tabuleiro.isCheio() && vencedor == null;
  }

  public String fazerJogada(int x) {
    int playerNum = jogadorAtual.getNumero();
    int y = tabuleiro.fazerJogada(x, playerNum);

    if (y == -1)
      return "Jogada Inválida \n";

    System.out.println("\n Ganhou?: " + checkWinHorizontal(x, y) + "\n");

    trocarJogadores();
    return tabuleiro.toString();
  }

  private boolean checkWinVertical(int x, int y) {
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

  public boolean checkWinHorizontal(int x, int y) {
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

  public boolean checkWinDiagonais(int x, int y) {
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
        return true;
    }

    return false;
  }

}
