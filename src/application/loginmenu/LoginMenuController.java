package application.loginmenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import application.popoutmenu.PopOutWindowController;
import application.popoutmenu.PopOutWindowModel;
import application.popoutmenu.PopOutWindowView;

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

        if (evt == theView.getCheckBox()) { // zaznaczono/odznaczono checkBox
            theModel.handleCheckBox(theView.getCheckBox().isSelected());
        }
        else if (evt == theView.getLoginButton()) { // naciśnięto loginButton
            theModel.handleLoginButton(theView.getUsernameFieldText(), theView.getPasswordFieldText());

            if (theModel.getIsLoginCorrect()) { // sprawdza czy dane logowania są poprawne
                theView.succesLogin();
            }
            else {
                theView.failLogin();
            }
        }
    }

    public Scene getScene() {
        return theView.getScene();
    }
}
