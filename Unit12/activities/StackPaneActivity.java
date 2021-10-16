package activities;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StackPaneActivity extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StackPane pane = new StackPane();
        pane.getChildren().addAll(
            new ImageView(new Image("file:media/images/emojis/headred.png")),
            new ImageView(new Image("file:media/images/emojis/eyesgreen.png")),
            new ImageView(new Image("file:media/images/emojis/browsworried.png")),
            new ImageView(new Image("file:media/images/emojis/mouthhm.png")),
            new ImageView(new Image("file:media/images/emojis/noseorange.png"))
        );
        stage.setScene(new Scene(pane));
        stage.setTitle("Stack Pane");
        stage.show();        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
