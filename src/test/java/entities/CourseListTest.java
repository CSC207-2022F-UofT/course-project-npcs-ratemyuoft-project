package entities;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class CourseListTest {

    @Test
    public void getCourseList() {
        CourseList courseList = new CourseList();
        assertTrue(courseList.size() == 0);
        courseList.addCourse(new Course("MAT137", "Mathematics"));
        assertTrue(Objects.equals(courseList.getCourseList().get(0).getCourseName(), "MAT137"));
    }

    @Test
    public void addCourse() {
        CourseList courseList = new CourseList();
        assertTrue(courseList.size() == 0);
        courseList.addCourse(new Course("MAT137", "Mathematics"));
        assertTrue(Objects.equals(courseList.getCourseList().get(0).getCourseName(), "MAT137"));
    }

    @Test
    public void size(){
        CourseList courseList = new CourseList();
        assertTrue(courseList.size() == 0);
        courseList.addCourse(new Course("MAT223", "Mathematics"));
        assertTrue(courseList.size() == 1);
    }
}