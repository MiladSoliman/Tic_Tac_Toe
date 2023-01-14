/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package version.pkg1.welcom.page;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author abdallahelgedawy
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
    
    Thread th;
   PrintStream ps;
   DataInputStream dis;
   Socket sSocket;

    /**
     * Initializes the controller class.
     */
 @Override
    public void initialize(URL url, ResourceBundle rb) {
   
                
                ObservableList<String> items = FXCollections.observableArrayList("abdallah", "milad", "hadia", "mai");
                list.setItems(items);
        
    
//        Connection Conn = null;
//         try {
//           Conn = DriverManager.getConnection("jdbc:derby://localhost:1527/finalproject","tictactoe","tictactoe");
//           
//       } catch (SQLException e) {
//             System.out.println(e.getMessage());
//             
//       }
//       Statement stmt = null;
//       ResultSet rs = null;
//              try {
//           stmt = Conn.createStatement();
//           rs = stmt.executeQuery("SELECT * FROM Players WHERE status LIKE ONLINE");
//
//           while (rs.next()) {
//                items.add(rs.getString(1));
//               System.out.println(rs.getString(1));
//           }
//       } catch (SQLException e) {
//
//       }
            

list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
    @Override
    
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
       
            String name = list.getSelectionModel().getSelectedItem().toString();
              System.out.println(name);
            System.out.println(username.getText());
                
            String message = ("request*"+username.getText()+"*"+name);
            sendRequest(message);
            
        
    }
});
            }
    
public void displayName(String name) {
        username.setText(name);
        //   System.out.println(username.getText());

    }
public void sendRequest(String message){
        try {
             sSocket = new Socket ("127.0.0.1",5005);
             ps = new PrintStream(sSocket.getOutputStream());
             dis = new DataInputStream(sSocket.getInputStream());
             ps.println(message);
             
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
}
