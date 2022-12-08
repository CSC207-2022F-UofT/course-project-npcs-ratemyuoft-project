package useCases.filterUseCases;

/**
 * FilterByFOSRequestModel is one of the three request models. It stores the field of studies information.
 *
 * <p>
 *
 * When filterByFOS is called by a filter controller, a FilterByFOSRequestModel is constructed and passed into the
 * FilterInputBoundary as a parameter of filterByFOS method. This eliminates the dependency on the user input and makes
 * the use case clean and SOLID.
 */

public class FilterByFOSRequestModel {

    final private String FOS;

    public FilterByFOSRequestModel(String FOS){ this.FOS = FOS; }

    // Getter
    public String getFOS(){ return this.FOS; }


}
