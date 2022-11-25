package CLI;

import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;

import java.util.Scanner;

public interface MainMenuInterface {

    void displayMainMenu(Presenter presenter);

    void choseOption(Scanner scanner, Presenter presenter, Controller controller, LogOutInterface logOutInterface);

}
