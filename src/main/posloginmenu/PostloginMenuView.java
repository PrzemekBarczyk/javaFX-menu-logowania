package main.posloginmenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


class PostloginMenuView {

    private Stage stage;
    private Button closeButton;

    PostloginMenuView(String message) {

        stage = new Stage();
        stage.setTitle("Pop Out Menu");

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(50));
        pane.setHgap(25);
        pane.setVgap(25);

        Text messageText = new Text(message);
        GridPane.setHalignment(messageText, HPos.CENTER);
        pane.add(messageText, 0,0);

        closeButton = new Button("close");
        GridPane.setHalignment(closeButton, HPos.CENTER);
        pane.add(closeButton, 0, 1);


        stage.setScene(new Scene(pane));
        stage.show();
    }

    void addEventHandlers(EventHandler<ActionEvent> actionListener, EventHandler<KeyEvent> keyListener) {

        closeButton.setOnAction(actionListener);
        closeButton.setOnKeyReleased(keyListener);
    }

    void closeStage() {
        stage.close();
    }

    void setScene(Scene newScene) {
        stage.setScene(newScene);
    }
}
