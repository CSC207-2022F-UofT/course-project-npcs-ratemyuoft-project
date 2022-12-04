package cli;

import com.sun.tools.javac.Main;
import filterInterfaceAdapters.FilterController;
import logInInterfaceAdapter.LogInController;
import logInInterfaceAdapter.LogInPresenter;

import java.util.Scanner;

public class ViewCourseMenu {

    public void displayAfterFilterOptions(){
        System.out.println("Press 0 to filter again\nEnter -1 to go back to main menu");
    }

    public void chooseOptions(Scanner scanner, FilterController filterController){
        int choice = scanner.nextInt();
        if (choice == 0) {
            FilterMenu filtermenu = new FilterMenu();
            filtermenu.displayFilterOptions();
            filtermenu.filter(scanner, filterController);
        }
        else{
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
