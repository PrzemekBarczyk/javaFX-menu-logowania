package application.loginmenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import application.posloginmenu.PostloginMenuController;
import application.posloginmenu.PostloginMenuModel;
import application.posloginmenu.PostloginMenuView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LoginMenuController {

    private LoginMenuView theView;
    private LoginMenuModel theModel;

    public LoginMenuController(LoginMenuView theView, LoginMenuModel theModel) {

        this.theView = theView;
        this.theModel = theModel;

        this.theView.addListeners(this.actionHandler, this.keyHandler);
    }


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

    private void checkLoginData() {

        if (theModel.getIsLoginCorrect()) { // sprawdza czy dane logowania są poprawne
            theView.succesLogin();
        }
        else {
            theView.failLogin();
        }
    }

    public Scene getScene() {
        return theView.getScene();
    }
}
