package UseCase;

import entity.User;
import entity.UserList;

import java.io.IOException;

public class Interactor {
    private final OutputBoundary outputBoundary;
    private User user;
    public static UserList users = new UserList();
    private Gateway gateway;


    public Interactor(OutputBoundary outputBoundary, User user) throws IOException, ClassNotFoundException{
        this.outputBoundary = outputBoundary;
        this.user = user;
        this.gateway = gateway;
        
        try{
            users = gateway.importUser();
        }catch (IOException e){
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

   // @Override
    public UserList showUsers(){
        return(users);
    }

   // @Override

    public void userRegister(String username, String password) throws InvalidInputException{
        if(checkInput(username) && !checkIfUserExists(username)){
            User user1 = new User(username,password);
            users.addUser(user1);
            try{
                gateway.saveUser(users);
            }catch(IOException e){
                this.outputBoundary.outputMessage("Registering new user failed");

            }
            this.outputBoundary.confirmUser(user1);
        }
    }
   // @Override
    public void userLogIn(String username, String password) throws InvalidInputException{
        if(checkInput(username) && checkIfUserExists(username)){
            try{
                for(User user: users){
                    if(user.getUserName().equals(username)){
                        user.setLogInStatus(true);
                    }
                }
                gateway.importUser();
            }catch(IOException e){
                this.outputBoundary.outputMessage("Log in failed");
            } catch (ClassNotFoundException e) {
                this.outputBoundary.outputMessage("Log in failed");
            }
        }
    }


    public boolean checkString(String s) throws UserNotInListException{
        int count = 0;
        for (char c: s.toCharArray()){
            if(c!= ' ' ){
                count++;
            }
        }
        if(count <= 20 && count > 0){
            return true;
        }
        else{
            throw new UserNotInListException();
        }
    }

   // @Override
    public void editUsername(int userId,String username) throws InvalidInputException, UserNotInListException {
        if(checkString(username)){
            for(User u : users){
                if(u.getUserId() == userId){
                    try{
                        u.setUserName(username);
                        gateway.importUser();
                        this.outputBoundary.outputMessage("Username is changed");
                    }catch (IOException e){
                        this.outputBoundary.outputMessage("edit and save username failed");
                    } catch (ClassNotFoundException e) {
                    }
                }
            }
        }
    }

    //@Override
    public void editPassword(int userId,String password) throws InvalidInputException, UserNotInListException {
        if(checkString(password)){
            for(User u : users){
                if(u.getUserId() == userId){
                    try{
                        u.setPassword(password);
                        gateway.importUser();
                        this.outputBoundary.outputMessage("Password is changed");
                    }catch (IOException e){
                        this.outputBoundary.outputMessage("edit and save password failed");
                    } catch (ClassNotFoundException e) {

                    }
                }
            }
        }
    }


    //@Override
    public void outputMessage(String message){
        this.outputBoundary.outputMessage(message);
    }
}
