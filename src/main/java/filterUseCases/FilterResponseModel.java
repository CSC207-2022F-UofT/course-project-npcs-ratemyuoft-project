package filterUseCases;

import entities.Course;
import entities.CourseList;

import java.util.ArrayList;
import java.util.List;

public class FilterResponseModel {

    public List<Course> courseList;

    public String message;

    public FilterResponseModel(CourseList courseList){ this.courseList = courseList.getCourselist(); }

    public FilterResponseModel(String message){
        this.message = message;
    }

    public FilterResponseModel(){
        this.courseList = new ArrayList<>();
        this.message = null;
    }
}
