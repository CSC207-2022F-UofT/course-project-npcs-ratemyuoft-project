package interfaceAdapter;

import useCase.OutputBoundary;
import entities.User;
import entities.UserList;

public class Presenter implements OutputBoundary{


    @Override
    public void showUsers(UserList userList) {
        for (User u: userList){
            outputMessage("||    Username : " + u.getUserName()+ "   " +
            "||    Major : " + u.getMajor() + "   " +
            "||    LogInStatus : " + u.getLogInStatus() + "   " +
            "||    Enrolment year : "+ u.getStartYearOfStudy() + "   " +"\n");
        }

    }


    @Override
    public void outputMessage(String s) {
        System.out.print(s);
    }


}
