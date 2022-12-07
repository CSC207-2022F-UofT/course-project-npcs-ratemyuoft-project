package cli;

import java.io.IOException;
import java.util.Scanner;
import logInInterfaceAdapter.LogInController;
import logInInterfaceAdapter.LogInPresenter;
import logInUseCase.InvalidInputException;


public class Login implements LogInInterface  {


    @Override
    public void login(Scanner scanner, LogInController logInController, LogInPresenter logInPresenter)
            throws IOException, ClassNotFoundException, InvalidInputException {


            logInPresenter.outputMessage(" Enter username please => "+ "\n");
            String username = scanner.nextLine();

            logInPresenter.outputMessage(" Enter password please = >"+ "\n");
            String password = scanner.nextLine();




            try{
                logInController.userLogin(username,password);
                MainMenuInterface mainMenuInterface =new MainMenu();
                mainMenuInterface.displayMainMenu(logInPresenter);
                mainMenuInterface.choseOption(scanner, logInPresenter, logInController);
            }catch (InvalidInputException e){
                logInPresenter.outputMessage("Please try again"+"\n" + "\n");
                WelcomeMenuInterface welcomeMenuInterface =new WelcomeMenu();
                welcomeMenuInterface.displayWelcomeMenu(logInPresenter);
                welcomeMenuInterface.choseLoginOrRegister(scanner, logInController, logInPresenter);
            } catch (leaveReviewUseCase.InvalidInputException e) {
                throw new RuntimeException(e);
            }


    }
}
