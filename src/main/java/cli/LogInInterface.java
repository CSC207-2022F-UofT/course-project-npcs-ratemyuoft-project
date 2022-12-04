package cli;

import java.io.IOException;
import java.util.Scanner;
import logInInterfaceAdapter.Controller;
import logInInterfaceAdapter.Presenter;
import logInUseCase.InvalidInputException;

public interface LogInInterface {

    void login(Scanner scanner, Controller controller, Presenter presenter,
               MainMenuInterface mainMenuInterface,
               WelcomeMenuInterface welcomeMenuInterface, RegisterInterface registerInterface,
               ShowUsersInterface showUsersInterface) throws IOException, ClassNotFoundException, InvalidInputException;
}
