package cli;

import java.io.IOException;
import java.util.Scanner;
import interfaceAdapters.logInInterfaceAdapter.LogInController;
import interfaceAdapters.logInInterfaceAdapter.LogInPresenter;
import useCases.logInUseCase.InvalidInputException;

public interface RegisterInterface {

    void register(Scanner scanner, LogInController logInController, LogInPresenter logInPresenter)
            throws IOException, ClassNotFoundException, InvalidInputException;

}
