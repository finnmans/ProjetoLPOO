package src.com.lpoo;

import java.util.Random;

public class Partida {
  Jogador jogador1, jogador2;
  Jogador vencedor;

  boolean isFinalizado;
  Integer jogadorAtual;

  public Partida(Jogador jogador1, Jogador jogador2) {
    Random random = new Random();
    this.jogador1 = jogador1;
    this.jogador2 = jogador2;
    this.jogadorAtual = random.nextInt() % 2 == 0 ? 1 : 2;

    String msg = String.format("Jogador [%d]: %s, começará jogando", jogadorAtual, GetJogadorById(jogadorAtual).nome);
    System.out.println(msg);
  }

  public void FazerJogada(int x) {
    String msg = String.format("jogador [%d]: %s jogou na coluna: %x", jogadorAtual, GetJogadorById(jogadorAtual).nome,
        x);
    System.out.println(msg);

    jogadorAtual = jogadorAtual == 1 ? 2 : 1;
  }

  private Jogador GetJogadorById(int id) {
    if (id == 1)
      return jogador1;
    else if (id == 2)
      return jogador2;
    else
      throw new NullPointerException("Id Invalido");
  }

}
