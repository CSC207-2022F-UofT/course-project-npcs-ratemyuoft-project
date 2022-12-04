package viewCourseDataStructures;

import java.util.ArrayList;

public class CourseListResponseModel {

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
