package cli;

import interfaceAdapter.Controller;
import interfaceAdapter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public interface MainMenuInterface {

    void displayMainMenu(Presenter presenter);

    void choseOption(Scanner scanner,Presenter presenter, Controller controller,
                      WelcomeMenuInterface welcomeMenuInterface,
                     RegisterInterface registerInterface,LogInInterface logInInterface,
                     ShowUsersInterface showUsersInterface, Filter filter)
            throws IOException, ClassNotFoundException;

//    void choseOption(Scanner scanner, Presenter presenter, Controller controller,
//                     WelcomeMenuInterface welcomeMenuInterface,
//                     RegisterInterface registerInterface, LogInInterface logInInterface,
//                     ShowUsersInterface showUsersInterface, FilterController filterController, FilterPresenter filterPresenter)
//            throws  ClassNotFoundException;
}
