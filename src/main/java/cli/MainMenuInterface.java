package cli;

import loginInterfaceAdapter.Controller;
import loginInterfaceAdapter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public interface MainMenuInterface {

    void displayMainMenu(Presenter presenter);

    void choseOption(Scanner scanner,Presenter presenter, Controller controller,
                      WelcomeMenuInterface welcomeMenuInterface,
                     RegisterInterface registerInterface,LogInInterface logInInterface,
                     ShowUsersInterface showUsersInterface)
            throws IOException, ClassNotFoundException;

}
