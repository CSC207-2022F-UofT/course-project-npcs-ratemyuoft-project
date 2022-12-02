package filterInterfaceAdapters;

import filterUseCases.FilterByFOSRequestModel;
import filterUseCases.FilterByNameRequestModel;
import filterUseCases.FilterByRatingRequestModel;
import filterUseCases.FilterInputBoundary;

public class FilterController {

    /**
     *
     *
     *
     *
     */

    final FilterInputBoundary filterInputBoundary;

    public FilterController(FilterInputBoundary filterInputBoundary) {
        this.filterInputBoundary = filterInputBoundary;
    }

    public void filterByName(String name) {
        try{filterInputBoundary.filterByName(new FilterByNameRequestModel(name));}
        catch(FilterFailException f){System.out.println(f.getMessage());}
    }

    public void filterByFOS(String FOS) {
        try{filterInputBoundary.filterByFOS(new FilterByFOSRequestModel(FOS));}
        catch(FilterFailException f){System.out.println(f.getMessage());}
    }

    public void filterByRating(double rating) {
        try{filterInputBoundary.filterByRating(new FilterByRatingRequestModel(rating));}
        catch(FilterFailException f){System.out.println(f.getMessage());}
    }
}
