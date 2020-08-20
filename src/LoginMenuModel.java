public class LoginMenuModel {

    private boolean rememberPassword;
    private String username;
    private String password;

    public LoginMenuModel() {

        rememberPassword = false;
        username = "";
        password = "";
    }

    public void handleCheckBox(boolean isSelected) {

        rememberPassword = isSelected;
        System.out.println(rememberPassword);
    }

    public void handleLoginButton(String username, String password) {

        this.username = username;
        this.password = password;
        System.out.println(username + " " + password);
    }
}
