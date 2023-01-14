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
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author hadia
 */
public class ClientSide extends Thread{
    Socket client;
 DataInputStream dis;
    PrintStream ps; 
    Thread th ;
     OnlineGameScreenController onlineGameScreenController;
    
     SignUpController signUpController;
    

public ClientSide(){}
public void connection(){
try {
          client = new Socket ("127.0.0.1",5005);
          dis=new DataInputStream(client.getInputStream());
          ps=new PrintStream(client.getOutputStream());
      } catch (IOException ex) { 
          Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
      }
reading();
}

public void reading(){
th= new Thread(() -> {
   
        while (true) {
            try {
              
                String msg = dis.readLine();
                System.out.println("msg="+msg);
                int index2=msg.indexOf("*");
                 String data =msg.substring(0, index2);
                 String rest=msg.substring(index2+1);
                System.out.println(data+rest);
                process(data,rest );

            } catch (IOException ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
  });
     th.start();
}


public void process(String data , String rest) throws IOException {
        switch (data) {
            case "signup":
               Platform.runLater(()->{ 
               SignUpController.signUp.labelEdit(rest);
               //System.out.println(rest);
               });
               
               break;
            case "login":
                Platform.runLater(()->{ 
               LoginController.logIn.labelEdit(rest);
               //System.out.println(rest);
               });
                break;
            case "request":
                System.out.println(rest);
                receivedrequest(rest);
                break;
            case "refused":
                RefuseRequest(rest);
                System.out.println("refuse");
                break;
                
                case"No Response":
                    noResponse();
                    break;
                    case"play":
                        play();
                        break;
                    case "gameTic":
                onlineGameScreenController.oppturn(rest);
                break;
                    

            default:
                throw new AssertionError();
        }
    }

public void receivedrequest(String rest) {

                // String opponentName = null ;'
                StringTokenizer s = new StringTokenizer(rest,"*");
                // String names = rest;
                String sender = s.nextToken();
                String receiver = s.nextToken();
                Platform.runLater(new Runnable(){
                    
                public void run(){
                ButtonType Yes = new ButtonType("Yes");
                ButtonType No = new ButtonType("No");
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("Confirm");
                // alert.setHeaderText("Required Fields Empty");
                
                alert.setHeaderText(sender + "Wants To Play With you");
                alert.getDialogPane().getButtonTypes().addAll(Yes, No);
                alert.showAndWait();

                 PauseTransition delay = new PauseTransition(Duration.seconds(15));
                 delay.setOnFinished(e -> alert.hide());
                Optional<ButtonType> checks = alert.showAndWait();
                if (checks.get() == Yes) {
                    ps.println("accept*" + sender +  "*" +  receiver);
                    try {
                        play();
                        // go to game online screen
                    } catch (IOException ex) {
                        Logger.getLogger(ClientSide.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (checks.get() == No) {
                    ps.println("refused*" + sender + "*" + receiver );
                } else {
                    ps.print("No Response*" + sender);
                }
                delay.play();
                }
        });
    }

    public void RefuseRequest(String rest) {
                StringTokenizer s = new StringTokenizer(rest,"*");
               // String names = rest;
                String reciever = s.nextToken();
                String sender = s.nextToken();
                 Platform.runLater(new Runnable(){
                    
                public void run(){
                Alert alert = new Alert(Alert.AlertType.NONE);
                ButtonType Yes = new ButtonType("Ok");
                alert.setTitle("Reject Dialog");
                alert.setHeaderText(sender + " Refused to Challenge you!");
                alert.getDialogPane().getButtonTypes().addAll(Yes);
                alert.showAndWait();
                }
                 });
            }
  /*  public void Accept(String rest){
        
    } */

    public void noResponse(){
         Platform.runLater(new Runnable(){
                    
                public void run(){
        Alert alert = new Alert(Alert.AlertType.NONE);
        ButtonType ok = new ButtonType("Ok");
        alert.setTitle("Reject Dialog");
        alert.setHeaderText("No response!!");
         alert.getDialogPane().getButtonTypes().addAll(ok);
                alert.showAndWait();
                }
         });
    }
  
       public void play() throws IOException  {
        Platform.runLater(new Runnable(){
                    
                public void run(){
                   
        ListOnlinePlayersController.listOnlinePlayersController.buttonPress();
                }
        });
    }
public void sending(String message){
   ps.println(message);
}
}
