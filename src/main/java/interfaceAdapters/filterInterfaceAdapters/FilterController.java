package interfaceAdapters.filterInterfaceAdapters;

import useCases.filterUseCases.FilterByFOSRequestModel;
import useCases.filterUseCases.FilterByNameRequestModel;
import useCases.filterUseCases.FilterByRatingRequestModel;
import useCases.filterUseCases.FilterInputBoundary;

/**
 * FilterController class is used for communicating with FilterInputBoundary interface . It's a starting point for
 * information that is passed from UI to back end through the interface. That is why it is packaged as interfaceAdapter
 * <p>
 *
 * FilterController takes in an instance of FilterInputBoundary and performs three different filter actions on it.
 *
 */
public class FilterController {

    /**
     * FilterController class is used for communicating with FilterInputBoundary interface . It's a starting point for
     * information that is passed from UI to back end through the interface. That is why it is packaged as interfaceAdapter
     * <p>
     *
     * FilterController takes in an instance of FilterInputBoundary and performs three different filter actions on it.
     *
     */

    final FilterInputBoundary filterInputBoundary;


    /**
     * Constructor of the class FilterController: Create an instance of FilterController by setting the instance
     * to the given FilterInputBoundary.
     *
     * @param filterInputBoundary an instance that implements the FilterInputBoundary.
     */
    public FilterController(FilterInputBoundary filterInputBoundary) {
        this.filterInputBoundary = filterInputBoundary;
    }

    /**
     * filterByName: Filter the courses by its unique name. Also referred to as direct search.
     * <p>
     * This method first creates an instance of FilterByNameRequestModel and passes the model to the
     * FilterInputBoundary, asking it to perform its use case on with the given FilterByNameRequestModel, which
     * eliminates dependency on the input data.
     *
     * @param name is the String representing the name of the interested course.
     */
    public void filterByName(String name) {
        filterInputBoundary.filterByName(new FilterByNameRequestModel(name));
    }

    /**
     * filterByFOS: Filter the course by its field of studies.
     * <p>
     * This method first creates an instance of FilterByFOSRequestModel and passes the model to the
     * FilterInputBoundary, asking it to perform its use case on with the given FilterByFOSRequestModel, which
     * eliminates dependency on the input data.
     *
     * @param FOS is the String representing the field of study of the interested course.
     */
    public void filterByFOS(String FOS) {
        filterInputBoundary.filterByFOS(new FilterByFOSRequestModel(FOS));
    }

    /**
     * filterByRating: Filter the course by keeping those that are higher than or equal to the given rating.
     * <p>
     * This method first creates an instance of FilterByRatingRequestModel and passes the model to the
     * FilterInputBoundary, asking it to perform its use case on with the given FilterByRatingRequestModel, which
     * eliminates the dependency on the input data.
     *
     * @param rating is the integer representing the rating threshold.
     */
    public void filterByRating(double rating) {
        filterInputBoundary.filterByRating(new FilterByRatingRequestModel(rating));
    }
}
