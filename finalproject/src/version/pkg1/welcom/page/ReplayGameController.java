/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version.pkg1.welcom.page;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ReplayGameController implements Initializable {

    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Label player1_name;
    @FXML
    private Label player2_name;
    @FXML
    private Label player1_score;
    @FXML
    private Label player2_score;
    @FXML
    private Button homescreen;

    String[] parts;
    String play;
    Thread th;
    boolean isO = true;
    String str;
    String filename=null;
    Thread thread;
    int i;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //System.out.println(filename);
       
        // TODO
    }    

    @FXML
    private void buttonPressed(ActionEvent event) {
    }

    @FXML
       private void homescreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       Scene scene = new Scene(root); 
       Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.show();
       
    }
      /* public void displayFileName(String file){
           filename=file;
           System.out.println(filename);
       }*/
       public void watchGame(String file,String playerName,String player1score,String player2score) {
           player1_name.setText(playerName);
         

   new Thread(() -> {
       FileInputStream fis = null;
       filename=file;
       try {
            fis = new FileInputStream("recordings"+"/"+filename);
            DataInputStream ds = new DataInputStream(fis);
            str = new String(ds.readUTF());
            System.out.println(str);
           
            //ds.close();
            parts = str.split(" ");
            play= parts[1];
             i = 0;

            
                while (i < parts.length) {
                    Platform.runLater(() -> {
                        if (isO) {
            play = "O";
            isO = false;
            } else {
            play = "X";
            isO = true;
            }
            switch (parts[i]) {
            case "btn1":
            
            btn1.setText(play);
            
            break;
            case "btn2":
            btn2.setText(play);
            
            break;
            case "btn3":
            
            btn3.setText(play);
            
            break;
            case "btn4":
            btn4.setText(play);
            
            break;
            case "btn5":
            System.out.println(parts[0]);
            btn5.setText(play);
            
            break;
            case "btn6":
            btn6.setText(play);
            
            break;
            case "btn7":
            btn7.setText(play);
            
            break;
            case "btn8":
            btn8.setText(play);
            
            break;
            case "btn9":
            btn9.setText(play);
            
            break;
            default:
            break;
            }
            if(play=="X"){
            player1_name.setTextFill(Paint.valueOf("#54cba7"));
            player2_name.setTextFill(Paint.valueOf("#c41e3a"));
            }else if(play=="O"){
            player2_name.setTextFill(Paint.valueOf("#54cba7"));
            player1_name.setTextFill(Paint.valueOf("#c41e3a"));
            }
                    });
                    Thread.sleep(1000);
                    i += 2;

                }
               // player1_score.setText(player1score);
               // player2_score.setText(player2score);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (FileNotFoundException ex) {
           Logger.getLogger(ReplayGameController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(ReplayGameController.class.getName()).log(Level.SEVERE, null, ex);
       }
        }).start();
   
     
  //fun    ,class    
}
}
    




