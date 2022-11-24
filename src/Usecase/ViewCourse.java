package Usecase;
import entity.Course;
import entity.CourseList;
import entity.Review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ViewCourse implements InputBoundary{

    private  CourseList courseList;
    private Course course;

    private ArrayList<Review> reviews;

    public ViewCourse(Course course, Gateway gateway){
        this.course = course;

        try{
            courseList = gateway.importcourselist();
        } catch (IOException | ClassNotFoundException e){
            courseList = new CourseList();
        }

        this.reviews = courseList.getReviews(this.course);
    }

    public ArrayList<Review> getReviews(){
        return this.reviews;
    }


}
