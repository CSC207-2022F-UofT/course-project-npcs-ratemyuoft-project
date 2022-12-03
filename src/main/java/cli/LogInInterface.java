package cli;

import java.io.IOException;
import java.util.Scanner;
import loginInterfaceAdapter.Controller;
import loginInterfaceAdapter.Presenter;
import loginUseCase.InvalidInputException;

public interface LogInInterface {

    void login(Scanner scanner, Controller controller, Presenter presenter,
               MainMenuInterface mainMenuInterface,
               WelcomeMenuInterface welcomeMenuInterface, RegisterInterface registerInterface,
               ShowUsersInterface showUsersInterface) throws IOException, ClassNotFoundException, InvalidInputException;
}
