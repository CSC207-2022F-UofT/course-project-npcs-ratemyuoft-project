package InterfaceAdapter;
import UseCase.*;
import entity.User;
import entity.UserList;

import java.io.IOException;


public class Controller {
    private final InputBoundary inputBoundary;

    public Controller(InputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    public UserList showUsers(){
        return inputBoundary.showUsers();
    }

    public void userRegister(String username, String password){
        try{
            inputBoundary.userRegister(username,password);
        }catch(InvalidInputException e){
            inputBoundary.outputMessage("Invalid input");
        }catch (UserAlreadyExistsException e) {
            inputBoundary.outputMessage("User already exists");
        } catch (IOException e) {
            inputBoundary.outputMessage("Invalid input");
        }
    }

    public void userLogin(String username, String password){
        try{
            inputBoundary.userLogin(username,password);
        }catch(InvalidInputException e){
            inputBoundary.outputMessage("Invalid input");
        }
    }

    public void editUsername(int userId,String username){
        try{
            inputBoundary.editUsername(userId,username);
        } catch (InvalidInputException e) {
            inputBoundary.outputMessage("Invalid input");
        } catch (NoUserWithSuchIDException e) {
            inputBoundary.outputMessage("There is no user with such id");
        }
    }
    public void editPassword(int userId,String password){
        try{
            inputBoundary.editPassword(userId,password);
        } catch (InvalidInputException e) {
            inputBoundary.outputMessage("Invalid input");
        } catch (NoUserWithSuchIDException e) {
            inputBoundary.outputMessage("There is no user with such id");
        }
    }

}
