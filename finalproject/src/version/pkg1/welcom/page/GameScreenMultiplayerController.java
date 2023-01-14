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
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class GameScreenMultiplayerController implements Initializable {
    private String player = "O";
    private boolean playerOneTurn = false;
  //  private boolean playeTwoTurn = false;
    private int playerOneScore ;
    private int playerTwoScore ;
    private Button clickedButton ; 
    private String winner ; 
    private boolean isWinner = false;
    private boolean playerOneWin = false;
    private boolean playerTwoWin = false;
    private Dialog<String> diaolg ;
    
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
    private Button playagain;
    @FXML
    private Button homescreen;
    @FXML
    private  Label player1;
    @FXML
    private  Label player2;
    @FXML
    private Label score1;
    @FXML
    private Label score2;

    /**
     * Initializes the controller class.
     */
    
    public void displaynames(String username1 , String username2){
       player1.setText(username1);
       player2.setText(username2);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    playagain.setVisible(false);
    }   
     
   

    @FXML
    private void buttonpressed(ActionEvent event) {
        if(!isWinner){
            clickedButton = (Button) event.getSource();
            if(clickedButton.getText().equals("")){
                clickedButton.setText(player);
            }
            if(player=="O"){
                player ="X";
                player1.setTextFill(Paint.valueOf("#54cba7"));
               player2.setTextFill(Paint.valueOf("#c41e3a"));
            }else{
                player="O";
               player2.setTextFill(Paint.valueOf("#54cba7"));
               player1.setTextFill(Paint.valueOf("#c41e3a"));
            }
            checkIsWin(); 
        }
        
        
    }
    
    
    
    
private void checkIsWin(){
        String b1=btn1.getText();
        String b2=btn2.getText();
        String b3=btn3.getText();
        String b4=btn4.getText();
        String b5=btn5.getText();
        String b6=btn6.getText();
        String b7=btn7.getText();
        String b8=btn8.getText();
        String b9=btn9.getText();
        
        // check first row
    if(b1.equals(b2)&&b1.equals(b3)&&!b1.equals("")){
         isWinner = true;
        colorWinner(btn1,btn2,btn3);
        if(b1.equals("O")){
            playerOneWin = true;
           
        }else
        {
            playerTwoWin=true;
          
        }
        playagain.setVisible(true);
    } 
   
    // check first colum
    if(b1.equals(b4)&&b1.equals(b7)&&!b1.equals("")){
         isWinner = true;
        colorWinner(btn1,btn4,btn7);
        if(b1.equals("O")){
            playerOneWin = true;
          
        }else
        {
            playerTwoWin=true;
          
        }
        playagain.setVisible(true);
    }

    //check diagonal 1 
    if(b1.equals(b5)&&b1.equals(b9)&&!b1.equals("")){
         isWinner = true;
        colorWinner(btn1,btn5,btn9);
        if(b1.equals("O")){
            playerOneWin = true;
        
        }else
        {
            playerTwoWin=true;
         
        }
        playagain.setVisible(true);
    } 
   
    //check secon row
    if(b4.equals(b5)&&b4.equals(b6)&&!b4.equals("")){
         isWinner = true;
        colorWinner(btn4,btn5,btn6);
        if(b4.equals("O")){
            playerOneWin = true;
          
        }else
        {
            playerTwoWin=true;
          
        }
        playagain.setVisible(true);
    }
   
    // check third row
    if(b7.equals(b8)&&b7.equals(b9)&&!b7.equals("")){
         isWinner = true;
        colorWinner(btn8,btn7,btn9);
        if(b7.equals("O")){
            playerOneWin = true;
          
        }else
        {
            playerTwoWin=true;
       
        }
        playagain.setVisible(true);
        
    } 
  
    // check second colume
     if(b2.equals(b5)&&b2.equals(b8)&&!b2.equals("")){
          isWinner = true;
         colorWinner(btn2,btn5,btn8);
        if(b2.equals("O")){
            playerOneWin = true;
         
        }else
        {
            playerTwoWin=true;
          
        }
        playagain.setVisible(true);
    } 
  
     // check third row
    if(b3.equals(b6)&&b3.equals(b9)&&!b3.equals("")){
         isWinner = true;
        colorWinner(btn3,btn6,btn9);
        if(b3.equals("O")){
            playerOneWin = true;
           
        }else
        {
            playerTwoWin=true;
          
        }
        playagain.setVisible(true);
    } 
    
    //check diagonal 2
    if(b3.equals(b5)&&b3.equals(b7)&&!b3.equals("")){
         isWinner = true;
        colorWinner(btn3,btn5,btn7);
        if(b3.equals("O")){
            playerOneWin = true;
         
        }else if (b3.equals("X"))
        {
            playerTwoWin=true;
           
        }
      playagain.setVisible(true);  
    }
   
    if(playerOneWin){
         playerOneScore +=1;
         setScore1(playerOneScore);
        ButtonType ok = new ButtonType("Ok", ButtonData.OK_DONE);
        //ButtonType Cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        Alert a = new Alert(Alert.AlertType.NONE); 
        a.setHeaderText("   CONGRATULATION!");
        a.getDialogPane().getButtonTypes().add(ok);
        //a.setContentText(player1.getText()+" "+"win");
        a.setContentText("             "+player1.getText()+" "+"win");
        
        DialogPane dialogPane = a.getDialogPane();
        dialogPane.getStylesheets().add(
        getClass().getResource("/css/style2.css").toExternalForm());
        dialogPane.getStyleClass().add("infoDialog");
        
        
        a.showAndWait();

        playerOneWin = false;
       
    
    }else if(playerTwoWin){
       playerTwoScore+=1;
       setScore2(playerTwoScore);
      ButtonType ok = new ButtonType("Ok", ButtonData.OK_DONE);
      //ButtonType Cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        Alert a = new Alert(Alert.AlertType.NONE); 
        a.setHeaderText("    CONGRATULATIONS!");
        a.getDialogPane().getButtonTypes().add(ok);
        a.setContentText("             "+player2.getText()+" "+"win");
        
        DialogPane dialogPane = a.getDialogPane();
        dialogPane.getStylesheets().add(
        getClass().getResource("/css/style2.css").toExternalForm());
        dialogPane.getStyleClass().add("infoDialog");
        a.showAndWait();
     
       playerTwoWin = false;
       
    }else if(checkIsDraw()){   
      diaolg = new Dialog<>();
      diaolg.setHeaderText("               Draw!");
      diaolg.setContentText("        "+"it's Draw guyes");
      ButtonType ok = new ButtonType("Ok", ButtonData.OK_DONE);
      //ButtonType Cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

     diaolg.getDialogPane().getButtonTypes().addAll(ok);
      
        DialogPane dialogPane = diaolg.getDialogPane();
        dialogPane.getStylesheets().add(
        getClass().getResource("/css/style2.css").toExternalForm());
        dialogPane.getStyleClass().add("infoDialog");

        diaolg.showAndWait();
    }
     
}
    
private boolean checkIsDraw(){
        String b1=btn1.getText();
        String b2=btn2.getText();
        String b3=btn3.getText();
        String b4=btn4.getText();
        String b5=btn5.getText();
        String b6=btn6.getText();
        String b7=btn7.getText();
        String b8=btn8.getText();
        String b9=btn9.getText();
    if (!b1.equals("")&&!b2.equals("")&&!b3.equals("")&&!b4.equals("")&&!b5.equals("")&&!b6.equals("")&&!b7.equals("")&&!b8.equals("")&&!b9.equals("")){
      return true; 
    }else{
        return false;
    }
   
}    
    
private void colorWinner(Button b1 ,Button b2 , Button b3  ){
    b1.setStyle("-fx-background-color: green;");
    b2.setStyle("-fx-background-color: green;");
    b3.setStyle("-fx-background-color: green;");
} 
@FXML
private void playagain(ActionEvent event) throws IOException  {
    playagain.setVisible(false);
    isWinner = false ; 
    btn1.setText("");
    btn2.setText("");
    btn3.setText("");
    btn4.setText("");
    btn5.setText("");
    btn6.setText("");
    btn7.setText("");
    btn8.setText("");
    btn9.setText("");
    btn1.setStyle("-fx-background-color: none;");
    btn2.setStyle("-fx-background-color: none;");
    btn3.setStyle("-fx-background-color: none;");
    btn4.setStyle("-fx-background-color: none;");
    btn5.setStyle("-fx-background-color: none;");
    btn6.setStyle("-fx-background-color: none;");
    btn7.setStyle("-fx-background-color: none;");
    btn8.setStyle("-fx-background-color: none;");
    btn9.setStyle("-fx-background-color: none;");  
}

public void setScore1(int x){
    playerOneScore = Integer.parseInt(score1.getText().toString());
    playerOneScore=x;
    score1.setText(""+playerOneScore);
}

public void setScore2(int x){
    playerTwoScore = Integer.parseInt(score2.getText().toString());
    playerTwoScore=x;
    score2.setText(""+playerTwoScore); 
}

@FXML
private void homescreen(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       Scene scene = new Scene(root); 
       Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.show();
}
    
}
