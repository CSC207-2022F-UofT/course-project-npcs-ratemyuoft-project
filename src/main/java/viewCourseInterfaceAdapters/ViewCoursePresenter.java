package viewCourseInterfaceAdapters;

import entity.Review;
import viewCourseDataStructures.CourseListResponseModel;
import viewCourseDataStructures.CourseListResponseModelHelp;
import viewCourseDataStructures.ReviewInformation;
import viewCourseReviewUseCase.ViewCourseOutputBoundary;

public class ViewCoursePresenter implements ViewCourseOutputBoundary {
    // Outputs to the UI
    @Override
    public void outputMessage(String s ){
        System.out.println(s);
    }

    @Override
    public void Display(CourseListResponseModel courseListResponseModel){
        // Takes in a Courselistreqeust Model Data type and outputs it to the UI.
        System.out.println("Course: " + courseListResponseModel.getCourseName());

        for (ReviewInformation r: courseListResponseModel.getRevList()){
            System.out.println("");
            System.out.println("Name: " + r.getName());
            System.out.println("Rating: " + r.getRating());
            System.out.println("Comment: " + r.getComment());
            System.out.println("Likes: " + r.getNumberOfLikes());
        }
    }

}
