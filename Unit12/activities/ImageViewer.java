package activities;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ImageViewer extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("file:media/images/sunflowers.jpg");
        ImageView view = new ImageView(image);

        HBox box = new HBox();
        box.getChildren().add(view);
        stage.setScene(new Scene(box));
        stage.setTitle("Image Viewer");
        stage.show();        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
