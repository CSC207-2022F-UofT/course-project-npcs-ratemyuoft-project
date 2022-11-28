package viewCourseUsecase;

import entities.Review;

import java.util.ArrayList;

public interface ViewCourseInputBoundary {
    ArrayList<Review> getReviews();

    void displayInformation();
}
