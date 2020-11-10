
package br.com.poli.connect4.gui.telas;

import br.com.poli.connect4.Partida;
import br.com.poli.connect4.singletons.PartidaBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Text;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaJogoController implements Initializable {
  
  Partida partida;

  @FXML
  private Label j1;
  @FXML
  private Label j2;
  
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    var builder = PartidaBuilder.getInstance();
    
    System.out.println("[Tela DeJogo] Inicializando");
    System.out.println("[Tela DeJogo] Jogadores:");
    System.out.println("[Tela DeJogo] " + builder.getUserName(0));
    System.out.println("[Tela DeJogo] " +builder.getUserName(1));
    
    j1.setText(builder.getUserName(0));
    j2.setText(builder.getUserName(1));
  }
}