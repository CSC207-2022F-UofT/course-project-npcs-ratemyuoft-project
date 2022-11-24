package entity;
public class User {
    private String userName;
    private String password;

    public String major;

    public int startYearOfStudy;




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

    public static int getNumberOfUsers(){
         return numberOfusers;
    }
    public int getStartYearOfStudy(){
        return this.startYearOfStudy;
    }


    public String getMajor() {
        return this.major;
    }




    //Setters


    public void setUserName(String newUserName){
        this.userName = newUserName;
    }

    public void setPassword(String newPassword){
        this.password = newPassword;
    }




    public boolean getLogInStatus() {
        return logInStatus;
    }

    public void setLogInStatus(boolean logInStatus) {
        this.logInStatus = logInStatus;
    }

    public void setMajor(String newMajor){
        this.major = newMajor;
    }

    public void setStartYearOfStudy(int newYearOfStudy){
        this.startYearOfStudy = newYearOfStudy;
    }

}
