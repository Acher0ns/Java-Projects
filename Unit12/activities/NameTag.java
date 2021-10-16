package activities;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NameTag extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label hello = new Label("HELLO MY NAME IS");
        hello.setAlignment(Pos.CENTER);
        hello.setFont(new Font("Impact", 20));
        hello.setPadding(new Insets(10));
        hello.setTextFill(Color.BLUE);
        hello.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Label name = new Label("Your Name");
        name.setFont(new Font("Comic Sans MS", 48));
        name.setTextFill(Color.RED);
        name.setPadding(new Insets(20));
        name.setAlignment(Pos.CENTER);
        name.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        VBox nameTag = new VBox();
        nameTag.setBorder(new Border(new BorderStroke(Color.BLUE, 
            BorderStrokeStyle.SOLID, new CornerRadii(10), 
            BorderStroke.THICK)));
        nameTag.getChildren().addAll(
            hello,
            name
        );

        TextField field = new TextField();
        field.setPromptText("Enter Your Name");
        field.setAlignment(Pos.CENTER);
        field.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Button button = new Button("Update Name Tag");
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setOnAction(new Updater(field, name));
        //button.setOnAction((e) -> name.setText(field.getText()));

        Button clear = new Button("Clear");
        clear.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        clear.setOnAction((e) -> name.setText(""));


        VBox box = new VBox();
        box.getChildren().addAll(
            nameTag,
            field,
            button,
            clear  
        );

        primaryStage.setTitle("Your Name");
        primaryStage.setScene(new Scene(box));
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}