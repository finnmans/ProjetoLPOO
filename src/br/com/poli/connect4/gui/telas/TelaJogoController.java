
package br.com.poli.connect4.gui.telas;

import br.com.poli.connect4.Partida;
import br.com.poli.connect4.gui.JanelaPrincipal;
import br.com.poli.connect4.singletons.PartidaBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Text;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaJogoController implements Initializable {

  public Label j1;
  public Label j2;
  Partida partida;
  
  //public static Label jog1;
  //public static Label jog2;

  
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    PartidaBuilder builder = PartidaBuilder.getInstance();
    this.partida = builder.MakePartida();
    
    System.out.println("[TelaJogo] Inicializando");
    System.out.println("[TelaJogo] Jogadores:");
    System.out.println("[TelaJogo] " + builder.getUserName(0));
    System.out.println("[TelaJogo] " +builder.getUserName(1));
    
//    Font font = Font.loadFont("file:gui/fonts/Blambot Casual Bold.ttf",32);
//    Font.loadFont(JanelaPrincipal.class.getResource("fonts/Blambot Casual Bold.ttf").toExternalForm(), 10);
//    j1.setFont(font);
//    j2.setFont(font);
    j1.setText(builder.getUserName(0));
    j2.setText(builder.getUserName(1));

  }
}