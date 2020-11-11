
package br.com.poli.connect4.gui.telas;

import br.com.poli.connect4.Jogador;
import br.com.poli.connect4.Partida;
import br.com.poli.connect4.gui.JanelaPrincipal;
import br.com.poli.connect4.singletons.PartidaBuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TelaJogoController implements Initializable {

  public Label j1;
  public Label j2;
  public Group grupoPecas;
  private ImageView[][] pecas;
  private Partida partida;
  private Image p1peca;
  private Image p2peca;


  public void log(PartidaBuilder builder) {
    System.out.println("[TelaJogo] Inicializando");
    System.out.println("[TelaJogo] " + builder.getUserName(0));
    System.out.println("[TelaJogo] " + builder.getUserName(1));
    System.out.println("[TelaJogo] \n" + "Tabuleiro Carregado: " + pecas[0].length + "x" + pecas.length);
    System.out.println("\n \t[TelaJogo>Partida] \n" + partida.getTabuleiroString());
  }


  @Override
  public void initialize(URL location, ResourceBundle resources) {
    //Criação da Partida

    PartidaBuilder builder = PartidaBuilder.getInstance();
    this.partida = builder.MakePartida();
    this.pecas = new ImageView[partida.getAltura()][partida.getLargura()];

    for (Node node : grupoPecas.getChildren()) {
      if (!(node instanceof ImageView)) continue;
      String[] pos = node.getId().split("-");
      ImageView view = (ImageView) node;
      int x = Integer.parseInt(pos[1]);
      int y = Integer.parseInt(pos[0]);

      this.pecas[y][x] = view;
      view.setVisible(false);
    }


    p1peca = new Image(JanelaPrincipal.class.getResource("telas/images/PeçaJogadaVermAtivo-7.png").toString());
    p2peca = new Image(JanelaPrincipal.class.getResource("telas/images/PeçaJogadaAzulAtivo-6.png").toString());


    setPecaImage(1, 5, 1);
    togglePeca(1, 5, true);

    //printar no console
    log(builder);

    //GUI SETUP
    Font font = Font.loadFont(JanelaPrincipal.class.getResource("fonts/Blambot-Casual-Bold.ttf").toExternalForm(), 32);

    j1.setFont(font);
    j2.setFont(font);
    j1.setText(builder.getUserName(0));
    j2.setText(builder.getUserName(1));

  }

  private void setPecaImage(int x, int y, int jogador) {
    pecas[y][x].setImage(jogador == 1 ? p1peca : p2peca);
  }

  private void togglePeca(int x, int y, boolean active) {
    pecas[y][x].setVisible(active);
  }


  public void makePlay(ActionEvent event) {
    Node node = (Node) event.getSource();
    String data = (String) node.getUserData();
    int value = Integer.parseInt(data);
    System.out.println(data);

    int y;
    
    //Scanner scanner = new Scanner(System.in);
    var users = new PartidaBuilder();
    Jogador vencedor = null;
    boolean empate = false;
    // String msgBaseJogada = "%-20s: jogou na coluna: %x %n";
    
    if (!empate && vencedor == null) {
      
      System.out.println(String.format("%-40s%n", " ").replace(" ", "-")); // Printar a linha no tamanho certo
      System.out.printf("%s | Digite a posição (0-6): ", partida.getJogadorAtual());
      int x = value;

      try {
        y = partida.fazerJogada(x);
        setPecaImage(x,y,partida.getJogadorAtual().getNumero());
        togglePeca(x,y,true);
        partida.fazerJogada(x);
      } catch (Exception e) {
        System.out.println("\n\u001B[31mposição inválida, tente novamente! \u001B[0m\n");
      }
      
     // setPecaImage(x,y,partida.getJogadorAtual());

      System.out.println(partida.getTabuleiroString());
      vencedor = partida.getVencedor();
      empate = partida.isEmpate();
      
    }
    

  }


  }
  
  
  
  
  
  
