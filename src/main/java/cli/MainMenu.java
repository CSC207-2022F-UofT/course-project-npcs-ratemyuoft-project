package cli;

import dataBases.courseDataBase.CourseDataAccess;
import dataBases.courseDataBase.CourseDataAccessInterface;
import interfaceAdapters.filterInterfaceAdapters.FilterController;
import interfaceAdapters.filterInterfaceAdapters.FilterPresenter;
import useCases.filterUseCases.FilterInputBoundary;
import useCases.filterUseCases.FilterOutputBoundary;
import useCases.filterUseCases.FilterUseCaseInteractor;
import interfaceAdapters.logInInterfaceAdapter.LogInController;
import interfaceAdapters.logInInterfaceAdapter.LogInPresenter;
import useCases.logInUseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu implements MainMenuInterface{

    public boolean isInteger(String r) {
        return isInteger(r, 10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }
    @Override
    public void displayMainMenu(LogInPresenter logInPresenter) {
        logInPresenter.outputMessage("Available Actions:" + "\n" + "1. Show all the Users on our forum" + "\n" +
                "2. Log out" + "\n" + "3. Look for a course \n");
    }

    @Override
    public void choseOption(Scanner scanner, LogInPresenter logInPresenter, LogInController logInController)
            throws ClassNotFoundException, InvalidInputException, IOException, useCases.leaveReviewUseCase.InvalidInputException {
        String choice = scanner.nextLine();

        if (isInteger(choice)) {

            if (Integer.parseInt(choice) == 1) {

                try {
                    ShowUsersInterface showUsersInterface = new ShowUsers();
                    showUsersInterface.showUsers(scanner, logInPresenter, logInController);
                } catch (IOException e) {
                    displayMainMenu(logInPresenter);
                    choseOption(scanner, logInPresenter, logInController);
                }


            } else if (Integer.parseInt(choice) == 2) {
                try {
                    logInController.userLogOut();
                    WelcomeMenuInterface welcomeMenuInterface = new WelcomeMenu();
                    welcomeMenuInterface.displayWelcomeMenu(logInPresenter);
                    welcomeMenuInterface.choseLoginOrRegister(scanner, logInController, logInPresenter);
                } catch (IOException e) {
                    displayMainMenu(logInPresenter);
                    choseOption(scanner, logInPresenter, logInController);
                } catch (InvalidInputException e) {
                    throw new RuntimeException(e);
                }

            } else if (Integer.parseInt(choice) ==3) {
                FilterMenu filterMenu = new FilterMenu();
                filterMenu.displayFilterOptions();
                CourseDataAccessInterface courseDataAccessInterface = new CourseDataAccess();
                FilterOutputBoundary filterOutputBoundary = new FilterPresenter();
                FilterInputBoundary filterInputBoundary = new FilterUseCaseInteractor(courseDataAccessInterface, filterOutputBoundary);
                FilterController filterController = new FilterController(filterInputBoundary);

                filterMenu.filter(scanner, filterController);
            } else {
                displayMainMenu(logInPresenter);
                choseOption(scanner, logInPresenter, logInController);
            }
        }else {
            logInPresenter.outputMessage("Please enter an integer from the given list!" + "\n");
            choseOption(scanner, logInPresenter, logInController);
        }
    }
}
