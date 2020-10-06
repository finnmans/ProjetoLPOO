package src.com.lpoo;

public class Pessoa {
  private final String nome;

  public Pessoa(String nome) {
    this.nome = nome;
  }

  @Override
  public String toString() {
    return "O nome do jogador é" + this.getNome();
  }

  public String getNome() {
    return nome;
  }
}
