package viewCourseInterfaceAdapters;

import entity.Review;
import viewCourseReviewUseCase.CourseListRequestModel;

public class Presenter implements viewCourseReviewUseCase.OutputBoundary {

    @Override
    public void outputMessage(String s ){
        System.out.println(s);
    }

    @Override

    public void Display(CourseListRequestModel courselistreq){
        System.out.println("Course: " + courselistreq.getCourse());

        for (Review r: courselistreq.getReviewlist()){
            System.out.println("");
            System.out.println("Name: " + r.Name);
            System.out.println("Rating: " + r.Rating);
            System.out.println("Comment: " + r.Comment);
            System.out.println("Likes: " + r.numberOfLikes);
        }
    }

}
