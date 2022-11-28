package cli;

import loginInterfaceAdapter.LoginController;
import loginInterfaceAdapter.LoginPresenter;

import java.io.IOException;
import java.util.Scanner;

public class ShowUsers implements ShowUsersInterface{
    @Override
    public void showUsers(Scanner scanner, LoginPresenter loginPresenter, LoginController loginController,
                          WelcomeMenuInterface welcomeMenuInterface, RegisterInterface registerInterface,
                          LogInInterface logInInterface,
                          MainMenuInterface mainMenuInterface, Filter filter) throws IOException, ClassNotFoundException {
        loginPresenter.outputMessage("Here is the list of users of our project"+ "\n");
        loginController.showUsers();
        mainMenuInterface.displayMainMenu(loginPresenter);
        mainMenuInterface.choseOption(scanner, loginPresenter, loginController,welcomeMenuInterface,
                registerInterface,logInInterface,this, filter);
    }
}
