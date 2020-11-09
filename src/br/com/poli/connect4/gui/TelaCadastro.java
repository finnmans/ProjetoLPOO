package br.com.poli.connect4.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaCadastro extends Application {
  @FXML
  private Button button;
  @FXML
  private Label label;
  private int counter = 0;
  
  public static void main(String[] args) {
    launch(args);
  }

  public void init(String[] args){
    launch(args);
  }
  
  @Override
  public void start(Stage primaryStage) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("TelaCadastro.fxml"));
    primaryStage.setTitle("LIG 4");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
  }

  public void handleButtonAction(ActionEvent actionEvent) {
    label.setText("Count: " + counter);
    counter++;
  }
}
