package useCase;

import entities.UserList;

public interface OutputBoundary {
    void showUsers(UserList userList);
    void outputMessage(String s);


}
