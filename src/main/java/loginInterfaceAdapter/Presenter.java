package loginInterfaceAdapter;

import loginUseCase.OutputBoundary;
import loginEntities.User;
import loginEntities.UserList;


/**
 * I would describe Presenter class as a brother of Controller class. As I indicated in the explanation of what
 * Controller class does, it is the starting point for data from UI to pass to back end. Accordingly, Presenter class
 * is the last point for data from back end to be passed and displayed in UI.
 */
public class Presenter implements OutputBoundary{


    /**
     * @param userList
     *
     * Uses method outputMessage to printout All the users and their information to UI.
     */
    @Override
    public void showUsers(UserList userList) {
        for (User u: userList){
            outputMessage("||    Username : " + u.getUserName()+ "   " +
            "||    Major : " + u.getMajor() + "   " +
            "||    LogInStatus : " + u.getLogInStatus() + "   " +
            "||    Enrolment year : "+ u.getStartYearOfStudy() + "   " +"\n");
        }

    }


    /**
     * @param s
     *
     * this method is used to make the code clean, so that everything that happens in UI communicates only with
     * Presenter and Controller and not have a bunch of messy System.out.print() everywhere
     *
     */
    @Override
    public void outputMessage(String s) {
        System.out.print(s);
    }


}
