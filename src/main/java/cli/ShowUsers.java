package cli;

import logInInterfaceAdapter.LogInController;
import logInInterfaceAdapter.LogInPresenter;
import logInUseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public class ShowUsers implements ShowUsersInterface{
    public void showUsers(Scanner scanner, LogInPresenter logInPresenter, LogInController logInController)
            throws IOException, ClassNotFoundException, InvalidInputException, leaveReviewUseCase.InvalidInputException {
        logInPresenter.outputMessage("Here is the list of users of our project"+ "\n");
        logInController.showUsers();
        MainMenuInterface mainMenuInterface = new MainMenu();
        mainMenuInterface.displayMainMenu(logInPresenter);
        mainMenuInterface.choseOption(scanner, logInPresenter, logInController);
    }
}
