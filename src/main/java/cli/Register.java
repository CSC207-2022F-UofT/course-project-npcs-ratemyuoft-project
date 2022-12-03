package cli;

import java.io.IOException;
import java.util.Scanner;
import loginInterfaceAdapter.Controller;
import loginInterfaceAdapter.Presenter;
import loginUseCase.InvalidInputException;

public class Register implements RegisterInterface{

    @Override
    public void register(Scanner scanner, Controller controller, Presenter presenter,
                         MainMenuInterface mainMenuInterface,
                         WelcomeMenuInterface welcomeMenuInterface,
                         LogInInterface logInInterface,
                         ShowUsersInterface showUsersInterface) throws IOException, ClassNotFoundException, InvalidInputException {

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
            mainMenuInterface.displayMainMenu(presenter);
            mainMenuInterface.choseOption(scanner, presenter, controller,
                    welcomeMenuInterface,this,logInInterface,showUsersInterface);

        }catch (InvalidInputException e){
            welcomeMenuInterface.choseLoginOrRegister(scanner,controller,presenter,this,
                    logInInterface,mainMenuInterface,showUsersInterface);
        }


    }
}
