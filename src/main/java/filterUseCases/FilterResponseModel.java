package filterUseCases;

import entities.Course;
import entities.CourseList;

public class FilterResponseModel {

    public CourseList courseList;

    public FilterResponseModel(CourseList courseList){ this.courseList = courseList; }

    public String toString(){
        return courseList.toString();
    }

}
