package entity;
public class CommonUser implements User {
    private final String userName;
    private final String password;

    public final String major;

    public final int startYearOfStudy;




    public static int numberOfusers = 0 ;


    private boolean logInStatus;



    //Constructor
     public CommonUser(String username, String password, String major, int startYearOfStudy){
         this.userName = username;
         this.password = password;
         this.startYearOfStudy = startYearOfStudy;
         this.major = major;
         numberOfusers++;
     }





    // Getters



    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public int getStartYearOfStudy(){
        return this.startYearOfStudy;
    }


    @Override
    public String getMajor() {
        return this.major;
    }




    //Setters



    @Override
    public boolean getLogInStatus() {
        return logInStatus;
    }

    @Override
    public void setLogInStatus(boolean logInStatus) {
        this.logInStatus = logInStatus;
    }


}
