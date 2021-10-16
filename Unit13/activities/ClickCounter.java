package activities;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ClickCounter extends Application {
    private int count;

    @Override
    public void start(Stage stage) throws Exception {
        count = 0;

        Label countLabel = makeLabel("0");
        Button clicker = new Button("Click Me");
        clicker.setOnAction((e) -> {
            count++;
            countLabel.setText(count + "");
        });
        clicker.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        VBox.setVgrow(clicker, Priority.ALWAYS);

        VBox box = new VBox();
        box.getChildren().addAll(countLabel, clicker);
        stage.setScene(new Scene(box));
        stage.setTitle("Count Clicker");
        stage.show();
    }

    private static Label makeLabel(String text) {
        Label label = new Label(text);    
        label.setFont(new Font("Times New Roman", 56));
        label.setTextFill(Color.BLACK);
        label.setBackground(new Background(new BackgroundFill(Color.BEIGE, new CornerRadii(5), new Insets(10))));
        label.setPadding(new Insets(20));
        label.setBorder(new Border(new BorderStroke(
            Color.BLACK,
            BorderStrokeStyle.SOLID, 
            new CornerRadii(5), 
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
