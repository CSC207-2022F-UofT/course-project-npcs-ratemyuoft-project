package entity;

public interface User {
    static int getNumberOfUsers() {
        return CommonUser.numberOfusers;
    }

    String getUserName();

    String getPassword();

    int getStartYearOfStudy();

    String getMajor();

    boolean getLogInStatus();

    void setLogInStatus(boolean logInStatus);
}
