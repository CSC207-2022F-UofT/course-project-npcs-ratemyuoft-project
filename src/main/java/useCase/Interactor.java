package useCase;

import dataBase.DataBase; // the import can not be used directly. it is used only through DataAccess interface
import entities.User;
import entities.UserList;
import interfaceAdapter.Presenter; //  can not be used directly. only through outputBoundary

import java.io.IOException;

/**
 * Interactor is basically a heart of the project, it's the only class that can interact with entities.
 * <p>
 * UI->Controller->InputBoundary->Interactor->OutputBoundary->Presenter->UI
 * <p>
 * It does all the work and passes is to OutputBoundary.
 */
public class Interactor implements InputBoundary {
    private final OutputBoundary outputBoundary;
    public static UserList users;
    private final DataAccess dataAccess;


    /**
     * @throws ClassNotFoundException is used for debugging in case something wrong with database
     * <p>
     *
     *  The most important task of the constructor in that case is importing users from database, and in case something
     *  goes wrong(Exception thrown) it just creates a new Userlist and indicates that the importation from the
     *  DataBase failed.
     */
    public Interactor() throws ClassNotFoundException{
        this.outputBoundary = new Presenter();
        this.dataAccess = new DataBase();
        try{
            users = dataAccess.importUsers();
        }catch (IOException e){
            users = new UserList();
            this.outputBoundary.outputMessage("Importation Failed"+ "\n");
        }

    }
//Methods: checkInput, checkIfUserExists, checkUserStatus, checkPassword are helper functions for the @override
  //  functions. The indicated above functions will never be called outside Interactor.

    /**
     * @param s is Any input passed to Intercator
     * @return true if input is following the criteria
     */
    private boolean checkInput(String s) {
        int count = s.length();
        return count <= 40 && count > 0;
    }

    /**
     * @param username of the User we want to register or logIn
     * @return true if user is in database, false if  not
     */
    public boolean checkIfUserExists(String username){
        for(User user: users){
            if(user.getUserName().equals(username)){
                return true;
            }
        }
        return false;
    }

    /**
     * @param username used to search the user in the database
     * @return user logInStatus.
     */
    public boolean checkUserStatus(String username){
        for(User user: users){
            if(user.getUserName().equals(username)){
                return user.getLogInStatus();
            }
        }
        return true;
    }

    /**
     * @param username is used to search for a user in the database
     * @param password is a password we need to verify
     * @return trues if @param password matches the password under the User with @param username
     */
    public boolean checkPassword(String username, String password){
        for (User u: users){
            if(u.getUserName().equals(username)){
                if(u.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @throws ClassNotFoundException
     *
     * Both Exceptions are used for debugging purposes. If they are being thrown it means something went wrong with
     * importation.
     *
     * After importation the data is being passed to outputBoundary.
     *
     */
    @Override
    public void showUsers() throws IOException, ClassNotFoundException {
        users = dataAccess.importUsers();
        this.outputBoundary.showUsers(users);

    }


    /**
     * @param username username passed from UI
     * @param password password passed from UI
     * @throws InvalidInputException thrown in case username or password doesn't pass checks with helper functions.
     * @throws IOException thrown in case updating user status in the dataBase failed.
     * @throws ClassNotFoundException thrown in case something went wrong with importation of the database
     * <p>
     * userLogin searches for a User with the passed username and changes the logInStatus of the user to true.
     * in case input is correct and passwords match. Otherwise, InvalidInputException  is being thrown.
     *
     *
     */
     @Override
    public void userLogin(String username, String password) throws InvalidInputException, IOException, ClassNotFoundException {
        users = dataAccess.importUsers();
        if(checkInput(username)&& checkInput(password) && checkIfUserExists(username)&& !checkUserStatus(username) &&
                checkPassword(username,password)){
            try{
                for(User user: users){
                    if(user.getUserName().equals(username)){
                        user.setLogInStatus(true);
                    }
                }
                dataAccess.saveUser(users);

            }catch(IOException e){
                this.outputBoundary.outputMessage("Log in failed"+ "\n");
            }
        }else{
            throw new InvalidInputException();
        }
     }

    /**
     * @param startYearOfStudy
     * The following parameters are needed to create a new instance of User (i.e. call User constructor)
     * <p>
     *
     * @throws InvalidInputException is thrown in case any of the passed parameters to the function
     * do not pass the checks.
     * <p>
     *
     * userRegister, checks all the inputs using helper functions above, then creates the new instance of User
     * sets it's logInStatus to true and adds it to database. IOException is thrown in case the process of updating the
     * database went wrong.
     * <p>
     *
     * if username that is passed already assigned to one of the User instances in the database
     * "User with this username already exists" is shown to let user know that they need to try another username
     *
     */
    @Override

    public void userRegister(String username, String password, String major, int startYearOfStudy) throws
            InvalidInputException {
        if (checkInput(username) && checkInput(major) && startYearOfStudy >= 1980 && startYearOfStudy <= 2022
                && checkInput(password) && !checkIfUserExists(username)) {
            User user1 = new User(username, password, major, startYearOfStudy);
            user1.setLogInStatus(true);
            users.addUser(user1);
            try {
                dataAccess.saveUser(users);
            } catch (IOException e) {
                this.outputBoundary.outputMessage("Registration failed"+ "\n");
            }

        } else if (checkIfUserExists(username)) {
            outputBoundary.outputMessage("User with this username already exists"+ "\n");
            throw new InvalidInputException();


        } else {
            throw new InvalidInputException();
        }
    }


    /**
     * @throws IOException is thrown in case something went wrong with updating the database.
     * and displays "Log out failed"
     *
     * userLogOut changes userLogInStatus of currently logged-in user to false and updates the database.
     */
    @Override
    public void userLogOut() throws IOException {

        try{
            for(User user: users){
                if(user.getLogInStatus()){
                    user.setLogInStatus(false);
                }
            }
            dataAccess.saveUser(users);

        }catch(IOException e){
            this.outputBoundary.outputMessage("Log out failed"+ "\n");
        }


    }


    /**
     * @param message is being passed further to outputBoundary with no modifications
     */
    @Override
    public void outputMessage(String message){
        this.outputBoundary.outputMessage(message);
    }

}













