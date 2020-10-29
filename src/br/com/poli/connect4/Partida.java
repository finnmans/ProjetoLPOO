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

    if (tabuleiro.fazerJogada(x, jogadorAtual.getNumero()) == -1)
      return "Jogada Inválida \n";

    trocarJogadores();

    return tabuleiro.toString();
  }

}
