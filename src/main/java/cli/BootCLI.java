package cli;

import interfaceAdapter.Controller;
import interfaceAdapter.Presenter;
import useCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

/**
 * This is the class that creates all the needed interfaces and calls the welcome menu. This class is only called
 * by using BootCLI interface in Main class.
 */
public class BootCLI implements BootCLIInterface {
    @Override
    public void boot() throws IOException, ClassNotFoundException, InvalidInputException {

        Scanner scanner = new Scanner(System.in);
        Presenter presenter = new Presenter();
        Controller controller = new Controller();

        WelcomeMenuInterface welcomeMenuInterface = new WelcomeMenu();

        controller.userLogOut(); //this call is needed in case some users stayed logged in, when program was crashed.

        welcomeMenuInterface.displayWelcomeMenu(presenter);
        welcomeMenuInterface.choseLoginOrRegister(scanner,controller,presenter);


    }
}
