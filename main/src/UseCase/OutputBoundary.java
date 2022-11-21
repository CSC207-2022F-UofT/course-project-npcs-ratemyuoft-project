package UseCase;

import entity.User;

public interface OutputBoundary {
    void showUsers();
    boolean confirmUser(User user1);
    String outputMessage(String s);
}
