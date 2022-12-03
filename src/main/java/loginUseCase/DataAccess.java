package loginUseCase;

import loginEntities.UserList;

import java.io.IOException;

/**
 * DataAccess is an interface to access Database without referring straight to database
 */
public interface DataAccess {

    UserList importUsers() throws IOException, ClassNotFoundException;
    void saveUser(UserList userList) throws IOException;

}
