package viewCourseUsecase;
import filterUseCases.CourseDataAccessInterface;
import entities.Course;
import entities.CourseList;
import entities.Review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ViewCourseInteracter implements ViewCourseInputBoundary{
    private  CourseList courseList;
    private Course course;
    private ArrayList<Review> reviews;
    private ViewCourseOutputBoundary output;
    public ViewCourseInteracter(String coursename, CourseDataAccessInterface gateway, ViewCourseOutputBoundary output){
        try{
            courseList = gateway.importCourses();
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

        this.reviews = this.course.getReviews();
        this.output = output;
    }

    public ArrayList<Review> getReviews(){
        return this.reviews;
    }

    public void displayInformation(){
        this.output.Display(this.reviews, this.course);
    }


}