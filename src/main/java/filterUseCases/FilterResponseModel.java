package filterUseCases;

import entities.Course;
import entities.CourseList;

import java.util.ArrayList;
import java.util.List;

public class FilterResponseModel {

    public List<Course> courseList;

    public FilterResponseModel(CourseList courseList){ this.courseList = courseList.getCourselist(); }
}
