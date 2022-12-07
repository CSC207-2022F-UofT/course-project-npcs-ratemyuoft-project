package cli;

import filterInterfaceAdapters.FilterController;
import loginInterfaceAdapter.LogInController;
import loginInterfaceAdapter.LogInPresenter;
import loginUseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public class ViewCourseMenu {

    public void displayAfterFilterOptions(){
        System.out.println("Press 0 to filter again\nPress 1 to View Course Reviews\nEnter -1 to go back to main menu");
    }

    public void chooseOptions(Scanner scanner, FilterController filterController) throws InvalidInputException, IOException, ClassNotFoundException {
        int choice = scanner.nextInt();
        if (choice == 0) {
            FilterMenu filtermenu = new FilterMenu();
            filtermenu.displayFilterOptions();
            filtermenu.filter(scanner, filterController);
        } else if (choice == 1) {
            ViewCourseCLI viewcoursecli = new ViewCourseCLI();
            viewcoursecli.viewcourse(scanner);

        } else{
            MainMenu mainmenu = new MainMenu();
            LogInPresenter logInPresenter = new LogInPresenter();
            mainmenu.displayMainMenu(logInPresenter);
            try {
                LogInController logInController = new LogInController();
                mainmenu.choseOption(scanner, logInPresenter, logInController);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
