package dataStructures;

import java.util.List;

/**
 * FilterResponseModel is the data structure designed for output data. It contains a list of FilterResponseSubModels, and
 * It is created and used mainly to eliminate the dependency of application output format on user output.
 */
public class FilterResponseModel {

    public List<FilterResponseSubModel> quartets;

    /**
     * Constructs an instance of FilterResponseModel by directly passing in the List of FilterResponseSubModels.
     * @param quartets
     */
    public FilterResponseModel(List<FilterResponseSubModel> quartets){
        this.quartets = quartets;
    }

    /**
     * toString is the special method that specifies the format that the instances of FilterResponseModel class prints out.
     * <p>
     *     It calls the FilterResponseSubModel toString method.
     * </p>
     * This method will be useful when we present information to the CLI using through the FilterOutputBoundary
     * @return the specified String format.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (FilterResponseSubModel q : quartets){
            sb.append("COURSE " + i + ": " + q.toString() + '\n');
            i += 1;
        }
        return sb.toString();
    }
}
