package cli;

import courseDataBase.CourseDataAccess;
import filterInterfaceAdapters.FilterController;
import filterInterfaceAdapters.FilterFailException;
import filterInterfaceAdapters.FilterPresenter;
import filterUseCases.CourseDataAccessInterface;
import filterUseCases.FilterInputBoundary;
import filterUseCases.FilterOutputBoundary;
import filterUseCases.FilterUseCaseInteracter;
import loginInterfaceAdapter.LoginController;
import loginInterfaceAdapter.LoginPresenter;
import loginUseCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu implements MainMenuInterface{
    @Override
    public void displayMainMenu(LoginPresenter loginPresenter) {
        loginPresenter.outputMessage("Avaliable Actions" + "\n" + "1. Show all the Users on our forum" + "\n" +
                "2. Log out" + "\n" + "3. Filter for courses" + "\n" +
                "Other features will be avaliable later..." + "\n");
        loginPresenter.outputMessage("Please, enter the number of the option to proceed"+ "\n");
    }

//    @Override
//    public void choseOption(Scanner scanner, Presenter presenter, Controller controller,
//                            WelcomeMenuInterface welcomeMenuInterface,
//                            RegisterInterface registerInterface, LogInInterface logInInterface,
//                            ShowUsersInterface showUsersInterface)
//            throws  ClassNotFoundException {
//        int choice = scanner.nextInt();
//
//        if(choice == 1){
//
//            try {
//                showUsersInterface.showUsers(scanner,presenter,controller,welcomeMenuInterface,
//                        registerInterface,logInInterface,this);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//
//        } else if (choice == 2) {
//            try{
//                controller.userLogOut();
//                welcomeMenuInterface.choseLoginOrRegister(scanner,controller,presenter,registerInterface,
//                        logInInterface,this,showUsersInterface);
//            }  catch (IOException | InvalidInputException e) {
//                displayMainMenu(presenter);
//                this.choseOption(scanner,presenter,controller,welcomeMenuInterface,registerInterface,
//                        logInInterface,showUsersInterface);
//            }
//
//
//
//        } else{
//            displayMainMenu(presenter);
//            this.choseOption(scanner,presenter,controller,welcomeMenuInterface,registerInterface,
//                    logInInterface,showUsersInterface);
//        }
//
//    }

    @Override
    public void choseOption(Scanner scanner, LoginPresenter loginPresenter, LoginController loginController, WelcomeMenuInterface welcomeMenuInterface, RegisterInterface registerInterface, LogInInterface logInInterface, ShowUsersInterface showUsersInterface, Filter filter) throws ClassNotFoundException, FilterFailException {
        int choice = scanner.nextInt();

        if(choice == 1){

            try {
                showUsersInterface.showUsers(scanner, loginPresenter, loginController,welcomeMenuInterface,
                        registerInterface,logInInterface,this, filter);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        } else if (choice == 2) {
            try{
                loginController.userLogOut();
                welcomeMenuInterface.choseLoginOrRegister(scanner, loginController, loginPresenter,registerInterface,
                        logInInterface,this,showUsersInterface, filter);
            }  catch (IOException | InvalidInputException e) {
                displayMainMenu(loginPresenter);
                this.choseOption(scanner, loginPresenter, loginController,welcomeMenuInterface,registerInterface,
                        logInInterface,showUsersInterface, filter);
            }



        } else if (choice == 3){

            FilterOutputBoundary filterPresenter = new FilterPresenter();
            CourseDataAccessInterface filterDataBase = new CourseDataAccess();
            FilterInputBoundary filterUseCaseInteracter = new FilterUseCaseInteracter(filterDataBase, filterPresenter);
            FilterController filterController = new FilterController(filterUseCaseInteracter);
            filter.chooseFilterOptions(scanner, filterController, filterPresenter, this);

        } else {
            displayMainMenu(loginPresenter);
            this.choseOption(scanner, loginPresenter, loginController,welcomeMenuInterface,registerInterface,
                    logInInterface,showUsersInterface, filter);
        }

    }




}
