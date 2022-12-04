package likeReviewUseCase;

import entity.Course;
import entity.CourseList;
import entity.Review;
import viewCourseReviewUseCase.CourseDataAccessInterface;

import java.io.IOException;
import java.util.Objects;


public class LikeReviewInteractor implements LikeReviewInputBoundary {
    // implements the Input Boundary, takes in a Gateway and OutputBoundary
    public CourseList courseList;
    public CourseDataAccessInterface courseDataAccessInterfaceView;
    public LikeReviewOutputBoundary output;

    public Review rev;

    public int iter;
    public Course cs;

    public LikeReviewInteractor(CourseDataAccessInterface courseDataAccessInterfaceView, LikeReviewOutputBoundary output) {

        this.courseDataAccessInterfaceView = courseDataAccessInterfaceView;
        this.output = output;

        try {
            this.courseList = this.courseDataAccessInterfaceView.importcourselist();
            System.out.println("Good");
        } catch (IOException | ClassNotFoundException e) {
            this.courseList = new CourseList();
        }

    }
    @Override
    public void AddLike (ReviewNameRequestModel revname) throws IOException, ClassNotFoundException {
        // Takes in Review Name model, finds the review in the courselist if it exists, adds a like, and gives outputmessage
        String reviewname = revname.getReviewName();
        Boolean liked = Boolean.FALSE;
        for (Course i : this.courseList) {
            int iterator = -1;
            for (Review r : i.GetReviews()) {
                iterator += 1;
                if (Objects.equals(r.Name, reviewname)) {
                    cs = i;
                    iter = iterator;
                    liked = Boolean.TRUE;
                    this.rev = r;
                    break;
                }
            }
        }

        if (this.rev != null){
            cs.reviews.get(iter).Like();
            this.courseDataAccessInterfaceView.SaveCourse(this.courseList);
        }

        if (liked == Boolean.TRUE){
            this.output.outputMessage(new LikeMessageResponseModel(reviewname));
        }
        else{
            this.output.outputMessage(new LikeMessageResponseModel("No Review With this Name"));
        }

    }
}
