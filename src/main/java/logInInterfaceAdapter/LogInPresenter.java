package loginInterfaceAdapter;

import entities.User;
import entities.UserList;
import loginUseCase.LogInOutputBoundary;


/**
 * LogInPresenter is a last class that data from the back end is going through. It's also the only class that is
 * allowed to display data in the CLI.
 * <p>
 * UPDATE: LogInPresenter class is also used by LogInViewModel class for sake of implementing the MVC design pattern
 * and optimizing the use of recourses when running the project.
 * NOTE: I tried to test methods in LogInPresenter. However, I couldn't find and implement the method that would
 * allow me to read data that is being output by the system. There was only one way, it is by returning boolean,
 * every time we try to output data in the CLI, but that wouldn't ensure that output data is correct. It would
 * be only an indicator that allows us to understand whether the data was output at all, and we can check that
 * just by looking at the CLI.
 */
public class LogInPresenter implements LogInOutputBoundary {


    /**
     * @param userList UserList instance that is being passed is the copy of the UserDataBase that has all the current
     * instances of User inside
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
