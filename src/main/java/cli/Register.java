package cli;

import java.io.IOException;
import java.util.Scanner;
import logInInterfaceAdapter.LogInController;
import logInInterfaceAdapter.LogInPresenter;
import logInUseCase.InvalidInputException;

public class Register implements RegisterInterface{

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
        int year = scanner.nextInt();

        try{
            logInController.userRegister(userName,password,major,year);
            MainMenuInterface mainMenuInterface = new MainMenu();
            mainMenuInterface.displayMainMenu(logInPresenter);
            mainMenuInterface.choseOption(scanner, logInPresenter, logInController);

        }catch (InvalidInputException e){
            WelcomeMenuInterface welcomeMenuInterface = new WelcomeMenu();
            welcomeMenuInterface.choseLoginOrRegister(scanner, logInController, logInPresenter);
        }


    }
}
