
package br.com.poli.connect4.gui.telas;

import br.com.poli.connect4.Partida;
import br.com.poli.connect4.gui.JanelaPrincipal;
import br.com.poli.connect4.singletons.PartidaBuilder;

import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaJogoController implements Initializable {

  public Label j1;
  public Label j2;
  public Group grupoPecas;
  public ImageView[][] pecas;
  Partida partida;
  

  public void log(PartidaBuilder builder){
    System.out.println("[TelaJogo] Inicializando");
    System.out.println("[TelaJogo] " +  builder.getUserName(0));
    System.out.println("[TelaJogo] " +  builder.getUserName(1));
    System.out.println("[TelaJogo] \n" +  "Tabuleiro Carregado: " + pecas[0].length + "x" + pecas.length);
    System.out.println("\n \t[TelaJogo>Partida] \n" +  partida.getTabuleiroString());
  }

  
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    //Criação da Partida
    
    PartidaBuilder builder = PartidaBuilder.getInstance();
    this.partida = builder.MakePartida();
    this.pecas = new ImageView[partida.getAltura()][partida.getLargura()];

    for (Node node:grupoPecas.getChildren()) {
      if(!(node instanceof ImageView)) continue;
      String[] pos = node.getId().split("-");
      ImageView view = (ImageView)node;
      int x = Integer.parseInt(pos[1]);
      int y = Integer.parseInt(pos[0]);
      
      this.pecas[y][x] = view;
      view.setVisible(false);
    }
    
    togglePeca(1,5,true);
    
    //printar no console
    log(builder);
    
    //GUI SETUP
    Font font = Font.loadFont(JanelaPrincipal.class.getResource("fonts/Blambot-Casual-Bold.ttf").toExternalForm(),32);

    j1.setFont(font);
    j2.setFont(font);
    j1.setText(builder.getUserName(0));
    j2.setText(builder.getUserName(1));

  }
  
  private void togglePeca(int x, int y, boolean active){
    pecas[y][x].setVisible(active);
  }
}