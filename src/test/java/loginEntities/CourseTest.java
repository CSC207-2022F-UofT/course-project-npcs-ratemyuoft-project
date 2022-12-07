package loginEntities;

import entities.Course;
import entities.Review;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class CourseTest {

    @Test
    public void getCourseName() {
        Course course = new Course("MAT137", "Mathematics");
        assertEquals("MAT137", course.getCourseName());
    }

    @Test
    public void getFieldOfStudy() {
        Course course = new Course("STA261", "Statistical Science");
        assertEquals("Statistical Science", course.getFieldOfStudy());
    }

    @Test
    public void getCourseRating() {
        Course course = new Course("CSC207", "Computer Science");
        course.setCourseRating(7);
        assertEquals(7, course.getCourseRating(), 0.0);
    }


    @Test
    public void getReviews() {
        Course course = new Course("CSC207", "Computer Science");
        Review review = new Review(8, "this course is good.", "review 1");
        course.addReview(review);
        assertEquals(course.getReviews().get(0), review);
    }

    @Test
    public void setCourseName() {
        Course course = new Course("STA257", "Statistical Science");
        course.setCourseName("STA257 Probabilities and Statistics I");
        assertEquals("STA257 Probabilities and Statistics I", course.getCourseName());
    }

    @Test
    public void setCourseRating() {
        Course course = new Course("MAT246", "Mathematics");
        course.setCourseRating(3);
        assertEquals(3, course.getCourseRating(), 0.0);
    }

    @Test
    public void setFieldOfStudy() {
        Course course = new Course("MAT334", "Mathematics");
        course.setFieldOfStudy("Math");
        assertEquals("Math", course.getFieldOfStudy());
    }

    @Test
    public void addReview() {
        Course course = new Course("CSC240", "Computer Science");
        Review review = new Review(8, "this course is hard!", "review 2");
        course.addReview(review);
        assertEquals(course.getReviews().get(0), review);
    }
}