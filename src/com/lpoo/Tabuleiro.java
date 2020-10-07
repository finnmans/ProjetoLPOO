package src.com.lpoo;

public class Tabuleiro {
    // private char[][] gridTabuleiro = new char[12][28];
    private Integer[][] jogarTabuleiro = new Integer[6][7];

    public void desenharTabuleiro() {

        System.out.println(" (0) (1) (2) (3) (4) (5) (6)");

        for (int i = 0; i < 13; i++) {

            for (int j = 0; j < 29; j++) {

                if (j == 0 || j == 28)
                    System.out.printf("|"); // print das laterais

                if (j > 0 && j < 28) {// print das divisorias da grid dentro do range 1 a 27 e não printar
                                      // 2 coisas no msm espaço

                    if (i % 2 != 0) { // condição de entrada nas partes sem grid
                        if (j % 4 == 0)
                            System.out.printf("|");

                        else if (j % 2 != 0)
                            System.out.printf(" "); // print para organizar

                        else
                            System.out.printf("0"); // print que vai ser substituido pelo numero do jogador
                    }

                    else { // condição de entrada para grid
                        if (j % 4 == 0)
                            System.out.printf("."); // divisoria de 4 para printar no lugar certo
                        else if (i != 12)
                            System.out.print("-");

                        else
                            System.out.print("=");
                    }
                }
            }
            System.out.print("\n");
        }
    }

    // Não sei se isso funciona mas parece algo utilizavel
    public void verificarJogada(int position, int jogador) {

        if(position >= jogarTabuleiro.length){
            System.out.println("Jogada Invalida"); //sera alterado
            return;
        }
    
        for(int i=0 ; i < jogarTabuleiro[position].length;i++){
            int linhaAtual = jogarTabuleiro[i][position];
            
            if(linhaAtual == 0) // caso for 0, passa pra proxima
              continue;
            else{
              jogarTabuleiro[i - 1][position] = jogador; //caso tenha achado alguma campo preenchido, se colocar na posição anterior
              return;
            }
        }    
    
        jogarTabuleiro[jogarTabuleiro.length - 1][position] = jogador; //caso n tenha achado nada, se coloca no final da coluna
     }

}
