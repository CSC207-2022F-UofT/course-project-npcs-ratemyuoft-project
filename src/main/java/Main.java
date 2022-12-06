import cli.BootCLI;
import cli.BootCLIInterface;
import leaveReviewUseCase.InvalidInputException;

import java.io.IOException;


/**
 * The most important class of the project and at the same time is the shortest one. It is not supposed to
 * have any other calls other than to run the project. Tests are omitted for the same reason.
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IOException, InvalidInputException {

        BootCLIInterface bootCLIInterface = new BootCLI();
        bootCLIInterface.boot();

    }
}
