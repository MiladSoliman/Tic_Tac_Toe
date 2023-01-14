/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version.pkg1.welcom.page;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LoginController implements Initializable {

    @FXML
    private Button signup;
    @FXML
    private Button login;
    @FXML
    private Button homescreen;
    @FXML
    private Label login_error;
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;

    //validate user
    String message;
    Socket serverSocket;
    PrintStream ps;
    DataInputStream dis;
    Thread th;
    ClientSide cSide;
    String isValidAccount = null;
    Boolean flag = false;
    static LoginController logIn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cSide = new ClientSide();
        logIn = this;
    }

    @FXML
    private void GameScreen(ActionEvent event) throws Exception {
        if (flag == false) {
            message = "login*" + username.getText() + "*" + password.getText();
            cSide.connection();
            cSide.sending(message);
        } else {

            String name = username.getText();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListOnlinePlayers.fxml"));
            Parent root = loader.load();
            ListOnlinePlayersController listOnlinePlayersController = loader.getController();
            listOnlinePlayersController.displayName(name);

            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }

    }

    public void labelEdit(String rest) {
        //signup_error.setText("high");
        isValidAccount = rest;

        if (isValidAccount.equalsIgnoreCase("valid account")) {
            flag = true;
            login.fire();
            //x=false;
        } else {
            login_error.setText("Sorry! username and email are not valid");
        }

    }

    @FXML
    private void signup(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void homescreen(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
