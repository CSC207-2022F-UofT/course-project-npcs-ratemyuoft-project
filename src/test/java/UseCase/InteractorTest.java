package UseCase;



import DataBase.DataAccess;
import Entities.Comment;
import Entities.CommentList;
import Entities.CommentTest;
import InterfaceAdapter.Presenter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class InteractorTest {
    InputBoundary testinteractor;
    OutputBoundary testOutputBoundary;
    CommentList testCommentList;
    Gateway testGateway;


    @Before
    public void setUp() throws Exception {

        testCommentList = new CommentList();
        testOutputBoundary = new Presenter();
        testGateway = new DataAccess("commentsFileTest.sav");
        testinteractor = new Interactor(testOutputBoundary,testGateway);


    }

    @After
    public void tearDown() throws Exception {
        testCommentList = null;
        testOutputBoundary = null;
        testGateway = null;
        testinteractor = null;
    }

    /**
     * Check showComment assert true if it can return to output Boundary
     */
    @Test
    public void showComments()  {
        try {
            testCommentList = testGateway.importComment();

            assertEquals(testCommentList.getClass(),new CommentList().getClass());
        } catch (IOException e) {
            fail("You messed up your code, shouldn't be a Error (IOException e)");
        } catch (ClassNotFoundException e) {
            fail("You messed up your code, shouldn't be a Error(ClassNotFoundException e)");
        }

    }

    @Test
    public void addComment() throws InvalidInputException, IOException, ClassNotFoundException {


        CommentList cl = testGateway.importComment();
        assertEquals(cl.getComment(0)," " );


    }

    @Test
    public void editComment() {
    }


    @Test
    public void testOutputMessage() {
    }
}