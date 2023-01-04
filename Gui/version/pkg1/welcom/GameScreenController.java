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
                buttonPressed.setText(player);


                //if(EasyOrHardLevelController.isrecord)
                // AccessFile.writeFile(buttonPressed.getId()+buttonPressed.getText()+".");
                 
                if(player=="X"){
                    player="O";
                }
                else{
                    player="X";
                }  
                
                checkState();
                if(!winner){
                    computerTurn();
                    checkState();
                }
            }else{
                if(isFullGrid()){
                    //txtWinner.setText("It's a Draw");
                   // btnPlayAgain.setVisible(true);
                }
                
            }
        }else{
            // show video
        }

    }
        
        
        //check state
           private void checkState (){
               //ROWS
            if(btn1.getText().equals(btn2.getText()) && btn2.getText().equals(btn3.getText()) && !btn1.getText().equals("")){
            //drawLine(btn1,btn3);
            if(btn1.getText().equals("O")){
               // txtWinner.setText("you won!");
                //displayVideo
                //display = true;
               // score += 10;
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
            if(btn4.getText().equals("O")){
               // txtWinner.setText("you won!");
                //displayVideo
               // display = true;
                //score += 10;
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
            if(btn7.getText().equals("O")){
                //txtWinner.setText("you won!");
                //displayVideo
                //display = true;
               // score += 10;
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
            if(btn1.getText().equals("O")){
                //txtWinner.setText("you won!");
                //displayVideo
                //display = true;
                //score += 10;
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
            if(btn2.getText().equals("O")){
               // txtWinner.setText("you won!");
                //displayVideo
               // display = true;
              //  score += 10;
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
            if(btn3.getText().equals("O")){
                //txtWinner.setText("you won!");
               // displayVideo
              // display = true;
              // score += 10;
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
            if(btn1.getText().equals("O")){
                //txtWinner.setText("you won!");
                //displayVideo
                //display = true;
                
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
            if(btn3.getText().equals("O")){
               // txtWinner.setText("you won!");
                //displayVideo
                //display = true;
                //score += 10;
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
        /*
        if(display){
            displayVideo("winner");             
            System.out.println("Synch");
            prefs.putInt("score",score);
            labScore.setText(""+ score);  
            btnPlayAgain.setVisible(true);
        }else if(computerWin){
            System.out.println("computer wins");
            displayVideo("lose");
           btnPlayAgain.setVisible(true); 
           
        }
        */

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
        
        myBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            //System.err.println("button pressed");
            buttonPressed = (Button) e.getSource();


               /* if(buttonPressed.getText().equals("")){
                    buttonPressed.setText(""+player);
**/
    
                if(buttonPressed.getText().equals("")){
                    buttonPressed.setText(""+player);
                    
                    //if(EasyOrHardLevelController.isrecord)
                   // AccessFile.writeFile(buttonPressed.getId()+buttonPressed.getText()+".");

                    if(player=="X"){
                        player="O";
                    }
                    else{
                        player="X";
                   }        
                }else{
                    //اللعبة خلصت ومفيش حد كسب
                    if(isFullGrid() && !winner){
                        //txtWinner.setText("It's a Draw");
                        //btnPlayAgain.setVisible(true);
                    }
                }
            }
        });
        myBtn.fire();

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
    }
    
    public void displayName(String username) {
		player_name.setText(""+username);
	}
    
}
