package UseCase;

import entity.User;
import entity.UserList;

public interface OutputBoundary {
    void showUsers(UserList userList);
    void outputMessage(String s);
}
