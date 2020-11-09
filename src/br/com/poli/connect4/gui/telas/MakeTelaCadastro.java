package br.com.poli.connect4.gui.telas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;


public class MakeTelaCadastro {
  
  final Parent root;
  private Scene scene;
  
  public MakeTelaCadastro(Parent root)  {
    this.root = root;
    this.scene = new Scene(root,335,600);
  }
  
  public static MakeTelaCadastro makeTela() throws IOException{
    Parent root = FXMLLoader.load(MakeTelaCadastro.class.getResource("TelaCadastro.fxml"));
    return new MakeTelaCadastro(root);
  }
  
  public Scene getScene(){
    return this.scene;
  }
  
  public Scene makeScene(){
    this.scene = new Scene(root,500,800);
    return this.scene;
  }
  
}

