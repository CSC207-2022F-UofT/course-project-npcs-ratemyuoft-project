package LikeReview;

import DataBase.DataAccess;
import Usecase.Gateway;
import LikeReview.OutputBoundaryL;
import entity.Course;
import entity.CourseList;
import entity.Review;

import java.io.IOException;
import java.util.Objects;


public class LikeReview implements InputBoundaryL{
    public Review review;
    public CourseList courseList;
    public Gateway gateway;
    public OutputBoundaryL output;


    public LikeReview(String ReviewName, Gateway gateway, OutputBoundaryL output){

        this.gateway = gateway;
        this.output = output;

        try{
            this.courseList = this.gateway.importcourselist();
        } catch (IOException | ClassNotFoundException e){
            this.courseList = new CourseList();
        }

        for (Course i: courseList){
            for (Review r: i.GetReviews()){
                if (Objects.equals(r.Name, ReviewName)){
                    r.Like();
                    //this.output.outputMessage("Course Liked");
                    System.out.println(r.Name);
                    System.out.println(r.numberOfLikes);
                }
            }
        }

        if (this.review == null){
            this.output.outputMessage("NO Review With This Name");
        }
    }
    //@Override
    //public void AddLike() throws IOException {
    //    this.review.Like();
    //    this.gateway.SaveCourse(this.courseList);
    //    this.output.outputMessage("Course Liked");
    //    System.out.println(this.review.numberOfLikes);
    //}
}
