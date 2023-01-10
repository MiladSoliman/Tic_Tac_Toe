/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author hadia
 */
public class DataAccessLayerFinal {
    public static int insert (Player player) throws SQLException{
        int result=0;
    DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/finalproject","tictactoe","tictactoe");
     //PreparedStatement stm=con.prepareStatement("INSERT INTO PLAYERS VALUES (?,?,?,?,?)");
     //stm.setString(1, "hadia");
     //stm.setString(2, "hadia@gmail.com");
     //stm.setString(3,"1234" );
     //stm.setInt(4, 5);
     //stm.setString(5,"online" );
     
     //result =stm.executeUpdate();
     con.commit();
     //stm.close();
     con.close();
    return result;
    }
    }
