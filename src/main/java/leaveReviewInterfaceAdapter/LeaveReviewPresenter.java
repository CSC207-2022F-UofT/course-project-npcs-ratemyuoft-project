package leaveReviewInterfaceAdapter;
import leaveReviewUseCase.LeaveReviewOutputBoundary;

public class LeaveReviewPresenter implements LeaveReviewOutputBoundary{
    /**
     *
     * @param s
     * this method is used to make the code clean, so that everything that happens in UI communicates only with
     * Presenter and Controller.
     */
    @Override
    public void outputMessage(String s) {
        System.out.print(s);
    }
}
