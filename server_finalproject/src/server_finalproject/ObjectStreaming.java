/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_finalproject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

/**
 *
 * @author hadia
 */
public class ObjectStreaming extends Thread{
    Socket client;
   ObjectOutputStream out;
   ObjectInputStream in;
   ServerSocket server;
   Thread th =new Thread(this);

    public ObjectStreaming() {
       while(true){
        try {
            this.server = new ServerSocket(5000);
            client=server.accept();
            out =new ObjectOutputStream(client.getOutputStream());
            in =new ObjectInputStream(client.getInputStream());
            start();
            //streaming(client);
            /*out.close();
            in.close();
            client.close();
            server.close();*/
        } catch (IOException ex) {
            Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
        }
            }  
    }
    
    

    /*public void run()
    {
    
        while(true)
        {
            try {
                SignUp obj=(SignUp) in.readObject();
                System.out.println("username="+obj.getUsername());
            } catch (IOException ex) {
                Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
            }
            } 
        }*/
     public void request(){
        try {
            String req = in.readLine();
            StringTokenizer s = new StringTokenizer(req,"**");
            String senderName=s.nextToken();
            String recivedName=s.nextToken();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    ButtonType Yes = new ButtonType("Yes");
                    ButtonType No = new ButtonType ("No");
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setTitle("Confirm");
                   // alert.setHeaderText("Required Fields Empty");
                    alert.setContentText(senderName+"Wants To Play With you");
                    alert.getDialogPane().getButtonTypes().addAll(Yes,No);
                    alert.showAndWait();
                    
                    PauseTransition delay = new PauseTransition(Duration.ofMillis(1000));
                    delay.setOnFinished(e -> alert.hide());
                    Optional<ButtonType> checks = alert.showAndWait();
                    if(checks.get()==Yes){
                        try {
                            out.writeChars(senderName+"Accept You Challnge");
                            // go to game online screen 
                        } catch (IOException ex) {
                            Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                    }
                    else if (checks.get()==No){
                        try {
                            out.writeChars(recivedName+" refuese your invite");
                        } catch (IOException ex) {
                            Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else {
                        try {
                            out.writeChars("No Response");
                        } catch (IOException ex) {
                            Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
         
     }
    
    
    }
    

