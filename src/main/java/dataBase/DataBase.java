package dataBase;

import java.io.*;

import useCase.DataAccess;
import entities.UserList;

/**
 * Database class is an implementation of the DataAccess interface that is located in package useCase
 * <p>
 * Its task is to create .sav file which is used as a database. Update the database and pass the data from it
 * to a UserList.
 */
public class DataBase implements DataAccess {

    private final String fileName = "userFile.sav";


    /**
     * @param users is the UserList that has all the users
     * @throws IOException .
     * @throws NullPointerException
     *
     * both Exceptions are used for debugging and restricting purposes
     * <p>
     *
     * saveUser accepts users and writes it to userFile.sav
     */
    @Override
    public void saveUser(UserList users) throws IOException, NullPointerException{
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(users);
        outputStream.close();
    }

    /**
     * importUsers method:
     *
     * @return UserList consisting of all users that are currently in userFile.sav
     * @throws IOException .
     * @throws ClassNotFoundException
     * both Exceptions are used for debugging and restricting purposes
     */
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

        return (UserList) inputStream.readObject();

    }
}
