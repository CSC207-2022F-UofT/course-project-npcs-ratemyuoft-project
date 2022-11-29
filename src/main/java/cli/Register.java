package cli;

import java.io.IOException;
import java.util.Scanner;
import interfaceAdapter.Controller;
import interfaceAdapter.Presenter;
import useCase.InvalidInputException;

public class Register implements RegisterInterface{

    @Override
    public void register(Scanner scanner, Controller controller, Presenter presenter) throws IOException,
            ClassNotFoundException, InvalidInputException {

        presenter.outputMessage(" Enter username please = > "+ "\n");
        String userName = scanner.nextLine();

        presenter.outputMessage(" Enter password please = > "+ "\n");
        String password = scanner.nextLine();

        presenter.outputMessage(" Enter your Major please = > "+ "\n");
        String major = scanner.nextLine();

        presenter.outputMessage(" Enter the year when you started your studies please = > "+ "\n");
        int year = scanner.nextInt();

        try{
            controller.userRegister(userName,password,major,year);
            MainMenuInterface mainMenuInterface = new MainMenu();
            mainMenuInterface.displayMainMenu(presenter);
            mainMenuInterface.choseOption(scanner,presenter,controller);

        }catch (InvalidInputException e){
            WelcomeMenuInterface welcomeMenuInterface = new WelcomeMenu();
            welcomeMenuInterface.choseLoginOrRegister(scanner,controller,presenter);
        }


    }
}
