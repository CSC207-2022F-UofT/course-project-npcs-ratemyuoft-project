package dataStructures;

/**
 * FilterResponseSubModel is the interface used in FilterResponseModel. This interface is created to mainly eliminate
 * the dependency of FilterResponseModels on (in this case) Quartets. In the future, any other forms of sub models can
 * be the component of FilterResponseModel so long as they implement the FilterResponseSubModel interface.
 * <p>
 *     It outlines the methods specified in Quartet.
 * </p>
 */
public interface FilterResponseSubModel {

    String toString();
}
