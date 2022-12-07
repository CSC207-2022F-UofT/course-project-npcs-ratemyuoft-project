package cli;

import logInUseCase.InvalidInputException;

import java.io.IOException;

public interface BootCLIInterface {
    void boot() throws ClassNotFoundException, IOException, InvalidInputException;
}
