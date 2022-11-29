package interfaceAdapter;
import useCase.InputBoundary;
import useCase.Interactor; // this import can't be accessed, only used to initialize input boundary
import useCase.InvalidInputException;


import java.io.IOException;


/**
 * Controller class is used for communicating with inputBoundary interface . It's a starting point for information
 * that is passed from UI to back end through the interface. That is why it is packaged as interfaceAdapter
 * <p>
 *
 *
 * I don't think it is obligatory to explain each method here, because the only function of controller is to try
 * to pass a method call to input boundary, and in case Exception is thrown- to catch it and explain what mistake might
 * have happened.
 * <p>
 *
 *
 *
 *
 * UPDATE: Now controller doesn't send simple message to inputBoundary->Interactor->OutputBoundary->Presenter->CLI
 * <p>
 * Instead, it Uses MVC Design Pattern, which allows us to avoid all that unneeded passes, and allows to
 * send messages we want to send from Controller like that: ViewModel->Presenter->CLI
 * <p>
 * I hope I understood it correctly.
 * <p>
 *
 */
public class Controller {
    private final InputBoundary inputBoundary;
    private final ViewModel viewModel;

    public Controller() throws ClassNotFoundException {
        this.inputBoundary = new Interactor();
        this.viewModel = new ViewModel();
    }

    public void showUsers() {
        try {
            inputBoundary.showUsers();
            viewModel.outputFromController("All Users are displayed"+ "\n");
        }catch (IOException | ClassNotFoundException e){
            viewModel.outputFromController("Invalid input"+ "\n");

        }
    }

    public void userRegister(String username, String password, String major, int startYearOfStudy) throws ClassNotFoundException, IOException, InvalidInputException {
        try{
            inputBoundary.userRegister(username,password,major,startYearOfStudy);
            viewModel.outputFromController("Registration Successful!"+ "\n");

        }catch(InvalidInputException e){
            viewModel.outputFromController("Invalid input"+ "\n");
            throw new InvalidInputException();
        } catch (IOException e) {
            viewModel.outputFromController("Invalid input"+ "\n");
            throw new IOException();
        } catch (ClassNotFoundException e) {
            viewModel.outputFromController("Invalid input"+ "\n");
            throw new ClassNotFoundException();
        }
    }

    public void userLogin(String username, String password) throws ClassNotFoundException, IOException, InvalidInputException {
        try{
            inputBoundary.userLogin(username,password);
            viewModel.outputFromController("Login Successful!"+ "\n");
        }catch(InvalidInputException e){
            viewModel.outputFromController("Invalid input"+ "\n");
            throw new InvalidInputException();
        } catch (IOException e) {
            viewModel.outputFromController("Invalid input"+ "\n");
            throw new IOException();
        } catch (ClassNotFoundException e) {
            viewModel.outputFromController("Invalid input"+ "\n");
            throw new ClassNotFoundException();
        }
    }

    public void userLogOut() throws IOException  {
        inputBoundary.userLogOut();
        viewModel.outputFromController("Log out successful!"+ "\n");


    }



}
