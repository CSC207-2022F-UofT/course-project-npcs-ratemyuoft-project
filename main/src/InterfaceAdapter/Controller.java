package InterfaceAdapter;
import UseCase.*;


import java.io.IOException;


public class Controller {
    private final InputBoundary inputBoundary;

    public Controller(InputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    public void showUsers(){
        inputBoundary.showUsers();
    }

    public void userRegister(String username, String password, String major, int startYearOfStudy){
        try{
            inputBoundary.userRegister(username,password,major,startYearOfStudy);
            inputBoundary.outputMessage("Registration Successful!");
        }catch(InvalidInputException e){
            inputBoundary.outputMessage("Invalid input");
        }catch (IOException e) {
            inputBoundary.outputMessage("Invalid input");
        }
    }

    public void userLogin(String username, String password){
        try{
            inputBoundary.userLogin(username,password);
            inputBoundary.outputMessage("Login Successful!");
        }catch(InvalidInputException e){
            inputBoundary.outputMessage("Invalid input");
        }
    }

    public void userLogOut(){

        inputBoundary.userLogOut();
        inputBoundary.outputMessage("Logout Successful!");


    }



}
