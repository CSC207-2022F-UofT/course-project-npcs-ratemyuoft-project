package cli;

import loginInterfaceAdapter.LoginController;
import loginInterfaceAdapter.LoginPresenter;

import java.io.IOException;
import java.util.Scanner;

public interface ShowUsersInterface {
    void showUsers(Scanner scanner, LoginPresenter loginPresenter, LoginController loginController,
                   WelcomeMenuInterface welcomeMenuInterface,
                   RegisterInterface registerInterface,
                   LogInInterface logInInterface,
                   MainMenuInterface mainMenuInterface, Filter filter) throws IOException, ClassNotFoundException;

}
