package br.com.poli.connect4.gui;

import br.com.poli.connect4.gui.telas.MakeTelaCadastro;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class JanelaPrincipal extends Application {
  public static Stage WINDOW;

  public void setUp(){
    launch();
  }
  
  @Override
  public void start(Stage primaryStage) throws IOException {
    WINDOW = primaryStage;
    
    var telaCadastro = MakeTelaCadastro.makeTela();
    
    WINDOW.setTitle("LIG 4");
    WINDOW.setScene(telaCadastro.getScene());
    WINDOW.show();
  }
  
}
