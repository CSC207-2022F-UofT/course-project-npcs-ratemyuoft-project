package InterfaceAdapter;

import entity.UserList;
import entity.User;
import UseCase.OutputBoundary;

public class Presenter implements OutputBoundary{

    @Override
    public void showUsers() {

    }

    @Override
    public boolean confirmUser(User user1) {
        return false;
    }

    @Override
    public String outputMessage(String s) {
        return s;
    }
}
