package useCase;

import java.io.IOException;


/**
 * InputBoundary is an interface that is used by controller(interfaceAdapter) to call needed methods from
 * Interactor(back end).
 * <p>
 *
 */
public interface InputBoundary {
    void showUsers() throws IOException, ClassNotFoundException;
    void userRegister(String username, String password, String major, int startYearOfStudy) throws
            InvalidInputException, IOException, ClassNotFoundException;
    void userLogin(String username, String password) throws InvalidInputException, IOException, ClassNotFoundException;
    void outputMessage(String output);



    void userLogOut() throws IOException;

}
