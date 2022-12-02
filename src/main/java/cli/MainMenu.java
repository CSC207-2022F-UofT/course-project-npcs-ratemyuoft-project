package cli;

import logInInterfaceAdapter.LogInController;
import logInInterfaceAdapter.LogInPresenter;
import logInuseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu implements MainMenuInterface{
    @Override
    public void displayMainMenu(LogInPresenter logInPresenter) {
        logInPresenter.outputMessage("Avaliable Actions" + "\n" + "1. Show all the Users on our forum" + "\n" +
                "2. Log out" + "\n" + "Another features will be avaliable later..." + "\n");
        logInPresenter.outputMessage("Please, enter the number of the option to proceed"+ "\n");
    }

    @Override
    public void choseOption(Scanner scanner, LogInPresenter logInPresenter, LogInController logInController)
            throws  ClassNotFoundException {
        int choice = scanner.nextInt();

        if(choice == 1){

            try {
                ShowUsersInterface showUsersInterface =new ShowUsers();
                showUsersInterface.showUsers(scanner, logInPresenter, logInController);
            } catch (IOException e) {
                displayMainMenu(logInPresenter);
                choseOption(scanner, logInPresenter, logInController);
            }


        } else if (choice == 2) {
            try{
                logInController.userLogOut();
                WelcomeMenuInterface welcomeMenuInterface =new WelcomeMenu();
                welcomeMenuInterface.choseLoginOrRegister(scanner, logInController, logInPresenter);
            }  catch (IOException  e) {
                displayMainMenu(logInPresenter);
                choseOption(scanner, logInPresenter, logInController);
            } catch (InvalidInputException e) {
                throw new RuntimeException(e);
            }

        }else{
            displayMainMenu(logInPresenter);
            choseOption(scanner, logInPresenter, logInController);
        }

    }
}
