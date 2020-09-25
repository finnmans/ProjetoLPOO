package src.com.lpoo;

public class Main {

  public static void main(String[] args) {
    Jogador jog1 = new Jogador(1, "Alex");
    Jogador jog2 = new Jogador(2, "Felipe");

    Partida partida = new Partida(jog1, jog2);
    partida.FazerJogada(0);
    partida.FazerJogada(1);
    partida.FazerJogada(2);
    partida.FazerJogada(3);
  }
}
