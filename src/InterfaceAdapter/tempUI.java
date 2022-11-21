package InterfaceAdapter;

import UseCase.*;
import entity.UserList;
import entity.User;


import java.io.IOException;

public class tempUI {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OutputBoundary outputBoundary = new Presenter();
        InputBoundary inputBoundary = new Interactor(outputBoundary,new User());
        Controller controller = new Controller(inputBoundary);

        controller.userRegister("kolya","kolya123");

    }
}
