package src.com.lpoo;

public class Tabuleiro {
    private int[][] peçaTabuleiro = new int[6][7]; //peças no tabuleiro

    public int[][] getPeçaTabuleiro() {
        return peçaTabuleiro;
    }

    public void setPeçaTabuleiro(int[][] peçaTabuleiro) {
        this.peçaTabuleiro = peçaTabuleiro;
    }

    public void desenharTabuleiro() { //desenhar o tabuleiro

        System.out.println(" (0) (1) (2) (3) (4) (5) (6)");
        System.out.println("|---.---.---.---.---.---.---|");

        for (int i = 0; i < 6; i++) {
            System.out.print("|");
            for (int j = 0; j < 7; j++) {

                if (peçaTabuleiro[i][j] == 0) //condição para saber se eh um espaço vazio
                    System.out.print("   |");
                else
                    System.out.print(" " + peçaTabuleiro[i][j] + " |");//printar onde fez a jogada

            }
            System.out.println("\n|---.---.---.---.---.---.---|");//linhas de separação

        }

    }

    // Não sei se isso funciona mas parece algo utilizavel
    public void fazerJogada(int position, int jogador) {

        if (position >= peçaTabuleiro.length) {
            System.out.println("Jogada Invalida"); // sera alterado
            return;
        }

        for (int i = 0; i < peçaTabuleiro.length; i++) {
            int linhaAtual = peçaTabuleiro[i][position];

            if (linhaAtual == 0) // caso for 0, passa pra proxima
                continue;
            else {
                peçaTabuleiro[i - 1][position] = jogador; // caso tenha achado alguma campo preenchido, se colocar na
                                                          // posição anterior
                return;
            }
        }

        peçaTabuleiro[peçaTabuleiro.length - 1][position] = jogador; // caso n tenha achado nada, se coloca no final
                                                                     // da coluna
    }

}
