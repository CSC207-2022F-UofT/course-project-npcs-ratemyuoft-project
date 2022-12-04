package userDataBase;

import java.io.*;

import logInUseCase.UserDataAccess;
import entities.UserList;

/**
 * UserDatabase class is an implementation of the UserDataAccess interface that is located in package logInUseCase
 * <p>
 * Its task is to create .sav file which is used as a database. Update the database and pass the data from it
 * to a UserList.
 */
public class UserDataBase implements UserDataAccess {

    private final String fileName = "userFile.sav";


    /**
     * @param users is the UserList that has all the users
     * @throws IOException please refer to "NOTE"
     * @throws NullPointerException please refer to "NOTE"
     * <p>
     * NOTE: both Exceptions are used for debugging and restricting purposes
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
     * importUsers method makes an exact copy of the UserList that was saved(serialised to "userFile.sav")
     * and returns it.
     *
     * @return UserList consisting of all users that are currently in userFile.sav
     * @throws IOException please refer to "NOTE"
     * @throws ClassNotFoundException please refer to "NOTE"
     * <p>
     * NOTE: both Exceptions are used for debugging and restricting purposes
     * <p>
     * WARNING: IntelliJ indicates that variable "inputStream" is never used, that happens because when program runs
     * first time database is empty. However, if project already has UserList serialised to "userFile.sav"
     * (registered users) then the try statement reaches it and reads the data from "userFile.sav".
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
