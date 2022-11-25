package CLI;

import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;
import UseCase.DataAccess;
import UseCase.InputBoundary;
import UseCase.OutputBoundary;

public interface BootCLIInterface {
    void boot(OutputBoundary outputBoundary, DataAccess dataAccess, InputBoundary inputBoundary,
              Controller controller, Presenter presenter) throws ClassNotFoundException;
}
