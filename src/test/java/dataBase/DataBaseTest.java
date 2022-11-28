package dataBase;

import useCase.DataAccess;
import entities.User;
import entities.UserList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DataBaseTest {


    UserList users1 = new UserList();
    UserList users2 = new UserList();
    DataAccess dataAccess = new DataBase();

    User u = new User("a","b","major",2020);
    User u1 = new User("r","c","math",2020);
    User u2 = new User("u","d","physics",2020);
    User u3 = new User("o","l","business",2020);



    @Test
    void saveUserTest()  {

        List<User> list1 = new ArrayList<>();
        List<User> list2 = new ArrayList<>();


        users1.addUser(u);
        users1.addUser(u1);
        users1.addUser(u2);
        users1.addUser(u3);

        try {
            dataAccess.saveUser(users1);
            users2 = dataAccess.importUsers();
            for(User u : users1){
                list1.add(u);
            }for(User u : users2){
                list2.add(u);
            }
            boolean everythingMatches = true;
            for(int i =0;i< list1.size();i++){
                if(list1.get(i).getUserName().equals(list2.get(i).getUserName())
                        && list1.get(i).getPassword().equals(list2.get(i).getPassword())
                        && list1.get(i).getMajor().equals(list2.get(i).getMajor())
                        && (list1.get(i).getStartYearOfStudy() == list2.get(i).getStartYearOfStudy())){
                }else{
                    everythingMatches=false;
                }
            }
            assertTrue(everythingMatches,"Users were not saved properly");


        } catch (IOException | ClassNotFoundException e) {
            System.out.println("probem");
        }


    }




    @Test
    void importUsersTest() {

        List<User> list1 = new ArrayList<>();
        List<User> list2 = new ArrayList<>();

        users1.addUser(u);
        users1.addUser(u1);
        users1.addUser(u2);
        users1.addUser(u3);

        try {
            dataAccess.saveUser(users1);
            users2 = dataAccess.importUsers();
            for(User u : users1){
                list1.add(u);
            }for(User u : users2){
                list2.add(u);
            }
            boolean everythingMatches = true;
            for(int i =0;i< list1.size();i++){
                if(list1.get(i).getUserName().equals(list2.get(i).getUserName())
                        && list1.get(i).getPassword().equals(list2.get(i).getPassword())
                        && list1.get(i).getMajor().equals(list2.get(i).getMajor())
                        && (list1.get(i).getStartYearOfStudy() == list2.get(i).getStartYearOfStudy())){
                }else{
                    everythingMatches=false;
                }
            }
            assertTrue(everythingMatches,"Users were not imported properly");


        } catch (IOException | ClassNotFoundException e) {
            System.out.println("probem");
        }



    }


}