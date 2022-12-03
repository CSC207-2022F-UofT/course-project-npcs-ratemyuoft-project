package UseCase;

import DataBase.DataAccess;
import DataStructures.InPutData;
import DataStructures.OutPutData;
import Entities.Comment;
import Entities.CommentList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.Assert.*;

public class InteractorTest {
    InputBoundary testInteractor;
    OutputBoundary testOutputBoundary;
    Gateway testGateway;
    CommentList testCommentList;
    CommentList temp;
    Gateway testGateway2;
    Interactor testInteractor2;


    /**
     * This method is real before every test.
     * It will create eight a new file for testing.
     * It will first add commentList  for reading.
     * It will create a new outputBoundary for testing which overrides all its method.
     * This will simplify the test And minimize messing with other methods in other class.
     * There is a secular testing file for improper importation.
     */
    @Before
    public void setUp() {

        testGateway = new DataAccess("commentFileTest.sav");
        try {
            testGateway.saveComment(null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        temp = new CommentList();
        Comment comment = new Comment("first test comment");
        Comment comment2 = new Comment("second test comment");
        temp.addComment(comment);
        temp.addComment(comment2);


        try {
            testGateway.saveComment(temp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        testOutputBoundary = new OutputBoundary() {
            /**
             * @param outPutData
             * It will assert ture if output Boundary is properly called,
             * And the show comment method that was called in the interactor carries the same object as this
             *
             */
            @Override
            public void showComments(OutPutData outPutData) {
                try {
                    testCommentList = testGateway.importComment();
                } catch (IOException  | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                assertEquals("first test comment",testCommentList.getComment(0));


            }

            /**
             * @param s
             * Nothing much here simply check if the interactor can call the output boundary.
             */
            @Override
            public void outputMessage(String s) {
                assertEquals("Importation failed", s);

            }

        };
        try {
            testInteractor = new Interactor(testOutputBoundary,testGateway);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        testGateway2 = new DataAccess("commentFileTest2.sav");
        try {
            testInteractor2 = new Interactor(testOutputBoundary,testGateway2);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * @throws Exception
     * Turn off all the object I create it until null
     * and every time a test run it clears all the data that was saved.
     */
    @After
    public void tearDown() throws Exception {

        testOutputBoundary = null;
        testGateway = null;
        testInteractor = null;
        testCommentList = null;
        testGateway2 = null;
        testInteractor2 = null;
        PrintWriter pw = new PrintWriter("commentFileTest.sav");
        pw.close();
        PrintWriter pw2 = new PrintWriter("commentFileTest2.sav");
        pw2.close();
    }


    /**
     * @throws IOException import fail
     * @throws ClassNotFoundException class not found
     * Simply checks if the method at output boundary can be called.
     */
    @Test
    public  void testShowComments() throws IOException, ClassNotFoundException {
        testInteractor.showComments();
    }


    /**
     * @throws InvalidInputException invalid input
     * @throws IOException import failed
     * @throws ClassNotFoundException class not found
     * Test if the comments can to be added to the testing database
     */
    @Test
    public void addComment() throws InvalidInputException, IOException, ClassNotFoundException {
        InPutData inPutData = new InPutData("third test comment");
        testInteractor.addComment(inPutData);
        CommentList tempList = testGateway.importComment();
        assertEquals("third test comment",tempList.getComment(0));

    }

    /**
     * @throws InvalidInputException invalid input
     * @throws IOException import fail
     * @throws ClassNotFoundException class not found
     *
     * Shows error if you enter invalid input.
     */
    @Test(expected = InvalidInputException.class)
    public void invalidAddComment() throws InvalidInputException, IOException, ClassNotFoundException {
        InPutData inPutData = new InPutData(" ");
        testInteractor.addComment(inPutData);
        CommentList tempList =testGateway.importComment();
        tempList.getComment(4);

    }

    /**
     * @throws InvalidInputException invalid input
     * @throws IOException import fail
     * @throws ClassNotFoundException class not found
     * Assert error for improper importation.
     */
    @Test
    public void iOExceptionAddComment() throws InvalidInputException, IOException, ClassNotFoundException {
        Gateway testGateway2 = new DataAccess("commentFileTest2.sav");
        testInteractor2 = new Interactor(testOutputBoundary,testGateway2);
        InPutData inPutData2 = new InPutData("bye");
        testInteractor2.addComment(inPutData2);
        CommentList tempList2 =testGateway2.importComment();
        tempList2.getComment(0);

    }


    @Test
    public void editComment() {
        try {
            testInteractor.editComment(0,"hi");
            assertTrue(true);
        } catch (InvalidInputException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Check if it will call the output boundary method.
     */
    @Test
    public void outputMessage(){
        testInteractor.outputMessage("Importation failed");
    }


}