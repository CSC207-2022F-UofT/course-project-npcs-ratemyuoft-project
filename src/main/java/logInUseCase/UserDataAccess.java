package logInUseCase;

import entities.UserList;

import java.io.IOException;

/**
 * DataAccess is an interface to access Database without referring straight to database
 */
public interface UserDataAccess {

    /**
     * @return an instance of UserList that is a copy of the UserList that was serialised to UserDataBase.
     * @throws IOException thrown in case the importation failed (e.g. UserDataBase is empty)
     * @throws ClassNotFoundException used for debugging and testing purposes, cannot occur during casual use.
     */
    UserList importUsers() throws IOException, ClassNotFoundException;

    /**
     * @param userList is an instance of UserList that was modified by LogInInteractor and is now passed to UserDataBase
     * @throws IOException is thrown in case saving to the UserDataBase fails.
     */
    void saveUser(UserList userList) throws IOException;

}
