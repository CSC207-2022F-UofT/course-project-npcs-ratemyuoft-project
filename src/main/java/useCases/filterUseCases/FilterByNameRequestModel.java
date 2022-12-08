package useCases.filterUseCases;

/**
 * FilterByNameRequestModel is one of the three request models. It stores the name information.
 *
 * <p>
 *
 * When filterByName is called by a filter controller, a FilterByNameRequestModel is constructed and passed into the
 * FilterInputBoundary as a parameter of filterByName method. This eliminates the dependency on the user input and makes
 * the use case clean and SOLID.
 */
public class FilterByNameRequestModel {

    final private String name;

    public FilterByNameRequestModel(String name){ this.name = name; }

    public String getName(){ return this.name; }


}
