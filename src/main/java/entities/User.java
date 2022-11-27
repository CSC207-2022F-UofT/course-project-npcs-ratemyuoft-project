package entities;

import java.io.Serializable;

public class User implements Serializable {
    private final String userName;
    private final String password;

    public final String major;

    public final int startYearOfStudy;




    public static int numberOfusers = 0 ;


    private boolean logInStatus;



    //Constructor
    public User(String username, String password, String major, int startYearOfStudy){
        this.userName = username;
        this.password = password;
        this.startYearOfStudy = startYearOfStudy;
        this.major = major;
        numberOfusers++;
    }





    // Getters




    public String getUserName() {
        return this.userName;
    }


    public String getPassword() {
        return this.password;
    }


    public int getStartYearOfStudy(){
        return this.startYearOfStudy;
    }


    public String getMajor() {
        return this.major;
    }




    //Setters




    public boolean getLogInStatus() {
        return logInStatus;
    }


    public void setLogInStatus(boolean logInStatus) {
        this.logInStatus = logInStatus;
    }


}
