package cli;

import courseDataBase.CourseDataAccess;
import filterInterfaceAdapters.FilterController;
import filterInterfaceAdapters.FilterPresenter;
import filterUseCases.CourseDataAccessInterface;
import filterUseCases.FilterInputBoundary;
import filterUseCases.FilterOutputBoundary;
import filterUseCases.FilterUseCaseInteractor;
import logInInterfaceAdapter.LogInController;
import logInInterfaceAdapter.LogInPresenter;
import logInUseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu implements MainMenuInterface{
    @Override
    public void displayMainMenu(LogInPresenter logInPresenter) {
        logInPresenter.outputMessage("Avaliable Actions" + "\n" + "1. Show all the Users on our forum" + "\n" +
                "2. Log out" + "\n" + "3. Filter for courses \n" + "Another features will be avaliable later..." + "\n");
        logInPresenter.outputMessage("Please, enter the number of the option to proceed"+ "\n");
    }

    @Override
    public void choseOption(Scanner scanner, LogInPresenter logInPresenter, LogInController logInController)
            throws ClassNotFoundException, InvalidInputException, IOException {
        int choice = scanner.nextInt();

        if(choice == 1){

            try {
                ShowUsersInterface showUsersInterface =new ShowUsers();
                showUsersInterface.showUsers(scanner, logInPresenter, logInController);
            } catch (IOException e) {
                displayMainMenu(logInPresenter);
                choseOption(scanner, logInPresenter, logInController);
            }


        } else if (choice == 2) {
            try{
                logInController.userLogOut();
                WelcomeMenuInterface welcomeMenuInterface =new WelcomeMenu();
                welcomeMenuInterface.choseLoginOrRegister(scanner, logInController, logInPresenter);
            }  catch (IOException  e) {
                displayMainMenu(logInPresenter);
                choseOption(scanner, logInPresenter, logInController);
            } catch (InvalidInputException e) {
                throw new RuntimeException(e);
            }

        } else if (choice == 3){
            FilterMenu filterMenu = new FilterMenu();
            filterMenu.displayFilterOptions();
            CourseDataAccessInterface courseDataAccessInterface = new CourseDataAccess();
            FilterOutputBoundary filterOutputBoundary = new FilterPresenter();
            FilterInputBoundary filterInputBoundary = new FilterUseCaseInteractor(courseDataAccessInterface, filterOutputBoundary);
            FilterController filterController = new FilterController(filterInputBoundary);

            filterMenu.filter(scanner, filterController);
        }

        else{
            displayMainMenu(logInPresenter);
            choseOption(scanner, logInPresenter, logInController);
        }

    }
}
