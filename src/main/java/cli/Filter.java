package cli;

import filterInterfaceAdapters.FilterController;
import filterInterfaceAdapters.FilterFailError;
import filterInterfaceAdapters.FilterPresenter;
import filterUseCases.FilterOutputBoundary;
import viewCourse.ViewCourseController;
import viewCourse.ViewCoursePresenter;

import java.util.Scanner;

public class Filter {


    public void chooseFilterOptions(Scanner scanner, FilterController filterController, FilterOutputBoundary filterPresenter,
                                    MainMenuInterface mainMenuInterface) throws FilterFailError {
        System.out.println("Choose filter options:" + "\n" + "1, Filter by field of studies" + "\n" +
                "2, Filter by ratings" + '\n' + "3, Search by course name" + '\n');
        int choice = scanner.nextInt();

        if (choice == 1){
            System.out.println("What is the field of study of interest?");
            try {filterController.filterByFOS(scanner.next());


                System.out.println("Insert the number of the course you want to view. " +'\n' + "Press - to go back to main menu" +
                        '\n' + "Press 0 to filter again" + '\n');
                ViewCourse viewCourse = new ViewCourse();
                ViewCourseController viewCourseController = new ViewCourseController();
                ViewCoursePresenter viewCoursePresenter = new ViewCoursePresenter();
                viewCourse.viewCourse(scanner, viewCourseController, viewCoursePresenter, this, mainMenuInterface,
                        filterController, filterPresenter);


            }
            catch(FilterFailError f) {
                System.out.println("filterfail");
            }

        }


    }
}
