package cli;

import logInInterfaceAdapter.LogInController;
import logInInterfaceAdapter.LogInPresenter;

import java.io.IOException;
import java.util.Scanner;

public class ShowUsers implements ShowUsersInterface{
    @Override
    public void showUsers(Scanner scanner, LogInPresenter logInPresenter, LogInController logInController)
            throws IOException, ClassNotFoundException {
        logInPresenter.outputMessage("Here is the list of users of our project"+ "\n");
        logInController.showUsers();
        MainMenuInterface mainMenuInterface = new MainMenu();
        mainMenuInterface.displayMainMenu(logInPresenter);
        mainMenuInterface.choseOption(scanner, logInPresenter, logInController);
    }
}
