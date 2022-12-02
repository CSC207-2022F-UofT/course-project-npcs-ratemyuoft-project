package cli;

import filterInterfaceAdapters.FilterFailException;
import loginInterfaceAdapter.LoginController;
import loginInterfaceAdapter.LoginPresenter;
import loginUseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public class WelcomeMenu implements WelcomeMenuInterface{
    @Override
    public void displayWelcomeMenu(LoginPresenter loginPresenter) {
        loginPresenter.outputMessage("\n" + "Avaliable Actions" + "\n" + "1. Register as new User" + "\n" +
                "2. Log in (if you already have an account)" + "\n");
        loginPresenter.outputMessage("Please, enter the number of the option to proceed"+ "\n");
    }

    @Override
    public void choseLoginOrRegister(Scanner scanner, LoginController loginController, LoginPresenter loginPresenter,
                                     RegisterInterface registerInterface, LogInInterface logInInterface,
                                     MainMenuInterface mainMenuInterface,
                                     ShowUsersInterface showUsersInterface, Filter filter)
            throws IOException, ClassNotFoundException, InvalidInputException, FilterFailException {

        String choice = scanner.nextLine();
        if(choice.contains("1")){

            registerInterface.register(scanner, loginController, loginPresenter,mainMenuInterface,
                    this ,logInInterface,showUsersInterface, filter);


        } else if (choice.contains("2")) {
            logInInterface.login(scanner, loginController, loginPresenter, mainMenuInterface,
                    this,registerInterface,showUsersInterface, filter);

        } else{
            displayWelcomeMenu(loginPresenter);
            choseLoginOrRegister(scanner, loginController, loginPresenter,registerInterface,logInInterface,
                    mainMenuInterface,showUsersInterface, filter);
        }
    }
}
