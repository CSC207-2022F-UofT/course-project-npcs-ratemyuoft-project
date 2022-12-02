package filterUseCases;
import dataStructures.FilterResponseModel;
import dataStructures.FilterResponsesubModel;
import dataStructures.Quartet;
import entities.CourseList;
import entities.Course;
import filterInterfaceAdapters.FilterFailException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FilterUseCaseInteracter implements FilterInputBoundary{

    private CourseList courselist;

    public FilterOutputBoundary filterOutputBoundary;

    public CourseDataAccessInterface gateway;

    public FilterUseCaseInteracter(CourseDataAccessInterface gateway, FilterOutputBoundary filterOutputBoundary) {
        this.filterOutputBoundary = filterOutputBoundary;
        this.gateway = gateway;
        try {
            this.courselist = gateway.importCourses();
        } catch (IOException | ClassNotFoundException e) {
            this.courselist = new CourseList();
            filterOutputBoundary.filterFailView("Importation Failed.");
        }
    }

    public void filterByRating(FilterByRatingRequestModel filterByRatingRequestModel) throws FilterFailException {
        List<Quartet> quartets = new ArrayList<>();
        for(Course course : courselist) {
            if(course.getCourseRating() >= filterByRatingRequestModel.getRating()) {
                quartets.add(new FilterResponsesubModel(course.getCourseName(), course.getFieldOfStudy(), course.getCourseRating(), course.getReviews().size()));
            }
        }
        if (quartets.size() != 0){
            filterOutputBoundary.filterView(new FilterResponseModel(quartets));
        }
        else {
            filterOutputBoundary.filterFailView("No such courses found. Please try another rating.");}
    }

    public void filterByFOS(FilterByFOSRequestModel filterByFOSRequestModel) throws FilterFailException {
        List<Quartet> quartets = new ArrayList<>();
        for(Course course : courselist) {
            if(Objects.equals(course.fieldOfStudy, filterByFOSRequestModel.getFOS())) {
                quartets.add(new FilterResponsesubModel(course.getCourseName(), course.getFieldOfStudy(), course.getCourseRating(), course.getReviews().size()));
            }
        }
        if (quartets.size() != 0){
            filterOutputBoundary.filterView(new FilterResponseModel(quartets));
        }
        else {
            filterOutputBoundary.filterFailView("No such courses found. Please try another field of study.");
        }
    }

    public void filterByName(FilterByNameRequestModel filterByNameRequestModel) throws FilterFailException {
        List<Quartet> quartets = new ArrayList<>();
        for(Course course : courselist) {
            if(Objects.equals(course.courseName, filterByNameRequestModel.getName())) {
                quartets.add(new FilterResponsesubModel(course.getCourseName(), course.getFieldOfStudy(), course.getCourseRating(), course.getReviews().size()));
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
