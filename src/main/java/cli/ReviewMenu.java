package cli;

import dataBases.courseDataBase.CourseDataAccess;
import dataBases.courseDataBase.CourseDataAccessInterface;
import interfaceAdapters.filterInterfaceAdapters.FilterController;
import interfaceAdapters.filterInterfaceAdapters.FilterPresenter;
import useCases.filterUseCases.FilterInputBoundary;
import useCases.filterUseCases.FilterOutputBoundary;
import useCases.filterUseCases.FilterUseCaseInteractor;
import interfaceAdapters.likeReviewInterfaceAdapters.LikeReviewController;
import interfaceAdapters.logInInterfaceAdapter.LogInController;
import interfaceAdapters.logInInterfaceAdapter.LogInPresenter;
import useCases.logInUseCase.InvalidInputException;
import java.io.IOException;
import java.util.Scanner;
public class ReviewMenu {
    public void displayFilterOptions() {
        System.out.println("1. Like a review\n2. Comment on a review\n3. Go to course menu\n4. Go back to main menu");
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

    public void filter(Scanner scanner, LikeReviewController likereviewController) throws ClassNotFoundException, InvalidInputException, IOException, useCases.leaveReviewUseCase.InvalidInputException {
        String choice = scanner.nextLine();
        if (isInteger(choice)) {
            if (Integer.parseInt(choice) == 1) {
                try {
                    System.out.println("Please enter the name of the review you want to like:");
                    likereviewController.Like(scanner.next());
                    FilterOutputBoundary filterOutputBoundary = new FilterPresenter();
                    CourseDataAccessInterface dataaccess = new CourseDataAccess();
                    FilterInputBoundary filterInputBoundary = new FilterUseCaseInteractor(dataaccess, filterOutputBoundary);
                    FilterController filterController =  new FilterController(filterInputBoundary);
                    ViewCourseMenu viewCourseMenu = new ViewCourseMenu();
                    viewCourseMenu.displayAfterFilterOptions();
                    Scanner scanner3 = new Scanner(System.in);
                    viewCourseMenu.chooseOptions(scanner3, filterController);

                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else if ( Integer.parseInt(choice) == 2) {
                System.out.println("This feature is coming soon!" + "\n" + "Please choose a different option:");
                Scanner scanner3 = new Scanner(System.in);
                filter(scanner3, likereviewController);
            } else if ( Integer.parseInt(choice) == 3) {
                FilterOutputBoundary filterOutputBoundary = new FilterPresenter();
                CourseDataAccessInterface dataaccess = new CourseDataAccess();
                FilterInputBoundary filterInputBoundary = new FilterUseCaseInteractor(dataaccess, filterOutputBoundary);
                FilterController filterController =  new FilterController(filterInputBoundary);
                ViewCourseMenu viewCourseMenu = new ViewCourseMenu();
                viewCourseMenu.displayAfterFilterOptions();
                Scanner scanner3 = new Scanner(System.in);
                viewCourseMenu.chooseOptions(scanner3, filterController);

            } else if (Integer.parseInt(choice) == 4) {
                MainMenu mainmenu = new MainMenu();
                LogInPresenter logInPresenter = new LogInPresenter();
                mainmenu.displayMainMenu(logInPresenter);
                try {
                    LogInController logInController = new LogInController();
                    mainmenu.choseOption(scanner, logInPresenter, logInController);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                }else {System.out.println("Please enter an integer from the given list!");
                this.filter(scanner, likereviewController);
            }
        }else {
            System.out.println("Please enter an integer from the given list!");
            this.filter(scanner, likereviewController);

        }

        MainMenu mainMenu = new MainMenu();
        LogInPresenter logInPresenter = new LogInPresenter();
        LogInController logInController = new LogInController();
        mainMenu.displayMainMenu(logInPresenter);
        mainMenu.choseOption(scanner, logInPresenter, logInController);
    }
}


