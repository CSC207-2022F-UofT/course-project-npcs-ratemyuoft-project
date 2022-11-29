package interfaceAdapter;

import useCase.OutputBoundary;
import entities.User;
import entities.UserList;


/**
 * I would describe Presenter class as a brother of Controller class. As I indicated in the explanation of what
 * Controller class does, it is the starting point for data from UI to pass to back end. Accordingly, Presenter class
 * is the last point for data from back end to be passed and displayed in UI.
 * <p>
 *
 *
 * As I said before. Presenter class can't be tested because it's basically two methods that use System.out.print
 * statements.
 * <p>
 *
 * UPDATE: Presenter class is also used by ViewModel class for sake of implementing the MVC design pattern
 * and optimizing the use of recourses when running the project.
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
