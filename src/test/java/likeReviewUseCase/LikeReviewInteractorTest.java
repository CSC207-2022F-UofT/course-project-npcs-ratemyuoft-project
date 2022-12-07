package likeReviewUseCase;


import courseDataBase.CourseDataAccess;
import entities.Course;
import entities.CourseList;
import entities.Review;
import filterUseCases.CourseDataAccessInterface;
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
        int initial = courselist.getCourseList().get(0).reviews.get(0).numberOfLikes;
        ReviewNameRequestModel revname = new ReviewNameRequestModel(courselist.getCourseList().get(0).reviews.get(0).Name);
        likereview.AddLike(revname);

        CourseList courselist2 = courseDataAccessInterface.importCourses();

        for (Course c: courselist2){
            for (Review r: c.reviews){
                System.out.println(r.numberOfLikes);
            }
        }

        assertEquals(initial + 1, courselist2.getCourseList().get(9).reviews.get(0).numberOfLikes);


    }

    @Test
    void checkIfwronginputworks() throws IOException, ClassNotFoundException {
        // Check for No Error
        CourseList courselist = courseDataAccessInterface.importCourses();
        ReviewNameRequestModel revname = new ReviewNameRequestModel("Review 20");
        likereview.AddLike(revname);
    }
}
