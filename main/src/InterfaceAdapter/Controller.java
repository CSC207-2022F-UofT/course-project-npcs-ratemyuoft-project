package InterfaceAdapter;
import UseCase.*;
import CLI.*;


import java.io.IOException;


public class Controller {
    private final InputBoundary inputBoundary;

    public Controller(InputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    public void showUsers() throws IOException, ClassNotFoundException {
        try {
            inputBoundary.showUsers();
            inputBoundary.outputMessage("All Users are displayed");
        }catch (IOException e){
            inputBoundary.outputMessage("Invalid input");

        }catch (ClassNotFoundException e ){
            inputBoundary.outputMessage("Invalid input");
        }
    }

    public void userRegister(String username, String password, String major, int startYearOfStudy) throws ClassNotFoundException, IOException, InvalidInputException {
        try{
            inputBoundary.userRegister(username,password,major,startYearOfStudy);
            inputBoundary.outputMessage("Registration Successful!");

        }catch(InvalidInputException e){
            inputBoundary.outputMessage("Invalid input");
            throw new InvalidInputException();
        } catch (IOException e) {
            inputBoundary.outputMessage("Invalid input");
            throw new IOException();
        } catch (ClassNotFoundException e) {
            inputBoundary.outputMessage("Invalid input");
            throw new ClassNotFoundException();
        }
    }

    public void userLogin(String username, String password) throws ClassNotFoundException, IOException, InvalidInputException {
        try{
            inputBoundary.userLogin(username,password);
            inputBoundary.outputMessage("Login Successful!");
        }catch(InvalidInputException e){
            inputBoundary.outputMessage("Invalid input");
            throw new InvalidInputException();
        } catch (IOException e) {
            inputBoundary.outputMessage("Invalid input");
            throw new IOException();
        } catch (ClassNotFoundException e) {
            inputBoundary.outputMessage("Invalid input");
            throw new ClassNotFoundException();
        }
    }

    public void userLogOut() throws IOException, InvalidInputException {
        try{
            inputBoundary.userLogOut();
        }catch (IOException e) {
            inputBoundary.outputMessage("Log out failed");
            throw new IOException();
        } catch (InvalidInputException e) {
            throw new InvalidInputException();
        }


    }



}
