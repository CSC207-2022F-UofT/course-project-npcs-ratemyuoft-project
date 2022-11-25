package CLI;

import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;

import java.util.Scanner;

public class MainMenu implements MainMenuInterface{
    @Override
    public void displayMainMenu(Presenter presenter) {
        presenter.outputMessage("Avaliable Actions" + "\n" + "1. Show all the Users on our forum" + "\n" +
                "2. Log out" + "\n" + "Another features will be avaliable later..." + "\n");
        presenter.outputMessage("Please, enter the number of the option to proceed");
    }

    @Override
    public void choseOption(Scanner scanner,Presenter presenter, Controller controller,
                            LogOutInterface logOutInterface) {
        String choice = scanner.nextLine();
        if(choice.contains("1")){

            presenter.outputMessage("Here is the list of users of our project");
            controller.showUsers();


        } else if (choice.contains("2")) {
            MainMenuInterface mainMenuInterface = new MainMenu();
            logOutInterface.logOut(scanner,controller,presenter, mainMenuInterface );

        } else{
            presenter.outputMessage("Input is invalid. Please try again");
            displayMainMenu(presenter);
        }

    }
}
