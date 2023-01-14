/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version.pkg1.welcom.page;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hadia
 */
public class ListOnlinePlayersController implements Initializable {

    @FXML
    private ListView<String> list;
    @FXML
    private Button home;
    @FXML
    private Label welcom;
    @FXML
    private Label username;
    @FXML
    private Button startgame;

    Thread th;
    PrintStream ps;
    DataInputStream dis;
    Socket sSocket;
    ArrayList<String> onlinePlayers;
    String sum;
    ObservableList<String> items = FXCollections.observableArrayList();
    static ListOnlinePlayersController listOnlinePlayersController;

    /**
     * Initializes the controller class.
     */
    public ListOnlinePlayersController (){
    listOnlinePlayersController=this;
    
    }
    public void displayName(String name) {
        username.setText(name);
        //   System.out.println(username.getText());

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            startgame.setVisible(false);
            sSocket = new Socket("127.0.0.1", 5005);
            ps = new PrintStream(sSocket.getOutputStream());
            dis = new DataInputStream(sSocket.getInputStream());
            ps.println("onlinePlayers*");
System.out.println(username.getText());
             
            //list.setItems(items);
            th=new Thread(new Runnable(){
                @Override
                public void run() {
                    
                    try {
                        sum=dis.readLine();
                        
                        String [] parts=sum.split("\\*");
                        for(int i=0;i<parts.length;i++)
                            if(!parts[i].equals(username.getText()))
                         items.add(parts[i]);
                        //onlinePlayers.add(dis.readLine());
                        //System.out.println(onlinePlayers.get(0));
                        Platform.runLater(new Runnable(){
                            @Override
                            public void run() {
                                
                                list.setItems(items);
                            }
                        });
                        
                    } catch (IOException ex) {
                        Logger.getLogger(ListOnlinePlayersController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                            }
            });
            th.start();
            
                list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    
                    String name = list.getSelectionModel().getSelectedItem().toString();
                    System.out.println(name);
                    System.out.println(username.getText());

                    String message = ("request*" + username.getText() + "*" + name);
                    ps.println(message);

                }
                });
            } catch (IOException ex) {
                    Logger.getLogger(ListOnlinePlayersController.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }    

    @FXML
    private void gotohomescreen(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOnlinePlayersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onlineGameScreen(ActionEvent event) {
        try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("OnlineGameScreen.fxml"));
                        Parent root = loader.load();
                       //  OnlineGameScreenController onlineGameScreenController = loader.getController();
                        // onlineGameScreenController.displayNames(username.getText(),list.getSelectionModel().getSelectedItem().toString());
                        Scene scene = new Scene(root);
                        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();} catch (IOException ex) {
                        Logger.getLogger(ListOnlinePlayersController.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }
    public void buttonPress() {
    startgame.setVisible(true);
    
    }
}
