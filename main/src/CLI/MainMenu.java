package CLI;

import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;
import UseCase.InvalidInputException;

import java.io.IOException;
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
                             WelcomeMenuInterface welcomeMenuInterface,
                            RegisterInterface registerInterface,LogInInterface logInInterface,
                            ShowUsersInterface showUsersInterface)
            throws IOException, ClassNotFoundException {
        int choice = scanner.nextInt();

        if(choice == 1){

            showUsersInterface.showUsers(scanner,presenter,controller,welcomeMenuInterface,
                    registerInterface,logInInterface,this);


        } else if (choice == 2) {
            try{
                controller.userLogOut();
                welcomeMenuInterface.choseLoginOrRegister(scanner,controller,presenter,registerInterface,
                        logInInterface,this,showUsersInterface);
            } catch (InvalidInputException e) {
                displayMainMenu(presenter);
                this.choseOption(scanner, presenter, controller,
                        welcomeMenuInterface,registerInterface,logInInterface,showUsersInterface);
            }

        } else{
            presenter.outputMessage("Input is invalid. Please try again");
            displayMainMenu(presenter);
            this.choseOption(scanner,presenter,controller,welcomeMenuInterface,registerInterface,
                    logInInterface,showUsersInterface);
        }

    }
}
