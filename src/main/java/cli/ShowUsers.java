package cli;

import interfaceAdapters.logInInterfaceAdapter.LogInController;
import interfaceAdapters.logInInterfaceAdapter.LogInPresenter;
import useCases.logInUseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public class ShowUsers implements ShowUsersInterface{
    public void showUsers(Scanner scanner, LogInPresenter logInPresenter, LogInController logInController)
            throws IOException, ClassNotFoundException, InvalidInputException, useCases.leaveReviewUseCase.InvalidInputException {
        logInPresenter.outputMessage("Here is the list of users of our project"+ "\n");
        logInController.showUsers();
        MainMenuInterface mainMenuInterface = new MainMenu();
        mainMenuInterface.displayMainMenu(logInPresenter);
        mainMenuInterface.choseOption(scanner, logInPresenter, logInController);
    }
}
