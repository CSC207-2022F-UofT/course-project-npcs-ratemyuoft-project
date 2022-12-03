package viewCourseTests;

import courseDatabase.DataAccess;
import entity.CourseList;
import loginUseCase.InvalidInputException;
import org.junit.jupiter.api.Test;
import viewCourseInterfaceAdapters.Presenter;
import viewCourseReviewUseCase.CourseNameRequestModel;
import viewCourseReviewUseCase.Gateway;
import viewCourseReviewUseCase.OutputBoundary;
import viewCourseReviewUseCase.ViewCourse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class viewCourseTest {

    OutputBoundary outputBoundary = new Presenter();
    Gateway gateway = new DataAccess();
    ViewCourse viewcourse = new ViewCourse(gateway, outputBoundary);

    @Test
    void checkIfrightinputworks() {
        CourseNameRequestModel coursename = new CourseNameRequestModel("Sta257");
        viewcourse.Displayinformation(coursename);
        assertEquals(viewcourse.course.courseName, "Sta257");
    }

    @Test
    void checkIfwronginputworks() {
        CourseNameRequestModel coursename = new CourseNameRequestModel("Sta237");
        viewcourse.Displayinformation(coursename);
        assertNull(viewcourse.course);
    }

}
