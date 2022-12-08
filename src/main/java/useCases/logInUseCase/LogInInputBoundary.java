package useCases.logInUseCase;

import java.io.IOException;


/**
 * LogInInputBoundary is an interface that is used by LogInController(logInInterfaceAdapter) to
 * call needed methods from Interactor(back end) to not create a dependency and follow CA.
 */
public interface LogInInputBoundary {
    /**
     * @throws IOException this exception cannot occur while using the program from the perspective of user.
     * However, it is useful for testing in case something is wrong with database, and we are trying to understand
     * which call provokes it.
     * @throws ClassNotFoundException the purpose of this exception is used for the same purpose as previous.
     */
    void showUsers() throws IOException, ClassNotFoundException;

    /**
     * @param username please refer to "NOTE"
     * @param password  please refer to "NOTE"
     * @param major please refer to "NOTE"
     * @param startYearOfStudy please refer to "NOTE"
     * <p>
     * NOTE: this is the input that is passed from LogInController and that is needs to be passed to LogInInteractor.
     *
     * @throws InvalidInputException this exception is thrown in userRegister.LogInInteractor in case the input
     * don't pass any of the checks.
     *
     * @throws IOException this exception is thrown in userRegister.LogInInteractor in case something is wrong with
     * UserDataBase and method failed to save a new instance of User.
     *
     * @throws ClassNotFoundException used for debugging and testing purposes, cannot occur while using the program
     * casually.
     */
    void userRegister(String username, String password, String major, int startYearOfStudy) throws
            InvalidInputException, IOException, ClassNotFoundException;

    /**
     * @param username please refer to "NOTE"
     * @param password please refer to "NOTE"
     * <p>
     * NOTE: this is the input that is passed from LogInController and that is needs to be passed to LogInInteractor.
     *
     * @throws InvalidInputException this exception is thrown in userLogin in case username or password in incorrect
     * and doesn't pass the checks.
     * @throws IOException this exception is thrown in userLogin.LogInInteractor in case something is wrong with
     * UserDataBase and method failed to update the logInStatus of User and save it to UserDataBase.
     * @throws ClassNotFoundException used for debugging and testing purposes, cannot occur while using the program
     * casually.
     */
    void userLogin(String username, String password) throws InvalidInputException, IOException, ClassNotFoundException;

    /**
     * @param output is an error message or a message that indicates a success of the performed action, and it being
     * passed further: LogInInteractor->LogInOutputBoundary->LogInPresenter->CLI.
     */
    void outputMessage(String output);


    /**
     * @throws IOException this is used for debugging and testing purposes to determine where and what went wrong with
     * the UserDataBase. For example, userLogOut failed to change logInStatus of the user in the DataBase to false.
     */
    void userLogOut() throws IOException;

}
