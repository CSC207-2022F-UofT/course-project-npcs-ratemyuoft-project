package cli;

import logInInterfaceAdapter.LogInController;
import logInInterfaceAdapter.LogInPresenter;
import logInUseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

/**
 * This is the class that creates all the needed interfaces and calls the welcome menu. This class is only called
 * by using BootCLI interface in Main class.
 * <p>
 * UPDATE: All the dependencies were eliminated, now the class is following Clean Architecture.
 */
public class BootCLI implements BootCLIInterface {
    @Override
    public void boot() throws IOException, ClassNotFoundException, InvalidInputException {

        Scanner scanner = new Scanner(System.in);
        LogInPresenter logInPresenter = new LogInPresenter();
        LogInController logInController = new LogInController();

        WelcomeMenuInterface welcomeMenuInterface = new WelcomeMenu();

        logInController.userLogOut(); //this call is needed in case some users stayed logged in, when program was crashed.

        welcomeMenuInterface.displayWelcomeMenu(logInPresenter);
        welcomeMenuInterface.choseLoginOrRegister(scanner, logInController, logInPresenter);


    }
}
