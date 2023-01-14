/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version.pkg1.welcom.page;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

/**
 * FXML Controller class
 *
 * @author User
 */
public class OnlineGameScreenController implements Initializable {
    private boolean myturn = true;
    private boolean oppturn = false;
    private boolean gamestate = true;
    PrintStream ps;
    DataInputStream dis;
     public static MediaPlayer mp;
    Dialog video = new Dialog();
    DialogPane pane = new DialogPane();
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
    private Label player1_name;
    @FXML
    private Label player2_name;
    @FXML
    private Label player1_score;
    @FXML
    private Label player2_score;
    @FXML
    private Button logout;
    private HashMap<String, Button> btn;
    String myTic="O";
    String oppTic;
    Boolean isWinner;
    Boolean player;
    
    
    

    /**
     * Initializes the controller class.
     */
   /* public void displayNames(String name1 ,String name2) {
        player1_name.setText(name1);
        player2_name.setText(name2);


    }*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       btn = new HashMap();

        btn.put("btn1", btn1);
        btn.put("btn2", btn2);
        btn.put("btn3", btn3);
        btn.put("btn4", btn4);
        btn.put("btn5", btn5);
        btn.put("btn6", btn6);
        btn.put("btn7", btn7);
        btn.put("btn8", btn8);
        btn.put("btn9", btn9);
        
    }    
//display player1 name
    @FXML
    private void buttonPressed(ActionEvent e) {
        
        Button buttonpressed;
        if(myturn && isWinner){
            buttonpressed = (Button) e.getSource();
            if(buttonpressed.getText().equals("")){
                buttonpressed.setText(myTic);
            }
            myturn = false;
            oppturn = true;
            ps.println("gameTic*"+player1_name.getText()+"*"+buttonpressed.getId()+"*"+myTic);
            }     
    }
    public void oppturn(String rest) throws IOException{
         //String oppPressed = dis.readLine();
         StringTokenizer s = new StringTokenizer(rest,"*");
         String id=s.nextToken();
         String oppTic=s.nextToken();
         Button btnOpp = btn.get(id);
          btnOpp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Button button = (Button) event.getSource();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            button.setText(oppTic);
                           checkIsWin();
                        }
                    });
                }
            });
            btnOpp.fire();
             if (oppTic.equals("O"))
                myTic="X";
            else
                myTic="O";
            myturn= true;
            oppturn = false;
           
    }
//    public void reset(){
//        
//    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        System.out.println(player1_name.getText());
       Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       Scene scene = new Scene(root); 
       Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.show();
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
        //colorWinner(btn1,btn2,btn3);
        if(b1.equals(myTic)){
            player = true;
           
        }
       // playagain.setVisible(true);
    } 
   
    // check first colum
    if(b1.equals(b4)&&b1.equals(b7)&&!b1.equals("")){
         isWinner = true;
        //colorWinner(btn1,btn4,btn7);
        if(b1.equals(myTic)){
            player = true;
          
        }
        //playagain.setVisible(true);
    }

    //check diagonal 1 
    if(b1.equals(b5)&&b1.equals(b9)&&!b1.equals("")){
         isWinner = true;
        //colorWinner(btn1,btn5,btn9);
        if(b1.equals(myTic)){
            player = true;
        
        }
        //playagain.setVisible(true);
    } 
   
    //check secon row
    if(b4.equals(b5)&&b4.equals(b6)&&!b4.equals("")){
         isWinner = true;
        //colorWinner(btn4,btn5,btn6);
        if(b4.equals(myTic)){
            player = true;
          
        }
        //playagain.setVisible(true);
    }
   
    // check third row
    if(b7.equals(b8)&&b7.equals(b9)&&!b7.equals("")){
         isWinner = true;
        //colorWinner(btn8,btn7,btn9);
        if(b7.equals(myTic)){
            player = true;
          
        }
        //playagain.setVisible(true);
        
    } 
  
    // check second colume
     if(b2.equals(b5)&&b2.equals(b8)&&!b2.equals("")){
          isWinner = true;
         //colorWinner(btn2,btn5,btn8);
        if(b2.equals(myTic)){
            player = true;
         
        }
        //playagain.setVisible(true);
    } 
  
     // check third row
    if(b3.equals(b6)&&b3.equals(b9)&&!b3.equals("")){
         isWinner = true;
        //colorWinner(btn3,btn6,btn9);
        if(b3.equals(myTic)){
            player = true;
           
        }
        //playagain.setVisible(true);
    } 
    
    //check diagonal 2
    if(b3.equals(b5)&&b3.equals(b7)&&!b3.equals("")){
         isWinner = true;
        //colorWinner(btn3,btn5,btn7);
        if(b3.equals(myTic)){
            player= true;
        }
      //playagain.setVisible(true);  
    }
   
    if(player){
        displayVideo("win.mp4","congratulations",400,400);
    }
    else if(!player){
             displayVideo("lose.mp4","Hard luck",400,400);   
       }
    else{
        displayVideo("Draw.mp4","it's a draw",400,400);
    }
 }
     

     public void displayVideo(String videopath, String title, int x, int y) {
        Media media = new Media(getClass().getResource(videopath).toExternalForm());
        mp = new MediaPlayer(media);
        view = new MediaView();
        video = new Dialog<>();
        video.getDialogPane().setMinSize(x, y);
        video.setTitle(title);
        video.getDialogPane().getChildren().add(view);
        ButtonType ok = new ButtonType("ok", ButtonBar.ButtonData.OK_DONE);
        video.getDialogPane().getButtonTypes().add(ok);
        view.setMediaPlayer(mp);
        video.show();
        mp.play();

    }

}