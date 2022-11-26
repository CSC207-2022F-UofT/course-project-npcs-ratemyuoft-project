package DataBase;

import java.io.*;

import UseCase.DataAccess;
import entity.UserList;
import entity.User;

public class DataBase implements DataAccess {

    private static final String fileName = "userfile.sav";



    @Override
    public void saveUser(UserList users) throws IOException, NullPointerException{
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(users);
        outputStream.close();

    }

    @Override
    public UserList importUsers() throws IOException, ClassNotFoundException{
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
        }catch (EOFException e){
            UserList newUL = new UserList();
            this.saveUser(newUL);
        }
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        if (br.readLine() == null) {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
            outputStream.writeObject(new UserList());
        }

        UserList newUsers = (UserList) inputStream.readObject();
        return newUsers;

    }
}
