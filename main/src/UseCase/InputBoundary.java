package UseCase;

import entity.UserList;

import java.io.IOException;

public interface InputBoundary {
    void showUsers();
    void userRegister(String username, String password, String major, int startYearOfStudy) throws InvalidInputException
            , IOException;
    void userLogin(String username, String password) throws InvalidInputException;
    void outputMessage(String output);



    void userLogOut(String username) throws InvalidInputException;

}
