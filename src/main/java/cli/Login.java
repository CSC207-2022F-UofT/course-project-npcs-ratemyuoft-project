package cli;

import java.io.IOException;
import java.util.Scanner;

import loginInterfaceAdapter.LoginController;
import loginInterfaceAdapter.LoginPresenter;
import loginUseCase.InvalidInputException;


public class Login implements LogInInterface  {


    @Override
    public void login(Scanner scanner, LoginController loginController, LoginPresenter loginPresenter,
                      MainMenuInterface mainMenuInterface,
                      WelcomeMenuInterface welcomeMenuInterface, RegisterInterface registerInterface,
                      ShowUsersInterface showUsersInterface, Filter filter) throws IOException, ClassNotFoundException, InvalidInputException {


            loginPresenter.outputMessage(" Enter username please => "+ "\n");
            String username = scanner.nextLine();

            loginPresenter.outputMessage(" Enter password please = >"+ "\n");
            String password = scanner.nextLine();




            try{
                loginController.userLogin(username,password);
                mainMenuInterface.displayMainMenu(loginPresenter);
                mainMenuInterface.choseOption(scanner, loginPresenter, loginController,welcomeMenuInterface,
                        registerInterface,this,showUsersInterface, filter);
            }catch (InvalidInputException e){
                loginPresenter.outputMessage("Please try again"+"\n" + "\n");
                welcomeMenuInterface.displayWelcomeMenu(loginPresenter);
                welcomeMenuInterface.choseLoginOrRegister(scanner, loginController, loginPresenter,registerInterface,
                        this,mainMenuInterface,showUsersInterface, filter);
            }


    }
}
