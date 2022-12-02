package filterInterfaceAdapters;

public class FilterFailException extends RuntimeException {
    public FilterFailException(String error) {
        super(error);
    }
}
