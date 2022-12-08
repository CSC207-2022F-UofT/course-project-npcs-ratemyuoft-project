package dataStructures.viewCourseDataStructures;

public class ReviewInformation {
    /**
     * ReviewInformation: Data Structure for the Courselist Response Model
     * ReviewInformation: Takes in name, rating, comment, number of likes and stores them in local variables
     * Getters: Returns the given local variable
     */
    private final String name;
    private final int rating;
    private final String comment;
    private final int numberOfLikes;

    public ReviewInformation(String name, int rating, String comment, int numberOfLikes){
        this.name = name;
        this.rating = rating;
        this.comment = comment;
        this.numberOfLikes = numberOfLikes;
    }

    public String getName(){
        return this.name;
    }

    public int getRating(){
        return this.rating;
    }

    public String getComment(){
        return this.comment;
    }

    public int getNumberOfLikes(){
        return this.numberOfLikes;
    }

}
