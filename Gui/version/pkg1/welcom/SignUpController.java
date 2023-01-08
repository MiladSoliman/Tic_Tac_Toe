/*
<<<<<<< HEAD:Gui/version/pkg1/welcom/SignUpController.java
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version.pkg1.welcom.page;

=======
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package version.pkg1.welcom.page;

import java.io.IOException;
>>>>>>> abdallah:LevelScreenController.java
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
<<<<<<< HEAD:Gui/version/pkg1/welcom/SignUpController.java
=======
import javafx.scene.control.Button;
>>>>>>> abdallah:LevelScreenController.java
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
<<<<<<< HEAD:Gui/version/pkg1/welcom/SignUpController.java
 * @author USER
 */
public class SignUpController implements Initializable {
=======
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
   
>>>>>>> abdallah:LevelScreenController.java

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
<<<<<<< HEAD:Gui/version/pkg1/welcom/SignUpController.java
     @FXML
    private void GameScreen(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
      @FXML
=======
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
>>>>>>> abdallah:LevelScreenController.java
      private void homescreen(ActionEvent event) throws Exception{
       Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       Scene scene = new Scene(root); 
       Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.show();
    }
<<<<<<< HEAD:Gui/version/pkg1/welcom/SignUpController.java
    
}
=======
      
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

>>>>>>> abdallah:LevelScreenController.java
