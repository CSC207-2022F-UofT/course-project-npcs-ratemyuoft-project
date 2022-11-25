package CLI;

import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;

import java.util.Scanner;

public class WelcomeMenu implements WelcomeMenuInterface{
    @Override
    public void displayWelcomeMenu(Presenter presenter) {
        presenter.outputMessage("\n" + "Avaliable Actions" + "\n" + "1. Register as new User" + "\n" +
                "2. Log in (if you already have an account)" + "\n");
        presenter.outputMessage("Please, enter the number of the option to proceed");
    }

    @Override
    public void choseLoginOrRegister(Scanner scanner, Controller controller, Presenter presenter,
                                     RegisterInterface registerInterface, LogInInterface logInInterface,
                                     MainMenuInterface mainMenuInterface, LogOutInterface logOutInterface) {

        String choice = scanner.nextLine();
        if(choice.contains("1")){

            registerInterface.register(scanner,controller,presenter,mainMenuInterface, logOutInterface,
                    this ,logInInterface);


        } else if (choice.contains("2")) {
            logInInterface.login(scanner,controller,presenter, mainMenuInterface,logOutInterface,
                    this,registerInterface );

        } else{
            presenter.outputMessage("Input is invalid. Please try again");
            displayWelcomeMenu(presenter);
        }
    }
}
