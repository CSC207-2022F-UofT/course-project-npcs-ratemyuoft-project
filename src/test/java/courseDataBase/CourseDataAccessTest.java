package courseDataBase;

import entities.Course;
import entities.CourseList;
import filterUseCases.CourseDataAccessInterface;
import org.junit.Test;

import java.io.IOException;
import java.util.Objects;

import static org.junit.Assert.*;

public class CourseDataAccessTest {

    private final CourseDataAccess courseDataAccess = new CourseDataAccess();

    public void courseDataFill() throws IOException, ClassNotFoundException{
        CourseList cl = new CourseList();
        Course course1 = new Course("MAT137", "Mathematics");
        Course course2 = new Course("MAT223", "Mathematics");
        Course course3 = new Course("MAT224", "Mathematics");
        Course course4 = new Course("MAT135", "Mathematics");
        Course course5 = new Course("MAT157", "Mathematics");
        Course course6 = new Course("CSC108", "Computer Science");
        Course course7 = new Course("CSC148", "Computer Science");
        Course course8 = new Course("STA257", "Statistical Science");
        Course course9 = new Course("STA261", "Statistical Science");
        Course course10 = new Course("STA130", "Statistical Science");
        cl.addCourse(course9);
        cl.addCourse(course4);
        cl.addCourse(course2);
        cl.addCourse(course8);
        cl.addCourse(course3);
        cl.addCourse(course6);
        cl.addCourse(course10);
        cl.addCourse(course5);
        cl.addCourse(course1);
        cl.addCourse(course7);
        int i = 0;
        for (Course c : cl) {
            c.setCourseRating(i);
            i += 1;
        }
        courseDataAccess.saveCourse(cl);
    }

    @Test
    public void saveCourseTest() throws IOException, ClassNotFoundException {
        courseDataFill();
        assertTrue(Objects.equals(courseDataAccess.importCourses().getCourseList().get(0).getCourseName(), "STA261"));
    }

    @Test
    public void importCourses() throws IOException, ClassNotFoundException {
        assertTrue(Objects.equals(courseDataAccess.importCourses().getCourseList().get(0).getFieldOfStudy(), "Statistical Science"));
    }
}