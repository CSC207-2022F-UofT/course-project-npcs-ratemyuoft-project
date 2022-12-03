package loginInterfaceAdapter;
import loginUseCase.*;


import java.io.IOException;


/**
 * Controller class is used for communicating with inputBoundary interface . It's a starting point for information
 * that is passed from UI to back end through the interface. That is why it is packaged as interfaceAdapter
 * <p>
 *
 *
 * I don't think it is obligatory to explain each method here, because the only function of controller is to try
 * to pass a method call to input boundary, and in case Exception is thrown- to catch it and explain what mistake might
 * have happened.
 */
public class Controller {
    private final InputBoundary inputBoundary;

    public Controller(InputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    public void showUsers() {
        try {
            inputBoundary.showUsers();
            inputBoundary.outputMessage("All Users are displayed"+ "\n");
        }catch (IOException | ClassNotFoundException e){
            inputBoundary.outputMessage("Invalid input"+ "\n");

        }
    }

    public void userRegister(String username, String password, String major, int startYearOfStudy) throws ClassNotFoundException, IOException, InvalidInputException {
        try{
            inputBoundary.userRegister(username,password,major,startYearOfStudy);
            inputBoundary.outputMessage("Registration Successful!"+ "\n");

        }catch(InvalidInputException e){
            inputBoundary.outputMessage("Invalid input"+ "\n");
            throw new InvalidInputException();
        } catch (IOException e) {
            inputBoundary.outputMessage("Invalid input"+ "\n");
            throw new IOException();
        } catch (ClassNotFoundException e) {
            inputBoundary.outputMessage("Invalid input"+ "\n");
            throw new ClassNotFoundException();
        }
    }

    public void userLogin(String username, String password) throws ClassNotFoundException, IOException, InvalidInputException {
        try{
            inputBoundary.userLogin(username,password);
            inputBoundary.outputMessage("Login Successful!"+ "\n");
        }catch(InvalidInputException e){
            inputBoundary.outputMessage("Invalid input"+ "\n");
            throw new InvalidInputException();
        } catch (IOException e) {
            inputBoundary.outputMessage("Invalid input"+ "\n");
            throw new IOException();
        } catch (ClassNotFoundException e) {
            inputBoundary.outputMessage("Invalid input"+ "\n");
            throw new ClassNotFoundException();
        }
    }

    public void userLogOut() throws IOException  {
        inputBoundary.userLogOut();
        inputBoundary.outputMessage("Log out successful!"+ "\n");


    }



}
