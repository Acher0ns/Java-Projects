package assignments.two;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

public class Song {
    private static final int SECOND = 1000;

    private final String description;
    private final Image image;
    private final MediaPlayer player;

    public Song(String mediaPath, String description, String imagePath) {
        Media media = new Media(new File(mediaPath).toURI().toString());
        this.player = new MediaPlayer(media);
        this.image = new Image(imagePath);
        this.description = description;
    }
    
    public void play() {
        Status status = player.getStatus();
        if (status != Status.PLAYING) {
            player.play();
        }
    }

    public void togglePause() {
        Status status = player.getStatus();
        if (status == Status.PAUSED) {
           player.play();
       } else if (status == Status.PLAYING) {
           player.pause();
       }
    }
    
    public void rewind() {
        Duration duration = new Duration(10 * SECOND);
        Duration current = player.getCurrentTime();
        player.seek(current.subtract(duration));
    }

    public void fastForward() {
        Duration duration = new Duration(10 * SECOND);
        Duration current = player.getCurrentTime();
        player.seek(current.add(duration));
    }

    public void stop() {
        player.stop();
    }

    public String getDescription() {
        return description;
    }

    public Image getImage() {
        return image;
    }
}
