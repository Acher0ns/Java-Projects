package activities;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GridPaneActivity extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();

        Label result = makeLabel("123.456");
        result.setAlignment(Pos.CENTER_RIGHT);
        pane.add(result, 0, 0, 4, 1);

        pane.add(makeLabel("AC"), 0, 1, 2, 1);
        pane.add(makeLabel("%"), 2, 1);
        pane.add(makeLabel("/"), 3, 1);

        pane.add(makeLabel("7"), 0, 2);
        pane.add(makeLabel("8"), 1, 2);
        pane.add(makeLabel("9"), 2, 2);
        pane.add(makeLabel("x"), 3, 2);

        pane.add(makeLabel("4"), 0, 4);
        pane.add(makeLabel("5"), 1, 4);
        pane.add(makeLabel("6"), 2, 4);
        pane.add(makeLabel("-"), 3, 4);


        pane.add(makeLabel("1"), 0, 5);
        pane.add(makeLabel("2"), 1, 5);
        pane.add(makeLabel("3"), 2, 5);
        pane.add(makeLabel("+"), 3, 5);

        pane.add(makeLabel("0"), 0, 6, 2, 1);
        pane.add(makeLabel("."), 2, 6);
        pane.add(makeLabel("="), 3, 6);



        Scene scene = new Scene(pane);
        stage.setScene(scene);

        stage.setTitle("Boilerplate");
        stage.show();     
    }

    public static Label makeLabel(String text) {
        Label label = new Label(text);    
        label.setFont(new Font("Times New Roman", 48));
        label.setTextFill(Color.BLACK);
        label.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0), Insets.EMPTY)));
        label.setPadding(new Insets(10));
        label.setBorder(new Border(new BorderStroke(
            Color.WHITE,
            BorderStrokeStyle.SOLID, 
            new CornerRadii(0), 
            BorderStroke.THIN
        )));
        label.setAlignment(Pos.CENTER);
        label.setMaxHeight(Double.MAX_VALUE);
        label.setMaxWidth(Double.MAX_VALUE);
        return label;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
