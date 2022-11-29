package cli;

import java.io.IOException;
import java.util.Scanner;
import interfaceAdapter.Controller;
import interfaceAdapter.Presenter;
import useCase.InvalidInputException;

public interface LogInInterface {

    void login(Scanner scanner, Controller controller, Presenter presenter) throws IOException, ClassNotFoundException, InvalidInputException;
}
