package cli;

import java.io.IOException;
import java.util.Scanner;
import interfaceAdapter.Controller;
import interfaceAdapter.Presenter;
import useCase.InvalidInputException;

public interface RegisterInterface {

    void register(Scanner scanner, Controller controller, Presenter presenter,
                  MainMenuInterface mainMenuInterface,
                  WelcomeMenuInterface welcomeMenuInterface, LogInInterface logInInterface,
                  ShowUsersInterface showUsersInterface) throws IOException, ClassNotFoundException, InvalidInputException;

}
