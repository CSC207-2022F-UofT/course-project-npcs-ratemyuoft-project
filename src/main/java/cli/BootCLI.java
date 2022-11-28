package cli;

import courseDataBase.CourseDataAccess;
import userDataBase.UserDataBase;
import filterInterfaceAdapters.FilterController;
import filterInterfaceAdapters.FilterPresenter;
import courseDataBase.CourseDataBaseGateway;
import filterUseCases.FilterInputBoundary;
import filterUseCases.FilterOutputBoundary;
import filterUseCases.FilterUseCaseInteractor;
import loginInterfaceAdapter.LoginController;
import loginInterfaceAdapter.LoginPresenter;
import loginUseCase.LoginDataAccess;
import loginUseCase.LoginInputBoundary;
import loginUseCase.LoginInteractor;
import loginUseCase.InvalidInputException;

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

        Filter filter = new Filter();


        LoginPresenter loginPresenter = new LoginPresenter();
        LoginDataAccess loginDataAccess = new UserDataBase();
        LoginInputBoundary loginInputBoundary = new LoginInteractor(loginPresenter, loginDataAccess);
        LoginController loginController = new LoginController(loginInputBoundary);

        FilterOutputBoundary filterPresenter = new FilterPresenter();
        CourseDataBaseGateway filterDataBase = new CourseDataAccess();
        FilterInputBoundary filterUseCaseInteracter = new FilterUseCaseInteractor(filterDataBase, filterPresenter);
        FilterController filterController = new FilterController(filterUseCaseInteracter);

        welcomeMenuInterface.displayWelcomeMenu(loginPresenter);
        welcomeMenuInterface.choseLoginOrRegister(scanner, loginController, loginPresenter, registerInterface,
                logInInterface,mainMenuInterface,showUsersInterface, filter);


    }
}
