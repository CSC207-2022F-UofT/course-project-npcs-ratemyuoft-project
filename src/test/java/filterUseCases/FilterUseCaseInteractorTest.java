package filterUseCases;

import dataBases.courseDataBase.CourseDataAccess;
import entities.Course;
import interfaceAdapters.filterInterfaceAdapters.FilterPresenter;
import org.junit.jupiter.api.Test;
import useCases.filterUseCases.FilterByFOSRequestModel;
import useCases.filterUseCases.FilterByNameRequestModel;
import useCases.filterUseCases.FilterByRatingRequestModel;
import useCases.filterUseCases.FilterUseCaseInteractor;

import static org.junit.jupiter.api.Assertions.*;

public class FilterUseCaseInteractorTest {

    private final FilterPresenter filterPresenter = new FilterPresenter();
    private final CourseDataAccess courseDataAccessInterface = new CourseDataAccess();
    private final FilterUseCaseInteractor filterUseCaseInteractor = new FilterUseCaseInteractor(courseDataAccessInterface, filterPresenter);
    private final Course course1 = new Course("MAT157", "Mathematics");
    private final Course course2 = new Course("CSC108", "Computer Science");

    /**
     * This suite of Java Tests only cover the validator methods.
     * The reason for this is the filter methods return void and also do not modify any database data. But the
     * functionality of the three filter methods are still directly tested in the command line interface every time the
     * program is run and the filter methods are called.
     *
     */

    @Test
    public void ratingValidator() {
        course1.setCourseRating(6);
        assertTrue(filterUseCaseInteractor.ratingValidator(new FilterByRatingRequestModel(6), course1));
        assertFalse(filterUseCaseInteractor.ratingValidator(new FilterByRatingRequestModel(7), course1));
    }


    @Test
    public void FOSValidator() {
        assertTrue(filterUseCaseInteractor.FOSValidator(new FilterByFOSRequestModel("Mathematics"), course1));
        assertFalse(filterUseCaseInteractor.FOSValidator(new FilterByFOSRequestModel("Mathematic"), course1));
    }


    @Test
    public void nameValidator() {
        assertTrue(filterUseCaseInteractor.nameValidator(new FilterByNameRequestModel("CSC108"), course2));
        assertFalse(filterUseCaseInteractor.nameValidator(new FilterByNameRequestModel("MAT137"), course2));
    }


}