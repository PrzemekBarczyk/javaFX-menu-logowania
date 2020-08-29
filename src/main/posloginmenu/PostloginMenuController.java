package main.posloginmenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class PostloginMenuController {

    private PostloginMenuView theView;
    private PostloginMenuModel theModel;

    public PostloginMenuController(String message) {

        this.theView = new PostloginMenuView(message);
        this.theModel = new PostloginMenuModel();

        EventHandler<ActionEvent> actionHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                theView.closeStage();
            }
        };

        EventHandler<KeyEvent> keyHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                theView.closeStage();
            }
        };

        theView.addListeners(actionHandler, keyHandler);
    }
}
