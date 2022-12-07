package cli;

import java.io.IOException;
import java.util.Scanner;
import loginInterfaceAdapter.LogInController;
import loginInterfaceAdapter.LogInPresenter;
import loginUseCase.InvalidInputException;

public interface LogInInterface {

    void login(Scanner scanner, LogInController logInController, LogInPresenter logInPresenter)
            throws IOException, ClassNotFoundException, InvalidInputException;
}
