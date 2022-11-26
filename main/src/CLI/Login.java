package CLI;

import java.io.IOException;
import java.util.Scanner;

import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;
import UseCase.InvalidInputException;


public class Login implements LogInInterface  {


    @Override
    public void login(Scanner scanner, Controller controller, Presenter presenter ,
                      MainMenuInterface mainMenuInterface,
                      WelcomeMenuInterface welcomeMenuInterface,RegisterInterface registerInterface,
                      ShowUsersInterface showUsersInterface) throws IOException, ClassNotFoundException, InvalidInputException {


            presenter.outputMessage(" Enter username please => ");
            String username = scanner.nextLine();

            presenter.outputMessage(" Enter password please = >");
            String password = scanner.nextLine();




            try{
                controller.userLogin(username,password);
                mainMenuInterface.displayMainMenu(presenter);
                mainMenuInterface.choseOption(scanner,presenter,controller,welcomeMenuInterface,
                        registerInterface,this,showUsersInterface);
            }catch (InvalidInputException e){
                presenter.outputMessage("Please try again"+"\n" + "\n");
                welcomeMenuInterface.choseLoginOrRegister(scanner,controller,presenter,registerInterface,
                        this,mainMenuInterface,showUsersInterface);
            }


    }
}
