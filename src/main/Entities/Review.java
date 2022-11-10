package Entities;

public class Review {
    int ID;
    int Rating;
    Student Name;
    String Comment;
    Course Coursei;

    public void Review(int ID, int Rating, Student Name, String Comment, Course Coursei) {
        this.ID = ID;
        this.Rating = Rating;
        this.Name = Name;
        this.Comment = Comment;
        this.Coursei = Coursei;
        CourseDatabase.AddReview(Coursei, this);


    }
}

