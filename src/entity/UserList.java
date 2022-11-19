package entity;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class UserList implements Iterable<User>{

    private List<User> userlist = new ArrayList<>();

    public void addUser(User user){
        userlist.add(user);
    }




    @Override
    public Iterator<User> iterator() {
        return new UserIterator();
    }

    private class UserIterator implements Iterator<User>{
        private int curr;

        @Override
        public boolean hasNext(){
            return curr < userlist.size();
        }

        @Override
        public User next() {
            if(hasNext()){
                userlist.get(curr++);
            }
            throw new NoSuchElementException();
        }

    }
}
