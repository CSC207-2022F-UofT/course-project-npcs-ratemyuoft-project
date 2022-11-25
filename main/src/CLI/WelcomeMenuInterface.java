package CLI;

import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;

import java.util.Scanner;

public interface WelcomeMenuInterface {

    void displayWelcomeMenu(Presenter presenter);

    void choseLoginOrRegister(Scanner scanner, Controller controller, Presenter presenter,
                              RegisterInterface registerInterface, LogInInterface logInInterface,
                              MainMenuInterface mainMenuInterface,LogOutInterface logOutInterface);

}
