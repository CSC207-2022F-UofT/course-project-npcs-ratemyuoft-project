package cli;

import interfaceAdapter.Controller;
import interfaceAdapter.Presenter;
import useCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public class WelcomeMenu implements WelcomeMenuInterface{
    @Override
    public void displayWelcomeMenu(Presenter presenter) {
        presenter.outputMessage("\n" + "Avaliable Actions" + "\n" + "1. Register as new User" + "\n" +
                "2. Log in (if you already have an account)" + "\n");
        presenter.outputMessage("Please, enter the number of the option to proceed"+ "\n");
    }

    @Override
    public void choseLoginOrRegister(Scanner scanner, Controller controller, Presenter presenter){
        String choice = scanner.nextLine();
        if(choice.contains("1")){

            RegisterInterface registerInterface = new Register();
            try {
                registerInterface.register(scanner,controller,presenter);
            } catch (IOException | ClassNotFoundException | InvalidInputException e) {
                displayWelcomeMenu(presenter);
                choseLoginOrRegister(scanner,controller,presenter);
            }


        } else if (choice.contains("2")) {
            LogInInterface logInInterface = new Login();
            try {
                logInInterface.login(scanner,controller,presenter);
            } catch (IOException | InvalidInputException | ClassNotFoundException e) {
                displayWelcomeMenu(presenter);
                choseLoginOrRegister(scanner,controller,presenter);
            }

        } else{
            WelcomeMenuInterface welcomeMenuInterface = new WelcomeMenu();
            welcomeMenuInterface.displayWelcomeMenu(presenter);
            try {
                welcomeMenuInterface.choseLoginOrRegister(scanner,controller,presenter);
            } catch (IOException | InvalidInputException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
