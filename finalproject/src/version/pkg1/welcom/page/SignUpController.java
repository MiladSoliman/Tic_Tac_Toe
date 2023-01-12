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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
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
    private PasswordField confirm_password;
    @FXML
    private Button signup;
    @FXML
    private Button homescreen;

    String message;
    DataInputStream dis;
    PrintStream ps;
    Socket sSocket;
   /*Socket client;
   ObjectOutputStream out;
   ObjectInputStream in;
   SignUp obj;*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    private void GameScreen(ActionEvent event) throws Exception {
        
       message="signup*"+username.getText()+"*"+email.getText()+"*"+password.getText();
        transfering(message); 
        Parent root = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
              
    }
      @FXML
      private void homescreen(ActionEvent event) throws Exception{
       Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       Scene scene = new Scene(root); 
       Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.show();
    }
      public void transfering(String message){
       try {
           sSocket=new Socket ("127.0.0.1",5005);
           ps=new PrintStream(sSocket.getOutputStream());
           dis=new DataInputStream(sSocket.getInputStream());
           ps.println(message);
       } catch (IOException ex) {
           Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
       }
      
      }
}