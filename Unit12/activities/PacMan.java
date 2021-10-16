package activities;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PacMan extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox box = new VBox();
        box.getChildren().addAll(
            makeButton("Start", "media/sounds/start.wav"),
            makeButton("Chomp", "media/sounds/chomp.wav"),
            makeButton("Eat", "media/sounds/eat.wav"),
            makeButton("Game Over!", "media/sounds/end.wav")
        );

        stage.setTitle("PacMan");
        stage.setScene(new Scene(box));
        stage.show();        
    }

    private static Button makeButton(String text, String path) {
        Button button = new Button(text, new ImageView(new Image("file:media/images/square.png")));
        button.setPadding(new Insets(5));
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        VBox.setVgrow(button, Priority.ALWAYS);

        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer player = new MediaPlayer(media);

        button.setOnAction((e) -> {
            Duration current = player.getCurrentTime();
            Duration stop = player.getStopTime();
            System.out.println(current + ", " + stop);
            System.err.println(current.equals(stop));
            if (player.getCurrentTime().equals(stop)) {
                player.stop();
            }
            player.play();
        });

        return button;
    }

    // private static void play(String path) {
    //     Media media = new Media(new File(path).toURI().toString());
    //     MediaPlayer player = new MediaPlayer(media);
    //     player.play();
    // }

    public static void main(String[] args) {
        launch(args);
    }
}
