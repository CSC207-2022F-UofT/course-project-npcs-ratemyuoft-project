package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class CourseListTest {

    @Test
    public void getCourseList() {
        CourseList courseList = new CourseList();
        Assertions.assertEquals(0, courseList.size());
        courseList.addCourse(new Course("MAT137", "Mathematics"));
        Assertions.assertEquals("MAT137", courseList.getCourseList().get(0).getCourseName());
    }

    @Test
    public void addCourse() {
        CourseList courseList = new CourseList();
        Assertions.assertEquals(0, courseList.size());
        courseList.addCourse(new Course("MAT137", "Mathematics"));
        Assertions.assertEquals("MAT137", courseList.getCourseList().get(0).getCourseName());
    }

    @Test
    public void size(){
        CourseList courseList = new CourseList();
        Assertions.assertEquals(0, courseList.size());
        courseList.addCourse(new Course("MAT223", "Mathematics"));
        Assertions.assertEquals(1, courseList.size());
    }
}