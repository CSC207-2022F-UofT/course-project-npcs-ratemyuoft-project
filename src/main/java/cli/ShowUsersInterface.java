package cli;

import loginInterfaceAdapter.LogInController;
import loginInterfaceAdapter.LogInPresenter;
import loginUseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public interface ShowUsersInterface {
    void showUsers(Scanner scanner, LogInPresenter logInPresenter, LogInController logInController)
            throws IOException, ClassNotFoundException, InvalidInputException;

}
