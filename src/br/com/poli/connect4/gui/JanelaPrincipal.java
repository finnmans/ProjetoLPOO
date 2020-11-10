package br.com.poli.connect4.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class JanelaPrincipal extends Application {
  public static final int WIDTH  = 440;
  public static final int HEIGHT = 590; 
  public static Stage WINDOW;
  
  public void setUp(){
    launch();
  }
  
  @Override
  public void start(Stage primaryStage) throws IOException {
    WINDOW = primaryStage;
    Parent rootCadastro = FXMLLoader.load(getClass().getResource("telas/TelaCadastro.fxml"));
    WINDOW.setResizable(false);
    WINDOW.setTitle("LIG 4");
    WINDOW.setScene(makeScene(rootCadastro));
    WINDOW.show();
  }
  
  public static Scene makeScene(Parent root){
    return new Scene(root,WIDTH,HEIGHT);
  }
  public static void setScene(Parent root){
    setScene(makeScene(root));
  }
  
  public static void setScene(Scene scene){
    WINDOW.setScene(scene);
  }

  public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.initOwner(owner);
    alert.show();
  }
  
}
