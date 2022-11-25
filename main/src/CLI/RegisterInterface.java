package CLI;

import java.util.Scanner;
import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;

public interface RegisterInterface {

    void register(Scanner scanner, Controller controller, Presenter presenter,
                  MainMenuInterface mainMenuInterface, LogOutInterface logOutInterface,
                  WelcomeMenuInterface welcomeMenuInterface, LogInInterface logInInterface);

}
