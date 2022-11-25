package UseCase;

import entity.UserList;

import java.io.IOException;

public interface DataAccess {

    UserList importUsers() throws IOException, ClassNotFoundException;
    void saveUser(UserList userList) throws IOException;

}
