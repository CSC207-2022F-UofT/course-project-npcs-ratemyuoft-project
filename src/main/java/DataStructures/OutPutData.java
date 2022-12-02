package DataStructures;

import java.util.ArrayList;

public class OutPutData {

    /**
     * I don't really need this because I don't have enough data for data clump, but to show clean architecture I made it.
     */
    private final ArrayList<String> listOfcomments;
    public OutPutData(ArrayList<String> listOfcomments) {
        this.listOfcomments = listOfcomments;
    }

    /**
     * @return ArrayList<String>
     * getter method
     */
    public ArrayList<String> getComments() {
        return this.listOfcomments;
    }

}

