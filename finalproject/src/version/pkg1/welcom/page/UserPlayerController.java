/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version.pkg1.welcom.page;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class UserPlayerController implements Initializable {

    @FXML
    private Button homescreen;
    @FXML
    private Button GameScreen;
    @FXML
    public TextField player1;
    @FXML
    private TextField player2;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void homescreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       Scene scene = new Scene(root); 
       Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.show();
    }

    @FXML
    private void GameScreen(ActionEvent event) throws IOException {
        String player_1 = player1.getText().toString();
        String player_2 = player2.getText().toString();
        if(player_1.length()==0||player_2.length()==0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Required Fields Empty");
            alert.setContentText("The Text fields must be filled "
                    + "out.\nPlease try again.");
           // alert.showAndWait();
            
            
            
               //Alert a = new Alert(Alert.AlertType.NONE); 
        //a.setHeaderText("    CONGRATULATIONS!");
       // a.getDialogPane().getButtonTypes().add(ok);
       // a.setContentText("             "+player2.getText()+" "+"win");
        
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
        getClass().getResource("/css/style3.css").toExternalForm());
        dialogPane.getStyleClass().add("infoDialog");
        alert.showAndWait();
        }else{
      FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScreenMultiplayer.fxml"));	
      Parent root = (Parent)loader.load();
       GameScreenMultiplayerController game2 = loader.getController();
       game2.displaynames(player_1, player_2);  
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    }
}