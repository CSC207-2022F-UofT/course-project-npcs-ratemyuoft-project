package cli;

import logInInterfaceAdapter.LogInController;
import logInInterfaceAdapter.LogInPresenter;
import logInUseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public interface MainMenuInterface {

    void displayMainMenu(LogInPresenter logInPresenter);

    void choseOption(Scanner scanner, LogInPresenter logInPresenter, LogInController logInController)
            throws IOException, ClassNotFoundException, InvalidInputException;

}
