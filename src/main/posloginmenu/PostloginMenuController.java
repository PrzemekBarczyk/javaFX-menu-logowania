package main.posloginmenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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

        theView.addListeners(actionHandler);
    }
}
