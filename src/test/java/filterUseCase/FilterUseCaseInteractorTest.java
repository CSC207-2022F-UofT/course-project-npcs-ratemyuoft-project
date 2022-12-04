package filterUseCase;

import courseDataBase.CourseDataAccess;
import entities.Course;
import filterInterfaceAdapters.FilterPresenter;
import filterUseCases.CourseDataAccessInterface;
import filterUseCases.FilterByNameRequestModel;
import filterUseCases.FilterByRatingRequestModel;
import filterUseCases.FilterUseCaseInteractor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.logging.Filter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilterUseCaseInteractorTest {

    FilterUseCaseInteractor filterUseCaseInteractor;

    {
        CourseDataAccess courseDataAccess = new CourseDataAccess();
        try {
            courseDataAccess.generateTempCourses2();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FilterPresenter filterPresenter = new FilterPresenter();
        filterUseCaseInteractor = new FilterUseCaseInteractor(courseDataAccess, filterPresenter);
    }

    @Test
    void ratingValidatorTest(){
        Course course1 = new Course("MAT137", "Mathematics");
        course1.setCourseRating(9);
        Assertions.assertTrue(filterUseCaseInteractor.ratingValidator(new FilterByRatingRequestModel(7), course1));
    }

}
