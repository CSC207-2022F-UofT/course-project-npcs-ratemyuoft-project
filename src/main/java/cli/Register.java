package cli;

import java.io.IOException;
import java.util.Scanner;
import interfaceAdapters.logInInterfaceAdapter.LogInController;
import interfaceAdapters.logInInterfaceAdapter.LogInPresenter;
import useCases.logInUseCase.InvalidInputException;

public class Register implements RegisterInterface{

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
    public void register(Scanner scanner, LogInController logInController, LogInPresenter logInPresenter)
            throws IOException, ClassNotFoundException, InvalidInputException {

        logInPresenter.outputMessage(" Enter username please = > "+ "\n");
        String userName = scanner.nextLine();

        logInPresenter.outputMessage(" Enter password please = > "+ "\n");
        String password = scanner.nextLine();

        logInPresenter.outputMessage(" Enter your Major please = > "+ "\n");
        String major = scanner.nextLine();

        logInPresenter.outputMessage(" Enter the year when you started your studies please = > "+ "\n");
        String year = scanner.nextLine();
        if (isInteger(year)) {

            try {
                logInController.userRegister(userName, password, major, Integer.parseInt(year));
                MainMenuInterface mainMenuInterface = new MainMenu();
                mainMenuInterface.displayMainMenu(logInPresenter);
                mainMenuInterface.choseOption(scanner, logInPresenter, logInController);

            } catch (InvalidInputException e) {
                WelcomeMenuInterface welcomeMenuInterface = new WelcomeMenu();
                welcomeMenuInterface.choseLoginOrRegister(scanner, logInController, logInPresenter);
            } catch (useCases.leaveReviewUseCase.InvalidInputException e) {
                throw new RuntimeException(e);
            }
        } else {
            logInPresenter.outputMessage("Please ensure that the year is an integer! Try again:" +"\n");
            WelcomeMenuInterface welcomeMenuInterface = new WelcomeMenu();
            welcomeMenuInterface.choseLoginOrRegister(scanner, logInController, logInPresenter);
        }


    }
}
