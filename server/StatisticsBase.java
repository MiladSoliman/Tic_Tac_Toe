package server_finalproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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

public class StatisticsBase extends StackPane {

    protected final Rectangle rectangle;
    protected final BorderPane borderPane;
    protected final HBox hBox;
    protected final Button button;
    protected final Label label;

    public StatisticsBase(Stage stage) {

        rectangle = new Rectangle();
        borderPane = new BorderPane();
        hBox = new HBox();
        button = new Button();
        label = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.WHITE);
        rectangle.setHeight(400.0);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
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

        button.setMnemonicParsing(false);
        button.setText("Home");
        button.setTextFill(javafx.scene.paint.Color.valueOf("#bc5272"));
        HBox.setMargin(button, new Insets(20.0, 0.0, 0.0, 20.0));
        button.setFont(new Font("Cambria Bold Italic", 20.0));
        button.addEventHandler(ActionEvent.ACTION,new  EventHandler<ActionEvent>(){
 @Override
 public void handle(ActionEvent e)
        {
     
         Parent root = new FinalBase(stage);
         Scene scene = new Scene(root);
         stage.setTitle("Tic Tac Toe");
         stage.setScene(scene);
         stage.show();
     
        }});

        label.setText("Statistics");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#6b719e"));
        HBox.setMargin(label, new Insets(20.0, 0.0, 0.0, 150.0));
        label.setFont(new Font("Cambria Bold Italic", 30.0));
        borderPane.setTop(hBox);

        getChildren().add(rectangle);
        hBox.getChildren().add(button);
        hBox.getChildren().add(label);
        getChildren().add(borderPane);

    }
}
