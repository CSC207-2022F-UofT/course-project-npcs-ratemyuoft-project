package useCases.logInUseCase;

import entities.UserList;

/**
 * this interface is used to pass the output from LogInInteractor to LogInPresenter, the sole purpose of this interface
 * is to follow Clean Architecture.
 */
public interface LogInOutputBoundary {
    /**
     * @param userList is the latest copy of the UserDataBase that is relevant only before it gets updated again.
     */
    void showUsers(UserList userList);

    /**
     * @param s is an output message from LogInInteractor used to pass message that indicates success of the action
     * that was performed or the message that informs that the exception was thrown.
     */
    void outputMessage(String s);


}
