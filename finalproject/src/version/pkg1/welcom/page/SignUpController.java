package version.pkg1.welcom.page;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Label signup_error;
    @FXML
    private PasswordField confirm_password;
    @FXML
    private Button signup;
    @FXML
    private Button homescreen;

    String isValid;
    String message;
    DataInputStream dis;
    PrintStream ps;
    Socket sSocket;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void GameScreen(ActionEvent event) throws Exception {
        if (password.getText().equals(confirm_password.getText())) {
            message = "signup*" + username.getText() + "*" + email.getText() + "*" + password.getText();
            isValid = transfering(message);
            System.out.println(isValid);
            switch (isValid) {
                case "not valid username or email": {
                    signup_error.setText("Sorry! username and email are not valid");
                    //x=false;
                }
                break;
                case "not valid username": {
                    System.out.println("ana d5lt");
                    signup_error.setText("Sorry! username is not valid");
                    System.out.println("ana d5lt");
                    //x=false;
                }
                break;
                case "not valid email": {
                    signup_error.setText("Sorry! email is not valid");
                    //x=false;
                }
                break;
                case "valid": {
                    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                }
                break;
            }
        } else {
            signup_error.setText("password fields don't match");
        }

    }

    @FXML
    private void homescreen(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public String transfering(String message) {

        try {
            sSocket = new Socket("127.0.0.1", 5005);
            ps = new PrintStream(sSocket.getOutputStream());
            dis = new DataInputStream(sSocket.getInputStream());
            ps.println(message);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        String isValid = dis.readLine();
                        System.out.println(isValid);
                    } catch (IOException ex) {
                        Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                    } 

                }
            }
            );
        } catch (IOException ex) { 
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isValid;
    }
}