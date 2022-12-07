package loginEntities;

import entities.User;
import entities.UserList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    UserList users = new UserList();
    User u = new User("a","b","major",2020);
    User u1 = new User("r","c","math",2020);
    User u2 = new User("u","d","physics",2020);
    User u3 = new User("o","l","business",2020);


    @Test
    void addUserTest() {
        users.addUser(u);
        users.addUser(u1);
        users.addUser(u2);
        users.addUser(u3);

        User[] user = {u,u1,u2,u3};

        assertIterableEquals(Arrays.asList(user),users, "Userlist doesn't add users properly");





    }

}