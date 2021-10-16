package reversi.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import reversi.model.Reversi;
import reversi.model.ReversiException;
import reversi.model.Square;

public class ReversiGUI extends Application {
    private static final Image SQUARE_IMAGE = new Image("file:media/images/square.png");
    private static final Image BLACK_IMAGE = new Image("file:media/images/blackpiece.png");
    private static final Image WHITE_IMAGE = new Image("file:media/images/whitepiece.png");
    private static final Image BLANK_IMAGE = new Image("file:media/images/blank.png");

    private Reversi board;

    @Override
    public void start(Stage stage) throws Exception {
        board = new Reversi();

        GridPane boardPane = new GridPane();
        for (int col = 0; col < Reversi.COLS; col++) {
            for (int row = 0; row < Reversi.ROWS; row++) {
                boardPane.add(makeReversiButton(col, row), col, row);
            }
        }
        stage.setScene(new Scene(boardPane));
        stage.setTitle("Reversi");
        stage.show();
    }

    public Button makeReversiButton(int col, int row) {
        ImageView squareView = new ImageView(SQUARE_IMAGE);
        Button button = new Button("", squareView);
        button.setBackground(
            new Background(
                new BackgroundImage(
                    SQUARE_IMAGE, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER, BackgroundSize.DEFAULT)
            )
        );
        button.setPadding(new Insets(0));
        Square square = board.getSquare(row, col);

        updateImage(square, squareView);
        square.register((sq) -> updateImage(square, squareView));

        button.setOnAction((e) -> {
            System.out.println(board.getSquare(row, col));
            try {
                board.move(row, col);
            } catch (ReversiException re) {
                System.out.println(re.getMessage());
            }
            System.out.println(board.getSquare(row, col));
        });

        return button;
    }

    private static void updateImage(Square square, ImageView squareView) {
        switch(square.getOccupyingColor()) {
            case BLACK:
                squareView.setImage(BLACK_IMAGE);
                break;
            case WHITE:
                squareView.setImage(WHITE_IMAGE);
                break;
            default:
                squareView.setImage(BLANK_IMAGE);
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
