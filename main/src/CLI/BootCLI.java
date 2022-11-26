package CLI;

import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;
import UseCase.DataAccess;
import UseCase.InputBoundary;
import UseCase.InvalidInputException;
import UseCase.OutputBoundary;

import java.io.IOException;
import java.util.Scanner;

public class BootCLI implements BootCLIInterface {
    @Override
    public void boot(OutputBoundary outputBoundary, DataAccess dataAccess,InputBoundary inputBoundary,
                     Controller controller,Presenter presenter) throws IOException, ClassNotFoundException, InvalidInputException {

        Scanner scanner = new Scanner(System.in);
        RegisterInterface registerInterface = new Register();
        LogInInterface logInInterface = new Login();
        MainMenuInterface mainMenuInterface = new MainMenu();
        WelcomeMenuInterface welcomeMenuInterface = new WelcomeMenu();
        ShowUsersInterface showUsersInterface = new ShowUsers();

        welcomeMenuInterface.displayWelcomeMenu(presenter);
        welcomeMenuInterface.choseLoginOrRegister(scanner,controller,presenter, registerInterface,
                logInInterface,mainMenuInterface,showUsersInterface);


    }
}
