package UseCase;

import DataBase.DataAccess;
import Entities.CommentList;
import Entities.CommentTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class InteractorTest {
    Interactor testinteractor;
    OutputBoundary testOutputBoundary;
    CommentList testCommentList;
    Gateway testGateway;


    @Before
    public void setUp() throws Exception {
        testinteractor = new Interactor(testOutputBoundary,testGateway);
        testCommentList = new CommentList();

    }

    @After
    public void tearDown() throws Exception {
        testinteractor = null;
        testCommentList = null;
    }

    /**
     * Check Empty input
     */
    @Test
    public void testCheckInputEmpty() {
        assertEquals(testinteractor.checkInput(" "), true);
        fail("No InvalidInput Thrown!!!");
    }

    /**
     * Check 1500+ input
     */
    @Test
    public void testCheckInput1500up() {
        try{
            String s ="";
            String s2 = "1";
            for(int i = 0; i< 1505; i++ ){
                s = s + s2;
            }
            assertEquals(testinteractor.checkInput(s), true);
            fail("No InvalidInput Thrown!!!");
        } catch (InvalidInputException e) {

        }
    }


    /**
     * Check ture input
     */
    @Test
    public void testCheckInputGood() {
        String s ="";
        String s2 = "1";
        for(int i = 0; i< 5; i++ ){
            s = s + s2;
        }
        assertEquals(testinteractor.checkInput(s), true);
    }

    /**
     * Check showComment
     */
    @Test
    public void showComments()  {
        try {
            testCommentList = testGateway.importComment();
            assertEquals(testCommentList.getClass(),new CommentList().getClass());
        } catch (IOException e) {
            fail("You messed up your code, shouldn't be a Error");
        } catch (ClassNotFoundException e) {
            fail("You messed up your code, shouldn't be a Error");
        }

    }

    @Test
    public void addComment() {

    }

    @Test
    public void editComment() {
    }

    @Test
    public void outputMessage() {
    }
}