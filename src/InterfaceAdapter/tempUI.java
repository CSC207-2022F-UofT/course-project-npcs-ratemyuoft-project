package InterfaceAdapter;

import Entities.Comment;
import Entities.User;
import UseCase.InputBoundary;
import UseCase.Interactor;
import UseCase.OutputBoundary;

import java.io.IOException;

public class tempUI {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OutputBoundary outputBoundary = new Presenter();
        InputBoundary inputBoundary = new Interactor(outputBoundary,new Comment());
        Controller controller = new Controller(inputBoundary);
        // take input
        User user = new User("username", "password");
        String comment = "blah blah blah";


    }
}
