package cli;

import useCases.logInUseCase.InvalidInputException;

import java.io.IOException;

public interface BootCLIInterface {
    void boot() throws ClassNotFoundException, IOException, InvalidInputException;
}
