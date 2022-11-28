package loginUseCase;

import entities.UserList;

import java.io.IOException;

/**
 * DataAccess is an interface to access Database without referring straight to database
 */
public interface LoginDataAccess {

    UserList importUsers() throws IOException, ClassNotFoundException;
    void saveUser(UserList userList) throws IOException;

}
