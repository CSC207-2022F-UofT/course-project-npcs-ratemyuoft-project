package cli;

import leaveReviewExceptions.InvalidInputException;

import java.io.IOException;

public interface BootCLIInterface {
    void boot() throws ClassNotFoundException, IOException, InvalidInputException;
}
