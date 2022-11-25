package CLI;

import java.util.Scanner;

import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;


public class Login implements LogInInterface  {


    @Override
    public void login(Scanner scanner, Controller controller, Presenter presenter ,
                      MainMenuInterface mainMenuInterface,LogOutInterface logOutInterface ,
                      WelcomeMenuInterface welcomeMenuInterface,RegisterInterface registerInterface) {


            presenter.outputMessage(" Enter username please => ");
            String userName = scanner.nextLine();

            presenter.outputMessage(" Enter password please = >");
            String password = scanner.nextLine();

            controller.userLogin(userName,password);

            if(scanner.nextLine().equals("Invalid input")) {
                presenter.outputMessage("Please try again"+"\n" + "\n");
                welcomeMenuInterface.displayWelcomeMenu(presenter);
                welcomeMenuInterface.choseLoginOrRegister(scanner,controller,presenter,registerInterface,
                        this,mainMenuInterface,logOutInterface);

            } else if (scanner.nextLine().equals("Login Successful!")) {
                mainMenuInterface.displayMainMenu(presenter);
                mainMenuInterface.choseOption(scanner,presenter,controller,logOutInterface);
            }


    }
}
