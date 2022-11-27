package filterInterfaceAdapters;

public class FilterFailError extends RuntimeException {
    public FilterFailError(String error) {
        super(error);
    }
}
