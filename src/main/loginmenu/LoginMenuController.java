package main.loginmenu;

import main.posloginmenu.PostloginMenuController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LoginMenuController {

    private LoginMenuView theView;
    private LoginMenuModel theModel;

    public LoginMenuController() {

        this.theView = new LoginMenuView();
        this.theModel = new LoginMenuModel();

        EventHandler<ActionEvent> actionHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Object evt = event.getSource();

                if (evt == theView.getCheckBox()) { // zaznaczono/odznaczono checkBox
                    theModel.handleCheckBox(theView.getCheckBox().isSelected());
                }
                else { // naciśnięto loginButton
                    theModel.handleLoginButton(theView.getUsernameField().getText(), theView.getPasswordField().getText());
                    checkLoginData();
                }
            }
        };

        EventHandler<KeyEvent> keyHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if (event.getCode() == KeyCode.ENTER) { // naciśnięto ENTER w polu loginu lub hasła

                    if (event.getSource() == theView.getUsernameField()) { // pole loginu
                        theView.getPasswordField().requestFocus();
                    }
                    else { // pole hasła
                        theModel.handleLoginButton(theView.getUsernameField().getText(), theView.getPasswordField().getText());
                        checkLoginData();
                    }
                }
            }
        };

        this.theView.addListeners(actionHandler, keyHandler);
    }

    private void checkLoginData() {

        if (theModel.getIsLoginCorrect()) { // sprawdza czy dane logowania są poprawne
            new PostloginMenuController("Success Login");
        }
        else {
            new PostloginMenuController("Fail Login");
        }
    }

    public Scene getScene() {
        return theView.getScene();
    }
}
