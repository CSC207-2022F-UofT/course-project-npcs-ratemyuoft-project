package cli;

import loginInterfaceAdapter.LoginController;
import loginInterfaceAdapter.LoginPresenter;

import java.io.IOException;
import java.util.Scanner;

public interface MainMenuInterface {

    void displayMainMenu(LoginPresenter loginPresenter);

    void choseOption(Scanner scanner, LoginPresenter loginPresenter, LoginController loginController,
                     WelcomeMenuInterface welcomeMenuInterface,
                     RegisterInterface registerInterface, LogInInterface logInInterface,
                     ShowUsersInterface showUsersInterface, Filter filter)
            throws IOException, ClassNotFoundException;



//    void choseOption(Scanner scanner, Presenter presenter, Controller controller,
//                     WelcomeMenuInterface welcomeMenuInterface,
//                     RegisterInterface registerInterface, LogInInterface logInInterface,
//                     ShowUsersInterface showUsersInterface, FilterController filterController, FilterPresenter filterPresenter)
//            throws  ClassNotFoundException;
}
