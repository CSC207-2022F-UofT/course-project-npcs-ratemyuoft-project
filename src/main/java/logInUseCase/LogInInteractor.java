package logInUseCase;

import logInInterfaceAdapter.LogInPresenter; // the import can not be used directly. it is used only through DataAccess interface
import entities.User;
import entities.UserList;//  can not be used directly. only through outputBoundary
import userDataBase.UserDataBase;


import java.io.IOException;

/**
 * LogInInteractor is the only class that can access and modify entities. It does all the work when methods from the
 * LogInInputBoundary are being called by LogInController. The only interface that has access to methods from
 * LogInInteractor class is LogInInputBoundary.
 * <p>
 * CLI->LogInController->LogInInputBoundary->LogInInteractor->LogInOutputBoundary->LogInPresenter->CLI
 * <p>
 * It does all the work and passes is to OutputBoundary.(e.g. registering the user, logging in, logging out etc.)
 * <p>
 * NOTE: methods showUsers and outputMessage are not tested as the calls are passed to LogInOutputBoundary and then
 * LogInPresenter, and methods in LogInPresenter are tested.
 * <p>
 * NOTE 2.0:
 * - users is an instance of UserList which is used as local variable, to import and save users to a
 * UserDataBase through UserDataAccess interface.
 * - logInOutputBoundary is an interface that is used to send the results to LogInPresenter.
 * - userDataAccess is an interface that is used to interact with UserDatabase.
 */
public class LogInInteractor implements LogInInputBoundary {

    public static UserList users;
    private final LogInOutputBoundary logInOutputBoundary;
    private final UserDataAccess userDataAccess;


    /**
     * @throws ClassNotFoundException is used for debugging in case something wrong with database
     * <p>
     *
     *  The most important task of the constructor in that case is importing users from database, and in case something
     *  goes wrong(Exception thrown) it just creates a new UserList and indicates that the importation from the
     *  DataBase failed.
     * <p>
     *  NOTE: LogInPresenter and UserDatabase can never be accessed directly from LogInInteractor. There is only one
     *  call that calls the constructor of those classes and assigns them to LogInOutPutBoundary and UserDataAccess,
     *  which are interfaces.
     */
    public LogInInteractor() throws ClassNotFoundException{
        this.logInOutputBoundary = (LogInOutputBoundary) new LogInPresenter();
        this.userDataAccess = (UserDataAccess) new UserDataBase();
        try{
            users = userDataAccess.importUsers();
        }catch (IOException e){ //This exception should be thrown when program starts first time
            // as UserDataBase is empty, therefore we can't import any data.
            users = new UserList();
            this.logInOutputBoundary.outputMessage("Importation Failed as UserDataBase is empty"+ "\n");
        }

    }
//Methods: checkInput, checkIfUserExists, checkUserStatus, checkPassword are helper functions for the @override
  //  functions. The indicated above functions will never be called outside Interactor.

    /**
     * @param s is Any input passed to LogInInteractor
     * @return true if input is following the criteria
     *
     * this method checks whether the passed String is > 0 characters long and if it less than 40 characters long
     */
    private boolean checkInput(String s) {
        int count = s.length();
        return count <= 40 && count > 0;
    }

    /**
     * @param username of the User we want to register or logIn
     * @return true if user is in database, false if not
     *
     * this method checks if username passed is already assigned to one of the Users in users
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
     * @param username used to search the user in users
     * @return user logInStatus.
     *
     * this method checks whether User is logged in.
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
     * @param passedUsername is used to search for a user in the database
     * @param password is a password we need to verify
     * @return true if password matches the password assigned to a User with username passedUsername.
     */
    public boolean checkPassword(String passedUsername, String password){
        for (User u: users){
            if(u.getUserName().equals(passedUsername)){
                if(u.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @throws ClassNotFoundException please refer to "NOTE"
     * @throws IOException
     *
     * NOTE:Both Exceptions are used for debugging purposes. If they are being thrown it means something
     * went wrong with importation.
     *
     * After importation the data is being passed to outputBoundary.
     *
     */
    @Override
    public void showUsers() throws IOException, ClassNotFoundException {
        users = userDataAccess.importUsers();
        this.logInOutputBoundary.showUsers(users);

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
        users = userDataAccess.importUsers();
        if(checkInput(username)&& checkInput(password) && checkIfUserExists(username)&& !checkUserStatus(username) &&
                checkPassword(username,password)){
            try{
                for(User user: users){
                    if(user.getUserName().equals(username)){
                        user.setLogInStatus(true);
                    }
                }
                userDataAccess.saveUser(users);

            }catch(IOException e){
                this.logInOutputBoundary.outputMessage("Log in failed"+ "\n");
            }
        }else{
            throw new InvalidInputException();
        }
     }

    /**
     * @param username please refer to "NOTE"
     * @param password please refer to "NOTE"
     * @param major please refer to "NOTE"
     * @param startYearOfStudy please refer to "NOTE"
     * <p>
     * NOTE: The following parameters are needed to create a new instance of User (i.e. call User constructor)
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
                userDataAccess.saveUser(users);
            } catch (IOException e) {
                this.logInOutputBoundary.outputMessage("Registration failed"+ "\n");
            }

        } else if (checkIfUserExists(username)) {
            logInOutputBoundary.outputMessage("User with this username already exists"+ "\n");
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
            userDataAccess.saveUser(users);

        }catch(IOException e){
            this.logInOutputBoundary.outputMessage("Log out failed"+ "\n");
        }


    }


    /**
     * @param message is being passed further to outputBoundary with no modifications
     */
    @Override
    public void outputMessage(String message){
        this.logInOutputBoundary.outputMessage(message+ "\n");
    }

}













