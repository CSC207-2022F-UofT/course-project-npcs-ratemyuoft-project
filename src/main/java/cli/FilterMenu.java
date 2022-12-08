package cli;

import filterInterfaceAdapters.FilterController;
import filterInterfaceAdapters.FilterFailException;
import logInInterfaceAdapter.LogInController;
import logInInterfaceAdapter.LogInPresenter;
import logInUseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public class FilterMenu {


    public void displayFilterOptions (){
        System.out.println("1. Filter by field of studies \n2. Filter by rating \n3. Filter by name \n4. Go" +
                " back to main" + " menu\nPlease enter your filter option");
    }

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
    public void filter(Scanner scanner, FilterController filterController) throws InvalidInputException, IOException, ClassNotFoundException, leaveReviewUseCase.InvalidInputException {
        String choice = scanner.nextLine();

        if (isInteger(choice)) {
            if (Integer.parseInt(choice) == 1 | Integer.parseInt(choice) == 2 | Integer.parseInt(choice) == 3 |
                    Integer.parseInt(choice) == 4) {
                try {
                    if (Integer.parseInt(choice) == 1) {
                        System.out.println("Please enter the field of study");
                        filterController.filterByFOS(scanner.next());
                    } else if (Integer.parseInt(choice) == 2) {
                        System.out.println("Please enter the rating threshold");
                        filterController.filterByRating(scanner.nextInt());
                    } else if (Integer.parseInt(choice) == 3){
                        System.out.println("Please enter the name of the course");
                        filterController.filterByName(scanner.next());
                    }else {
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
                    } catch (FilterFailException filterFailException) {
                    Scanner scanner1 = new Scanner(System.in);
                        System.out.println(filterFailException.getMessage());
                        displayFilterOptions();
                        this.filter(scanner1, filterController);
                }
                ViewCourseMenu viewCourseMenu = new ViewCourseMenu();
                viewCourseMenu.displayAfterFilterOptions();
                Scanner scanner3 = new Scanner(System.in);
                viewCourseMenu.chooseOptions(scanner3, filterController);
            } else {
                System.out.println("Please enter an integer from the given list!");
                displayFilterOptions();
                this.filter(scanner, filterController);
            }
        }else {
            System.out.println("Please enter an integer from the given list!");
            this.filter(scanner, filterController);
        }
    }
}
