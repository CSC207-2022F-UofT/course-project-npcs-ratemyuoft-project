package DataBase;

import java.io.*;

import UseCase.DataAccess;
import entity.UserList;

public class DataBase implements DataAccess {

    private static final String fileName = "userfile.sav";

    @Override
    public UserList importUsers() throws IOException, ClassNotFoundException{
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        UserList newUsers = (UserList) inputStream.readObject();
        return newUsers;

    }

    @Override
    public void saveUser(UserList users) throws IOException, NullPointerException{
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(users);
        outputStream.close();
    }
}
