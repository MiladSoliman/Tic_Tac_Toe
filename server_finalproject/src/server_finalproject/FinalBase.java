package server_finalproject;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FinalBase extends StackPane {

    boolean flag;
    
    protected final Rectangle rectangle;
    protected final BorderPane borderPane;
    protected final HBox hBox;
    protected final Label label;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;

    public FinalBase(Stage stage) {
         flag=true;
        
        
       
        rectangle = new Rectangle();
        borderPane = new BorderPane();
        hBox = new HBox();
        label = new Label();
        button = new Button();
        button0 = new Button();
        button1 = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        
        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setHeight(400.0);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(600.0);
        Stop[] stops = new Stop[] { new Stop(0, Color.WHITE),new Stop(1, Color.CADETBLUE)};
        LinearGradient lg1 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.NO_CYCLE, stops);
        rectangle.setFill(lg1);         

        borderPane.setPrefHeight(200.0);
        borderPane.setPrefWidth(200.0);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        label.setText(" tic-tac-toe server");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#dad4d4"));
        label.setFont(new Font("Gabriola", 44.0));
        HBox.setMargin(label, new Insets(20.0, 0.0, 0.0, 180.0));
        borderPane.setTop(hBox);

        BorderPane.setAlignment(button, javafx.geometry.Pos.CENTER);
        button.setMnemonicParsing(false);
        button.setText("activate");
        button.setTextFill(javafx.scene.paint.Color.valueOf("#1b6f93"));
        button.setFont(new Font("Cambria Bold Italic", 23.0));
        button.addEventHandler(ActionEvent.ACTION,new  EventHandler<ActionEvent>(){
 @Override
 public void handle(ActionEvent e)
        {
            if (flag==true)
            {
                ObjectStreaming obj= new ObjectStreaming();
                    button.setText("deactivate");
                    flag=false;
                   
                    //Player player=new Player("hadia","hadia@gmail.com","1234",50,"online");
                //try {
                  //  DataAccessLayerFinal.insert(player);
                //} catch (SQLException ex) {
                  //  Logger.getLogger(FinalBase.class.getName()).log(Level.SEVERE, null, ex);
                //}
            }
            
            else
            {
                    button.setText("activate");
                    flag=true;
            }

        }});
        BorderPane.setMargin(button, new Insets(0.0, 0.0, 0.0, 20.0));
        borderPane.setLeft(button);

        BorderPane.setAlignment(button0, javafx.geometry.Pos.CENTER);
        button0.setMnemonicParsing(false);
        button0.setText("online & offline players");
        button0.setTextFill(javafx.scene.paint.Color.valueOf("#1b6f93"));
        button0.setFont(new Font("Cambria Bold Italic", 23.0));
        button0.addEventHandler(ActionEvent.ACTION,new  EventHandler<ActionEvent>(){
 @Override
 public void handle(ActionEvent e)
        {
     
         Parent root = new playersBase(stage);
         Scene scene = new Scene(root);
         stage.setTitle("Players");
         stage.setScene(scene);
         stage.show();
     
        }});
        borderPane.setCenter(button0);

        BorderPane.setAlignment(button1, javafx.geometry.Pos.CENTER);
        button1.setMnemonicParsing(false);
        button1.setText("statistics");
        button1.setTextFill(javafx.scene.paint.Color.valueOf("#1b6f93"));
        button1.setFont(new Font("Cambria Bold Italic", 23.0));
        button1.addEventHandler(ActionEvent.ACTION,new  EventHandler<ActionEvent>(){
 @Override
 public void handle(ActionEvent e)
        {
     
         Parent root = new StatisticsBase(stage);
         Scene scene = new Scene(root);
         stage.setTitle("Statistics");
         stage.setScene(scene);
         stage.show();
            //ObjectStreaming obj= new ObjectStreaming();
     
        }});
        BorderPane.setMargin(button1, new Insets(0.0, 20.0, 0.0, 0.0));
        borderPane.setRight(button1);

        getChildren().add(rectangle);
        hBox.getChildren().add(label);
        getChildren().add(borderPane);

    }
}
