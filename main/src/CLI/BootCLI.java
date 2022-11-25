package CLI;

import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;
import UseCase.DataAccess;
import UseCase.InputBoundary;
import UseCase.OutputBoundary;

import java.util.Scanner;

public class BootCLI implements BootCLIInterface {
    @Override
    public void boot(OutputBoundary outputBoundary, DataAccess dataAccess,InputBoundary inputBoundary,
                     Controller controller,Presenter presenter)  {

        Scanner scanner = new Scanner(System.in);
        RegisterInterface registerInterface = new Register();
        LogInInterface logInInterface = new Login();
        LogOutInterface logOutInterface =new LogOut();
        MainMenuInterface mainMenuInterface = new MainMenu();
        WelcomeMenuInterface welcomeMenuInterface = new WelcomeMenu();

        welcomeMenuInterface.displayWelcomeMenu(presenter);
        welcomeMenuInterface.choseLoginOrRegister(scanner,controller,presenter, registerInterface,
                logInInterface,mainMenuInterface, logOutInterface);


    }
}
