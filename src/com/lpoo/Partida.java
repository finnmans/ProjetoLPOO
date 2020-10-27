/**
 *  Projeto de LPOO
 * 
 *   Dupla:
 *    Alexandre Candido Souza
 *    Felipe Vasconcelos
 */

package src.com.lpoo;

import java.util.Random;

public class Partida {
  private Jogador[] jogadores;
  private Jogador jogadorAtual;
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

    String msg = String.format("%-20s: começará jogando!", jogadorAtual);

    System.out.println();
    System.out.println(msg);
    System.out.println(String.format("%-40s", " ").replace(" ", "-")); // Printar a linha no tamanho certo
  }
  // #endregion

  public void trocarJogadores() {
    if (jogadorAtualIndex == 0)
      setJogadorAtualByIndex(1);
    else
      setJogadorAtualByIndex(0);
  }

  public void fazerJogada(int x) {
    String msg = String.format("%-20s: jogou na coluna: %x", jogadorAtual, x);

    System.out.println(msg);
    tabuleiro.fazerJogada(x, jogadorAtual.getNumero());
    tabuleiro.desenharTabuleiro();
    trocarJogadores();
  }

}
