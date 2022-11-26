package entity;
import java.io.Serializable;
import java.util.*;

public class UserList implements Iterable<User>, Serializable {

    private List<User> userlist = new ArrayList<>();


    public void addUser(User user){
        userlist.add(user);
    }





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
                return userlist.get(curr++);
            }
            throw new NoSuchElementException();
        }

    }
}
