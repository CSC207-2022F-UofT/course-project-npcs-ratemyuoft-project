package filterUseCases;
import entities.CourseList;
import entities.Course;

import java.io.IOException;
import java.util.Objects;

public class FilterUseCaseInteractor implements FilterInputBoundary{

    private static CourseList courselist;

    public FilterResponseModel filterResponseModel;

    public FilterUseCaseInteractor(FilterDAGateway gateway) {
        try {
            courselist = gateway.importCourse();
            this.filterResponseModel = new FilterResponseModel();
        } catch (
                IOException | ClassNotFoundException e) {
            courselist = new CourseList();
            this.filterResponseModel = new FilterResponseModel("Importation failed");
        }
    }

    public FilterResponseModel filterByRating(FilterByRatingRequestModel filterByRatingRequestModel){
        CourseList cl = new CourseList();
        for(Course c : courselist) {
            if(c.getCourseRating() >= filterByRatingRequestModel.getRating()) {
                cl.addCourse(c);
            }
        }
        return new FilterResponseModel(cl);
    }

    public FilterResponseModel filterByFOS(FilterByFOSRequestModel filterByFOSRequestModel){
        CourseList cl = new CourseList();
        for(Course c : courselist) {
            if(Objects.equals(c.courseName, filterByFOSRequestModel.getFOS())) {
                cl.addCourse(c);
            }
        }
        return new FilterResponseModel(cl);
    }

    public FilterResponseModel filterByName(FilterByNameRequestModel filterByNameRequestModel){
        CourseList cl = new CourseList();
        for(Course c : courselist) {
            if(Objects.equals(c.courseName, filterByNameRequestModel.getName())) {
                cl.addCourse(c);
            }
        }
        return new FilterResponseModel(cl);
    }
}
