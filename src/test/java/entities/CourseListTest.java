package entities;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class CourseListTest {

    @Test
    public void getCourseList() {
        CourseList courseList = new CourseList();
        assertEquals(0, courseList.size());
        courseList.addCourse(new Course("MAT137", "Mathematics"));
        assertEquals("MAT137", courseList.getCourseList().get(0).getCourseName());
    }

    @Test
    public void addCourse() {
        CourseList courseList = new CourseList();
        assertEquals(0, courseList.size());
        courseList.addCourse(new Course("MAT137", "Mathematics"));
        assertEquals("MAT137", courseList.getCourseList().get(0).getCourseName());
    }

    @Test
    public void size(){
        CourseList courseList = new CourseList();
        assertEquals(0, courseList.size());
        courseList.addCourse(new Course("MAT223", "Mathematics"));
        assertEquals(1, courseList.size());
    }
}