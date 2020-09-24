package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        public class Partida {
            Jogador jogador1, jogador2;https://chat.whatsapp.com/KxPn4YRzyL8IJGkzi2Zf09
            boolean isFinalizado;
            Integer vencedor = 0;
            Integer playerAtual;

            playerAtual = (randomNumber()%2==0)? 1:0;

            public Partida(Jogador jogador1, Jogador jogador2) {
                this.jogador1 = jogador1;
                this.jogador2 = jogador2;
            }

            public void FazerJogada(int x){
                System.out.println("jogador " + playerAtual + " jogou em " + x);
                playerAtual = playerAtual == 1 ? 0 : 1;
            }
            public int randomNumber(int rng){
                Random random = new Random();
                return random.nextInt(rng);
                }

            }
        }
    }
