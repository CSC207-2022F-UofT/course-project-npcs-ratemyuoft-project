package DataStructures;

/**
 * I don't really need this because I don't have enough data for data clump, but to show clean architecture I made it.
 */
public class InPutData {
    private final String comments;


    public InPutData(String comments) {
        this.comments = comments;
    }

    /**
     * @return a string
     * getter
     */
    public String getComments() {
        return this.comments;
    }

}
