package courseDataBase;

import dataBases.courseDataBase.CourseDataAccess;
import dataBases.courseDataBase.DataFill;
import entities.Course;
import entities.CourseList;
import entities.Review;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CourseDataAccessTest {

    private final CourseDataAccess courseDataAccess = new CourseDataAccess();
    public DataFill dataFill =new DataFill();

    public void courseDataFill() throws IOException {
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
        Review r1 = new Review(course1, 3, "Good Course");
        Review r2 = new Review(course2, 3, "Good Course");
        Review r3 = new Review(course3, 3, "Good Course");
        Review r4 = new Review(course4, 3, "Good Course");
        Review r5 = new Review(course5, 3, "Good Course");
        Review r6 = new Review(course6, 3, "Good Course");
        Review r7 = new Review(course7, 3, "Good Course");
        Review r8 = new Review(course8, 3, "Good Course");
        Review r9 = new Review(course9,3, "Good Course");
        Review r10 = new Review(course10, 3, "Good Course");

        course1.addReview(r1);
        course2.addReview(r2);
        course3.addReview(r3);
        course4.addReview(r4);
        course5.addReview(r5);
        course6.addReview(r6);
        course7.addReview(r7);
        course8.addReview(r8);
        course9.addReview(r9);
        course10.addReview(r10);


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
        Assertions.assertEquals("STA261", courseDataAccess.importCourses().getCourseList().get(0).getCourseName());
    }

    @Test
    public void importCourses() throws IOException, ClassNotFoundException {
        Assertions.assertEquals("Statistical Science", courseDataAccess.importCourses().getCourseList().get(0).getFieldOfStudy());
    }
}