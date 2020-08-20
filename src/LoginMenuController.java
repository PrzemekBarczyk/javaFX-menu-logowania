import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class LoginMenuController implements EventHandler<ActionEvent> {

    private LoginMenuView theView;
    private LoginMenuModel theModel;

    public LoginMenuController(LoginMenuView theView, LoginMenuModel theModel) {

        this.theView = theView;
        this.theModel = theModel;

        this.theView.addListeners(this);
    }

    @Override
    public void handle(ActionEvent event) {

        Object evt = event.getSource();

        if (evt == theView.getCheckBox()) {
            theModel.handleCheckBox(theView.getCheckBox().isSelected());
        }
        else if (evt == theView.getLoginButton()) {
            theModel.handleLoginButton(theView.getUsernameFieldText(), theView.getPasswordFieldText());
        }
    }

    public Scene getScene() {
        return theView.getScene();
    }
}
