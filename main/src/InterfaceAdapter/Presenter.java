package InterfaceAdapter;

import UseCase.OutputBoundary;
import entity.User;
import entity.UserList;

public class Presenter implements OutputBoundary{


    @Override
    public void showUsers(UserList userList) {
        for (User u: userList){
            System.out.print(u.getUserName());
            System.out.print(u.getMajor());
            System.out.print(u.getStartYearOfStudy() + "\n");
        }

    }


    @Override
    public void outputMessage(String s) {
        System.out.print(s);
    }
}
