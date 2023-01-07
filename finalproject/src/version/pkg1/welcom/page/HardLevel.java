/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version.pkg1.welcom.page;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import static version.pkg1.welcom.page.GameScreenController.mp;

/**
 *
 * @author abdallahelgedawy
 */
public class HardLevel {
    
  
  //static boolean compWin = false;
  //static boolean playerWin = false;
    
     public static class Move
{
    int row, col;
    
};
    private static  String player = "O";
    private static String computer = "x";
    public static Boolean isMovesLeft(Button board[][])
{
     for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++)
       
            if (board[i][j].getText().equals("")){
                return true;
            }
    return false;
}
    
    public static int checkState (Button b[][]){
               //ROWS
         for (int row = 0; row < 3; row++) {
            if (b[row][0].getText().equals(b[row][1].getText()) && b[row][1].getText().equals(b[row][2].getText())) {
                 // winner = true;
               //  colorWinner(b[row][0],b[row][1],b[row][2]);
                switch (b[row][0].getText()) {
                    case "O":
                        // colorWinner(b[row][0],b[row][1],b[0][2]);
                    
                        return 10;
                        
                    case "X":
                        // colorWinner(b[row][0],b[row][1],b[0][2]);
                       
                        return -10;
                        
                }
              
            }
        }
         for (int col = 0; col < 3; col++) {
            if (b[0][col].getText().equals(b[1][col].getText()) && b[1][col].getText().equals(b[2][col].getText())) {
               //  winner = true;
            //   colorWinner(b[0][col],b[1][col],b[2][col]);
                switch (b[0][col].getText()) {
                    case "O":
                      
                        return 10;
                    case "X":
                       
                        return -10;
                }
            }
        }
           if (b[0][0].getText().equals(b[1][1].getText()) && b[1][1].getText().equals(b[2][2].getText())) {
               //  winner = true;
              // colorWinner(b[0][0],b[1][1],b[2][2]);
            switch (b[0][0].getText()) {
                case "O":  
                   
                    return 10;
                case "X":
                   
                    return -10;
            }
        }
        if (b[0][2].getText().equals(b[1][1].getText()) && b[1][1].getText().equals(b[2][0].getText())) {
           //  winner = true;
          // colorWinner(b[0][2],b[1][1],b[2][0]);
            switch (b[0][2].getText()) {
                case "O":
                 
                    return 10;
                case "X":
                
                 return -10;
            }
        }
    
        return 0;
        
    }
    
       public static int minimax(Button board[][], int depth, Boolean isMax) {
        int score = checkState(board);
        if (score == 10) {
            return score;
        }
        if (score == -10) {
            return score;
        }
        if (isMovesLeft(board) == false) {
            return 0;
        }

        if (isMax) {
            int best = -1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].getText().equals("")) {
                        board[i][j].setText(player);
                        best = Math.max(best, minimax(board, depth + 1, !isMax));
                        board[i][j].setText("");
                    }
                }
            }
            return best;

        } else{
            int best = 1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].getText().equals("")) {
                        board[i][j].setText(computer);
                        best = Math.min(best, minimax(board, depth + 1, isMax));
                        board[i][j].setText("");
                    }
                }
            }
            return best;
        }
    }
        public static Move findBestMove(Button board[][]) {
        int bestVal = -1000;
        Move bestMove = new Move();
        bestMove.row = 0;
        bestMove.col = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getText().equals("")) {
                    board[i][j].setText(player);
                    int moveVal = minimax(board, 0, false);
                    board[i][j].setText("");
                    if (moveVal > bestVal) {
                        bestMove.row = i;
                        bestMove.col = j;
                        bestVal = moveVal;
                    }
                }
            }
        }
        return bestMove;
    }
   
}
    

