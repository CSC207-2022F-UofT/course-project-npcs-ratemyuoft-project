package logInInterfaceAdapter;
import logInUseCase.LogInInputBoundary;
import logInUseCase.LogInInteractor; // this import can't be accessed, only used to initialize input boundary
import logInUseCase.InvalidInputException;


import java.io.IOException;


/**
 * LogInController class is used for communicating with LogInInputBoundary interface . It's a starting point for
 * information that is passed from UI to back end through the interface. That is why it is packaged
 * as logInInterfaceAdapter
 * <p>
 *
 *
 * UPDATE: Now controller doesn't send simple message to LogInInputBoundary->LogInInteractor->
 * LogInOutputBoundary->LogInPresenter->CLI
 * <p>
 *
 * Instead, it Uses MVC Design Pattern, which allows us to avoid all that unneeded passes, and allows to
 * send messages we want to send from Controller like that: ViewModel->Presenter->CLI
 * <p>
 *
 * NOTE: this class is not tested as it passes to calls to 2 other classes:
 * 1.LogInViewModel, where the call is passed to LogInPresenter
 * 2.LogInInputBoundary, which is interface that is implemented by LogInInteractor, then to LogInOutputBoundary,
 * then to LogInPresenter.
 * !!!Please refer to "NOTE" in LogInPresenter
 *
 */
public class LogInController {
    private final LogInInputBoundary logInInputBoundary;
    private final LogInViewModel logInViewModel;

    /**
     * @throws ClassNotFoundException this exception is used to help debug code in case merging won't go as smooth
     *  as it supposed to be.
     *  LogInController is a constructor, in the MileStone 4 it was accepting input from outside and assigning
     *  it to logInInputBoundary and logInViewModel, but I understood that it's unnecessary and for the sake of
     *  simplicity and readability of code, now the instances are created right in the constructor.
     * <p>
     *  NOTE: "this.logInInputBoundary = new LogInInteractor();" doesn't trigger dependency as LogInInteractor
     *  is never accessed any other way except the logInInputBoundary, which is an interface.
     *  This was made to not initialise "LogInInputBoundary = new LogInInteractor();" in the ClI to follow the rules
     *  of CA.
     */
    public LogInController() throws ClassNotFoundException {
        this.logInInputBoundary = new LogInInteractor();
        this.logInViewModel = new LogInViewModel();
    }

    /**
     * Method showUsers in LogInController redirects the call to LogInInputBoundary and in case any exceptions are
     * thrown displays the corresponding messages by redirecting them to LogInViewModel where it gets redirected to
     * LogInPresenter and displayed to CLI.
     */
    public void showUsers() {
        try {
            logInInputBoundary.showUsers();
            logInViewModel.outputFromController("All Users are displayed"+ "\n");
        }catch (IOException | ClassNotFoundException e){
            logInViewModel.outputFromController("Invalid input"+ "\n");

        }
    }

    /**
     * @param username is the input passed from the CLI
     *
     * @param password is the input passed from the CLI
     *
     * @param major is the input passed from the CLI
     *
     * @param startYearOfStudy  is the input passed from the CLI
     *
     * @throws ClassNotFoundException if this exception is thrown by userRegister.LogInInteractor,
     * userRegister.LogInController passes an error message to LogInViewModel and then to LogInPresenter to CLI
     *
     * @throws IOException if this exception is thrown by userRegister.LogInInteractor,
     * userRegister.LogInController passes an error message to LogInViewModel and then to LogInPresenter to CLI
     *
     * @throws InvalidInputException if this exception is thrown by userRegister.LogInInteractor,
     * userRegister.LogInController passes an error message to LogInViewModel and then to LogInPresenter to CLI
     */
    public void userRegister(String username, String password, String major, int startYearOfStudy) throws ClassNotFoundException, IOException, InvalidInputException {
        try{
            logInInputBoundary.userRegister(username,password,major,startYearOfStudy);
            logInViewModel.outputFromController("Registration Successful!"+ "\n");

        }catch(InvalidInputException e){
            logInViewModel.outputFromController("Invalid input"+ "\n");
            throw new InvalidInputException();
        } catch (IOException e) {
            logInViewModel.outputFromController("Invalid input"+ "\n");
            throw new IOException();
        } catch (ClassNotFoundException e) {
            logInViewModel.outputFromController("Invalid input"+ "\n");
            throw new ClassNotFoundException();
        }
    }

    /**
     * @param username same as in userRegister, that is the input passed from CLI
     * @param password same as in userRegister, that is the input passed from CLI
     *
     * @throws ClassNotFoundException in case the exception thrown by corresponding method in LogInInteractor, method
     * userLogin.LogInController catches an exception and passes an error message to LogInViewModel
     *
     * @throws IOException userLogin.LogInController catches an exception and passes an error
     * message to LogInViewModel
     *
     * @throws InvalidInputException userLogin.LogInController catches an exception and passes
     * an error message to LogInViewModel
     */
    public void userLogin(String username, String password) throws ClassNotFoundException, IOException, InvalidInputException {
        try{
            logInInputBoundary.userLogin(username,password);
            logInViewModel.outputFromController("Login Successful!"+ "\n");
        }catch(InvalidInputException e){
            logInViewModel.outputFromController("Invalid input"+ "\n");
            throw new InvalidInputException();
        } catch (IOException e) {
            logInViewModel.outputFromController("Invalid input"+ "\n");
            throw new IOException();
        } catch (ClassNotFoundException e) {
            logInViewModel.outputFromController("Invalid input"+ "\n");
            throw new ClassNotFoundException();
        }
    }

    /**
     * @throws IOException this exception is used for sake of debugging, because it's impossible to have
     * wrong input in this exception. If this exception is thrown it means that something wrong with the UserDataBase
     * or the User instance we try to log out. It is more useful in tests rather than on practice, because when running
     * the project we have interface boundaries that prevent this Exception from being triggered.
     */
    public void userLogOut() throws IOException  {
        logInInputBoundary.userLogOut();


    }



}
