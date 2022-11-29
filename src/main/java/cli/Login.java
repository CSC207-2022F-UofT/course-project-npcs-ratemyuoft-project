package cli;

import java.io.IOException;
import java.util.Scanner;

import interfaceAdapter.Controller;
import interfaceAdapter.Presenter;
import useCase.InvalidInputException;


public class Login implements LogInInterface  {


    @Override
    public void login(Scanner scanner, Controller controller, Presenter presenter)
            throws IOException, ClassNotFoundException, InvalidInputException {


            presenter.outputMessage(" Enter username please => "+ "\n");
            String username = scanner.nextLine();

            presenter.outputMessage(" Enter password please = >"+ "\n");
            String password = scanner.nextLine();




            try{
                controller.userLogin(username,password);
                MainMenuInterface mainMenuInterface =new MainMenu();
                mainMenuInterface.displayMainMenu(presenter);
                mainMenuInterface.choseOption(scanner,presenter,controller);
            }catch (InvalidInputException e){
                presenter.outputMessage("Please try again"+"\n" + "\n");
                WelcomeMenuInterface welcomeMenuInterface =new WelcomeMenu();
                welcomeMenuInterface.displayWelcomeMenu(presenter);
                welcomeMenuInterface.choseLoginOrRegister(scanner,controller,presenter);
            }


    }
}
