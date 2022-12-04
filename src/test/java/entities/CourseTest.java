package entities;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class CourseTest {

    @Test
    public void getCourseName() {
        Course course = new Course("MAT137", "Mathematics");
        assertTrue(Objects.equals(course.getCourseName(), "MAT137"));
    }

    @Test
    public void getFieldOfStudy() {
        Course course = new Course("STA261", "Statistical Science");
        assertTrue(Objects.equals(course.getFieldOfStudy(), "Statistical Science"));
    }

    @Test
    public void getCourseRating() {
        Course course = new Course("CSC207", "Computer Science");
        course.setCourseRating(7);
        assertTrue(course.getCourseRating() == 7);
    }


    @Test
    public void getReviews() {
        Course course = new Course("CSC207", "Computer Science");
        Review review = new Review(8, "this course is good.", "review 1");
        course.addReview(review);
        assertTrue(Objects.equals(course.getReviews().get(0), review));
    }

    @Test
    public void setCourseName() {
        Course course = new Course("STA257", "Statistical Science");
        course.setCourseName("STA257 Probabilities and Statistics I");
        assertTrue(Objects.equals(course.getCourseName(), "STA257 Probabilities and Statistics I"));
    }

    @Test
    public void setCourseRating() {
        Course course = new Course("MAT246", "Mathematics");
        course.setCourseRating(3);
        assertTrue(course.getCourseRating() == 3);
    }

    @Test
    public void setFieldOfStudy() {
        Course course = new Course("MAT334", "Mathematics");
        course.setFieldOfStudy("Math");
        assertTrue(Objects.equals(course.getFieldOfStudy(), "Math"));
    }

    @Test
    public void addReview() {
        Course course = new Course("CSC240", "Computer Science");
        Review review = new Review(8, "this course is hard!", "review 2");
        course.addReview(review);
        assertTrue(Objects.equals(course.getReviews().get(0), review));
    }
}