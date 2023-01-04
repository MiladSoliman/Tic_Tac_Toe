/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version.pkg1.welcom.page;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;


/**
 * FXML Controller class
 *
 * @author User
 */
public class GameScreenController implements Initializable {
    
    private Button buttonPressed;
    private boolean winner = false;
    private Boolean computerWin = false ;
    private String player = "O";




    @FXML

    private Boolean playerWin = false ;
    public static MediaPlayer mp;
     Dialog video=new Dialog();
       DialogPane pane=new DialogPane();
       MediaView view;
     
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
    private Label player_name;
    @FXML
    private Label player_score;
    @FXML
    private Label computer_score;
    @FXML
    private Button exit_btn;
    @FXML
    private Button play_again_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
        public void buttonPressed(ActionEvent e){
        if(!winner){
            //System.err.println("x");
            buttonPressed = (Button) e.getSource();
            if(buttonPressed.getText().equals("")){
                buttonPressed.setText("O");
                //if(EasyOrHardLevelController.isrecord)
                // AccessFile.writeFile(buttonPressed.getId()+buttonPressed.getText()+".");
            }
                 checkState();
                if(!winner){
                    computerTurn();
                    checkState();
                }
    }
        
        }
        
        //check state
           private void checkState (){
               //ROWS
            if(btn1.getText().equals(btn2.getText()) && btn2.getText().equals(btn3.getText()) && !btn1.getText().equals("")){

            //drawLine(btn1,btn3);

            colorWinner(btn1,btn2,btn3);

            if(btn1.getText().equals("O")){
               // txtWinner.setText("you won!");
                //displayVideo
                //display = true;
               // score += 10;


               playerWin=true;

               int score=Integer.parseInt(player_score.getText().toString());
               score+=1;
               player_score.setText(""+score);
               

               
            }else{
                //txtWinner.setText("computer won!");
                computerWin = true;
                 int score=Integer.parseInt(computer_score.getText().toString());
               score+=1;
               computer_score.setText(""+score);
            }
            winner = true;
        }
        else if(btn4.getText().equals(btn5.getText()) && btn5.getText().equals(btn6.getText()) && !btn4.getText().equals("")){

           // drawLine(btn4,btn6);

           colorWinner(btn4,btn5,btn6);

            if(btn4.getText().equals("O")){
               // txtWinner.setText("you won!");
                //displayVideo
               // display = true;
                //score += 10;


                playerWin=true;

                int score=Integer.parseInt(player_score.getText().toString());
               score+=1;
               player_score.setText(""+score);
            }else{
                //txtWinner.setText("computer won!");
                computerWin = true;
                 int score=Integer.parseInt(computer_score.getText().toString());
               score+=1;
               computer_score.setText(""+score);
            }
            winner = true;
        }
        else if(btn7.getText().equals(btn8.getText()) && btn8.getText().equals(btn9.getText()) && !btn7.getText().equals("")){

            //drawLine(btn7,btn9);

            colorWinner(btn7,btn8,btn9);

            if(btn7.getText().equals("O")){
                //txtWinner.setText("you won!");
                //displayVideo
                //display = true;
               // score += 10;


               playerWin=true;

               int score=Integer.parseInt(player_score.getText().toString());
               score+=1;
               player_score.setText(""+score);
            }else{
                //txtWinner.setText("computer won!");
                computerWin = true;
                  int score=Integer.parseInt(computer_score.getText().toString());
               score+=1;
               computer_score.setText(""+score);
            }
            winner = true;
        }

        //COLUMNS
        if(btn1.getText().equals(btn4.getText()) && btn4.getText().equals(btn7.getText()) && !btn1.getText().equals("")){

           // drawLine(btn1,btn7);

           colorWinner(btn1,btn4,btn7);

            if(btn1.getText().equals("O")){
                //txtWinner.setText("you won!");
                //displayVideo
                //display = true;
                //score += 10;

                playerWin=true;

                 int score=Integer.parseInt(player_score.getText().toString());
               score+=1;
               player_score.setText(""+score);
            }else{
               // txtWinner.setText("computer won!");
                computerWin = true;
                 int score=Integer.parseInt(computer_score.getText().toString());
               score+=1;
               computer_score.setText(""+score);
            }
            winner = true;
        }
        else if(btn2.getText().equals(btn5.getText()) && btn5.getText().equals(btn8.getText()) && !btn2.getText().equals("")){

            //drawLine(btn2,btn8);

            colorWinner(btn2,btn5,btn8);

            if(btn2.getText().equals("O")){
               // txtWinner.setText("you won!");
                //displayVideo
               // display = true;
              //  score += 10;

              playerWin=true;

                int score=Integer.parseInt(player_score.getText().toString());
               score+=1;
               player_score.setText(""+score);
            }else{
               // txtWinner.setText("computer won!");
                computerWin = true;
                  int score=Integer.parseInt(computer_score.getText().toString());
               score+=1;
               computer_score.setText(""+score);
            }
            winner = true;
        }
        else if(btn3.getText().equals(btn6.getText()) && btn6.getText().equals(btn9.getText()) && !btn3.getText().equals("")){

            //drawLine(btn3,btn9);

            colorWinner(btn3,btn6,btn9);

            if(btn3.getText().equals("O")){
                //txtWinner.setText("you won!");
               // displayVideo
              // display = true;
              // score += 10;

              playerWin=true;

                int score=Integer.parseInt(player_score.getText().toString());
               score+=1;
               player_score.setText(""+score);
            }else{
                //txtWinner.setText("computer won!");
                computerWin = true;
               int score=Integer.parseInt(computer_score.getText().toString());
               score+=1;
               computer_score.setText(""+score);
            }
            winner = true;
        }      
        //DIOGONAL
        
        if(btn1.getText().equals(btn5.getText()) && btn5.getText().equals(btn9.getText()) && !btn1.getText().equals("")){

            //drawLine(btn1,btn9);

            colorWinner(btn1,btn5,btn9);

            if(btn1.getText().equals("O")){
                //txtWinner.setText("you won!");
                //displayVideo
                //display = true;

                playerWin=true;

                int score=Integer.parseInt(player_score.getText().toString());
               score+=1;
               player_score.setText(""+score);            
            }else{
                //txtWinner.setText("computer won!");
                computerWin = true;
                        int score=Integer.parseInt(computer_score.getText().toString());
               score+=1;
               computer_score.setText(""+score);
            }
            winner = true;
        }
        else if(btn3.getText().equals(btn5.getText()) && btn5.getText().equals(btn7.getText()) && !btn3.getText().equals("")){

            //drawLine(btn3,btn7);

            colorWinner(btn3,btn5,btn7);

            if(btn3.getText().equals("O")){
               // txtWinner.setText("you won!");
                //displayVideo
                //display = true;
                //score += 10;

                playerWin=true;

                int score=Integer.parseInt(player_score.getText().toString());
               score+=1;
               player_score.setText(""+score); 
            }else{
                //txtWinner.setText("computer won!");
                computerWin = true;
                 int score=Integer.parseInt(computer_score.getText().toString());
               score+=1;
               computer_score.setText(""+score);
            }
            winner = true;
        }
 if(playerWin){
            displayVideo("Draw.mp4");             
           /* System.out.println("Synch");
            prefs.putInt("score",score);
            labScore.setText(""+ score);  
            btnPlayAgain.setVisible(true);*/
        }
        else if(computerWin){
            displayVideo("lose.mp4");
           /* System.out.println("computer wins");
           btnPlayAgain.setVisible(true); */    
        }
       else if (isFullGrid()){
           displayVideo("Draw.mp4");  
       }
    
    }
               
