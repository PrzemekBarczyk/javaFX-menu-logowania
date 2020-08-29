package main.loginmenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class LoginMenuView {

    private Scene scene;
    private TextField usernameField;
    private TextField passwordField;
    private CheckBox checkBox;
    private Button loginButton;

    LoginMenuView() {

        // konfiguracja głównego Panelu
        GridPane mainPane = new GridPane();
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setPadding(new Insets(50));
        mainPane.setHgap(25);
        mainPane.setVgap(25);

        // dodanie komponentów do głownego Panelu
        Text menuNameText = new Text("PLEASE LOG IN");
        menuNameText.setFont(new Font("Default", 24));
        GridPane.setHalignment(menuNameText, HPos.CENTER);
        mainPane.add(menuNameText, 0, 0, 2, 1);

        Label usernameLabel = new Label("Username");
        mainPane.add(usernameLabel, 0, 1);

        usernameField = new TextField();
        mainPane.add(usernameField, 1, 1);

        Label passwordLabel = new Label("Password");
        mainPane.add(passwordLabel, 0, 2);

        passwordField = new PasswordField();
        mainPane.add(passwordField, 1, 2);

        BorderPane lowerPane = new BorderPane();
        mainPane.add(lowerPane, 0, 3, 2, 1);

        checkBox = new CheckBox("Remember me");
        lowerPane.setLeft(checkBox);

        loginButton = new Button("Login");
        lowerPane.setRight(loginButton);

        takeSavedLogin(); // pobiera ostatnie dane do logowania jeśli zaznaczono opcję "remember me"

        scene = new Scene(mainPane);
    }

    private void takeSavedLogin() {

        try {
            Scanner scanner = new Scanner(new FileReader("resources/saved_login.txt"));
            while (scanner.hasNextLine()) {
                System.out.println("Pobrano poprzednie dane logowania");
                String[] usernameAndPassword = scanner.nextLine().split(" ");
                usernameField.setText(usernameAndPassword[0]);
                passwordField.setText(usernameAndPassword[1]);
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("takeSavedLogin(): błąd przy otwieraniu pliku");
        }
    }

    void succesLogin() {
        System.out.println("Zalogowano");
    }

    void failLogin() {
        System.out.println("Błędny login lub hasło");
    }

    void addEventHandlers(EventHandler<ActionEvent> actionListener, EventHandler<KeyEvent> keyListener) {

        checkBox.setOnAction(actionListener);
        loginButton.setOnAction(actionListener);
        usernameField.setOnKeyReleased(keyListener);
        passwordField.setOnKeyReleased(keyListener);
    }

    Scene getScene() {
        return scene;
    }

    Button getLoginButton() {
        return loginButton;
    }

    CheckBox getCheckBox() {
        return checkBox;
    }

    TextField getUsernameField() {
        return usernameField;
    }

    TextField getPasswordField() {
        return passwordField;
    }
}
