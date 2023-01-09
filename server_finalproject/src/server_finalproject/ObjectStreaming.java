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
import java.util.logging.Level;
import java.util.logging.Logger;

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
       
            
            th.start();
            //streaming(client);
            /*out.close();
            in.close();
            client.close();
            server.close();*/
       
            }  
    }

    public void run()
    {
    
        while(true)
        {
        
            
            try {
                this.server = new ServerSocket(5000);
            client=server.accept();
            out =new ObjectOutputStream(client.getOutputStream());
            in =new ObjectInputStream(client.getInputStream());
                SignUp obj=(SignUp) in.readObject();
                System.out.println("username="+obj.getUsername());
            } catch (IOException ex) {
                Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ObjectStreaming.class.getName()).log(Level.SEVERE, null, ex);
            }
            } 
        }
    }
    

