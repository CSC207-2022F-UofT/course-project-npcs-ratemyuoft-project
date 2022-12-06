package entities;
public class User {
    public String userName;
    public String password;

    public static int numberOfusers = 0;

    //Constructor
     public User(String username1, String password1 ){
         this.userName = username1;
         this.password = password1;
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

    //Setters


    public void setUserName(String newUserName){
        this.userName = newUserName;
    }

    public void setPassword(String newPassword){
        this.password = newPassword;
    }




}