     private boolean isFullGrid(){

        if(!btn1.getText().equals("") && !btn2.getText().equals("") && !btn3.getText().equals("") && !btn4.getText().equals("")
                    && !btn5.getText().equals("") && !btn6.getText().equals("")&& !btn7.getText().equals("")
                    && !btn8.getText().equals("") && !btn9.getText().equals("")){
                    return true;
        }else{
            return false;
        }
    }
               
    private void computerTurn(){
        Random r;
        Button[] btns = {btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9};
        Button myBtn;
        do{
            r = new Random();
            //will generate numbers in the range 0 to 8 both inclusive.
            int i =r.nextInt(9);
            myBtn = btns[i];
            if(isFullGrid()){
                break;
            }
            //اول ملاقى  زراز يكون فاضى اطلع من اللوب عشان اكتب عليه 
        }while(!myBtn.getText().equals(""));
        myBtn.setText("X");
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
    private void playagain(ActionEvent event) {

        computerWin=false;
        player="O";
        winner = false ; 
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
    
    public void displayName(String username) {
		player_name.setText(""+username);
	}
    

    private void colorWinner(Button b1 ,Button b2 , Button b3  ){
    b1.setStyle("-fx-background-color: green;");
    b2.setStyle("-fx-background-color: green;");
    b3.setStyle("-fx-background-color: green;");
}
    
  public void displayVideo(String videopath){
    Media media = new Media(getClass().getResource(videopath).toExternalForm());
    mp = new MediaPlayer(media); 
    view=new MediaView();
    video = new Dialog<>();
    video.setHeight(300);
    view.getFitHeight();
    video.getDialogPane().getChildren().add(view);
    view.setMediaPlayer(mp);   
    video.show(); 
    mp.play();
           
  }

}
