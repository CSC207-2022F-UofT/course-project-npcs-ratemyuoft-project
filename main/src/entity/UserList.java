package entity;
import java.io.Serializable;
import java.util.*;

public class UserList implements Iterable<User>, Serializable {

    private final List<User> userlist = new ArrayList<>();


    public void addUser(User user){
        userlist.add(user);
    }


    public static class DsFill {
        public final Random generator = new Random();

        public int getRandomInRange(int lowerBound, int higherBound) {
            return lowerBound + generator.nextInt(higherBound - lowerBound + 1);
        }

        public DsFill() {


        }
        public void builder(List<User> users){
                for (int i = 0; i <= 100; i++) {
                    int random = getRandomInRange(1920, 2022);
                    String defaultUsername = "anonimus";
                    String defaultPassword = "Qwerty";
                    if (i <= 20) {
                        User u = new User(defaultUsername + random, defaultPassword + i,
                                "MATH", random);
                        users.add(u);
                    } else if ( i <= 40) {
                        User u = new User(defaultUsername + random, defaultPassword + i,
                                "CS", random);
                        users.add(u);
                    } else if ( i <= 60) {
                        User u = new User(defaultUsername + random, defaultPassword + i,
                                "HUMANITIES", random);
                        users.add(u);
                    } else if ( i <= 80) {
                        User u = new User(defaultUsername + random, defaultPassword + i,
                                "ENVIRONMENTAL SCIENCE", random);
                        users.add(u);
                    }
                    else {
                        User u;
                        u = new User(defaultUsername + random, defaultPassword + i,
                                "NO MAJOR", random);
                        users.add(u);
                    }
                }
        }
    }


    public UserList(){
        DsFill dsFill = new DsFill();
        dsFill.builder(userlist);
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
