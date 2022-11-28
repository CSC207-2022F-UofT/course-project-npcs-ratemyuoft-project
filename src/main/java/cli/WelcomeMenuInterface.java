package cli;

import loginInterfaceAdapter.LoginController;
import loginInterfaceAdapter.LoginPresenter;
import loginUseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public interface WelcomeMenuInterface {

    void displayWelcomeMenu(LoginPresenter loginPresenter);

    void choseLoginOrRegister(Scanner scanner, LoginController loginController, LoginPresenter loginPresenter,
                              RegisterInterface registerInterface, LogInInterface logInInterface,
                              MainMenuInterface mainMenuInterface,
                              ShowUsersInterface showUsersInterface, Filter filter) throws IOException, ClassNotFoundException, InvalidInputException;

}
