package cliShawn;

import loginInterfaceAdapter.Controller;
import loginInterfaceAdapter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public interface ShowUsersInterface {
    void showUsers(Scanner scanner, Presenter presenter, Controller controller,
                   WelcomeMenuInterface welcomeMenuInterface,
                   RegisterInterface registerInterface,
                   LogInInterface logInInterface,
                   MainMenuInterface mainMenuInterface) throws IOException, ClassNotFoundException;

}
