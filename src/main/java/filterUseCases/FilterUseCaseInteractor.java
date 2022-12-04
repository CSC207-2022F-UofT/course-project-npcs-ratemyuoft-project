package filterUseCases;
import dataStructures.FilterResponseModel;
import dataStructures.Quartet;
import dataStructures.FilterResponseSubModel;
import entities.CourseList;
import entities.Course;
import filterInterfaceAdapters.FilterFailException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * FilterUseCaseInteractor implements the FilterInputBoundary interface. It specifies the methods outlines the FilterInputBoundary.
 * <p>
 * It has a courseList instance as a private variable and takes in a FilterOutputBoundary and a CourseDataAccessInterface
 * as its assistants.
 * </p>
 *
 */
public class FilterUseCaseInteractor implements FilterInputBoundary{

    private CourseList courselist;

    public FilterOutputBoundary filterOutputBoundary;

    public CourseDataAccessInterface gateway;

    /**
     * Constructor of a FilterUseCaseInteractor.
     * @param gateway the gateway needed for data access. Usually created before the instantiation of interactor.
     * @param filterOutputBoundary the interface needed for correctly outputting data
     */
    public FilterUseCaseInteractor(CourseDataAccessInterface gateway, FilterOutputBoundary filterOutputBoundary) {
        this.filterOutputBoundary = filterOutputBoundary;
        this.gateway = gateway;
        try {
            this.courselist = gateway.importCourses();
        } catch (IOException | ClassNotFoundException e) {
            this.courselist = new CourseList();
            filterOutputBoundary.filterFailView("Importation Failed.");
        }
    }

    /**
     * ratingValidator is the helper methods needed to help validating the right courses that satisfies the criteria of
     * filter.
     * @param filterByRatingRequestModel the request model specifying the desired filter by rating criteria that was created to
     *                                   pass input data correctly and cleanly into the interactor method.
     * @param course the course of comparison
     * @return true if and only if the course rating is higher than the threshold information contained in the request model
     */
    public Boolean ratingValidator(FilterByRatingRequestModel filterByRatingRequestModel, Course course) {
        return filterByRatingRequestModel.getRating() <= course.getCourseRating();
    }

    /**
     * filterByRating filters the course using the given rating information passed in through the filterByRatingRequestModel.
     * It will only filter successfully if there are at least one subject course in the course database that satisfies the
     * filter criteria. Otherwise, it throws a FilterFailException.
     *
     * <p>
     *     It calls the helper method ratingValidator.
     * </p>
     * @param filterByRatingRequestModel contains the filters by rating threshold information
     * @throws FilterFailException throws the exception if filter fails
     */
    public void filterByRating(FilterByRatingRequestModel filterByRatingRequestModel) throws FilterFailException {
        List<FilterResponseSubModel> quartets = new ArrayList<>();
        for(Course course : courselist) {
            if(ratingValidator(filterByRatingRequestModel, course)) {
                quartets.add(new Quartet(course.getCourseName(), course.getFieldOfStudy(), course.getCourseRating(), course.getReviews().size()));
            }
        }
        if (quartets.size() != 0){
            filterOutputBoundary.filterView(new FilterResponseModel(quartets));
        }
        else {
            filterOutputBoundary.filterFailView("No such courses found. Please try another rating.");}
    }

    /**
     * ratingValidator is the helper methods needed to help validating the right courses that satisfies the criteria of
     * filter.
     * @param filterByFOSRequestModel the request model specifying the desired filter by field of studies criteria that was created to
     *                                   pass input data correctly and cleanly into the interactor method.
     * @param course the course of comparison
     * @return true if and only if the course FOS is equal to the field of studies information contained in the request model
     */
    public Boolean FOSValidator(FilterByFOSRequestModel filterByFOSRequestModel, Course course){
        return Objects.equals(filterByFOSRequestModel.getFOS(), course.getFieldOfStudy());
    }

    /**
     * filterByFOS filters the course using the given field of studies information passed in through the filterByFOSRequestModel.
     * It will only filter successfully if there are at least one subject course in the course database that satisfies the
     * filter criteria. Otherwise, it throws a FilterFailException.
     *
     * <p>
     *     It calls the helper method FOSValidator.
     * </p>
     * @param filterByFOSRequestModel contains the filters by field of studies information
     * @throws FilterFailException throws the exception if filter fails
     */
    public void filterByFOS(FilterByFOSRequestModel filterByFOSRequestModel) throws FilterFailException {
        List<FilterResponseSubModel> quartets = new ArrayList<>();
        for(Course course : courselist) {
            if(FOSValidator(filterByFOSRequestModel, course)) {
                quartets.add(new Quartet(course.getCourseName(), course.getFieldOfStudy(), course.getCourseRating(), course.getReviews().size()));
            }
        }
        if (quartets.size() != 0){
            filterOutputBoundary.filterView(new FilterResponseModel(quartets));
        }
        else {
            filterOutputBoundary.filterFailView("No such courses found. Please try another field of study.");
        }
    }

    /**
     * ratingValidator is the helper methods needed to help validating the right courses that satisfies the criteria of
     * filter.
     * @param filterByNameRequestModel the request model specifying the desired filter by name criteria that was created to
     *                                   pass input data correctly and cleanly into the interactor method.
     * @param course the course of comparison
     * @return true if and only if the course name is equal to the name information contained in the request model
     */
    public Boolean nameValidator(FilterByNameRequestModel filterByNameRequestModel, Course course){
        return Objects.equals(filterByNameRequestModel.getName(), course.getCourseName());
    }

    /**
     * filterByFOS filters the course using the given name information passed in through the filterByNameRequestModel.
     * It will only filter successfully if there are at least one subject course in the course database that satisfies the
     * filter criteria. Otherwise, it throws a FilterFailException.
     *
     * <p>
     *     It calls the helper method nameValidator.
     * </p>
     * @param filterByNameRequestModel contains the filters by name information
     * @throws FilterFailException throws the exception if filter fails
     */
    public void filterByName(FilterByNameRequestModel filterByNameRequestModel) throws FilterFailException {
        List<FilterResponseSubModel> quartets = new ArrayList<>();
        for(Course course : courselist) {
            if(nameValidator(filterByNameRequestModel, course)) {
                quartets.add(new Quartet(course.getCourseName(), course.getFieldOfStudy(), course.getCourseRating(), course.getReviews().size()));
            }
        }
        if (quartets.size() != 0){
            filterOutputBoundary.filterView(new FilterResponseModel(quartets));
        }
        else {
            filterOutputBoundary.filterFailView("No such courses found. Please try another name.");
        }
    }
}
