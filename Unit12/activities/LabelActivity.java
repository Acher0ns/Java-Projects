package activities;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LabelActivity extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //HBox box = new HBox();

        BorderPane pane = new BorderPane();

        Label label1 = makeLabel("Label 1", new Font("Times New Roman", 42));
        Label label2 = makeLabel("Label 2", new Font("Times New Roman", 56));
        Label label3 = makeLabel("Label 3", new Font("Times New Roman", 70));
        Label label4 = makeLabel("Label 4", new Font("Times New Roman", 56));
        Label label5 = makeLabel("Label 5", new Font("Times New Roman", 70));

        pane.setTop(label1);
        pane.setBottom(label2);
        pane.setLeft(label3);
        pane.setCenter(label4);
        pane.setRight(label5);

       // box.getChildren().addAll(label1, label2, label3);

        Scene scene = new Scene(pane);

        stage.setScene(scene);

        stage.setTitle("Boilerplate");
        stage.show();     
    }

    private static Label makeLabel(String text, Font font) {
        Label label = new Label(text);    
        label.setFont(font);
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
