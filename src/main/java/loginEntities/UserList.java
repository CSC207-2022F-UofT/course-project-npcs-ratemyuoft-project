package loginEntities;
import java.io.Serializable;
import java.util.*;

/**
 * Class UserList is used purely for storing and accessing Users. Basically, a packaging that will allow us to make
 * our database implementation look clean and simple
 */
public class UserList implements Iterable<User>, Serializable {


    private final List<User> userlist = new ArrayList<>();


    /**
     * addUser is basically an implementation of List.add()
     */
    public void addUser(User user){
        userlist.add(user);
    }


    /**
     *  iterator in this class is needed for the other parts of code that will interact with UserList class
     *  to understand that there is class of type User inside the UserList and that we can iterate through it to
     *  access a needed user
     */
    public Iterator<User> iterator() {
        return new UserIterator();
    }

    /**
     * class UserIterator is an implementation of the call of iterator that was called before
     */
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
