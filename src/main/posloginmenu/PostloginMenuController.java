package main.posloginmenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class PostloginMenuController {

    private PostloginMenuView theView;
    private PostloginMenuModel theModel;

    private EventHandler<ActionEvent> actionEventHandler;
    private EventHandler<KeyEvent> keyEventHandler;

    public PostloginMenuController(String message) {

        this.theView = new PostloginMenuView(message);
        this.theModel = new PostloginMenuModel();

        this.createEventHandlers();
        theView.addEventHandlers(actionEventHandler, keyEventHandler);
    }

    private void createEventHandlers() {

        actionEventHandler = event -> theView.closeStage();
        keyEventHandler = event -> theView.closeStage();
    }
}
