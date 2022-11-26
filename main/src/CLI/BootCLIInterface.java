package CLI;

import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;
import UseCase.DataAccess;
import UseCase.InputBoundary;
import UseCase.InvalidInputException;
import UseCase.OutputBoundary;

import java.io.IOException;

public interface BootCLIInterface {
    void boot(OutputBoundary outputBoundary, DataAccess dataAccess, InputBoundary inputBoundary,
              Controller controller, Presenter presenter) throws ClassNotFoundException, IOException, InvalidInputException;
}
