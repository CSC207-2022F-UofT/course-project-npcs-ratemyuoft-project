package InterfaceAdapter;

import UseCase.*;
import entity.UserList;
import entity.User;
import DataBase.DataAccess;


import java.io.IOException;

public class tempUI {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OutputBoundary outputBoundary = new Presenter();
        Gateway gateway=new DataAccess();
        InputBoundary inputBoundary = new Interactor(outputBoundary,gateway);
        Controller controller = new Controller(inputBoundary);

        controller.userRegister("kolya","kolya123");
        controller.userRegister("dmaslmdk","asdasdas");
        for(User u: controller.showUsers() ){
            System.out.println(u);
        }
    }
}
