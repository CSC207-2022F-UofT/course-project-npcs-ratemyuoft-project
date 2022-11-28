package cli;

import courseDataBase.CourseDataAccess;
import courseDataBase.CourseDataBaseGateway;
import filterInterfaceAdapters.FilterController;
import filterInterfaceAdapters.FilterFailError;
import filterInterfaceAdapters.FilterPresenter;
import filterUseCases.FilterOutputBoundary;
import viewCourseInterfaceAdapters.ViewCourseController;
import viewCourseInterfaceAdapters.ViewCoursePresenter;
import viewCourseUsecase.ViewCourseOutputBoundary;

import java.util.Scanner;

public class Filter {


    public void chooseFilterOptions(Scanner scanner, FilterController filterController, FilterOutputBoundary filterPresenter,
                                    MainMenuInterface mainMenuInterface) throws FilterFailError {
        System.out.println("Choose filter options:" + "\n" + "1, Filter by field of studies" + "\n" +
                "2, Filter by ratings" + '\n' + "3, Search by course name" + '\n');
        int choice = scanner.nextInt();
        ViewCourse viewCourse = new ViewCourse();
        ViewCourseOutputBoundary viewCourseOutputBoundary = new ViewCoursePresenter();
        CourseDataBaseGateway courseDataBaseGateway = new CourseDataAccess();
        ViewCourseController viewCourseController = new ViewCourseController("s", courseDataBaseGateway, viewCourseOutputBoundary);
        ViewCoursePresenter viewCoursePresenter = new ViewCoursePresenter();

        if (choice == 1){
            System.out.println("What is the field of study of interest?");
            try {filterController.filterByFOS(scanner.next());


                System.out.println("Insert the number of the course you want to view. " +'\n' + "Press 100 to go back to main menu" +
                        '\n' + "Press 0 to filter again" + '\n');

                viewCourse.viewCourse(scanner, viewCourseController, viewCoursePresenter, this, mainMenuInterface,
                        filterController, filterPresenter);


            }
            catch(FilterFailError f) {
                System.out.println("filterfail");
            }

        }
        else if (choice == 2) {
            System.out.println("Insert course rating threshold: " + '\n');
            try {
                filterController.filterByRating(scanner.nextInt());
                System.out.println("Insert the number of the course you want to view. " + '\n' + "Press 100 to go back to main menu" +
                        '\n' + "Press 0 to filter again" + '\n');
                viewCourse.viewCourse(scanner, viewCourseController, viewCoursePresenter, this, mainMenuInterface,
                        filterController, filterPresenter);
            }
            catch(FilterFailError f) {
                System.out.println("filterfail");
            }
        }
        else if (choice == 3){
            System.out.println("Enter Course Name:" + '\n');
            try{
                filterController.filterByName(scanner.next());
                System.out.println("Insert the number of the course you want to view. " + '\n' + "Press 100 to go back to main menu" +
                        '\n' + "Press 0 to filter again" + '\n');
                viewCourse.viewCourse(scanner, viewCourseController, viewCoursePresenter, this, mainMenuInterface,
                        filterController, filterPresenter);
            }
            catch(FilterFailError f) {
                System.out.println("filterfail");
            }
        }


    }
}
