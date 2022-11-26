package CLI;

import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class ShowUsers implements ShowUsersInterface{
    @Override
    public void showUsers(Scanner scanner, Presenter presenter, Controller controller,
                          WelcomeMenuInterface welcomeMenuInterface, RegisterInterface registerInterface,
                          LogInInterface logInInterface,
                          MainMenuInterface mainMenuInterface) throws IOException, ClassNotFoundException {
        presenter.outputMessage("Here is the list of users of our project");
        controller.showUsers();
        mainMenuInterface.displayMainMenu(presenter);
        mainMenuInterface.choseOption(scanner,presenter,controller,welcomeMenuInterface,
                registerInterface,logInInterface,this);
    }
}
