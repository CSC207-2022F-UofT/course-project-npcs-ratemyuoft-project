package CLI;

import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;

import java.util.Scanner;

public class LogOut implements  LogOutInterface {
    @Override
    public void logOut(Scanner scanner, Controller controller, Presenter presenter,
                       MainMenuInterface mainMenuInterface) {


        presenter.outputMessage("Are you sure you want to Log Out? Please answer Y or N ");
        String answer = scanner.nextLine();

        if (answer.equals("Y") || answer.equals("y")) {
            controller.userLogOut();
            //display welcome menu
        } else if (answer.equals("N") || answer.equals("n")) {
            mainMenuInterface.displayMainMenu(presenter);
        }
    }
}
