package InterfaceAdapter;

import UseCase.OutputBoundary;
import entity.User;
import entity.UserList;

public class Presenter implements OutputBoundary{


    @Override
    public void showUsers(UserList userList) {
        for (User u: userList){
            System.out.print("||    Username : " + u.getUserName()+ "   ");
            System.out.print("||    Major : " + u.getMajor() + "   ");
            System.out.print("||    Major : " + u.getLogInStatus() + "   ");
            System.out.print("||    Enrolment year : "+ u.getStartYearOfStudy() + "   " +"\n");
        }

    }


    @Override
    public void outputMessage(String s) {
        System.out.println(s);
    }


}
