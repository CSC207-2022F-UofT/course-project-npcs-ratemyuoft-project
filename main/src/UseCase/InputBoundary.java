package UseCase;

import entity.User;
import entity.UserList;

import java.io.IOException;

public interface InputBoundary {
    void showUsers() throws IOException, ClassNotFoundException;
    void userRegister(String username, String password, String major, int startYearOfStudy) throws
            InvalidInputException, IOException, ClassNotFoundException;
    void userLogin(String username, String password) throws InvalidInputException, IOException, ClassNotFoundException;
    void outputMessage(String output);



    void userLogOut() throws IOException,InvalidInputException;

}
