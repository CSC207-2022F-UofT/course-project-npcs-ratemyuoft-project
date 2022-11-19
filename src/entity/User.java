package entity;
public class User {
    private String userName;
    private String password;

    public static int numberOfusers = 0 ;
    private int userId;

    private boolean logInStatus;



    //Constructor
     public User(String username1, String password1 ){
         this.userName = username1;
         this.password = password1;
         numberOfusers++;
         this.userId = numberOfusers;
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

    public int getUserId(){ return userId;}



    //Setters


    public void setUserName(String newUserName){
        this.userName = newUserName;
    }

    public void setPassword(String newPassword){
        this.password = newPassword;
    }

    @Override
    public boolean equals(Object obj) {
         return this.userName.equals(obj);
    }


    public boolean getLogInStatus() {
        return logInStatus;
    }

    public void setLogInStatus(boolean logInStatus) {
        this.logInStatus = logInStatus;
    }
}
