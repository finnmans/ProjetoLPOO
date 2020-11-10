
package br.com.poli.connect4.gui.telas;

import br.com.poli.connect4.Partida;
import br.com.poli.connect4.singletons.PartidaBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Text;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaJogoController implements Initializable {
  
  Partida partida;
  
  //public static Label jog1;
  //public static Label jog2;
  
  @FXML
  private Label j1;
  @FXML
  private Label j2;
  
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    var builder = PartidaBuilder.getInstance();
    //Font font = Font.loadFont("file:gui/fonts/Blambot Casual Bold.ttf",32);
    //Font.loadFont(CustomFontApp.class.getResource("Blambot Casual Bold.ttf").toExternalForm(), 10);
   j1.setText(builder.getUserName(0));
   j2.setText(builder.getUserName(1));
   //j1.setFont(font);
   //j2.setFont(font);
    System.out.println("[Tela DeJogo] Inicializando");
    System.out.println("[Tela DeJogo] Jogadores:");
    System.out.println("[Tela DeJogo] " + builder.getUserName(0));
    System.out.println("[Tela DeJogo] " +builder.getUserName(1));

  }
}