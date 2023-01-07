/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package version.pkg1.welcom.page;

import com.sun.org.apache.xpath.internal.patterns.NodeTest;
import java.awt.JobAttributes;
import java.io.IOException;
import java.net.URL;
import java.sql.DatabaseMetaData;
import java.util.Random;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import version.pkg1.welcom.page.HardLevel.Move;
import static version.pkg1.welcom.page.HardLevel.checkState;
import static version.pkg1.welcom.page.HardLevel.findBestMove;
import static version.pkg1.welcom.page.HardLevel.minimax;
import static version.pkg1.welcom.page.HardLevel.isMovesLeft;



/**
 * FXML Controller class
 *
 * @author abdallahelgedawy
 */
public class GameScreenExpertController implements Initializable {

    
    
        
    private boolean winner = false;
    private Boolean computerWin = false ;
    private String player = "O";
    private String computer = "x";
    private Boolean playerWin = false ;
    public Button[][] board=new Button[3][3];
    private Button buttonPressed;
    int moveNum = 0;
    Move bestMove;

    
    @FXML
    private Label player_name;
    @FXML
    private Button play_again_btn;
    @FXML
    private Button exit_btn;
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
    private Label player_score;
    @FXML
    private Label computer_score;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        board[0][0] = btn1;
        board[0][1] = btn2;
        board[0][2] = btn3;
        board[1][0] = btn4;
        board[1][1] = btn5;
        board[1][2] = btn6;
        board[2][0] = btn7;
        board[2][1] = btn8;
        board[2][2] = btn9;
 }         
    @FXML
    private void buttonPressed(ActionEvent e) {
      
        for (Button[] btns : board) {
            for (Button btn : btns) {
             
                btn.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
                    
                    if(!winner){
                        if(btn.getText().equals("")){
                           btn.setText("O");
                          
                     if (moveNum + 1 < 9) {  
                        bestMove = findBestMove(board);
                        board[bestMove.row][bestMove.col].setText("X");
                     //   board[bestMove.row][bestMove.col].setMouseTransparent(true);
                        // System.out.println(bestMove.row);
                         //  System.out.println(bestMove.col);
                        
                    }

                    moveNum += 2;
                    
                     
                    if (moveNum >= 5) {
                        
                        int result = checkState(board);
 
                        if (result == 10) {
                            int score=Integer.parseInt(player_score.getText().toString());
                            score+=1;
                            player_score.setText(""+score);
                            System.out.println(score);
                            playerWin = true;
                            winner = true;
               

                      
                          //  xScore++;
                          //  System.out.println("the x score is" + xScore);

                        } else if (result == -10) {
                            computerWin=true;
                           

                int score=Integer.parseInt(computer_score.getText().toString());
               score+=1;
                            computer_score.setText(""+score);  
                            winner = true;

                        } else if (isMovesLeft(board) == false) {
                            
                          //  tieScore++;
                            
                            
                            System.out.println("Draw");
                           winner = true;
                        }
                    }
                     }
                
                    }
                    
                    
        });
        

    }
}
          
    }
    
       
    @FXML
    private void playagain(ActionEvent event) {
    computerWin=false;
    player="O";
    winner = false ; 
    moveNum = 0;
    buttonPressed(event);
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
       


    


    
    @FXML
    private void homescreen(ActionEvent event) throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       Scene scene = new Scene(root); 
       Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.show();
    }


        
        
               
     public void displayName(String username) {
		player_name.setText(""+username);
	}


 

}