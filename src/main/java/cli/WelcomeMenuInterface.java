package cli;

import interfaceAdapter.Controller;
import interfaceAdapter.Presenter;
import useCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public interface WelcomeMenuInterface {

    void displayWelcomeMenu(Presenter presenter);

    void choseLoginOrRegister(Scanner scanner, Controller controller, Presenter presenter,
                              RegisterInterface registerInterface, LogInInterface logInInterface,
                              MainMenuInterface mainMenuInterface,
                              ShowUsersInterface showUsersInterface, Filter filter) throws IOException, ClassNotFoundException, InvalidInputException;

}
