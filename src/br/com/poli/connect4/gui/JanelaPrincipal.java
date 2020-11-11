package br.com.poli.connect4.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;

public class JanelaPrincipal extends Application {
  public static final int WIDTH  = 440;
  public static final int HEIGHT = 590;
  private static double xOffset = 0;
  private static double yOffset = 0;
  
  public static Stage WINDOW;
  
  public void setUp(){
    launch();
  }
  
  @Override
  public void start(Stage primaryStage) throws IOException {
    WINDOW = primaryStage;
    primaryStage.initStyle(StageStyle.TRANSPARENT);
    Parent rootCadastro = FXMLLoader.load(getClass().getResource("telas/TelaCadastro.fxml"));

  
    
    
    WINDOW.setResizable(false);
    WINDOW.setTitle("LIG 4");
    setScene(makeScene(rootCadastro));
    WINDOW.show();
  }
  
  public static Scene makeScene(Parent root){
    return new Scene(root,WIDTH,HEIGHT);
  }
  public static void setScene(Parent root){
    setScene(makeScene(root));
  }
  
  public static void setScene(Scene scene){
    scene.setFill(Color.TRANSPARENT);
    scene.getStylesheets().add(JanelaPrincipal.class.getResource("styles/ClubPenguin.css").toExternalForm());

    scene.setOnMousePressed(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        xOffset = event.getX();
        yOffset = event.getY();
      }
    });

    scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        WINDOW.setX(event.getScreenX() - xOffset);
        WINDOW.setY(event.getScreenY() - yOffset);
      }
    });
    
    WINDOW.setScene(scene);
  }

  public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.initStyle(StageStyle.TRANSPARENT);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.initOwner(owner);
    alert.getDialogPane().getScene().setFill(Color.TRANSPARENT);
    alert.show();
  }
  
}
