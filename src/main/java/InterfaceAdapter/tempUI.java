package InterfaceAdapter;

import DataBase.DataAccess;
import Entities.Comment;
import Entities.User;
import UseCase.Gateway;
import UseCase.InputBoundary;
import UseCase.Interactor;
import UseCase.OutputBoundary;

import java.io.IOException;

public class tempUI {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Gateway gateway = new DataAccess();
        OutputBoundary outputBoundary = new Presenter();
        InputBoundary inputBoundary = new Interactor(outputBoundary,gateway);
        Controller controller = new Controller(inputBoundary);
        // take input
        User user = new User("username", "password");
        String comment = "blah blah blah";


    }
}
