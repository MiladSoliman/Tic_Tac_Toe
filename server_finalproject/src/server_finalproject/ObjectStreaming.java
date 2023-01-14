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
                         System.out.println("client"+client);
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
    Thread thread;
    String sum="";
    static HashMap<String,PlayerHandeler> playerInGame =new HashMap<String, PlayerHandeler>();
    static HashMap<String,PlayerHandeler> playerVsSocket =new HashMap<String, PlayerHandeler>();
    
    static Vector <PlayerHandeler> playervictor = new Vector <PlayerHandeler> ();
   //static HashMap<String,Socket> connectedPlayer =new HashMap<String, Socket>();
    static  List<String> list =  new ArrayList<String>();   
    public PlayerHandeler (Socket client){
        try {
            sc=client;
           di=new DataInputStream(client.getInputStream());
           ps=new PrintStream(client.getOutputStream());
          /* PlayerHandeler.playervictor.add(this);
               System.out.println(PlayerHandeler.playervictor.get(0).username);
               System.out.println(PlayerHandeler.playervictor.get(0).sc);
               System.out.println(PlayerHandeler.playervictor.get(1).username);
               System.out.println(PlayerHandeler.playervictor.get(1).sc); */
         
           this.start();
         
    }   catch (IOException ex) {   
            Logger.getLogger(PlayerHandeler.class.getName()).log(Level.SEVERE, null, ex);
            
        }   
    }
    @Override
    public void run(){
        while(true){
            String str;
            try {
                str = di.readLine();
                System.out.println(str);
                 stringDivision(str);
            } catch (IOException ex) {
                Logger.getLogger(PlayerHandeler.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
    
    }

   
        
public void stringDivision(String str){
    int index2=str.indexOf("*");
    String process =str.substring(0, index2);
    String rest=str.substring(index2+1);
                whichProcess(process,rest);
}
   public void whichProcess(String process,String rest){
     
              
       switch (process){
               case"signup":{
               String [] parts=rest.split("\\*");
               //System.out.println(parts[0]);
               Player p=new Player(parts[0], parts[1], parts[2], 0,"online");
              
           try {
               String isValid=DataAccessLayerFinal.validateSignup(p);
               System.out.println(isValid);
               if(isValid=="valid"){
               DataAccessLayerFinal.insert(p);
                       //PlayerHandeler.playervictor.add(this);
              // System.out.println(PlayerHandeler.playervictor.get(0).username);
              // System.out.println(PlayerHandeler.playervictor.get(0).sc);
               }
               ps.println("signup*"+isValid);
               
               }
                catch (SQLException ex) {
               Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
           }
               }
               break;

               
               case"request":{
                 request(rest);
               }
              break;
               case"login":{
                login(rest);
               }
               break;
               case"refused":{
                   rejected(rest);
               }
               break;
               case"accept":{
                   accept(rest);
               }
               break;
               case"No Response":{
                   noResponse(rest);
               }
               break;
               case"onlinePlayers":{
                   onlinePlayers();
               }
               break;
               case "gameTic":{
           
               //String data = di.readLine();
               forward(rest);
            
               }
                break;
  
            }        
    
   }
   public void login(String rest){
          String [] parts=rest.split("\\*");
               System.out.println(parts[0]);               
               System.out.println(parts[1]);
                username=parts[0];
                
            
              
               Player player=new Player(parts[0], parts[1]);
               
           try {
               int isValidAccount=DataAccessLayerFinal.validateLogin(player);
               if (isValidAccount==1){
                   ps.println("login*"+"valid account");
              PlayerHandeler.playerVsSocket.put(username, this);
              
               }else {
                   ps.println("login*"+"invalid account");


               }
           } catch (SQLException ex) {
               Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
           }
               
   }
   
   
   
   
    public void request(String rest){
     
         //list =DataAccessLayerFinal.getConnectedPlayers();
         //String req = in.readLine();
         StringTokenizer s = new StringTokenizer(rest,"*");
         String senderName=s.nextToken();
         String reciverName=s.nextToken();
        // System.out.println();
        //for(PlayerHandeler i : playervictor){
            //if(i.username.equals(reciverName))
            PlayerHandeler.playerVsSocket.get(reciverName).ps.println("request*"+senderName+"*"+reciverName);
            //i.ps.println("request*"+senderName+"*"+reciverName);
            System.out.println("map");
            
        }
            
    
             
         
     
    
    public void accept(String rest){
        PlayerHandeler p1=null;
        PlayerHandeler p2=null;
        StringTokenizer s = new StringTokenizer(rest,"*");
         String challenger =s.nextToken();
          String accepter=s.nextToken();
          for(int i =0 ;i<playervictor.size();i++){
             if(challenger.equals(playervictor.get(i).username)){
                 p1=playervictor.get(i);}
                 else if(accepter.equals(playervictor.get(i).username)){
                    p2=playervictor.get(i); 
             }}
          playerInGame.put(challenger,p2);
          playerInGame.put(accepter,p1);
          
        // String challenger=s.nextToken();
         //for(int i =0 ;i<playervictor.size();i++){
           //  if(challenger.equals(playervictor.get(i).username)){
               //go to game screen for this socket
             //  playervictor.get(i).ps.println("play*");
             PlayerHandeler.playerVsSocket.get(challenger).ps.println("play*");
             }
         
        
        
    public void rejected(String rest){
        StringTokenizer s = new StringTokenizer(rest,"*");
         String rejecter =s.nextToken();
         String challenger=s.nextToken();
          //for(int i =0 ;i<playervictor.size();i++){
            // if(challenger.equals(playervictor.get(i).username)){
              // playervictor.get(i).ps.println("refused*"+rejecter+"*"+challenger);  
               PlayerHandeler.playerVsSocket.get(challenger).ps.println("refused*"+rejecter+"*"+challenger);
             }
         
         
    
    
    public void noResponse(String rest){
         String challenger =rest;
         for(int i =0 ;i<playervictor.size();i++){
             if(challenger.equals(playervictor.get(i).username)){
               playervictor.get(i).ps.println("No Response");    
             }
         }
    }
    public void onlinePlayers(){
       
            Thread th;
            
            th = new Thread(new Runnable(){
                @Override
                public void run() {
                        try {
                            list=DataAccessLayerFinal.getConnectedPlayers();
                            for(int i =0;i<list.size();i++){
                                          sum=sum+list.get(i)+"*";
                            }
                             ps.println(sum);
                                System.out.println(sum);
                            
                            //  ps.println("null");
                            Thread.sleep(5000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(PlayerHandeler.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                        Logger.getLogger(PlayerHandeler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            });
            th.start();
        }
    
    public void forward(String data){
               
               StringTokenizer s = new StringTokenizer(data,"*");
               String name=s.nextToken();
               String button = s.nextToken();
               String oppTic = s.nextToken();
               PlayerHandeler p = playerInGame.get(name);
               p.ps.println("gameTic*" + button+"*"+oppTic);
             //  ps.println(button);
           }
 
    }
    
    
    
    

    
    
    
    

