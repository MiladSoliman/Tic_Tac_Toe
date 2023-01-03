package server_finalproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Background;
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

public class playersBase extends StackPane {

    protected final Rectangle rectangle;
    protected final BorderPane borderPane;
    protected final HBox hBox;
    protected final Button home;
    protected final Label label;
    protected final TableView tableView;
    protected final TableColumn tableColumn;
    protected final TableColumn tableColumn0;

    public playersBase(Stage stage) {

        rectangle = new Rectangle();
        borderPane = new BorderPane();
        hBox = new HBox();
        home = new Button();
        label = new Label();
        tableView = new TableView();
        tableColumn = new TableColumn();
        tableColumn0 = new TableColumn();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        //rectangle.setFill(javafx.scene.paint.Color.valueOf("#a7d1d7"));
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

        home.setMnemonicParsing(false);
        //home.setOnAction(this::homeButtonAction);
        home.setText("Home");
        home.setTextFill(javafx.scene.paint.Color.valueOf("#bc5272"));
        home.setFont(new Font("Cambria Bold Italic", 20.0));
        home.addEventHandler(ActionEvent.ACTION,new  EventHandler<ActionEvent>(){
 @Override
 public void handle(ActionEvent e)
        {
     
         Parent root = new FinalBase(stage);
         Scene scene = new Scene(root);
         stage.setTitle("Tic Tac Toe");
         stage.setScene(scene);
         stage.show();
     
        }});
        HBox.setMargin(home, new Insets(20.0, 0.0, 0.0, 20.0));

        label.setText("online & offline players");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#6b719e"));
        label.setFont(new Font("Cambria Bold Italic", 30.0));
        HBox.setMargin(label, new Insets(20.0, 0.0, 0.0, 80.0));
        borderPane.setTop(hBox);

        BorderPane.setAlignment(tableView, javafx.geometry.Pos.CENTER);
        tableView.setPrefHeight(200.0);
        tableView.setPrefWidth(200.0);
        tableView.setStyle("-fx-background-color:transparent");
        

        tableColumn.setMaxWidth(300.0);
        tableColumn.setMinWidth(300.0);
        tableColumn.setPrefWidth(300.0);
        tableColumn.setText("online");

        tableColumn0.setMaxWidth(300.0);
        tableColumn0.setMinWidth(300.0);
        tableColumn0.setPrefWidth(300.0);
        tableColumn0.setText("offline");
        borderPane.setCenter(tableView);

        getChildren().add(rectangle);
        hBox.getChildren().add(home);
        hBox.getChildren().add(label);
        tableView.getColumns().add(tableColumn);
        tableView.getColumns().add(tableColumn0);
        getChildren().add(borderPane);

    }

    //protected abstract void homeButtonAction(javafx.event.ActionEvent actionEvent);

}
