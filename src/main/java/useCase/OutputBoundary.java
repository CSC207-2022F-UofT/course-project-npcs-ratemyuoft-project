package useCase;

import entities.UserList;

/**
 * this interface is implemented and used by presenter(interfaceAdapter). In our case is doesn't have a lot \
 * functions, and functions doesn't throw any exceptions, because they are just display functions.
 */
public interface OutputBoundary {
    void showUsers(UserList userList);
    void outputMessage(String s);


}
