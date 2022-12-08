package cli;

import courseDataBase.CourseDataAccess;
import courseDataBase.CourseDataAccessInterface;
import filterInterfaceAdapters.FilterController;
import leaveReviewInterfaceAdapter.LeaveReviewController;
import leaveReviewInterfaceAdapter.LeaveReviewPresenter;
import leaveReviewUseCase.LeaveReviewInputBoundary;
import leaveReviewUseCase.LeaveReviewInteractor;
import logInInterfaceAdapter.LogInController;
import logInInterfaceAdapter.LogInPresenter;
import logInUseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public class ViewCourseMenu {

    public void displayAfterFilterOptions(){
        System.out.println("1. Look for a different course\n2. View course reviews\n3. Leave a review\n" +
                "4. Go back to main menu");
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


    public void chooseOptions(Scanner scanner, FilterController filterController) throws InvalidInputException, IOException, ClassNotFoundException, leaveReviewUseCase.InvalidInputException {
        String choice = scanner.nextLine();
        if (isInteger(choice)) {
            if (Integer.parseInt(choice) == 1) {
                FilterMenu filtermenu = new FilterMenu();
                filtermenu.displayFilterOptions();
                Scanner scanner3 = new Scanner(System.in);
                filtermenu.filter(scanner3, filterController);
            } else if (Integer.parseInt(choice)== 2) {
                try {
                    ViewCourseCLI viewcoursecli = new ViewCourseCLI();
                    Scanner scanner3 = new Scanner(System.in);
                    viewcoursecli.viewcourse(scanner3);
                }catch (ClassNotFoundException e) {
                    System.out.println("Course not in directory, please try again");
                    Scanner newScanner = new Scanner(System.in);
                    displayAfterFilterOptions();
                    chooseOptions(newScanner, filterController);
                }

            } else if (Integer.parseInt(choice) == 3){
                Scanner scanner3 = new Scanner(System.in);
                LeaveReviewInterface registerInterface = new LeaveReview();
                LeaveReviewPresenter leaveReviewPresenter = new LeaveReviewPresenter();
                CourseDataAccessInterface dataAccess = new CourseDataAccess();
                LeaveReviewInputBoundary leaveReviewInputBoundary = new LeaveReviewInteractor(leaveReviewPresenter, dataAccess);
                LeaveReviewController leaveReviewController = new LeaveReviewController(leaveReviewInputBoundary);
                LeaveReviewWelcomeMenuInterface leaveReviewWelcomeMenuInterface = new LeaveReviewWelcomeMenu();

                leaveReviewWelcomeMenuInterface.chooseCourseToReview(scanner, scanner3, leaveReviewController,
                        leaveReviewPresenter, registerInterface, dataAccess);
            }

            else if (Integer.parseInt(choice) == 4){
                MainMenu mainmenu = new MainMenu();
                LogInPresenter logInPresenter = new LogInPresenter();
                mainmenu.displayMainMenu(logInPresenter);
                try {
                    LogInController logInController = new LogInController();
                    mainmenu.choseOption(scanner, logInPresenter, logInController);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Please enter an integer from the given list!");
                this.chooseOptions(scanner, filterController);
            }
        } else {
            System.out.println("Please enter an integer from the given list!");
            Scanner scanner1 = new Scanner(System.in);
            chooseOptions(scanner1, filterController);
        }
    }
}
