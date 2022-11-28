package cli;

import java.io.IOException;
import java.util.Scanner;
import loginInterfaceAdapter.LoginController;
import loginInterfaceAdapter.LoginPresenter;
import loginUseCase.InvalidInputException;

public interface LogInInterface {

    void login(Scanner scanner, LoginController loginController, LoginPresenter loginPresenter,
               MainMenuInterface mainMenuInterface,
               WelcomeMenuInterface welcomeMenuInterface, RegisterInterface registerInterface,
               ShowUsersInterface showUsersInterface, Filter filter) throws IOException, ClassNotFoundException, InvalidInputException;
}
