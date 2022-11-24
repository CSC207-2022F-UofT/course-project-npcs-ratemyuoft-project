package UseCase;

import entity.User;
import entity.UserList;

import java.io.IOException;

public class Interactor implements InputBoundary {
    private final OutputBoundary outputBoundary;
    public static UserList users = new UserList();
    private final Gateway gateway;


    public Interactor(OutputBoundary outputBoundary, Gateway gateway) throws ClassNotFoundException{
        this.outputBoundary = outputBoundary;
        this.gateway =gateway;
        
        try{
            users = gateway.importUser();
        }catch (IOException e ){
            users = new UserList();
            this.outputBoundary.outputMessage("Importation failed");
        }
    }


    public boolean checkInput(String username) throws InvalidInputException{
        int count = 0;
        for(char c: username.toCharArray()){
            if(c!= ' '){
                count++;
            }
        }
        if(count <= 20 && count > 0){
            return true;
        }else{
            throw new InvalidInputException();
        }

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
    public void showUsers(){
        for(User u: users){
            System.out.print(" " + u.getUserName());
            System.out.print(" " + u.getMajor());
            System.out.print(" " + u.getStartYearOfStudy());
            System.out.print(" " + u.getLogInStatus() + "\n");
        }

    }
    @Override

    public void userRegister(String username, String password, String major, int startYearOfStudy) throws
            InvalidInputException, IOException {
        if(checkInput(username) && checkInput(major)&& startYearOfStudy <=2022 && !checkIfUserExists(username) &&
                checkInput(password)){
            User user1 = new User(username,password,major,startYearOfStudy);
            users.addUser(user1);
            try{
                gateway.saveUser(users);
            }catch(IOException e){
                this.outputBoundary.outputMessage("Registering new user failed");
            throw new IOException();
            }
            this.outputBoundary.confirmUser(user1);

        }else{
            throw new InvalidInputException();
        }
    }


     @Override
    public void userLogin(String username, String password) throws InvalidInputException{
        if(checkInput(username)&& checkInput(password) && checkIfUserExists(username)&& !checkUserStatus(username) && checkPassword(username,password)){
            try{
                for(User user: users){
                    if(user.getUserName().equals(username)){
                        user.setLogInStatus(true);
                    }
                }
                gateway.saveUser(users);
            }catch(IOException e){
                this.outputBoundary.outputMessage("Log in failed");
            }
        }else{
            throw new InvalidInputException();
        }
    }

    @Override
    public void userLogOut(String username) throws InvalidInputException {
        if( checkInput(username) && checkIfUserExists(username) && checkUserStatus(username)){
            try{
                for(User user: users){
                    if(user.getUserName().equals(username)){
                        user.setLogInStatus(false);
                    }
                }
                gateway.saveUser(users);
            }catch(IOException e){
                this.outputBoundary.outputMessage("Log out failed");
            }
        }else{
            throw new InvalidInputException();
        }

    }






    @Override
    public void outputMessage(String message){
        this.outputBoundary.outputMessage(message);
    }

}
