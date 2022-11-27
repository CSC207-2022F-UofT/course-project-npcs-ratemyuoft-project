package CLI;

import interfaceAdapter.Controller;
import interfaceAdapter.Presenter;
import useCase.DataAccess;
import useCase.InputBoundary;
import useCase.InvalidInputException;
import useCase.OutputBoundary;

import java.io.IOException;

public interface BootCLIInterface {
    void boot(OutputBoundary outputBoundary, DataAccess dataAccess, InputBoundary inputBoundary,
              Controller controller, Presenter presenter) throws ClassNotFoundException, IOException, InvalidInputException;
}
