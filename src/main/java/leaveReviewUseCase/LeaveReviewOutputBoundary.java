package leaveReviewUseCase;

public interface LeaveReviewOutputBoundary {

    /***
     *
     * @param s is an output message from the LeaveReviewInteractor that is used to pass messages that indicates success
     *          of the action performed or the message tht informs that an exception was thrown.
     */
    void outputMessage(String s);
}
