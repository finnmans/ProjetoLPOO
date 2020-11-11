
package br.com.poli.connect4.gui.telas;

import br.com.poli.connect4.Jogador;
import br.com.poli.connect4.Partida;
import br.com.poli.connect4.gui.JanelaPrincipal;
import br.com.poli.connect4.singletons.PartidaBuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
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
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // Criação da Partida

    PartidaBuilder builder = PartidaBuilder.getInstance();
    this.partida = builder.MakePartida();
    this.pecas = new ImageView[partida.getAltura()][partida.getLargura()];
    var jogadorInicial = partida.getJogadorAtual();

    for (Node node : grupoPecas.getChildren()) {
      if (!(node instanceof ImageView))
        continue;
      String[] pos = node.getId().split("-");
      ImageView view = (ImageView) node;
      int x = Integer.parseInt(pos[1]);
      int y = Integer.parseInt(pos[0]);

      this.pecas[y][x] = view;
      view.setVisible(false);
    }

    p1peca = new Image(JanelaPrincipal.class.getResource("telas/images/PeçaJogadaVermAtivo-7.png").toString());
    p2peca = new Image(JanelaPrincipal.class.getResource("telas/images/PeçaJogadaAzulAtivo-6.png").toString());

    // printar no console
    log(builder);
    System.out.printf("%n%-20s: começará jogando!%n", jogadorInicial);
    System.out.println(String.format("%-40s%n", " ").replace(" ", "-")); // Printar a linha no tamanho certo
    System.out.println(partida.getTabuleiroString());

    JanelaPrincipal.showAlert(Alert.AlertType.CONFIRMATION, JanelaPrincipal.WINDOW.getScene().getWindow(),
        "Inicio da Partida", jogadorInicial + ": começará jogando!");

    // GUI SETUP
    Font font = Font.loadFont(JanelaPrincipal.class.getResource("fonts/Blambot-Casual-Bold.ttf").toExternalForm(), 32);

    j1.setFont(font);
    j2.setFont(font);
    j1.setText(builder.getUserName(0));
    j2.setText(builder.getUserName(1));

    DropShadow shadow = new DropShadow();
    shadow.setOffsetY(8.0);
    // Setting the effect to the text
    
    j1.setEffect(shadow);
    j2.setEffect(shadow);
  }

  private void setPecaImage(int x, int y, int jogador) {
    pecas[y][x].setImage(jogador == 1 ? p1peca : p2peca);
  }

  private void togglePeca(int x, int y, boolean active) {
    pecas[y][x].setVisible(active);
  }
  
  private void changeColorPlayer(int jogadorat){ 
   // Color blue = new Color(0,103,154,100);
    (jogadorat==1? j2:j1).setTextFill(Color.rgb(0,104,154,0.5));
    (jogadorat==1? j1:j2).setTextFill(Color.WHITE);
  }
  

  public void makePlay(ActionEvent event) throws IOException {
    Node node = (Node) event.getSource();
    String data = (String) node.getUserData();
    int x = Integer.parseInt(data);
    int y = -1;
    int jogador = partida.getJogadorAtual().getNumero();

    Jogador vencedor = null;
    boolean empate = false;

    System.out.println(String.format("%-40s%n", " ").replace(" ", "-")); // Printar a linha no tamanho certo
    System.out.printf("%s | Digite a posição (0-6): ", partida.getJogadorAtual());

    try {
      y = partida.fazerJogada(x);
      setPecaImage(x,y,partida.getJogadorAtual().getNumero());
      togglePeca(x,y,true);
      changeColorPlayer(partida.getJogadorAtual().getNumero());
    } catch (Exception e) {
      System.out.println("\n\u001B[31mposição inválida, tente novamente! \u001B[0m\n");

      JanelaPrincipal.showAlert(Alert.AlertType.ERROR, JanelaPrincipal.WINDOW.getScene().getWindow(),
          "Ei man, isso é ilegal!", "posição Inválida, tente novamente!");

      return;
    }

    setPecaImage(x, y, jogador);
    togglePeca(x, y, true);

    System.out.println(partida.getTabuleiroString());
    vencedor = partida.getVencedor();
    empate = partida.isEmpate();

    if (!empate && vencedor == null)
      return;

    if (vencedor != null) {
      JanelaPrincipal.showAlert(Alert.AlertType.INFORMATION, JanelaPrincipal.WINDOW.getScene().getWindow(), "VITÓRIA",
          vencedor + " VENCEU!!");
      System.out.printf("%n %s VENCEU!!%n", vencedor);
    }

    if (empate) {
      JanelaPrincipal.showAlert(Alert.AlertType.WARNING, JanelaPrincipal.WINDOW.getScene().getWindow(), "EMPATE!",
          "ITS A TIE!!");
      System.out.println("ITS A TIE!");
    }

    System.out.println("\nJogo acabou"); // ta aq so pra saber se tem erro em algum lugar

    Parent rootGame = FXMLLoader.load(getClass().getResource("TelaCadastro.fxml"));
    JanelaPrincipal.setScene(rootGame);

  }

}
