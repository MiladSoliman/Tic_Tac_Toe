/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_finalproject;

import java.io.Serializable;

/**
 *
 * @author hadia
 */
public class SignUp implements Serializable{
    private String username;
    private String email;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public SignUp(){}

    public SignUp(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    
}
