package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CourseTest {
    Course c = new Course("STA130", "Statistics");
    Review r = new Review(c,3, "The course was just alright");

    Review r2 = new Review(c, 5, "I loved this course!");

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


