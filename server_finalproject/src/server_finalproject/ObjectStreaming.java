package server_finalproject;

import java.io.DataInputStream;
import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

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
   DataInputStream dis;
    PrintStream ps;
   String [] arr;
    String str;

    public ObjectStreaming() {
        
      
      
        try {
             server = new ServerSocket(5005);
            
             th=new Thread(new Runnable() {
                 @Override
                 public void run() {
                    
            while(true){
                     try {
                         
                         client=server.accept();
                         dis=new DataInputStream(client.getInputStream());
                         ps=new PrintStream(client.getOutputStream());
                         str=dis.readLine();
                           
                           
                         if(str.length()>0){
                         stringDivision(str);
                         System.out.println(str);
                         }
                         //SignUp obj=(SignUp) in.readObject();
                //System.out.println("username="+obj.getUsername());
                     } catch (IOException ex) { 
                    Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
                } 
                 }
                 }
             });
             
             th.start();
            //streaming(client);
            /*out.close();
            in.close();
            client.close();
            server.close();*/
         
           // }  
    }  catch (IOException ex) { 
           Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
       } 

    /*public void run()
    {
    
        //while(true)
        //{
         
            
            try {
               
                
                SignUp obj=(SignUp) in.readObject();
                System.out.println("username="+obj.getUsername());
            } catch (IOException ex) {
                Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
            }
            //}
        }*/
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
               System.out.println(parts[0]);
               Player p=new Player(parts[0], parts[1], parts[2], 0,"online");
           try {
               DataAccessLayerFinal.insert(p);
           } catch (SQLException ex) {
               Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
           }
               }
               break;
               
               case"login":{
               String [] parts=rest.split("\\*");
               System.out.println(parts[0]);               
               System.out.println(parts[1]);

               Player player=new Player(parts[0], parts[1]);
           try {
               int isValidAccount=DataAccessLayerFinal.validateLogin(player);
               if (isValidAccount==1){
                   ps.println("valid account");
                   
               }else {
                   ps.println("invalid account");

               }
           } catch (SQLException ex) {
               Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
           }
               }
               break;
             
       }
               
    }

   
   }