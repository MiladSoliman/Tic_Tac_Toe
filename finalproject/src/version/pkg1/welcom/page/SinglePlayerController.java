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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hadia
 */
public class SinglePlayerController implements Initializable {

    @FXML
    private Button homescreen;
    @FXML
    private Button gotolevels;
    @FXML
    private TextField single_player_name;

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
    private void gotolevels(ActionEvent event) throws IOException {

        String username;
        if(single_player_name.getText().toString().isEmpty())
        {Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Required Fields Empty");
            alert.setContentText("Text field must be filled "
                    + "out.\nPlease try again.");
            alert.showAndWait();
        
        }
        else{

         username = single_player_name.getText().toString();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LevelScreen.fxml"));	
        Parent root = loader.load();	
	LevelScreenController levelScreenController = loader.getController();
	levelScreenController.saveName(username);
        
       //Parent root = FXMLLoader.load(getClass().getResource("LevelScreen.fxml"));
       Scene scene = new Scene(root);
       Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.show();
        }
    }
    
}
