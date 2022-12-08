package cli;

import interfaceAdapters.logInInterfaceAdapter.LogInController;
import interfaceAdapters.logInInterfaceAdapter.LogInPresenter;
import useCases.logInUseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public class WelcomeMenu implements WelcomeMenuInterface{
    @Override
    public void displayWelcomeMenu(LogInPresenter logInPresenter) {
        logInPresenter.outputMessage("\n" + "Available Actions" + "\n" + "1. Register as new User" + "\n" +
                "2. Log in (if you already have an account)" + "\n");
        logInPresenter.outputMessage("Please, enter the number of the option to proceed"+ "\n");
    }
    public boolean isInteger(String r) {
        return isInteger(r, 10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }


    @Override
    public void choseLoginOrRegister(Scanner scanner, LogInController logInController, LogInPresenter logInPresenter){
        String choice = scanner.nextLine();
        if (isInteger(choice)) {
            if (Integer.parseInt(choice) == 1) {

                RegisterInterface registerInterface = new Register();
                try {
                    registerInterface.register(scanner, logInController, logInPresenter);
                } catch (IOException | ClassNotFoundException | InvalidInputException e) {
                    displayWelcomeMenu(logInPresenter);
                    choseLoginOrRegister(scanner, logInController, logInPresenter);
                }


            } else if (Integer.parseInt(choice) == 2) {
                LogInInterface logInInterface = new Login();
                try {
                    logInInterface.login(scanner, logInController, logInPresenter);
                } catch (IOException | InvalidInputException | ClassNotFoundException e) {
                    displayWelcomeMenu(logInPresenter);
                    choseLoginOrRegister(scanner, logInController, logInPresenter);
                }

            } else {
                WelcomeMenuInterface welcomeMenuInterface = new WelcomeMenu();
                welcomeMenuInterface.displayWelcomeMenu(logInPresenter);
                try {
                    welcomeMenuInterface.choseLoginOrRegister(scanner, logInController, logInPresenter);
                } catch (IOException | InvalidInputException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }else {
            logInPresenter.outputMessage("Please enter an integer from the given list!" + "\n");
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
