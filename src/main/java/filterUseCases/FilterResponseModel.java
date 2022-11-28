package filterUseCases;

import entities.Course;
import entities.CourseList;

import java.util.ArrayList;
import java.util.List;

public class FilterResponseModel {

    public CourseList courseList;

    public FilterResponseModel(CourseList courseList){ this.courseList = courseList; }

    public String toString(){
        return courseList.toString();
    }

}
