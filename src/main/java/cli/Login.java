package cli;

import java.io.IOException;
import java.util.Scanner;
import interfaceAdapters.logInInterfaceAdapter.LogInController;
import interfaceAdapters.logInInterfaceAdapter.LogInPresenter;
import useCases.logInUseCase.InvalidInputException;


public class Login implements LogInInterface  {


    @Override
    public void login(Scanner scanner, LogInController logInController, LogInPresenter logInPresenter)
            throws IOException, ClassNotFoundException, InvalidInputException {


            logInPresenter.outputMessage("Enter username:"+ "\n");
            String username = scanner.nextLine();

            logInPresenter.outputMessage("Enter password:"+ "\n");
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
            } catch (useCases.leaveReviewUseCase.InvalidInputException e) {
                throw new RuntimeException(e);
            }


    }
}
