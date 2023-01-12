/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version.pkg1.welcom.page;

import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.util.Duration;

/**
 *
 * @author abdallahelgedawy
 */
public class client extends Thread {
Socket client;
ServerSocket server;
 
public client() throws IOException{
    server = new ServerSocket(5005);
    th.start();
  

}
 Thread th;
    DataInputStream dis;
    PrintStream ps; 
    @Override
    public void run() {
        while (true) {
            try {
                client = server.accept(); 
                dis=new DataInputStream(client.getInputStream());
                ps=new PrintStream(client.getOutputStream());
                String msg = dis.readLine();
                StringTokenizer s = new StringTokenizer("*");
                String data = s.nextToken();
                String rest = s.nextToken();
                process(data, rest);

            } catch (IOException ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void process(String data , String rest) {
        switch (data) {
            case "requset":   
                receivedrequest(rest);
                break;
            case "refused":
                RefuseRequest(rest);
                break;
                
                case"No Response":
                    noResponse();
                    break;
                    case"play":
                        play();
                        

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
                    // go to game online screen

                } else if (checks.get() == No) {
                    ps.println("refused*" + sender + "*" + receiver );
                } else {
                    ps.print("No Response*" + sender);
                }
            
        
    }

    public void RefuseRequest(String rest) {
                StringTokenizer s = new StringTokenizer(rest,"*");
               // String names = rest;
                String sender = s.nextToken();
                String receiver = s.nextToken();
                Alert alert = new Alert(AlertType.NONE);
                ButtonType Yes = new ButtonType("Ok");
                alert.setTitle("Reject Dialog");
                alert.setHeaderText(sender + " Refused to Challenge you!");
                alert.getDialogPane().getButtonTypes().addAll(Yes);
                
            }
  /*  public void Accept(String rest){
        
    } */

    public void noResponse(){
        Alert alert = new Alert(AlertType.NONE);
        alert.setTitle("Reject Dialog");
        alert.setHeaderText("No response!!");
        
    }
    public void play(){
        // run online game 
    }
}
