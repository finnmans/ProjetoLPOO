package br.com.poli.connect4.gui.telas;

import br.com.poli.connect4.gui.JanelaPrincipal;
import br.com.poli.connect4.singletons.PartidaBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaCadastroController implements Initializable {
  @FXML
  private Button mainButton;
  @FXML
  private TextArea tFieldP2;
  @FXML
  private TextArea tFieldP1;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    System.out.println("[Tela de Cadastro] Inicializando");
  }

  public void handleStart(ActionEvent actionEvent) throws IOException {
    if(tFieldP1.getText().isEmpty()) {
       JanelaPrincipal.showAlert(Alert.AlertType.ERROR, JanelaPrincipal.WINDOW.getScene().getWindow(),"Form Error!", "O Jogador 1 precisa de um nome");
      return;
    }
    if(tFieldP2.getText().isEmpty()) {
      JanelaPrincipal.showAlert(Alert.AlertType.ERROR, JanelaPrincipal.WINDOW.getScene().getWindow(),
        "Form Error!", "O Jogador 2 precisa de um nome");
      return;
    }

    var builder = PartidaBuilder.getInstance();
    builder.setUserName(tFieldP1.getText(),0);
    builder.setUserName(tFieldP2.getText(),1);
    
    Parent rootGame = FXMLLoader.load(getClass().getResource("TelaJogo.fxml"));
    JanelaPrincipal.setScene(rootGame);

  }

  
}
