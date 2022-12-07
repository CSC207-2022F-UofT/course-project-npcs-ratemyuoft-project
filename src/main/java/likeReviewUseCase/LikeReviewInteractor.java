package likeReviewUseCase;

import courseDataBase.CourseDataAccessInterface;
import entities.Course;
import entities.CourseList;
import entities.Review;

import java.io.IOException;
import java.util.Objects;


public class LikeReviewInteractor implements LikeReviewInputBoundary {
    /**
     * LikeReviewInteractor: Interactor for Like Review Use Case
     * LikeReviewInteractor: Takes in CourseDataAccessInterface and OutputBoundary and creates a courselist with it
     * AddLike: Takes in a Reviewname InputData, Looks for it in the CourseList, If found adds a like, and save the
     * Courselist back onto the Database, and outputs that the review has been liked
     * If not found, sends an outputmessage that nothing was found.
     */
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
            this.courseList = this.courseDataAccessInterfaceView.importCourses();
            System.out.println("Good");
        } catch (IOException | ClassNotFoundException e) {
            this.courseList = new CourseList();
        }

    }
    @Override
    public void AddLike(ReviewNameRequestModel revname) throws IOException {
        String reviewname = revname.getReviewName();
        Boolean liked = Boolean.FALSE;
        for (Course i : this.courseList) {
            int iterator = -1;
            for (Review r : i.getReviews()) {
                iterator += 1;
                if (Objects.equals(r.getReviewID(), reviewname)) {
                    cs = i;
                    iter = iterator;
                    liked = Boolean.TRUE;
                    this.rev = r;
                    break;
                }
            }
        }

        if (this.rev != null){
            cs.getReviews().get(iter).Like();
            this.courseDataAccessInterfaceView.saveCourse(this.courseList);
        }

        if (liked == Boolean.TRUE){
            this.output.outputMessage(new LikeMessageResponseModel(reviewname));
        }
        else{
            this.output.outputMessage(new LikeMessageResponseModel("No Review With this Name"));
        }

    }
}
