import filterInterfaceAdapters.DataBase;
import filterInterfaceAdapters.FilterController;
import filterInterfaceAdapters.FilterPresenter;
import filterUseCases.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FilterDAGateway dataBase = new DataBase();
        ((DataBase) dataBase).generateTempCourses2();
//        System.out.println(dataBase.importCourses());

        FilterOutputBoundary filterPresenter = new FilterPresenter();
        FilterInputBoundary filterUseCaseInteracter = new FilterUseCaseInteractor(dataBase, filterPresenter);
        FilterController filterController = new FilterController(filterUseCaseInteracter);
//

        System.out.println(filterController.filterByFOS("Mathematics"));
        System.out.println(filterController.filterByRating(6));
        System.out.println(filterController.filterByName("MAT223"));
    }
}
