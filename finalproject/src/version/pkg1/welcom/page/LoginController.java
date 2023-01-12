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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void GameScreen(ActionEvent event) throws Exception {
        message = "login*" + username.getText() + "*" + password.getText();
        boolean is_valid_account = transfering(message);
        if (is_valid_account) {
            String name = username.getText();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListOnlinePlayers.fxml"));
            Parent root = loader.load();
            ListOnlinePlayersController listOnlinePlayersController = loader.getController();
            listOnlinePlayersController.displayName(name);

            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } else {
            login_error.setText("Sorry! your username or password is not valid");
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

    private boolean transfering(String message) {
        boolean is_valid_account = false;
        try {
            serverSocket = new Socket("127.0.0.1", 5005);
            ps = new PrintStream(serverSocket.getOutputStream());
            dis = new DataInputStream(serverSocket.getInputStream());
            ps.println(message);
            String isValidAccount = dis.readLine();
            if (isValidAccount.equalsIgnoreCase("valid account")) {
                is_valid_account = true;
            }

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return is_valid_account;
    }

}
