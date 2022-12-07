package loginUseCase;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for outputMessage and showUsers were not made as they have the only task is to send the information
 * forward to outputBoundary which sends it to Presenter.
 */
class LogInInteractorTest {

    LogInInteractor logInInteractor;

    {
        try {
            logInInteractor = new LogInInteractor();
        } catch (ClassNotFoundException e) {
            System.out.println("interactor is not constructed");
        }
    }


    @Test
    void checkIfUserExistsTest() {

        try {
            logInInteractor.userRegister("mykola", "mykola123", "math",2020);
            logInInteractor.userLogOut();
            assertTrue(logInInteractor.checkIfUserExists("mykola"),"checkIfUserExists didn't work properly");
            assertFalse(logInInteractor.checkIfUserExists("mykola1"),"checkIfUserExists didn't work properly");
        } catch (IOException | InvalidInputException e) {
            System.out.println("wrong input");
        }


    }

    @Test
    void checkUserStatusTest() {
        try {
            logInInteractor.userRegister("username100","tired","ofTesting", 2002);
            assertTrue(logInInteractor.checkUserStatus("username100"), "checkUserStatus didn't work properly");
            logInInteractor.userLogOut();
            assertFalse(logInInteractor.checkUserStatus("username100"), "checkUserStatus didn't work properly");
        } catch (IOException | InvalidInputException e) {
            System.out.println("wrong input");
        }


    }


    @Test
    void checkPasswordTest() {
        try {
            logInInteractor.userRegister("username10","tired","ofTesting", 2002);
            logInInteractor.userLogOut();
            assertTrue(logInInteractor.checkPassword("username10","tired"),
                    "checkPassword didn't work properly");
            assertFalse(logInInteractor.checkPassword("username10","notTired"),
                    "checkPassword didn't work properly");
        } catch (IOException | InvalidInputException e) {
            System.out.println("wrong input");
        }
    }
@Test
    void userLoginTest() {
        try {
            logInInteractor.userRegister("username30","tired","ofTesting", 2002);
            logInInteractor.userLogOut();
            assertFalse(logInInteractor.checkUserStatus("username30"));
            logInInteractor.userLogin("username","tired");
            assertTrue(logInInteractor.checkUserStatus("username30"));
        } catch (IOException | ClassNotFoundException | InvalidInputException e) {
            System.out.println("smth wrong with userLogin");
        }

    }

    @Test
    void userRegisterTest() {
        String username = "sadasdasdasdds";
        String password = "ndhashdhaskdhl";
        String major ="sdkjahskjdbkjsad";
        int year = 2000;
        assertFalse(logInInteractor.checkIfUserExists(username));
        try {
            logInInteractor.userRegister(username,password,major,year);
            logInInteractor.userLogOut();
        } catch (IOException | InvalidInputException e) {
            System.out.println("wrong input");
        }
        assertTrue(logInInteractor.checkIfUserExists(username));


    }

    @Test
    void userLogOutTest() {
        try {
            logInInteractor.userRegister("sdasdasd","ueioqwuyeuiyr","msdklmasoikvi",2000);
            assertTrue(logInInteractor.checkUserStatus("sdasdasd"));
            logInInteractor.userLogOut();
            assertFalse(logInInteractor.checkUserStatus("sdasdasd"));
        } catch (IOException | InvalidInputException e) {
            System.out.println("wrong input");
        }

    }
}