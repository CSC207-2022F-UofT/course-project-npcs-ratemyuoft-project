package cli;

import filterInterfaceAdapters.FilterController;
import filterInterfaceAdapters.FilterPresenter;
import filterUseCases.FilterOutputBoundary;
import loginInterfaceAdapter.LoginPresenter;
import viewCourseInterfaceAdapters.ViewCourseController;
import viewCourseInterfaceAdapters.ViewCoursePresenter;

import java.util.Scanner;

public class ViewCourse {

    public void viewCourse(Scanner scanner, ViewCourseController viewCourseController, ViewCoursePresenter viewCoursePresenter,
                           Filter filter, MainMenuInterface mainMenuInterface, FilterController filterController,
                           FilterOutputBoundary filterPresenter) {

        int choice = scanner.nextInt();

        if (choice == 0) {
            filter.chooseFilterOptions(scanner, filterController, filterPresenter, mainMenuInterface);

        }
        if (choice == 100){
            LoginPresenter loginPresenter = new LoginPresenter();
            mainMenuInterface.displayMainMenu(loginPresenter);


        }
    }
}
