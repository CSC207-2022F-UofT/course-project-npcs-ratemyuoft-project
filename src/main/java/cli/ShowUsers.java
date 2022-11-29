package cli;

import interfaceAdapter.Controller;
import interfaceAdapter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class ShowUsers implements ShowUsersInterface{
    @Override
    public void showUsers(Scanner scanner, Presenter presenter, Controller controller)
            throws IOException, ClassNotFoundException {
        presenter.outputMessage("Here is the list of users of our project"+ "\n");
        controller.showUsers();
        MainMenuInterface mainMenuInterface = new MainMenu();
        mainMenuInterface.displayMainMenu(presenter);
        mainMenuInterface.choseOption(scanner,presenter,controller);
    }
}
