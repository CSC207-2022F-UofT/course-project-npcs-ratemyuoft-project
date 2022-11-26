package CLI;

import java.io.IOException;
import java.util.Scanner;
import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;
import UseCase.InvalidInputException;

public interface RegisterInterface {

    void register(Scanner scanner, Controller controller, Presenter presenter,
                  MainMenuInterface mainMenuInterface,
                  WelcomeMenuInterface welcomeMenuInterface, LogInInterface logInInterface,
                  ShowUsersInterface showUsersInterface) throws IOException, ClassNotFoundException, InvalidInputException;

}
