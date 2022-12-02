package dataStructures;


public class FilterResponsesubModel implements Quartet{
    public String coursename;

    public String fieldOfStudy;

    public double rating;

    public int numReviews;

    public FilterResponsesubModel(String coursename, String fieldOfStudy, double rating, int numReviews) {
        this.coursename = coursename;
        this.fieldOfStudy = fieldOfStudy;
        this.rating = rating;
        this.numReviews = numReviews;
    }

    public String toString(){
        return "Name: " + coursename + ", Field of Studies: " + fieldOfStudy + ", Rating: " + rating +
                ", Number of Reviews: " + numReviews;
    }
}
