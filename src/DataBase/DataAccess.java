package DataBase;

import Entities.Comment;
import Entities.CommentList;
import UseCase.Gateway;

import java.io.*;

public class DataAccess implements Gateway ,Serializable{

    private static final String fileName = "commentsFile.sav";
    @Override
    public CommentList importComment() throws IOException, ClassNotFoundException {

        FileInputStream fileIn = new FileInputStream(fileName);
        ObjectInputStream inputStream = new ObjectInputStream(fileIn);
        CommentList newComments = (CommentList) inputStream.readObject();
        return newComments;

    }

    @Override
    public void saveComment(CommentList commentList) throws IOException {

        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
        outputStream.writeObject(commentList);
        fileOut.close();



    }
}
