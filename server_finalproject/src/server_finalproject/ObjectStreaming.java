package server_finalproject;

import java.io.DataInputStream;
import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import static java.rmi.Naming.list;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Optional;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
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
   //ObjectOutputStream out;
   //ObjectInputStream in;
   ServerSocket server;
   Thread th;
   DataInputStream di;
    PrintStream ps;
   String [] arr;
    String str;
  
    public ObjectStreaming() {
        try {
             server = new ServerSocket(5005);
        } catch (IOException ex) {       
            Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
        }
        th=new Thread(()->{
            while(true){
                     try {
                        
                         client=server.accept();
                         new PlayerHandeler(client);
                     } catch (IOException ex) {
                Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
            }
                           
                           
                         
            } 
    });
        th.start();
}
}

    class PlayerHandeler extends Thread {
    DataInputStream di ; 
    PrintStream ps ;
    private String username;
    private String email;
    private String password;
    private int score;
    private String status;
    Socket sc;
    
    static Vector <PlayerHandeler> playervictor = new Vector <PlayerHandeler> ();
   static HashMap<String,Socket> connectedPlayer =new HashMap<String, Socket>();
    static  List<String> list =  new ArrayList<String>();   
    public PlayerHandeler (Socket client){
        try {
            sc=client;
           di=new DataInputStream(client.getInputStream());
           ps=new PrintStream(client.getOutputStream());
            //str=di.readLine();
            PlayerHandeler.playervictor.add(this);
               
            list=DataAccessLayerFinal.getConnectedPlayers();
           for(int i =0 ; i<list.size();i++){
            PlayerHandeler.connectedPlayer.put(list.get(i),client);
            } 
           //System.out.println(PlayerHandeler.connectedPlayer.get("milad")); 
            start();
         
    }   catch (IOException ex) {
            Logger.getLogger(PlayerHandeler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerHandeler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run(){
        while(true){
            String str;
            try {
                str = di.readLine();
                 stringDivision(str);
            } catch (IOException ex) {
                Logger.getLogger(PlayerHandeler.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }

   
        
public void stringDivision(String str){
    //int index1=0;
    int index2=str.indexOf("*");
    String process =str.substring(0, index2);
    String rest=str.substring(index2+1);
   //String [] parts=str.split("\\*");
   //System.out.println(process);
                 //System.out.println(rest);
		//for(int i=0;i<parts.length;i++)
		//System.out.println(parts[i]);
                //System.out.println(list.get(0));
                whichProcess(process,rest);
}
   public void whichProcess(String process,String rest){
       switch (process){
               case"signup":{
               String [] parts=rest.split("\\*");
               //System.out.println(parts[0]);
               Player p=new Player(parts[0], parts[1], parts[2], 0,"online");
               username=parts[0];
               PlayerHandeler.playervictor.add(this);
               System.out.println(PlayerHandeler.playervictor.get(0).username);
               System.out.println(PlayerHandeler.playervictor.get(0).sc);
           try {
               DataAccessLayerFinal.insert(p);
           } catch (SQLException ex) {
               Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
           }
               }
               break;
               case"Login":{
                  // login();
                 
               }
               
               case"request":{
                 //  request(rest);
               }
               break;
             
       }
               
            }

    /*public void request(String rest){
      
         //list =DataAccessLayerFinal.getConnectedPlayers();
         //String req = in.readLine();
         StringTokenizer s = new StringTokenizer(rest,"**");
         String senderName=s.nextToken();
         String reciverName=s.nextToken();
         for(int i =0 ;i<playervictor.size();i++){
             if(reciverName.equals(playervictor.get(i).username)){
               playervictor.get(i).ps.println("requset**senderName");
                 
             }
         }
     } */
}