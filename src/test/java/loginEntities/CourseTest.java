package loginEntities;

import entities.Course;
import entities.Review;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class CourseTest {

    Course c = new Course("STA130", "Statistics");
    Review r = new Review(c,3, "The course was just alright");

    Review r2 = new Review(c, 5, "I loved this course!");

    /**
     * This test checks that the course name is updated properly.
     */

    @Test
    public void getCourseName() {
        Course course = new Course("MAT137", "Mathematics");
        Assertions.assertEquals("MAT137", course.getCourseName());
    }

    /**
     * This test checks that the course's field of study is updated properly.
     */

    @Test
    public void getFieldOfStudy() {
        Course course = new Course("STA261", "Statistical Science");
        Assertions.assertEquals("Statistical Science", course.getFieldOfStudy());
    }

    /**
     * This test checks that the setCourseName method works as it should.
     */

    @Test
    public void setCourseName() {
        Course course = new Course("STA257", "Statistical Science");
        course.setCourseName("STA257 Probabilities and Statistics I");
        Assertions.assertEquals("STA257 Probabilities and Statistics I", course.getCourseName());
    }

    /**
     * This test checks that the setCourseRating method correctly updates the rating of the course.
     */

    @Test
    public void setCourseRating() {
        Course course = new Course("MAT246", "Mathematics");
        course.setCourseRating(3);
        Assertions.assertEquals(3, course.getCourseRating(), 0.0);
    }

    /**
     * This test checks that the setFieldOfStudy method correctly updates the field of study of the course.
     */


    @Test
    public void setFieldOfStudy() {
        Course course = new Course("MAT334", "Mathematics");
        course.setFieldOfStudy("Math");
        Assertions.assertEquals("Math", course.getFieldOfStudy());
    }

    /**
     * This test checks that the addReview method correctly updates the reviewList of the course.
     */


    @Test
    public void addReview() {
        Course course = new Course("CSC240", "Computer Science");
        Review review = new Review(course, 2, "This course was hard");
        course.addReview(review);
        Assertions.assertEquals(course.getReviews().get(0), review);
    }

    /**
     * This test checks that the reviewList of the course is correctly updated when a review is added to the course.
     */

    @Test
    void reviewListTest() {
        Assertions.assertEquals(0, c.getReviews().size());
        c.addReview(r);
        Assertions.assertEquals(1, c.getReviews().size());

    }

    /**
     * This test checks that the review count of the course being reviewed is correctly updated when a review is added
     * to it.
     */

    @Test
    void reviewCountTest() {
        Assertions.assertEquals(0, c.getReviewCount());
        c.addReview(r);
        Assertions.assertEquals(1, c.getReviewCount());
    }

    /**
     * This test checks that the ratingCount of the course is correctly updated when a review is added to course.
     */

    @Test
    void ratingCountTest()  {
        Assertions.assertEquals(0, c.getRatingCount());
        c.addReview(r);
        Assertions.assertEquals(3, c.getRatingCount());
        c.addReview(r2);
        Assertions.assertEquals(8, c.getRatingCount());
    }

    /**
     * This test checks that the courseRating of the course is correctly updated when a review is added to the course.
     */
    @Test
    void courseRatingTest() {
        Assertions.assertEquals(0, c.getCourseRating());
        c.addReview(r);
        Assertions.assertEquals(3, c.getCourseRating());
        c.addReview(r2);
        Assertions.assertEquals(4, c.getCourseRating());
    }

}
