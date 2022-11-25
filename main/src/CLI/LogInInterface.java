package CLI;

import java.util.Collection;
import java.util.Scanner;
import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;

public interface LogInInterface {

    void login(Scanner scanner, Controller controller, Presenter presenter,
               MainMenuInterface mainMenuInterface, LogOutInterface logOutInterface,
               WelcomeMenuInterface welcomeMenuInterface, RegisterInterface registerInterface);
}
