package cli;

import interfaceAdapter.Controller;
import interfaceAdapter.Presenter;
import useCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu implements MainMenuInterface{
    @Override
    public void displayMainMenu(Presenter presenter) {
        presenter.outputMessage("Avaliable Actions" + "\n" + "1. Show all the Users on our forum" + "\n" +
                "2. Log out" + "\n" + "Another features will be avaliable later..." + "\n");
        presenter.outputMessage("Please, enter the number of the option to proceed"+ "\n");
    }

    @Override
    public void choseOption(Scanner scanner,Presenter presenter, Controller controller)
            throws  ClassNotFoundException {
        int choice = scanner.nextInt();

        if(choice == 1){

            try {
                ShowUsersInterface showUsersInterface =new ShowUsers();
                showUsersInterface.showUsers(scanner,presenter,controller);
            } catch (IOException e) {
                displayMainMenu(presenter);
                choseOption(scanner,presenter,controller);
            }


        } else if (choice == 2) {
            try{
                controller.userLogOut();
                WelcomeMenuInterface welcomeMenuInterface =new WelcomeMenu();
                welcomeMenuInterface.choseLoginOrRegister(scanner,controller,presenter);
            }  catch (IOException  e) {
                displayMainMenu(presenter);
                choseOption(scanner,presenter,controller);
            } catch (InvalidInputException e) {
                throw new RuntimeException(e);
            }

        }else{
            displayMainMenu(presenter);
            choseOption(scanner,presenter,controller);
        }

    }
}
