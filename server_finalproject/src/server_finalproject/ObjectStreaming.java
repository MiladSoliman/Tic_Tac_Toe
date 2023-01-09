/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_finalproject;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
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
                         String str=dis.readLine();
                         System.out.println(str);
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
}
    

