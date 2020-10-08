/**
 *  Primeira Parte do Projeto de LPOO
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

  // TODO: Comentado até eu descobrir como pegar o IndexOf de um elemento :)

  // public Jogador GetJogadorByNumero(int numero) {
  // for (int i = 0; i < this.jogadores.length; i++) {
  // var jogador = this.jogadores[i];
  // if (jogador == null)
  // continue;
  //
  // if (jogador.getNumero() == numero)
  // return jogador;
  // }
  //
  // throw new ArrayIndexOutOfBoundsException("Id de jogador invalido");
  // }

  public void SetJogadorAtual(Jogador jogador) {
    this.jogadorAtual = jogador;
  }

  public void SetJogadorAtualByIndex(int arrayIndex) {
    SetJogadorAtual(GetJogadorByIndex(arrayIndex));
    this.jogadorAtualIndex = arrayIndex;
  }

  // TODO: Comentado até eu descobrir como pegar o IndexOf de um elemento :)

  // public void SetJogadorAtualByNumero(int numero) {
  // var jogador = GetJogadorByNumero(numero);
  // SetJogadorAtual(jogador);
  // }

  // #endregion

  // #region Construtores
  public Partida(String nomeJogador1, String nomeJogador2) {
    this(new Jogador(0, nomeJogador1), new Jogador(1, nomeJogador2));
  }

  public Partida(Jogador jogador1, Jogador jogador2) {
    Random random = new Random();
    this.jogadores = new Jogador[] { jogador1, jogador2 };
    SetJogadorAtualByIndex(random.nextInt() % 2 == 0 ? 0 : 1);

    String msg = String.format("%-20s: começará jogando!", jogadorAtual);

    System.out.println();
    System.out.println(msg);
    System.out.println(String.format("%-40s", " ").replace(" ", "-")); // Printar a linha no tamanho certo
  }
  // #endregion

  public void TrocarJogadores() {
    if (jogadorAtualIndex == 0)
      SetJogadorAtualByIndex(1);
    else
      SetJogadorAtualByIndex(0);
  }

  public void FazerJogada(int x) {
    String msg = String.format("%-20s: jogou na coluna: %x", jogadorAtual, x);

    System.out.println(msg);
    TrocarJogadores();
  }

}
