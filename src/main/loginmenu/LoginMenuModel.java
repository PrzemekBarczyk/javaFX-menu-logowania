package main.loginmenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class LoginMenuModel {

    private boolean doRememberPassword; // czy wybrano zapamiętanie danych logowania
    private boolean isLoginCorrect; // czy podano poprawne dane
    private String username;
    private String password;

    LoginMenuModel() {

        doRememberPassword = false;
        username = "";
        password = "";
    }

    void handleCheckBox(boolean isSelected) {
        doRememberPassword = isSelected;
    }

    void handleLoginButton(String username, String password) {

        this.username = username;
        this.password = password;

        checkIsLoginCorrect(); // sprawdza czy podany login jest poprawny
        doRememberLogin(); // sprawdza czy zapisać hasło
    }

    private void checkIsLoginCorrect() {

        // sprawdza czy podane dane logowania są w pliku
        try {
            Scanner scanner = new Scanner(new File("resources/correct_logins.txt"));
            String[] usernameAndPassword;
            while (scanner.hasNextLine()) {
                usernameAndPassword = scanner.nextLine().split(" ");
                if (username.equals(usernameAndPassword[0]) && password.equals(usernameAndPassword[1])) {
                    isLoginCorrect = true;
                    return;
                }
            }
            isLoginCorrect = false; // nie znaleziono podanych danych logowania
        }
        catch (FileNotFoundException ex) {
            System.out.println("checkIsLoginCorrect(): błąd otwarcia pliku do odczytu");
            isLoginCorrect = false;
        }
    }

    private void doRememberLogin() {

        // sprawdza czy dane do logowania mają zostać zapisane
         if (isLoginCorrect && doRememberPassword) { // podano dobry login i zaznaczono opcję zapamiętania

             // zapisz dane w pliku
             try {
                 PrintWriter write = new PrintWriter("resources/saved_login.txt");
                 write.print(""); // wyczyść poprzednie dane
                 write.println(username + " " + password);
                 write.close();
             }
             catch (FileNotFoundException ex) {
                 System.out.println("doRememberLogin():1: błąd otwarcia pliku do zapisu");
             }
         }
         else { // podano dobry login i odznaczono opcję zapamiętania lub podano zły login

             // usuń zawartość pliku
             try {
                 PrintWriter write = new PrintWriter("resources/saved_login.txt");
                 write.print(""); // wyczyść wszystkie dane
             }
             catch (FileNotFoundException ex) {
                 System.out.println("doRememberLogin():2: błąd otwarcia pliku do zapisu");
             }
         }
    }

    boolean getIsLoginCorrect() {
        return isLoginCorrect;
    }
}
