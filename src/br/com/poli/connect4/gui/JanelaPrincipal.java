package br.com.poli.connect4.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JanelaPrincipal extends Application {
  public static final int WIDTH  = 440;
  public static final int HEIGHT = 614; 
  public static Stage WINDOW;

  public void setUp(){
    launch();
  }
  
  @Override
  public void start(Stage primaryStage) throws IOException {
    WINDOW = primaryStage;

    Parent rootCadastro = FXMLLoader.load(getClass().getResource("telas/TelaCadastro.fxml"));

    WINDOW.setTitle("LIG 4");
    WINDOW.setScene(new Scene(rootCadastro,WIDTH,HEIGHT));
    WINDOW.show();
  }
  
}
