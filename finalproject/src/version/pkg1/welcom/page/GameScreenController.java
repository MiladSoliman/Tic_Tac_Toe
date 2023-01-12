//desktop
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version.pkg1.welcom.page;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author User
 */
public class GameScreenController implements Initializable {

    private Button buttonPressed;
    private boolean winner = false;
    private Boolean computerWin = false;
    private String player = "O";
    boolean flag = false;
    String sum = "";
//ArrayList<String> parts=new ArrayList<String>();
    int i = 0;
    String play;
    Thread th;
    boolean isO = true;
    String[] parts;
    String str;

    @FXML

    private Boolean playerWin = false;
    public static MediaPlayer mp;
    Dialog video = new Dialog();
    DialogPane pane = new DialogPane();
    MediaView view;

    @FXML

    protected Button btn1;
    @FXML
    protected Button btn2;
    @FXML
    protected Button btn3;
    @FXML
    protected Button btn4;
    @FXML
    protected Button btn5;
    @FXML
    protected Button btn6;
    @FXML
    protected Button btn7;
    @FXML
    protected Button btn8;
    @FXML
    protected Button btn9;
    @FXML
    private Label player_name;
    @FXML
    private Label player_score;
    @FXML
    private Label computer_score;
    @FXML
    private Button exit_btn;
    @FXML
    private Button play_again_btn;
    @FXML
    private Button btn_watch_game;

