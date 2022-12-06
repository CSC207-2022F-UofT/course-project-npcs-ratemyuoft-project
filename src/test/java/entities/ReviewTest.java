package entities;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ReviewTest {

    Course c = new Course("MAT137", "Mathematics");
    Review r = new Review(c, 5, "I loved this course!");

    @Test
    void getOptionalCommentTest() {
        assertEquals("I loved this course!", r.getOptionalComment());
    }

    @Test
    void getReviewRatingTest() {
        Assertions.assertEquals(5, r.getRating());
    }

    @Test
    void getNumberOfLikesTest() {
        Assertions.assertEquals(0, r.getNumberOfLikes());
    }

    @Test
    void getNumberOfDislikesTest() {
        Assertions.assertEquals(0, r.getNumberOfDislikes());
    }

    @Test
    void getReviewIDTest() {
        c.addReview(r);
        Assertions.assertEquals("MAT137Review1", r.getReviewID());
    }
}
