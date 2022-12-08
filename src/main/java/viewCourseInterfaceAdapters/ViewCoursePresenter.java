package viewCourseInterfaceAdapters;

import viewCourseDataStructures.CourseListResponseModel;
import viewCourseDataStructures.ReviewInformation;
import viewCourseReviewUseCase.ViewCourseOutputBoundary;

public class ViewCoursePresenter implements ViewCourseOutputBoundary {
    /**
     * ViewCoursePresenter: Presenter for View Course,
     * outputMessage: Takes in a String and Prints it to the UI.
     * Display: Takes in a CourseListResponse Model, Prints Course Name, and Iterates through a list
     * of Review Information to Print to UI.
     */
    @Override
    public void outputMessage(String s ){
        System.out.println(s);
    }

    @Override
    public void Display(CourseListResponseModel courseListResponseModel){
        System.out.println("Course: " + courseListResponseModel.getCourseName());

        for (ReviewInformation r: courseListResponseModel.getRevList()){
            System.out.println("");
            System.out.println("Name: " + r.getName());
            System.out.println("Rating: " + r.getRating());
            System.out.println("Comment: " + r.getComment());
            System.out.println("Likes: " + r.getNumberOfLikes()+ "\n");

        }
    }

}
