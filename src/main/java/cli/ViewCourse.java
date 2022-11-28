package cli;

import filterInterfaceAdapters.FilterController;
import filterInterfaceAdapters.FilterPresenter;
import filterUseCases.FilterOutputBoundary;
import viewCourse.ViewCourseController;
import viewCourse.ViewCoursePresenter;

import java.util.Scanner;

public class ViewCourse {

    public void viewCourse(Scanner scanner, ViewCourseController viewCourseController, ViewCoursePresenter viewCoursePresenter,
                           Filter filter, MainMenuInterface mainMenuInterface, FilterController filterController,
                           FilterOutputBoundary filterPresenter) {

        int choice = scanner.nextInt();

        if (choice == 0) {
            filter.chooseFilterOptions(scanner, filterController, filterPresenter, mainMenuInterface);

        }
    }
}
