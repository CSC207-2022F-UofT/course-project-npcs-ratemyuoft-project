package viewCourseDataStructures;

import java.util.ArrayList;

public class CourseListResponseModel {
    /**
     * CourseListResponseModel: Output Data for View-Course Use Casse
     * CourseListResponseModel: Takes in a List with ReviewInformation type and String and stores them in locals
     * Getters: returns value in given Local
     */

    public ArrayList<ReviewInformation> reviewlist;
    public String coursename;

    public CourseListResponseModel(ArrayList<ReviewInformation> reviewlist, String coursename){
        this.reviewlist = reviewlist;
        this.coursename = coursename;
    }

    public ArrayList<ReviewInformation> getRevList(){
        return this.reviewlist;
    }

    public String getCourseName(){
        return this.coursename;
    }



}
