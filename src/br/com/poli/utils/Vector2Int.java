/*
   Projeto de LPOO
  
    Dupla:
     Alexandre Candido Souza
     Felipe Vasconcelos
 */

package br.com.poli.utils;

/**
 * Classe Auxiliar que guarda um par ordenado de inteiros (X,Y);
 */
public class Vector2Int {
  private int x;
  private int y;

  public int getY() {
    return y;
  }

  public int getX() {
    return x;
  }

  public final void setXY(int x, int y) {
    this.setX(x);
    this.setY(y);
  }

  public final void setX(int x) {
    this.x = x;
  }

  public final void setY(int y) {
    this.y = y;
  }

  public Vector2Int(int x, int y) {
    this.setX(x);
    this.setY(y);
  }

  public boolean compare(int x, int y) {
    return this.getX() == x && this.getY() == y;
  }

}
