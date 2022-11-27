package useCase;

import entities.User;
import entities.UserList;

import java.io.IOException;

public class Interactor implements InputBoundary {
    private final OutputBoundary outputBoundary;
    public static UserList users;
    private final DataAccess dataAccess;


    public Interactor(OutputBoundary outputBoundary, DataAccess dataAccess) throws ClassNotFoundException{
        this.outputBoundary = outputBoundary;
        this.dataAccess = dataAccess;
        try{
            users = dataAccess.importUsers();
        }catch (IOException e){
            users = new UserList();
            this.outputBoundary.outputMessage("Importation Failed"+ "\n");
        }

    }


    private boolean checkInput(String s) {
        int count = s.length();
        return count <= 40 && count > 0;
    }

    public boolean checkIfUserExists(String username){
        for(User user: users){
            if(user.getUserName().equals(username)){
                return true;
            }
        }
        return false;
    }

    public boolean checkUserStatus(String username){
        for(User user: users){
            if(user.getUserName().equals(username)){
                return user.getLogInStatus();
            }
        }
        return true;
    }

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

    @Override
    public void showUsers() throws IOException, ClassNotFoundException {
        users = dataAccess.importUsers();
        this.outputBoundary.showUsers(users);

    }


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

    @Override

    public void userRegister(String username, String password, String major, int startYearOfStudy) throws
            InvalidInputException {
        if (checkInput(username) && checkInput(major) && startYearOfStudy <= 2022 && checkInput(password) &&
                !checkIfUserExists(username)) {
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






    @Override
    public void outputMessage(String message){
        this.outputBoundary.outputMessage(message);
    }

}













