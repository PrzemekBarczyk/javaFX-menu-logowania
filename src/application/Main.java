package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import application.loginmenu.LoginMenuController;
import application.loginmenu.LoginMenuModel;
import application.loginmenu.LoginMenuView;

public class Main extends Application {

    private static Stage primaryStage;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        primaryStage = stage;
        primaryStage.setTitle("Login Menu");
        primaryStage.setScene(new LoginMenuController(new LoginMenuView(), new LoginMenuModel()).getScene());
        primaryStage.show();
    }

    public static void setScene(Scene newScene) {
        primaryStage.setScene(newScene);
    }
}
