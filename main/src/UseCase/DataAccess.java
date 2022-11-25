package UseCase;

import entity.UserList;

import java.io.IOException;

public interface Gateway {

    UserList importUser() throws IOException, ClassNotFoundException;
    void saveUser(UserList userList) throws IOException;

}
