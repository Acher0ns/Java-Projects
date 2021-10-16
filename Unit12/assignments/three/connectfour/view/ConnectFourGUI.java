package assignments.three.connectfour.view;

import assignments.three.connectfour.model.Checker;
import assignments.three.connectfour.model.ConnectFour;
import assignments.three.connectfour.model.ConnectFourException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Creates a GUI implementation of a game of connect four.
 * Does not check if game has ended.
 */
public class ConnectFourGUI extends Application {
    // Blank png image used for size of peices
    private static final Image BLANK_IMAGE = new Image("file:media/images/blank.png");

    // represent empty whole in ConnectFour game
    private static final StackPane BLANK;
    // represent red peice in ConnectFour game
    private static final StackPane RED;
    // represent black peice in ConnectFour game
    private static final StackPane BLACK;

    static {
        BLANK = new StackPane();
        BLANK.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, new CornerRadii(50), new Insets(5))));
        BLANK.getChildren().add(new ImageView(BLANK_IMAGE));

        BLACK = new StackPane();
        BLACK.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(50), new Insets(5))));
        BLACK.getChildren().add(new ImageView(BLANK_IMAGE));

        RED = new StackPane();
        RED.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(50), new Insets(5))));
        RED.getChildren().add(new ImageView(BLANK_IMAGE));
    }

    private ConnectFour game;

    @Override
    public void start(Stage stage) throws Exception {
        // Start game
        game = new ConnectFour();

        // Pane representing the entire window
        BorderPane borderPane = new BorderPane();

        // HBox holding drop buttons at the top of window used to make a move
        HBox dropBtns = new HBox();
        HBox.setHgrow(dropBtns, Priority.ALWAYS);
        dropBtns.getChildren().addAll(
            makeDropButton(stage, 0),
            makeDropButton(stage, 1),
            makeDropButton(stage, 2),
            makeDropButton(stage, 3),
            makeDropButton(stage, 4),
            makeDropButton(stage, 5)
        );
        borderPane.setTop(dropBtns);

        // GridPane representing the game board where the peices are
        GridPane gameBoard = new GridPane();
        gameBoard.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        for (int col = 0; col < 6; col++) {
            for (int row = 0; row < 6; row++) {
                // Peice represented by a stack pane.
                StackPane piece = new StackPane();
                piece.setBackground(BLANK.getBackground());
                piece.getChildren().add(new ImageView(BLANK_IMAGE));
                gameBoard.add(piece, col, row);
                
                // Create copy of local variable and register/create observer for current peice to update it when a move is made
                final int copyCol = col;
                final int copyRow = row;
                game.registerObserver((cf, c, r) -> {
                    if (c == copyCol && r == copyRow) {
                        Checker checker = game.getChecker(c, r);
                        if (checker == Checker.RED) {
                            piece.setBackground(RED.getBackground());
                        } else if (checker == Checker.BLACK) {
                            piece.setBackground(BLACK.getBackground());
                        } else {
                            piece.setBackground(BLANK.getBackground());
                        }
                    }
                });
            }
        }
        borderPane.setCenter(gameBoard);

        VBox gameControls = new VBox();
        Button restartButton = new Button("Restart");
        //VBox.setVgrow(restartButton, Priority.ALWAYS);

        restartButton.setFont(new Font("Times New Roman", 16));
        restartButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        restartButton.setOnAction((e) -> {
            game.reset();
            for (int col = 0; col < 6; col++) {
                for (int row = 0; row < 6; row++) {
                    game.notifyObservers(col, row);
                }
            }

            stage.setTitle("Connect Four: New Game");
        });
        gameControls.getChildren().add(restartButton);
        borderPane.setBottom(gameControls);

        stage.setScene(new Scene(borderPane));
        stage.setTitle("Connect Four: " + game.getCurrentPlayer() + "'s move");
        stage.show();
    }

    /**
     * Creates a button allowing user to make a move in that column
     * @param col that move is made in
     * @return button created
     */
    private Button makeDropButton(Stage stage, int col) {
        Button button = new Button("Drop!");
        HBox.setHgrow(button, Priority.ALWAYS);

        button.setFont(new Font("Times New Roman", 16));
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        button.setOnAction((e) -> {
            try {
                game.move(col);
                stage.setTitle("Connect Four: " + game.getCurrentPlayer() + "'s move");
            } catch (ConnectFourException cfe) {
                stage.setTitle("Connect Four: Invalid Move!");
            }
        });
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
