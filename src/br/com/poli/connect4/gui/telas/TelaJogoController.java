package br.com.poli.connect4.gui.telas;

import br.com.poli.connect4.Partida;
import br.com.poli.connect4.singletons.PartidaBuilder;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class TelaJogoController implements Initializable {
  Partida partida;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    var builder = PartidaBuilder.getInstance();

    System.out.println("[Tela DeJogo] Jogadores:");
    System.out.println("[Tela DeJogo] " + builder.getUserName(0));
    System.out.println("[Tela DeJogo] " +builder.getUserName(1));
  }
}
