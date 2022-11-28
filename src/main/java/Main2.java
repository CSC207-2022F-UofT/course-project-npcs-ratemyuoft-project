import filterInterfaceAdapters.DataBase;
import filterInterfaceAdapters.FilterController;
import filterInterfaceAdapters.FilterPresenter;
import filterUseCases.*;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        ((DataBase) dataBase).generateTempCourses2();
//        System.out.println(dataBase.importCourses());
        FilterDAGateway dataBase = new DataBase();
        FilterOutputBoundary filterPresenter = new FilterPresenter();
        FilterInputBoundary filterUseCaseInteracter = new FilterUseCaseInteractor(dataBase, filterPresenter);
        FilterController filterController = new FilterController(filterUseCaseInteracter);
//

        System.out.println(filterController.filterByFOS("Mathematics"));
        System.out.println(filterController.filterByRating(6));
        System.out.println(filterController.filterByName("MAT223"));
    }
}