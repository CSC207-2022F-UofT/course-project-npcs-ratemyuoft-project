package filterUseCases;
import entities.CourseList;
import entities.Course;

import java.io.IOException;
import java.util.Objects;

public class FilterUseCaseInteractor implements FilterInputBoundary{

    private CourseList courselist;

    public FilterOutputBoundary presenter;

    public FilterDAGateway gateway;

    public FilterUseCaseInteractor(FilterDAGateway gateway, FilterOutputBoundary filterOutputBoundary) {
        this.presenter = filterOutputBoundary;
        this.gateway = gateway;
    }

    public void importCourse(){
        try {
            this.courselist = gateway.importCourses();
        } catch (
                IOException | ClassNotFoundException e) {
            this.courselist = new CourseList();
            presenter.filterFailView("Importation Failed.");
        }
    }

    public FilterResponseModel filterByRating(FilterByRatingRequestModel filterByRatingRequestModel){
        this.importCourse();
        CourseList cl = new CourseList();
        for(Course c : courselist) {
            if(c.getCourseRating() >= filterByRatingRequestModel.getRating()) {
                cl.addCourse(c);
            }
        }
        return presenter.filterSuccessView(cl);
    }

    public FilterResponseModel filterByFOS(FilterByFOSRequestModel filterByFOSRequestModel){
        this.importCourse();
        CourseList cl = new CourseList();
        for(Course c : courselist) {
            if(Objects.equals(c.fieldOfStudy, filterByFOSRequestModel.getFOS())) {
                cl.addCourse(c);
            }
        }
        return presenter.filterSuccessView(cl);
    }

    public FilterResponseModel filterByName(FilterByNameRequestModel filterByNameRequestModel){
        this.importCourse();
        CourseList cl = new CourseList();
        for(Course c : courselist) {
            if(Objects.equals(c.courseName, filterByNameRequestModel.getName())) {
                cl.addCourse(c);
            }
        }
        return presenter.filterSuccessView(cl);
    }
}
