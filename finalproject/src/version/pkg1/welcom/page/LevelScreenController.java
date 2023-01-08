/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
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
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdallahelgedawy
 */
public class LevelScreenController implements Initializable {

    @FXML
    private Button Beginner;
    @FXML
    private Button Proficient;
    @FXML
    private Button GameScreenExpert;
    @FXML
    private Button homescreen;
    String playerName = null;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
@FXML
  private void GameScreen(ActionEvent event) throws Exception{
      // Parent root = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
      // Scene scene = new Scene(root);
      // Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
      // stage.setScene(scene);
      // stage.show();
       
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScreen.fxml"));	
        Parent root = loader.load();	
	GameScreenController gameScreenController = loader.getController();
	gameScreenController.displayName(playerName);
        
       //Parent root = FXMLLoader.load(getClass().getResource("LevelScreen.fxml"));
       Scene scene = new Scene(root);
       Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.show();
       

       
    }
     @FXML
      private void homescreen(ActionEvent event) throws Exception{
       Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       Scene scene = new Scene(root); 
       Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.show();
    }
      
          public void saveName(String username) {
		playerName=username;
	}

    @FXML
    private void GameScreenExpert(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScreenExpert.fxml"));	
        Parent root = loader.load();	
	GameScreenExpertController gameScreenController = loader.getController();
	gameScreenController.displayName(playerName);
        
       //Parent root = FXMLLoader.load(getClass().getResource("LevelScreen.fxml"));
       Scene scene = new Scene(root);
       Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.show();
    }
    
}

