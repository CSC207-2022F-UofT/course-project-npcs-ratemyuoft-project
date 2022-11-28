package Usecase;
import entity.Course;
import entity.CourseList;
import entity.Review;

import java.io.IOException;
import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ViewCourse implements InputBoundary{
    private  CourseList courseList;
    private Course course;
    private ArrayList<Review> reviews;
    private OutputBoundary output;
    public ViewCourse(String coursename, Gateway gateway, OutputBoundary output){
        try{
            courseList = gateway.importcourselist();
        } catch (IOException | ClassNotFoundException e){
            courseList = new CourseList();
        }

        for (Course i: courseList){
            if (Objects.equals(i.courseName, coursename)) {
                this.course = i;
                break;
            }
        }

        if (this.course == null){
            this.course = new Course("dfd", "fd");
        }

        this.reviews = this.course.GetReviews();
        this.output = output;
    }

    public ArrayList<Review> getReviews(){
        return this.reviews;
    }

    public void Displayinformation(){
        this.output.Display(this.reviews, this.course);
    }


}
