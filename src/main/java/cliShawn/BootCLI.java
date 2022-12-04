package cliShawn;

import userDatabase.DataBase;
import loginInterfaceAdapter.Controller;
import loginInterfaceAdapter.Presenter;
import loginUseCase.*;

import java.io.IOException;
import java.util.Scanner;

/**
 * This is the class that creates all the needed interfaces and calls the welcome menu. This class is only called
 * by using BootCLI interface in Main class.
 */
public class BootCLI implements BootCLIInterface {
    @Override
    public void boot() throws IOException, ClassNotFoundException, InvalidInputException {

        Scanner scanner = new Scanner(System.in);
        RegisterInterface registerInterface = new Register();
        LogInInterface logInInterface = new Login();
        MainMenuInterface mainMenuInterface = new MainMenu();
        WelcomeMenuInterface welcomeMenuInterface = new WelcomeMenu();
        ShowUsersInterface showUsersInterface = new ShowUsers();
        Presenter presenter = new Presenter();
        DataAccess dataAccess = new DataBase();
        InputBoundary inputBoundary =new Interactor(presenter,dataAccess);
        Controller controller = new Controller(inputBoundary);
        ViewCourseCLI vcli = new ViewCourseCLI();

        welcomeMenuInterface.displayWelcomeMenu(presenter);
        welcomeMenuInterface.choseLoginOrRegister(scanner,controller,presenter, registerInterface,
                logInInterface,mainMenuInterface,showUsersInterface);


    }
}
