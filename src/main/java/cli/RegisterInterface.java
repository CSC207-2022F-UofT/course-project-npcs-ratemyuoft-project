package cli;

import java.io.IOException;
import java.util.Scanner;
import loginInterfaceAdapter.LoginController;
import loginInterfaceAdapter.LoginPresenter;
import loginUseCase.InvalidInputException;

public interface RegisterInterface {

    void register(Scanner scanner, LoginController loginController, LoginPresenter loginPresenter,
                  MainMenuInterface mainMenuInterface,
                  WelcomeMenuInterface welcomeMenuInterface, LogInInterface logInInterface,
                  ShowUsersInterface showUsersInterface, Filter filter) throws IOException, ClassNotFoundException, InvalidInputException;

}
