package br.com.poli.utils;

public class Vector2Int {
  public int x;
  public int y;

  public Vector2Int(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public boolean compare(int x, int y) {
    return this.x == x && this.y == y;
  }
}
