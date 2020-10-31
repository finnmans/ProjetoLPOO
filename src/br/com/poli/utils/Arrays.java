/**
 *  Projeto de LPOO
 * 
 *   Dupla:
 *    Alexandre Candido Souza
 *    Felipe Vasconcelos
 */

package br.com.poli.utils;

public final class Arrays {

  private Arrays() {
  }

  public static <T> boolean contemElemento(T[][] matriz, T alvo) {
    for (T[] linha : matriz) {
      if (contemElemento(linha, alvo))
        return true;
    }

    return false;
  }

  public static <T> boolean contemElemento(T[] array, T alvo) {
    for (T value : array) {
      if (value.equals(alvo)) {
        return true;
      }
    }
    return false;
  }

  public static boolean contemElemento(int[][] matriz, int alvo) {
    for (int[] linha : matriz) {
      if (contemElemento(linha, alvo))
        return true;
    }

    return false;
  }

  public static boolean contemElemento(int[] array, int alvo) {
    for (int value : array) {
      if (value == alvo) {
        return true;
      }
    }
    return false;
  }
}
