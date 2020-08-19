public class LoginMenuView {

    private LoginMenuController theController;

    public LoginMenuView() {

        theController = new LoginMenuController(this, new LoginMenuModel());
    }
}
