package interfaceAdapters.filterInterfaceAdapters;

/**
 * this is an exception exclusive to filter exceptions, and it contains the message explaining what went wrong
 */
public class FilterFailException extends RuntimeException {
    /**
     * This is basically the super's constructor
     * @param error is the message explaining the error/exception.
     */
    public FilterFailException(String error) {
        super(error);
    }
}
