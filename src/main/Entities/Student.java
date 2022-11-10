package Entities;

public class Student {

    String displayName;
    String userName;
    String Password;
    String logStatus;

    public Student(String displayName, String userName, String Password, String logStatus){
        this.displayName = displayName;
        this.userName = userName;
        this.Password = Password;
        this.logStatus = logStatus;
    }

    public leaveReview(int ID, int Rating, Student Name, String Comment, Course Coursei){
        Review studentReview = Review(ID, Rating, Name, Comment, Coursei);
    }
}

