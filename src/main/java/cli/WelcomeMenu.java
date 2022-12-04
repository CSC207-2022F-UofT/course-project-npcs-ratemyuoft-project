package cli;

import logInInterfaceAdapter.LogInController;
import logInInterfaceAdapter.LogInPresenter;
import logInUseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public class WelcomeMenu implements WelcomeMenuInterface{
    @Override
    public void displayWelcomeMenu(LogInPresenter logInPresenter) {
        logInPresenter.outputMessage("\n" + "Available Actions" + "\n" + "1. Register as new User" + "\n" +
                "2. Log in (if you already have an account)" + "\n");
        logInPresenter.outputMessage("Please, enter the number of the option to proceed"+ "\n");
    }

    @Override
    public void choseLoginOrRegister(Scanner scanner, LogInController logInController, LogInPresenter logInPresenter){
        String choice = scanner.nextLine();
        if(choice.contains("1")){

            RegisterInterface registerInterface = new Register();
            try {
                registerInterface.register(scanner, logInController, logInPresenter);
            } catch (IOException | ClassNotFoundException | InvalidInputException e) {
                displayWelcomeMenu(logInPresenter);
                choseLoginOrRegister(scanner, logInController, logInPresenter);
            }


        } else if (choice.contains("2")) {
            LogInInterface logInInterface = new Login();
            try {
                logInInterface.login(scanner, logInController, logInPresenter);
            } catch (IOException | InvalidInputException | ClassNotFoundException e) {
                displayWelcomeMenu(logInPresenter);
                choseLoginOrRegister(scanner, logInController, logInPresenter);
            }

        } else{
            WelcomeMenuInterface welcomeMenuInterface = new WelcomeMenu();
            welcomeMenuInterface.displayWelcomeMenu(logInPresenter);
            try {
                welcomeMenuInterface.choseLoginOrRegister(scanner, logInController, logInPresenter);
            } catch (IOException | InvalidInputException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
