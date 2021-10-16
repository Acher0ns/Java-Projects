package assignments.two;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MusicPlayer extends Application {
    private Song currentSong;
    private ImageView songImageViewer;

    @Override
    public void start(Stage stage) throws Exception {
        Song newWorld = new Song("media/songs/EBEN - New World.mp3", "EBEN - New World", "media/songs/EBEN - New World.png");
        Song hollywood = new Song("media/songs/Post Malone - Hollywood's Bleeding (Meka Remix).mp3", "Post Malone - Hollywood's Bleeding (Meka Remix)", "media/songs/Post Malone - Hollywood's Bleeding (Meka Remix).png");
        Song firstTime = new Song("media/songs/Seven Lions, SLANDER, & Dabin - First Time ft. Dylan Matthew.mp3", "Seven Lions, SLANDER, & Dabin - First Time ft. Dylan Matthew", "media/songs/Seven Lions, SLANDER, & Dabin - First Time ft. Dylan Matthew.png");
        Song fake = new Song("media/songs/The Tech Thieves - Fake.mp3", "The Tech Thieves - Fake", "media/songs/The Tech Thieves - Fake.png");
        Song hurt = new Song("media/songs/Updog - Hurt.mp3", "Updog - Hurt", "media/songs/Updog - Hurt.png");
        currentSong = newWorld;
        songImageViewer = new ImageView(currentSong.getImage());
        songImageViewer.setFitHeight(500);
        songImageViewer.setFitWidth(500);
        VBox.setVgrow(songImageViewer, Priority.ALWAYS);
        HBox.setHgrow(songImageViewer, Priority.ALWAYS);

        BorderPane pane = new BorderPane();

        VBox songButtons = new VBox();
        songButtons.getChildren().addAll(makeSongButton(newWorld, stage), makeSongButton(hollywood, stage), makeSongButton(firstTime, stage), makeSongButton(fake, stage), makeSongButton(hurt, stage));
        VBox.setVgrow(songButtons, Priority.ALWAYS);

        HBox controlButtons = new HBox();
        Button rewind = new Button("Rewind");
        rewind.setOnAction((e) -> {
            currentSong.rewind();
        });
        rewind.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        VBox.setVgrow(rewind, Priority.ALWAYS);
        HBox.setHgrow(rewind, Priority.ALWAYS);

        Button play = new Button("Play");
        play.setOnAction((e) -> {
            currentSong.play();
        });
        play.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        VBox.setVgrow(play, Priority.ALWAYS);
        HBox.setHgrow(play, Priority.ALWAYS);
    
        Button pause = new Button("Pause");
        pause.setOnAction((e) -> {
            currentSong.togglePause();
        });
        pause.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        VBox.setVgrow(pause, Priority.ALWAYS);
        HBox.setHgrow(pause, Priority.ALWAYS);

        Button stop = new Button("Stop");
        stop.setOnAction((e) -> {
            currentSong.stop();
        });
        stop.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        VBox.setVgrow(stop, Priority.ALWAYS);
        HBox.setHgrow(stop, Priority.ALWAYS);

        Button fastForward = new Button("Fast Forward");
        fastForward.setOnAction((e) -> {
            currentSong.fastForward();
        });
        fastForward.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        VBox.setVgrow(fastForward, Priority.ALWAYS);
        HBox.setHgrow(fastForward, Priority.ALWAYS);

        
        controlButtons.setAlignment(Pos.CENTER);
        controlButtons.getChildren().addAll(rewind, play, pause, stop, fastForward);
        HBox.setHgrow(controlButtons, Priority.ALWAYS);

        pane.setCenter(songButtons);
        pane.setLeft(songImageViewer);
        pane.setBottom(controlButtons);
        stage.setScene(new Scene(pane));
        stage.setTitle("Current Song: " + currentSong.getDescription());
        stage.show();        
    }

    public Button makeSongButton(Song song, Stage stage) {
        Button button = new Button(song.getDescription());
        VBox.setVgrow(button, Priority.ALWAYS);
        HBox.setHgrow(button, Priority.ALWAYS);
        button.setOnAction((e) -> {
            currentSong = song;
            stage.setTitle("Current Song: " + currentSong.getDescription());
            songImageViewer.setImage(song.getImage());
        });
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
