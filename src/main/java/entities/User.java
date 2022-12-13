package entities;

import java.io.Serializable;

/**
 * Class User represents single user of the program
 * <p>
 *
 */
public class User implements Serializable {

    private final String userName;
    private final String password;

    public final String major;

    public final int startYearOfStudy;


    /**
     *  this parameter is left in case features that may be added further will need it
     */
    public static int numberUsers = 0 ;


    private boolean logInStatus;


    /**
     * @param username is needed to Log In or
     *                 perform any other action with User
     *
     * @param password in needed to verify the user when Logging in
     *                 because userName is available to all Users which
     *                 might be abused
     *
     * @param major represents User's field of study. So that when seeing
     *              their review others can tell that they are competent
     *
     * @param startYearOfStudy is needed for other users to understand
     *                        whether on is current student, or already graduated
     *
     *
     */
    //Constructor
    public User(String username, String password, String major, int startYearOfStudy){
        this.userName = username;
        this.password = password;
        this.startYearOfStudy = startYearOfStudy;
        this.major = major;
        numberUsers++;
    }


    /** NOTE:
     *  Methods: getUserName,getPassword,getStartYearOfStudy,getMajor
     *  are getters that are meant to be used inside the program, to access data of particular user.
     *  They return:  Username, password, startYearOfStudy and major respectively
     */
    public String getUserName() {
        return this.userName;
    }


    /**
     * @return please refer to the "NOTE" above
     */
    public String getPassword() {
        return this.password;
    }


    /**
     * @return please refer to the "NOTE" above
     */
    public int getStartYearOfStudy(){
        return this.startYearOfStudy;
    }


    /**
     * @return please refer to the "NOTE" above
     */
    public String getMajor() {
        return this.major;
    }


    /**
     * @return as input restriction for userRegister and userLogIn methods in Interactor
     */
    public boolean getLogInStatus() {
        return logInStatus;
    }


    /**
     * @param logInStatus can be set either true or false. For example, when user is registered or logging in
     *                    it is being changed to true. And when user logs out, it is change to false
     */
    public void setLogInStatus(boolean logInStatus) {
        this.logInStatus = logInStatus;
    }


}