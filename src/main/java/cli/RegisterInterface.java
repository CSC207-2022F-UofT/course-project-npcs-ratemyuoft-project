package cli;

import java.io.IOException;
import java.util.Scanner;
import logInInterfaceAdapter.LogInController;
import logInInterfaceAdapter.LogInPresenter;
import logInuseCase.InvalidInputException;

public interface RegisterInterface {

    void register(Scanner scanner, LogInController logInController, LogInPresenter logInPresenter) throws IOException, ClassNotFoundException, InvalidInputException;

}
