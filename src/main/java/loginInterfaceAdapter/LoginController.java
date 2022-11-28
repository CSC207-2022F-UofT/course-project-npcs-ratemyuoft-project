package loginInterfaceAdapter;
import loginUseCase.LoginInputBoundary;
import loginUseCase.InvalidInputException;
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
public class LoginController {
    private final LoginInputBoundary loginInputBoundary;

    public LoginController(LoginInputBoundary loginInputBoundary){
        this.loginInputBoundary = loginInputBoundary;
    }

    public void showUsers() {
        try {
            loginInputBoundary.showUsers();
            loginInputBoundary.outputMessage("All Users are displayed"+ "\n");
        }catch (IOException | ClassNotFoundException e){
            loginInputBoundary.outputMessage("Invalid input"+ "\n");

        }
    }

    public void userRegister(String username, String password, String major, int startYearOfStudy) throws ClassNotFoundException, IOException, InvalidInputException {
        try{
            loginInputBoundary.userRegister(username,password,major,startYearOfStudy);
            loginInputBoundary.outputMessage("Registration Successful!"+ "\n");

        }catch(InvalidInputException e){
            loginInputBoundary.outputMessage("Invalid input"+ "\n");
            throw new InvalidInputException();
        } catch (IOException e) {
            loginInputBoundary.outputMessage("Invalid input"+ "\n");
            throw new IOException();
        } catch (ClassNotFoundException e) {
            loginInputBoundary.outputMessage("Invalid input"+ "\n");
            throw new ClassNotFoundException();
        }
    }

    public void userLogin(String username, String password) throws ClassNotFoundException, IOException, InvalidInputException {
        try{
            loginInputBoundary.userLogin(username,password);
            loginInputBoundary.outputMessage("Login Successful!"+ "\n");
        }catch(InvalidInputException e){
            loginInputBoundary.outputMessage("Invalid input"+ "\n");
            throw new InvalidInputException();
        } catch (IOException e) {
            loginInputBoundary.outputMessage("Invalid input"+ "\n");
            throw new IOException();
        } catch (ClassNotFoundException e) {
            loginInputBoundary.outputMessage("Invalid input"+ "\n");
            throw new ClassNotFoundException();
        }
    }

    public void userLogOut() throws IOException  {
        loginInputBoundary.userLogOut();
        loginInputBoundary.outputMessage("Log out successful!"+ "\n");


    }



}
