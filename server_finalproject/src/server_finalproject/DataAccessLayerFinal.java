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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.Vector;
import static javax.swing.UIManager.getString;


/**
 *
 * @author hadia
 */

public class DataAccessLayerFinal {
    public static int insert (Player player) throws SQLException{
        int result=0;
    DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/finalproject","tictactoe","tictactoe");
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


     public static List<Player>getPlayers () throws SQLException{
        DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
        Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/finalproject","tictactoe","tictactoe"); 
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM  PLAYERS "); 
        List<Player> list = query1(res);
        con.close();                                     
        st.close();
        return list; 
      }

    private static List<Player> query1(ResultSet res) throws SQLException {
        List<Player> list =  new ArrayList<>();
        while  (res.next()){   
        Player player = new Player(res.getString(1),res.getString(2),res.getString(3),res.getInt(4),res.getString(5));
        list.add(player);
        }
        return list;
    }
    
        //validate login
        public static int validateLogin (Player player) throws SQLException{
           int result; 
        
            try {
    DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/finalproject","tictactoe","tictactoe");
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

    
     private static Vector<String> query(ResultSet rs) throws SQLException {
        Vector<String> list =  new Vector<>();
        while  (rs.next()){   
        String userName = (rs.getString(1));
        list.add(userName);

        }
    return list;
    } 

    public static List<String>getConnectedPlayers () throws SQLException{
        DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/finalproject","tictactoe","tictactoe");
        Statement stmt = con.createStatement();
        
        PreparedStatement prepStmt = con.prepareStatement("SELECT USERNAME FROM PLAYERS WHERE STATUS = ?");
        prepStmt.setString(1, "online");
        ResultSet rs = prepStmt.executeQuery();
        List<String> list = query(rs);
        
        con.close();                                     
        stmt.close();
        return list;
        
    }
   
  
   public static String validateSignup(Player player) throws SQLException{
       String isValid = null;
            
    DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/finalproject","tictactoe","tictactoe");
    PreparedStatement prepStmt = con.prepareStatement("select * from players where username = ?");
    PreparedStatement prepStmt2 = con.prepareStatement("select * from players where email = ?");
            prepStmt.setString(1, player.getUsername());
            prepStmt2.setString(1, player.getEmail());
            ResultSet rs = prepStmt.executeQuery();
            ResultSet res = prepStmt2.executeQuery();
            if(rs.next()&&res.next()){
                isValid="not valid username or email";
            }
            else if(rs.next()){
            isValid="not valid username";
            }
            else if(res.next()){
            isValid="not valid email";
            }
            else{
            isValid="valid";
            }
        
        return isValid;
            }
        }
