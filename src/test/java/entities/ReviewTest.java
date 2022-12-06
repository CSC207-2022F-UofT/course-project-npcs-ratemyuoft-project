package entities;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ReviewTest {

    Course c = new Course("MAT137", "Mathematics");
    Review r = new Review(c, 5, "I loved this course!");
    Review r2 = new Review(c, 4, "I really enjoyed taking this course");

    /**
     * This method test that the optional comment of the review is correctly added to the review.
     */
    @Test
    void getOptionalCommentTest() {
        Assertions.assertEquals("I loved this course!", r.getOptionalComment());
    }

    /**
     * This test checks that the reviewRating of the review is correctly made when a review is created.
     */
    @Test
    void getReviewRatingTest() {
        Assertions.assertEquals(5, r.getRating());
    }

    /**
     * This test checks that the NumberOFLikes of the review is correctly instantiated to 0 when a review is first
     * created.
     */
    @Test
    void getNumberOfLikesTest() {
        Assertions.assertEquals(0, r.getNumberOfLikes());
    }

    /**
     * This test checks that the NumberOFDislikes of the review is correctly instantiated to 0 when a review is first
     * created.
     */
    @Test
    void getNumberOfDislikesTest() {
        Assertions.assertEquals(0, r.getNumberOfDislikes());
    }

    /**
     * This test checks that the reviewID of the review is correctly created when a review is added to a course.
     */
    @Test
    void getReviewIDTest() {
        c.addReview(r);
        Assertions.assertEquals("MAT137Review1", r.getReviewID());
        c.addReview(r2);
        Assertions.assertEquals("MAT137Review2", r2.getReviewID());

    }
}
