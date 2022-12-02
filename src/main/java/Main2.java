import filterInterfaceAdapters.FilterFailException;
import filterUseCases.CourseDataAccessInterface;
import courseDataBase.CourseDataAccess;
import filterInterfaceAdapters.FilterController;
import filterInterfaceAdapters.FilterPresenter;
import filterUseCases.*;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        CourseDataAccessInterface dataBase = new CourseDataAccess();
        ((CourseDataAccess) dataBase).generateTempCourses2();
//        System.out.println(dataBase.importCourses());
//        FilterOutputBoundary filterPresenter = new FilterPresenter();
//        FilterInputBoundary filterUseCaseInteracter = new FilterUseCaseInteracter(dataBase, filterPresenter);
//        FilterController filterController = new FilterController(filterUseCaseInteracter);
////
//
//        filterController.filterByFOS("Mathematics");
//        filterController.filterByRating(6);
//        filterController.filterByName("MAT223");
//        FilterFailException f = new FilterFailException("fffff");
//        System.out.println(f.getMessage());
    }
}