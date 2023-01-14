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
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import static version.pkg1.welcom.page.GameScreenController.mp;
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
public static MediaPlayer mp;
    Dialog video=new Dialog();
    DialogPane pane=new DialogPane();
    MediaView view;
    boolean flag=false;   
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
                              // player win
                              if (result == 10) {
                              int score=Integer.parseInt(player_score.getText().toString());
                              score+=1;
                              player_score.setText(""+score);
                              System.out.println(score);
                              playerWin = true;
                              winner = true;
                                int mediaHeight=400;
                                int mediaWidth=450;
                                int prefWidth=500;
                                int prefHeight=400;
                              displayVideo("win.mp4","Congratulations",mediaHeight,mediaWidth,prefWidth,prefHeight,22,20);
                          //  xScore++;
                          //  System.out.println("the x score is" + xScore);
                            // Computer win
                           } else if (result == -10) {
                              computerWin=true;
                                int mediaHeight=350;
                                int mediaWidth=1600;
                                int prefWidth=400;
                                int prefHeight=390;
                             displayVideo("lose.mp4","Hard luck",mediaHeight,mediaWidth,prefWidth,prefHeight,60,20);
                              int score=Integer.parseInt(computer_score.getText().toString());
                              score+=1;
                              computer_score.setText(""+score);  
                              winner = true;
                              // No one wins (DRAW)
                             } else if (isMovesLeft(board) == false) {
                          //  tieScore++;   
                                System.out.println("Draw");
                                winner = true;
                                int mediaHeight=1100;
                                int mediaWidth=500;
                                int prefWidth=550;
                                int prefHeight=270;
                            displayVideo("Draw.mp4","It's a draw",mediaHeight,mediaWidth,prefWidth,prefHeight,22,20);  
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
    
    
  public void displayVideo(String videopath,String title,int mediaHeight,int mediaWidth,int prefWidth,int prefHeight, int x,int y){  
    Media media = new Media(getClass().getResource(videopath).toExternalForm());
    mp = new MediaPlayer(media); 
    view=new MediaView();
    view.setFitHeight(mediaHeight);
    view.setFitWidth(mediaWidth);
    view.setX(x);
    view.setY(y);
    video = new Dialog<>();
    DialogPane dialogPane=video.getDialogPane();
    video.getDialogPane().setPrefSize(prefWidth, prefHeight);
    video.setTitle(title);
    video.getDialogPane().getChildren().add(view);
    ButtonType ok = new ButtonType("ok",ButtonBar.ButtonData.OK_DONE);
    video.getDialogPane().getButtonTypes().add(ok);
    view.setMediaPlayer(mp);   
    dialogPane .getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
    dialogPane.getStyleClass().add("infoDialog");
    video.show(); 
    mp.play();
    flag=false;
   // btn_watch_game.setDisable(false);        
  }
}