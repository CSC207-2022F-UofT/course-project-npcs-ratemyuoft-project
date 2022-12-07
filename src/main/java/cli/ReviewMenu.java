package cli;

import likeReviewInterfaceAdapters.LikeReviewController;
import logInInterfaceAdapter.LogInController;
import logInInterfaceAdapter.LogInPresenter;
import logInUseCase.InvalidInputException;
import java.io.IOException;
import java.util.Scanner;
public class ReviewMenu {
    public void displayFilterOptions() {
        System.out.println("1. Like Review \n2. Leave Review\n3. Comment on Review \nPlease enter your filter option");
    }

    public void filter(Scanner scanner, LikeReviewController likereviewController) throws ClassNotFoundException, InvalidInputException, IOException {
        int choice = scanner.nextInt();
        if (choice == 1) {
            try {
                System.out.println("Please enter the name of the Review you want to like");
                likereviewController.Like(scanner.next());

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        MainMenu mainMenu = new MainMenu();
        LogInPresenter logInPresenter = new LogInPresenter();
        LogInController logInController = new LogInController();
        mainMenu.displayMainMenu(logInPresenter);
        mainMenu.choseOption(scanner, logInPresenter, logInController);
    }
}


