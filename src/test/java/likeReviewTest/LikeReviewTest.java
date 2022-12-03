package viewCourseTests;

import courseDatabase.DataAccess;
import entity.CourseList;
import likeReviewInterfaceAdapters.PresenterL;
import likeReviewUseCase.LikeReview;
import likeReviewUseCase.OutputBoundaryL;
import likeReviewUseCase.ReviewNameRequestModel;
import loginUseCase.InvalidInputException;
import org.junit.jupiter.api.Test;
import viewCourseReviewUseCase.Gateway;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class LikeReviewTest {

    OutputBoundaryL outputBoundary = new PresenterL();
    Gateway gateway = new DataAccess();
    LikeReview likereview = new LikeReview(gateway, outputBoundary);

    @Test
    void checkIfrightinputworks() throws IOException, ClassNotFoundException {
        // Want likes of Review with this name to have plus one like
        CourseList courselist = gateway.importcourselist();
        int initial = courselist.Courses.get(0).reviews.get(0).numberOfLikes;
        ReviewNameRequestModel revname = new ReviewNameRequestModel(courselist.Courses.get(0).reviews.get(0).Name);
        likereview.AddLike(revname);
        CourseList courselist2 = gateway.importcourselist();
        assertEquals(courselist2.Courses.get(0).reviews.get(0).numberOfLikes, initial + 1);
    }

    @Test
    void checkIfwronginputworks() throws IOException, ClassNotFoundException {
        // Check for No Error
        CourseList courselist = gateway.importcourselist();
        ReviewNameRequestModel revname = new ReviewNameRequestModel("Review 20");
        likereview.AddLike(revname);
    }
}
