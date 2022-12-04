package cli;

import logInInterfaceAdapter.Controller;
import logInInterfaceAdapter.Presenter;
import logInUseCase.InvalidInputException;
import java.io.IOException;
import java.util.Scanner;

public class MainMenu implements MainMenuInterface{
    @Override
    public void displayMainMenu(Presenter presenter) {
        presenter.outputMessage("Avaliable Actions" + "\n" + "1. Show all the Users on our forum" + "\n" +
                "2. Log out" + "\n" + "3. Search Course" + "\n");
        presenter.outputMessage("Please, enter the number of the option to proceed"+ "\n");
    }

    @Override
    public void choseOption(Scanner scanner,Presenter presenter, Controller controller,
                             WelcomeMenuInterface welcomeMenuInterface,
                            RegisterInterface registerInterface,LogInInterface logInInterface,
                            ShowUsersInterface showUsersInterface)
            throws  ClassNotFoundException {
        int choice = scanner.nextInt();

        if(choice == 1){

            try {
                showUsersInterface.showUsers(scanner,presenter,controller,welcomeMenuInterface,
                        registerInterface,logInInterface,this);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        } else if (choice == 2) {
            try{
                controller.userLogOut();
                welcomeMenuInterface.choseLoginOrRegister(scanner,controller,presenter,registerInterface,
                        logInInterface,this,showUsersInterface);
            }  catch (IOException | InvalidInputException e) {
                displayMainMenu(presenter);
                this.choseOption(scanner,presenter,controller,welcomeMenuInterface,registerInterface,
                        logInInterface,showUsersInterface);
            }

        } else if (choice == 3) {
            try {
                controller.userLogOut();
                ViewCourseCLI vc = new ViewCourseCLI();
                vc.viewcourse(scanner);

            } catch (IOException | InvalidInputException e) {
                displayMainMenu(presenter);
                this.choseOption(scanner, presenter, controller, welcomeMenuInterface, registerInterface,
                        logInInterface, showUsersInterface);
            }


        } else{
            displayMainMenu(presenter);
            this.choseOption(scanner,presenter,controller,welcomeMenuInterface,registerInterface,
                    logInInterface,showUsersInterface);
        }

    }
}
