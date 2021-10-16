package activities;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Updater implements EventHandler<ActionEvent> {
    private final TextField textField;
    private final Label label;

    public Updater(TextField textField, Label label) {
        this.textField = textField;
        this.label = label;
    }

    @Override
    public void handle(ActionEvent arg0) {
        String text = textField.getText();
        label.setText(text);
    }
}
