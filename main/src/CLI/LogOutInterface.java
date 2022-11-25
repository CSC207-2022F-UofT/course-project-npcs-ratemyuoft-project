package CLI;

import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;

import java.util.Scanner;

public interface LogOutInterface {
    void logOut(Scanner scanner, Controller controller, Presenter presenter, MainMenuInterface mainMenuInterface);
}
