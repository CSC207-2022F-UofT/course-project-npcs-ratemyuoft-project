package InterfaceAdapter;

import DataStructures.InPutData;
import UseCase.InputBoundary;
import UseCase.InvalidInputException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;

import static org.junit.Assert.*;


public class ControllerTest {
    Controller testController;
    InputBoundary testInputBoundary;

    /**
     * Override all interactor method, simplify testing from controller to interactor.
     * Without going to entities or database. Only tester controller's method
     */
    @Before
    public void setUp() {
        testInputBoundary =new InputBoundary() {
            /**
             * There is not much to test it will assert true when this method is called
             */
            @Override
            public void showComments()  {
                assertTrue(true);

            }

            /**
             * @param inPutData
             * It will assert true when this method was called.
             */
            @Override
            public void addComment(InPutData inPutData)  {
                assertEquals("testing",inPutData.getComments());
            }

            @Override
            public void editComment(int commentNum, String s) {

            }

            /**
             * @param s
             * It will assert true when the string and testing are the same
             */
            @Override
            public void outputMessage(String s) {
                assertEquals("testing",s);
            }
        };

        testController = new Controller(testInputBoundary);

    }

    /**
     * Change everything into Null
     */
    @After
    public void tearDown()  {
        testController = null;
        testInputBoundary = null;
    }

    /**
     * If the controller called the input boundary then it will assert ture.
     */
    @Test
    public void testOutPutMessage() {
        testController.outPutMessage("testing");
    }

    /**
     * If this calls the show comment method in interactor it will assert true.
     * In the overwritten interactor method.
     */
    @Test
    public void testShowComments() {

        try {
            testController.showComments();
        } catch (IOException e) {
            fail("IOException error at testOutPutMessage!");
        } catch (ClassNotFoundException e) {
            fail("ClassNotFoundException error at testOutPutMessage!");
        }
    }

    /**
     * If this calls the addComment method in interactor it will assert true.
     *  In the overwritten interactor method.
     */
    @Test
    public void testAddComment() {

        try {
            testController.addComment("testing");
        } catch (IOException e) {
            fail("IOException error at testAddComment!");
        } catch (InvalidInputException e) {
            fail("InvalidInputException error at testAddComment!");
        }
    }

    @Test
    public void testEditComment() {
    }
}