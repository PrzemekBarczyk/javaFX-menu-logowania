import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LoginMenuView {

    private Scene scene;
    private TextField usernameField;
    private TextField passwordField;
    private CheckBox checkBox;
    private Button loginButton;

    public LoginMenuView() {

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

        loginButton = new Button("login");
        lowerPane.setRight(loginButton);

        scene = new Scene(mainPane);
    }

    public void addListeners(EventHandler<ActionEvent> listener) {

        checkBox.setOnAction(listener);
        loginButton.setOnAction(listener);
    }

    public Scene getScene() {
        return scene;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public String getUsernameFieldText() {
        return usernameField.getText();
    }

    public String getPasswordFieldText() {
        return passwordField.getText();
    }
}
