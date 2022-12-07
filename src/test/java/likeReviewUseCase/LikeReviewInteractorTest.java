package likeReviewUseCase;


import courseDataBase.CourseDataAccess;
import courseDataBase.CourseDataAccessInterface;
import entities.Course;
import entities.CourseList;
import entities.Review;
import likeReviewInterfaceAdapters.LikeReviewPresenter;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class LikeReviewInteractorTest {

    LikeReviewOutputBoundary outputBoundary = new LikeReviewPresenter();
    CourseDataAccessInterface courseDataAccessInterface = new CourseDataAccess();
    LikeReviewInteractor likereview = new LikeReviewInteractor(courseDataAccessInterface, outputBoundary);

    @Test
    void checkIfrightinputworks() throws IOException, ClassNotFoundException {
        // Want likes of Review with this name to have plus one like
        CourseList courselist = courseDataAccessInterface.importCourses();
        int initial = courselist.getCourseList().get(0).getReviews().get(0).getNumberOfLikes();
        ReviewNameRequestModel revname = new ReviewNameRequestModel(courselist.getCourseList().get(0).getReviews().get(0).getReviewID());
        likereview.AddLike(revname);

        CourseList courselist2 = courseDataAccessInterface.importCourses();

        for (Course c: courselist2){
            for (Review r: c.getReviews()){
                System.out.println(r.getNumberOfLikes());
            }
        }

        assertEquals(initial + 1, courselist2.getCourseList().get(9).getReviews().get(0).getNumberOfLikes());


    }

    @Test
    void checkIfwronginputworks() throws IOException, ClassNotFoundException {
        // Check for No Error
        CourseList courselist = courseDataAccessInterface.importCourses();
        ReviewNameRequestModel revname = new ReviewNameRequestModel("Review 20");
        likereview.AddLike(revname);
    }
}
