package viewCourseTests;

import courseDataBase.CourseDataAccess;
import courseDataBase.CourseDataAccessInterface;
import org.junit.jupiter.api.Test;
import viewCourseInterfaceAdapters.ViewCoursePresenter;
import viewCourseDataStructures.CourseNameRequestModel;
import viewCourseReviewUseCase.ViewCourseOutputBoundary;
import viewCourseReviewUseCase.ViewCourseInteractor;

import static org.junit.jupiter.api.Assertions.*;

public class viewCourseTest {

    ViewCourseOutputBoundary viewCourseOutputBoundary = new ViewCoursePresenter();
    CourseDataAccessInterface courseDataAccessInterface = new CourseDataAccess();
    ViewCourseInteractor viewcourse = new ViewCourseInteractor(courseDataAccessInterface, viewCourseOutputBoundary);

    @Test
    void checkIfrightinputworks() throws ClassNotFoundException {
        CourseNameRequestModel coursename = new CourseNameRequestModel("MAT137");
        viewcourse.Displayinformation(coursename);
        assertEquals(viewcourse.course.getCourseName(), "MAT137");
    }

    @Test
    void checkIfwronginputworks() throws ClassNotFoundException {
        CourseNameRequestModel coursename = new CourseNameRequestModel("Sta237");
        viewcourse.Displayinformation(coursename);
        assertNull(viewcourse.course);
    }

}
