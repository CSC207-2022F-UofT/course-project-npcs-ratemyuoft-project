package cli;

import logInInterfaceAdapter.LogInController;
import logInInterfaceAdapter.LogInPresenter;
import logInuseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public interface WelcomeMenuInterface {

    void displayWelcomeMenu(LogInPresenter logInPresenter);

    void choseLoginOrRegister(Scanner scanner, LogInController logInController, LogInPresenter logInPresenter) throws IOException, ClassNotFoundException, InvalidInputException;

}
