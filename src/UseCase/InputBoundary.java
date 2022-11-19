package UseCase;

import entity.UserList;

public interface InputBoundary {
    UserList showUsers();
    void userRegister(String username, String password) throws InvalidInputException,UserAlreadyExistsException;
    void userLogin(String username, String password) throws InvalidInputException;
    void outputMessage(String output);

    void editPassword(int userId,String username) throws InvalidInputException, NoUserWithSuchIDException ;
    void editUsername(int userId,String password) throws InvalidInputException, NoUserWithSuchIDException;
}
