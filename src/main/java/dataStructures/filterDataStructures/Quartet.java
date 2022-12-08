package dataStructures.filterDataStructures;

/**
 * Quartet is the data structure that implements the FilterResponseSubModel Interface.
 * <p>
 *     It is basically a Java type safe list with types String, String, double, and rating accordingly.
 * </p>
 */
public class Quartet implements FilterResponseSubModel {
    public String courseName;

    public String fieldOfStudy;

    public double rating;

    public int numReviews;

    /**
     * Constructor of Quartet class, instantiates a Quartet instance by directly passing in the instance variable.
     * @param courseName passes in as the instance variable courseName
     * @param fieldOfStudy passes in as the instance variable fieldOfStudy
     * @param rating passes in as the instance variable rating
     * @param numReviews passes in as the instance variable numReviews.
     */
    public Quartet(String courseName, String fieldOfStudy, double rating, int numReviews) {
        this.courseName = courseName;
        this.fieldOfStudy = fieldOfStudy;
        this.rating = rating;
        this.numReviews = numReviews;
    }

    /**
     * toString is the special method that specifies the format that the instances of Quartet class prints out.
     * @return the specified String format.
     */
    public String toString(){
        return "Name: " + courseName + ", Field of Studies: " + fieldOfStudy + ", Rating: " + rating +
                ", Number of Reviews: " + numReviews;
    }
}
