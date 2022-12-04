package cli;

import filterInterfaceAdapters.FilterController;
import filterInterfaceAdapters.FilterFailException;
import java.util.Scanner;

public class FilterMenu {


    public void displayFilterOptions (){
        System.out.println("1. Filter by field of studies \n2. Filter by rating \n3. Filter by name \nPlease enter your filter option");
    }
    public void filter(Scanner scanner, FilterController filterController) {
        int choice = scanner.nextInt();
        if (choice == 1 | choice == 2 | choice == 3) {
            try {
                if (choice == 1) {
                    System.out.println("Please enter the field of study");
                    filterController.filterByFOS(scanner.next());
                } else if (choice == 2) {
                    System.out.println("Please enter the rating threshold");
                    filterController.filterByRating(scanner.nextInt());
                } else {
                    System.out.println("Please enter the name of the course");
                    filterController.filterByName(scanner.next());
                }
                System.out.println("Please enter the number of course to view details");
            } catch (FilterFailException filterFailException) {
                System.out.println(filterFailException.getMessage());
            }
            ViewCourseMenu viewCourseMenu = new ViewCourseMenu();
            viewCourseMenu.displayAfterFilterOptions();
            viewCourseMenu.chooseOptions(scanner, filterController);
        } else {
            displayFilterOptions();
            filter(scanner, filterController);
        }
    }
}
