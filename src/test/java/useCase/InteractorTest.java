package useCase;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for outputMessage and showUsers were not made as they have the only task is to send the information
 * forward to outputBoundary which sends it to Presenter.
 */
class InteractorTest {

    Interactor interactor;

    {
        try {
            interactor = new Interactor();
        } catch (ClassNotFoundException e) {
            System.out.println("interactor is not constructed");
        }
    }


    @Test
    void checkIfUserExistsTest() {

        try {
            interactor.userRegister("mykola", "mykola123", "math",2020);
            interactor.userLogOut();
            assertTrue(interactor.checkIfUserExists("mykola"),"checkIfUserExists didn't work properly");
            assertFalse(interactor.checkIfUserExists("mykola1"),"checkIfUserExists didn't work properly");
        } catch (InvalidInputException | IOException e) {
            System.out.println("wrong input");
        }


    }

    @Test
    void checkUserStatusTest() {
        try {
            interactor.userRegister("username100","tired","ofTesting", 2002);
            assertTrue(interactor.checkUserStatus("username100"), "checkUserStatus didn't work properly");
            interactor.userLogOut();
            assertFalse(interactor.checkUserStatus("username100"), "checkUserStatus didn't work properly");
        } catch (InvalidInputException | IOException e) {
            System.out.println("wrong input");
        }


    }


    @Test
    void checkPasswordTest() {
        try {
            interactor.userRegister("username10","tired","ofTesting", 2002);
            interactor.userLogOut();
            assertTrue(interactor.checkPassword("username10","tired"),
                    "checkPassword didn't work properly");
            assertFalse(interactor.checkPassword("username10","notTired"),
                    "checkPassword didn't work properly");
        } catch (InvalidInputException | IOException e) {
            System.out.println("wrong input");
        }
    }
@Test
    void userLoginTest() {
        try {
            interactor.userRegister("username30","tired","ofTesting", 2002);
            interactor.userLogOut();
            assertFalse(interactor.checkUserStatus("username30"));
            interactor.userLogin("username","tired");
            assertTrue(interactor.checkUserStatus("username30"));
        } catch (InvalidInputException e) {
            System.out.println("wrong input");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("smth wrong with userLogin");
        }

    }

    @Test
    void userRegisterTest() {
        String username = "sadasdasdasdds";
        String password = "ndhashdhaskdhl";
        String major ="sdkjahskjdbkjsad";
        int year = 2000;
        assertFalse(interactor.checkIfUserExists(username));
        try {
            interactor.userRegister(username,password,major,year);
            interactor.userLogOut();
        } catch (InvalidInputException | IOException e) {
            System.out.println("wrong input");
        }
        assertTrue(interactor.checkIfUserExists(username));


    }

    @Test
    void userLogOutTest() {
        try {
            interactor.userRegister("sdasdasd","ueioqwuyeuiyr","msdklmasoikvi",2000);
            assertTrue(interactor.checkUserStatus("sdasdasd"));
            interactor.userLogOut();
            assertFalse(interactor.checkUserStatus("sdasdasd"));
        } catch (InvalidInputException | IOException e) {
            System.out.println("wrong input");
        }

    }
}