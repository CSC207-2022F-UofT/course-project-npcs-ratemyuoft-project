package cli;

import java.io.IOException;
import java.util.Scanner;
import loginInterfaceAdapter.LoginController;
import loginInterfaceAdapter.LoginPresenter;
import loginUseCase.InvalidInputException;

public class Register implements RegisterInterface{

    @Override
    public void register(Scanner scanner, LoginController loginController, LoginPresenter loginPresenter,
                         MainMenuInterface mainMenuInterface,
                         WelcomeMenuInterface welcomeMenuInterface,
                         LogInInterface logInInterface,
                         ShowUsersInterface showUsersInterface, Filter filter) throws IOException, ClassNotFoundException, InvalidInputException {

        loginPresenter.outputMessage(" Enter username please = > "+ "\n");
        String userName = scanner.nextLine();

        loginPresenter.outputMessage(" Enter password please = > "+ "\n");
        String password = scanner.nextLine();

        loginPresenter.outputMessage(" Enter your Major please = > "+ "\n");
        String major = scanner.nextLine();

        loginPresenter.outputMessage(" Enter the year when you started your studies please = > "+ "\n");
        int year = scanner.nextInt();

        try{
            loginController.userRegister(userName,password,major,year);
            mainMenuInterface.displayMainMenu(loginPresenter);
            mainMenuInterface.choseOption(scanner, loginPresenter, loginController,
                    welcomeMenuInterface,this,logInInterface,showUsersInterface, filter);

        }catch (InvalidInputException e){
            welcomeMenuInterface.choseLoginOrRegister(scanner, loginController, loginPresenter,this,
                    logInInterface,mainMenuInterface,showUsersInterface, filter);
        }


    }
}
