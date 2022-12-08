package cli;

import interfaceAdapters.logInInterfaceAdapter.LogInController;
import interfaceAdapters.logInInterfaceAdapter.LogInPresenter;
import useCases.logInUseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public interface MainMenuInterface {

    void displayMainMenu(LogInPresenter logInPresenter);

    void choseOption(Scanner scanner, LogInPresenter logInPresenter, LogInController logInController)
            throws IOException, ClassNotFoundException, InvalidInputException, useCases.leaveReviewUseCase.InvalidInputException;

}
