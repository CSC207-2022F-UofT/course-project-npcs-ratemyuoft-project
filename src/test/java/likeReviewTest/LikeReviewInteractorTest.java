package likeReviewTest;

import courseDatabase.CourseDataAccessShawn;
import entities.CourseList;
import likeReviewInterfaceAdapters.LikeReviewPresenter;
import likeReviewUseCase.LikeReviewInteractor;
import likeReviewUseCase.LikeReviewOutputBoundary;
import likeReviewUseCase.ReviewNameRequestModel;
import org.junit.jupiter.api.Test;
import viewCourseReviewUseCase.CourseDataAccessInterface;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class LikeReviewInteractorTest {

    LikeReviewOutputBoundary outputBoundary = new LikeReviewPresenter();
    CourseDataAccessInterface courseDataAccessInterface = new CourseDataAccessShawn();
    LikeReviewInteractor likereview = new LikeReviewInteractor(courseDataAccessInterface, outputBoundary);

    @Test
    void checkIfrightinputworks() throws IOException, ClassNotFoundException {
        // Want likes of Review with this name to have plus one like
        CourseList courselist = courseDataAccessInterface.importcourselist();
        int initial = courselist.Courses.get(0).reviews.get(0).numberOfLikes;
        ReviewNameRequestModel revname = new ReviewNameRequestModel(courselist.Courses.get(0).reviews.get(0).Name);
        likereview.AddLike(revname);
        CourseList courselist2 = courseDataAccessInterface.importcourselist();
        assertEquals(courselist2.Courses.get(0).reviews.get(0).numberOfLikes, initial + 1);
    }

    @Test
    void checkIfwronginputworks() throws IOException, ClassNotFoundException {
        // Check for No Error
        CourseList courselist = courseDataAccessInterface.importcourselist();
        ReviewNameRequestModel revname = new ReviewNameRequestModel("Review 20");
        likereview.AddLike(revname);
    }
}
