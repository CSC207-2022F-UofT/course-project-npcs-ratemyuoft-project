package CLI;

import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;
import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;
import UseCase.InvalidInputException;

public interface LogInInterface {

    void login(Scanner scanner, Controller controller, Presenter presenter,
               MainMenuInterface mainMenuInterface,
               WelcomeMenuInterface welcomeMenuInterface, RegisterInterface registerInterface,
               ShowUsersInterface showUsersInterface) throws IOException, ClassNotFoundException, InvalidInputException;
}
