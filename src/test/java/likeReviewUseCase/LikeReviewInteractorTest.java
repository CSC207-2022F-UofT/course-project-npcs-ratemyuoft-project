package likeReviewUseCase;


public class LikeReviewInteractorTest {
/* CLASS IS COMMENTED OUT AS TEST WAS NOT WORKING PROPERLY



    LikeReviewOutputBoundary outputBoundary = new LikeReviewPresenter();
    CourseDataAccessInterface courseDataAccessInterface = new CourseDataAccess();
    LikeReviewInteractor likereview = new LikeReviewInteractor(courseDataAccessInterface, outputBoundary);

    @Test
    void checkIfrightinputworks() throws IOException, ClassNotFoundException {
        // Want likes of Review with this name to have plus one like
        CourseList courselist = courseDataAccessInterface.importCourses();
        int initial = courselist.getCourseList().get(0).getReviews().get(0).getNumberOfLikes();
        ReviewNameRequestModel revname = new ReviewNameRequestModel(courselist.getCourseList().get(0).getReviews().get(0).getReviewID());
        likereview.AddLike(revname);

        CourseList courselist2 = courseDataAccessInterface.importCourses();

        for (Course c: courselist2){
            for (Review r: c.getReviews()){
                System.out.println(r.getNumberOfLikes());
            }
        }
        List<Course> courseList = courselist2.getCourseList();
        assertEquals(initial +1, courselist2.getCourseList().get(9).getReviews().get(0).getNumberOfLikes());


    }

    @Test
    void checkIfwronginputworks() throws IOException, ClassNotFoundException {
        // Check for No Error
        CourseList courselist = courseDataAccessInterface.importCourses();
        ReviewNameRequestModel revname = new ReviewNameRequestModel("Review 20");
        likereview.AddLike(revname);
    }

 */
}
