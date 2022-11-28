package cli;

import dataBase.DataBase;
import filterInterfaceAdapters.FilterController;
import filterInterfaceAdapters.FilterPresenter;
import filterUseCases.FilterDAGateway;
import filterUseCases.FilterInputBoundary;
import filterUseCases.FilterOutputBoundary;
import filterUseCases.FilterUseCaseInteractor;
import interfaceAdapter.Controller;
import interfaceAdapter.Presenter;
import useCase.*;

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


        Presenter presenter = new Presenter();
        DataAccess dataAccess = new dataBase.DataBase();
        InputBoundary inputBoundary = new Interactor(presenter,dataAccess);
        Controller controller = new Controller(inputBoundary);

        FilterOutputBoundary filterPresenter = new FilterPresenter();
        FilterDAGateway filterDataBase = new filterInterfaceAdapters.DataBase();
        FilterInputBoundary filterUseCaseInteracter = new FilterUseCaseInteractor(filterDataBase, filterPresenter);
        FilterController filterController = new FilterController(filterUseCaseInteracter);

        welcomeMenuInterface.displayWelcomeMenu(presenter);
        welcomeMenuInterface.choseLoginOrRegister(scanner,controller,presenter, registerInterface,
                logInInterface,mainMenuInterface,showUsersInterface, filter);


    }
}
