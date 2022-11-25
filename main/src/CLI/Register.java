package CLI;

import java.util.Scanner;
import InterfaceAdapter.Controller;
import InterfaceAdapter.Presenter;

public class Register implements RegisterInterface{

    @Override
    public void register(Scanner scanner, Controller controller, Presenter presenter,
                         MainMenuInterface mainMenuInterface,
                         LogOutInterface logOutInterface,
                         WelcomeMenuInterface welcomeMenuInterface,
                         LogInInterface logInInterface) {

        presenter.outputMessage(" Enter username please => ");
        String userName = scanner.nextLine();

        presenter.outputMessage(" Enter password please = >");
        String password = scanner.nextLine();

        presenter.outputMessage(" Confirm your password please = >");
        String password1 = scanner.nextLine();

        presenter.outputMessage(" Enter your Major please = >");
        String major = scanner.nextLine();

        presenter.outputMessage(" Enter the year when you started your studies please = >");
        int startYear = scanner.nextInt();
        int year = Integer.valueOf(startYear);

        if(password.equals(password1)){
            controller.userRegister(userName,password,major,year);
            if(scanner.nextLine().equals("Invalid input")){
                    welcomeMenuInterface.displayWelcomeMenu(presenter);
                    welcomeMenuInterface.choseLoginOrRegister(scanner,controller,presenter,this,
                            logInInterface,mainMenuInterface,logOutInterface);
            }else if(scanner.nextLine().equals("Registration Successful!")){
                    mainMenuInterface.displayMainMenu(presenter);
                    mainMenuInterface.choseOption(scanner, presenter, controller, logOutInterface);
            }
        }else {
            presenter.outputMessage("Your Password doesn't match, please try again");
            welcomeMenuInterface.displayWelcomeMenu(presenter);
            welcomeMenuInterface.choseLoginOrRegister(scanner,controller,presenter,this,
                    logInInterface,mainMenuInterface,logOutInterface);
        }




    }
}
