/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hadia
 */
public class DataAccessLayerFinal {
    public static int insert (Player player) throws SQLException{
        int result=0;
    DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/tictactoe","tictactoe","tictactoe");
     PreparedStatement stm=con.prepareStatement("INSERT INTO PLAYERS VALUES (?,?,?,?,?)");
     stm.setString(1, player.getUsername());
     stm.setString(2, player.getEmail());
     stm.setString(3,player.getPassword());
     stm.setInt(4, player.getScore());
     stm.setString(5,player.getStatus() );
     
     result =stm.executeUpdate();
     con.commit();
     stm.close();
     con.close();
    return result;
    }
    
    //validate login
        public static int validateLogin (Player player) throws SQLException{
           int result; 
        
            try {
    DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/tictactoe","tictactoe","tictactoe");
    PreparedStatement prepStmt = con.prepareStatement("SELECT USERNAME,PASSWORD FROM PLAYERS WHERE USERNAME=? AND PASSWORD=?");
            prepStmt.setString(1, player.getUsername());
            prepStmt.setString(2, player.getPassword());
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                return 1;
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return 0;  
        }

    
    }
