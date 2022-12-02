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
    InputBoundary testinteractor;
    OutputBoundary testOutputBoundary;
    Gateway testGateway;
    CommentList testCommentList;
    CommentList temp;
    Gateway testGateway2;
    Interactor testinteractor2;


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
            @Override
            public void showComments(OutPutData outPutData) {
                try {
                    testCommentList = testGateway.importComment();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                assertEquals("first test comment",testCommentList.getComment(0));


            }

            @Override
            public void outputMessage(String s) {
                assertEquals("Importation failed", s);

            }

        };
        try {
            testinteractor = new Interactor(testOutputBoundary,testGateway);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        testGateway2 = new DataAccess("commentFileTest2.sav");
        try {
            testinteractor2= new Interactor(testOutputBoundary,testGateway2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @After
    public void tearDown() throws Exception {

        testOutputBoundary = null;
        testGateway = null;
        testinteractor = null;
        testCommentList = null;
        testGateway2 = null;
        testinteractor2 = null;
        PrintWriter pw = new PrintWriter("commentFileTest.sav");
        pw.close();
        PrintWriter pw2 = new PrintWriter("commentFileTest2.sav");
        pw2.close();
    }


    @Test
    public  void testShowComments() throws IOException, ClassNotFoundException {
        testinteractor.showComments();
    }


    @Test
    public void addComment() throws InvalidInputException, IOException, ClassNotFoundException {
        InPutData inPutData = new InPutData("third test comment");
        testinteractor.addComment(inPutData);
        CommentList tempList = testGateway.importComment();
        assertEquals("third test comment",tempList.getComment(0));

    }

    @Test(expected = InvalidInputException.class)
    public void invalidAddComment() throws InvalidInputException, IOException, ClassNotFoundException {
        InPutData inPutData = new InPutData(" ");
        testinteractor.addComment(inPutData);
        CommentList tempList =testGateway.importComment();
        tempList.getComment(4);

    }

    @Test
    public void iOExceptionAddComment() throws InvalidInputException, IOException, ClassNotFoundException {
        Gateway testGateway2 = new DataAccess("commentFileTest2.sav");
        Interactor testinteractor2 = new Interactor(testOutputBoundary,testGateway2);
        InPutData inPutData2 = new InPutData("bye");
        testinteractor2.addComment(inPutData2);
        CommentList tempList2 =testGateway2.importComment();
        tempList2.getComment(0);

    }


    @Test
    public void editComment() {
        try {
            testinteractor.editComment(0,"hi");
            assertEquals(true,true);
        } catch (InvalidInputException e) {
            throw new RuntimeException(e);
        } catch (CommentNotInListException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void outputMessage(){
        testinteractor.outputMessage("Importation failed");
    }


}