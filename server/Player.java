/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_finalproject;

/**
 *
 * @author hadia
 */
class Player {
    private String username;
    private String email;
    private String password;
    private int score;
    private String status;
    
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getScore() {
        return score;
    }

    public String getStatus() {
        return status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Player(String username, String email, String password, int score, String status) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.score = score;
        this.status = status;
    }
                   
}
