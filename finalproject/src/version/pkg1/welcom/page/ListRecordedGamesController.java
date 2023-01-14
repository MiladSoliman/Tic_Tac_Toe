/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version.pkg1.welcom.page;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ListRecordedGamesController implements Initializable {

    @FXML
    private Button homescreen;
    @FXML
    private ScrollPane games_scroll_pan;
    @FXML
    private ListView<String> listgames_list_view;
    
   // ArrayList<String> list_of_names_games = new ArrayList<String>();
   private ObservableList<String> list_of_names_games =FXCollections.observableArrayList();
   String player_name;
   String player1_score;
   String player2_score;



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
    
    public void displaylistOfNamesGames(ArrayList<String> listOfNamesGames,String playerName,String player1score,String player2score) {
		list_of_names_games.addAll(listOfNamesGames);
                listgames_list_view.setItems(list_of_names_games);
                games_scroll_pan.setContent(listgames_list_view);
                player_name=playerName;
                player1_score=player1score;
                player2_score=player2score;

	}
    
    @FXML
        public void selectedItem(){
                 listgames_list_view.setOnMouseClicked((MouseEvent event) -> {
                     try {
                         System.out.println(listgames_list_view.getSelectionModel().getSelectedItems().toString());
                         
                         
                         String selectedItem = listgames_list_view.getSelectionModel().getSelectedItems().toString();
                         String record = selectedItem.toString().replace("[", "").replace("]", "");
                         System.out.println(record);
                         
                         
                         //changeSceneToWatchGame(event);
                         FXMLLoader loader = new FXMLLoader(getClass().getResource("ReplayGame.fxml"));
                         Parent root = loader.load();
                         ReplayGameController replayGameController = loader.getController();
                         replayGameController.watchGame(record,player_name,player1_score,player2_score);
                         
                         //Parent root = FXMLLoader.load(getClass().getResource("ListRecordedGames.fxml"));
                         Scene scene = new Scene(root);
                         Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                         stage.setScene(scene);
                         stage.show(); } catch (IOException ex) {
                         Logger.getLogger(ListRecordedGamesController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 
        });
        
        }

    
}
