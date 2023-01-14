package version.pkg1.welcom.page;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
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
    Thread th;
    ArrayList hadia;
    ClientSide cSide;
    static SignUpController signUp;
    Boolean flag;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cSide = new ClientSide();
        flag = false;
    }

    public SignUpController() {
        signUp = this;
    }

    @FXML
    private void GameScreen(ActionEvent event) throws Exception {
        if (flag == false) {
            if (username.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty() || confirm_password.getText().isEmpty()) {
                signup_error.setText("Please fill all fields");
            } else {
                if (!(password.getText().equals(confirm_password.getText()))) {
                    signup_error.setText("password fields don't match");
                } else {
                    message = "signup*" + username.getText() + "*" + email.getText() + "*" + password.getText();
                    cSide.connection();
                    cSide.sending(message);
                }
            }
        } else if (flag == true) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void labelEdit(String rest) {
        //signup_error.setText("high");
        isValid = rest;
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
                signup_error.setText("valid");
                flag = true;
                signup.fire();

            }

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

}