    String fileName;
    boolean is_recored_game;
    ArrayList<String> listOfNamesGames = new ArrayList<String>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        flag = true;
        // TODO
        //recording the game
        is_recored_game = isRecordGame();
    }

    @FXML
    public void buttonPressed(ActionEvent e) {
        if (!winner) {
            //System.err.println("x");
            buttonPressed = (Button) e.getSource();
            if (buttonPressed.getText().equals("")) {
                buttonPressed.setText("O");
                recordGame(buttonPressed.getId().toString(), buttonPressed.getText(), is_recored_game);
                //if(EasyOrHardLevelController.isrecord)
                // AccessFile.writeFile(buttonPressed.getId()+buttonPressed.getText()+".");
                checkState();
                if (!winner) {
                    computerTurn();
                    checkState();
                }
            }

        }

    }

    //check state
    private void checkState() {
        //ROWS
        if (btn1.getText().equals(btn2.getText()) && btn2.getText().equals(btn3.getText()) && !btn1.getText().equals("")) {

            //drawLine(btn1,btn3);
            colorWinner(btn1, btn2, btn3);

            if (btn1.getText().equals("O")) {
                // txtWinner.setText("you won!");
                //displayVideo
                //display = true;
                // score += 10;

                playerWin = true;

                int score = Integer.parseInt(player_score.getText().toString());
                score += 1;
                player_score.setText("" + score);

            } else {
                //txtWinner.setText("computer won!");
                computerWin = true;
                int score = Integer.parseInt(computer_score.getText().toString());
                score += 1;
                computer_score.setText("" + score);
            }
            winner = true;
        } else if (btn4.getText().equals(btn5.getText()) && btn5.getText().equals(btn6.getText()) && !btn4.getText().equals("")) {

            // drawLine(btn4,btn6);
            colorWinner(btn4, btn5, btn6);

            if (btn4.getText().equals("O")) {
                // txtWinner.setText("you won!");
                //displayVideo
                // display = true;
                //score += 10;

                playerWin = true;

                int score = Integer.parseInt(player_score.getText().toString());
                score += 1;
                player_score.setText("" + score);
            } else {
                //txtWinner.setText("computer won!");
                computerWin = true;
                int score = Integer.parseInt(computer_score.getText().toString());
                score += 1;
                computer_score.setText("" + score);
            }
            winner = true;
        } else if (btn7.getText().equals(btn8.getText()) && btn8.getText().equals(btn9.getText()) && !btn7.getText().equals("")) {

            //drawLine(btn7,btn9);
            colorWinner(btn7, btn8, btn9);

            if (btn7.getText().equals("O")) {
                //txtWinner.setText("you won!");
                //displayVideo
                //display = true;
                // score += 10;

                playerWin = true;

                int score = Integer.parseInt(player_score.getText().toString());
                score += 1;
                player_score.setText("" + score);
            } else {
                //txtWinner.setText("computer won!");
                computerWin = true;
                int score = Integer.parseInt(computer_score.getText().toString());
                score += 1;
                computer_score.setText("" + score);
            }
            winner = true;
        }

        //COLUMNS
        if (btn1.getText().equals(btn4.getText()) && btn4.getText().equals(btn7.getText()) && !btn1.getText().equals("")) {

            // drawLine(btn1,btn7);
            colorWinner(btn1, btn4, btn7);

            if (btn1.getText().equals("O")) {
                //txtWinner.setText("you won!");
                //displayVideo
                //display = true;
                //score += 10;

                playerWin = true;

                int score = Integer.parseInt(player_score.getText().toString());
                score += 1;
                player_score.setText("" + score);
            } else {
                // txtWinner.setText("computer won!");
                computerWin = true;
                int score = Integer.parseInt(computer_score.getText().toString());
                score += 1;
                computer_score.setText("" + score);
            }
            winner = true;
        } else if (btn2.getText().equals(btn5.getText()) && btn5.getText().equals(btn8.getText()) && !btn2.getText().equals("")) {

            //drawLine(btn2,btn8);
            colorWinner(btn2, btn5, btn8);

            if (btn2.getText().equals("O")) {
                // txtWinner.setText("you won!");
                //displayVideo
                // display = true;
                //  score += 10;

                playerWin = true;

                int score = Integer.parseInt(player_score.getText().toString());
                score += 1;
                player_score.setText("" + score);
            } else {
                // txtWinner.setText("computer won!");
                computerWin = true;
                int score = Integer.parseInt(computer_score.getText().toString());
                score += 1;
                computer_score.setText("" + score);
            }
            winner = true;
        } else if (btn3.getText().equals(btn6.getText()) && btn6.getText().equals(btn9.getText()) && !btn3.getText().equals("")) {

            //drawLine(btn3,btn9);
            colorWinner(btn3, btn6, btn9);

            if (btn3.getText().equals("O")) {
                //txtWinner.setText("you won!");
                // displayVideo
                // display = true;
                // score += 10;

                playerWin = true;

                int score = Integer.parseInt(player_score.getText().toString());
                score += 1;
                player_score.setText("" + score);
            } else {
                //txtWinner.setText("computer won!");
                computerWin = true;
                int score = Integer.parseInt(computer_score.getText().toString());
                score += 1;
                computer_score.setText("" + score);
            }
            winner = true;
        }
        //DIOGONAL

        if (btn1.getText().equals(btn5.getText()) && btn5.getText().equals(btn9.getText()) && !btn1.getText().equals("")) {

            //drawLine(btn1,btn9);
            colorWinner(btn1, btn5, btn9);

            if (btn1.getText().equals("O")) {
                //txtWinner.setText("you won!");
                //displayVideo
                //display = true;

                playerWin = true;

                int score = Integer.parseInt(player_score.getText().toString());
                score += 1;
                player_score.setText("" + score);
            } else {
                //txtWinner.setText("computer won!");
                computerWin = true;
                int score = Integer.parseInt(computer_score.getText().toString());
                score += 1;
                computer_score.setText("" + score);
            }
            winner = true;
        } else if (btn3.getText().equals(btn5.getText()) && btn5.getText().equals(btn7.getText()) && !btn3.getText().equals("")) {

            //drawLine(btn3,btn7);
            colorWinner(btn3, btn5, btn7);

            if (btn3.getText().equals("O")) {
                // txtWinner.setText("you won!");
                //displayVideo
                //display = true;
                //score += 10;

                playerWin = true;

                int score = Integer.parseInt(player_score.getText().toString());
                score += 1;
                player_score.setText("" + score);
            } else {
                //txtWinner.setText("computer won!");
                computerWin = true;
                int score = Integer.parseInt(computer_score.getText().toString());
                score += 1;
                computer_score.setText("" + score);
            }
            winner = true;
        }
        if (playerWin) {
            displayVideo("win.mp4", "Congratulations", 200, 200);
            playerWin = false;
            /* System.out.println("Synch");
            prefs.putInt("score",score);
            labScore.setText(""+ score);  
            btnPlayAgain.setVisible(true);*/
        } else if (computerWin) {
            displayVideo("lose.mp4", "Hard luck", 400, 400);
            computerWin = false;
            /* System.out.println("computer wins");
           btnPlayAgain.setVisible(true); */
        } else if (isFullGrid()) {
            displayVideo("Draw.mp4", "It's a draw", 600, 400);
        }

    }

    private boolean isFullGrid() {

        if (!btn1.getText().equals("") && !btn2.getText().equals("") && !btn3.getText().equals("") && !btn4.getText().equals("")
                && !btn5.getText().equals("") && !btn6.getText().equals("") && !btn7.getText().equals("")
                && !btn8.getText().equals("") && !btn9.getText().equals("")) {
            return true;
        } else {
            return false;
        }
    }

    private void computerTurn() {
        Random r;
        Button[] btns = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        Button myBtn;
        do {
            r = new Random();
            //will generate numbers in the range 0 to 8 both inclusive.
            int i = r.nextInt(9);
            myBtn = btns[i];
            if (isFullGrid()) {
                break;
            }
            //اول ملاقى  زراز يكون فاضى اطلع من اللوب عشان اكتب عليه 
        } while (!myBtn.getText().equals(""));
        myBtn.setText("X");
        recordGame(myBtn.getId().toString(), myBtn.getText(), is_recored_game);

    }

    @FXML
    private void homescreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void changeSceneToWatchGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListRecordedGames.fxml"));
        Parent root = loader.load();
        ListRecordedGamesController listRecordedGamestroller = loader.getController();
        listRecordedGamestroller.displaylistOfNamesGames(listOfNamesGames);

        //Parent root = FXMLLoader.load(getClass().getResource("ListRecordedGames.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void playagain(ActionEvent event) {

        computerWin = false;
        player = "O";
        winner = false;

        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        btn1.setStyle("-fx-background-color: none;");
        btn2.setStyle("-fx-background-color: none;");
        btn3.setStyle("-fx-background-color: none;");
        btn4.setStyle("-fx-background-color: none;");
        btn5.setStyle("-fx-background-color: none;");
        btn6.setStyle("-fx-background-color: none;");
        btn7.setStyle("-fx-background-color: none;");
        btn8.setStyle("-fx-background-color: none;");
        btn9.setStyle("-fx-background-color: none;");

    }

    public void displayName(String username) {
        player_name.setText("" + username);
    }

    private void colorWinner(Button b1, Button b2, Button b3) {
        b1.setStyle("-fx-background-color: green;");
        b2.setStyle("-fx-background-color: green;");
        b3.setStyle("-fx-background-color: green;");
    }

    public void displayVideo(String videopath, String title, int x, int y) {
        Media media = new Media(getClass().getResource(videopath).toExternalForm());
        mp = new MediaPlayer(media);
        view = new MediaView();
        video = new Dialog<>();
        video.getDialogPane().setMinSize(x, y);
        video.setTitle(title);
        video.getDialogPane().getChildren().add(view);
        ButtonType ok = new ButtonType("ok", ButtonData.OK_DONE);
        video.getDialogPane().getButtonTypes().add(ok);
        view.setMediaPlayer(mp);
        video.show();
        mp.play();
        flag = false;
        btn_watch_game.setDisable(false);

    }

    public void recordGame(String Id, String x, boolean isrecoredGame) {
        if (isrecoredGame) {
            File dir = new File("recordings");
            //add new file
            dir.mkdirs();
            File file = new File(dir + "/" + fileName);

            //File file=new File("recordings/new.txt");
            try {
                FileOutputStream fos;
                fos = new FileOutputStream(file);
                DataOutputStream os = new DataOutputStream(fos);
                String str = sum + Id + " " + x + " ";
                sum = str;
                os.writeUTF(str);
                if (!flag) {
                    os.close();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GameScreenController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GameScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void watchGame() {
        FileInputStream fis = null;
        try {

            fis = new FileInputStream("recordings/new.txt");
            DataInputStream ds = new DataInputStream(fis);
            str = new String(ds.readUTF());
            fis.close();
            ds.close();
            parts = str.split(" ");
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    int i = 0;
                    while (i <= parts.length) {
                        try {
                            if (isO) {
                                play = "O";
                                isO = false;
                            } else {
                                play = "X";
                                isO = true;
                            }
                            switch (parts[i]) {
                                case "btn1":

                                    btn1.setText(play);

                                    break;
                                case "btn2":
                                    btn2.setText(play);

                                    break;
                                case "btn3":

                                    btn3.setText(play);

                                    break;
                                case "btn4":
                                    btn4.setText(play);

                                    break;
                                case "btn5":
                                    System.out.println(parts[0]);
                                    btn5.setText(play);

                                    break;
                                case "btn6":
                                    btn6.setText(play);

                                    break;
                                case "btn7":
                                    btn7.setText(play);

                                    break;
                                case "btn8":
                                    btn8.setText(play);

                                    break;
                                case "btn9":
                                    btn9.setText(play);

                                    break;
                                default:
                                    break;
                            }

                            Thread.sleep(3000);
                            i += 2;
                        } catch (InterruptedException ex) {
                            Logger.getLogger(GameScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        } 

                    }
                }
            }
            );
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GameScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public boolean isRecordGame() {
        //recording the game

        boolean checkRecording;
        ButtonType Yes = new ButtonType("Yes");
        ButtonType No = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert a = new Alert(Alert.AlertType.NONE);
        //a.setTitle("Alert ASk");
        a.getDialogPane().getButtonTypes().addAll(Yes, No);
        a.setHeaderText("Do you want to record the game?");

        DialogPane dialogPane = a.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("/css/style.css").toExternalForm());
        dialogPane.getStyleClass().add("infoDialog");

        a.showAndWait();
        if (a.getResult() == Yes) {
            checkRecording = true;
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH-mm-ss");
            LocalDateTime now = LocalDateTime.now();
            fileName = dateTimeFormatter.format(now);
            listOfNamesGames.add(fileName);

        } else {
            checkRecording = false;
        }
        return checkRecording;

    }
}

            


